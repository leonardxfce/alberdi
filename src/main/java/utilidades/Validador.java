/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import examen.EsPar;
import java.time.LocalDate;
import modelos.Envase;
import modelos.Tapa;
import modelos.Usuario;


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
    public boolean validarVolumen(Envase envase){
        boolean validar;
        if (envase.getVolumen()> 0){
            validar=true;
        }else {
            validar=false;
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
    
    public boolean validarPassword(Usuario usuario){
        boolean result = false;
        char contrasena[]= usuario.getPass().toCharArray();
        if(contrasena.length>=8){
            result=true;
        }return result;
    }

    
}
