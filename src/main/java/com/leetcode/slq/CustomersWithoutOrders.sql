-- https://neetcode.io/problems/sql-customers-without-orders/

SELECT customers.name
FROM customers
         LEFT JOIN orders
                   ON customers.id = orders.customer_id
WHERE orders.customer_id is null;