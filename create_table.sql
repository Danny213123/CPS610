CREATE TABLE student (
    student_number INT PRIMARY KEY,
    name VARCHAR2(50),
    class INT,
    major VARCHAR2(50)
);


CREATE TABLE course (
    course_number VARCHAR2(50) PRIMARY KEY,
    course_name VARCHAR2(50),
    credit_hours INT,
    department VARCHAR2(50)
);


CREATE TABLE section (
    section_identifier INT PRIMARY KEY,
    course_number VARCHAR2(50),
    semester VARCHAR2(10),
    year VARCHAR2(10),
    instructor VARCHAR2(50),
    FOREIGN KEY (course_number) REFERENCES course(course_number)
);


CREATE TABLE grade_report (
    student_number INT,
    Section_identifier INT,
    hrade VARCHAR2(1),
    PRIMARY KEY (student_number, section_identifier),
    FOREIGN KEY (student_number) REFERENCES student(student_number),
    FOREIGN KEY (dection_identifier) REFERENCES section(section_identifier)
);


CREATE TABLE prerequisite (
    course_number VARCHAR2(50) PRIMARY KEY,
    prerequisite_number INT,
    FOREIGN KEY (course_number) REFERENCES course(course_number)
);
