import requests

npz_account = "APL-NZKH-MZRE-2CTT-98NPZ"
npz_sender = "9211698109297098287"
npz_secret_phrase = "0"

URL = "localhost:7876"
# URL = "apl-tap-0.testnet-ap.apollowallet.org"

start = 100000
finish = 100999
amountATM = "1500000000000"


def sendMoneyToManyAccounts(url, finishNumber, startNumber):
    for k in range(int(startNumber), int(finishNumber) + 1, 1):
        print(k)
        print(" ----- SEND MONEY TO >>> " + str(k) + " <<<---- ACCOUNT --- ")
        headers = {
            'Content-Type': "application/json"
        }
        getAccountId = {"": "%2Fapl", "requestType": "getAccountId", "secretPhrase": str(k)}
        response = requests.request("GET", "http://" + url + "/apl", headers=headers, params=getAccountId)
        print(response.json())
        account = response.json()["accountRS"]
        print("---- RECIPIENT ---- >>>> " + str(account))

        data = {"requestType": "sendMoney", "recipient": str(account), "amountATM": amountATM,
                "secretPhrase": npz_secret_phrase, "feeATM": "100000000", "deadline": "1440",
                "sender": npz_sender}
        response = requests.request("POST", "http://" + url + "/apl",
                                    headers=headers,
                                    params=data)
        print(response.json())
        print("<<< -------- >>> FINISHED <<< ---------->>> ")


sendMoneyToManyAccounts(URL, finish, start)
