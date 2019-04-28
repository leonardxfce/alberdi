/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author caro_
 */
public class ModeloEnvase extends ModeloPadre {

    public ModeloEnvase() {
        super();
    }

    public boolean repetido(Envase miAl) {
        String nombre = miAl.getNombre();
        String tipo = miAl.getTipo();
        int volumen = miAl.getVolumen();
        String descripcion = miAl.getDescripcion();
        boolean bandera = false;
        String sql = ""
                + "SELECT COUNT(*) as contar  FROM "
                + "ENVASE WHERE "
                + " NOMBRE='" + nombre
                + "' AND TIPO = '" + tipo
                + "' AND VOLUMEN =" + volumen
                + " AND DESCRIPCION = '" + descripcion + "';";
        try (ResultSet rs = statement.executeQuery(sql);) { //Esto hace que el statement se cierre solo
            rs.next();
            int cuenta = rs.getInt("contar");
            bandera = cuenta >= 1;
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return bandera;
    }

    public void guardarEnvaseNuevo(Envase miAl) {
        try {
            statement.executeUpdate("insert into ENVASE values(NULL,'"
                    + miAl.getNombre() + "', '"
                    + miAl.getTipo() + "',"
                    + miAl.getVolumen() + ",'"
                    + miAl.getDescripcion() + "');");
            String sql2 = ""
                    + "SELECT ID FROM "
                    + "ENVASE WHERE "
                    + " NOMBRE='" + miAl.getNombre()
                    + "' AND TIPO = '" + miAl.getTipo()
                    + "' AND VOLUMEN =" + miAl.getVolumen()
                    + " AND DESCRIPCION = '" + miAl.getDescripcion() + "';";
            ResultSet resultado = statement.executeQuery(sql2);
            resultado.next();
            int id = resultado.getInt("ID");
            resultado.close();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String fecha = LocalDate.now().format(formatter);
            statement.executeUpdate(
                    "INSERT INTO MOVIMIENTOENVASE VALUES " +
                            "( NULL," + id + ", 0 , '" + fecha + "' );"
            );
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }
    public List darEnvasesCombo(){
        ArrayList<Envase> envases = new ArrayList<>();
        String sql = "SELECT * FROM ENVASE";
        try(ResultSet r = statement.executeQuery(sql)){
            while(r.next()){
                Envase envase = new Envase(
                    r.getInt("id"),
                    r.getString("nombre"),
                    r.getString("tipo"),
                    r.getInt("Volumen"),
                    r.getString("descripcion")
                );
                envases.add(envase);
            }
        }catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return envases;
    }
    
    public List darTodosLosEnvases() {
        ArrayList<Envase> misEnvases = new ArrayList<>();
        String sql = "SELECT e.*, SUM(me.CANTIDAD) stock\n" +
                "FROM MOVIMIENTOENVASE me \n" +
                "INNER JOIN  ENVASE e ON e.ID=me.ID_ENVASE\n" +
                "GROUP BY e.ID";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Envase envase = new Envase(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getInt("Volumen"),
                        rs.getString("descripcion"),
                        rs.getInt("stock")
                );
                misEnvases.add(envase);
            }
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return misEnvases;
    }

    public void modificarEnvase(Envase miAl) {
        int id = miAl.getId();
        String nombre = miAl.getNombre();
        String tipo = miAl.getTipo();
        int volumen = miAl.getVolumen();
        String descripcion = miAl.getDescripcion();
        String sql = ""
                + "UPDATE ENVASE SET "
                + " NOMBRE='" + nombre
                + "', TIPO = '" + tipo
                + "', VOLUMEN =" + volumen
                + ", DESCRIPCION = '" + descripcion + "' WHERE ID= " + id + ";";
        try {
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public Envase darUno(int id) {
        String sql = "SELECT * FROM ENVASE WHERE ID= " + id + ";";
        Envase envase = null;
        try (ResultSet rs = statement.executeQuery(sql)) {
            rs.next();
            envase = new Envase(rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"), rs.getInt("Volumen"), rs.getString("descripcion"));
            statement.close();
        } catch (Exception e) {
            Logger logger = Logger.getLogger(ModeloEnvase.class);
            logger.error(e.getMessage());
        }
        return envase;
    }

}
