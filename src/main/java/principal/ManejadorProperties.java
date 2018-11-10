package principal;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManejadorProperties {
    // Propiedades
    String rutaFichero = "";
    String rutaFichero1 = "propiedades.properties";
    String rutaFichero2 = "log4j.properties";
    Properties propiedades;
    
   
    //contructor
    public ManejadorProperties(int opcion) {
        propiedades = new Properties();
       if (opcion == 1){
            rutaFichero = rutaFichero1;
        }
        if (opcion == 2){
            rutaFichero = rutaFichero2;
        }
        try {
            String direccion = System.getProperty("user.dir");
            String direcion1 = direccion + "/src/main/resources/" + rutaFichero; 
            InputStream output = new FileInputStream(direcion1);
            propiedades.load(output);
        } catch (IOException ex) {
            Logger.getLogger(ManejadorProperties.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //metodos
    public String leerPropiedad(String nombre) {

        if (propiedades == null) {
        }

        String resultado = "";
        resultado = propiedades.getProperty(nombre);

        return resultado;

    }

}
