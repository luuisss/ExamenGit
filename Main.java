
/**
 *joc penjat en java
 *
 *@author Luis
 *@version 1.0
 *
 */

package com.company;

import java.util.Scanner;
import java.util.Random;

/**
 * comença utilitzant 3 parametres estàtics que son: paraules (vector que conte 3
 * paraules a esbrinar), index (per recorrer la paraula) i la p (per ficar guionets a
 * les que no esbrinem).
 *
 *@param paraules String vector amb paraules definides
 *@param index int l'utilitzem per recorrer les paraules del vector
 *@param p String l'utilitzem per ficar guionets a les lletres que no esbrinem
 *
 */


public class Main {

    static protected String paraules[] = {"hola","programació","casa"};
    static protected int index;
    static protected String p;

    public static void main(String[] args) {
        System.out.println("Comença el joc!");

        Random rand = new Random();
        index = rand.nextInt(3);
        for (int i=0; i<paraules[index].length(); i++) {
            p += "_";
        }

        System.out.println(p);

        Scanner reader = new Scanner(System.in);

        int num_errors = 0;

        while (!p.equals(paraules[index]) && num_errors < 5) {
            if (!nova_lletra(reader.next().charAt(0))) {
                num_errors++;
            }
            System.out.println(p);
        }
   }

    /**
     *Funció que comproba que quan introduim una lletra es verdader o fals que es troba
     * dins de la paraula a esbrinar.
     *
     *
     * @param nova_lletra boolean Rep per una nova lletra
     * @return boolean Retorna true o false, si el la lletra es correcta o no.
     *
     */

    static public boolean nova_lletra(char nova) {
        boolean trobada = false;
        String paraula_old = p;
        p = "";
        for (int i=0; i<paraules[index].length(); i++) {
            if (paraules[index].charAt(i) == nova) {
                p += paraules[index].charAt(i);
                trobada = true;
            }
            else {
                p += paraula_old.charAt(i);
            }
        }
        return trobada;
    }

}

