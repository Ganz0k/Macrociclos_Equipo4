/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guis;

import control.ControlCalculadoraVolumen;
import entidades.Macrociclo;
import enumeradores.Operacion;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import utils.ButtonEditor;
import utils.ButtonRenderer;

/**
 *
 * @author Yorsh
 */
public class CalculadoraVolumenFrame extends javax.swing.JFrame {

    private final ControlCalculadoraVolumen control;
    private final Operacion operacion;
    private Macrociclo macrociclo;
    private final INegocio fachadaNegocio = new FachadaNegocio();
    
    /**
     * Creates new form CalculadoraVolumenFrame
     * @param operacion
     */
    public CalculadoraVolumenFrame(Operacion operacion) {
        initComponents();
        
        this.operacion = operacion;
        this.control = new ControlCalculadoraVolumen();
        this.tablaCalculadora.getColumnModel().getColumn(20).setCellRenderer(new ButtonRenderer());
        this.tablaCalculadora.getColumnModel().getColumn(20).setCellEditor(new ButtonEditor(new JTextField("Calcular"), this, this.tablaCalculadora));
        this.macrociclo = fachadaNegocio.obtenerMacrociclo(new ObjectId("6540abc7eb7a0415d79ba288"));
        
        if (operacion.equals(Operacion.ACTUALIZAR)) {
            this.control.cargarTabla(macrociclo, (DefaultTableModel) this.tablaCalculadora.getModel());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalculadora = new javax.swing.JTable();
        btnNuevoMedio = new javax.swing.JButton();
        btnEliminarMedio = new javax.swing.JButton();
        btnGuardarMedios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculadora de volumen");

        tablaCalculadora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Medios", "Min", "Max", "Promedio", "Ins.", "Semanas", "V. etapa", "Min", "Max", "Promedio", "Ins.", "Semanas", "V. etapa", "Min", "Max", "Promedio", "Ins.", "Semanas", "V. etapa", "Volumen total", "Calcular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, false, true, true, false, true, true, false, true, true, false, true, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCalculadora);

        btnNuevoMedio.setText("Añadir nuevo medio");
        btnNuevoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedioActionPerformed(evt);
            }
        });

        btnEliminarMedio.setText("Eliminar medio físico");
        btnEliminarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMedioActionPerformed(evt);
            }
        });

        btnGuardarMedios.setText("Guardar medios físicos");
        btnGuardarMedios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMediosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Calculadora de Volumen");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Etapa General");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Etapa Especial");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Etapa Competitiva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevoMedio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarMedio))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(226, 226, 226)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(406, 406, 406)
                                    .addComponent(btnGuardarMedios))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(407, 407, 407)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(133, 133, 133)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoMedio)
                    .addComponent(btnEliminarMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarMedios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedioActionPerformed
        this.control.anadirNuevaFila((DefaultTableModel) this.tablaCalculadora.getModel());
    }//GEN-LAST:event_btnNuevoMedioActionPerformed

    private void btnEliminarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMedioActionPerformed
        this.control.eliminarFila(this, tablaCalculadora);
    }//GEN-LAST:event_btnEliminarMedioActionPerformed

    private void btnGuardarMediosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMediosActionPerformed
        this.control.acrualizarMediosFisicos(this, new ObjectId("6540abc7eb7a0415d79ba288"), (DefaultTableModel) this.tablaCalculadora.getModel());
    }//GEN-LAST:event_btnGuardarMediosActionPerformed

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
            java.util.logging.Logger.getLogger(CalculadoraVolumenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraVolumenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraVolumenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraVolumenFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraVolumenFrame(Operacion.ACTUALIZAR).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarMedio;
    private javax.swing.JButton btnGuardarMedios;
    private javax.swing.JButton btnNuevoMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCalculadora;
    // End of variables declaration//GEN-END:variables
}
