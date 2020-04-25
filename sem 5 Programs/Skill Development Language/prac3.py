import datetime
current_date=datetime.date.today()
print("todays date is",current_date)
dob=input("Enter birth date")
dobdate=datetime.datetime.strptime(dob,"%Y-%m-%d")
years=current_date.year-dobdate.year
month=current_date.month-dobdate.month
day=current_date.day-dobdate.day

if years>0:
	print(years,"year")
	if month>0:
		print(month,"months")
	else:
		print(12-(dobdate.month-current_date.month),"month")
	if day>0:
		print(days,"days")
	else:
		print(31-(dobdate.day-current_date.day),"day")
else:
	print("not born yet")
