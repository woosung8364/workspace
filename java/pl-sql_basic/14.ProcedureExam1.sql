-- ���ν���(Procedure)
-- ���� ���Ǵ� PL/SQL �ڵ� ���� ������ �� �ֵ��� ���ȭ�Ͽ� DBMS�� �����ϰ� ���(ȣ��)
-- �μ���ȣ �Է� �޾� ������ ���
-- DDL �̿��Ͽ� ���ν��� ����
CREATE OR REPLACE PROCEDURE listbydeptno (p_deptno employees.department_id%TYPE) IS
    employee_row employees%ROWTYPE;
    CURSOR employee_cursor IS
    SELECT
        *
    FROM
        employees
    WHERE
        department_id = p_deptno;

BEGIN
    dbms_output.put_line('--- ��� ��� ---');
    FOR employee_row IN employee_cursor LOOP
    	--EXIT WHEN employee_cursor%NOTFOUND;
        dbms_output.put_line(p_deptno
                             || ','
                             || employee_row.employee_id
                             || ', '
                             || employee_row.first_name
                             || ', '
                             || employee_row.salary);
    END LOOP;

END;

-- SQLPlus*���� ���ν��� ����
--EXECUTE listByDeptno(100);