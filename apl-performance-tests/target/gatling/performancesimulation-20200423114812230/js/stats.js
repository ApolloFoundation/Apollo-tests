var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "19517",
        "ok": "14174",
        "ko": "5343"
    },
    "minResponseTime": {
        "total": "95",
        "ok": "95",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "70893",
        "ok": "70893",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "19881",
        "ok": "15889",
        "ko": "30468"
    },
    "standardDeviation": {
        "total": "20509",
        "ok": "17314",
        "ko": "24223"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "8236",
        "ko": "10002"
    },
    "percentiles2": {
        "total": "29886",
        "ok": "24756",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "53957",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "58906",
        "ko": "60002"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1623,
    "percentage": 8
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 574,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 11977,
    "percentage": 61
},
    "group4": {
    "name": "failed",
    "count": 5343,
    "percentage": 27
},
    "meanNumberOfRequestsPerSecond": {
        "total": "154.897",
        "ok": "112.492",
        "ko": "42.405"
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
        "ok": "7517",
        "ko": "4483"
    },
    "minResponseTime": {
        "total": "167",
        "ok": "167",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60002",
        "ok": "59970",
        "ko": "60002"
    },
    "meanResponseTime": {
        "total": "18441",
        "ok": "14356",
        "ko": "25292"
    },
    "standardDeviation": {
        "total": "20061",
        "ok": "17011",
        "ko": "22741"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "7371",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "25048",
        "ok": "21329",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "52730",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "59289",
        "ko": "60002"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 984,
    "percentage": 8
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 316,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6217,
    "percentage": 52
},
    "group4": {
    "name": "failed",
    "count": 4483,
    "percentage": 37
},
    "meanNumberOfRequestsPerSecond": {
        "total": "95.238",
        "ok": "59.659",
        "ko": "35.579"
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
        "total": "7517",
        "ok": "6657",
        "ko": "860"
    },
    "minResponseTime": {
        "total": "95",
        "ok": "95",
        "ko": "10001"
    },
    "maxResponseTime": {
        "total": "70893",
        "ok": "70893",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "22178",
        "ok": "17621",
        "ko": "57454"
    },
    "standardDeviation": {
        "total": "20999",
        "ok": "17489",
        "ko": "9040"
    },
    "percentiles1": {
        "total": "14269",
        "ok": "12935",
        "ko": "60001"
    },
    "percentiles2": {
        "total": "40451",
        "ok": "25315",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "55151",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "58651",
        "ko": "60002"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 639,
    "percentage": 9
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 258,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5760,
    "percentage": 77
},
    "group4": {
    "name": "failed",
    "count": 860,
    "percentage": 11
},
    "meanNumberOfRequestsPerSecond": {
        "total": "59.659",
        "ok": "52.833",
        "ko": "6.825"
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
