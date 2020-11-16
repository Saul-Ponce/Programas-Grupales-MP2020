/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Saul Ponce
 */
public class Ejemplo7 {
    public static int NORM=1024;
    public static int SUMA=993;
    public static int MULT=801;
    public static int SEM=835;
    public static double RND;
    public static int[] REC={0,0,0};
    public static int MAX;
    public static int SUM=0;
    public static Scanner reader = new Scanner(System.in);
    public static String tst;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        do{
            System.out.println("Introduzca el numero de ensayos :");
            tst = reader.nextLine();
            if(isNumeric(tst)){
               MAX = Integer.parseInt(tst);
            if(Integer.parseInt(tst)<=0){
                System.out.println("El numero de ensayos debe ser mayor a 0 ");
            }else if(Integer.parseInt(tst) >= NORM){
                System.out.println("El numero de ensayos debe ser menor que "+NORM);
            }
            }else{
                System.out.println("El dato insertado no es un numero");
            }
        }while(!isNumeric(tst) || Integer.parseInt(tst) <= 0|| Integer.parseInt(tst) >= NORM);
        
        
        for (int i = 1; i <= MAX; i++) {
            for (int j = 0; j < 3; j++) {
                SEM=(MULT*SEM+SUMA)%NORM;
                RND=(Double.valueOf(SEM)) / (Double.valueOf(NORM));
                REC[j]= (int)(5*RND+1);
            }
            if(REC[0]!=REC[1] && REC[1]!=REC[2] &&REC[0]!=REC[2] ){
                SUM++;
            }
        }
        
        System.out.println("La probabilidad de caer en un recipiente distinto es: "+(Double.valueOf(SUM)/MAX));
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;       
	}
}
    
}
