/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import controlador.ConexionPostgresql;
import controlador.Controlador;
import controlador.LibroIndice;
import controlador.ListaVentas;
import controlador.VentaBD;
import java.awt.Window;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.JavaPdf;
import modelo.Libro;

/**
 *
 * @author Alejandra
 */
public class RegistroVentas extends javax.swing.JDialog {

        ListaVentas librosPorVender;
        DefaultTableModel tablaVentas;
        String[] cabecera;
         //boolean[] editables;
        public ArrayList<Libro> ventas;
        //SpinnerVentas cnt = new SpinnerVentas(1,this); 
        
    
    /**
     * Creates new form RegistroVentas
     */
    public RegistroVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tablaVentas = (DefaultTableModel)ventaJTable.getModel();
        librosPorVender = new ListaVentas();
        establecerTabla();
        ponerFecha();
    }
    
    public Object colocar(int stock){
        SpinnerVentas cnt = new SpinnerVentas(1,this, stock);
        ventaJTable.getColumn("Cantidad").setCellEditor(cnt);
        return cnt.getCellEditorValue();
    }
    
    public void establecerTabla(){
        
         
        //cabecera = new String[]{"Cantidad","Nombre del Libro","Autor del Libro","Costo Unitario", "Costo Total"};
        //ventas = librosPorVender.getLibrosAgregados();
        //Object[][] arregloDatosLibro = conseguirDatosLibro();
        
        //tablaVentas.setDataVector(arregloDatosLibro, cabecera);
        
        
        
        
        ventaJTable.setRowHeight(30);
    }
    
    private Object[][] conseguirDatosLibro(){
        Object[][] datosLibro = new Object[ventas.size()][];
        
        for (int i = 0; i < datosLibro.length; i++) {
            datosLibro[i] = convertirArrayAArreglo(ventas.get(i));
        }
        
        return datosLibro;
    }
    
    
    
    
    private Object[] convertirArrayAArreglo(Libro libro){
        Object [] respuesta = new Object[5];
        
        //SpinnerVentas cnt = new SpinnerVentas(1,this);
        respuesta[0] = 1;
        respuesta[1] = libro.getNombreLibro();
        respuesta[2] = libro.getAutorLibro();
        respuesta[3] = libro.getCostoVenta();
        respuesta[4] = (Double)(libro.getCostoVenta() * (Integer)respuesta[0]);
        
        return respuesta;
    }

    private void setListeners(Controlador c) {
       // agregarJB.addMouseListener(c);
       // eliminarJB.addMouseListener(c);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        agregarJB = new javax.swing.JButton();
        TablaJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ventaJTable = new javax.swing.JTable();
        registrarJB = new javax.swing.JButton();
        eliminarJB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Ventas");

        jPanel1.setBackground(new java.awt.Color(5, 5, 28));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE VENTAS");

        DCliente.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Cliente :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("NIT/CI  :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fecha :");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DClienteLayout = new javax.swing.GroupLayout(DCliente);
        DCliente.setLayout(DClienteLayout);
        DClienteLayout.setHorizontalGroup(
            DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DClienteLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DClienteLayout.createSequentialGroup()
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        DClienteLayout.setVerticalGroup(
            DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DClienteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(DClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        agregarJB.setText("Agregar Libro");
        agregarJB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarJBMouseClicked(evt);
            }
        });

        ventaJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Nombre", "Autor", "Precio", "PrecioTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ventaJTable);

        javax.swing.GroupLayout TablaJPanelLayout = new javax.swing.GroupLayout(TablaJPanel);
        TablaJPanel.setLayout(TablaJPanelLayout);
        TablaJPanelLayout.setHorizontalGroup(
            TablaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        TablaJPanelLayout.setVerticalGroup(
            TablaJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TablaJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        registrarJB.setText("Generar Factura");
        registrarJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarJBActionPerformed(evt);
            }
        });

        eliminarJB.setText("Eliminar Libro");
        eliminarJB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarJBMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("TOTAL A PAGAR :");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarJB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarJB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TablaJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registrarJB, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eliminarJB)
                    .addComponent(agregarJB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TablaJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addComponent(registrarJB)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        int total = suma();
        this.txtTotal.setText( String.valueOf(total) );
    }//GEN-LAST:event_txtTotalActionPerformed

    private int suma()
    {
        int total = 0;
        //recorrer todas las filas de la segunda columna y va sumando las cantidades
        for( int i=0 ; i<ventaJTable.getRowCount() ; i++)
        {
            int numero =0;
            try{
                //capturamos valor de celda
                numero = Integer.valueOf( ventaJTable.getValueAt(i, 4).toString() );
            }
            catch (NumberFormatException nfe){ //si existe un error se coloca 0 a la celda
                numero = 0;
                tablaVentas.setValueAt(0, i, 5);
            }
            //se suma al total
            total += numero;
        }
        //muestra en el componente
        return total;
    }

    
    private void eliminarJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarJBMouseClicked
         if(getVentaTabla().getSelectedRow() >= 0)
        {
            eliminarFilaVenta(getSelectedRow());
        }
    }//GEN-LAST:event_eliminarJBMouseClicked

    private void agregarJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarJBMouseClicked
        
        BuscadorLibros buscadorLibros = new BuscadorLibros(new javax.swing.JDialog(), true);
                buscadorLibros.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        Window buscador = e.getWindow();
                        if(buscador instanceof JDialog)
                            ((JDialog)buscador).dispose();
                    }
                });
                buscadorLibros.setVisible(true);
                
        Libro libro = buscadorLibros.getLibroBuscado();
       //Libro libro = new Libro(1, "El Resplandor", "Stephen King", "Novela terror", 12, 30.0, 35.0);
       
       String [] datos = {"1", libro.getNombreLibro(), libro.getAutorLibro(), ""+libro.getCostoVenta(), "12"};        
       
        anadirFilaVenta(datos);
        int total = suma();
        this.txtTotal.setText( String.valueOf(total) );
    }//GEN-LAST:event_agregarJBMouseClicked

    private void registrarJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarJBActionPerformed
        //Para obtener las entradas
        String cliente = txtCliente.getText();
        String fecha = txtFecha.getText();
        String nit = txtNit.getText();
        String total = txtTotal.getText();
                
        //Sacar datos de tabla
        String[] tablaTitulo = {"Cantidad", "Nombre", "Autor", "Precio", "Precio Total"};
        int rows = ventaJTable.getRowCount();
        int columns = ventaJTable.getColumnCount();

        Object[][] tabla = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                tabla[i][j] = ventaJTable.getValueAt(i, j);
            }
        }
        
        //Sacar nombres de libros, para insercion en BD, detalle_venta
        //Sacar precio parcial para insertar a detalle_venta
        String [] libros = new String [rows];
        String [] parciales = new String [rows];
        int n=1;
        int p=4;
        for(int k=0; k<rows; k++){
            libros[k] = (String) ventaJTable.getValueAt(k, n);
            parciales[k] = (String) ventaJTable.getValueAt(k, p);
        }
                  
         //Poner datos en BD, cliente, venta
        insertarBD(cliente, nit, fecha, total,libros, parciales);

        //Enviamos detalle de venta para pdf
        JavaPdf miPdf = new JavaPdf("factura", "Libreria");
        miPdf.generarFactura(fecha, cliente, nit, tabla, total, rows, columns, tablaTitulo);
        miPdf.shownPdf();
    }//GEN-LAST:event_registrarJBActionPerformed

     private void ponerFecha() {
        Date fec = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = sdf.format(fec);
        txtFecha.setText(fecha);
        txtFecha.setEditable(false);
    }
                                              

    private void insertarDetalle(String [] libros, int idV, String[] parciales){
         System.out.println("Entra a insertar detalle");
        LibroIndice lb = new LibroIndice(libros, idV, parciales);
        lb.insertarEnBD();
        
    }
    
    private void insertarBD(String nombre, String ci, String fecha, String total, String [] libros, String [] parciales) {
        
        String sql="INSERT INTO cliente (ci, nombre) VALUES ("+ci+", '" + nombre + "')";
        boolean res = ConexionPostgresql.updateDB(sql);
        
        if(res=true){
            System.out.println("Cliente registrado");
        }
        
        String sql2="INSERT INTO venta (ci, id_libreria, fecha, total) VALUES ("+ci+", '"+1+"', '"+fecha+"', "+total+")";
        res = ConexionPostgresql.updateDB(sql2);
        if(res=true){
            System.out.println("Venta registrada");
        }
        
        //Para la inserción en detalle_Venta
        VentaBD vt= new VentaBD();
        int fin  = vt.getVentas().size();
        int idV = vt.getVentas().get(fin-1).getId_venta();
        System.out.println("El indice: "+idV);
        System.out.println("Sale de consulta");
        insertarDetalle(libros, idV, parciales);
             
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
            java.util.logging.Logger.getLogger(RegistroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controlador c = new Controlador();
                RegistroVentas dialog = new RegistroVentas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DCliente;
    private javax.swing.JPanel TablaJPanel;
    private javax.swing.JButton agregarJB;
    private javax.swing.JButton eliminarJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registrarJB;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTable ventaJTable;
    // End of variables declaration//GEN-END:variables

    public JButton getAgregar()
    {
        return agregarJB;
    }
    
    public JButton getEliminar()
    {
        return eliminarJB;
    }
    
    public JTable getVentaTabla()
    {
        return ventaJTable;
    }
    
    public int getSelectedRow()
    {
        return ventaJTable.getSelectedRow();
    }
    
    public void anadirFilaVenta(String [] dataRow)
    {
	((DefaultTableModel)ventaJTable.getModel()).addRow(dataRow);
    }
    
    public void eliminarFilaVenta(int rowIndex)
    {
        ((DefaultTableModel)ventaJTable.getModel()).removeRow(rowIndex);
    }
    
    private String precioTotal()
    {
        String res = "";
        
        
        
        return res;
    }
}
