-- https://neetcode.io/problems/sql-top-travellers/

SELECT u.name AS name,
       CASE
           WHEN sum(r.distance) > 0
               THEN sum(r.distance)
           ELSE 0
           END as travelled_distance
FROM users AS u
         LEFT JOIN rides as r
                   ON u.id = r.user_id
GROUP BY u.id
ORDER BY travelled_distance DESC, name;

SELECT u.name, COALESCE(SUM(r.distance), 0) AS travelled_distance
FROM users u
         LEFT JOIN rides r ON u.id = r.user_id
GROUP BY u.id, u.name
ORDER BY travelled_distance DESC, u.name ASC;