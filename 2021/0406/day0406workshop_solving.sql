-- day0406 workshop 실습!
use world;
select @@autocommit;
set autocommit = false;

-- 1
select country.code, country.name
from country join city
on city.name = 'kabul'
where country.code = city.countrycode;

-- 2
select c.name, l.language, l.percentage
from country c join countrylanguage l
on c.code = l.countrycode
where l.percentage = 100
order by name;

-- 3
select city.name, l.language, c.name
from city join country c
on city.countrycode = c.code
join countrylanguage l
on l.countrycode = c.code
where l.isofficial = "T"
and city.name = 'amsterdam';

-- 4
select c.name, c.capital, city.name '수도', city.population '수도인구'
from country c join city
on c.code = city.countrycode
where c.name like "united%" and city.id = c.capital;

-- 5 ?? 모르겠다요 
select distinct c.name, ifnull(c.capital, ''), ifnull(city.name, "수도없음") '수도', ifnull(city.population, "수도없음") '수도 인구'
from country c left join city
on c.code = city.countrycode
where c.name like "united%" 
and (city.id = c.capital or c.capital is null);

-- 6
select count(*) "국가수"
from country c join countrylanguage l
on c.code = l.countrycode
where l.isofficial = "T"
and l.percentage > all (select l.percentage
						from countrylanguage l join country c
						on c.code = 'che' and c.code = l.countrycode
                        );
                        
-- 7
select l.language
from country c join countrylanguage l
on c.code = l.countrycode
where c.name = "south korea"
and l.isofficial = "t";

-- 8 ?? 
select countrycode "code", count(name) cnt
from city
group by code;

select c.name, c.code, t.cnt "도시개수"
from country c join (
						select countrycode "code", count(name) cnt
						from city
						group by code
					) t
on c.code = t.code
where c.name like "bo%";

-- 9 
select c.name, c.code, ifnull(t.cnt, "단독") "도시개수"
from country c left join (
						select countrycode "code", count(name) cnt
						from city
						group by code
					) t
on c.code = t.code
where c.name like "bo%";

-- 10
select countrycode, name, population
from city
where population = (
					select max(population)
                    from city
					);
                    
-- 11 
select co.name, co.code, ci.name, ci.population
from country co join city ci
on co.code = ci.countrycode
where ci.population = (
						select min(population)
                        from city
						);
                        
-- 12
select countrycode, name, population
from city 
where population > (
					select ci.population
					from city ci join country co
					on ci.countrycode = co.code
					where ci.name="seoul" and co.code="kor"
					);
				
select ci.population
from city ci join country co
on ci.countrycode = co.code
where ci.name="seoul" and co.code="kor";

select population
from city
where name="seoul" and countrycode = "kor";

-- 13
select name
from city
where name = 'san miguel';

select ci.countrycode, cl.language
from city ci join countrylanguage cl
using (countrycode)
where ci.name = 'san miguel' and cl.isofficial="t"
order by 1;







					















