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
import principal.ManejadorProperties;

/**
 * @author lauta
 */
public class ModeloLogin extends ModeloPadre {

    ResultSet contenidoDeRespuesta;

    public ModeloLogin() {
        super();
        ManejadorProperties propiedades = new ManejadorProperties(1);
        String usuario = propiedades.leerPropiedad("usuario");
        String password = propiedades.leerPropiedad("password");
    }

    public boolean comprobarExistencia(Usuario ArrUser) {

        String user = ArrUser.getUser();
        String pass = ArrUser.getPass();
        try {
            ResultSet contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            boolean result = contenidoDeRespuesta.next();
            statement.close();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public String seleccionar(String user, String pass) {
        try {

            contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            contenidoDeRespuesta.next();
            statement.close();
            return contenidoDeRespuesta.getString("USUARIO");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean insertar(Usuario ArrUser) {
        String user = ArrUser.getUser();
        String pass = ArrUser.getPass();
        int count;
        try {
            count = statement.executeUpdate("INSERT INTO USUARIOS VALUES (null,'" + user + "','" + pass + "');");
            statement.close();
            if (count > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    //eldavidmodificoesto

    public void eliminar(String user, String pass) {
        try {
            //solo para eliminar un user
            statement.executeUpdate("DELETE * FROM `USUARIOS`(`ID`, `USUARIO`, `PASSWORD`) VALUES (null,'" + user + "'," + pass + ")");

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
