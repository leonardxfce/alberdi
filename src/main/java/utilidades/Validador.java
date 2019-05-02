/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.time.LocalDate;
import modelos.Envase;
import modelos.Tapa;


public class Validador {

    String cadena;
    String cadena2;
    String cadena3;
    String cadena4;
    int cadena5;
    String cadena6;

    public boolean validarTapa(Tapa tapa) {
        cadena = tapa.getNombre();
        cadena2 = tapa.getDescripcion();
        boolean validar;
       
        if (cadena.equals("") || cadena2.equals("")) {
            validar = false;
        }else{
            validar= true;
        }
        return validar;
    }

    public boolean validarEnvase(Envase envase) {
        cadena3 = envase.getNombre();
        cadena4 = envase.getTipo();
        cadena6 = envase.getDescripcion();
        boolean validar;

        if (cadena3.equals("") || cadena4.equals("") || cadena6.equals("")) {
            validar=false;
        }else{
            validar=true;
        }
        return validar;
    }

    public boolean validarMovimiento(String cantidad, int indiceComboBox, LocalDate date){
        boolean validar;
        if (cantidad.equals("")||indiceComboBox==-1||date==null){
            validar=false;
        }else {
            validar=true;
        }
        return validar;
    }
}
