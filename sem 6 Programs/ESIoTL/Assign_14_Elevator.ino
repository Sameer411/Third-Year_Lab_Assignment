#include <Servo.h>
#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 13, 10, 8, 7);
Servo servo;

int buttonpin0=4;
int buttonpin1=3;
int buttonpin2=2;

void setup()
{
  pinMode(buttonpin0,INPUT);
  pinMode(buttonpin1,INPUT);
  pinMode(buttonpin2,INPUT);
  
  lcd.begin(16,2);
  lcd.print("Floor 2");
  
  servo.attach(9);
  servo.write(0);
}

void loop()
{
  int button0=digitalRead(buttonpin0);
  int button1=digitalRead(buttonpin1);
  int button2=digitalRead(buttonpin2);
  
  if(button0==HIGH&&servo.read()==90) 
  {
    servo.writeMicroseconds(2500);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 0");
    button0=LOW;
  }
  
  else if(button2==HIGH&&servo.read()==90)
  {
    servo.writeMicroseconds(500);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 2");
    button2=LOW;
  }

  else if(button0==HIGH&&servo.read()==0)
  {
    servo.writeMicroseconds(2500);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 0");
    button0=LOW;
  }
  
  else if(button1==HIGH&&servo.read()==0)
  {
    servo.writeMicroseconds(1475);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 1");
    button1=LOW;
  }
  
  else if(button1==HIGH&&servo.read()==180)
  {
    servo.writeMicroseconds(1475);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 1");
    button1=LOW;
  }
  
  else if(button2==HIGH&&servo.read()==180)
  {
    servo.writeMicroseconds(500);
    lcd.clear();
    delay(1000);
    lcd.print("Floor 2");
    button2=LOW;
  }
  
}