/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author lauta
 */
public class Configurar {
    
    private Connection connection;
    private String url = "jdbc:sqlite:sample.db";
    private Statement statement;
    
    public Configurar(){
    try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE if not exists USUARIOS (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "USUARIO text unique,\n"
                    + "PASSWORD text\n"
                    + ");");
            statement.close();
            statement.executeUpdate("CREATE TABLE if not exists ENVASE (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "NOMBRE text,\n"
                    + "TIPO text,\n"
                    + "VOLUMEN int,\n"
                    + "DESCRIPCION text\n"
                    + ");");
            statement.close();
            statement.executeUpdate("CREATE TABLE if not exists TAPA (\n"
                    + "ID integer PRIMARY KEY,\n"
                    + "NOMBRE text,\n"
                    + "DESCRIPCION text\n"
                    + ");");
            statement.close();
            statement.executeUpdate("CREATE TABLE if not exists MOVIMIENTOENVASE (\n" +
                    "ID_MOVIMIENTOENVASE integer PRIMARY KEY,\n" +
                    "ID_ENVASE integer,\n" +
                    "CANTIDAD integer,\n" +
                    "FECHA text,\n" +
                    "FOREIGN KEY(ID_ENVASE) REFERENCES ENVASE(ID)\n" +
                    ");");
            statement.close();
            statement.executeUpdate("insert or replace into USUARIOS values(1,'lautaro','12345')");
            statement.close();
            statement.executeUpdate("insert or replace into USUARIOS values(2,'marcelo','123')");
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
}
