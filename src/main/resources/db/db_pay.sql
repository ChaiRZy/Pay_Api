create DATABASE db_pay;
use db_pay;
#1、支付日志
create table paylog(id int primary key auto_increment,oid varchar(64),content varchar(20),creaatetime datetime,flag int);
#2、预支付信息
create table prepayment(id int primary key auto_increment,oid varchar(64),type int, 
				money int,
				result	int,
				qrcodeurl varchar(200),
				createtime datetime);
#3、支付结果
create table payresult(id int primary key auto_increment,oid varchar(64),type int, 
				flag int,
				createtime datetime,
				paytime datetime);
#4、支付二维码
create table payrcode(id int primary key auto_increment,poid int, 
				qrcode text,
                hours int,
				createtime datetime,flag int);