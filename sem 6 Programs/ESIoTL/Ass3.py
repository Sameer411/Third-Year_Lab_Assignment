#Assignment No: 3
#Problem Statement :Study of Connectivity and configuration of Raspberry-Pi /Beagle board
#circuit with basic peripherals, LEDS. Understanding GPIO and its use in program.
#Name :Sameer Rathod
#TE B 58

import RPi.GPIO as GPIO
import time
led1Pin = 7
led2Pin = 11
led3Pin = 13
led4Pin = 15

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)
GPIO.setup(led1Pin, GPIO.OUT)
GPIO.setup(led2Pin, GPIO.OUT)
GPIO.setup(led3Pin, GPIO.OUT)
GPIO.setup(led4Pin, GPIO.OUT)

while True:
    print "on"
    GPIO.output(led1Pin, True)
    time.sleep(1)
    GPIO.output(led2Pin, True)
    time.sleep(1)
    GPIO.output(led3Pin, True)
    time.sleep(1)
    GPIO.output(led4Pin, True)
    time.sleep(1)
    
    print "off"
    GPIO.output(led1Pin, False)
    time.sleep(1)
    GPIO.output(led2Pin, False)
    time.sleep(1)
    GPIO.output(led3Pin, False)
    time.sleep(1)
    GPIO.output(led4Pin, False)
    time.sleep(1)
    

   
    





