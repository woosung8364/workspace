/*
 * Ŀ��(CURSOR)��?
 * SELECT���� ��������� �����ϱ� ���� ������ Ȯ���ϴ� �޸� ����
 * SELECT���� ��������� �������� ��� �ݵ�� Ŀ���� �̿��ؾ� �Ѵ�.
 */
DECLARE
	-- #1. Ŀ�� ����
    CURSOR department_cursor IS
    SELECT
        department_id,
        department_name,
        location_id
    FROM
        departments;
        
    --��������
    department_row department_cursor%rowtype;
BEGIN
	-- #2. Ŀ�� ����(���Ǹ� �����ϰ� ��� ������ ������ ��������� �����ϰ�,
    -- Ŀ���� ������� ù��°���� ����Ų��
    OPEN department_cursor;
    LOOP
        FETCH department_cursor INTO
              department_row.department_id,
              department_row.department_name,
              department_row.location_id;
        EXIT WHEN department_cursor%notfound;
        
        -- Ŀ���� �����ϴ� �Ӽ�: FOUND, NOTFOUND, ROWCOUNT
        dbms_output.put_line(department_row.department_id || ', ' || department_row.department_name
                             || ', ' || department_row.location_id);
    END LOOP;
    dbms_output.put_line(department_cursor%rowcount || '���� �˻��Ǿ����ϴ�.');

    -- #3.Ŀ�� �ݱ�
    CLOSE department_cursor;
END;