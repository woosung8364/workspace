--1--
-- employees ���̺��� �޿��� 5000�̻� 15000���� ���̿� ���Ե��� �ʴ� 
--����� �����ȣ(employee_id), �̸�(last_name), �޿�(salary), �Ի�����(hire_date)�� ��ȸ�Ͻÿ�.

SELECT
    employee_id,
    last_name,
    salary,
    hire_date
FROM
    employees
WHERE
    salary NOT BETWEEN 5000 AND 15000;
    
--2--
--�μ���ȣ(department_id) 50, ����(job_id) 'ST_MAN', �Ի��� 2004-07-18���� 
--����� �����ȣ(employee_id), �̸�(last_name), ������ȣ(job_id), �Ի���(hire_date)�� ��ȸ�Ͻÿ�.
SELECT
    employee_id,
    last_name,
    job_id,
    hire_date
FROM
    employees
WHERE
        department_id = 50
    AND job_id = 'ST_MAN'
    AND hire_date = '2004/07/18';
    
--3--
-- 2002�� ���Ŀ�  �Ի��Ͽ���, ������ȣ�� 'ST_MAN' �Ǵ� 'ST_CLERK'�� ������� ��� �÷��� ��ȸ�Ͻÿ�.
SELECT
    *
FROM
    employees
WHERE
        hire_date > '2002/01/01'
    AND job_id = 'ST_MAN'
    OR job_id = 'ST_CLERK';
    
    
--4--
--���(manager_id)�� ���� ����� ��� �÷��� ��ȸ�Ͻÿ�.
SELECT
    *
FROM
    employees
WHERE
    manager_id IS NULL;


--5--
--����̸�(last_name)�� J, A �Ǵ� M���� �����ϴ� ��� ����� last_name�� salary�� ��ȸ�Ͻÿ�.(��, last_name �������� ��ȸ)

SELECT
    last_name,
    salary
FROM
    employees
WHERE
    ( last_name LIKE 'J%'
      OR last_name LIKE 'A%' )
    AND last_name LIKE 'M%'
ORDER BY
    last_name;
    
    
--6--
--�⵵�� �Ի��ο����� ��ȸ�Ͻÿ�
SELECT
    COUNT(hire_date),
    hire_date
FROM
    employees
GROUP BY
    hire_date
ORDER BY
    hire_date;


--7--
--�����ȣ(employee_id)�� Ȧ���� ����� ��� ������ ��ȸ�Ͻÿ�.

SELECT
    *
FROM
    employees
WHERE
    mod(employee_id, 2) = 1;
    
--8--
--8.���ú��� 6���� �� ���ƿ��� ù��° �ݿ����� ��¥�� ����Ͻÿ�
--(��¥ �������: 2002-06-05 15:23:10 �ݿ���)

SELECT
    TO_DATE (a,'YYYY/MM/DD HH24:MI:SS') t
FROM
    dual
WHERE
    t = (
        SELECT
            ADD_MONTHS(SYSDATE , 6) a
        FROM
            dual
    );









--9--
--�����ȣ(employee_id), �����(first_name), ����ȣ(manager_id)�� ��ȸ�ϵ�
--��簡 ����(NULL) ��� ����ȣ�� '�뻧'�̶� ����Ͻÿ�
  
  SELECT 
    e.employee_id ,
    e.first_name ,
    e.manager_id
    FROM
        employees e
    WHERE
        e.manager_id = (
            SELECT 
                d.manager_id
            FROM
                departments d
            WHERE
                d.manager_id=null
        );
    
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
--10--
--������� 3���౸������ �з��ϱ� ���� ����� 3���� ������
-- �������� 0�̸� "��ȭ�����"
--�������� 1�̸� "���׸���"
-- �������� 2�̸� "������" ���� �з��Ͽ� ���̸�, �����ȣ, ������� ����Ͻÿ�.

























--11--
--����� �޿��׷����� �Ʒ��� ���� ����Ͻÿ�(2�÷����� ���)






















--12--
--2002�� 3������ 2003�� 2�� �Ⱓ ���� �Ի��� ����� ������� �μ��� �ο����� ��ȸ�Ͻÿ�
--(����� �ο����� ���� ������� �����Ͽ� ���)














--13--
--������ ��� �޿��� ����϶�. ��, ��ձ޿��� 10000�� �ʰ��ϴ� ���� 
--�����ϰ� ��� �޿��� ���� ������������ �����Ͻÿ�.




















--14--
--14.������ ������� ���� �Ի��� ������� �Ʒ��� ���� ����Ͻÿ�.