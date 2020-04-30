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
        "total": "51",
        "ok": "51",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "71582",
        "ok": "71582",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "19316",
        "ok": "19316",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "16652",
        "ok": "16652",
        "ko": "-"
    },
    "percentiles1": {
        "total": "15997",
        "ok": "15996",
        "ko": "-"
    },
    "percentiles2": {
        "total": "34941",
        "ok": "34948",
        "ko": "-"
    },
    "percentiles3": {
        "total": "50283",
        "ok": "50283",
        "ko": "-"
    },
    "percentiles4": {
        "total": "56307",
        "ok": "56307",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1585,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 205,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 10210,
    "percentage": 85
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "87.591",
        "ok": "87.591",
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
        "total": "45231",
        "ok": "45231",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "13034",
        "ok": "13034",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "14683",
        "ok": "14683",
        "ko": "-"
    },
    "percentiles1": {
        "total": "6067",
        "ok": "6067",
        "ko": "-"
    },
    "percentiles2": {
        "total": "18097",
        "ok": "18097",
        "ko": "-"
    },
    "percentiles3": {
        "total": "42099",
        "ok": "42099",
        "ko": "-"
    },
    "percentiles4": {
        "total": "44407",
        "ok": "44407",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1394,
    "percentage": 23
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 148,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 4458,
    "percentage": 74
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "43.796",
        "ok": "43.796",
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
        "total": "51",
        "ok": "51",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "71582",
        "ok": "71582",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "25597",
        "ok": "25597",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "16127",
        "ok": "16127",
        "ko": "-"
    },
    "percentiles1": {
        "total": "25353",
        "ok": "25362",
        "ko": "-"
    },
    "percentiles2": {
        "total": "37042",
        "ok": "37033",
        "ko": "-"
    },
    "percentiles3": {
        "total": "53992",
        "ok": "53989",
        "ko": "-"
    },
    "percentiles4": {
        "total": "56906",
        "ok": "56906",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 191,
    "percentage": 3
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 57,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 5752,
    "percentage": 96
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "43.796",
        "ok": "43.796",
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
