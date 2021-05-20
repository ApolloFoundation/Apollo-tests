import json
import random
import threading
import time

import requests


peer = '51.15.37.165'
moneyCount = 10000000
thread_count = 1
wallet_count = 1001

for i in range(200):
    sendMoney = 10000000;
    moneyCount += sendMoney;
    amount_str = str(sendMoney)+'00000000';
    #if moneyCount >= 60000000: break
    print(i)
    response = requests.post('http://' + peer + ':7876/apl?requestType=getAccountId&secretPhrase='+str(i))
    response_string = json.loads(response.content)
    accountRS = response_string["accountRS"]
    print(response_string["accountRS"])
    response = requests.post('http://'+peer+':7876/apl?requestType=sendMoney&feeATM=3000000000&deadline=1440&&amountATM='+amount_str+'&recipient='+accountRS+'&secretPhrase=0')
    print(json.loads(response.content))

