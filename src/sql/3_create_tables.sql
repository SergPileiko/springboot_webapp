USE employeedb;

CREATE TABLE employee (
  employee_id BIGINT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(25),
  last_name VARCHAR(25),
  department_id INT,
  job_title VARCHAR(25),
  gender ENUM('MALE', 'FEMALE'),
  date_of_birth DATE,
  PRIMARY KEY (employee_id)
);