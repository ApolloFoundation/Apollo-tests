package com.apollocurrrency.aplwallet.inttest.tests;

import com.apollocurrency.aplwallet.api.dto.TransactionDTO;
import com.apollocurrrency.aplwallet.inttest.helper.SCSourceFactory;
import com.apollocurrrency.aplwallet.inttest.helper.TestConfiguration;
import com.apollocurrrency.aplwallet.inttest.model.TestBaseNew;
import com.apollocurrrency.aplwallet.inttest.model.Wallet;
import com.apollocurrrency.aplwallet.inttest.model.sc.requests.*;
import com.apollocurrrency.aplwallet.inttest.model.sc.SCType;
import com.apollocurrrency.aplwallet.inttest.model.sc.response.TrxResponse;
import io.qameta.allure.Description;
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

public class SmartContracts extends TestBaseNew {
    SCSourceFactory sourceFactory = new SCSourceFactory();

    @DisplayName("Create SC")
    @Description("Create SC")
    @ParameterizedTest(name = "{displayName} rate: {0}")
    @MethodSource("scRate")
    public void createSc(String rate){
        String name = "INTTEST";
        String symbol = "INT";
        String cap = "100";
        String init = "50";
        rate = "1";
        String buyAmountAPL = "10";




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

        verifyBalanceOf(init,sc.getRecipientRS(),"0xfd1ba38548944743");

        SCBuyRequest scBuyRequest = new SCBuyRequest(
                    sc.getRecipientRS(),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                    convertToAtom(buyAmountAPL),
                    TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse buyResponse = scBuyTokens(scBuyRequest);
        trxId = broadcastTransaction(buyResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);



        verifyLockOf(String.valueOf(Long.parseLong(buyAmountAPL) * Long.parseLong(rate)),
                sc.getRecipientRS(),"0xfd1ba38548944743");

        SCUnlockRequest scUnlockRequest = new SCUnlockRequest(
                sc.getRecipientRS(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getUser(),
                TestConfiguration.getTestConfiguration().getStandartWallet().getPass());

        TrxResponse unlockResponse = scUnlockTokens(scUnlockRequest);
        trxId = broadcastTransaction(unlockResponse.getTx()).getTransaction();
        verifyTransactionInBlock(trxId);

        verifyLockOf("0",sc.getRecipientRS(),"0xfd1ba38548944743");
        verifyBalanceOf("60",sc.getRecipientRS(),"0xfd1ba38548944743");


    }

    void verifyBalanceOf(String expectedResult, String scAddress,String account){
        SCBalanceOfRequest balanceReq = new SCBalanceOfRequest(scAddress,account);
        TrxResponse balanceResponse = balanceOf(balanceReq);
        assertEquals(convertToAtom(expectedResult), balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");

    }

    void verifyLockOf(String expectedResult, String scAddress,String account){
        SCLockOfRequest balanceReq = new SCLockOfRequest(scAddress,account);
        TrxResponse balanceResponse = lockOf(balanceReq);
        assertEquals(convertToAtom(expectedResult),balanceResponse.getResults().get(0).getOutput().get(0),"Balance does not match");
        log.info("LockOf balance: ");
    }



    private static Stream<String> scRate() {
        return Stream.of("1", "0.01", "0.001", "0.00000001", "10", "100");

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
