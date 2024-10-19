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
public class listadoProductos extends javax.swing.JFrame {

    /**
     * Creates new form listodoProductos
     */
    private static listadoProductos esVisible;

    public listadoProductos() {
        initComponents();
        llenartabla();
    }

    private void llenartabla() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO DE PRODUCTO");
        model.addColumn("NOMBRE");
        model.addColumn("CATEGORIA");
        tablaCategoria.setModel(model);
        funcionalidad funcionalidad = new funcionalidad();

        ArrayList<ArrayList<String>> productos = funcionalidad.leerDb("productos");
        ArrayList<ArrayList<String>> categorias = funcionalidad.leerDb("categorias");
        ArrayList<ArrayList<String>> listadoLimpio = new ArrayList<>();

        String nombreCategoria = "";
        for (ArrayList<String> row : productos) {
            nombreCategoria = "NA";

            for (ArrayList<String> cat : categorias) {
                if (row.get(3).trim().equals(cat.get(0).trim())) {
                    nombreCategoria = cat.get(1);
                }

            }
            ArrayList<String> nuevoListado = new ArrayList<>();
            nuevoListado.add(row.get(0));
            nuevoListado.add(row.get(1));
            nuevoListado.add(nombreCategoria);
            listadoLimpio.add(nuevoListado);
        }

        for (ArrayList<String> row : listadoLimpio) {
            model.addRow(new Object[]{row.get(0), row.get(1), row.get(2)});
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(listadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listadoProductos().setVisible(true);
            }
        });
    }

    public static listadoProductos obtenerPantalla() {
        if (esVisible == null) {
            esVisible = new listadoProductos();
            obtenerPantalla().setVisible(true);
        }
        return esVisible;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCategoria;
    // End of variables declaration//GEN-END:variables
}
