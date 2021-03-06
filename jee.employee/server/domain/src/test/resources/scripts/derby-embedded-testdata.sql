INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (38,'Toronto','Canada','L5J2B5','ONT','1450 Acme Cr., Suite 4')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (56,'Vancouver','Canada','N5J2N5','BC','20 Mountain Blvd., Floor 53, Suite 6')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (59,'Yellowknife','Canada','Y5J2N5','YK','1112 Gold Rush Rd.')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (65,'Montreal','Canada','Q2S5Z5','QUE','1 Canadien Place')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (67,'Arnprior','Canada','W1A2B5','ONT','1 Hawthorne Drive')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (68,'Perth','Canada','Y3Q2N9','ONT','234 Caledonia Lane')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (73,'Calgary','Canada','J5J2B5','AB','1111 Mooseland Rd.')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (78,'Smith Falls','Canada','C6C6C6','ONT','89 Chocolate Drive')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (86,'Victoria','Canada','Z5J2N5','BC','382 Hyde Park Blvd.')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (87,'Prince Rupert','Canada','K3K5D5','BC','3254 Parkway Place')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (88,'Metcalfe','Canada','Y4F7V6','ONT','2 Anderson Rd.')
INSERT INTO ADDRESS (ADDRESS_ID,CITY,COUNTRY,P_CODE,PROVINCE,STREET) VALUES (96,'Ottawa','Canada','K5J2B5','ONT','12 Merivale Rd., Suite 5')
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (70,'John','Male','Way',1,NULL,TIMESTAMP('1991-12-11 00:00:00'),NULL,68)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (96,'Jill','Female','May',1,NULL,TIMESTAMP('1991-12-11 00:00:00'),NULL,87)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (50,'Bob','Male','Smith',1,TIMESTAMP('1996-02-01 00:00:00'),TIMESTAMP('1993-02-01 00:00:00'),70,38)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (56,'Marcus','Male','Saunders',1,TIMESTAMP('2002-01-31 00:00:00'),TIMESTAMP('1995-02-12 00:00:00'),70,56)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (57,'Charles','Male','Chanley',1,TIMESTAMP('2002-01-31 00:00:00'),TIMESTAMP('1995-02-01 00:00:00'),96,59)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (59,'Jim-Bob','Male','Jefferson',1,TIMESTAMP('2002-01-31 00:00:00'),TIMESTAMP('1995-02-12 00:00:00'),96,65)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (65,'Sarah-Lou','Female','Smitty',1,TIMESTAMP('1996-02-01 00:00:00'),TIMESTAMP('1993-02-01 00:00:00'),NULL,67)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (85,'Fred','Male','Jones',1,TIMESTAMP('2002-01-31 00:00:00'),TIMESTAMP('1995-02-01 00:00:00'),NULL,73)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (86,'Emanual','Male','Smith',1,TIMESTAMP('2002-01-31 00:00:00'),TIMESTAMP('1995-02-01 00:00:00'),70,78)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (88,'Betty','Female','Jones',1,TIMESTAMP('1995-02-01 00:00:00'),TIMESTAMP('2002-01-31 00:00:00'),70,86)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (97,'Nancy','Female','White',1,TIMESTAMP('1996-02-01 00:00:00'),TIMESTAMP('1993-02-01 00:00:00'),59,88)
INSERT INTO EMPLOYEE (EMP_ID,F_NAME,GENDER,L_NAME,VERSION,END_DATE,START_DATE,MANAGER_ID,ADDR_ID) VALUES (98,'Sarah','Female','Way',1,TIMESTAMP('2001-08-31 00:00:00'),TIMESTAMP('1995-06-01 00:00:00'),59,96)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (58,'Bachelor Arts',88)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (60,'Bachelor Computer Science',96)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (61,'Bachelor Computer Science',56)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (63,'Masters Business',85)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (67,'Masters Engineering',88)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (68,'Bachelor Business',85)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (72,'PHD Computer Science',96)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (76,'PHD Philosophy',88)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (87,'Bachelor Computer Science',70)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (89,'Bachelor Computer Science',65)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (90,'Masters Computer Science',56)
INSERT INTO DEGREE (DEGREE_ID,NAME,EMP_ID) VALUES (92,'Masters Computer Science',96)
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (10,'jill.may@acme.com',96,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (11,'jill.lewis.may@sprint.com',96,'Mobile')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (12,'jim-bob@jim-bob.com',59,'Home')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (13,'john.way@acme.com',70,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (14,'charles.chanley@acme.com',57,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (15,'emanual.smith@acme.com',86,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (16,'sarah-lou.smitty@rogers.com',65,'Home')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (17,'sarah.way@acme.com',98,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (18,'fred.jones@acme.com',85,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (19,'marcus.saunders@acme.com',56,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (20,'nancy.white@acme.com',97,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (21,'betty.jones@acme.com',88,'Work')
INSERT INTO EMAIL (EMAIL_ID,EMAIL_ADDRESS,EMP_ID,EMAIL_TYPE) VALUES (22,'betty.cleo.jones@rogers.com',88,'Home')
INSERT INTO JOBTITLE (JOB_ID,TITLE) VALUES (1,'CEO')
INSERT INTO JOBTITLE (JOB_ID,TITLE) VALUES (2,'VP')
INSERT INTO JOBTITLE (JOB_ID,TITLE) VALUES (3,'Manager')
INSERT INTO JOBTITLE (JOB_ID,TITLE) VALUES (4,'Developer')
INSERT INTO JOBTITLE (JOB_ID,TITLE) VALUES (5,'Admin')
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (50,4)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (56,5)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (59,2)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (65,2)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (70,3)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (85,2)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (88,5)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (96,1)
INSERT INTO EMP_JOB (EMP_ID,TITLE_ID) VALUES (97,5)
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (51,'S','A tool to help marketing query various things.','Marketing Query Tool',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (52,'S','A tool to help shipping query various things.','Shipping Query Tool',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (53,'S','A tool to help accounting query various things.','Accounting Query Tool',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (54,'S','A tool to help staff query various things.','Staff Query Tool',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (55,'L','A reporting application to report on the corporations database through TopLink.','Sales Reporting',1,70,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (66,'L','A PRS application to report on the corporations database through TopLink.','Problem Reporting System',1,57,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (73,'S','A PRS application to report on the corporations database through TopLink.','Problem Reporter',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (74,'S','A enterprise wide application to report on the corporations database through TopLink.','Enterprise',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (77,'L','A lightweight application to report on the corporations database through TopLink.','Light Reporter',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (80,'S','A management application to report on the corporations database through TopLink.','TOP-Employee Manager',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (81,'L','A management application to report on the corporations database through TopLink.','TOPEmployee Management',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (83,'S','A reporting application using JDK to report on the corporations database through TopLink.','Sales Reporter',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (84,'S','An extremely lightweight application to report on the corporations database through TopLink.','Feather Reporter',1,NULL,'active')
INSERT INTO PROJECT (PROJ_ID,PROJ_TYPE,DESCRIP,PROJ_NAME,VERSION,LEADER_ID,STATUS) VALUES (94,'L','A enterprise wide application to report on the corporations database through TopLink.','Enterprise System',1,57,'active')
INSERT INTO LPROJECT (PROJ_ID,BUDGET,MILESTONE) VALUES (55,5000.0,TIMESTAMP('1991-11-11 12:00:00'))
INSERT INTO LPROJECT (PROJ_ID,BUDGET,MILESTONE) VALUES (66,101.98,TIMESTAMP('1997-10-06 01:40:44'))
INSERT INTO LPROJECT (PROJ_ID,BUDGET,MILESTONE) VALUES (77,100.98,TIMESTAMP('1999-12-25 11:40:44'))
INSERT INTO LPROJECT (PROJ_ID,BUDGET,MILESTONE) VALUES (81,4000.98,TIMESTAMP('1997-11-12 01:00:00'))
INSERT INTO LPROJECT (PROJ_ID,BUDGET,MILESTONE) VALUES (94,40.98,TIMESTAMP('1996-09-06 06:40:44'))
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('Cellular','416','5551111',59)
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('Home','613','5551234',59)
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('ISDN','905','5553691',88)
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('Pager','976','5556666',86)
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('Work','613','5558812',96)
INSERT INTO PHONE (TYPE,AREA_CODE,P_NUMBER,EMP_ID) VALUES ('WorkFax','613','5555943',65)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (50,74)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (50,80)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (50,83)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (56,77)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (57,66)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (57,73)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (57,94)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (70,73)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (70,74)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (70,84)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (97,77)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (98,66)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (98,73)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (98,81)
INSERT INTO PROJ_EMP (EMP_ID,PROJ_ID) VALUES (98,83)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (70,'Hire people when more people are required.',0)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (70,'Lay off employees when less people are required.',1)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (50,'Water the office plants.',0)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (50,'Maintain the kitchen facilities.',1)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (57,'Perform code reviews as required.',0)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (86,'Have to fix the Database problem.',0)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (98,'Write code documentation.',0)
INSERT INTO RESPONSE (EMP_ID,RESPONSIBILITY,PRIORITY) VALUES (56,'Write user specifications.',0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (50,35000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (56,54300.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (57,43000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (59,50000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (65,75000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (70,53005.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (85,500000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (86,49631.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (88,500001.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (96,56232.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (97,31000.0)
INSERT INTO SALARY (EMP_ID,SALARY) VALUES (98,87000.0)
