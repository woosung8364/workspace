DECLARE
  -- ���۷��� Ÿ��(ROWTYPE)
    v_employee_row   employees%rowtype; -- ����ü ����
    v_department_name departments.department_name%TYPE;
BEGIN
  -- ���� ������� �ʾƵ� ��..
    SELECT    *
    INTO  v_employee_row
    FROM  employees
    WHERE first_name = 'Lisa';

    SELECT  department_name
    INTO    v_department_name
    FROM    departments
    WHERE   department_id = v_employee_row.department_id;

    dbms_output.put_line('====== ��� ���� ======');
    dbms_output.put_line(v_employee_row.employee_id || ', ' || v_employee_row.last_name || ', ' || v_department_name);

END;