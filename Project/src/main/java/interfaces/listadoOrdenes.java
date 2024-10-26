/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import inyeccion.funcionalidad;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergi
 */
public class listadoOrdenes extends javax.swing.JFrame {

    private static listadoOrdenes esVisible;

    /**
     * Creates new form listadoOrdenes
     */
    public listadoOrdenes() {
        initComponents();
        llenartabla();
    }

                         

    private void llenartabla() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("PRODUCTO");
        model.addColumn("CANTIDAD");
        model.addColumn("PRECIO");
        model.addColumn("TOTAL");
        model.addColumn("COMENTARIO");
        model.addColumn("ESTADO");

        tablaCategoria.setModel(model);
        funcionalidad funcionalidad = new funcionalidad();

        ArrayList<ArrayList<String>> ordenes = funcionalidad.leerDb("ordenes");
        ArrayList<ArrayList<String>> categorias = funcionalidad.leerDb("productos");
        ArrayList<ArrayList<String>> listadoLimpio = new ArrayList<>();

        String nombrProducto = "";
        for (ArrayList<String> row : ordenes) {
            nombrProducto = "NA";

            for (ArrayList<String> cat : categorias) {
                if (row.get(1).trim().equals(cat.get(0).trim())) {
                    nombrProducto = cat.get(1);
                }

            }
            ArrayList<String> nuevoListado = new ArrayList<>();
            nuevoListado.add(row.get(0));
            nuevoListado.add(nombrProducto);
            nuevoListado.add(row.get(2));
            nuevoListado.add(row.get(3));
            nuevoListado.add(row.get(4));
            nuevoListado.add(row.get(5));
            nuevoListado.add(row.get(6));
            listadoLimpio.add(nuevoListado);
        }

        for (ArrayList<String> row : listadoLimpio) {
            model.addRow(new Object[]{row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6)});
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
        tablaCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "DESCRIPCION"
            }
        ));
        jScrollPane1.setViewportView(tablaCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
           esVisible = null;
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(listadoOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listadoOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listadoOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listadoOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listadoOrdenes().setVisible(true);
            }
        });
    }

    public static listadoOrdenes obtenerPantalla() {
        if (esVisible == null) {
            esVisible = new listadoOrdenes();
            obtenerPantalla().setVisible(true);
        }
        return esVisible;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCategoria;
    // End of variables declaration//GEN-END:variables
}
