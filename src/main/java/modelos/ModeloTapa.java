/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SantiagoGuirado
 */
public class ModeloTapa {

    Connection connection;
    Statement statement;
    ResultSet rs;
    private String url;

    int id;
    String nombre;
    String descripcion;

    //constructores
    public ModeloTapa(int id, String nombre, String descripcion, String url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;

        try {
            connection = DriverManager.getConnection(url, "sql10259965", "Ej1IRP2Jsk");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //select
    public String select(int dato) {
        String retorno = "";
        try {
            rs = statement.executeQuery("SELECT * FROM TAPA WHERE ID = " + dato + ";");
            rs.next();
            retorno = rs.getString("NOMBRE");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //insert
    public void insert() {
        try {
            statement.executeUpdate("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (" + id + ", '"
                    + nombre + "', '" + descripcion + "');");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //setters && getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
