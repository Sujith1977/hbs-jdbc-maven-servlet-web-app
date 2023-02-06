USE hotelbookingsystemdb;

select * from hotel;
select * from customer;
select * from hotel_customer;
select * from room;
select * from bill;
select * from booking;
insert into bill (customer_id, booking_id, bill_date, bill_customer_name) values (301, 511, "2022-05-07", "deepak sreeraj");
delete from bill where customer_id = 301 and bill_customer_name = "deepak sreeraj";
select * from employee;
select * from service;
select * from hotel_service;
select * from booking_service;