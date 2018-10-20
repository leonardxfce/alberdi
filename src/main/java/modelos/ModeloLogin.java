/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;
import java.util.ArrayList;
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
        this.url = "jdbc:sqlite:sample.db";
        try {

            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean comprobarExistencia(ArrayList<String> ArrUsuario) {
        usuario = ArrUsuario.get(0);
        password = ArrUsuario.get(1);
        try {
            ResultSet contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "';");
            statement.close();
            return contenidoDeRespuesta.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String seleccionar(String usuario, String password) {
        try {

            contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "';");
            contenidoDeRespuesta.next();
            statement.close();
            return contenidoDeRespuesta.getString("USUARIO");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void insertar() {
        try {
            statement.executeUpdate("INSERT INTO USUARIOS(ID, USUARIO, PASSWORD) VALUES (null,'" + usuario + "','" + password + "')");
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //eldavidmodificoesto

    public void eliminar() {
        try {
            //solo para eliminar un user
            statement.executeUpdate("DELETE * FROM `USUARIOS`(`ID`, `USUARIO`, `PASSWORD`) VALUES (null,'" + usuario + "'," + password + ")");

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
