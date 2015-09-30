 
package vista;

import controlador.ControladorIngresar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

 
public class Inicio extends javax.swing.JFrame {

    private Ingresar ingresar;
    private ControladorIngresar controladorIngreso;
    
    public Inicio() {
        ingresar = new Ingresar(this, true);
        controladorIngreso = new ControladorIngresar(ingresar, this);
        initComponents();
        itemSalir.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBaseInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        itemIngresar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlBaseInicio.setBackground(new java.awt.Color(5, 5, 28));
        pnlBaseInicio.setPreferredSize(new java.awt.Dimension(979, 605));

        jLabel1.setBackground(new java.awt.Color(5, 5, 28));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SISTEMA DE VENTAS DE LIBROS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imagenes/librería.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBaseInicioLayout = new javax.swing.GroupLayout(pnlBaseInicio);
        pnlBaseInicio.setLayout(pnlBaseInicioLayout);
        pnlBaseInicioLayout.setHorizontalGroup(
            pnlBaseInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseInicioLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        pnlBaseInicioLayout.setVerticalGroup(
            pnlBaseInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseInicioLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(5, 5, 28));
        jMenuBar1.setBorder(null);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(58, 35));

        menuInicio.setBackground(new java.awt.Color(5, 5, 28));
        menuInicio.setForeground(new java.awt.Color(5, 5, 28));
        menuInicio.setText("INICIO");
        menuInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInicioMouseClicked(evt);
            }
        });

        itemIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemIngresar.setText("Ingresar");
        itemIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemIngresarMouseClicked(evt);
            }
        });
        itemIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIngresarActionPerformed(evt);
            }
        });
        menuInicio.add(itemIngresar);

        itemSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemSalirMouseClicked(evt);
            }
        });
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuInicio.add(itemSalir);

        jMenuBar1.add(menuInicio);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");
        jMenuBar1.setBackground(new java.awt.Color(51,51,55));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBaseInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBaseInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInicioMouseClicked
        
    }//GEN-LAST:event_menuInicioMouseClicked

    private void itemSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemSalirMouseClicked
        
    }//GEN-LAST:event_itemSalirMouseClicked

    private void itemIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemIngresarMouseClicked
        
    }//GEN-LAST:event_itemIngresarMouseClicked

    private void itemIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIngresarActionPerformed
        controladorIngreso.inicializarIngreso();
        ingresar.setVisible(true);
    }//GEN-LAST:event_itemIngresarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        Inicio ini=new Inicio();
        pnlBaseInicio.removeAll();
        pnlBaseInicio.add(ini.getPnlBaseInicio());
        pnlBaseInicio.updateUI();
        itemIngresar.setVisible(true);
        itemSalir.setVisible(false);
    }//GEN-LAST:event_itemSalirActionPerformed

    public JMenuItem getItemIngresar() {
        return itemIngresar;
    }

    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public JMenu getMenuInicio() {
        return menuInicio;
    }

    public JPanel getPnlBaseInicio() {
        return pnlBaseInicio;
    }

    
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemIngresar;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JPanel pnlBaseInicio;
    // End of variables declaration//GEN-END:variables
}
