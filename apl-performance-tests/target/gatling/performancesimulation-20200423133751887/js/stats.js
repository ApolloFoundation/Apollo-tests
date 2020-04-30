var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "18000",
        "ok": "18000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "25498",
        "ok": "25498",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "9603",
        "ok": "9603",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6995",
        "ok": "6995",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8835",
        "ok": "8836",
        "ko": "-"
    },
    "percentiles2": {
        "total": "15057",
        "ok": "15070",
        "ko": "-"
    },
    "percentiles3": {
        "total": "21880",
        "ok": "21880",
        "ko": "-"
    },
    "percentiles4": {
        "total": "24853",
        "ok": "24853",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1471,
    "percentage": 8
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 632,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 15897,
    "percentage": 88
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "202.247",
        "ok": "202.247",
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
        "total": "9000",
        "ok": "9000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "88",
        "ok": "88",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "18383",
        "ok": "18383",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "6197",
        "ok": "6197",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "4736",
        "ok": "4736",
        "ko": "-"
    },
    "percentiles1": {
        "total": "5206",
        "ok": "5206",
        "ko": "-"
    },
    "percentiles2": {
        "total": "9705",
        "ok": "9705",
        "ko": "-"
    },
    "percentiles3": {
        "total": "15153",
        "ok": "15153",
        "ko": "-"
    },
    "percentiles4": {
        "total": "16139",
        "ok": "16139",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1206,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 374,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 7420,
    "percentage": 82
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "101.124",
        "ok": "101.124",
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
        "total": "9000",
        "ok": "9000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "25498",
        "ok": "25498",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "13008",
        "ok": "13008",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "7227",
        "ok": "7227",
        "ko": "-"
    },
    "percentiles1": {
        "total": "13954",
        "ok": "13957",
        "ko": "-"
    },
    "percentiles2": {
        "total": "19505",
        "ok": "19504",
        "ko": "-"
    },
    "percentiles3": {
        "total": "23268",
        "ok": "23268",
        "ko": "-"
    },
    "percentiles4": {
        "total": "25044",
        "ok": "25044",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 265,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 258,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 8477,
    "percentage": 94
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "101.124",
        "ok": "101.124",
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
