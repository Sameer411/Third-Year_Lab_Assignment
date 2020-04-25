delimiter $$
create procedure pk(in roll int)
begin
declare d date;
declare nod int;
declare f int;
set f=0;

select DOI into d from borrower where roll_no=roll;
select d;
set nod=datediff(sysdate(),d);
select nod;


IF nod <15 THEN 
	f=0;
ELSE 
	IF nod>15 AND nod<30 THEN 
		f=5*nod;
	ELSE 
		IF nod>30 THEN 
		f=50*nod;
		END IF;
IF f<>0 THEN 
 	insert into fine values(roll ,sysdate(),f);
 END IF;
END
$$
delimiter ;
