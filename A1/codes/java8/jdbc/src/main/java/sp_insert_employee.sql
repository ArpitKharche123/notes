CREATE OR REPLACE PROCEDURE sp_insert_employee(
	e_name varchar,
	e_dept varchar,
	e_gender char
)
LANGUAGE PLPGSQL
AS $$
BEGIN
	INSERT INTO employee(name,dept,gender)
	VALUES(e_name,e_dept,e_gender);
END;
$$;
CREATE OR REPLACE PROCEDURE sp_insert_employee(
	e_name varchar,
	e_dept varchar,
	e_gender char
)
LANGUAGE PLPGSQL
AS $$
BEGIN
	INSERT INTO employee(name,dept,gender)
	VALUES(e_name,e_dept,e_gender);
END;
$$;
