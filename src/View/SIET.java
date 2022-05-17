package View;

import View.Acceso.IniciarSesion;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Brynner
 */
public class SIET {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            final String path = "siet-user-information.encrypted";
            final File file = new File(path);
            
            if (file.exists()) {
                new Principal().setVisible(true);
            } else {
                new IniciarSesion().setVisible(true);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SIET.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}