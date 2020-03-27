# StudentToTeacher_beta
 JavaEE_WebApp_JDBC
数据库创建：
create database HomeworkManager;
use homeworkmanager;
create table student
(
StudentId varchar(20) primary key,
StudentName varchar(20)not null,
StudentPassword varchar(20) not null,
StudentClass varchar(20) not null,
StudentCreateTime varchar(20) not null
);
create table teacher
(
TeacherId varchar(20) primary key,
TeacherName varchar(20) not null,
TeacherPassword varchar(20) not null,
TeacherCreateTime varchar(20) not null
);
create table course
(
CourseId varchar(20) primary key,
CourseName varchar(20) not null,
CourseTeacherId varchar(20) not null,
CourseCreateTime varchar(20) not null,
foreign key(CourseTeacherId)references teacher(TeacherId)
);
create table class
(
ClassId varchar(20) primary key,
ClassName varchar(20) not null,
ClassCreateTime varchar(20) not null
);
create table course_class
(
KeyId varchar(20) primary key,
ClassId varchar(20) not null,
CourseId varchar(20) not null,
foreign key(ClassId)references class(ClassId),
foreign key(CourseId)references course(CourseId)
);
create table homework
(
HomeworkId varchar(20) primary key,
TeacherId varchar(20) not null,
Title varchar(80) not null,
Content varchar(10000) not null,
HomeworkCreateTime varchar(20) not null,
HomeworkDeadLine varchar(20) not null,
foreign key(TeacherId)references teacher(TeacherId)
);
create table Handlehomework
(
HandleHomeworkId varchar(20) primary key,
HomeworkId varchar(20),
StudentId varchar(20) not null,
Title varchar(80) not null,
Content varchar(10000) not null,
HandleHomeworkCreateTime varchar(20) not null,
foreign key(StudentId)references student(StudentId),
foreign key(HomeworkId)references homework(HomeworkId)
);
create table administrators
(
AdminId varchar(20) primary key,
AdminName varchar(20) not null,
AdminPassword varchar(20) not null,
AdminCreateTime varchar(20) not null
);
insert into student values('s1','张1','123','cla1',now());
insert into student values('s2','张2','123','cla2',now());
insert into student values('s3','张3','123','cla3',now());
insert into student values('s4','赵1','123','cla1',now());
insert into student values('s5','赵2','123','cla2',now());
insert into student values('s6','赵3','123','cla3',now());
insert into student values('s7','钱1','123','cla1',now());
insert into student values('s8','钱2','123','cla2',now());
insert into student values('s9','钱3','123','cla3',now());
insert into class values('cla1','班1',now());
insert into class values('cla2','班2',now());
insert into class values('cla3','班3',now());
insert into teacher values('t1','赵老师','321',now());
insert into teacher values('t2','钱老师','321',now());
insert into teacher values('t3','孙老师','321',now());
insert into teacher values('t4','李老师','321',now());
insert into course values('cou1','课1','t1',now());
insert into course values('cou2','课2','t2',now());
insert into course values('cou3','课3','t3',now());
insert into course values('cou4','课4','t4',now());
insert into course_class values(1,'cla1','cou1');
insert into course_class values(2,'cla2','cou2');
insert into course_class values(3,'cla3','cou3');
insert into course_class values(4,'cla1','cou4');
insert into course_class values(5,'cla2','cou1');
insert into course_class values(6,'cla3','cou2');
insert into course_class values(7,'cla1','cou3');
insert into course_class values(8,'cla2','cou4');
insert into homework values('hw1','t1','作业1','作业内容1',now(),'10');
insert into homework values('hw2','t2','作业2','作业内容2',now(),'10');
insert into homework values('hw3','t3','作业3','作业内容3',now(),'10');
insert into homework values('hw4','t4','作业4','作业内容4',now(),'10');
insert into homework values('hw5','t1','作业5','作业内容5',now(),'10');
insert into homework values('hw6','t2','作业6','作业内容6',now(),'10');
insert into homework values('hw7','t3','作业7','作业内容7',now(),'10');
insert into homework values('hw8','t4','作业8','作业内容8',now(),'10');
insert into handlehomework values('hhw1','hw1','s1','学生作业标题test','学生作业内容test',now());
insert into administrators values('admin1','admin','admin',now());
