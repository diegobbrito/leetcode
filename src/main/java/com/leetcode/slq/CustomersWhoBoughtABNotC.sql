-- https://neetcode.io/problems/sql-customers-bought-a-b-not-c/

SELECT customers.customer_id, customers.customer_name
FROM customers
WHERE customers.customer_id IN (
    SELECT orders.customer_id
    FROM orders
    WHERE orders.product_name = 'A'
)
  AND customers.customer_id IN (
    SELECT orders.customer_id
    FROM orders
    WHERE orders.product_name = 'B'
)
  AND customers.customer_id NOT IN (
    SELECT orders.customer_id
    FROM orders
    WHERE orders.product_name = 'C'
)
ORDER BY customers.customer_name;