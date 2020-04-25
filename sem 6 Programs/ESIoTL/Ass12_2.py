#Assignment No.: 12
#Problem To understand client server application  on Raspberry Pi inorder to get services. 
#Name :Sameer Rathod
#TE B 58

from picamera import PiCamera
from time import sleep

import smtplib
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText
from email.MIMEBase import MIMEBase
from email import encoders

camera = PiCamera()

camera.start_preview()
sleep(5)
camera.capture('/home/pi/Desktop/image.jpg')
camera.stop_preview()

 
fromaddr = "manisha.intelidemics@gmail.com"
toaddr = "anumahale44@gmail.com"
 
msg = MIMEMultipart()
 
msg['From'] = fromaddr
msg['To'] = toaddr
msg['Subject'] = "capture Images Send using Raspberry pi"
 
body = "camera capture image send successfully"
 
msg.attach(MIMEText(body, 'plain'))
 
filename = "image.jpg"
attachment = open("/home/pi/Desktop/image.jpg", "rb")
 
part = MIMEBase('application', 'octet-stream')
part.set_payload((attachment).read())
encoders.encode_base64(part)
part.add_header('Content-Disposition', "attachment; filename= %s" % filename)
 
msg.attach(part)
 
server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(fromaddr, "manisha@123")
text = msg.as_string()
server.sendmail(fromaddr, toaddr, text)
server.quit()
