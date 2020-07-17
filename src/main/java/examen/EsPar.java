/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

/**
 *
 * @author yamilla
 */
public class EsPar {

    int numero;

    public EsPar(int i) {
        this.numero = i;
    }

    public EsPar() {

    }

    public boolean esPar() {

        boolean bandera = false;
        if (numero % 2 == 0) {
            bandera = true;
        } else {
            bandera = false;
        }
        return bandera;
    }

}
