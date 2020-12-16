# Java-eOkul-eSchool
Console program that records students' grades.

Student Table
CREATE TABLE "Student" (
	"Id"	INTEGER,
	"TC_No"	INTEGER NOT NULL UNIQUE,
	"Name"	TEXT,
	"Math"	INTEGER,
	"Physics"	INTEGER,
	"Database"	INTEGER,
	"Mobile"	INTEGER,
	"Average"	REAL,
	"Gender"	INTEGER,
	PRIMARY KEY("Id" AUTOINCREMENT)
)

Class Table
CREATE TABLE "Class" (
	"Id"	INTEGER,
	"Class_Name"	TEXT,
	PRIMARY KEY("Id" AUTOINCREMENT)
)

Student_List
CREATE TABLE "Student_List" (
	"Id"	INTEGER,
	"Student_Id"	INTEGER UNIQUE,
	"Class_Id"	INTEGER,
	PRIMARY KEY("Id" AUTOINCREMENT)
)
