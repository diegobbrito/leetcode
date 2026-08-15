-- https://neetcode.io/problems/sql-sellers-with-no-sales/

SELECT seller.seller_name
FROM seller
WHERE seller.seller_id NOT IN (
    SELECT orders.seller_id FROM orders
    WHERE (orders.sale_date BETWEEN '2020-01-01' AND '2020-12-31')
)
ORDER BY seller.seller_name;