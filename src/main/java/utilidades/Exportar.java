/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

/**
 *
 * @author caro_
 */
public class Exportar {

    Stage stage;

    public void exportarDatos() {
        File fichero = new File("sample.db");
        File origen = new File(fichero.getAbsolutePath());
        try (InputStream in = new FileInputStream(origen)) {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            File destino = new File(file.getAbsolutePath() + ".db");
            try (OutputStream out = new FileOutputStream(destino)) {
                byte[] buffer = new byte[1024];
                int leido;
                while ((leido = in.read(buffer)) > 0) {
                    out.write(buffer, 0, leido);
                }
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(Exportar.class);
            logger.error(e.getMessage());
        }
    }
}
