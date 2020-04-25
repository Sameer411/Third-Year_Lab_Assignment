#Assignment No: 5
#Problem Statement :Understanding the connectivity of Raspberry-Pi /Beagle board circuit with
#IR sensor. Write an application to detect obstacles and notify the user using LEDs.
#Name :Sameer Rathod
#TE B 58


import RPi.GPIO as GPIO

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(36, GPIO.IN)



while True :
    prox_val = GPIO.input(36)
    if prox_val :
        print("obstacle detected\n")
        
    else :
        print("No obstacle detected\n")
       
        
