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
            setQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            setResultSet(statement.executeQuery(getQuery()));
            boolean result = getResultSet().next();
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

    public String seleccionar(Usuario arrUser) {
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
        String retorno = "";
        try {
            setQuery("SELECT * FROM USUARIOS where USUARIO = '" + user + "' AND PASSWORD = '" + pass + "';");
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            retorno = getResultSet().getString("USUARIO");
            statement.close();
            getResultSet().close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return retorno;
    }

    public boolean nombreDeUsuarioRepetido(Usuario usuario) {
        String user = usuario.getUser();
        boolean nombreRepetido = false;
        try {
            setQuery("SELECT USUARIO FROM USUARIOS where USUARIO = '" + user + "';");
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            if (getResultSet().getString("USUARIO").equals(user)) {
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
        boolean error = false;
        try {
            setQuery("INSERT INTO USUARIOS VALUES (null,'" + user + "','" + pass + "');");
            count = statement.executeUpdate(getQuery());
            statement.close();
            if (count > 0) {
                error = true;
            }
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return error;
    }
}
