DROP SCHEMA IF EXISTS `book_db` ;
CREATE SCHEMA IF NOT EXISTS `book_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `book_db` ;

drop table if exists `book_db`.`book_tb`;
create table if not exists `book_db`.`book_tb` (
	`bnum` int(11) not null auto_increment,
    `btitle` varchar(50),
    `bcontent` varchar(50),
    `bwriter` varchar(50),
primary key(`bnum`));

insert into book_tb(btitle, bcontent, bwriter) values('abc', 'english', 'american');

select * from book_tb;
