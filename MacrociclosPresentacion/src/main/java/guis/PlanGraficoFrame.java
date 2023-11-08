/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import control.ControlPlanGrafico;
import entidades.Macrociclo;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import teststuff.MacrocicloDAOTest;

/**
 *
 * @author Yorsh
 */
public class PlanGraficoFrame extends javax.swing.JFrame {

    private Macrociclo macrociclo;
    private final MacrocicloDAOTest dao = new MacrocicloDAOTest();
    private final ControlPlanGrafico controlPlanGrafico;

    /**
     * Creates new form VolumenMedioFisicoFrame
     */
    public PlanGraficoFrame() {
        initComponents();

        this.macrociclo = dao.obtenerMacrociclo(new ObjectId("6540abc7eb7a0415d79ba288"));
        this.controlPlanGrafico = new ControlPlanGrafico();
        this.controlPlanGrafico.setTableModel(this.planGrafico, this.macrociclo);
        this.controlPlanGrafico.cargarTabla((DefaultTableModel) this.planGrafico.getModel(), this.macrociclo.getMesociclos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanePlanGrafico = new javax.swing.JScrollPane();
        planGrafico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnGuardarMicrociclos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plan gráfico");

        planGrafico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPanePlanGrafico.setViewportView(planGrafico);

        jLabel1.setText("Distribución de volumen plan gráfico");

        btnGuardarMicrociclos.setText("Guardar microciclos");
        btnGuardarMicrociclos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMicrociclosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanePlanGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(385, 385, 385))
            .addGroup(layout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(btnGuardarMicrociclos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePlanGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarMicrociclos)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMicrociclosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMicrociclosActionPerformed
        this.controlPlanGrafico.guardarMicrociclos(this, macrociclo, (DefaultTableModel) this.planGrafico.getModel());
    }//GEN-LAST:event_btnGuardarMicrociclosActionPerformed

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
            java.util.logging.Logger.getLogger(PlanGraficoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanGraficoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanGraficoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanGraficoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanGraficoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarMicrociclos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable planGrafico;
    private javax.swing.JScrollPane scrollPanePlanGrafico;
    // End of variables declaration//GEN-END:variables
}
