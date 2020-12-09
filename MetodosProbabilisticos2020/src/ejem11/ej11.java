/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem11;

import java.util.Scanner;

/**
 *
 * @author Saul Ponce
 */
public class ej11 {
    public static void main(String[] args) {
        final int norm = 1000;
        final int suma = 487;
        final int mult = 8601;
        
        Scanner leer = new Scanner(System.in);
        
        int i, max, j;
        long sem;
        double rnd;
        Double p;
        Double q;
        Double probabilidad;
        
        Double sum;
        
        System.out.println("Numero de simulaciones [maximo 999]: ");
        max = leer.nextInt();
       
        
        
            System.out.println("Probabilidad: ");
            p = leer.nextDouble();
        
        q=1-p;
        
        
        sem = 10;
        
        System.out.println("---------------------------" + " " + max);
        
        for (j = 1; j < max; j++) {
            sem = (mult*sem + suma)%norm;
            rnd = (double)sem/norm;
            probabilidad = p;
            sum =p;
            i = 1;
            while(rnd >= sum){
                probabilidad=q*probabilidad;
                sum += probabilidad;
                i++;
            }
            
            System.out.println("el "+j+" tiempo de espera es: "+i);
        }
    }

}
