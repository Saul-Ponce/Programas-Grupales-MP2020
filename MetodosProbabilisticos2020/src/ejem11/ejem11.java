/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem11;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Saul Ponce
 */
public class ejem11 extends javax.swing.JFrame {

    final int norm = 1000;
    final int suma = 487;
    final int mult = 8601;

    int i, max, j;
    long sem;
    double rnd;
    Double p;
    Double q;
    Double probabilidad;
    int[] x;
    int[] xAgrupado;
    int[] frecuencia;
    int[] frecuenciaA;
    public int[] FrecuenciaA;
    public double[] ProbReal;
    public double[] ProbRealA;
    Double sum;
    DefaultTableModel modelo;
    /**
     * Creates new form ejem11
     */
    public ejem11() {
        initComponents();
        probabilidad = 0.0;
        x = new int[100];
        xAgrupado = new int[100];
        frecuencia = new int[100];
        FrecuenciaA = new int[100];
        ProbReal = new double[100];
        ProbRealA = new double[100];
        modelo =(DefaultTableModel) tabla11.getModel();
        //Random();
    }

    public void Random() {
        for (j = 1; j < max; j++) {
            sem = (mult * sem + suma) % norm;
            rnd = (double) sem / norm;
            probabilidad = p;
            sum = p;
            i = 1;
            while (rnd >= sum) {
                probabilidad = q * probabilidad;
                sum += probabilidad;
                i++;
                
            }
            x[j]=i;
            
            System.out.println("el " + j + " tiempo de espera es: " + i);
        }
    }
    
       
    
    public void agrupar(int i){
        for (int k = 0; k < x.length; k++) {
            if(x[k]==i){
                frecuencia[k]++;
            }else{
                x[k] = i;
                frecuencia[k]++;
            }
        }
    } 
    private void frecuenciaAbsoluta() {
        for (int j = 0; j < xAgrupado.length; j++) {
            for (int i = 0; i < xAgrupado.length; i++) {
                if (xAgrupado[j] == x[i]) {
                    frecuencia[j]++;
                }
            }
            //System.out.println(frecuencia[j]);
        }
    }
    
    public void fAcumulada(int frecuencia, int i){
        if(i==0){
            FrecuenciaA[i]=frecuencia;
        }else if(i==1){
            FrecuenciaA[i]=(FrecuenciaA[i-1]+frecuencia);
        }else{
            FrecuenciaA[i]=(FrecuenciaA[i-1]+frecuencia);
        }
    }
      private void frecuenciaA() {
        int aux = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                if (x[i] == x[j]) {
                    if (numero(x[i])) {
                        xAgrupado[aux] = x[i];
                        aux++;
                    }
                }

            }

        }

    }

    private boolean numero(int num) {
        for (int i = 0; i < xAgrupado.length; i++) {
            if (xAgrupado[i] == num) {
                return false;
            }
        }
        return true;
    }
    
    public void calculaProbabilidad(int[] contador){
        for (int i = 0; i < contador.length; i++) {
            ProbReal[i]=Double.valueOf(contador[i])/max;
        }
    }
    
    public void PAcumulada(double probabilidad, int i){

        if(i==0){
            ProbRealA[i]=probabilidad;
        }else{
            ProbRealA[i]=(ProbRealA[i-1]+probabilidad);
        }
    }
    
    private void llenarTabla(){
        String[] datos = new String[5];
        for (int k = 0; k < frecuencia.length; k++) {
            fAcumulada(frecuencia[k], k);
            PAcumulada(ProbReal[k], k);
            if(xAgrupado[k]!=0){
            datos[0] = xAgrupado[k]+"";
            datos[1] = frecuencia[k]+"";
            datos[2] = FrecuenciaA[k]+"";
            datos[3] = ProbReal[k]+"";
            datos[4] = ProbRealA[k]+"";
            //tabla11.setValueAt(xAgrupado[i], i, 0);
            modelo.addRow(datos);
            }
        }
        tabla11.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabla11 = new javax.swing.JTable();
        txtMax = new javax.swing.JTextField();
        txtProbabilidad = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tabla11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X", "f(x)", "F(x)", "P(x)", "P(x) Acumulada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla11.setRowHeight(60);
        jScrollPane2.setViewportView(tabla11);

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("N. Simulaciones");

        jLabel2.setText("Probabilidad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtProbabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jButton2)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMax)
                    .addComponent(txtProbabilidad, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtMax.getText() == "" && txtProbabilidad.getText() == "") {
            JOptionPane.showMessageDialog(this, "Campo/s vacio/s");
        } else if (max >= 1000) {
            JOptionPane.showMessageDialog(this, "Numero de simulaciones incorrectas");
            txtMax.setText("");
            txtMax.requestFocus();
        } else {
            max = Integer.parseInt(txtMax.getText());
            p = Double.parseDouble(txtProbabilidad.getText());
            if (p < 0 || p > 1) {
                JOptionPane.showMessageDialog(this, "probabilidad incorrecta");
                txtProbabilidad.setText("");
                txtProbabilidad.requestFocus();
            } else {
                p = Double.parseDouble(txtProbabilidad.getText());
                q = 1 - p;
                sem = 10;
                Random();
                frecuenciaA();
                frecuenciaAbsoluta();
                calculaProbabilidad(frecuencia);
                llenarTabla();
            }
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ejem11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ejem11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ejem11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ejem11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ejem11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla11;
    private javax.swing.JTextField txtMax;
    private javax.swing.JTextField txtProbabilidad;
    // End of variables declaration//GEN-END:variables
}
