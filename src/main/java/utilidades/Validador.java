/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validador {

    String cadena;
    String cadena2;
    String cadena3;
    String cadena4;
    int cadena5;
    String cadena6;

    public boolean validarTapa(String nombre, String descripcion) {
        cadena = nombre;
        cadena2 = descripcion;
        boolean validar;
       
        if (cadena.equals("") || cadena2.equals("")) {
            validar = false;
        }else{
            validar= true;
        }
        return validar;
    }

    public boolean validarEnvase(String nombre, String tipo, String descripcion) {
        cadena3 = nombre;
        cadena4 = tipo;
        cadena6 = descripcion;
        boolean validar;

        if (cadena3.equals("") || cadena4.equals("") || cadena6.equals("")) {
            validar=false;
        }else{
            validar=true;
        }
        return validar;
    }
    
    public boolean validarLetrasEnvase(String nombre, String tipo,String descripcion){
        cadena3 = nombre;
        cadena4 = tipo;
        cadena6 = descripcion;
        boolean validar = false;
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat = pat.matcher(cadena3);
        Matcher mat1 = pat.matcher(cadena4);
        Matcher mat2 = pat.matcher(cadena6);
        if(!mat.find()&&!mat1.find()&&!mat2.find()){
            validar = true;
        }
        return validar;
    }

    public boolean validarLetrasTapa(String descripcion){
        cadena2 = descripcion;
        boolean validar = false;
        Pattern pat = Pattern.compile("[0-9]");
        Matcher mat1 = pat.matcher(cadena2);
        if(!mat1.find()){
            validar = true;
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
