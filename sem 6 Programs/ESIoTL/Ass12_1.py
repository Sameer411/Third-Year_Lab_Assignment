#Assignment No.: 12
#Problem To understand client server application  on Raspberry Pi inorder to get services. 
#Name :Sameer Rathod
#TE B 58


import RPi.GPIO as GPIO
from picamera import PiCamera
from time import sleep

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
pirPin = 15
GPIO.setup(pirPin,GPIO.IN)

camera = PiCamera()
while True:
    pirValue = GPIO.input(pirPin)
    if pirValue == 0:
        print"Movement not detected"
    if pirValue == 1:
        print"Movement Detected"
        camera.start_preview()
        sleep(5)
        camera.capture('/home/pi/Desktop/image1.jpg')
        camera.stop_preview()





