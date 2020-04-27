delete from Userlogin;
delete from Customer;
delete from Member;
delete from ParkingLotA;
delete from ParkingLotB;
delete from ParkingLotC;

-- Sample Data for User
insert into Userlogin (name, username, password) values ('Kevin', 'kcho12', '123cheesecake');
insert into Userlogin (name, username, password, mem_type) values ('Sam', 'Sam24', 'randpass', 'Member' );

-- Sample Data for Customer
insert into Customer (id, credit_card, payment_address, license_number) values (( Select userLogin.id From userLogin Where name = 'Kevin'), 1232348912345678, '123 Street Street', 'kcho1');
insert into Customer (id, credit_card, payment_address, license_number) values (( Select userLogin.id From userLogin Where name = 'Sam'), 1234567565664562, '789 Main Street','sam1');

-- Sample Data for Member
Insert Into Member(id) Values(( Select userLogin.id From userLogin Where name = 'Sam'));

--Data for ParkingLot:
insert into ParkingLotA values(2, 'Reserved', 'guest', 'Apr 28, 2020', 1, 30);
insert into ParkingLotB values(1, 'Reserved', 'guest', 'Apr 28, 2020', 1, 30);
insert into ParkingLotC values(1, 'Reserved', 'guest', 'Apr 28, 2020', 1, 30);


