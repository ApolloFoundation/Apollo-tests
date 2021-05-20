import requests

peers = ['51.15.37.165','51.15.209.252','51.15.228.126','51.15.228.171','51.15.46.25','51.15.72.23']

for i in peers:
    print(i)
   #response = requests.post('http://'+i+':7876/apl?requestType=stopForging&adminPassword=1', proxies=proxyDict)
    response = requests.post('http://' + i + ':7876/apl?requestType=stopForging&adminPassword=1')
    print(response.content)