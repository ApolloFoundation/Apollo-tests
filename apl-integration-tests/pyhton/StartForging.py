import random
import requests

peers = ['51.15.37.165','51.15.209.252','51.15.228.126','51.15.46.25','51.15.72.23']


for i in range(200):
    peer = random.choice(peers)
    print(peer)
    response = requests.post('http://'+peer+':7876/apl?requestType=startForging&secretPhrase='+str(i+1))
    print(response.content)
