/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import inyeccion.funcionalidad;

/**
 * @author sergi
 */
public class categoriaForm extends javax.swing.JFrame{

    /**
     * Creates new form categoriaForm
     */
    public categoriaForm(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(){

        nombre = new javax.swing.JTextField();
        descri = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("codigo de categoria");

        jLabel2.setText("nombre de categoria");

        jLabel3.setText("descripcion");

        jButton1.setText("Agregar categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25 , 25 , 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(114 , 114 , 114)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(descri , javax.swing.GroupLayout.PREFERRED_SIZE , 72 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nombre , javax.swing.GroupLayout.PREFERRED_SIZE , 72 , javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(codigo , javax.swing.GroupLayout.PREFERRED_SIZE , 72 , javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(127 , 127 , 127)
                                                .addComponent(jButton1 , javax.swing.GroupLayout.PREFERRED_SIZE , 119 , javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(154 , Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(11 , 11 , 11)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigo , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(5 , 5 , 5)
                                .addComponent(nombre , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descri , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31 , 31 , 31)
                                .addComponent(jButton1)
                                .addContainerGap(69 , Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButton1ActionPerformed

        funcionalidad funcionalidad = new funcionalidad();
        String codigo = this.codigo.getText();
        String nombre = this.nombre.getText();
        String descri = this.descri.getText();
        String guardar = codigo + "," + nombre + "," + descri;
        System.out.println(codigo);
        System.out.println(nombre);
        System.out.println(descri);
        System.out.println(guardar);
        funcionalidad.escribirDb("categorias" , guardar);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(categoriaForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (InstantiationException ex){
            java.util.logging.Logger.getLogger(categoriaForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (IllegalAccessException ex){
            java.util.logging.Logger.getLogger(categoriaForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex){
            java.util.logging.Logger.getLogger(categoriaForm.class.getName()).log(java.util.logging.Level.SEVERE , null , ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new categoriaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField descri;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}