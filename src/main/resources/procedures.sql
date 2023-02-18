CREATE PROCEDURE `get_people_by_city`(IN cityParameter varchar(255))
BEGIN
    select * from persons where city = cityParameter;
END;

CREATE PROCEDURE `get_people_who_lives_in_tartu`()
BEGIN
    select * from persons where city='Tartu';
END;

CREATE PROCEDURE `get_employee_with_personal_id` (IN p_personal_id varchar(11))
BEGIN
    select * from employee where personal_id = p_personal_id;
END;

