package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection cnx = null;
    
    public static Connection conectar() throws Exception{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=dbHack21", "sa", "Administrador2021");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en: "+ e.getMessage());
        }
        return cnx;
    }
    
    public static void cerrarCnx() throws Exception{
        if(Conexion.cnx != null){
            cnx.close();
        }
    }
    
    public static void main(String []args) throws Exception{
        conectar();
        if(cnx != null){
            System.out.println("Conectado");
        }else{
            System.out.println("Sin conectar");
        }
    }
}