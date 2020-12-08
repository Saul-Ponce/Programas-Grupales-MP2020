/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo10;

import static java.lang.Math.pow;

/**
 *
 * @author Saul Ponce
 */
public class Ej10 {

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
    int MAX=100;
    int N=10;
    double P=0.25;
    double Q=0.75;
    Double p[] = new Double[N];
                
    Double SUM[] = new Double[N];
    int I;
    int cont=0;
    int test=0;
    
    p[0]=pow(Q,N);//0.31640625
        //System.out.println("p[0]:"+p[0]);
    
        for (int i = 1; i < N; i++) {
            //System.out.println("N: "+N+", i: "+i+", P: "+P+", Q: "+Q+", p[i-1]: "+p[i-1]);
            
            p[i]=(((double)((N-i)+1)/i)*(P/Q)*p[i-1]);
            //System.out.println("p["+i+"]: "+p[i]);
            //System.out.println("-------------------------------------------------------------------------");
        }
        SUM[0]=p[0];//0.31640625
            for (int j = 1; j < N; j++) {
            SUM[j]=SUM[j-1]+p[j];
                //System.out.println("SUM["+j+"]"+SUM[j]);
            }
            SEM=1500;
            I=0;
                for (int k = 1; k <= MAX; k++) {
                    //System.out.println("------------------------------------------------------------------------");
                    //System.out.println("Simulacion "+k);
                    SEM=(MULT*SEM+SUMA)%NORM;
                    RND=(Double.valueOf(SEM)) / (Double.valueOf(NORM));
                    

                    //System.out.println("RND: "+RND);
                    
                   if(I <= 10){ 
                    //System.out.println("I: "+I);
                        if(RND >= SUM[cont] && cont <= 5){
                            cont++;
                            //System.out.println(""+cont);
                        }
                        
                        
                        //System.out.println("I: "+I);
                        I++;
                        if(I == 10){
                            System.out.println("la  muestra de tela evaluada tiene "+cont+" defectos");
                       System.out.println("grupo "+test+" evaluado");
                       
                       cont=0;
                       I=0;
                       test++;
                        }
                        
//                    if(RND >= SUM[0] && RND < SUM[1]){
//                       System.out.println("la muestra evaluada no tiene defectos, probabilidad: "+SUM[0]);
//                    }else if(RND >= SUM[1] && RND < SUM[2]){
//                        System.out.println("la muestra evaluada tiene 1 defecto, probabilidad: "+SUM[1]); 
//                    }else if(RND >= SUM[2] && RND < SUM[3]){
//                        System.out.println("la muestra evaluada tiene 2 defectos, probabilidad: "+SUM[2]);
//                        //cont=2;
//                    }else if(RND >= SUM[3] && RND < SUM[4]){
//                        System.out.println("la muestra evaluada tiene 3 defectos, probabilidad: "+SUM[3]);
//                        //cont=3;
//                    }else if(RND >= SUM[4] && RND < SUM[5]){
//                        System.out.println("la muestra evaluada tiene 4 defectos, probabilidad: "+SUM[4]);
//                        //cont=4;
//                    }else if(RND == SUM[5]){
//                        System.out.println("la muestra evaluada tiene 5 defectos, probabilidad: "+SUM[5]);
//                        //cont=5;
//                    }else{
//                        
//                    }
                    
                   }/*else if(I>10){
                       System.out.println("la  muestra evaluada tiene "+cont+" defectos");
                       System.out.println("grupo "+test+" evaluado");
                       
                       cont=0;
                       I=0;
                       test++;  
                   }*/
                }
                System.out.println("grupos evaluados: "+test);
            
        
        
        
    }
    
}
