/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import modelos.Tapa;

/**
 *
 * @author yamilla
 */
public class Calculadora {
    
    public int raizCuadrada(int numero){
        int resultado= (int) Math.sqrt(numero);
        return resultado;
    }
    
    public int suma(int i,int t){
        int resultado= i+t;
        return resultado;
    }
    
    public int doble(int numero){
        int resultado= numero*2;
        return resultado;
    }
    
    public int aleatorios(int i){
        int resultado = (int) (Math.random()*3);
        return resultado;
        
    }
    
    public String crearINSERTAR(String v){
        String resultado= "INSERT INTO ALUMNOS VALUES(NULL,'"+v+"')";
        return resultado;
    }

    public String crearINSERTARTapa(Tapa tapa) {
       String resultado= "INSERT INTO ALUMNOS VALUES(NULL,'"+tapa.getNombre()+"','"+tapa.getDescripcion()+"',"+tapa.getCantidad()+")";
       return resultado;
    }
    
    public String modificarTapa(Tapa tapa){
        String resultado= "UPDATE ALUMNOS SET NOMBRE ='"+tapa.getNombre()+"' where CANTIDAD="+tapa.getCantidad()+"";
        return resultado;
    }
    
    public String borrarTapa(Tapa tapa){
        String resultado= "DELETE FROM ALUMNOS WHERE CANTIDAD="+tapa.getCantidad()+"";
        return resultado;
    }
    
}
