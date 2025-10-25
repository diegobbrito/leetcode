#https://leetcode.com/problems/customers-who-never-order/

SELECT c.name as Customers
FROM Customers  AS c
LEFT JOIN Orders AS o
ON c.id = o.customerId
WHERE o.customerId IS NULL;