package vista;//GEN-LINE:variables

import controlador.Restriccion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class RegistroVenta2 extends JPanel 
{
    
    private JPanel panelTabla;
    private JPanel pnlDatosCliente;
    private JPanel pnlTablaCompra;
    
    private JScrollPane scrollPanel;
    private JScrollPane scrollTabla;
    private JScrollPane pane;
    
    private JTable tablaDesplegable;
    private JTable tablaCompra;
    private final String[] titulosTabla = {"TITULO","AUTOR","GENERO","EDICION",
                  "CANTIDAD","COMPRA","VENTA","MINIMO"};
    
    private JTextFieldP txtTitulo;
    private JTextFieldP txtAutor;
    private JTextFieldP txtGenero;
    private JTextFieldP txtEdicion;
    private JTextFieldP txtCantidad;
    private JTextFieldP txtPrecio;
    
    private JTextField txtNit;
    private JTextField txtCliente;
    
    private JLabel lblNit;
    private JLabel lblCliente;
    private JLabel lblAux;
    
    JTextField campo = new JTextField();
    private Restriccion restriccion;
    
    public RegistroVenta2() {
        restriccion = new Restriccion();
        initComponents();
        initOtherComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelTituloBuscar = new javax.swing.JLabel();
        comboBoxBuscarEn = new javax.swing.JComboBox();
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnVender = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(5, 5, 28));
        setPreferredSize(new java.awt.Dimension(798, 556));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE VENTAS");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel1);
        jLabel1.setBounds(4, 11, 770, 59);

        labelTituloBuscar.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        labelTituloBuscar.setForeground(new java.awt.Color(255, 255, 255));
        labelTituloBuscar.setText("Buscar :");
        add(labelTituloBuscar);
        labelTituloBuscar.setBounds(46, 74, 82, 25);

        comboBoxBuscarEn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lista de libros", "libros dados de baja" }));
        add(comboBoxBuscarEn);
        comboBoxBuscarEn.setBounds(47, 105, 170, 30);

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnLimpiar.setText("Limpiar");
        add(btnLimpiar);
        btnLimpiar.setBounds(600, 100, 90, 26);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAgregar.setText("Agregar");
        add(btnAgregar);
        btnAgregar.setBounds(700, 100, 90, 26);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("TOTAL A PAGAR :");
        add(jLabel5);
        jLabel5.setBounds(570, 490, 107, 30);

        btnVender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnVender.setText("Vender");
        add(btnVender);
        btnVender.setBounds(707, 530, 90, 26);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        add(btnEliminar);
        btnEliminar.setBounds(610, 530, 90, 26);

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        add(txtTotal);
        txtTotal.setBounds(690, 489, 100, 30);
    }// </editor-fold>                        

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void initOtherComponents() {
        txtTitulo = new JTextFieldP();
        txtAutor = new JTextFieldP();
        txtGenero = new JTextFieldP();
        txtEdicion = new JTextFieldP();
        txtCantidad = new JTextFieldP();
        txtPrecio = new JTextFieldP();
        
        txtNit = new JTextField(15);
        txtCliente = new JTextField(25);

        panelTabla = new JPanel();
        pnlTablaCompra = new JPanel();
        
        scrollPanel = new JScrollPane();
        scrollTabla = new JScrollPane();
        pane = new JScrollPane();
        
        tablaDesplegable = new JTable();
        tablaCompra = new JTable();
        
        lblNit = new JLabel();
        lblCliente = new JLabel();
        lblAux = new JLabel();
        
        panelTabla.setPreferredSize(new Dimension(900, 275));
        panelTabla.setLayout(null);
        
        DefaultTableModel tableModel = (DefaultTableModel)tablaDesplegable.getModel();
        tableModel.setDataVector(null, titulosTabla);
        
        tableModel = (DefaultTableModel)tablaDesplegable.getModel();
        tableModel.setDataVector(null, titulosTabla);
        
        TableColumnModel columnModel = tablaDesplegable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(200);
        columnModel.getColumn(1).setPreferredWidth(200);
        columnModel.getColumn(2).setPreferredWidth(130);
        columnModel.getColumn(3).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        
        scrollTabla.setViewportView(tablaDesplegable);
        panelTabla.add(scrollTabla);
        scrollTabla.setBounds(0, 0, 900, 275);
        
        scrollPanel.setViewportView(panelTabla);
        add(scrollPanel);
        scrollPanel.setBounds(47, 166, 748, 300);
        scrollPanel.setVisible(false);

        txtTitulo.setPlaceholder("titulo");
        add(txtTitulo);
        txtTitulo.setBounds(47, 140, 190, 30);

        txtAutor.setPlaceholder("autor");
        add(txtAutor);
        txtAutor.setBounds(233, 140, 190, 30);

        txtGenero.setPlaceholder("genero");
        add(txtGenero);
        txtGenero.setBounds(419, 140, 110, 30);

        txtEdicion.setPlaceholder("edición");
        add(txtEdicion);
        txtEdicion.setBounds(525, 140, 110, 30);

        txtCantidad.setPlaceholder("cantidad");
        add(txtCantidad);
        txtCantidad.setBounds(631, 140, 90, 30);

        txtPrecio.setPlaceholder("precio");
        add(txtPrecio);
        txtPrecio.setBounds(717, 140, 110, 30);
     
        pnlDatosCliente = new JPanel();
        add(pnlDatosCliente);
        
        pnlDatosCliente.setBounds(50, 180, 740, 50);
        pnlDatosCliente.setBackground(new Color(153,153,153));
        
        lblNit.setFont(new Font("Tahoma", 1, 13));
        lblNit.setText("NIT/CI :");
        pnlDatosCliente.add(lblNit);           
        pnlDatosCliente.add(txtNit);
        
        lblAux.setFont(new Font("Tahoma", 1, 13));
        lblAux.setText("----------------");
        lblAux.setForeground(new Color(153,153,153));
        pnlDatosCliente.add(lblAux);
        
        lblCliente.setFont(new Font("Tahoma", 1, 13));
        lblCliente.setText("CLIENTE :");
        pnlDatosCliente.add(lblCliente);       
        pnlDatosCliente.add(txtCliente);
        
        
        add(pnlTablaCompra);
        
        pnlTablaCompra.setBounds(50, 240, 740, 245);
        
        tablaCompra.setModel(new DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "CANTIDAD", "NOMBRE", "AUTOR",  "PRECIO", "PRECIO TOTAL"
            }
        ) 
        {
            Class[] types = new Class [] {
                java.lang.String.class,  java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        
        TableColumn columna = tablaCompra.getColumnModel().getColumn(0);
        columna.setCellEditor(new DefaultCellEditor (campo));
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                if(!restriccion.esEntero(caracter, 3, campo)){
                    e.consume();
                } else {
                    campo.setEditable(true);
                }
            }
        });
        tablaCompra.setRowHeight(25);
        tablaCompra.setPreferredSize(new Dimension(725, 200));
        tablaCompra.getTableHeader().setReorderingAllowed(false);

        tablaCompra.setPreferredScrollableViewportSize(tablaCompra.getPreferredSize());
        pane.setViewportView(tablaCompra);
        pnlTablaCompra.add(pane);
        
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox comboBoxBuscarEn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelTituloBuscar;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration                   

    public JTextFieldP getTxtTitulo() {
        return txtTitulo;
    }

    public JTextFieldP getTxtAutor() {
        return txtAutor;
    }

    public JTextFieldP getTxtGenero() {
        return txtGenero;
    }

    public JTextFieldP getTxtEdicion() {
        return txtEdicion;
    }

    public JTextFieldP getTxtCantidad() {
        return txtCantidad;
    }

    public JTextFieldP getTxtPrecio() {
        return txtPrecio;
    }
    
    public JTextField getTxtNit() {
        return txtNit;
    }
    
    public JTextField getTxtCliente() {
        return txtCliente;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }
    

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVender() {
        return btnVender;
    }
    
    public JTable getTablaVenta(){
        return tablaCompra;
    }

    public JTable getTablaDesplegable() {
        return tablaDesplegable;
    }

    public JScrollPane getScrollPanel() {
        return scrollPanel;
    }

    public JComboBox getComboBoxBuscarEn() {
        return comboBoxBuscarEn;
    }


}
