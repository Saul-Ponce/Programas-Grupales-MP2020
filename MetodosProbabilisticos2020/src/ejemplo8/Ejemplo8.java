/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo8;

/**
 *
 * @author Saul Ponce
 */
public class Ejemplo8 {
    public static int NORM=8192;
    public static int SUMA=4857;
    public static int MULT=8601;
    public static int SEM=82584;
    public static int I=0;
    public static int MAX=5000;
    public static int J=0;
    public static int N=0;
    public static double[] P = {0.0167,0.3333,0.5000,0.6667,0.8333,1};
    public static double[] ProbReal = {0,0,0,0,0,0};
    public static int[] contador = {0,0,0,0,0,0};
    public static double RND;
    
    
    public static void main(String[] args) {
        double totalP=0;
        Random();
        calculaProbabilidad(contador);
        for (int i = 0; i < contador.length; i++) {
            System.out.println("P("+(i+1)+") = "+String.format("%.4f", ProbReal[i]));
            totalP +=ProbReal[i];
        }
        System.out.println("Probabilidad Total: "+totalP);
    }
    public static void Random(){
        for (J = 1; J < MAX; J++) {
           SEM=(MULT*SEM+SUMA)%NORM;
           RND=(Double.valueOf(SEM)) / (Double.valueOf(NORM));
           CarasDado(RND);

        }
    }
    public static void CarasDado(double RND){
        if(RND>0 && RND <=P[0]){
              contador[0]++;
              
          }else if(RND>P[0] && RND <=P[1]){
              contador[1]++;
             
          } else if(RND>P[1] && RND <=P[2]){
              contador[2]++;
              
          }else if(RND>P[2] && RND <=P[3]){
              contador[3]++;
              
          }else if(RND>P[3] && RND <=P[4]){
              contador[4]++;
           
          }else if(RND>P[4] && RND <=P[5]){
              contador[5]++;
  
          }
    }
    public static void calculaProbabilidad(int[] contador){
        for (int i = 0; i < contador.length; i++) {
            ProbReal[i]=Double.valueOf(contador[i])/MAX;
        }
    }
    
}
