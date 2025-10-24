#https://leetcode.com/problems/employees-earning-more-than-their-managers/

select name as Employee from Employee e where e.salary > (select salary from Employee where id = e.managerId);

SELECT e.name AS Employee
FROM Employee AS e
JOIN Employee AS m ON e.managerId = m.id
WHERE e.salary > m.salary;