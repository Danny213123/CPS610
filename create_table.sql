CREATE TABLE Student (
    Student_number INT PRIMARY KEY,
    Name VARCHAR(50),
    Class INT,
    Major VARCHAR(50)
);

CREATE TABLE Course (
    Course_number VARCHAR(50) PRIMARY KEY,
    Course_name VARCHAR(50),
    Credit_hours INT,
    Department VARCHAR(50)
);

CREATE TABLE Section (
    Section_identifier INT PRIMARY KEY,
    Course_number VARCHAR(50),
    Semester VARCHAR(10),
    Year VARCHAR(10),
    Instructor VARCHAR(50),
    FOREIGN KEY (Course_number) REFERENCES Course(Course_number)
);

CREATE TABLE Grade_Report (
    Student_number INT,
    Section_identifier,
    Grade VARCHAR(1),
    FOREIGN KEY (Student_number) REFERENCES Student(Student_number),
    FOREIGN KEY (Section_identifier) REFERENCES Section(Section_identifier)
);

CREATE TABLE Prerequisite (
    Course_number VARCHAR(50),
    Prerequisite_number INT PRIMARY KEY,
    FOREIGN KEY (Course_number) REFERENCES Course(Course_number)
);
