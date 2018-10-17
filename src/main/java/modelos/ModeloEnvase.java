/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author caro_
 */
public class ModeloEnvase {

    Connection connection;
    Statement statement;
    int id;
    String nombre;
    String tipo;
    int volumen;
    String descripcion;
    String url = "jdbc:sqlite:sample.db";

    public ModeloEnvase() {

        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public boolean repetido(ArrayList<String> miAl) {
        String nombre = miAl.get(0);
        String tipo = miAl.get(1);
        int volumen = Integer.parseInt(miAl.get(2));
        String descripcion = miAl.get(3);
        boolean bandera = false;
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            String SQL = ""
                    + "SELECT COUNT(*) as contar  FROM "
                    + "ENVASE WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND TIPO = '" + tipo
                    + "' AND VOLUMEN =" + volumen
                    + " AND DESCRIPCION = '" + descripcion + "';";
            ResultSet rs = statement.executeQuery(SQL);
            rs.next();
            int cuenta = rs.getInt("contar");
            bandera = cuenta >= 1;
            statement.close();
        } catch (Exception e) {

            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return bandera;
    }

    public void guardarEnvaseNuevo(ArrayList<String> miAl) {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.executeUpdate("insert into ENVASE values(NULL,'" + miAl.get(0) + "', '" + miAl.get(1) + "', '" + miAl.get(2) + "',' " + miAl.get(3) + "')");
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
