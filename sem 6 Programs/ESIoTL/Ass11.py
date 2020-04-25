/*Problem Statement:Data uploading on cloud
#Name :Sameer Rathod
#TE B 58

*/

import httplib,urllib
import time
sleep=60
key='QHO6YB4PBTFNTLIG'

def thermometer():
	while True:
		temp=int(open('/sys/class/thermal/thermal_zone0/temp').read())/1e3
		params=urllib.urlencode({'field1':temp,'key':key})
		headers={"Content-typZZe":"application/x-www-form-urlencoded","Accept":"text/plain"}
		conn=httplib.HTTPConnection("api.thingspeak.com:80")
		print(temp)
		try:
			conn.request("POST","/update",params,headers)
			response=conn.getresponse()

			print(response.status,response.reason)
			data=response.read()
			conn.close()
		except:
			print("connection failed")
		break
if __name__=="__main__":
	while True:
		thermometer()
time.sleep(sleep)
