-- https://neetcode.io/problems/sql-sales-person/

SELECT sales_person.name
FROM sales_person
         LEFT JOIN orders
                   ON sales_person.sales_id = orders.sales_id
WHERE sales_person.sales_id NOT IN (
    SELECT orders.sales_id
    FROM orders
             LEFT JOIN company
                       ON orders.com_id = company.com_id
    WHERE company.name = 'CRIMSON'
)
GROUP BY sales_person.name;

--

SELECT sales_person.name
FROM sales_person
WHERE sales_person.sales_id NOT IN (
    SELECT orders.sales_id
    FROM orders
    JOIN company
    ON orders.com_id = company.com_id
    WHERE company.name = 'CRIMSON'
);