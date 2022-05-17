package View.GestionEquipos.GestionEquiposActivos;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author brynner
 */
public class Camara extends javax.swing.JDialog {

    private final Webcam webcam;
    private int registrar;
    private int modificar;
    private boolean camaraActivada;
    private ImageIcon imageIcon;

    public Camara(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        registrar = -1;
        modificar = -1;
        imageIcon = null;
        camaraActivada = false;

        webcam = Webcam.getDefault();
        //webcam.setViewSize(new Dimension(320, 280));
        webcam.setViewSize(new Dimension(640, 480));
    }

    public void setRegistrar(int registrar) {
        this.registrar = registrar;
    }

    public void setModificar(int modificar) {
        this.modificar = modificar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLBLCamara = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JBTNAsignarFoto = new javax.swing.JButton();
        JBTNCapturar = new javax.swing.JButton();
        JBTNNuevaFoto = new javax.swing.JButton();
        JBTNCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Cámara");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLBLCamara.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JBTNAsignarFoto.setText("ASIGNAR FOTO");
        JBTNAsignarFoto.setEnabled(false);
        JBTNAsignarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNAsignarFotoActionPerformed(evt);
            }
        });

        JBTNCapturar.setText("CAPTURAR");
        JBTNCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCapturarActionPerformed(evt);
            }
        });

        JBTNNuevaFoto.setText("NUEVA FOTO");
        JBTNNuevaFoto.setEnabled(false);
        JBTNNuevaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNNuevaFotoActionPerformed(evt);
            }
        });

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBTNCapturar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTNNuevaFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTNCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(JBTNAsignarFoto)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNAsignarFoto)
                    .addComponent(JBTNCapturar)
                    .addComponent(JBTNNuevaFoto)
                    .addComponent(JBTNCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBLCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLBLCamara, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (registrar == -1 && modificar == -1) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                webcam.open();
                camaraActivada = true;
                new VideoFeedTaker().start();
            }
        } catch (final HeadlessException exception) {
            System.err.println("Error: " + exception.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCapturarActionPerformed
        camaraActivada = false;
        JBTNCapturar.setEnabled(false);
        JBTNNuevaFoto.setEnabled(true);
        JBTNAsignarFoto.setEnabled(true);
        imageIcon = new ImageIcon(webcam.getImage().getScaledInstance(JLBLCamara.getWidth(), JLBLCamara.getHeight(), Image.SCALE_DEFAULT));
        webcam.close();
        JLBLCamara.setIcon(imageIcon);
    }//GEN-LAST:event_JBTNCapturarActionPerformed

    private void JBTNNuevaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNNuevaFotoActionPerformed
        JBTNNuevaFoto.setEnabled(false);
        JBTNAsignarFoto.setEnabled(false);
        JBTNCapturar.setEnabled(true);
        imageIcon = null;
        JLBLCamara.setIcon(null);
        webcam.open();
        camaraActivada = true;
        new VideoFeedTaker().start();
    }//GEN-LAST:event_JBTNNuevaFotoActionPerformed

    private void JBTNAsignarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNAsignarFotoActionPerformed
        if (registrar == 1) {
            RegistrarEquipo.equipoFoto = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
            RegistrarEquipo.fotoCambiada = true;
        } else if (modificar == 1) {
            ModificarEquipo.equipoFoto = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
            ModificarEquipo.fotoCambiada = true;
        }
        dispose();
    }//GEN-LAST:event_JBTNAsignarFotoActionPerformed

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        camaraActivada = false;
        webcam.close();
        if (registrar == 1) {
            RegistrarEquipo.fotoCambiada = false;
        } else if (modificar == 1) {
            ModificarEquipo.fotoCambiada = false;
        }
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        camaraActivada = false;
        webcam.close();
        if (registrar == 1) {
            RegistrarEquipo.fotoCambiada = false;
        } else if (modificar == 1) {
            ModificarEquipo.fotoCambiada = false;
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Camara dialog = new Camara(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNAsignarFoto;
    private javax.swing.JButton JBTNCapturar;
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JButton JBTNNuevaFoto;
    private javax.swing.JLabel JLBLCamara;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private class VideoFeedTaker extends Thread {

        @Override
        public void run() {
            while (camaraActivada) {
                try {
                    JLBLCamara.setIcon(new ImageIcon(webcam.getImage()));
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
