package com.apollocurrrency.aplwallet.inttest.tests;

import com.apollocurrency.aplwallet.api.dto.TransactionDTO;
import com.apollocurrrency.aplwallet.inttest.helper.SCSourceFactory;
import com.apollocurrrency.aplwallet.inttest.helper.TestConfiguration;
import com.apollocurrrency.aplwallet.inttest.model.TestBaseNew;
import com.apollocurrrency.aplwallet.inttest.model.Wallet;
import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCAllowanceOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCBalanceOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCLockOfRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.read.SCTotalSupplyRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.CreateSmartContract;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.SCApproveRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.SCBuyRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.write.SCUnlockRequest;
import com.apollocurrrency.aplwallet.inttest.model.sc.response.TrxResponse;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartContracts extends TestBaseNew {
    SCSourceFactory sourceFactory = new SCSourceFactory();

    @DisplayName("Create SC")
    @Description("Create SC")
    @ParameterizedTest(name = "{displayName} rate: {0}")
    @MethodSource("scRate")
    public void createSc(String rate){
        String name = "INTTEST";
        String symbol = "INT";
        String cap = String.valueOf(Integer.MAX_VALUE);
        String init = "50";
        //String rate = "1";
        String buyAmountAPL = "10";
        String allowanceAmount = buyAmountAPL;
        //APL-AKU5-JP6B-Y42V-H5X8U - 0xfd1ba38548944743
        //APL-MK35-9X23-YQ5E-8QBKH   0x67c5363f4019c423

        String source = sourceFactory.createSCSCSource(SCType.APL20_PERSONAL_LOCKABLE,name,symbol,cap,init,rate);

        CreateSmartContract smartContract = new CreateSmartContract(
                "MyAPL20PersonalLockable",
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                "0",
                "10000",
                "1000000000",
                source,
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());
        //publish
        TrxResponse trxResponse =  createSC(smartContract);
        var trxId = broadcastTransaction(trxResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        TransactionDTO sc = getTransaction(trxId);

        verifyBalanceOf(convertToAtom(init), sc.getRecipientRS(),"0xfd1ba38548944743");

        SCBuyRequest scBuyRequest = new SCBuyRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    convertToAtom(buyAmountAPL),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse buyResponse = scBuyTokens(scBuyRequest);
        trxId = broadcastTransaction(buyResponse.getTx()).getTransaction();


        verifyTransactionInBlock(trxId);


        String balanceLockOf = String.valueOf(Long.parseLong(buyAmountAPL) * Double.valueOf(Double.parseDouble(rate) * 100000000L).longValue());
        verifyLockOf(balanceLockOf, sc.getRecipientRS(),"0xfd1ba38548944743");

        SCUnlockRequest scUnlockRequest = new SCUnlockRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse unlockResponse = scUnlockTokens(scUnlockRequest);
        trxId = broadcastTransaction(unlockResponse.getTx()).getTransaction();

        verifyTransactionInBlock(trxId);

        verifyLockOf(convertToAtom("0"),sc.getRecipientRS(),"0xfd1ba38548944743");

        String balanceOf = String.valueOf(Long.parseLong(balanceLockOf) + Long.parseLong(convertToAtom(init)));
        verifyBalanceOf(balanceOf,sc.getRecipientRS(),"0xfd1ba38548944743");

        String totalSupply = String.valueOf(Long.parseLong(balanceLockOf) + Long.parseLong(convertToAtom(init)));
        verifyTotalSupply(totalSupply,sc.getRecipientRS());


        SCApproveRequest scApproveRequest = new SCApproveRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                convertToAtom(allowanceAmount),
                "0x67c5363f4019c423",
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse approveResponse = scApprove(scApproveRequest);
        trxId = broadcastTransaction(approveResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyAllowance(convertToAtom(allowanceAmount),sc.getRecipientRS(),"0xfd1ba38548944743","0x67c5363f4019c423");


        source = sourceFactory.createSCSCSource(SCType.ESCROW,name);
        smartContract = new CreateSmartContract(
                "MyTokenEscrow",
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                "0",
                "10000",
                "1000000000",
                source,
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        trxResponse =  createSC(smartContract);
        trxId = broadcastTransaction(trxResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);


    }

    void verifyBalanceOf(String expectedResult, String scAddress,String account){
        SCBalanceOfRequest balanceReq = new SCBalanceOfRequest(scAddress,account);
        TrxResponse balanceResponse = balanceOf(balanceReq);
        log.info("BalanceOf balance: {}",balanceResponse.getResults().get(0).getOutput().get(0));
        assertEquals(expectedResult, balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");

    }

    void verifyLockOf(String expectedResult, String scAddress,String account){
        SCLockOfRequest balanceReq = new SCLockOfRequest(scAddress,account);
        TrxResponse balanceResponse = lockOf(balanceReq);
        log.info("LockOf balance: {}",balanceResponse.getResults().get(0).getOutput().get(0));
        assertEquals(expectedResult,balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");
    }

    void verifyTotalSupply(String expectedResult, String scAddress){
        SCTotalSupplyRequest totalSupplyRequest = new SCTotalSupplyRequest(scAddress);
        TrxResponse balanceResponse = scTotalSupply(totalSupplyRequest);
        log.info("TotalSupply balance: {}",balanceResponse.getResults().get(0).getOutput().get(0));
        assertEquals(expectedResult,balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");
    }


    void verifyAllowance(String expectedResult, String scAddress, String owner, String spender){
        SCAllowanceOfRequest allowanceRequest = new SCAllowanceOfRequest(scAddress,owner,spender);
        TrxResponse balanceResponse = scAllowanceOf(allowanceRequest);
        log.info("Allowance balance: {}",balanceResponse.getResults().get(0).getOutput().get(0));
        assertEquals(expectedResult,balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");
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
