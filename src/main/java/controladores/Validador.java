/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JOptionPane;


public class Validador {

    String cadena;
    String cadena2;
    String cadena3;
    String cadena4;
    int cadena5;
    String cadena6;

    public boolean validarTapa(String Nombre, String Descripcion) {
        cadena = Nombre;
        cadena2 = Descripcion;
        boolean validar;
       
        if (cadena.equals("") || cadena2.equals("")) {
            validar = false;
        }else{
            validar= true;
        }
        return validar;
    }

    public boolean validarEnvase(String nombre, String tipo, int volumen, String descripcion) {
        cadena3 = nombre;
        cadena4 = tipo;
        cadena5 = volumen;
        cadena6 = descripcion;
        boolean validar;

        if (cadena3.equals("") || cadena4.equals("") || "".equals(cadena5) || cadena6.equals("")) {
            validar=false;
        }else{
            validar=true;
        }
        return validar;
    }
    

}
