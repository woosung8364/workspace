--SET SERVEROUTPUT ON;
-- SQLPlus*���� ����� set serveroutput on; ���� �ʿ�...
-- �����
DECLARE
	-- ����
    v_no       NUMBER(3) := 10;
    -- ���
    c_message  CONSTANT VARCHAR2(50) := '�ȳ��ϼ���. PL/SQL!!!';
    v_hiredate VARCHAR2(30) := to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS');
-- �����
BEGIN
	-- dbms_output ��Ű���� put_line ���ν����� �̿��� ���ڿ� ���
    dbms_output.put_line('--- PL/SQL �ǽ��Դϴ�. ---');
    -- ���� ���    
    dbms_output.put_line(v_no);
    dbms_output.put_line(c_message);
    dbms_output.put_line(v_hiredate);
END;