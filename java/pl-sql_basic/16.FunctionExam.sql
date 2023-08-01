-- �Լ�(function)�� ���ν����� ���� �������� �� �����ϰ� ���� �� �ְ�, SQL������ ȣ�Ⱑ���� ������ ������.
CREATE OR REPLACE FUNCTION getSalary (p_no employees.employee_id%TYPE) RETURN NUMBER IS
    v_salary NUMBER;
BEGIN
    SELECT
        salary
    INTO v_salary
    FROM
        employees
    WHERE
        employee_id = p_no;

    RETURN v_salary;
END;

-- SQLPlus* ����
--VARIABLE salary NUMBER;
--EXECUTE :salary := getSalary(100);

-- SQL���� �Լ� ����
--SELECT getSalary(100)
--FROM dual;