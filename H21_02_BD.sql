USE master
GO

DROP DATABASE dbHack21
GO

IF db_id('dbHack21') IS NOT NULL
    PRINT '*** Si existe la base de datos ***'
ELSE
    PRINT '--- No existe la base de datos, procederé a crearla ---'
    CREATE DATABASE dbHack21
GO

USE dbHack21
GO

CREATE TABLE PARTICIPANTE(
    CODPAR      INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
    NOMPAR      VARCHAR(90) NOT NULL,
    APEPAR      VARCHAR(90) NOT NULL,
    CELPAR      CHAR(9) NOT NULL,
    DNIPAR      CHAR(8) NOT NULL,
    EMAPAR      VARCHAR(150) NOT NULL,
    DIRPAR      VARCHAR(90) NOT NULL
)
GO

CREATE TABLE CONFERENCIA(
    CODCONF     INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    TEMCONF     VARCHAR(100) NOT NULL,
    FECREACONF  DATE NOT NULL DEFAULT GETDATE(),
    BLOCONF     CHAR(1) NOT NULL,
    CODPON      INT NOT NULL
)
GO

CREATE TABLE PONENTE(
    CODPON      INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    NOMPON      VARCHAR(90) NOT NULL,
    APEPON      VARCHAR(90) NOT NULL,
    CELPON      CHAR(9) NOT NULL,
    DNIPON      CHAR(8) NOT NULL,
    EMAPON      VARCHAR(150) NOT NULL,
    DIRPON      VARCHAR(90) NOT NULL
)
GO

CREATE TABLE REGISTRO(
    CODREG      INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    FECREG      DATE NOT NULL DEFAULT GETDATE(),
    CERTREG     CHAR(1) NOT NULL,
    CODCONF     INT NOT NULL,
    CODPAR      INT NOT NULL
)
GO

CREATE TABLE REGISTRODETALLE(
    CODREGDET       INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    TEMREGDET       CHAR(1) NOT NULL,
    CODREG          INT NOT NULL
)
GO

/* Creando las relacionesentre las tablas (PARTICIPANTE - REGISTRO) */
ALTER TABLE REGISTRO
    ADD CONSTRAINT PARTICIPANTE_REGISTRO FOREIGN KEY (CODPAR) REFERENCES PARTICIPANTE(CODPAR)
GO

/* Creando las relacionesentre las tablas (PONENTE - CONFERENCIA) */
ALTER TABLE CONFERENCIA
    ADD CONSTRAINT PONENTE_CONFERENCIA FOREIGN KEY (CODPON) REFERENCES PONENTE(CODPON)
GO

/* Creando las relacionesentre las tablas (CONFERENCIA - REGISTRO) */
ALTER TABLE REGISTRO
    ADD CONSTRAINT CONFERENCIA_REGISTRO FOREIGN KEY (CODCONF) REFERENCES CONFERENCIA(CODCONF)
GO

/* Creando las relacionesentre las tablas (REGISTRO - REGISTRODETALLE) */
ALTER TABLE REGISTRODETALLE
    ADD CONSTRAINT REGISTRO_REGISTRODETALLE FOREIGN KEY (CODREG) REFERENCES REGISTRO(CODREG)
GO

INSERT INTO PARTICIPANTE
    (NOMPAR, APEPAR, CELPAR, DNIPAR, EMAPAR, DIRPAR)
VALUES
    ('José', 'Moreno Perez', '993254184', '73984562', 'moreno@gmail.com', 'San vicente'),
    ('Miguel', 'Navarro Ruíz', '996857413', '73984585', 'miguel@gmail.com', 'Av. 2 de mayo'),
    ('Antonio', 'García Martínez', '991234567', '73456198', 'jose@gmail.com', 'Av. Libertad')
GO

INSERT INTO PONENTE
    (NOMPON, APEPON, CELPON, DNIPON, EMAPON, DIRPON)
VALUES
    ('David', '', '998657416', '73985414', 'david@gmail.com', 'Av. Libertad'),
    ('Francisco', 'López Perez', '991238595', '87123654', 'francisco@gmail.com', 'Av. Simón Bolivar'),
    ('Ángel', 'Moreno Diaz', '991235468', '73985421', 'angel@gmail.com', 'Jr. La unión')
GO

INSERT INTO CONFERENCIA
    (TEMCONF, BLOCONF, CODPON)
VALUES
    ('Ciberseguridad', '1', 1),
    ('Transformación Digital', '2', 2),
    ('Desarrollo de Software Empresarial', '3', 3)
GO

INSERT INTO REGISTRO
    (CERTREG, CODCONF, CODPAR)
VALUES
    ('S', 1, 1),
    ('N', 2, 3),
    ('S', 1, 2)
GO

INSERT INTO REGISTRODETALLE
    (TEMREGDET, CODREG)
VALUES
    ('1', 1),
    ('2', 3),
    ('3', 2)
GO

/* Crear el procedure */
CREATE PROCEDURE spInsertRegistro
    (
        @certificado CHAR(1),
        @conferencia INT,
        @participante INT
    )
AS
    BEGIN
    SET NOCOUNT ON
        BEGIN TRY
            BEGIN TRAN
                INSERT INTO REGISTRO
                    (CERTREG, CODCONF, CODPAR)
                VALUES
                    (UPPER(@certificado), @conferencia, @participante) 
                IF UPPER(@certificado) = 'D' OR UPPER(@certificado) = 'E'
                    COMMIT TRAN
                ELSE
                    ROLLBACK TRAN;
        END TRY
        BEGIN CATCH
            SELECT 'No se ha registrado al participante' AS 'ERROR'
            IF @@TRANCOUNT > 0 ROLLBACK TRAN; 
        END CATCH
    END
GO

/* Crear las vistas */
CREATE VIEW vCERTIFICADO
AS
SELECT
    CONCAT(A.APEPAR, ', ', A.NOMPAR) AS 'Participante',
    CONCAT(O.APEPON, ', ', O.NOMPON) AS 'Ponente',
    RD.TEMREGDET AS 'Tema',
    R.FECREG AS 'Fecha'
FROM PARTICIPANTE AS A
    INNER JOIN PONENTE AS O
    ON A.CODPAR = O.CODPON
    INNER JOIN REGISTRODETALLE AS RD
    ON A.CODPAR = RD.CODREGDET
    INNER JOIN REGISTRO AS R
    ON A.CODPAR = R.CODREG