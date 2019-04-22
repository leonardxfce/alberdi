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
        /*Manejador Properties: Si alguien sabe que hace, que lo escriba POR FAVOR...!----->*/
        ManejadorProperties propiedades = new ManejadorProperties(1);
        String usuario = propiedades.leerPropiedad("usuario");
        String password = propiedades.leerPropiedad("password");
    }

    public boolean comprobarExistencia(Usuario ArrUser) {
        /*metodo que comprueba si el usuario y la contraseña ingresados están en la base de datos*/
        /*recibe el Usuario con los datos de la VistaLogin y los almacena en un Array de String.*/
        String user = ArrUser.getUser();
        String pass = ArrUser.getPass();
        try {
            /*Ésta consulta permite verificar Si el usuario está en la base de datos por medio de un SELECT*/
            /*si Usuario es igual a Usuario, entonces dá TRUE*/
            /*si el usuario y la contraseña difiere con los datos de la base de datos, tendremos FALSE*/
            ResultSet contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            boolean result = contenidoDeRespuesta.next();
            statement.close();
            return result;
            /*En caso de que tengamos un error en la base de datos, se ejecuta este catch que nos imprime por consola el error*/
            /*Tambien devuelve FALSE*/
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }     
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
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
