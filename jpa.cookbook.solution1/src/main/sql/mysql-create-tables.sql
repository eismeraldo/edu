CREATE TABLE RECIPE (ID BIGINT NOT NULL, LASTUPDATE DATETIME, NOOFPERSON INTEGER NOT NULL, PREAMBLE VARCHAR(255), PREPARATION VARCHAR(255) NOT NULL, TITLE VARCHAR(200) NOT NULL, IMAGE_DESCRIPTION VARCHAR(50), IMAGE_URL VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE INGREDIENT (ID BIGINT NOT NULL, ANNOTATION VARCHAR(255), DESCRIPTION VARCHAR(255), QUANTITY VARCHAR(255), RECIPE_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE TAGS (RECIPE_ID BIGINT, TAGS VARCHAR(255));
ALTER TABLE INGREDIENT ADD CONSTRAINT FK_INGREDIENT_RECIPE_ID FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE (ID);
ALTER TABLE TAGS ADD CONSTRAINT FK_TAGS_RECIPE_ID FOREIGN KEY (RECIPE_ID) REFERENCES RECIPE (ID);
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME));
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0);