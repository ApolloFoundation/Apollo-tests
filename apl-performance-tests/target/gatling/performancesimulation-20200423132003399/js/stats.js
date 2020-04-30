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
        "total": "28908",
        "ok": "28908",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "13221",
        "ok": "13221",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "8440",
        "ok": "8440",
        "ko": "-"
    },
    "percentiles1": {
        "total": "12692",
        "ok": "12692",
        "ko": "-"
    },
    "percentiles2": {
        "total": "20881",
        "ok": "20881",
        "ko": "-"
    },
    "percentiles3": {
        "total": "26808",
        "ok": "26808",
        "ko": "-"
    },
    "percentiles4": {
        "total": "27939",
        "ok": "27939",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 932,
    "percentage": 8
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 166,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10902,
    "percentage": 91
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "121.212",
        "ok": "121.212",
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
        "total": "97",
        "ok": "97",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "19415",
        "ok": "19415",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "8816",
        "ok": "8816",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "5707",
        "ok": "5707",
        "ko": "-"
    },
    "percentiles1": {
        "total": "9244",
        "ok": "9244",
        "ko": "-"
    },
    "percentiles2": {
        "total": "13308",
        "ok": "13308",
        "ko": "-"
    },
    "percentiles3": {
        "total": "18080",
        "ok": "18080",
        "ko": "-"
    },
    "percentiles4": {
        "total": "19071",
        "ok": "19071",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 814,
    "percentage": 14
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 158,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5028,
    "percentage": 84
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "60.606",
        "ok": "60.606",
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
        "total": "28908",
        "ok": "28908",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "17626",
        "ok": "17626",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "8431",
        "ok": "8431",
        "ko": "-"
    },
    "percentiles1": {
        "total": "20917",
        "ok": "20917",
        "ko": "-"
    },
    "percentiles2": {
        "total": "24536",
        "ok": "24536",
        "ko": "-"
    },
    "percentiles3": {
        "total": "27533",
        "ok": "27533",
        "ko": "-"
    },
    "percentiles4": {
        "total": "28347",
        "ok": "28347",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 118,
    "percentage": 2
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5874,
    "percentage": 98
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "60.606",
        "ok": "60.606",
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
