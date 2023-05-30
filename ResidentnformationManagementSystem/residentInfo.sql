CREATE TABLE residentInfo(
	id		int			PRIMARY KEY,
	name	VARCHAR(10)	NOT NULL,
	tel		CHAR(20)	NOT NULL,
	address	int			NOT NULL,
	members	CHAR(10)	NOT NULL

);


INSERT INTO residentInfo (id, name, tel, address, members)
VALUES(1, 'Anna', '01012341234',201,'5' ),
(2, 'Bela', '01012345678',202,'7' ),
(3, 'Candy', '01012346789',203,'4' ),
(4, 'sandy', '01012349876',204,'3' )
;

INSERT INTO residentInfo (id, name, tel, address, members)
VALUES(5, 'Anna', '01067897891',303,'3' );


INSERT INTO residentInfo (id, name, tel, address, members)
VALUES(6, 'Anna', '01012341234',301,'5' ),
(7, 'Bela', '01012345678',302,'7' ),
(8, 'Candy', '01012346789',401,'3' ),
(9, 'sandy', '01012349876',402,'3' )
;

DELETE FROM residentInfo WHERE id=?;

UPDATE residentInfo SET tel=?,address=?, members=? WHERE id=?;

SELECT * FROM residentInfo WHERE id=?;

SELECT * FROM residentInfo WHERE address=?;

SELECT * FROM residentInfo WHERE name=?;

SELECT * FROM residentInfo;




