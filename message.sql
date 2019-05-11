prompt PL/SQL Developer import file
prompt Created on 2010��6��25�� by kaili.liu
set feedback off
set define off
prompt Creating MESSAGE...
create table MESSAGE
(
  ID         NUMBER(11) not null,
  TITLE      VARCHAR2(50) not null,
  USERNAME   VARCHAR2(20) not null,
  CONTENTS   VARCHAR2(255),
  CREATETIME DATE not null
)
tablespace ORDER_TABLESPACE
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table MESSAGE
  add primary key (ID)
  using index 
  tablespace ORDER_TABLESPACE
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for MESSAGE...
alter table MESSAGE disable all triggers;
prompt Deleting MESSAGE...
delete from MESSAGE;
commit;
prompt Loading MESSAGE...
insert into MESSAGE (ID, TITLE, USERNAME, CONTENTS, CREATETIME)
values (1, '��ӭ��', 'bdqn', '��ӭ��ѧϰ��������γ�', to_date('12-01-2007', 'dd-mm-yyyy'));
insert into MESSAGE (ID, TITLE, USERNAME, CONTENTS, CREATETIME)
values (2, '2008���˿�Ļʽ', 'lkl', '��Ļʽ�ǳ�����,��������,��������', to_date('09-08-2008', 'dd-mm-yyyy'));
insert into MESSAGE (ID, TITLE, USERNAME, CONTENTS, CREATETIME)
values (8, 'ss', 'dd', 'ss', to_date('25-06-2010 15:59:47', 'dd-mm-yyyy hh24:mi:ss'));
insert into MESSAGE (ID, TITLE, USERNAME, CONTENTS, CREATETIME)
values (7, '����60������ı�', 'С��', '���ı�չʾ���й����ӵ��۷磬����Ϊ֮��Ѫ����', to_date('25-06-2010 15:48:24', 'dd-mm-yyyy hh24:mi:ss'));
commit;
prompt 4 records loaded
prompt Enabling triggers for MESSAGE...
alter table MESSAGE enable all triggers;
set feedback on
set define on
prompt Done.
