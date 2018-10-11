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
import java.util.ArrayList;
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

    //constructores
    public ModeloTapa() {
        this.url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10259965";
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
    public void insert(ArrayList<String> miAl) {
        String nombre = miAl.get(0);
        String descripcion = miAl.get(1);
        try {
            statement.executeUpdate("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (" + null + ", '"
                    + nombre + "', '" + descripcion + "');");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean repetido(ArrayList<String> miAl) {
        String nombre = miAl.get(0);
        String descripcion = miAl.get(1);
        boolean bandera = false;
        try {
            String SQL = ""
                    + "SELECT COUNT(*) as contar  FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';";
            ResultSet rs = statement.executeQuery(SQL);
            rs.next();
            int cuenta = rs.getInt("contar");
            if (cuenta >= 1){
                bandera = true;
            }
            //bandera = cuenta >= 1;

        } catch (Exception e) {
            org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return bandera;
    }

    //setters && getters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
