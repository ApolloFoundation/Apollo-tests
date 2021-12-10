package com.apollocurrrency.aplwallet.inttest.tests;

import com.apollocurrency.aplwallet.api.dto.TransactionDTO;
import com.apollocurrrency.aplwallet.inttest.helper.SCSourceFactory;
import com.apollocurrrency.aplwallet.inttest.helper.TestConfiguration;
import com.apollocurrrency.aplwallet.inttest.model.TestBaseNew;
import com.apollocurrrency.aplwallet.inttest.model.Wallet;
import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.SmartContract;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCAllowanceOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCBalanceOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCLockOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCTotalSupplyRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.*;
import com.apollocurrrency.aplwallet.inttest.model.sc.response.TrxResponse;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.Assert.assertNull;

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
    @ParameterizedTest(name = "{displayName} rate: {0}")
    @MethodSource("scRate")
    void createSc(String rateStr){
        //sender = APL-AKU5-JP6B-Y42V-H5X8U  0xfd1ba38548944743
        //vault  = APL-MK35-9X23-YQ5E-8QBKH  0x67c5363f4019c423
        long init = 50;
        var rate = Double.valueOf(Double.parseDouble(rateStr)*100000000L).longValue();

        String source = SCSourceFactory.createSCSCSource(SCType.APL20_PERSONAL_LOCKABLE,
                "INT_TEST-"+rateStr, "INT",toAtm(1000),toAtm(init),""+rate,"1","0x67c5363f4019c423");

        SmartContract smartContract = SmartContract.builder()
                .name("MyAPL20PersonalLockable")
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

        long balanceLockOfATM = buyAmountAPL*rate;
        verifyLockOf(""+balanceLockOfATM, sc.getRecipientRS(),"0xfd1ba38548944743");

        SCUnlockRequest scUnlockRequest = new SCUnlockRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse unlockResponse = scUnlockTokens(scUnlockRequest);
        trxId = broadcastTransaction(unlockResponse.getTx()).getTransaction();

        verifyTransactionInBlock(trxId);

        verifyLockOf(toAtm(0),sc.getRecipientRS(),"0xfd1ba38548944743");

        long balanceOf = balanceLockOfATM + init*100000000L;
        verifyBalanceOf((""+balanceOf),sc.getRecipientRS(),"0xfd1ba38548944743");

        verifyTotalSupply((""+balanceOf),sc.getRecipientRS());

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
        assertNull(balanceResponse.getNewErrorCode());
        var rc = balanceResponse.getResults().get(0).getOutput().get(0);
        log.info("Requested result={}", rc);
        assertEquals(expectedResult, (rc),"Result does not match");
    }

    private static Stream<String> scRate() {
         return Stream.of("1","0.1", "0.001", "0.00000001", "10");
    }

    private static Stream<Arguments> generateArgs(List<String> typesOfCurr){
        List<Wallet> wallets = Arrays.asList(
                TestConfiguration.getTestConfiguration().getStandartWallet(),
                TestConfiguration.getTestConfiguration().getVaultWallet());
        List<Arguments> arguments = new ArrayList<>();
        typesOfCurr.forEach(type-> wallets.forEach(wallet ->arguments.add(Arguments.of(type, wallet))));
        return arguments.stream();
    }

}
