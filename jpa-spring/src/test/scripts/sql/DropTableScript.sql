
ALTER TABLE INGREDIENT DROP CONSTRAINT INGREDIENTRECIPEID;
ALTER TABLE INGREDIENT DROP CONSTRAINT SQL_INGREDIENT_PK;
DROP INDEX SQL_INGREDIENT_IDX_01;
DROP INDEX SQL_INGREDIENT_IDX_02;
DROP TABLE INGREDIENT;

ALTER TABLE TAGS DROP CONSTRAINT FK_TAGS_RECIPE_ID;
DROP INDEX SQL_TAGS_IDX;
DROP TABLE TAGS;

ALTER TABLE RECIPE DROP CONSTRAINT SQL_RECIPE_PK;
DROP INDEX SQL_RECIPE_IDX_01;
DROP TABLE RECIPE;


