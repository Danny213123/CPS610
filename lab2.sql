DROP TABLE professor;
DROP TYPE depart_type;

CREATE TYPE depart_type AS OBJECT
(
    name VARCHAR(100),
    faculty VARCHAR(100),
    building VARCHAR(100),
    phone VARCHAR(100)
)

CREATE TABLE professor (
    name VARCHAR(100),
    emp_id INT PRIMARY KEY,
    email VARCHAR(100),
    income DECIMAL(10, 2),
    depart_type depart_type
);

INSERT INTO professor (name, emp_id, email, income, depart_type) VALUES ('John Doe', 101, 'john.doe@example.com', 210000, depart_type('Computer Science', 'Engineering', 'Building A', '123-4590'));
INSERT INTO professor (name, emp_id, email, income, depart_type) VALUES ('Jane Smith', 102, 'jane.smith@example.com', 196000, depart_type('Mathematics', 'Science', 'Building B', '234-567-8901'));
INSERT INTO professor (name, emp_id, email, income, depart_type) VALUES ('Alice Johnson', 103, 'alice.johnson@example.com', 250000, depart_type('Biology', 'Science', 'Building C', '345-678-9012'));
INSERT INTO professor (name, emp_id, email, income, depart_type) VALUES ('Bob Williams', 104, 'bob.williams@example.com', 400000, depart_type('Physics', 'Science', 'Building D', '456-789-0123'));
INSERT INTO professor (name, emp_id, email, income, depart_type) VALUES ('Emily Brown', 105, 'emily.brown@example.com', 5, depart_type('Chemistry', 'Science', 'Building E', '567-890-1234'));

CREATE OR REPLACE PROCEDURE Poor 
IS
BEGIN
    FOR prof IN (SELECT * FROM Professor WHERE Income < 40000) LOOP
        DBMS_OUTPUT.PUT_LINE('Name: ' || prof.Name || ', Emp_id: ' || prof.Emp_id || ', Email: ' || prof.Email);
    END LOOP;
END Poor;

CREATE OR REPLACE PROCEDURE Average AS
    v_avg_income NUMBER;
BEGIN
    SELECT AVG(Income) INTO v_avg_income FROM Professor;
    DBMS_OUTPUT.PUT_LINE('Average Income: $' || v_avg_income);
END Average;

SELECT * FROM professor;

SELECT Name, Income * 0.3 AS Tax FROM Professor;

SET SERVEROUTPUT ON;

BEGIN
    FOR professor_record IN (SELECT income FROM professor) LOOP
        DBMS_OUTPUT.PUT_LINE('Professor Income: ' || professor_record.income || ', Tax: ' || professor_record.income * 0.30);
    END LOOP;
END;

BEGIN
    Poor;
END;

BEGIN
    Average;
END;
