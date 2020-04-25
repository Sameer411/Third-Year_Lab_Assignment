#Assignment No.:10
#Problem Statement : Write an application using Raspberry-Pi /Beagle board to control the
#operation of a hardware simulated traffic signal.
#Name :Sameer Rathod
#TE B 58


import time

import RPi.GPIO as GPIO

 

red_led1 = 36

yellow_led1 = 38

green_led1 = 40



red_led2 = 8

yellow_led2 = 10

green_led2 = 12



red_led3 = 11

yellow_led3 = 13

green_led3 = 15



red_led4 = 19

yellow_led4 = 21

green_led4 = 23


lane1= int(input("lane1:"))
print(lane1)

lane2= int(input("lane2:"))
print(lane2)

lane3= int(input("lane3:"))
print(lane3)

lane4= int(input("lane4:"))
print(lane4)


RUNNING = True



GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False);


GPIO.setup(red_led1, GPIO.OUT)

GPIO.setup(yellow_led1, GPIO.OUT)

GPIO.setup(green_led1, GPIO.OUT)



GPIO.setup(red_led2, GPIO.OUT)

GPIO.setup(yellow_led2, GPIO.OUT)
                 
GPIO.setup(green_led2, GPIO.OUT)



GPIO.setup(red_led3, GPIO.OUT)

GPIO.setup(yellow_led3, GPIO.OUT)

GPIO.setup(green_led3, GPIO.OUT)



GPIO.setup(red_led4, GPIO.OUT)

GPIO.setup(yellow_led4, GPIO.OUT)

GPIO.setup(green_led4, GPIO.OUT)

 



# Define a function to control the traffic light

def trafficState1(red1, yellow1, green1):

    GPIO.output(red_led1, red1)

    GPIO.output(yellow_led1, yellow1)

    GPIO.output(green_led1, green1)



def trafficState2(red2, yellow2, green2):

    GPIO.output(red_led2, red2)

    GPIO.output(yellow_led2, yellow2)

    GPIO.output(green_led2, green2)



def trafficState3(red3, yellow3, green3):

    GPIO.output(red_led3, red3)

    GPIO.output(yellow_led3, yellow3)

    GPIO.output(green_led3, green3)



def trafficState4(red4, yellow4, green4):

    GPIO.output(red_led4, red4)

    GPIO.output(yellow_led4, yellow4)

    GPIO.output(green_led4, green4)

 

print "Traffic Light Simulation. Press CTRL + C to quit"



# Main loop

try:

    while RUNNING:

        
        print("Green Light ON for Lane 3 ")
        
        trafficState1(0,0,1)

        trafficState2(1,0,0)

        trafficState3(1,0,0)

        trafficState4(1,0,0)

        time.sleep(lane3)



        trafficState1(0,1,0)

        trafficState2(1,0,0)

        trafficState3(1,0,0)

        trafficState4(1,0,0)

        time.sleep(5)

        

        print("Green Light ON for Lane 4")
        
        trafficState1(1,0,0)

        trafficState2(0,0,1)

        trafficState3(1,0,0)

        trafficState4(1,0,0)

        time.sleep(lane4)



        trafficState1(1,0,0)

        trafficState2(0,1,0)

        trafficState3(1,0,0)

        trafficState4(1,0,0)

        time.sleep(5)


        print("Green Light ON for Lane 1")
        trafficState1(1,0,0)

        trafficState2(1,0,0)

        trafficState3(0,0,1)

        trafficState4(1,0,0)

        time.sleep(lane1)



        trafficState1(1,0,0)

        trafficState2(1,0,0)

        trafficState3(0,1,0)

        trafficState4(1,0,0)

        time.sleep(5)

        
        print("Green Light ON for Lane 2")
        trafficState1(1,0,0)

        trafficState2(1,0,0)

        trafficState3(1,0,0)

        trafficState4(0,0,1)

        time.sleep(lane2)



        trafficState1(1,0,0)

        trafficState2(1,0,0)

        trafficState3(1,0,0)

        trafficState4(0,1,0)

        time.sleep(5)

 

# If CTRL+C is pressed the main loop is broken

except KeyboardInterrupt:

    RUNNING = False

    print "\Quitting"

 

# Actions under 'finally' will always be called

finally:

    # Stop and finish cleanly so the pins

    # are available to be used again

    GPIO.cleanup()
