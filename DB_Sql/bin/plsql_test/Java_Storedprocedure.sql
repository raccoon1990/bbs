
CREATE OR REPLACE procedure java_stored_proc(
	
	v_id IN member2.id%TYPE,
	v_pw IN member2.passwd%TYPE,
	v_name IN member2.name%TYPE,
	v_age IN member2.age%TYPE,
	v_addr IN member2.addr%TYPE,
	v_email IN member2.email%TYPE
)
IS

BEGIN
	
	INSERT INTO member2 values(v_id, v_pw, v_name, v_age, v_addr, v_email);
	
END ;