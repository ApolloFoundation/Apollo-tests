var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20170",
        "ok": "15377",
        "ko": "4793"
    },
    "minResponseTime": {
        "total": "64",
        "ok": "64",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "66500",
        "ok": "66500",
        "ko": "60018"
    },
    "meanResponseTime": {
        "total": "25504",
        "ok": "21831",
        "ko": "37290"
    },
    "standardDeviation": {
        "total": "20081",
        "ok": "16870",
        "ko": "24529"
    },
    "percentiles1": {
        "total": "20235",
        "ok": "18928",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "41457",
        "ok": "35908",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "52024",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "58572",
        "ko": "60010"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 946,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 356,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 14075,
    "percentage": 70
},
    "group4": {
    "name": "failed",
    "count": 4793,
    "percentage": 24
},
    "meanNumberOfRequestsPerSecond": {
        "total": "145.108",
        "ok": "110.626",
        "ko": "34.482"
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
        "ok": "8170",
        "ko": "3830"
    },
    "minResponseTime": {
        "total": "94",
        "ok": "94",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60017",
        "ok": "59980",
        "ko": "60017"
    },
    "meanResponseTime": {
        "total": "22400",
        "ok": "17755",
        "ko": "32309"
    },
    "standardDeviation": {
        "total": "21039",
        "ok": "17299",
        "ko": "24582"
    },
    "percentiles1": {
        "total": "10002",
        "ok": "9127",
        "ko": "10002"
    },
    "percentiles2": {
        "total": "38550",
        "ok": "31785",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "52627",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "58486",
        "ko": "60009"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 850,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 324,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6996,
    "percentage": 58
},
    "group4": {
    "name": "failed",
    "count": 3830,
    "percentage": 32
},
    "meanNumberOfRequestsPerSecond": {
        "total": "86.331",
        "ok": "58.777",
        "ko": "27.554"
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
        "total": "8170",
        "ok": "7207",
        "ko": "963"
    },
    "minResponseTime": {
        "total": "64",
        "ok": "64",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "66500",
        "ok": "66500",
        "ko": "60018"
    },
    "meanResponseTime": {
        "total": "30064",
        "ok": "26452",
        "ko": "57103"
    },
    "standardDeviation": {
        "total": "17619",
        "ok": "15093",
        "ko": "10004"
    },
    "percentiles1": {
        "total": "30035",
        "ok": "27589",
        "ko": "60001"
    },
    "percentiles2": {
        "total": "42771",
        "ok": "38342",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "50010",
        "ko": "60010"
    },
    "percentiles4": {
        "total": "60008",
        "ok": "58651",
        "ko": "60011"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 96,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 32,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 7079,
    "percentage": 87
},
    "group4": {
    "name": "failed",
    "count": 963,
    "percentage": 12
},
    "meanNumberOfRequestsPerSecond": {
        "total": "58.777",
        "ok": "51.849",
        "ko": "6.928"
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
