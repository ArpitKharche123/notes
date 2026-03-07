CREATE OR REPLACE FUNCTION fn_count_by_gender(
e_gender char
)
RETURNS INT
LANGUAGE SQL
AS $$
	SELECT COUNT(*)
	FROM employee
	WHERE gender=e_gender;
$$;