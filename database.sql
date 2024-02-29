create database BookStore
use BookStore

create table Book(
    id int IDENTITY PRIMARY KEY ,
    name nvarchar(200),
    photo nvarchar(200)
)

drop table Account
create table Account (
    id int IDENTITY primary key,
    name nvarchar(200),
    email nvarchar(200),
    password nvarchar(200),
    role nvarchar(200)
)

insert into Account values('phat','phat@gmail.com','123','user')
insert into Account values('admin','admin@gmail.com','123','admin')
delete Book
select *from Book 