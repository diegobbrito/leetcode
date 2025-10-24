#https://leetcode.com/problems/duplicate-emails/

SELECT email as Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;