insert into "RECIPE" ("ID", "LASTUPDATE", "NOOFPERSON", "PREAMPLE", "PREPARATION", "TITLE", "IMAGE_DESCRIPTION", "IMAGE_URL") values(10001, '2014-01-22 23:03:20', 2, 'Preample', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque convallis lacus at sagittis scelerisque. Donec at mauris ac mi pharetra.', 'Dies und Das', null, null)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(100, '', 'Pfeffer', 'etwas', 10001)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(101, 'ev. Mehrsalz', 'Salz', 'priese', 10001)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(102, 'kalt gepresst', 'Olivenöl', '2 TL', 10001)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(103, '', 'Ingwer', 'nach Lust & Laune', 10001)
insert into "TAGS" ("RECIPE_ID", "TAGS") values(10001, 'vegetarisch')
insert into "TAGS" ("RECIPE_ID", "TAGS") values(10001, 'hauptgericht')
insert into "RECIPE" ("ID", "LASTUPDATE", "NOOFPERSON", "PREAMPLE", "PREPARATION", "TITLE", "IMAGE_DESCRIPTION", "IMAGE_URL") values(10002, '2014-01-28 23:03:20', 4, 'Rezept für Hungrige', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque convallis lacus at sagittis scelerisque. Donec at mauris ac mi pharetra.', 'Pasta für alle', null, null)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(200, '', 'Pasta', '250g', 10002)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(201, 'ev. Mehrsalz', 'Salz', '5EL', 10002)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(202, 'kalt gepresst', 'Olivenöl', '2 TL', 10002)
insert into "INGREDIENT" ("ID", "COMMENT", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(203, '', 'Pelati', 'eine Dose', 10002)
insert into "TAGS" ("RECIPE_ID", "TAGS") values(10002, 'fleisch')
insert into "TAGS" ("RECIPE_ID", "TAGS") values(10002, 'vorspeise')
