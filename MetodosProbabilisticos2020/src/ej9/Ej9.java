/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

import static java.lang.Math.pow;

/**
 *
 * @author Saul Ponce
 */
public class Ej9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int NORM=2048;
    int SUMA=2033;
    int MULT=2001;
    int SEM;
    double RND;
    int MAX=500;
    int N=4;
    double P=0.25;
    double Q=0.75;
    double p[] = {0,0,0,0};
                //0,1,2,3
    double SUM[]={0,0,0,0};
    int I;
    
    p[0]=pow(Q,N);//0.31640625
        System.out.println("p[0]:"+p[0]);
    
        for (int i = 1; i < N ; i++) {
            System.out.println("N: "+N+", i: "+i+", P: "+P+", Q: "+Q+", p[i-1]: "+p[i-1]);
            
            p[i]=(((double)((N-i)+1)/i)*(P/Q)*p[i-1]);
            System.out.println("p["+i+"]: "+p[i]);
            System.out.println("-------------------------------------------------------------------------");
        }
        SUM[0]=p[0];//0.31640625
            for (int j = 1; j < N; j++) {
            SUM[j]=SUM[j-1]+p[j];
                System.out.println("SUM["+j+"]"+SUM[j]);
                //System.out.println("p[j]"+p[j]);
            }
            SEM=1500;
            I=0;
                for (int k = 1; k < MAX; k++) {
                    SEM=(MULT*SEM+SUMA)%NORM;
                    RND=(Double.valueOf(SEM)) / (Double.valueOf(NORM));
                    

                    //System.out.println("RND: "+RND);
                    
                    
                    //System.out.println("I: "+I);
                    if(RND >= SUM[I] && I<N-1){
                        //System.out.println("SUM["+I+"]: "+SUM[I]);
                        System.out.println("Valor de SUM: "+SUM[I]);
                        I++;
                        
                    }
                    System.out.println("valor de I: "+I);
                }
            
        
        
        
    }
    
}
