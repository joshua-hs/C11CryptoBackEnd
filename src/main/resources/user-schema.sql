drop table if exists user CASCADE;
create table user (id bigint generated by default as identity, available_capital double not null, name varchar(255), primary key (id));