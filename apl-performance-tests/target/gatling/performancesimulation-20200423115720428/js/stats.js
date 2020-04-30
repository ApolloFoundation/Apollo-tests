var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "24000",
        "ok": "24000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "85",
        "ok": "85",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6803",
        "ok": "6803",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1674",
        "ok": "1674",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2109",
        "ok": "2109",
        "ko": "-"
    },
    "percentiles1": {
        "total": "316",
        "ok": "316",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2770",
        "ok": "2770",
        "ko": "-"
    },
    "percentiles3": {
        "total": "5906",
        "ok": "5906",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6289",
        "ok": "6289",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 14625,
    "percentage": 61
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 817,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 8558,
    "percentage": 36
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "375",
        "ok": "375",
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
        "total": "12000",
        "ok": "12000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "158",
        "ok": "158",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3205",
        "ok": "3205",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "343",
        "ok": "343",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "362",
        "ok": "362",
        "ko": "-"
    },
    "percentiles1": {
        "total": "213",
        "ok": "213",
        "ko": "-"
    },
    "percentiles2": {
        "total": "302",
        "ok": "302",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1011",
        "ok": "1011",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2121",
        "ok": "2121",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 11144,
    "percentage": 93
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 400,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 456,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "187.5",
        "ok": "187.5",
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
        "total": "12000",
        "ok": "12000",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "85",
        "ok": "85",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6803",
        "ok": "6803",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "3004",
        "ok": "3004",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2285",
        "ok": "2285",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2731",
        "ok": "2731",
        "ko": "-"
    },
    "percentiles2": {
        "total": "5392",
        "ok": "5392",
        "ko": "-"
    },
    "percentiles3": {
        "total": "6101",
        "ok": "6101",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6350",
        "ok": "6350",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3481,
    "percentage": 29
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 417,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 8102,
    "percentage": 68
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "187.5",
        "ok": "187.5",
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
