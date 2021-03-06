CREATE DATABASE MOCK
GO
USE MOCK
GO
CREATE TABLE [admin](
	id INT PRIMARY KEY IDENTITY(1,1),
	username VARCHAR(20),
	password VARCHAR(1000),
	user_role VARCHAR(20)
)
GO
INSERT dbo.admin
        ( username, password, user_role )
VALUES  ( 
          'admin', -- usename - varchar(20)
          '1',  -- password - varchar(1000)
		  'ROLE_ADMIN'
          )
GO
CREATE TABLE course(
	id INT PRIMARY KEY IDENTITY(1,1),
	name NVARCHAR(100)
)
GO
INSERT dbo.course
        ( name )
VALUES  ( N'Lesson 1'  -- name - nvarchar(100)
          )
INSERT dbo.course
        ( name )
VALUES  ( N'Lesson 2'  -- name - nvarchar(100)
          )
INSERT dbo.course
        ( name )
VALUES  ( N'Lesson 3'  -- name - nvarchar(100)
          )
GO
CREATE TABLE quiz(
	id INT PRIMARY KEY IDENTITY(1,1),
	id_course INT REFERENCES dbo.course(id),
	question NTEXT NOT NULL,
	ans1 NTEXT NOT NULL,
	ans2 NTEXT NOT NULL,
	ans3 NTEXT NOT NULL,
	ans4 NTEXT NOT NULL,
	ans INT NOT NULL CHECK(ans IN (1,2,3,4))
)
GO
INSERT dbo.quiz
        ( 
          id_course ,
          question ,
          ans1 ,
          ans2 ,
          ans3 ,
          ans4 ,
          ans
        )
VALUES  (
          1 , -- id_course - int
          'This quiz is a quiz?' , -- question - ntext
          'Oh, really!' , -- ans1 - ntext
          'Nah! Dont care' , -- ans2 - ntext
          'Definitely a question' , -- ans3 - ntext
          'Wait for it' , -- ans4 - ntext
          1  -- ans - int
        ),
		(
          1 , -- id_course - int
          'This quiz is a quiz?' , -- question - ntext
          'Oh, really!' , -- ans1 - ntext
          'Nah! Dont care' , -- ans2 - ntext
          'Definitely a question' , -- ans3 - ntext
          'Wait for it' , -- ans4 - ntext
          2  -- ans - int
        ),
		(
          2 , -- id_course - int
          'This quiz is a quiz?' , -- question - ntext
          'Oh, really!' , -- ans1 - ntext
          'Nah! Dont care' , -- ans2 - ntext
          'Definitely a question' , -- ans3 - ntext
          'Wait for it' , -- ans4 - ntext
          3  -- ans - int
        ),
		(
          2 , -- id_course - int
          'This quiz is a quiz?' , -- question - ntext
          'Oh, really!' , -- ans1 - ntext
          'Nah! Dont care' , -- ans2 - ntext
          'Definitely a question' , -- ans3 - ntext
          'Wait for it' , -- ans4 - ntext
          4  -- ans - int
        )
GO
select * from admin
select * from course
select * from quiz

