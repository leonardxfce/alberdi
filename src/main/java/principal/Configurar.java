/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import modelos.ModeloEnvase;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author lauta
 */
public class Configurar {

    private Connection connection;
    private String url = "jdbc:sqlite:sample.db";
    private Statement statement;
    String id = "ID integer PRIMARY KEY,\n";

    public Configurar() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE if not exists USUARIOS (\n"
                    + id
                    + "USUARIO text unique,\n"
                    + "PASSWORD text\n"
                    + ");");
            statement.close();
            statement.executeUpdate("CREATE TABLE if not exists ENVASE (\n"
                    + id
                    + "NOMBRE text,\n"
                    + "TIPO text,\n"
                    + "VOLUMEN int,\n"
                    + "DESCRIPCION text\n"
                    + ");");
            statement.close();
            statement.executeUpdate("CREATE TABLE if not exists TAPA (\n"
                    + id
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
            statement.executeUpdate("CREATE TABLE if not exists MOVIMIENTOTAPA (\n" +
                    "ID_MOVIMIENTOTAPA integer PRIMARY KEY,\n" +
                    "ID_TAPA integer,\n" +
                    "CANTIDAD integer,\n" +
                    "FECHA text,\n" +
                    "FOREIGN KEY(ID_TAPA) REFERENCES TAPA(ID)\n" +
                    ");");
            statement.close();
            statement.executeUpdate("insert or replace into USUARIOS values(1,'lautaro','12345678')");
            statement.close();
            statement.executeUpdate("insert or replace into USUARIOS values(2,'marcelo','12345678')");
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }
}
