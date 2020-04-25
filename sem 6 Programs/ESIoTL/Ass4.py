#Assignment No: 4
#Problem Statement :Understanding the connectivity of Raspberry-Pi/Beagle board with
#temperature sensor. Write an application to read the environment temperature. If temperature
#crosses a threshold value, the application indicated user using LEDs.
#Name :Sameer Rathod
#TE B 58


import RPi.GPIO as GPIO
import time,sys
import datetime
import dht11

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.cleanup()
GPIO.setup(37,GPIO.OUT)
instance=dht11.DHT11(pin=5)

while True:
    result=instance.read()
    if result.is_valid():
        print("Last valid input:"+ str(datetime.datetime.now()))
        print("Temperature:%d C" %result.temperature)
        print("Humidity:%d %%" %result.humidity)

    if result.temperature>=23:
       GPIO.output(37,True)
       print('-------------temperature above 25 alert------------')
    else :
       GPIO.output(37,False)
    time.sleep(1)
GPIO.cleanup()
sys.exit(0)
