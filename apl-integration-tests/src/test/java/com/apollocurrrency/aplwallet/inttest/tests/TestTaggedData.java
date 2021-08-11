package com.apollocurrrency.aplwallet.inttest.tests;

import com.apollocurrency.aplwallet.api.dto.TaggedDataDTO;
import com.apollocurrency.aplwallet.api.response.AllTaggedDataResponse;
import com.apollocurrency.aplwallet.api.response.CreateTransactionResponse;
import com.apollocurrrency.aplwallet.inttest.helper.TestConfiguration;
import com.apollocurrrency.aplwallet.inttest.helper.providers.WalletProvider;
import com.apollocurrrency.aplwallet.inttest.model.TestBaseNew;
import com.apollocurrrency.aplwallet.inttest.model.Wallet;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DisplayName("TaggedData")
@Epic(value = "TaggedData")
public class TestTaggedData extends TestBaseNew {

    private String Name;
    private String description;
    private String tag;
    private String channel;
    private final File image = TestConfiguration.getTestConfiguration().getDefaultImage();

    @BeforeEach
    @Override
    public void setUp(TestInfo testInfo) {
        super.setUp(testInfo);
        this.Name = RandomStringUtils.randomAlphabetic(5);
        this.description = RandomStringUtils.randomAlphabetic(5);
        this.channel = RandomStringUtils.randomAlphabetic(5);
        StringBuilder tags = new StringBuilder();
        String symbols = "!@$^&*()_+{}'./,\"";
        for (int i = 0; i < RandomUtils.nextInt(2, 5); i++) {
            if (i > 0) {
                tags.append(symbols.charAt(RandomUtils.nextInt(0, symbols.length())));
            }
            tags.append(RandomStringUtils.randomAlphabetic( 5));
        }
        this.tag = tags.toString();

        log.info("Data Name: {}", Name);
        log.info("Data Tag: {}", tag);
        log.info("Data description: {}", description);
        log.info("Data channel: {}", channel);
    }

    @DisplayName("Upload tagged data")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @ArgumentsSource(WalletProvider.class)
    void TaggedDataTest(Wallet wallet) {
        Long tagsQuantity = getDataTagCount().getNumberOfDataTags();
        log.info("Tags quantity: {} before uploading new TaggedData", tagsQuantity);
        CreateTransactionResponse uploadData = uploadTaggedData(wallet, Name, description, tag, channel, image);
        verifyCreatingTransaction(uploadData);
        verifyTransactionInBlock(uploadData.getTransaction());
        int parsedTags = getTaggedData(uploadData.getTransaction()).getParsedTags().size();
        log.info("Tags quantity which is created after uploading new TaggedData equals {} ", parsedTags);
        assertEquals(Name, getTaggedData(uploadData.getTransaction()).getName(), "names are not the same");
        assertEquals(description, getTaggedData(uploadData.getTransaction()).getDescription(), "descriptions are not the same");
        assertEquals(channel, getTaggedData(uploadData.getTransaction()).getChannel(), "channels are not the same");
        assertEquals(tagsQuantity + parsedTags, getDataTagCount().getNumberOfDataTags(), "quantity of tags are different");
        assertNotNull(searchTaggedDataByName(Name).getData(), "search by name doesn't work");
        assertFalse(searchTaggedDataByName(Name).getData().isEmpty(), "search by name doesn't work");
        assertEquals(Name, searchTaggedDataByName(Name).getData().get(0).getName(), "search by name doesn't work");
        AllTaggedDataResponse taggedDataByTag = searchTaggedDataByTag(tag);
        assertThat("TaggedData by tags count",taggedDataByTag.getData().size(),greaterThan(0));
        assertThat("TaggedData by tags count",taggedDataByTag.getData().get(0).getParsedTags().size(),greaterThan(0));
        log.info(" Tag from getTaggedData =  {} ", getTaggedData(uploadData.getTransaction()).getParsedTags().get(0));
        assertEquals(getTaggedData(uploadData.getTransaction()).getParsedTags().get(0), searchTaggedDataByTag(tag).getData().get(0).getParsedTags().get(0), "search by tag doesn't work");
        log.info(" Tag from searchTaggedData =  {} ", searchTaggedDataByTag(tag).getData().get(0).getParsedTags().get(0));
    }

    @DisplayName("upload TaggedData Test with extend TaggedData request")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @ArgumentsSource(WalletProvider.class)
    void extendTaggedDataTest(Wallet wallet) {
        Long tagsQuantity = getDataTagCount().getNumberOfDataTags();
        log.info("Tags quantity: {} before uploading new TaggedData", tagsQuantity);
        CreateTransactionResponse uploadData = uploadTaggedData(wallet, Name, description, tag, channel, image);
        verifyCreatingTransaction(uploadData);
        verifyTransactionInBlock(uploadData.getTransaction());
        TaggedDataDTO taggedData = getTaggedData(uploadData.getTransaction());
        int parsedTags = taggedData.getParsedTags().size();
        log.info("Tags quantity which is created after uploading new TaggedData equals {} ", parsedTags);
        assertEquals(Name, getTaggedData(uploadData.getTransaction()).getName(), "names are not the same");
        assertEquals(description, getTaggedData(uploadData.getTransaction()).getDescription(), "descriptions are not the same");
        assertEquals(channel, getTaggedData(uploadData.getTransaction()).getChannel(), "channels are not the same");
        assertEquals(tagsQuantity + parsedTags, getDataTagCount().getNumberOfDataTags(), "quantity of tags are different");
        assertNotNull(searchTaggedDataByName(Name).getData(), "search by name doesn't work");
        assertFalse(searchTaggedDataByName(Name).getData().isEmpty(), "search by name doesn't work");
        assertEquals(Name, searchTaggedDataByName(Name).getData().get(0).getName(), "search by name doesn't work");
        assertThat("TaggedData tags count",taggedData.getParsedTags().size(),greaterThan(0));
        AllTaggedDataResponse taggedDataByTag = searchTaggedDataByTag(tag);
        assertThat("TaggedData by tags count",taggedDataByTag.getData().size(),greaterThan(0));
        assertThat("TaggedData by tags count",taggedDataByTag.getData().get(0).getParsedTags().size(),greaterThan(0));
        assertEquals(getTaggedData(uploadData.getTransaction()).getParsedTags().get(0), searchTaggedDataByTag(tag).getData().get(0).getParsedTags().get(0), "search by tag doesn't work");
        log.info(" Tag from getTaggedData =  {} ", getTaggedData(uploadData.getTransaction()).getParsedTags().get(0));
        log.info(" Tag from searchTaggedData =  {} ", searchTaggedDataByTag(tag).getData().get(0).getParsedTags().get(0));
        CreateTransactionResponse extendData = extendTaggedData(wallet, uploadData.getTransaction());
        verifyCreatingTransaction(extendData);
        verifyTransactionInBlock(extendData.getTransaction());
    }


}
