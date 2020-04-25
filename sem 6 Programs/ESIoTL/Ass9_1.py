#Assignment No.: 9
#Problem Statement :Write an application using Raspberry-Pi to control the operation of stepper motor.
#Name :Sameer Rathod
#TE B 58


import RPi.GPIO as GPIO 
import time
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
while True:
    ControlPin=[7,11,13,15]
    for pin in ControlPin:
        GPIO.setup(pin,GPIO.OUT)
        GPIO.output(pin,0)

    seq = [
             [0,0,0,1],
             [0,0,1,1],
             [0,0,1,0],
             [0,1,1,0],
             [0,1,0,0],
             [1,1,0,0],
             [1,0,0,0],
             [1,0,0,1],
              
          ]
    for i in range(512):
        for halfstep in range(8):
            for pin in range(4):
                GPIO.output(ControlPin[pin],seq[halfstep][pin])
            time.sleep(0.001)
GPIO.cleanup()        
