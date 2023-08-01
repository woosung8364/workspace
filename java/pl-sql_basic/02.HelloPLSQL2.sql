/*
 * Ư�� ���̺��� ���� �˻��Ͽ� ������ �Ҵ��� �� ������ �� ���
 */
DECLARE
    v_name     VARCHAR2(20);
    v_salary   NUMBER(8, 2);
    v_hiredate VARCHAR2(30);
BEGIN
    SELECT last_name, salary, to_char(hire_date, 'YYYY-MM-DD')
    INTO   v_name, v_salary,v_hiredate
    FROM   employees
    WHERE  employee_id = 104;

    dbms_output.put_line('=== ��� ���� ===');
    dbms_output.put_line(v_name || ', ' || v_salary || ', ' || v_hiredate);
END;