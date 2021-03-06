insert into "RECIPE" ("UUID", "LASTUPDATE", "ADDINGDATE", "NOOFPERSON", "PREAMPLE", "PREPARATION", "TITLE", "IMAGE_DESCRIPTION", "IMAGE_URL", "RATING", "VERSION") values('FF00-AA', '2014-01-22 23:03:20', '2014-01-22 23:03:20', '2', 'Preample', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque convallis lacus at sagittis scelerisque. Donec at mauris ac mi pharetra.', 'Dies und Das', null, null, 2, 1);
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(100, null, 'Pfeffer', 'etwas', 'FF00-AA');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(101, 'ev. Mehrsalz', 'Salz', 'priese', 'FF00-AA');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(102, 'kalt gepresst', 'Olivenöl', '2 TL', 'FF00-AA');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(103, null, 'Ingwer', 'nach Lust & Laune', 'FF00-AA');
insert into "TAGS" ("RECIPE_ID", "TAGS") values('FF00-AA', 'vegetarisch');
insert into "TAGS" ("RECIPE_ID", "TAGS") values('FF00-AA', 'hauptgericht');
insert into "RECIPE" ("UUID", "LASTUPDATE", "ADDINGDATE", "NOOFPERSON", "PREAMPLE", "PREPARATION", "TITLE", "IMAGE_DESCRIPTION", "IMAGE_URL", "RATING", "VERSION") values('FF00-BB', '2014-01-28 23:03:20', '2014-01-22 23:03:20', '4', 'Rezept für Hungrige', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque convallis lacus at sagittis scelerisque. Donec at mauris ac mi pharetra.', 'Pasta für alle', null, null, 4, 1);
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(200, null, 'Pasta', '250g', 'FF00-BB');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(201, 'ev. Mehrsalz', 'Salz', '5EL', 'FF00-BB');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(202, 'kalt gepresst', 'Olivenöl', '2 TL', 'FF00-BB');
insert into "INGREDIENT" ("ID", "ANNOTATION", "DESCRIPTION", "QUANTITY", "RECIPE_ID") values(203, null, 'Pelati', 'eine Dose', 'FF00-BB');
insert into "TAGS" ("RECIPE_ID", "TAGS") values('FF00-BB', 'vegetarisch');
insert into "TAGS" ("RECIPE_ID", "TAGS") values('FF00-BB', 'vorspeise');
