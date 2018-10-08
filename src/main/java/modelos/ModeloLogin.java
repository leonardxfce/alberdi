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
    ResultSet contenidoDeRespuesta;

    public ModeloLogin(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.url = "jdbc:mysql://sql10.freemysqlhosting.net/sql10259965";
        try {

            connection = DriverManager.getConnection(url, "sql10259965", "Ej1IRP2Jsk");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean comprobarExistencia(String usuario, int password) {
        try {
            ResultSet contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "';");
            return contenidoDeRespuesta.next();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String seleccionar() {
        try {

            contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "';");
            contenidoDeRespuesta.next();
            return contenidoDeRespuesta.getString("USUARIO");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertar() {
        try {
            statement.executeUpdate("INSERT INTO `USUARIOS`(`id`, `usuario`, `password`) VALUES (null,'" + usuario + "'," + password + ")");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        try {
            statement.executeUpdate("DELETE * FROM `USUARIOS`(`id`, `usuario`, `password`) VALUES (null,'" + usuario + "'," + password + ")");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() {

    }
}
