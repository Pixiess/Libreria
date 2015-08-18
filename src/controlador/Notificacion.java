package controlador;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import vista.Libreria;

public class Notificacion {

    private Libreria libreria;
    private JFrame frame;
    private PopupMenu popMenu;
    private Image imagen;
    private TrayIcon trayIcon;
    private static int libStock;
    private Timer timer;
    private boolean band;

    public Notificacion(Libreria lib, JFrame f, int cant) {
        try {
            libreria = lib;
            frame = f;
            libStock = cant;
            popMenu = new PopupMenu();

            imagen = new ImageIcon(getClass().getResource("/vista/imagenes/icono.png")).getImage();
            trayIcon = new TrayIcon(imagen, "Libreria", popMenu);

            SystemTray.getSystemTray().add(trayIcon);

            MouseListener mouseListener = new MouseListener() {

                public void mouseClicked(MouseEvent evt) {
                }

                public void mouseEntered(MouseEvent evt) {
                }

                public void mouseExited(MouseEvent evt) {
                }

                public void mousePressed(MouseEvent evt) {
                }

                public void mouseReleased(MouseEvent evt) {
                }
            };

            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };

            ActionListener RestaurarListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);
                    frame.setExtendedState(JFrame.NORMAL);
                    frame.repaint();
                    band = true;
                }
            };

            MenuItem SalirItem = new MenuItem("Salir");
            SalirItem.addActionListener(exitListener);
            popMenu.add(SalirItem);

            MenuItem ItemRestaurar = new MenuItem("Restaurar");
            ItemRestaurar.addActionListener(RestaurarListener);
            popMenu.add(ItemRestaurar);
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(mouseListener);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    frame.setVisible(false);
                    band = false;
                    timer = new Timer();
                    int time = (int) Math.random();
                    timer.schedule(new Tiempo(), 0, 60000);
                }
            });

        } catch (AWTException ex) {
            Logger.getLogger(Notificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Mensaje(String texto, TrayIcon.MessageType tipo) {
        trayIcon.displayMessage("Importante: ", texto, tipo);
    }

    public void setCantStock(int cant) {
        libStock = cant;
    }

    public class Tiempo extends TimerTask {

        public void run() {
            if (band) {
                timer.cancel();
            } else {
                verificarStock();
            }
        }

        public void verificarStock() {
            libStock = libreria.cantLibrosStock();
            if (libStock > 0) {
                Mensaje("Hay " + libStock + " libros en stock", TrayIcon.MessageType.INFO);
            }

        }

    }
}
