package com.apollocurrrency.aplwallet.inttest.model;

public class ReqType {
    public static final String REQUEST_TYPE = "requestType";
    public static final String GET_BALANCE = "getBalance";
    public static final String START_FORGING = "startForging";
    public static final String GET_TRANSACTION = "getTransaction";
    public static final String SEND_MONEY = "sendMoney";
    public static final String LEASE_BALANCE = "leaseBalance";
    public static final String GET_SHUFFLING_PARTICIPANTS = "getShufflingParticipants";
    public static final String GET_ALL_SHUFFLINGS = "getAllShufflings";
    public static final String DGS_REFUND = "dgsRefund";
    public static final String DGS_FEEDBACK = "dgsFeedback";
    public static final String DGS_DELIVERY = "dgsDelivery";
    public static final String DGS_PURCHASE = "dgsPurchase";
    public static final String DGS_PRICE_CHANGE = "dgsPriceChange";
    public static final String GET_DGS_GOOD = "getDGSGood";
    public static final String DGS_QUANTITY_CHANGE = "dgsQuantityChange";
    public static final String DGS_DELISTING = "dgsDelisting";
    public static final String DGS_LISTING = "dgsListing";
    public static final String SHUFFLING_VERIFY = "shufflingVerify";
    public static final String START_SHUFFLER = "startShuffler";
    public static final String SHUFFLING_PROCESS = "shufflingProcess";
    public static final String SHUFFLING_REGISTER = "shufflingRegister";
    public static final String SHUFFLING_CANCEL = "shufflingCancel";
    public static final String GET_SHUFFLING = "getShuffling";
    public static final String GET_ACCOUNT_CURRENCIES = "getAccountCurrencies";
    public static final String SHUFFLING_CREATE = "shufflingCreate";
    public static final String SCHEDULE_CURRENCY_BUY = "scheduleCurrencyBuy";
    public static final String CURRENCY_BUY = "currencyBuy";
    public static final String CURRENCY_SELL = "currencySell";
    public static final String PUBLISH_EXCHANGE_OFFER = "publishExchangeOffer";
    public static final String CURRENCY_RESERVE_INCREASE = "currencyReserveIncrease";
    public static final String CURRENCY_RESERVE_CLAIM = "currencyReserveClaim";
    public static final String CURRENCY_MINT = "currencyMint";
    public static final String TRANSFER_CURRENCY = "transferCurrency";
    public static final String GET_ALL_CURRENCIES = "getAllCurrencies";
    public static final String GET_CURRENCY = "getCurrency";
    public static final String GET_CURRENCY_ACCOUNTS = "getCurrencyAccounts";
    public static final String DELETE_CURRENCY = "deleteCurrency";
    public static final String GET_FORGING = "getForging";
    public static final String STOP_FORGING = "stopForging";
    public static final String IMPORT_KEY = "importKey";
    public static final String EXPORT_KEY = "exportKey";
    public static final String GET_EC_BLOCK = "getECBlock";
    public static final String GET_BLOCKCHAIN_STATUS = "getBlockchainStatus";
    public static final String GET_MY_INFO = "getMyInfo";
    public static final String ADD_PEER = "addPeer";
    public static final String ENABLE_2FA = "enable2FA";
    public static final String GET_PEER = "getPeer";
    public static final String DELETE_KEY = "deleteKey";
    public static final String GENERATE_ACCOUNT = "generateAccount";
    public static final String DELETE_ACCOUNT_PROPERTY = "deleteAccountProperty";
    public static final String GET_PRIVATE_BLOCKCHAIN_TRANSACTIONS = "getPrivateBlockchainTransactions";
    public static final String GET_ACCOUNT = "getAccount";
    public static final String GET_ACCOUNT_BLOCK_COUNT = "getAccountBlockCount";
    public static final String GET_ACCOUNT_BLOCKS = "getAccountBlocks";
    public static final String GET_ACCOUNT_BLOCK_IDS = "getAccountBlockIds";
    public static final String GET_ACCOUNT_ID = "getAccountId";
    public static final String GET_ACCOUNT_LEDGER = "getAccountLedger";
    public static final String GET_ACCOUNT_LEDGER_ENTRY = "getAccountLedgerEntry";
    public static final String GET_ACCOUNT_LESSORS = "getAccountLessors";
    public static final String GET_ACCOUNT_PROPERTIES = "getAccountProperties";
    public static final String GET_ACCOUNT_PUBLIC_KEY = "getAccountPublicKey";
    public static final String GET_BLOCKCHAIN_TRANSACTIONS = "getBlockchainTransactions";
    public static final String GET_GUARANTEED_BALANCE = "getGuaranteedBalance";
    public static final String GET_UNCONFIRMED_TRANSACTION_IDS = "getUnconfirmedTransactionIds";
    public static final String GET_UNCONFIRMED_TRANSACTIONS = "getUnconfirmedTransactions";
    public static final String SET_ACCOUNT_INFO = "setAccountInfo";
    public static final String START_FUNDING_MONITOR = "startFundingMonitor";
    public static final String STOP_FUNDING_MONITOR = "stopFundingMonitor";
    public static final String GET_ALL_PHASING_ONLY_CONTROLS = "getAllPhasingOnlyControls";
    public static final String GET_PHASING_ONLY_CONTROL = "getPhasingOnlyControl";
    public static final String SET_PHASING_ONLY_CONTROL = "setPhasingOnlyControl";
    public static final String SEARCH_ACCOUNTS = "searchAccounts";
    public static final String GET_PEERS = "getPeers";
    public static final String GET_BLOCKS = "getBlocks";
    public static final String SET_ALIAS = "setAlias";
    public static final String SET_ACCOUNT_PROPERTY = "setAccountProperty";
    public static final String GET_ALIAS = "getAlias";
    public static final String GET_ALIASES = "getAliases";
    public static final String GET_ALIAS_COUNT = "getAliasCount";
    public static final String DELETE_ALIAS = "deleteAlias";
    public static final String SELL_ALIAS = "sellAlias";
    public static final String BUY_ALIAS = "buyAlias";
    public static final String GET_ALIASES_LIKE = "getAliasesLike";
    public static final String ENCRYPT_TO = "encryptTo";
    public static final String DECRYPT_FROM = "decryptFrom";
    public static final String DOWNLOAD_PRUNABLE_MESSAGE = "downloadPrunableMessage";
    public static final String SEND_MESSAGE = "sendMessage";
    public static final String GET_ALL_PRUNABLE_MESSAGES = "getAllPrunableMessages";
    public static final String GET_PRUNABLE_MESSAGE = "getPrunableMessage";
    public static final String READ_MESSAGE = "readMessage";
    public static final String VERIFY_PRUNABLE_MESSAGE = "verifyPrunableMessage";
    public static final String ISSUE_ASSET = "issueAsset";
    public static final String GET_ACCOUNT_ASSET_COUNT = "getAccountAssetCount";
    public static final String GET_ACCOUNT_ASSETS = "getAccountAssets";
    public static final String GET_ASSET = "getAsset";
    public static final String GET_ALL_ASSETS = "getAllAssets";
    public static final String GET_ASSETS = "getAssets";
    public static final String PLACE_BID_ORDER = "placeBidOrder";
    public static final String PLACE_ASK_ORDER = "placeAskOrder";
    public static final String GET_ACCOUNT_CURRENT_BID_ORDERS = "getAccountCurrentBidOrders";
    public static final String GET_ACCOUNT_CURRENT_ASK_ORDERS = "getAccountCurrentAskOrders";
    public static final String GET_ALL_OPEN_BID_ORDERS = "getAllOpenBidOrders";
    public static final String GET_ALL_OPEN_ASK_ORDERS = "getAllOpenAskOrders";
    public static final String GET_ACCOUNT_CURRENT_BID_ORDER_IDS = "getAccountCurrentBidOrderIds";
    public static final String GET_ACCOUNT_CURRENT_ASK_ORDER_IDS = "getAccountCurrentAskOrderIds";
    public static final String GET_ALL_TRADES = "getAllTrades";
    public static final String GET_ASSET_ACCOUNT_COUNT = "getAssetAccountCount";
    public static final String GET_ASSET_ACCOUNTS = "getAssetAccounts";
    public static final String CANCEL_BID_ORDER = "cancelBidOrder";
    public static final String CANCEL_ASK_ORDER = "cancelAskOrder";
    public static final String GET_ASSET_IDS = "getAssetIds";
    public static final String GET_ASSET_TRANSFERS = "getAssetTransfers";
    public static final String TRANSFER_ASSET = "transferAsset";
    public static final String GET_ASSETS_BY_ISSUER = "getAssetsByIssuer";
    public static final String GET_BID_ORDERS = "getBidOrders";
    public static final String GET_ASK_ORDERS = "getAskOrders";
    public static final String GET_ASK_ORDER = "getAskOrder";
    public static final String GET_BID_ORDER = "getBidOrder";
    public static final String GET_BID_ORDER_IDS = "getBidOrderIds";
    public static final String GET_ASK_ORDER_IDS = "getAskOrderIds";
    public static final String GET_LAST_TRADES = "getLastTrades";
    public static final String GET_ORDER_TRADES = "getOrderTrades";
    public static final String DELETE_ASSET_SHARES = "deleteAssetShares";
    public static final String GET_EXPECTED_ASSET_DELETES = "getExpectedAssetDeletes";
    public static final String GET_EXPECTED_ORDER_CANCELLATIONS = "getExpectedOrderCancellations";
    public static final String GET_EXPECTED_BID_ORDERS = "getExpectedBidOrders";
    public static final String GET_EXPECTED_ASK_ORDERS = "getExpectedAskOrders";
    public static final String GET_ASSET_DELETES = "getAssetDeletes";
    public static final String SEARCH_ASSETS = "searchAssets";
    public static final String GET_BLOCK_ID = "getBlockId";
    public static final String GET_BLOCK = "getBlock";
    public static final String SEND_MONEY_PRIVATE = "sendMoneyPrivate";
    public static final String DIVIDEND_PAYMENT = "dividendPayment";
    public static final String GET_ASSET_DIVIDENDS = "getAssetDividends";
    public static final String GET_EXPECTED_ASSET_TRANSFERS = "getExpectedAssetTransfers";
    public static final String ISSUE_CURRENCY = "issueCurrency";
    public static final String GET_POLL = "getPoll";
    public static final String CREATE_POLL = "createPoll";
    public static final String CAST_VOTE = "castVote";
    public static final String GET_POLL_VOTES = "getPollVotes";
    public static final String GET_POLL_RESULT = "getPollResult";
    public static final String UPLOAD_TAGGED_DATA = "uploadTaggedData";
    public static final String DOWNLOAD_TAGGED_DATA = "downloadTaggedData";
    public static final String GET_ALL_TAGGED_DATA = "getAllTaggedData";
    public static final String GET_TAGGED_DATA = "getTaggedData";
    public static final String GET_DATA_TAG_COUNT = "getDataTagCount";
    public static final String SEARCH_TAGGED_DATA = "searchTaggedData";
    public static final String EXTEND_TAGGED_DATA = "extendTaggedData";

}
