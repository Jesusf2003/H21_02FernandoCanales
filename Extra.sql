SELECT * FROM PARTICIPANTE
GO
SELECT * FROM PONENTE
GO
SELECT * FROM CONFERENCIA
GO
SELECT * FROM REGISTRO
GO
SELECT
    *
FROM REGISTRODETALLE
WHERE CODREG = 4
GO

CREATE VIEW vTEMA
AS
SELECT
    CASE C.BLOCONF
        WHEN 1 THEN 'Cyberseguridad'
        WHEN 2 THEN 'Transformación Digital'
        WHEN 3 THEN 'Desarrollo de Software Empresarial'
        ELSE 'null'
    END AS 'Bloque',
    C.TEMCONF AS 'Tema',
    UPPER(P.APEPON) + ', ' + P.NOMPON AS 'Ponente'
FROM CONFERENCIA AS C
    INNER JOIN PONENTE AS P
    ON C.CODPON = P.CODPON
GO

SELECT * FROM vTEMA

SELECT
    CASE C.BLOCONF
        WHEN 1 THEN 'Cyberseguridad'
        WHEN 2 THEN 'Transformación Digital'
        WHEN 3 THEN 'Desarrollo de Software Empresarial'
        ELSE 'null'
    END AS 'Bloque',
    C.TEMCONF AS 'Tema',
    UPPER(P.APEPON) + ', ' + P.NOMPON AS 'Ponente'
FROM CONFERENCIA AS C
    INNER JOIN PONENTE AS P
    ON C.CODPON = P.CODPON
WHERE C.BLOCONF = 2
GO

SELECT
    CASE C.BLOCONF
        WHEN 1 THEN 'Cyberseguridad'
        WHEN 2 THEN 'Transformación Digital'
        WHEN 3 THEN 'Desarrollo de Software Empresarial'
        ELSE 'null'
    END AS 'Bloque',
    C.TEMCONF AS 'Tema',
    UPPER(P.APEPON) + ', ' + P.NOMPON AS 'Ponente'
FROM CONFERENCIA AS C
    INNER JOIN PONENTE AS P
    ON C.CODPON = P.CODPON
WHERE C.BLOCONF = 3
GO

EXEC spInsertRegistro 'S', 2
GO

EXEC spInsertRegistroDetalle 1
GO
EXEC spInsertRegistroDetalle 3
GO
EXEC spInsertRegistroDetalle 5
GO

EXEC spInsertRegistro 'N', 4
GO

EXEC spInsertRegistroDetalle 3
GO

EXEC spInsertRegistro 'S', 3
GO

EXEC spInsertRegistroDetalle 1
GO
EXEC spInsertRegistroDetalle 5
GO

SELECT * FROM dbo.CLIENTE