/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SantiagoGuirado
 */
public class ModeloTapa extends ModeloPadre {

    public ModeloTapa() {
        super();
    }

    //insert
    public void insert(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        setQuery("INSERT INTO TAPA (ID, NOMBRE, DESCRIPCION) VALUES (NULL, '" + nombre + "', '" + descripcion + "');");
        try {
            statement.executeUpdate(getQuery());
            statement.close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
    }

    public boolean repetido(Tapa tapa) {
        String nombre = tapa.getNombre();
        String descripcion = tapa.getDescripcion();
        boolean bandera = false;
        try {
            setQuery("SELECT COUNT(*) as contar  FROM "
                    + "TAPA WHERE "
                    + " NOMBRE='" + nombre
                    + "' AND DESCRIPCION = '" + descripcion + "';");
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            int cuenta = getResultSet().getInt("contar");
            if (cuenta >= 1) {
                bandera = true;
            }
            statement.close();
            getResultSet().close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return bandera;
    }

    public void modificarTapa(Tapa miAl) {
        int id = miAl.getIdTapa();
        String nombre = miAl.getNombre();
        String descripcion = miAl.getDescripcion();
        setQuery("UPDATE TAPA SET "
                + " NOMBRE='" + nombre
                + "',DESCRIPCION = '" + descripcion + "' WHERE ID= " + id + ";");
        try {
            statement.executeUpdate(getQuery());
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    //select de todos los datos, copiado a modeloEnvase(creditos a quien corresponda )
    public List darTodasLasTapas() {
        ArrayList<Tapa> listadoTapas = new ArrayList<>();
        setQuery("SELECT * FROM TAPA");
        try {
            setResultSet(statement.executeQuery(getQuery()));
            while (getResultSet().next()) {
                Tapa tapa = new Tapa(getResultSet().getInt("ID"), getResultSet().getString("nombre"),
                        getResultSet().getString("descripcion"));
                listadoTapas.add(tapa);
            }
            statement.close();
            getResultSet().close();
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(ex.getMessage());
        }
        return listadoTapas;
    }

    public Tapa darUno(int id) {
        Tapa tapa = null;
        setQuery("SELECT * FROM TAPA WHERE ID= " + id + ";");
        try {
            setResultSet(statement.executeQuery(getQuery()));
            getResultSet().next();
            tapa = new Tapa(getResultSet().getInt("id"),
                    getResultSet().getString("nombre"), getResultSet().getString("descripcion"));
            statement.close();
            getResultSet().close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return tapa;
    }
}
