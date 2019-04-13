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
          ManejadorProperties propiedades = new ManejadorProperties(1);
        String usuario = propiedades.leerPropiedad("usuario");
        String password = propiedades.leerPropiedad("password");

    }
    
    public boolean comprobarExistencia(Usuario ArrUsuario) {
        
        String usuario = ArrUsuario.getUsuario();
        String password = ArrUsuario.getPassword();
        try {
            ResultSet contenidoDeRespuesta = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + usuario + "' AND PASSWORD = '" + password + "';");
            boolean result = contenidoDeRespuesta.next();
            statement.close();
            return result;
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

    public boolean insertar(String usuario, String password) {
        boolean variable;
        try {
            statement.executeQuery("INSERT INTO USUARIOS VALUES (null,'"+ usuario +" ','" + password + "');");
            statement.close();
            variable =true;
        } catch (SQLException ex) {
            System.out.println("No se registro el usuario, por que ya hay uno con ese mismo nombre");
            System.out.println(ex.getMessage());
            variable = false;
        }
        
         return variable;
    }
    //eldavidmodificoesto

    public void eliminar(String usuario, String password) {
        try {
            //solo para eliminar un user
            statement.executeUpdate("DELETE * FROM `USUARIOS`(`ID`, `USUARIO`, `PASSWORD`) VALUES (null,'" + usuario + "'," + password + ")");

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(ModeloLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
