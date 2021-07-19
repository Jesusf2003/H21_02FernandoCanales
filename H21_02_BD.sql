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
    FECREGPAR   DATE NOT NULL DEFAULT GETDATE(),
    NOMPAR      VARCHAR(90) NOT NULL,
    APEPAR      VARCHAR(90) NOT NULL,
    DNIPAR      CHAR(8) NOT NULL,
    TIPPAR      CHAR(1) NOT NULL,
    CELPAR      CHAR(9) NOT NULL,
    EMAPAR      VARCHAR(150) NOT NULL,
    LUGPROPAR      VARCHAR(90) NOT NULL,
    ESTPAR      CHAR(1) NOT NULL DEFAULT 'A'
)
GO

CREATE TABLE CONFERENCIA(
    CODCONF     INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    TEMCONF     VARCHAR(150) NOT NULL,
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
    CODPAR      INT NOT NULL
)
GO

CREATE TABLE REGISTRODETALLE(
    CODREGDET       INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
    CODCONF         INT NOT NULL,
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

/* Creando las relacionesentre las tablas (CONFERENCIA - REGISTRODETALLE) */
ALTER TABLE REGISTRODETALLE
    ADD CONSTRAINT CONFERENCIA_REGISTRODETALLE FOREIGN KEY (CODCONF) REFERENCES CONFERENCIA(CODCONF)
GO

/* Creando las relacionesentre las tablas (REGISTRO - REGISTRODETALLE) */
ALTER TABLE REGISTRODETALLE
    ADD CONSTRAINT REGISTRO_REGISTRODETALLE FOREIGN KEY (CODREG) REFERENCES REGISTRO(CODREG)
GO

INSERT INTO PARTICIPANTE
    (NOMPAR, APEPAR, DNIPAR, TIPPAR, CELPAR, EMAPAR, LUGPROPAR)
VALUES
    ('Miguel', 'Navarro Ruíz', '73984585', '1', '996857413', 'miguel@gmail.com', 'San Vicente'),
    ('María', 'Gonzáles Perez', '78863512', '1', '893515242', 'maria@gmail.com', 'Imperial'),
    ('Lucía', 'Serrano Muñoz', '78314499', '2', '639857415', 'lucia@gmail.com', 'Imperial'),
    ('Alejandro', 'Hernandez Diaz', '66987415', '2', '778425364', 'alejandro@gmail.com', 'Mala'),
    ('José', 'Moreno Perez', '73984562', '3', '993254184',  'jose@gmail.com', 'San Antonio'),
    ('Sergio', 'Ortega Cuenca', '87125245', '3', '982634571',  'sergio@gmail.com', 'San Vicente'),
    ('Raúl', 'Torres Lozano', '67458526', '1', '963548721',  'raul@gmail.com', 'Imperial'),
    ('Andrea', 'Arenas Nuñéz', '74581695', '2', '974815263',  'jose@gmail.com', 'San Antonio'),
    ('Enrique', 'Arenas Nuñéz', '63458279', '2', '993657841',  'enrique@gmail.com', 'San Vicente'),
    ('Emilio', 'Arenas Nuñéz', '25983615', '3', '693526487',  'emilio@gmail.com', 'Imperial')
GO

INSERT INTO PONENTE
    (NOMPON, APEPON, CELPON, DNIPON, EMAPON, DIRPON)
VALUES
    ('David', 'López Cuello', '998657416', '73985414', 'david@gmail.com', 'Av. Libertad'),
    ('Andrés', 'Picazo Morcillo', '882514367', '65983484', 'andres@gmail.com', 'Av. Miguel Grau'),
    ('Manuela', 'Cuenca Garrido', '558471695', '88251436', 'manuela@gmail.com', 'Av. Libertad'),
    ('Ramón', 'Lozano Castillo', '776958914', '99475824', 'ramon@gmail.com', 'Av. 2 de mayo'),
    ('Francisco', 'López Perez', '884725635', '87123654', 'francisco@gmail.com', 'Av. Simón Bolivar'),
    ('Ángel', 'Moreno Diaz', '991235468', '73985421', 'angel@gmail.com', 'Jr. La unión')
GO

INSERT INTO CONFERENCIA
    (TEMCONF, BLOCONF, CODPON)
VALUES
    ('Hackers de sombrero blanco como aliados para resguardar el proceso electoral', '1', 1),
    ('La manipulación en la industria de las redes sociales mediante el uso de bots', '1', 2),
    ('Transformación digital impulsada por los datos', '2', 3),
    ('La TRANSFORMACIÓN DIGITAL en un mundo impulsado por los datos', '2', 4),
    ('SECUENCIA DE ACTIVIDADES DE ADMINISTRACION DE UN PROYECTO', '3', 5),
    ('RECOPILACION DE LOS REQUERIMIENTOS', '3', 6)
GO

INSERT INTO REGISTRO
    (CERTREG, CODPAR)
VALUES
    ('S', 1)
GO

INSERT INTO REGISTRODETALLE
    (CODREG, CODCONF)
VALUES
    (1, 1),
    (1, 3),
    (1, 5)
GO

INSERT INTO REGISTRO
    (CERTREG, CODPAR)
VALUES
    ('N', 3)
GO

INSERT INTO REGISTRODETALLE
    (CODREG, CODCONF)
VALUES
    (2, 1)
GO

INSERT INTO REGISTRO
    (CERTREG, CODPAR)
VALUES
    ('S', 5)
GO

INSERT INTO REGISTRODETALLE
    (CODREG, CODCONF)
VALUES
    (3, 1),
    (3, 3)
GO

INSERT INTO REGISTRO
    (CERTREG, CODPAR)
VALUES
    ('N', 3)
GO

INSERT INTO REGISTRODETALLE
    (CODREG, CODCONF)
VALUES
    (4, 3)
GO

/* Crear el procedure */
CREATE PROCEDURE spInsertRegistro
    (
        @certificado CHAR(1),
        @participante INT
    )
AS
    BEGIN
    SET NOCOUNT ON
        BEGIN TRY
            BEGIN TRAN
                INSERT INTO REGISTRO
                    (CERTREG, CODPAR)
                VALUES
                    (UPPER(@certificado), @participante) 
                IF UPPER(@certificado) = 'S' OR UPPER(@certificado) = 'N'
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

CREATE PROCEDURE spInsertRegistroDetalle
    (
        @codigoConferencia INT
    )
AS
    BEGIN
    SET NOCOUNT ON
        BEGIN TRY
            BEGIN TRAN
            DECLARE @codigoRegistro INT
            SET @codigoRegistro = (SELECT MAX(R.CODREG) FROM dbo.REGISTRO AS R)
                INSERT INTO dbo.REGISTRODETALLE
                (CODREG, CODCONF)
                VALUES
                (@codigoRegistro, @codigoConferencia)
                COMMIT TRAN;
        END TRY
        BEGIN CATCH
            SELECT 'No se ha registrado al evento' AS 'ERROR'
            IF @@TRANCOUNT > 0 ROLLBACK TRAN; 
        END CATCH
    END
GO

/* Cabecera */
EXEC spInsertRegistro 'S', 2
GO


/* Detalle */
EXEC spInsertRegistroDetalle 1
GO
EXEC spInsertRegistroDetalle 3
GO
EXEC spInsertRegistroDetalle 5
GO

/* Cabecera */
EXEC spInsertRegistro 'N', 4
GO

/* Detalle */
EXEC spInsertRegistroDetalle 3
GO

/* Cabecera */
EXEC spInsertRegistro 'S', 3
GO

/* Detalle */
EXEC spInsertRegistroDetalle 1
GO
EXEC spInsertRegistroDetalle 5
GO

/* Crear las vistas */
CREATE VIEW vCERTIFICADO
AS
SELECT
    CONCAT(A.APEPAR, ', ', A.NOMPAR) AS 'Participante',
    CONCAT(O.APEPON, ', ', O.NOMPON) AS 'Ponente',
    R.FECREG AS 'Fecha'
FROM PARTICIPANTE AS A
    INNER JOIN PONENTE AS O
    ON A.CODPAR = O.CODPON
    INNER JOIN REGISTRODETALLE AS RD
    ON A.CODPAR = RD.CODREGDET
    INNER JOIN REGISTRO AS R
    ON A.CODPAR = R.CODREG
GO

CREATE VIEW vtipoPARTICIPANTE
AS
SELECT 
    TIPO = CASE P.TIPPAR 
        WHEN '1' THEN 'Estudiante'
        WHEN '2' THEN 'Egresado'
        WHEN '3' THEN 'Público General'
        ELSE 'No existe'
        END,
    UPPER(P.APEPAR) + ', '+ P.NOMPAR AS 'Participante',
    P.CELPAR AS 'Celular',
    P.EMAPAR AS 'Correo',
    P.LUGPROPAR AS 'Procedencia'
FROM PARTICIPANTE AS P
GO

SELECT 
    p.APEPAR + ', ' + p.NOMPAR as Participante,
    CASE r.CERTREG
            WHEN 'S' THEN 'Si'
            WHEN 'N' THEN 'No'
            ELSE 'No existe'
            END AS 'Certificación',
    CASE c.BLOCONF
        WHEN '1' THEN 'Ciberseguridad'
        WHEN '2' THEN 'Transformación digital'
        WHEN '3' THEN 'Desarrollo empresarial'
        ELSE 'No existe'
        END AS Bloque,
    c.TEMCONF,
    p.APEPAR + ', ' + po.NOMPON AS Ponente
FROM REGISTRO AS R
    INNER JOIN REGISTRODETALLE AS RD
    ON R.CODREG = RD.CODREG
    INNER JOIN PARTICIPANTE AS P
    ON P.CODPAR = R.CODPAR
    INNER JOIN CONFERENCIA AS C
    ON RD.CODCONF = C.CODCONF
    INNER JOIN PONENTE AS PO
    ON C.CODPON = PO.CODPON
GO