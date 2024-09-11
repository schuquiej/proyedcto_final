/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import inyeccion.funcionalidad;
import modelos.Item;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;


/**
 * @author sergi
 */
public class listadoCategoriasForm extends javax.swing.JFrame{

    /**
     * Creates new form listadoCategoriasForm
     */
    public listadoCategoriasForm(){
        initComponents();
        llenartabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(){

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null , null , null} , {null , null , null} , {null , null , null} , {null , null , null}} , new String[]{"CODIGO" , "NOMBRE" , "DESCRIPCION"}));
        jScrollPane1.setViewportView(tablaCategoria);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING , layout.createSequentialGroup().addContainerGap(19 , Short.MAX_VALUE).addComponent(jScrollPane1 , javax.swing.GroupLayout.PREFERRED_SIZE , 375 , javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1 , javax.swing.GroupLayout.PREFERRED_SIZE , 275 , javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(19 , Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try{
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(listadoCategoriasForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(listadoCategoriasForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(listadoCategoriasForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(listadoCategoriasForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new listadoCategoriasForm().setVisible(true);
            }
        });

    }


    private void llenartabla(){


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CODIGO");
        model.addColumn("NOMBRE");
        model.addColumn("DESCRIPCION");
        tablaCategoria.setModel(model);

        funcionalidad funcionalidad = new funcionalidad();

        ArrayList<ArrayList<String>> resultado = funcionalidad.leerDb("categorias");
        for (ArrayList<String> row : resultado){
            System.out.println(row);
            model.addRow(new Object[]{row.get(0) , row.get(1) , row.get(2)});
        }


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCategoria;
    // End of variables declaration//GEN-END:variables
}