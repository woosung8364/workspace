/* PL/SQL ��� */
DECLARE
    v_no    NUMBER(2) := 5;
    v_score NUMBER(3) := 80;
BEGIN
  -- �ܼ� IF ~ END IF;
    IF v_no = 5 THEN
        dbms_output.put_line('5�Դϴ�..');
    END IF;

  -- IF ~ ELSE ~ END IF;
    IF v_no = 5 THEN
        dbms_output.put_line('5�Դϴ�..');
    ELSE
        dbms_output.put_line('5�� �ƴմϴ�.');
    END IF;

  -- ���� IF ~~ ELSEIF ~ END IF;
    IF v_score >= 90 THEN
        dbms_output.put_line('��');
    ELSIF v_score >= 80 THEN
        dbms_output.put_line('��');
    ELSIF v_score >= 70 THEN
        dbms_output.put_line('��');
    ELSIF v_score >= 60 THEN
        dbms_output.put_line('��');
    ELSE
        dbms_output.put_line('��');
    END IF;

END;