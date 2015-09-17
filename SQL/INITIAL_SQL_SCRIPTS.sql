create table customer (customer_id int(6) unsigned auto_increment primary key, 
first_name 			varchar(20), 
middle_name			varchar(20),
last_name 			varchar(20), 
guardian_name 		varchar(20),
created_by			varchar(20),
created_dt 			timestamp,
updated_by			varchar(20),
updated_dt			timestamp);

create table address (address_id int(6) unsigned auto_increment primary key, 
street				varchar(20), 
street2				varchar(20),
city	 			varchar(20), 
state		 		varchar(20),
pincode				varchar(20),
country				varchar(20),
created_by			varchar(20),
created_dt 			timestamp,
updated_by			varchar(20),
updated_dt			timestamp);

create table idcard (idcard_id int(6) unsigned auto_increment, 
customer_id			int(6) unsigned,
id_type				varchar(20), 
id_number			varchar(20),
created_by			varchar(20),
created_dt 			timestamp,
updated_by			varchar(20),
updated_dt			timestamp,
primary key 		(idcard_id),
constraint cus_fk foreign key (customer_id) 
references customer(customer_id) );

create table phone (phone_id int(6) unsigned auto_increment, 
phone_type			varchar(15),
phone_number		varchar(20), 
created_by			varchar(20),
created_dt 			timestamp,
updated_by			varchar(20),
updated_dt			timestamp,
primary key 		(phone_id));

create table receipts (receipt_id int(6) unsigned auto_increment, 
loan_amount			decimal(22,7),
loan_date			timestamp,
customer_id			int(6) unsigned,
address_id			int(6) unsigned,
phone_id			int(6) unsigned,
total_qty			integer,
killogram			decimal(15,3),
gram				decimal(15,3),
milligram			decimal(15,3),
return_date			timestamp,
idcard_id			int(6) unsigned,
created_by			varchar(20),
created_dt 			timestamp,
updated_by			varchar(20),
updated_dt			timestamp,
primary key 		(receipt_id),
constraint rcust_fk foreign key (customer_id) 
references customer(customer_id),
constraint radd_fk foreign key (address_id)
references address(address_id),
constraint rphone_fk foreign key (phone_id)
references phone(phone_id),
constraint ridcard_fk foreign key (idcard_id)
references idcard(idcard_id));

create table items (items_id int(6) unsigned auto_increment,
receipt_id 		int(6) unsigned,
item_name 		varchar(20),
item_qty 		integer,
created_by		varchar(20),
created_dt 		timestamp,
updated_by		varchar(20),
updated_dt		timestamp,
primary key 	(items_id),
constraint ireceipt_fk foreign key (items_id) 
references receipts(receipt_id));

create table customer_address (cus_addr_id int(6) unsigned auto_increment,
customer_id		int(6) unsigned,
address_id 		int(6) unsigned,
primary key 	(cus_addr_id),
constraint cs_cus_fk foreign key (customer_id) 
references customer(customer_id),
constraint cs_addr_fk foreign key (address_id) 
references address(address_id));

create table customer_phone (cus_phone_id int(6) unsigned auto_increment,
customer_id		int(6) unsigned,
phone_id 		int(6) unsigned,
primary key 	(cus_phone_id),
constraint cp_cus_fk foreign key (customer_id) 
references customer(customer_id),
constraint cp_ph_fk foreign key (phone_id) 
references phone(phone_id));

commit;
