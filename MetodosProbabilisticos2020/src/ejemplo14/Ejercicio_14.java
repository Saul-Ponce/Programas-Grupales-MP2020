/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo14;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dany
 */
public class Ejercicio_14 extends java.awt.Frame {

    int norm = 128;
    int suma = 57;
    int mult = 101;
    int superior = 1;
    int max = 100;
    //variables
    double sem = 105;
    double rnd;
    double x;
    double v_esperado;
    double varianza;
    double sumaValor;
    double sumaValor1;
    double[] contador = new double[100];
    double[] frecuencia = new double[100];
    double[] frecuenciaAcumulada = new double[100];
    double[] filasX = new double[100];
    double[] probabilidadR = new double[100];
    double[] probabilidadRA = new double[100];
    DefaultTableModel tablamodel;
    

    /**
     * Creates new form Ejercicio_14
     */
    public Ejercicio_14() {
        initComponents();
        random();
        llenartabla();
    }

    private void random() {
//    int suma=0;
        for (int i = 0; i < 100; i++) {
            sem = (mult * sem + suma) % norm;
            rnd = sem / norm;
            x =  (1 / Math.sqrt(1 - rnd));
            filasX[i] =  x;
            sumaValor = sumaValor+x;
            sumaValor1=sumaValor+ Math.pow(x, 2);
        }
        v_esperado=sumaValor/max;
        varianza= Math.sqrt(Math.abs(sumaValor1/100-Math.pow(sumaValor/100, 2)));
        
    }

    private void frecuenciaA() {
        int aux = 0;
        for (int i = 0; i < filasX.length; i++) {
            for (int j = 0; j < filasX.length; j++) {
                if ((int)filasX[i] == (int)filasX[j]) {
                    if (numero((int)filasX[i])) {
                        contador[aux] = filasX[i];
                        aux++;
                    }
                }

            }

        }

    }

    private boolean numero(int num) {
        for (int i = 0; i < contador.length; i++) {
            if ((int)contador[i] == num) {
                return false;
            }
        }
        return true;
    }

    private void llenartabla() {
        frecuenciaA();
        frecuenciaAcumulada();
        calcularProbabilidad();
        probabilidadAcumulada();
        for (int i = 0; i < 8; i++) {
            if (frecuencia[i] != 0 && frecuenciaAcumulada[i] != 0) {
                tabla14.setValueAt(String.format("%.0f", contador[i]), i, 0);
                tabla14.setValueAt(String.format("%.0f", frecuencia[i]), i, 1);
                tabla14.setValueAt(String.format("%.0f", frecuenciaAcumulada[i]), i, 2);
                tabla14.setValueAt(String.format("%.3f", probabilidadR[i]), i, 3);
                tabla14.setValueAt(String.format("%.3f", probabilidadRA[i]), i, 4);
                
            }

        }
        labelVE.setText(String.format("%.4f",v_esperado));
        labelDesv.setText(String.format("%.4f",varianza));

    }

    private void frecuenciaAcumulada() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < contador.length; i++) {
                if ((int)contador[j] == (int)filasX[i]) {
                    frecuencia[j]++;
                }
            }
            System.out.println(frecuencia[j]);
        }
        for (int i = 0; i < frecuencia.length; i++) {
            if (frecuencia[i] != 0) {
                if (i == 0) {
                    frecuenciaAcumulada[i] = frecuencia[i];
                } else if (i == 1) {
                    frecuenciaAcumulada[i] = (frecuenciaAcumulada[i - 1] + frecuencia[i]);
                } else {
                    frecuenciaAcumulada[i] = (frecuenciaAcumulada[i - 1] + frecuencia[i]);
                }
            }
        }
    }
    
    private void calcularProbabilidad(){
    for (int i = 0; i < frecuencia.length; i++) {
            probabilidadR[i]=Double.valueOf(frecuencia[i])/max;
        }
    }
    
    private void probabilidadAcumulada(){
         for (int i = 0; i < probabilidadR.length; i++) {
            if (probabilidadR[i] != 0) {
    if(i==0){
            probabilidadRA[i]=probabilidadR[i];
        }else{
            probabilidadRA[i]=(probabilidadRA[i-1]+probabilidadR[i]);
        }
    }
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelVE = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelDesv = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla14 = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Ejercicio 14");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Escriba un programa para simular 100 valores de X, donde X tiene la función de densidad siguiente:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ejemplo14/ejercicio14.jpg.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMinimumSize(new java.awt.Dimension(70, 50));
        jLabel3.setPreferredSize(new java.awt.Dimension(157, 56));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Tambien Simular E(X), σ(x)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4))))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);
        add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(195, 150));

        jLabel6.setText("E(x) =");

        labelVE.setText("jLabel7");

        jLabel7.setText("Generador Utilizado");

        jLabel8.setText(" Norm = 128");

        jLabel9.setText("Suma = 57");

        jLabel10.setText("Mult = 101");

        jLabel11.setText("Sem = 105");

        jLabel12.setText("Max = 100");

        jLabel13.setText("σ(x) =");

        labelDesv.setText("jLabel7");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(labelVE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(labelDesv)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelVE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelDesv))
                .addGap(113, 113, 113))
        );

        add(jPanel3, java.awt.BorderLayout.WEST);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tabla14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "x", "f(x)", "F(x)", "p(x)= f(x)/max", "Total"
            }
        ));
        tabla14.setColumnSelectionAllowed(true);
        tabla14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla14.setMaximumSize(new java.awt.Dimension(2000, 2000));
        tabla14.setPreferredSize(new java.awt.Dimension(300, 500));
        tabla14.setRowHeight(20);
        jScrollPane3.setViewportView(tabla14);
        tabla14.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabla14.getColumnModel().getColumnCount() > 0) {
            tabla14.getColumnModel().getColumn(0).setMinWidth(8);
            tabla14.getColumnModel().getColumn(1).setMinWidth(80);
            tabla14.getColumnModel().getColumn(2).setMinWidth(80);
            tabla14.getColumnModel().getColumn(3).setMinWidth(80);
            tabla14.getColumnModel().getColumn(4).setMinWidth(80);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio_14().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDesv;
    private javax.swing.JLabel labelVE;
    private javax.swing.JTable tabla14;
    // End of variables declaration//GEN-END:variables
}
