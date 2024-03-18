INSERT INTO student VALUES (101, 'Alex', 1, 'CS');
INSERT INTO student VALUES (102, 'Bob', 3, 'BM');
INSERT INTO student VALUES (103, 'Steve', 2, 'CS');
INSERT INTO student VALUES (104, 'Jessica', 1, 'CS');
INSERT INTO student VALUES (105, 'Mary', 4, 'BS');
INSERT INTO student VALUES (106, 'Joseph', 1, 'CS');
INSERT INTO student VALUES (107, 'Bella', 4, 'BS');
INSERT INTO student VALUES (108, 'Hanna', 2, 'CS');
INSERT INTO student VALUES (109, 'Travis', 4, 'BS');
INSERT INTO student VALUES (110, 'Daniel', 3, 'BM');


INSERT INTO course VALUES('CPS109', 'Introduction to Computer Science I', 52, 'CS');
INSERT INTO course VALUES('CPS209', 'Introduction to Computer Science II', 52, 'CS');
INSERT INTO course VALUES('CPS510', 'Database System I', 52, 'CS');
INSERT INTO course VALUES('CPS610', 'Database System II', 52, 'CS');
INSERT INTO course VALUES('QMS110', 'Applied Mathematics for Business', 50, 'BM');
INSERT INTO course VALUES('MKT100', 'Principles of Marketing', 50, 'BM');
INSERT INTO course VALUES('BLG143', 'Biology I', 48, 'BS');
INSERT INTO course VALUES('BLG144', 'Biology II', 48, 'BS');

INSERT INTO section VALUES(1, 'CPS109', 'Fall', 2023, 'John');
INSERT INTO section VALUES(2, 'CPS109', 'Fall', 2023, 'Abdul');
INSERT INTO section VALUES(3, 'CPS209', 'Winter', 2024, 'Gale');
INSERT INTO section VALUES(12, 'CPS510', 'Fall', 2023, 'Mikhail');
INSERT INTO section VALUES(13, 'CPS610', 'Winter', 2024, 'Matthew');
INSERT INTO section VALUES(20, 'QMS110', 'Fall', 2023, 'Ben');
INSERT INTO section VALUES(22, 'MKT100', 'Winter', 2024, 'Jen');
INSERT INTO section VALUES(40, 'BLG143', 'Fall', 2023, 'Raina');
INSERT INTO section VALUES(42, 'BLG144', 'Winter', 2024, 'Michelle');


INSERT INTO grade_report VALUES (101, 1, 'A');
INSERT INTO grade_report VALUES (103, 2, 'B');
INSERT INTO grade_report VALUES (104, 1, 'A');
INSERT INTO grade_report VALUES (106, 1, 'B');
INSERT INTO grade_report VALUES (108, 2, 'B');


INSERT INTO grade_report VALUES (101, 3, 'B');
INSERT INTO grade_report VALUES (103, 3, 'B');
INSERT INTO grade_report VALUES (104, 3, 'A');
INSERT INTO grade_report VALUES (106, 3, 'A');
INSERT INTO grade_report VALUES (108, 3, 'C');


INSERT INTO grade_report VALUES (101, 12, 'B');
INSERT INTO grade_report VALUES (103, 12, 'A');
INSERT INTO grade_report VALUES (104, 12, 'A');
INSERT INTO grade_report VALUES (106, 12, 'B');
INSERT INTO grade_report VALUES (108, 12, 'A');


INSERT INTO grade_report VALUES (101, 13, 'B');
INSERT INTO grade_report VALUES (103, 13, 'C');
INSERT INTO grade_report VALUES (104, 13, 'A');
INSERT INTO grade_report VALUES (106, 13, 'A');
INSERT INTO grade_report VALUES (108, 13, 'B');


INSERT INTO grade_report VALUES (102, 20, 'B');
INSERT INTO grade_report VALUES (110, 20, 'A');


INSERT INTO grade_report VALUES (102, 22, 'A');
INSERT INTO grade_report VALUES (110, 22, 'A');


INSERT INTO grade_report VALUES (105, 40, 'A');
INSERT INTO grade_report VALUES (107, 40, 'B');
INSERT INTO grade_report VALUES (109, 40, 'B');


INSERT INTO grade_report VALUES (105, 42, 'A');
INSERT INTO grade_report VALUES (107, 42, 'C');
INSERT INTO grade_report VALUES (109, 42, 'B');


INSERT INTO prerequisite VALUES ('CPS209', 'CPS109');
INSERT INTO prerequisite VALUES ('CPS610', 'CPS510');
INSERT INTO prerequisite VALUES ('BLG144', 'BLH143');
