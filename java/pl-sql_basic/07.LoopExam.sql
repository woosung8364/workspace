/* �ݺ��� */
DECLARE
    i NUMBER := 0;
BEGIN
    LOOP
        i := i + 1;
      -- ����
        EXIT WHEN i >= 10;
        dbms_output.put_line(i);
    END LOOP;
END;