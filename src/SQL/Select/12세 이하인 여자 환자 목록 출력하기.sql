/*
���� ����
������ ���պ����� ��ϵ� ȯ�������� ���� PATIENT ���̺��Դϴ�. PATIENT ���̺��� ������ ������ PT_NO, PT_NAME, GEND_CD, AGE, TLNO�� ���� ȯ�ڹ�ȣ, ȯ���̸�, �����ڵ�, ����, ��ȭ��ȣ�� �ǹ��մϴ�.

Column name	Type	Nullable
PT_NO	VARCHAR(10)	FALSE
PT_NAME	VARCHAR(20)	FALSE
GEND_CD	VARCHAR(1)	FALSE
AGE	INTEGER	FALSE
TLNO	VARCHAR(50)	TRUE
����
PATIENT ���̺��� 12�� ������ ����ȯ���� ȯ���̸�, ȯ�ڹ�ȣ, �����ڵ�, ����, ��ȭ��ȣ�� ��ȸ�ϴ� SQL���� �ۼ����ּ���. �̶� ��ȭ��ȣ�� ���� ���, 'NONE'���� ��½��� �ֽð� ����� ���̸� �������� �������� �����ϰ�, ���� ���ٸ� ȯ���̸��� �������� �������� �������ּ���.
*/

--     https://school.programmers.co.kr/learn/courses/30/lessons/132201


-- �ڵ带 �Է��ϼ���
SELECT pt_name,
       pt_no,
       gend_cd,
       age,
       nvl(tlno,'NONE') AS tlno
FROM patient
WHERE age <= 12 AND gend_cd = 'W'
ORDER BY age desc, pt_name