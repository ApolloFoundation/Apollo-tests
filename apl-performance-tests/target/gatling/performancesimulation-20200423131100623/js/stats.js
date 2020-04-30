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
        "total": "49",
        "ok": "49",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "19370",
        "ok": "19370",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "5824",
        "ok": "5824",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6457",
        "ok": "6457",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2499",
        "ok": "2499",
        "ko": "-"
    },
    "percentiles2": {
        "total": "11626",
        "ok": "11626",
        "ko": "-"
    },
    "percentiles3": {
        "total": "17683",
        "ok": "17683",
        "ko": "-"
    },
    "percentiles4": {
        "total": "18982",
        "ok": "18982",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3747,
    "percentage": 31
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 564,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 7689,
    "percentage": 64
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "171.429",
        "ok": "171.429",
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
        "total": "88",
        "ok": "88",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5642",
        "ok": "5642",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1336",
        "ok": "1336",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1375",
        "ok": "1375",
        "ko": "-"
    },
    "percentiles1": {
        "total": "720",
        "ok": "720",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2194",
        "ok": "2194",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4174",
        "ok": "4174",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4878",
        "ok": "4878",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3135,
    "percentage": 52
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 406,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2459,
    "percentage": 41
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "85.714",
        "ok": "85.714",
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
        "total": "49",
        "ok": "49",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "19370",
        "ok": "19370",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "10312",
        "ok": "10312",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "6419",
        "ok": "6419",
        "ko": "-"
    },
    "percentiles1": {
        "total": "11626",
        "ok": "11626",
        "ko": "-"
    },
    "percentiles2": {
        "total": "15916",
        "ok": "15915",
        "ko": "-"
    },
    "percentiles3": {
        "total": "18516",
        "ok": "18516",
        "ko": "-"
    },
    "percentiles4": {
        "total": "19132",
        "ok": "19132",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 612,
    "percentage": 10
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 158,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5230,
    "percentage": 87
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "85.714",
        "ok": "85.714",
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
