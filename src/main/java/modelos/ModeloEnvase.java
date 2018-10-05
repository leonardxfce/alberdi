/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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
    String url;


    public ModeloEnvase(String nombre, String tipo,int volumen,String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.descripcion = descripcion;
        this.url = "jdbc:sqlite:sample.db";
    }


    public void insert() {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            System.out.println("insert into envase values(1,'" + nombre + "', '" + tipo + "', '" + volumen + "', '" + descripcion + "')");
            statement.executeUpdate("insert into envase values(1,'" + nombre + "', '" + tipo + "', '" + volumen + "',' " + descripcion + "')");
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
