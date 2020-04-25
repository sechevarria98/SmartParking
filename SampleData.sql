delete from Userlogin;
delete from Customer;
delete from Member;
delete from ParkingLotA;
delete from ParkingLotB;
delete from ParkingLotC;

-- Sample Data for User/Customer;
insert into Userlogin (name, username, password) values ('Kevin', 'kcho12', '123cheesecake');
insert into Customer (credit_card, payment_address, license_number) values (1232348912345678, '123 Street Street', 'kcho1');

insert into Userlogin (name, username, password) values ('Sam', 'Sam24', 'randpass', 'Member' );
insert into Customer (credit_card, payment_address, license_number) values  (1234567565664562, '789 Main Street','sam1');


--Data for ParkingLot:
insert into ParkingLotA (2, 'Reserved', 'guest');








