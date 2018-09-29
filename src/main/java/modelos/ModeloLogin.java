/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author lauta
 */
public class ModeloLogin {

    int id;
    String usuario;
    String password;
    String url;
    Connection connection;
    Statement statement;
    ResultSet rs;

    public ModeloLogin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.url = "jdbc:postgresql://pellefant.db.elephantsql.com:5432/prafqulb";

    }

    public String seleccionar() {
        try {
            connection = DriverManager.getConnection(url, "prafqulb", "M-dsT1RJ6AM7h17OM2PppJ2-Z5TPIQTc");
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND CONTRASENA = '" + password + "';");
            rs.next();
            return rs.getString("USUARIO");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertar() {
        try {

            connection = DriverManager.getConnection(url, "prafqulb", "M-dsT1RJ6AM7h17OM2PppJ2-Z5TPIQTc");
            statement = connection.createStatement();
            statement.executeUpdate("insert into USUARIOS values( 2,'" + usuario + "'," + password + ");");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {

    }

    public void modificar() {

    }
}
