use ssafydb;

select e.employee_id, e.first_name, e.salary, j.job_title, d.department_name
from employees e join jobs j
on e.job_id = j.job_id
join departments d
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id
where lcase(city) = lcase('Seattle')
order by salary desc;

select *
from employees
where department_id is null;

select e.employee_id, e.first_name, ifnull(d.department_name, '대기발령중')
from employees e left outer join departments d
on e.department_id = d.department_id;

-- 회사의 모든 부서에 근무하는 사원의 부서번호, 부서이름, 사번, 이름
select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e right outer join departments d
on d.department_id = e.department_id;

-- 이름이 scott인 사원의 부서번호와 부서이름을 직원명과 함께 조회하세요
select d.department_id, d.department_name, e.first_name
from employees e join departments d
on e.first_name = "Nancy" and d.department_id = e.department_id;













-- 1) join 안쓰기

-- 2) join on 쓰기

-- 3) join using 쓰기 (가능한경우)

-- 4) natural join 쓰기 (가능한경우)

-- 1. 모든 사원의 이름과 소속된 부서이름과 지역명을 조회하세요
-- 1) join 안쓰기
select e.first_name, d.department_name, l.city
from employees e, locations l, departments d
where e.department_id = d.department_id
and d.location_id = l.location_id;

-- 2) join on 쓰기
select e.first_name, d.department_name, l.city
from employees e join locations l join departments d
on e.department_id = d.department_id and d.location_id = l.location_id;

-- 3) join using 쓰기 (가능한경우)
select e.first_name, d.department_name, l.city
from employees e join departments d
using (department_id)
join locations l 
using (location_id);

-- 4) natural join 쓰기 (가능한경우)


-- 2. 10번 부서에 속하는 모든 담당 업무(job)를 중복이 있다면 한번만 표시, 부서의 지역명을 포함하여 조회
-- 1) join 안쓰기
select d.department_name, j.job_title, l.city
from departments d, locations l, jobs j
where d.department_id = 10;

-- 2) join on 쓰기
select d.department_name, j.job_title, l.city
from departments d join locations l join jobs j
on d.department_id = 10;

-- 3) join using 쓰기 (가능한경우)

-- 4) natural join 쓰기 (가능한경우)








