
/* Drop Tables */

DROP TABLE IF EXISTS admin_record;
DROP TABLE IF EXISTS career;
DROP TABLE IF EXISTS certification;
DROP TABLE IF EXISTS education;
DROP TABLE IF EXISTS school;
DROP TABLE IF EXISTS main;




/* Create Tables */

CREATE TABLE admin_record
(
	num int NOT NULL,
	empNo int NOT NULL,
	objectEmpNo int NOT NULL,
	recordDay timestamp NOT NULL,
	recordContent varchar(300) NOT NULL,
	PRIMARY KEY (num)
) WITHOUT OIDS;


CREATE TABLE career
(
	num int NOT NULL,
	empNo int NOT NULL,
	beforeEmp varchar(300) NOT NULL,
	startDay varchar(100) NOT NULL,
	endDay varchar(100) NOT NULL,
	title varchar(100),
	beforeWork varchar(300),
	retirement varchar(300),
	PRIMARY KEY (num)
) WITHOUT OIDS;


CREATE TABLE certification
(
	num int NOT NULL,
	empNo int NOT NULL,
	certificationName varchar(500) NOT NULL,
	acpDate varchar(100) NOT NULL,
	agency varchar(300),
	PRIMARY KEY (num)
) WITHOUT OIDS;


CREATE TABLE education
(
	num int NOT NULL,
	empNo int NOT NULL,
	institute varchar(500) NOT NULL,
	startDay varchar(100) NOT NULL,
	endDay varchar(100) NOT NULL,
	content varchar(500),
	PRIMARY KEY (num)
) WITHOUT OIDS;


CREATE TABLE main
(
	empNo int NOT NULL,
	name varchar(30) NOT NULL,
	residentNum varchar(100) NOT NULL,
	hiredate varchar(100) NOT NULL,
	phone varchar(200) NOT NULL,
	email varchar(200) NOT NULL,
	dept int NOT NULL,
	jobtitle int NOT NULL,
	skillCode varchar(300),
	skillGrade varchar(300),
	skill varchar(500),
	stateY int,
	stateDate varchar(200),
	adminY int,
	adminPw varchar(2000),
	PRIMARY KEY (empNo)
) WITHOUT OIDS;


CREATE TABLE school
(
	num int NOT NULL,
	empNo int NOT NULL,
	startDay varchar(100) NOT NULL,
	endDay varchar(100) NOT NULL,
	schoolName varchar(200) NOT NULL,
	major varchar(300),
	PRIMARY KEY (num)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE admin_record
	ADD FOREIGN KEY (empNo)
	REFERENCES main (empNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE career
	ADD FOREIGN KEY (empNo)
	REFERENCES main (empNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE certification
	ADD FOREIGN KEY (empNo)
	REFERENCES main (empNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE education
	ADD FOREIGN KEY (empNo)
	REFERENCES main (empNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE school
	ADD FOREIGN KEY (empNo)
	REFERENCES main (empNo)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



