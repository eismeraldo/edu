ALTER TABLE PROJECT DROP CONSTRAINT FK_PROJECT_LEADER_ID
ALTER TABLE PHONE DROP CONSTRAINT FK_PHONE_EMP_ID
ALTER TABLE LPROJECT DROP CONSTRAINT FK_LPROJECT_PROJ_ID
ALTER TABLE EMPLOYEE DROP CONSTRAINT FK_EMPLOYEE_MANAGER_ID
ALTER TABLE EMPLOYEE DROP CONSTRAINT FK_EMPLOYEE_ADDR_ID
ALTER TABLE SALARY DROP CONSTRAINT FK_SALARY_EMP_ID
ALTER TABLE DEGREE DROP CONSTRAINT FK_DEGREE_EMP_ID
ALTER TABLE EMP_JOB DROP CONSTRAINT FK_EMP_JOB_EMP_ID
ALTER TABLE EMP_JOB DROP CONSTRAINT FK_EMP_JOB_TITLE_ID
ALTER TABLE EMAIL DROP CONSTRAINT FK_EMAIL_EMP_ID
ALTER TABLE RESPONS DROP CONSTRAINT FK_RESPONS_EMP_ID
ALTER TABLE PROJ_EMP DROP CONSTRAINT FK_PROJ_EMP_EMP_ID
ALTER TABLE PROJ_EMP DROP CONSTRAINT FK_PROJ_EMP_PROJ_ID
DROP TABLE PROJECT
DROP TABLE PHONE
DROP TABLE LPROJECT
DROP TABLE EMPLOYEE
DROP TABLE SALARY
DROP TABLE ADDRESS
DROP TABLE JOBTITLE
DROP TABLE DEGREE
DROP TABLE EMP_JOB
DROP TABLE EMAIL
DROP TABLE RESPONS
DROP TABLE PROJ_EMP
DROP SEQUENCE SEQ_GEN_SEQUENCE
