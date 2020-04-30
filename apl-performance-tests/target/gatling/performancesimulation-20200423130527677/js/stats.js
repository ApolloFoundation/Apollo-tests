var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "14905",
        "ok": "3769",
        "ko": "11136"
    },
    "minResponseTime": {
        "total": "98",
        "ok": "98",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "79204",
        "ok": "77823",
        "ko": "79204"
    },
    "meanResponseTime": {
        "total": "30263",
        "ok": "13670",
        "ko": "35879"
    },
    "standardDeviation": {
        "total": "24006",
        "ok": "14785",
        "ko": "23930"
    },
    "percentiles1": {
        "total": "22287",
        "ok": "7065",
        "ko": "31585"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "23460",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "40163",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60006",
        "ok": "59682",
        "ko": "60006"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 652,
    "percentage": 4
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 195,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2922,
    "percentage": 20
},
    "group4": {
    "name": "failed",
    "count": 11136,
    "percentage": 75
},
    "meanNumberOfRequestsPerSecond": {
        "total": "107.23",
        "ok": "27.115",
        "ko": "80.115"
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
        "total": "12000",
        "ok": "2905",
        "ko": "9095"
    },
    "minResponseTime": {
        "total": "98",
        "ok": "98",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60024",
        "ok": "59980",
        "ko": "60024"
    },
    "meanResponseTime": {
        "total": "27657",
        "ok": "11741",
        "ko": "32740"
    },
    "standardDeviation": {
        "total": "24139",
        "ok": "13750",
        "ko": "24528"
    },
    "percentiles1": {
        "total": "10002",
        "ok": "2666",
        "ko": "10003"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "22659",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "36763",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "56680",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 632,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 182,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2091,
    "percentage": 17
},
    "group4": {
    "name": "failed",
    "count": 9095,
    "percentage": 76
},
    "meanNumberOfRequestsPerSecond": {
        "total": "86.331",
        "ok": "20.899",
        "ko": "65.432"
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
        "total": "2905",
        "ok": "864",
        "ko": "2041"
    },
    "minResponseTime": {
        "total": "170",
        "ok": "170",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "79204",
        "ok": "77823",
        "ko": "79204"
    },
    "meanResponseTime": {
        "total": "41028",
        "ok": "20154",
        "ko": "49865"
    },
    "standardDeviation": {
        "total": "20151",
        "ok": "16229",
        "ko": "14280"
    },
    "percentiles1": {
        "total": "42001",
        "ok": "19327",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60001",
        "ok": "27135",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "58595",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "65602",
        "ok": "71065",
        "ko": "60012"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 20,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 13,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 831,
    "percentage": 29
},
    "group4": {
    "name": "failed",
    "count": 2041,
    "percentage": 70
},
    "meanNumberOfRequestsPerSecond": {
        "total": "20.899",
        "ok": "6.216",
        "ko": "14.683"
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
