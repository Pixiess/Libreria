/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class JTextFieldP extends JTextField{

    private Dimension d = new Dimension(200,32);
    private String placeholder = "";
    private Color phColor= Color.blue;
    private boolean band = true;

    /** Constructor de clase */
    public JTextFieldP( )
    {
        super();
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        setMargin( new Insets(3,6,3,6));
        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                band = (getText().length()>0) ? false:true ;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                band = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {}

        });
    }

    public void setPlaceholder(String placeholder)
    {
        this.placeholder=placeholder;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }

    public Color getPhColor() {
        return phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color de placeholder 
        g.setColor( new Color(phColor.getRed(),phColor.getGreen(),phColor.getBlue(),97));

        //dibuja texto
        g.drawString((band)?placeholder:"",
                     getMargin().left+5,
                     (getSize().height)/2 + getFont().getSize()/2 );
      }            

}