create database hwDB01;

use hwDB01;

-- 1
create table `product` (
	`code` char(3) not null,
    `title` varchar(16) not null,
    `price` int(11) not null,
    
    primary key (`code`)
);

-- 2
insert into `product` 
values ('1', '삼성 tv', '50000'),
		('2', '삼성 노트북', '30000'),
        ('3', '삼성 고오급 노트북', '40000'),
        ('4', '삼성 고오급 tv', '70000'),
        ('5', '삼성 냉장고', '100000');
        
-- 3
select code, title, (price*0.85) as 'price(15% 할인가)'
from product;

-- 4 
update product
set price = price*0.8
where title like '%tv%';

select code, title, price as 'price 20% 할인 후 가격'
from product
where title like '%tv%';

-- 5
select sum(price) as '총 가격'
from product;





