use EmployeeDB;
CREATE TABLE `user_history` ( `id` INT PRIMARY KEY AUTO_INCREMENT, `userId` INT, `token` VARCHAR(50), `login_date` DATE, `rowAddTime` DATETIME DEFAULT CURRENT_TIMESTAMP, `active_status` INT ); 

create table request(id INT PRIMARY KEY AUTO_INCREMENT,emp_id int, courseid int, rowAddTime datetime DEFAULT CURRENT_TIMESTAMP,foreign key (emp_id) references employee(emp_id),foreign key (courseid) references course(courseid));

delimiter #
create trigger user_au
after update on user 
for each row
	begin
	if
		(new.token is null)
	then
		insert into user_history(userId,token,login_date) values(old.user_id,old.token,old.login_date);
	end if;
end #