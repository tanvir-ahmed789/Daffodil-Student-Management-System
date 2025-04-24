CREATE DATABASE daffodilstudentmanagement;
USE daffodilstudentmanagement;


CREATE TABLE login (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE student (
    name VARCHAR(100) NOT NULL,
    fname VARCHAR(100),
    dob VARCHAR(20),
    salary VARCHAR(20),
    address VARCHAR(255),
    phone VARCHAR(15),
    email VARCHAR(100),
    education VARCHAR(50),
    designation VARCHAR(100), -- Used as Department
    addhar VARCHAR(20), -- Aadhar number
    empId VARCHAR(10) NOT NULL,
    PRIMARY KEY (empId)
);

CREATE TABLE IF NOT EXISTS courses (
    courseName VARCHAR(100) NOT NULL,
    PRIMARY KEY (courseName)
);

CREATE TABLE IF NOT EXISTS assigned_courses (
    empId VARCHAR(10) NOT NULL,
    courseName VARCHAR(100) NOT NULL,
    PRIMARY KEY (empId, courseName),
    FOREIGN KEY (empId) REFERENCES student(empId) ON DELETE CASCADE,
    FOREIGN KEY (courseName) REFERENCES courses(courseName) ON DELETE CASCADE
);

INSERT INTO login (username, password) VALUES ('admin', 'admin123');


INSERT INTO courses (courseName) VALUES 
    ('BBA'), ('B.Tech'), ('BCA'), ('BA'), ('BSC'), ('B.COM'),
    ('MBA'), ('MCA'), ('MA'), ('MTech'), ('MSC'), ('PHD');