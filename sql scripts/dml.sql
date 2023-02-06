USE hotelbookingsystemdb;

-- Get details of a speciﬁc Hotel
SELECT 
    hotel_id, hotel_name
FROM
    hotel
WHERE
    hotel_id = 1;

-- Get info of all customers of a speciﬁc Hotel
SELECT 
    c.customer_id, c.customer_f_name, c.customer_l_name
FROM
    customer c
        INNER JOIN
    hotel_customer hc ON c.customer_id = hc.customer_id
WHERE
    hc.hotel_id = 1;
    
-- Add a customer to a Hotel
INSERT INTO hotel_customer (hotel_id, customer_id) VALUES (2, 301);

-- Get details of a speciﬁc room of a speciﬁc Hotel
SELECT 
    r.room_type, r.room_desc
FROM
    room r
WHERE
    r.hotel_id = 1 AND r.room_id = 101; 

-- Get info of all customers in the System
SELECT 
    customer_id, customer_f_name, customer_l_name
FROM
    customer;

-- Get details of a speciﬁc customer in the system
SELECT 
    customer_id, customer_f_name, customer_l_name
FROM
    customer
WHERE
    customer_id = 302;

-- Get info of all Bills of a customer in the system
SELECT 
    bill_id, bill_date, bill_customer_name
FROM
    bill b
WHERE
    b.customer_id = 301; 

-- Get details of a speciﬁc Employee
SELECT 
    e.employee_f_name, e.employee_l_name
FROM
    employee e 
WHERE
    e.ssn = 403;
    
-- Get info of all bookings handled by a Employee
SELECT 
    b.booking_id,
    b.customer_id,
    b.hotel_id,
    b.room_id,
    b.booking_customer
FROM
    booking b
        INNER JOIN
    employee e ON b.ssn = e.ssn
WHERE
    e.ssn = 403;  

-- Modify details of a speciﬁc Booking
UPDATE booking 
SET 
    booking_vacate_date = '2022-04-04'
WHERE
    booking_id = 501;

-- Delete a Service from the system
START transaction;
DELETE FROM booking_service WHERE service_id = 204;
DELETE FROM hotel_service WHERE service_id = 204;
DELETE FROM service WHERE service_id = 204;
COMMIT;

-- Get info of all bookings that contain a speciﬁc service
SELECT 
    b.booking_id,
    b.customer_id,
    b.hotel_id,
    b.room_id,
    b.booking_customer
FROM
    booking b
        INNER JOIN
    booking_service bs ON b.booking_id = bs.booking_id
WHERE
    bs.service_id = 201;

-- Get info of all bookings of all hotels that have a rating of 5 stars
SELECT 
    b.booking_id,
    b.customer_id,
    b.hotel_id,
    b.room_id,
    b.booking_customer
FROM
    booking b
        INNER JOIN
    hotel h ON b.hotel_id = h.hotel_id
WHERE
    h.hotel_rating = 5;

