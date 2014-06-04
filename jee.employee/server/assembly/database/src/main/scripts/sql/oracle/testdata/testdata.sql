-- INSERTING into ADDRESS
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (59,'Yellowknife','Canada','Y5J2N5','YK','1112 Gold Rush Rd.');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (65,'Montreal','Canada','Q2S5Z5','QUE','1 Canadien Place');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (67,'Arnprior','Canada','W1A2B5','ONT','1 Hawthorne Drive');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (68,'Perth','Canada','Y3Q2N9','ONT','234 Caledonia Lane');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (73,'Calgary','Canada','J5J2B5','AB','1111 Mooseland Rd.');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (78,'Smith Falls','Canada','C6C6C6','ONT','89 Chocolate Drive');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (86,'Victoria','Canada','Z5J2N5','BC','382 Hyde Park Blvd.');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (87,'Prince Rupert','Canada','K3K5D5','BC','3254 Parkway Place');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (88,'Metcalfe','Canada','Y4F7V6','ONT','2 Anderson Rd.');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (96,'Ottawa','Canada','K5J2B5','ONT','12 Merivale Rd., Suite 5');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (38,'Toronto','Canada','L5J2B5','ONT','1450 Acme Cr., Suite 4');
Insert into ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) values (56,'Vancouver','Canada','N5J2N5','BC','20 Mountain Blvd., Floor 53, Suite 6');
-- INSERTING into EMPLOYEE
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (65,'Sarah-Lou','Female','Smitty',1,to_timestamp('01.02.1996 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1993 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),null,67);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (85,'Fred','Male','Jones',1,to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),null,73);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (70,'John','Male','Way',1,null,to_timestamp('11.12.1991 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),null,68);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (96,'Jill','Female','May',1,null,to_timestamp('11.12.1991 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),null,87);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (50,'Bob','Male','Smith',1,to_timestamp('01.02.1996 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1993 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),70,38);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (56,'Marcus','Male','Saunders',1,to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('12.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),70,56);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (57,'Charles','Male','Chanley',1,to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),96,59);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (59,'Jim-Bob','Male','Jefferson',1,to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('12.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),96,65);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (86,'Emanual','Male','Smith',1,to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),70,78);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (88,'Betty','Female','Jones',1,to_timestamp('01.02.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('31.01.2002 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),70,86);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (97,'Nancy','Female','White',1,to_timestamp('01.02.1996 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.02.1993 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),59,88);
Insert into EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) values (98,'Sarah','Female','Way',1,to_timestamp('31.08.2001 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),to_timestamp('01.06.1995 00:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'),59,96);
-- INSERTING into DEGREE
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (61,'Bachelor Computer Science',56);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (63,'Masters Business',85);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (67,'Masters Engineering',88);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (68,'Bachelor Business',85);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (72,'PHD Computer Science',96);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (76,'PHD Philosophy',88);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (87,'Bachelor Computer Science',70);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (89,'Bachelor Computer Science',65);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (90,'Masters Computer Science',56);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (92,'Masters Computer Science',96);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (58,'Bachelor Arts',88);
Insert into DEGREE (DEGREE_ID,NAME,EMP_ID) values (60,'Bachelor Computer Science',96);
-- INSERTING into EMAIL
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (12,'Home','jim-bob@jim-bob.com',59);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (13,'Work','john.way@acme.com',70);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (14,'Work','charles.chanley@acme.com',57);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (15,'Work','emanual.smith@acme.com',86);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (16,'Home','sarah-lou.smitty@rogers.com',65);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (17,'Work','sarah.way@acme.com',98);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (18,'Work','fred.jones@acme.com',85);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (19,'Work','marcus.saunders@acme.com',56);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (20,'Work','nancy.white@acme.com',97);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (21,'Work','betty.jones@acme.com',88);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (22,'Home','betty.cleo.jones@rogers.com',88);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (10,'Work','jill.may@acme.com',96);
Insert into EMAIL (EMAIL_ID,EMAIL_TYPE,EMAIL_ADDRESS,EMP_ID) values (11,'Mobile','jill.lewis.may@sprint.com',96);
-- INSERTING into JOBTITLE
Insert into JOBTITLE (JOB_ID,TITLE) values (3,'Manager');
Insert into JOBTITLE (JOB_ID,TITLE) values (4,'Developer');
Insert into JOBTITLE (JOB_ID,TITLE) values (5,'Admin');
Insert into JOBTITLE (JOB_ID,TITLE) values (1,'CEO');
Insert into JOBTITLE (JOB_ID,TITLE) values (2,'VP');
-- INSERTING into EMP_JOB
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (50,4);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (56,5);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (59,2);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (65,2);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (70,3);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (85,2);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (88,5);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (96,1);
Insert into EMP_JOB (EMP_ID,TITLE_ID) values (97,5);
-- INSERTING into PROJECT
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (53,'S','A tool to help accounting query various things.','Accounting Query Tool',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (54,'S','A tool to help staff query various things.','Staff Query Tool',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (55,'L','A reporting application to report on the corporations database through TopLink.','Sales Reporting',1,70);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (66,'L','A PRS application to report on the corporations database through TopLink.','Problem Reporting System',1,57);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (73,'S','A PRS application to report on the corporations database through TopLink.','Problem Reporter',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (74,'S','A enterprise wide application to report on the corporations database through TopLink.','Enterprise',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (77,'L','A lightweight application to report on the corporations database through TopLink.','Light Reporter',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (80,'S','A management application to report on the corporations database through TopLink.','TOP-Employee Manager',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (81,'L','A management application to report on the corporations database through TopLink.','TOPEmployee Management',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (83,'S','A reporting application using JDK to report on the corporations database through TopLink.','Sales Reporter',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (84,'S','An ext--ely lightweight application to report on the corporations database through TopLink.','Feather Reporter',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (94,'L','A enterprise wide application to report on the corporations database through TopLink.','Enterprise System',1,57);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (51,'S','A tool to help marketing query various things.','Marketing Query Tool',1,null);
Insert into PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID) values (52,'S','A tool to help shipping query various things.','Shipping Query Tool',1,null);
-- INSERTING into LPROJECT
Insert into LPROJECT (PROJ_ID,BUDGET,MILESTONE) values (77,100.98,to_timestamp('25.12.1999 11:40:44.000000000','DD.MM.YYYY HH24:MI:SSXFF'));
Insert into LPROJECT (PROJ_ID,BUDGET,MILESTONE) values (81,4000.98,to_timestamp('12.11.1997 01:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'));
Insert into LPROJECT (PROJ_ID,BUDGET,MILESTONE) values (94,40.98,to_timestamp('06.09.1996 06:40:44.000000000','DD.MM.YYYY HH24:MI:SSXFF'));
Insert into LPROJECT (PROJ_ID,BUDGET,MILESTONE) values (55,5000,to_timestamp('11.11.1991 12:00:00.000000000','DD.MM.YYYY HH24:MI:SSXFF'));
Insert into LPROJECT (PROJ_ID,BUDGET,MILESTONE) values (66,101.98,to_timestamp('06.10.1997 01:40:44.000000000','DD.MM.YYYY HH24:MI:SSXFF'));
-- INSERTING into PHONE
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('ISDN','905','5553691',88);
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('Pager','976','5556666',86);
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('Work','613','5558812',96);
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('WorkFax','613','5555943',65);
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('Cellular','416','5551111',59);
Insert into PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) values ('Home','613','5551234',59);
-- INSERTING into PROJ_EMP
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (50,74);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (50,80);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (50,83);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (56,77);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (57,66);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (57,73);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (57,94);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (70,73);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (70,74);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (70,84);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (97,77);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (98,66);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (98,73);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (98,81);
Insert into PROJ_EMP (EMP_ID,PROJ_ID) values (98,83);
-- INSERTING into RESPONSE
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (50,'Water the office plants.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (50,'Maintain the kitchen facilities.',1);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (57,'Perform code reviews as required.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (86,'Have to fix the Database problem.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (98,'Write code documentation.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (56,'Write user specifications.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (70,'Hire people when more people are required.',0);
Insert into RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) values (70,'Lay off employees when less people are required.',1);
-- INSERTING into SALARY
Insert into SALARY (EMP_ID,SALARY) values (57,43000);
Insert into SALARY (EMP_ID,SALARY) values (59,50000);
Insert into SALARY (EMP_ID,SALARY) values (65,75000);
Insert into SALARY (EMP_ID,SALARY) values (70,53005);
Insert into SALARY (EMP_ID,SALARY) values (85,500000);
Insert into SALARY (EMP_ID,SALARY) values (86,49631);
Insert into SALARY (EMP_ID,SALARY) values (88,500001);
Insert into SALARY (EMP_ID,SALARY) values (96,56232);
Insert into SALARY (EMP_ID,SALARY) values (97,31000);
Insert into SALARY (EMP_ID,SALARY) values (98,87000);
Insert into SALARY (EMP_ID,SALARY) values (50,35000);
Insert into SALARY (EMP_ID,SALARY) values (56,54300);
