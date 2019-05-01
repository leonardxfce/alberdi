/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;

import org.apache.log4j.Logger;

/**
 * @author lauta
 */
public class ModeloLogin extends ModeloPadre {
    //Atributos
    private ResultSet contenidoDeRespuesta;

    //Constructor
    public ModeloLogin() {
        super();
    }

    //Metodos
    public boolean comprobarExistencia(Usuario arrUser) {
        /*metodo que comprueba si el usuario y la contraseña ingresados están en la base de datos*/
        /*recibe el Usuario con los datos de la VistaLogin y los almacena en un Array de String.*/
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
        try {
            /*Ésta consulta permite verificar Si el usuario está en la base de datos por medio de un SELECT*/
            /*si Usuario es igual a Usuario, entonces dá TRUE*/
            /*si el usuario y la contraseña difiere con los datos de la base de datos, tendremos FALSE*/
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            boolean result = resultSet.next();
            statement.close();
            return result;
            /*En caso de que tengamos un error en la base de datos, se ejecuta este catch que nos imprime por consola el error*/
            /*Tambien devuelve FALSE*/
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
            return false;
        }
    }

    public String seleccionar(String user, String pass) {
        try {
            setQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            setContenidoDeRespuesta(statement.executeQuery(getQuery()));
            getContenidoDeRespuesta().next();
            statement.close();
            return getContenidoDeRespuesta().getString("USUARIO");
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return null;
    }

    public boolean seleccionarUsuario(Usuario usuario) {
        String user = usuario.getUser();
        boolean nombreRepetido = false;
        try {
            setQuery("SELECT USUARIO FROM USUARIOS where USUARIO = '" + user + "';");
            setContenidoDeRespuesta(statement.executeQuery(getQuery()));
            getContenidoDeRespuesta().next();
            if (getContenidoDeRespuesta().getString("USUARIO").equals(user)) {
                nombreRepetido = true;
            }
            statement.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return nombreRepetido;
    }

    public boolean insertar(Usuario arrUser) {
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
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
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
            return false;
        }
    }

    //Setteres && Getters
    public ResultSet getContenidoDeRespuesta() {
        return contenidoDeRespuesta;
    }

    public void setContenidoDeRespuesta(ResultSet contenidoDeRespuesta) {
        this.contenidoDeRespuesta = contenidoDeRespuesta;
    }
}
