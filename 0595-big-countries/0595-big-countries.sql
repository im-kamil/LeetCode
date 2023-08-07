# Write your MySQL query statement below
# SELECT name , population, area
#  FROM WORLD 
#  WHERE area > 3000000 OR population > 25000000
select name,population,area from world where (area>=3000000 or population>=25000000)