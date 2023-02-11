CREATE PROCEDURE `get_people_by_city`(IN cityParameter varchar(255))
BEGIN
    select * from persons where city = cityParameter;
END;

CREATE PROCEDURE `get_people_who_lives_in_tartu`()
BEGIN
    select * from persons where city='Tartu';
END;
