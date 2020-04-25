--TEMPORARY
CREATE TABLE Userlogin (
	id SERIAL UNIQUE,
	name VARCHAR(90),
	username VARCHAR(90),
	password VARCHAR(90),
	mem_type VARCHAR(90) Default 'Non-member'
);

create table Customer(
	 id SERIAL UNIQUE,
	 credit_card numeric(16,0) not null,
	 payment_address varchar(100) not null,
	 license_number VARCHAR(5) not null,
	 hourlyFee numeric (10,0) Default 5.00,
	 foreign key(id) references Userlogin (id)
	);

--Once a customer decides to be a member then their id serial is entered into the member table. Their hourlyFee is replaced with monthlyFee.
create table Member(
	id numeric (5,0),
	monthlyFee numeric(10,0) Default 10.00,
	tempPlate1 varchar(5) Default 'None',
	tempPlate2 varchar(5) Default 'None'
);

--All ParkingLots have 5 spaces in total that are by default not reserved.
create table ParkingLotA(
	 parkingspace numeric(1,0) not null,
	 status varchar(100) Default 'Not reserved',
	 license_number VARCHAR(5) Default 'None'
	);

create table ParkingLotB(
	 parkingspace numeric(1,0) not null,
	 status varchar(100) Default 'Not reserved',
	 license_number VARCHAR(5) Default 'None'
	);
	
create table ParkingLotC(
	 parkingspace numeric(1,0) not null,
	 status varchar(100) Default 'Not reserved',
	 license_number VARCHAR(5) Default 'None'
	);
	
