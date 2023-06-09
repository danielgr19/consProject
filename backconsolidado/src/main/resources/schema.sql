DROP TABLE IF EXISTS TEAMMEMBERS;
  
CREATE TABLE TEAMMEMBERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  rol VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS PROJECTS;
  
CREATE TABLE PROJECTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  projectName VARCHAR(250) NOT NULL,
  codeID VARCHAR(250) NOT NULL,
  descripcion VARCHAR(250) DEFAULT NULL
);

DROP TABLE IF EXISTS STATE;
  
CREATE TABLE STATE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  stateName VARCHAR(250) NOT NULL,
  descripcion VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS PROJECTTYPE;
  
CREATE TABLE PROJECTTYPE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  typeOfProyect VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS TASKS;
  
CREATE TABLE TASKS (
  taskId INT AUTO_INCREMENT  PRIMARY KEY,
  taskName VARCHAR(250) NOT NULL,
  taskDescription VARCHAR(250) NOT NULL,
  startDate VARCHAR(250) NOT NULL,
  finishDate VARCHAR(250) NOT NULL
);