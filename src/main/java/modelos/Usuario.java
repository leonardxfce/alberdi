
package modelos;

/**
 *
 * @author lauta
 */
public class Usuario {
    private String user;
    private String pass;
    
    public Usuario(String user, String pass){
        this.user=user;
        this.pass=pass;
    }
    
    public String getUser(){
    return this.user;
}
    public String getPass(){
        return this.pass;
    }

    public boolean comprobarUsuario(Usuario arrUser) {
        String user = arrUser.getUser();
        String pass = arrUser.getPass();
        int sectores = pass.length();

        if (user=="" & pass==""){
            return false;
        }
        if (sectores>=8){
            return false;
        }
        else{

            return true;
        }

    }
}
