/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


/**
 *
 * @author lauta
 */
public class Usuario {
        private String usuario;
        private String password;
    public Usuario (String usuario, String password){
        this.usuario=usuario;
        this.password=password;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    public String getPassword(){
        return this.password;
    }
   
}
