var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "12000",
        "ok": "12000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "83",
        "ok": "83",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3281",
        "ok": "3281",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "564",
        "ok": "564",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "671",
        "ok": "671",
        "ko": "-"
    },
    "percentiles1": {
        "total": "215",
        "ok": "215",
        "ko": "-"
    },
    "percentiles2": {
        "total": "730",
        "ok": "730",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2085",
        "ok": "2085",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2953",
        "ok": "2954",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 9170,
    "percentage": 76
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 890,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1940,
    "percentage": 16
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "193.548",
        "ok": "193.548",
        "ko": "-"
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
        "total": "6000",
        "ok": "6000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "156",
        "ok": "156",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1968",
        "ok": "1968",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "253",
        "ok": "253",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "162",
        "ok": "162",
        "ko": "-"
    },
    "percentiles1": {
        "total": "196",
        "ok": "196",
        "ko": "-"
    },
    "percentiles2": {
        "total": "241",
        "ok": "241",
        "ko": "-"
    },
    "percentiles3": {
        "total": "561",
        "ok": "561",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1134",
        "ok": "1134",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 5866,
    "percentage": 98
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 107,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 27,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "96.774",
        "ok": "96.774",
        "ko": "-"
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
        "total": "6000",
        "ok": "6000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "83",
        "ok": "83",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3281",
        "ok": "3281",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "874",
        "ok": "874",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "826",
        "ok": "826",
        "ko": "-"
    },
    "percentiles1": {
        "total": "633",
        "ok": "633",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1452",
        "ok": "1452",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2615",
        "ok": "2615",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3078",
        "ok": "3078",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3304,
    "percentage": 55
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 783,
    "percentage": 13
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1913,
    "percentage": 32
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "96.774",
        "ok": "96.774",
        "ko": "-"
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
