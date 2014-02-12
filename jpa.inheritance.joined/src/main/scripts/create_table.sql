CREATE TABLE PERSON (
	ID INTEGER PRIMARY KEY,
	PERSON_NR INTEGER NOT NULL,
	PERSON_TYPE CHAR(2) NOT NULL
); 

CREATE TABLE JP (
	ID INTEGER PRIMARY KEY,
	LEGALFORM VARCHAR(255),
	FOREIGN KEY (ID) REFERENCES PERSON(ID)
); 

CREATE TABLE NP (
	ID INTEGER PRIMARY KEY,
	LASTNAME VARCHAR(255),
	FOREIGN KEY (ID) REFERENCES PERSON(ID)
); 