-- https://neetcode.io/problems/sql-customers-with-positive-revenue/question

SELECT customer_id
FROM customers
WHERE year = 2020 AND revenue > 0;