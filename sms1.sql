create database sms;

drop database sales;

create table sms.Customer(
	customer_id int primary key auto_increment,
    customer_name varchar(255) not null
);

create table sms.Employee(
	employee_id int auto_increment primary key,
    employee_name varchar(255) not null,
    salary decimal(10,2) not null,
    supervisor_id int,
    
    -- khóa ngoại của customer
    constraint fk_supervisor
    foreign key (supervisor_id)
    references Customer(customer_id)
    on update cascade
);


create table sms.Product(
	product_id int auto_increment primary key,
    product_name varchar(255) not null,
    list_price decimal(10,2) not null
);

create table sms.Orders(
	order_id int auto_increment primary key, 
	order_date datetime not null,
    total decimal(10,2),
    customer_id int,
    employee_id int,
    
      -- khóa ngoại của customer 
    constraint fk_customer 
    foreign key (customer_id)
    references Customer (customer_id)
    on update cascade,
    
    -- khóa ngoại của employee 
    constraint  fk_employee
    foreign key (employee_id)
    references Employee (employee_id)
    on update cascade
);



create table sms.LineItem(
	quantity int not null,
    price decimal(10,3),
    order_id int,
    product_id int,
    -- khóa ngoại của order
    constraint fk_order
    foreign key (order_id)
    references Orders (order_id)
    on update cascade,
    
    -- khóa ngoại của product
    constraint fk_product
    foreign key (product_id)
    references Product (product_id)
    on update cascade
    
);

-- nhập thông tin cho bảng  Customer
insert into Customer (customer_name) values ("Nguyễn Thành Đạt");
insert into Customer (customer_name) values ("Trần Văn Hưng");
insert into	customer (customer_name) values ("Lê Hoàn Minh Tiến");
-- xuất bảng và kiểm tra thông tin vừa nhập
select * from Customer;

-- Nhập thông tin cho bảng Employee
insert into employee(employee_name,salary) values 
("Trần Văn Giàu",5000000),
("Cao Văn Viễn",5000000);
-- xuất bảng và kiểm tra thông tin
select * from Employee;

-- Nhập thông tin cho bảng Product
insert into product(product_name,list_price) values
("xà bông",100000),
("sữa tắm",250000),
("nước rửa chén", 50000),
("dầu gội đầu", 120000);
-- xuất bảng và kiểm tra thông tin
select * from Product;

-- Nhập thông tin cho bảng Orders
insert into orders(order_date,total,customer_id,employee_id) values
('2025-12-29',300000,1,2),
('2025-12-29',350000,1,1),
('2025-12-29',370000,2,2),
('2025-12-29',50000,2,2);
-- Xuất bảng và kiểm tra thông tin
delete from sms.Orders;
select * from Orders;

-- Nhập thông tin cho bảng LineItem
insert into lineitem(quantity,price,order_id,product_id) values
(1,250000,1,2),
(1,50000,1,3),
(1,100000,2,1),
(1,250000,2,2),
(1,250000,3,2),
(1,120000,3,4),
(1,50000,4,3);
-- xuất bảng và kiểm tra thông tin
delete from sms.LineItem;
select * from LineItem;


-- bài 1
select distinct Customer.customer_id, Customer.customer_name 
	from Customer
	INNER JOIN Orders 
		ON Customer.customer_id = Orders.customer_id;

-- bài 2
select * from sms.Orders where customer_id=1;

-- bài 3
select * from sms.LineItem where order_id=1;

-- bài 4
DELIMITER //
create function tinhtong(pro_order_id int)
returns decimal(10,2)
DETERMINISTIC
begin
	declare tong decimal(10,2);
    select sum(quantity*price)
	into tong 
    from lineitem where order_id = pro_order_id;
    return ifnull(tong,0);
    end//
DELIMITER ;
select * from lineitem;
SELECT tinhtong(3);

-- bài 5
DELIMITER //
create procedure c_add_customer(add_name varchar(255))
begin
	insert into customer(customer_name) value (add_name);
end//
DELIMITER ;
call c_add_customer("Nguyễn Phùng Ái Gia");
select * from customer;

-- bài 6
DELIMITER //
create procedure del_customer_id (del_customer int)
begin
	delete from lineitem where order_id in (select order_id from orders where customer_id=del_customer);
    delete from Orders where customer_id = del_customer;
    delete from Customer where customer_id = del_customer;
    end//
DELIMITER ;

-- drop procedure del_customer_id;
-- select * from sms.lineitem ;
-- select * from sms.lineitem where order_id in (select order_id from orders where customer_id=2);
-- select * from sms.orders;
-- select * from sms.customer;

SET SQL_SAFE_UPDATES = 0;
call del_customer_id (2);


-- bài 7
use sms;
DELIMITER //
create procedure upd_customer_id (upd_customer varchar(255), upd_customer_id int)
begin
	update customer
    set customer_name = upd_customer 
    where customer_id= upd_customer_id;
end//

DELIMITER ;
call upd_customer_id ("Huỳnh Công Hậu", 4);
select * from customer;

-- bài 8
insert into orders(order_date,total,customer_id,employee_id) value(curdate(),300000,3,2);
select * from orders;

-- bài 9
insert into lineitem(quantity,price,order_id,product_id) value (2,50000,33,3);
select *from lineitem;

-- bài 10
update orders set total = tinhtong(33) where order_id=33;
