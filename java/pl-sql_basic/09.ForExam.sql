BEGIN
    FOR i IN 0..9 LOOP
        dbms_output.put_line(i || ': ����� �ְ�');
    END LOOP;

  -- ��ø for ������ ���
    FOR i IN 2..9 LOOP
        FOR j IN 1..9 LOOP
            dbms_output.put(i || '*' || j || '=' || i * j || ' ');
        END LOOP;
        dbms_output.put_line(' ');
    END LOOP;

END;