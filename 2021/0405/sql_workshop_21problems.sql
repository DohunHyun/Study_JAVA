-- sql 실습

select @@autocommit;
set autocommit=false;
use world;

-- 1
select count(*) as '전체', count(indepYear) as '독립 연도 보유'
from country;

-- 2
select sum(lifeexpectancy) as '합계', round(avg(lifeexpectancy), 2) as '평균', 
max(lifeexpectancy) as '최대', min(lifeexpectancy) as '최소'
from country;

-- 3
select continent, count(*) as '국가 수', sum(population) as '인구 합'
from country
group by continent
order by count(*) desc;
-- order by '국가 수' desc; 는 왜 안될까

-- 4
select continent, sum(surfacearea) as '표면적 합'
from country
group by continent
order by sum(surfacearea) desc limit 3;

-- 5
select continent, sum(gnp) as 'gnp 합'
from country
where population >= 50000000
group by continent
order by sum(gnp);

-- 6
select continent, sum(gnp) as 'gnp 합'
from country
where population >= 50000000 
group by continent
having sum(gnp) > 5000000;
-- 이게 맞는건가...?

-- 7
select indepyear, count(*) as '독립 국가 수'
from country
group by indepyear
having count(*) >= 10 and indepyear is not null;

-- 8 over 함수?!
select continent, name, gnp, avg(gnp) over() '전세계 평균', 
avg(gnp) over(partition by continent) '대륙평균' 
from country;

-- 9 foreign key 때문. code가 다른 테이블 참조값인데 거기서 있어야함. 
insert into countrylanguage value('AAA', '외계어', 'F', '10');
insert into countrylanguage value('KOR', '외계어', 'F', '10');

-- 10 primary key -> (countrycode, language) 이므로 이미 있으면 불가능! 
insert into countrylanguage value('ABW', 'Dutch', 'F', '10');
select * from countrylanguage; -- 해보면 이미 abw, dutch 가 있음.
insert into countrylanguage value('ABW', 'Korean', 'F', '5');

-- 11 code가 길고, name이 없는데 default가 없고, not null 이라서 뭐라도 넣어줘야함! 
insert into country(code, name, region, code2) value("TCo", "haha", "TRegion", "TC");















