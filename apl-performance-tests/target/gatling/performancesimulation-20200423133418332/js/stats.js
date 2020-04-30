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
        "total": "6572",
        "ok": "6572",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1022",
        "ok": "1022",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1364",
        "ok": "1364",
        "ko": "-"
    },
    "percentiles1": {
        "total": "160",
        "ok": "160",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1802",
        "ok": "1803",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3764",
        "ok": "3764",
        "ko": "-"
    },
    "percentiles4": {
        "total": "5794",
        "ok": "5794",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 7537,
    "percentage": 63
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 640,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3823,
    "percentage": 32
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "190.476",
        "ok": "190.476",
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
        "total": "87",
        "ok": "87",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1311",
        "ok": "1311",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "155",
        "ok": "155",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "137",
        "ok": "137",
        "ko": "-"
    },
    "percentiles1": {
        "total": "116",
        "ok": "116",
        "ko": "-"
    },
    "percentiles2": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "percentiles3": {
        "total": "333",
        "ok": "333",
        "ko": "-"
    },
    "percentiles4": {
        "total": "965",
        "ok": "965",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 5909,
    "percentage": 98
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 83,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 8,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "95.238",
        "ok": "95.238",
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
        "total": "6572",
        "ok": "6572",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1890",
        "ok": "1890",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1483",
        "ok": "1483",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1799",
        "ok": "1799",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2757",
        "ok": "2757",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4979",
        "ok": "4979",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6064",
        "ok": "6064",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1628,
    "percentage": 27
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 557,
    "percentage": 9
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 3815,
    "percentage": 64
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "95.238",
        "ok": "95.238",
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
