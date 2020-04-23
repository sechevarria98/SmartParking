--TEMPORARY
CREATE TABLE member (
	id SERIAL UNIQUE,
	name VARCHAR(90),
	username VARCHAR(90),
	password VARCHAR(90),
	mem_type VARCHAR(90)
);
