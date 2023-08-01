-- ���ν��� �Ű����� ó��
-- �����ȣ �Է¹޾� �޾� �����ȣ, �̸�, �޿� ��ȯ
CREATE OR REPLACE PROCEDURE findemployeebyno (
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

-- SQLPlus*���� ���ν��� ����
-- ��ȯ���� �ޱ� ���� ��������
/*
VAR b_id NUMBER;
VAR b_name VARCHAR2(20);
VAR b_salary NUMBER;

EXECUTE findEmployeeByNo(100, :b_id, :b_name, :b_salary);
-- ������ ���
print b_id;
*/