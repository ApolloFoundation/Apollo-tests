var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20906",
        "ok": "3518",
        "ko": "17388"
    },
    "minResponseTime": {
        "total": "103",
        "ok": "103",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60024",
        "ok": "53364",
        "ko": "60024"
    },
    "meanResponseTime": {
        "total": "18544",
        "ok": "5716",
        "ko": "21139"
    },
    "standardDeviation": {
        "total": "19150",
        "ok": "5550",
        "ko": "19867"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "6228",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "10048",
        "ok": "9500",
        "ko": "28993"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "13114",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "21397",
        "ko": "60002"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 953,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 262,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2303,
    "percentage": 11
},
    "group4": {
    "name": "failed",
    "count": 17388,
    "percentage": 83
},
    "meanNumberOfRequestsPerSecond": {
        "total": "215.526",
        "ok": "36.268",
        "ko": "179.258"
    }
},
contents: {
"req_get-account-id-2666f": {
        type: "REQUEST",
        name: "Get Account Id",
path: "Get Account Id",
pathFormatted: "req_get-account-id-2666f",
stats: {
    "name": "Get Account Id",
    "numberOfRequests": {
        "total": "18000",
        "ok": "2906",
        "ko": "15094"
    },
    "minResponseTime": {
        "total": "166",
        "ok": "166",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60024",
        "ok": "53364",
        "ko": "60024"
    },
    "meanResponseTime": {
        "total": "15076",
        "ok": "5116",
        "ko": "16993"
    },
    "standardDeviation": {
        "total": "16410",
        "ok": "5321",
        "ko": "17114"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "2112",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "10002",
        "ok": "9060",
        "ko": "10002"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "12540",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "18925",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 909,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 220,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1777,
    "percentage": 10
},
    "group4": {
    "name": "failed",
    "count": 15094,
    "percentage": 84
},
    "meanNumberOfRequestsPerSecond": {
        "total": "185.567",
        "ok": "29.959",
        "ko": "155.608"
    }
}
    },"req_send-money-daeb4": {
        type: "REQUEST",
        name: "Send Money",
path: "Send Money",
pathFormatted: "req_send-money-daeb4",
stats: {
    "name": "Send Money",
    "numberOfRequests": {
        "total": "2906",
        "ok": "612",
        "ko": "2294"
    },
    "minResponseTime": {
        "total": "103",
        "ok": "103",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60011",
        "ok": "36210",
        "ko": "60011"
    },
    "meanResponseTime": {
        "total": "40026",
        "ok": "8565",
        "ko": "48419"
    },
    "standardDeviation": {
        "total": "20842",
        "ok": "5729",
        "ko": "14388"
    },
    "percentiles1": {
        "total": "31614",
        "ok": "9477",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "11820",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "14011",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "28856",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 44,
    "percentage": 2
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 42,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 526,
    "percentage": 18
},
    "group4": {
    "name": "failed",
    "count": 2294,
    "percentage": 79
},
    "meanNumberOfRequestsPerSecond": {
        "total": "29.959",
        "ok": "6.309",
        "ko": "23.649"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
