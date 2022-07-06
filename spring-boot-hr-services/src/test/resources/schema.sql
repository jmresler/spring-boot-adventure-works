create schema if not exists HumanResources;
create table if not exists HumanResources.Employee (
	BusinessEntityID int NOT NULL,
	NationalIDNumber nvarchar(15)  NOT NULL,
	LoginID nvarchar(256)  NOT NULL,
	OrganizationNode binary NULL,
	OrganizationLevel smallint,
	JobTitle nvarchar(50) NOT NULL,
	BirthDate date NOT NULL,
	MaritalStatus nchar(1)  NOT NULL,
	Gender nchar(1)  NOT NULL,
	HireDate date NOT NULL,
	SalariedFlag boolean DEFAULT 1 NOT NULL,
	VacationHours smallint DEFAULT 0 NOT NULL,
	SickLeaveHours smallint DEFAULT 0 NOT NULL,
	CurrentFlag boolean DEFAULT 1 NOT NULL,
	rowguid varchar(1024)  NOT NULL,
	ModifiedDate datetime  NOT NULL,
	CONSTRAINT PK_Employee_BusinessEntityID PRIMARY KEY (BusinessEntityID)
);

create table if not EXISTS HumanResources.EmployeeDepartmentHistory (
	BusinessEntityID int NOT NULL,
	DepartmentID smallint NOT NULL,
	ShiftID tinyint NOT NULL,
	StartDate date NOT NULL,
	EndDate date NULL,
	ModifiedDate datetime  NOT NULL,
	CONSTRAINT PK_EmployeeDepartmentHistory_BusinessEntityID_StartDate_DepartmentID PRIMARY KEY (BusinessEntityID,StartDate,DepartmentID,ShiftID)
);

CREATE TABLE IF NOT EXISTS HumanResources.Department (
	DepartmentID smallint IDENTITY(1,1) NOT NULL,
	Name varchar(1024)  NOT NULL,
	GroupName varchar(1024) NOT NULL,
	ModifiedDate datetime NOT NULL,
	CONSTRAINT PK_Department_DepartmentID PRIMARY KEY (DepartmentID)
);

CREATE TABLE IF NOT EXISTS HumanResources.EmployeePayHistory (
	BusinessEntityID int NOT NULL,
	RateChangeDate datetime NOT NULL,
	Rate float NOT NULL,
	PayFrequency tinyint NOT NULL,
	ModifiedDate datetime NOT NULL,
	CONSTRAINT PK_EmployeePayHistory_BusinessEntityID_RateChangeDate PRIMARY KEY (BusinessEntityID,RateChangeDate)
);

CREATE TABLE IF NOT EXISTS HumanResources.JobCandidate (
	JobCandidateID int IDENTITY(1,1) NOT NULL,
	BusinessEntityID int NULL,
	Resume varchar(1024) NULL,
	ModifiedDate datetime NOT NULL,
	CONSTRAINT PK_JobCandidate_JobCandidateID PRIMARY KEY (JobCandidateID)
);

CREATE TABLE IF NOT EXISTS HumanResources.Shift (
	ShiftID tinyint IDENTITY(1,1) NOT NULL,
	Name varchar(1024) NOT NULL,
	StartTime time NOT NULL,
	EndTime time NOT NULL,
	ModifiedDate datetime NOT NULL,
	CONSTRAINT PK_Shift_ShiftID PRIMARY KEY (ShiftID)
);