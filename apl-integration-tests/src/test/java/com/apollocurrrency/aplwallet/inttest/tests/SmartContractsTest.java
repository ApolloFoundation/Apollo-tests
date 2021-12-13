package com.apollocurrrency.aplwallet.inttest.tests;

import com.apollocurrency.aplwallet.api.dto.TransactionDTO;
import com.apollocurrrency.aplwallet.inttest.helper.SCSourceFactory;
import com.apollocurrrency.aplwallet.inttest.helper.TestConfiguration;
import com.apollocurrrency.aplwallet.inttest.model.TestBaseNew;
import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SmartContract;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.*;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.*;
import com.apollocurrrency.aplwallet.inttest.model.sc.response.TrxResponse;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
class SmartContractsTest extends TestBaseNew {


    @DisplayName("Publish Suspicious smart-contract")
    @Test
    void publishSuspiciousContract(){

        String source = "class MyAPL20PersonalLockable extends APL20PersonalLockable {\n" +
                "  constructor(){\n" +
                "      super(WrongTokenName,'WRG','1000','50','1','0','0x67c5363f4019c423');\n" +
                "  }\n" +
                " }";

        SmartContract smartContract = SmartContract.builder()
                .name("MyAPL20PersonalLockable")
                .sender(TestConfiguration.getTestConfiguration().getStandartWallet().getUser())
                .value("0")
                .fuelPrice("10000")
                .fuelLimit("1000000000")
                .source(source)
                .secretPhrase(TestConfiguration.getTestConfiguration().getStandartWallet().getPass())
                .build();

        //publish
        TrxResponse trxResponse =  createSC(smartContract);
        var trxId = broadcastTransaction(trxResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        TransactionDTO sc = getTransaction(trxId);
        assertNotNull(sc);


    }

    @DisplayName("Create SC")
    @Description("Create SC")
    @ParameterizedTest(name = "{displayName} rate: {0} SC Type: {1}")
    @MethodSource("scTestParameters")
    void createSc(String rateStr,SCType scType){
        //sender = APL-AKU5-JP6B-Y42V-H5X8U  0xfd1ba38548944743
        //vault  = APL-MK35-9X23-YQ5E-8QBKH  0x67c5363f4019c423
        long init = 50;
        long cap = 10000;
        var rate = Double.valueOf(Double.parseDouble(rateStr)*100000000L).longValue();

        String source = SCSourceFactory.createSCSCSource(scType, "INT_TEST-" + rateStr + " " + scType.getBaseContract(), "INT",toAtm(cap),toAtm(init),String.valueOf(rate),"0x67c5363f4019c423");

        switch (scType){
            case APL20_PERSONAL_LOCKABLE:
                source = SCSourceFactory.createSCSCSource(scType,
                        "INT_TEST-"+rateStr + " " + scType.getBaseContract(), "INT",toAtm(cap),toAtm(init),String.valueOf(rate),"1","0x67c5363f4019c423");
                break;
            case APL20_LOCK:
                source = SCSourceFactory.createSCSCSource(scType,
                        "INT_TEST-" + rateStr + " " + scType.getBaseContract(), "INT",toAtm(cap),toAtm(init),String.valueOf(rate),String.valueOf(Instant.now().plus(3, ChronoUnit.SECONDS).toEpochMilli()),"0x67c5363f4019c423");
                break;
        }

        SmartContract smartContract = SmartContract.builder()
                .name(scType.getContractName())
                .sender(TestConfiguration.getTestConfiguration().getStandartWallet().getUser())
                .value("0")
                .fuelPrice("10000")
                .fuelLimit("50000000")
                .source(source)
                .secretPhrase(TestConfiguration.getTestConfiguration().getStandartWallet().getPass())
                .build();

        //PUBLISH
        TrxResponse trxResponse =  createSC(smartContract);
        var trxId = broadcastTransaction(trxResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);
        TransactionDTO sc = getTransaction(trxId);
        String scHex = convertAccountIdToHex(sc.getRecipientRS());

        //BUY
        long buyAmountAPL = 10;
        long allowanceAmount = 10;

        SCBuyRequest scBuyRequest = new SCBuyRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    convertToAtom(buyAmountAPL),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse buyResponse = scBuyTokens(scBuyRequest);
        trxId = broadcastTransaction(buyResponse.getTx()).getTransaction();

        verifyTransactionInBlock(trxId);

        long balanceLockOfATM = buyAmountAPL * rate;
        long balanceOf = balanceLockOfATM + init * 100000000L;

        //UNLOCK
        if (scType == SCType.APL20_PERSONAL_LOCKABLE || scType == SCType.APL20_LOCK) {

            verifyLockOf(""+balanceLockOfATM, sc.getRecipientRS(),"0xfd1ba38548944743");

            SCUnlockRequest scUnlockRequest = new SCUnlockRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

            TrxResponse unlockResponse = scUnlockTokens(scUnlockRequest);
            trxId = broadcastTransaction(unlockResponse.getTx()).getTransaction();

            verifyTransactionInBlock(trxId);
            verifyLockOf(toAtm(0), sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyBalanceOf(("" + balanceOf), sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyTotalSupply(("" + balanceOf), sc.getRecipientRS());
        }

        if (scType == SCType.APL20_PERSONAL_LOCKABLE || scType == SCType.APL20_LOCK || scType == SCType.APL20_FREEZE) {
            //FREEZE
            SCFreezeRequest scFreezeRequest = new SCFreezeRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                    String.valueOf(balanceOf));

            TrxResponse freezeResponse = scFreeze(scFreezeRequest);
            trxId = broadcastTransaction(freezeResponse.getTx()).getTransaction();
            verifyTransactionInBlock(trxId);

            verifyFreezeOf(String.valueOf(balanceOf), sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyBalanceOf("0", sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyTotalSupply(String.valueOf(balanceOf), sc.getRecipientRS());

            //UNFREEZE
            SCUnfreezeRequest scUnfreezeRequest = new SCUnfreezeRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                    String.valueOf(balanceOf));

            TrxResponse unfreezeResponse = scUnfreeze(scUnfreezeRequest);
            trxId = broadcastTransaction(unfreezeResponse.getTx()).getTransaction();
            verifyTransactionInBlock(trxId);

            verifyFreezeOf("0", sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyBalanceOf(String.valueOf(balanceOf), sc.getRecipientRS(), "0xfd1ba38548944743");
            verifyTotalSupply(String.valueOf(balanceOf), sc.getRecipientRS());
        }


        //ESCROW
        source = SCSourceFactory.createSCSCSource(SCType.ESCROW);
        smartContract = SmartContract.builder()
                .name("MyTokenEscrow")
                .sender(TestConfiguration.getTestConfiguration().getStandartWallet().getUser())
                .value("0")
                .fuelPrice("10000")
                .fuelLimit("1000000000")
                .source(source)
                .secretPhrase(TestConfiguration.getTestConfiguration().getStandartWallet().getPass())
                .build();

        trxResponse =  createSC(smartContract);
        trxId = broadcastTransaction(trxResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        TransactionDTO scEscrow = getTransaction(trxId);
        String scEscrowHex = convertAccountIdToHex(scEscrow.getRecipientRS());

        //APPROVE
        SCApproveRequest scApproveRequest = new SCApproveRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                convertToAtom(allowanceAmount),
                scEscrowHex,
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse approveResponse = scApprove(scApproveRequest);
        trxId = broadcastTransaction(approveResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyAllowance(convertToAtom(allowanceAmount),sc.getRecipientRS(),"0xfd1ba38548944743",scEscrowHex);

        //DEPOSIT
        SCDepositEscrow scDepositEscrowReq = new SCDepositEscrow(
                scEscrow.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                "0x67c5363f4019c423",
                scHex,
                convertToAtom(allowanceAmount));

        TrxResponse depositResponse = scDepositEscrow(scDepositEscrowReq);
        trxId = broadcastTransaction(depositResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyBalanceOf(convertToAtom(allowanceAmount),sc.getRecipientRS(),scEscrowHex);

        //WITHDRAW
        SCWithdrawEscrowRequest scWithdrawEscrowReq = new SCWithdrawEscrowRequest(
                scEscrow.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                "0x67c5363f4019c423",
                scHex);

        TrxResponse withdrawResponse = scWithdrawEscrow(scWithdrawEscrowReq);
        trxId = broadcastTransaction(withdrawResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);


        verifyBalanceOf(convertToAtom(allowanceAmount),sc.getRecipientRS(),"0x67c5363f4019c423");
        verifyTotalSupply((""+balanceOf),sc.getRecipientRS());



        SCTransferRequest scTransferRequest = new SCTransferRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                scHex,
                convertToAtom(buyAmountAPL));

        TrxResponse scTransferResponse = scTransfer(scTransferRequest);
        trxId = broadcastTransaction(scTransferResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyBalanceOf(convertToAtom(buyAmountAPL),sc.getRecipientRS(),scHex);
        verifyTotalSupply((""+balanceOf),sc.getRecipientRS());




        SCBalanceOfRequest balanceReq = new SCBalanceOfRequest(sc.getRecipientRS(),"0xfd1ba38548944743");
        var currentBalance =  balanceOf(balanceReq).getResults().get(0).getOutput().get(0);
        balanceOf = balanceOf - Long.parseLong(currentBalance);


        SCBurnRequest scBurnRequest = new SCBurnRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass(),
                currentBalance);

        TrxResponse scBurnRequestResponse = scBurn(scBurnRequest);
        trxId = broadcastTransaction(scBurnRequestResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyBalanceOf("0",sc.getRecipientRS(),"0xfd1ba38548944743");
        verifyTotalSupply((""+balanceOf),sc.getRecipientRS());

    }




    void verifyFreezeOf(String expectedResult, String scAddress,String account){
        SCFreezeOfRequest balanceReq = new SCFreezeOfRequest(scAddress,account);
        chekResponse(expectedResult, scFreezeOf(balanceReq));
    }

    void verifyBalanceOf(String expectedResult, String scAddress,String account){
        SCBalanceOfRequest balanceReq = new SCBalanceOfRequest(scAddress,account);
        chekResponse(expectedResult, balanceOf(balanceReq));
    }

    void verifyLockOf(String expectedResult, String scAddress,String account){
        SCLockOfRequest balanceReq = new SCLockOfRequest(scAddress,account);
        chekResponse(expectedResult, lockOf(balanceReq));
    }

    void verifyTotalSupply(String expectedResult, String scAddress){
        SCTotalSupplyRequest totalSupplyRequest = new SCTotalSupplyRequest(scAddress);
        chekResponse(expectedResult, scTotalSupply(totalSupplyRequest));
    }

    void verifyAllowance(String expectedResult, String scAddress, String owner, String spender){
        SCAllowanceOfRequest allowanceRequest = new SCAllowanceOfRequest(scAddress,owner,spender);
        chekResponse(expectedResult, scAllowanceOf(allowanceRequest));
    }

    private void chekResponse(String expectedResult, TrxResponse balanceResponse) {
        assertNotNull(expectedResult);
        assertNotNull(balanceResponse);
        var rc = balanceResponse.getResults().get(0).getOutput().get(0);
        log.info("Requested result={}", rc);
        assertEquals(expectedResult, (rc),"Result does not match");
    }

    private static Stream<String> scRate() {
         return Stream.of("1","0.1", "0.001", "0.00000001", "10");
    }

    private static Stream<Arguments> scTestParameters() {
        return generateArgs(Arrays.asList("1","0.1", "0.001", "0.00000001", "10"));
    }



    private static Stream<Arguments> generateArgs(List<String> typesOfCurr){
        List<SCType> wallets = Arrays.asList(
                SCType.APL20_PERSONAL_LOCKABLE,
                SCType.APL20_LOCK,
                SCType.APL20_FREEZE,
                SCType.APL20_BUY);
        List<Arguments> arguments = new ArrayList<>();
        typesOfCurr.forEach(type-> wallets.forEach(wallet ->arguments.add(Arguments.of(type, wallet))));
        return arguments.stream();
    }

}