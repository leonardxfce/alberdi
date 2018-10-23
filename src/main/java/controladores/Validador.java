/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JOptionPane;
import modelos.Tapa;


public class Validador {
    String cadena;
    String cadena2;
    
    
    
    public Validador(String Nombre, String Descripcion){
        cadena=Nombre;
        cadena2=Descripcion;
        
        if(cadena.equals("")){
            JOptionPane.showMessageDialog(null, "Para continuar con el Registro LLene los campos solicitados");
        }
        
        if (cadena2.equals ("")){
            JOptionPane.showMessageDialog(null, "Para continuar con el Registro LLene los campos solicitados");
        
        }
}

   
    
}
