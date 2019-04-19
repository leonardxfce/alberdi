/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import principal.ManejadorProperties;

/**
 * @author lauta
 */
public class ModeloLogin extends ModeloPadre {

    ResultSet contenidoDeRespuesta;
    ManejadorProperties propiedades;
    String usuario;
    String password;

    public ModeloLogin() {
        super();
        propiedades = new ManejadorProperties(1);
        usuario = propiedades.leerPropiedad("usuario");
        password = propiedades.leerPropiedad("password");
    }

    public boolean comprobarExistencia(Usuario arrUser) {
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
        setQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
        try {
            ResultSet respuesta = statement.executeQuery(getQuery());
            boolean result = respuesta.next();
            statement.close();
            respuesta.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //Este metodo sirve para verificar si el nombre de usuario ya existe. Agregado por Santiago
    public boolean comprobarExistenciaUser(String user) {
        setQuery("SELECT USUARIO FROM USUARIOS where USUARIO = '" + user + "';");
        try {
            ResultSet respuesta = statement.executeQuery(getQuery());
            boolean result = respuesta.next();
            statement.close();
            respuesta.close();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String seleccionar(String user, String pass) {
        setQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
        try {
            contenidoDeRespuesta = statement.executeQuery(getQuery());
            contenidoDeRespuesta.next();
            statement.close();
            return contenidoDeRespuesta.getString("USUARIO");
        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insertar(Usuario arrUser) {
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
        int count;
        boolean error;
        try {
            count = statement.executeUpdate("INSERT INTO USUARIOS VALUES (null,'" + user + "','" + pass + "');");
            statement.close();
            if (count > 0) {
                error = true;
            } else {
                error = false;
            }
        } catch (Exception ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
            error = false;
        }
        return error;
    }
    //eldavidmodificoesto

    public void eliminar(String user, String pass) {
        setQuery("DELETE * FROM `USUARIOS`(`ID`, `USUARIO`, `PASSWORD`) VALUES (null,'" + user + "'," + pass + ")");
        try {
            //solo para eliminar un user
            statement.executeUpdate(getQuery());

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
