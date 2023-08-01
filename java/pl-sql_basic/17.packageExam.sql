-- ��Ű�� - �����ִ� ���ν����� �Լ��� ȿ�������� �����ϱ� ���� ���ȭ

-- #1, ��Ű�� ����
CREATE OR REPLACE PACKAGE my_package IS
    PROCEDURE getEmployee (
        in_id      IN employees.employee_id%TYPE,
        out_id     OUT employees.employee_id%TYPE,
        out_name   OUT employees.first_name%TYPE,
        out_salary OUT employees.salary%TYPE
    );

    FUNCTION getSalary (
        vno IN employees.employee_id%TYPE
    ) RETURN NUMBER;

END;
/
-- ��Ű�� ���� ����
CREATE OR REPLACE PACKAGE BODY my_package IS
	-- ���ν��� ����
    PROCEDURE getEmployee (
        in_id      IN employees.employee_id%TYPE,
        out_id     OUT employees.employee_id%TYPE,
        out_name   OUT employees.first_name%TYPE,
        out_salary OUT employees.salary%TYPE
    ) IS
    BEGIN
        SELECT
            employee_id,
            first_name,
            salary
        INTO
            out_id,
            out_name,
            out_salary
        FROM
            employees
        WHERE
            employee_id = in_id;

    END;

	-- �Լ� ����
    FUNCTION getSalary (
        vno IN employees.employee_id%TYPE
    ) RETURN NUMBER IS
        vsalary NUMBER;
    BEGIN
        SELECT
            salary
        INTO vsalary
        FROM
            employees
        WHERE
            employee_id = vno;

        RETURN vsalary;
    END;

END;