package modelos;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloMovimientoEnvase extends ModeloPadre {
    ResultSet rs;

    public void insertarMovimiento(MovimientoEnvase me){
        int idEnvase=me.getIdEnvase();
        int cantidad=me.getCantidad();
        String fecha=me.getFecha();
        try {
            String sql="insert into MOVIMIENTOENVASE values(NULL,'"
                    + idEnvase + "',"
                    + cantidad + ",'"
                    + fecha + "');";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(ModeloMovimientoEnvase.class);
            logger.error(e.getMessage());
        }
    }
}
