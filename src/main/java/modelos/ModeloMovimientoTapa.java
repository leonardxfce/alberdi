/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author caro_
 */
public class ModeloMovimientoTapa extends ModeloPadre {
    ResultSet rs;

    public void insertarMovimiento(MovimientoTapa me) {
        int idTapa = me.getIdTapa();
        int cantidad = me.getCantidad();
        String fecha = me.getFecha();
        try {
            String sql = "insert into MOVIMIENTOTAPA values(NULL,'"
                    + idTapa + "',"
                    + cantidad + ",'"
                    + fecha + "');";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
    }

    public List darTodosLosMovimientosConNombre() {
        ArrayList<MovimientoTapa> movimientosConNombres = new ArrayList<>();
        String sql = "SELECT t.NOMBRE,t.DESCRIPCION, mt.CANTIDAD, mt.FECHA\n" +
                "FROM MOVIMIENTOTAPA mt\n" +
                "INNER JOIN  TAPA t ON t.ID=mt.ID_TAPA\n" +
                "WHERE mt.CANTIDAD!=0";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                MovimientoTapa movimiento = new MovimientoTapa(
                        rs.getString("nombre") +" "+rs.getString("descripcion"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha")
                );
                movimientosConNombres.add(movimiento);
            }
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
        return movimientosConNombres;
    }
}
