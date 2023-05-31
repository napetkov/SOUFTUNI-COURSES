delimiter $$
create function ufn_select_5()
    returns int
    deterministic
begin
    return (select 5);
end$$
delimiter ;
;



delimiter $$
create function count_employees_by_town(`town_name` varchar(50))
    returns int
    deterministic
begin
    declare e_count int;
    set e_count := (select count(*)
            from employees as e
                     join addresses as a on e.address_id = a.address_id
                     join towns t on a.town_id = t.town_id
            where t.name = town_name);
    return e_count;
end $$

delimiter ;
;
select count_employees_by_town('Sofia') as count;
select name, count_employees_by_town(name) as count from towns;
