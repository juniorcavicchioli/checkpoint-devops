CREATE DATABASE CP_02;
GO

use CP_02;
GO

CREATE TABLE USUARIO (
	ID_USUARIO INT PRIMARY KEY IDENTITY(1,1),
	DS_EMAIL VARCHAR(45) NOT NULL,
	DS_PASSWORD VARCHAR(255) NOT NULL
);
GO