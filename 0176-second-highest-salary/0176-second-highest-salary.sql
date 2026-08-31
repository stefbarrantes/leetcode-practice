SELECT MAX(e.salary) as SecondHighestSalary from Employee as e 
WHERE e.salary < (SELECT MAX(e.salary) from Employee as e )
