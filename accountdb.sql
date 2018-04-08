create table accounts( accountids integer primary key, 
username varchar(24) not null,
passwords varchar(24) not null,
firstname varchar(24) not null,
lastname varchar(24) not null,
money integer not null);
insert into accounts(ACCOUNTIDS, username, passwords, firstname, lastname, money) values(2, 'ataylor8294', 'ataylor8294', 'andrew', 'taylor', 500);
select * from accounts;
create sequence account_sequence;
create or replace trigger account_insert before insert on accounts for each row
begin 
select account_sequence.nextval into :new.accountids from dual;
end;
/
commit;