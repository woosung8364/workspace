/* FOR...IN...LOOP...END LOOP;������ �ζ���Ŀ�� ����ϱ� */
DECLARE
    v_total_salary NUMBER := 0;
    v_row_count    NUMBER := 0;
BEGIN
    dbms_output.put_line('=======================================');
    dbms_output.put_line('�����ȣ, ����̸�, �޿�, ����ѱ޿�');
    dbms_output.put_line('=======================================');
    FOR employee_row IN (
        SELECT
            employee_id,
            first_name,
            salary
        FROM
            employees
    ) LOOP
        v_total_salary := v_total_salary + employee_row.salary;
        v_row_count := v_row_count + 1;
        dbms_output.put_line(employee_row.employee_id
                             || ',  '
                             || employee_row.first_name
                             || ',  '
                             || employee_row.salary
                             || ', '
                             || v_total_salary);
    END LOOP;

    dbms_output.put_line(v_row_count || '���� �˻��Ǿ����ϴ�.');
END;