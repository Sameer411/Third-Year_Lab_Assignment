delimiter $$
create trigger before_book_delete
                after delete on Books
                for each row 
begin 
                insert into Library_Audit
                set action ='delete',
                Acc_no=OLD.Acc_no,
                Title=OLD.Title,
                Author=OLD.Author,
                Publisher=OLD.Publisher,
                Count=OLD.Count;                
END $$
DELIMITER ;
DELIMITER $$
create trigger before_book_update 
                before update on Books
                for each row
begin
                insert into Library_Audit
                set action ='update' ,                
                 Acc_no=OLD.Acc_no,
                Title=OLD.Title,
                Author=OLD.Author,
                Publisher=OLD.Publisher,
                Count=OLD.Count;
end $$
delimiter ;
DELIMITER $$
CREATE TRIGGER  before_book_issue
	AFTER INSERT ON issue
	FOR EACH ROW
BEGIN
	UPDATE Books
	SET Count =Count-1
	where Acc_no = NEW.Acc_no;
	end $$
	delimiter ;			
DELIMITER $$
CREATE TRIGGER  do_uppercase
	BEFORE INSERT ON Books
	FOR EACH ROW
BEGIN
	SET NEW.Author=UPPER(NEW.Author);
	end $$
	delimiter ;
