ALTER TABLE INGREDIENT DROP CONSTRAINT INGREDIENTRECIPEID;
ALTER TABLE TAGS DROP CONSTRAINT FK_TAGS_RECIPE_ID;
DROP TABLE RECIPE;
DROP TABLE INGREDIENT;
DROP TABLE TAGS;
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN';
DROP TABLE SEQUENCE;
