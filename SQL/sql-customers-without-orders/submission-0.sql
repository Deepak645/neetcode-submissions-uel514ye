-- Write your query below

select name from customers WHERE id NOT IN (select customer_id from orders);