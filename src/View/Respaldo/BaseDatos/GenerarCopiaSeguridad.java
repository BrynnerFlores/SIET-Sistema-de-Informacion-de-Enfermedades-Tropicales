package View.Respaldo.BaseDatos;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class GenerarCopiaSeguridad extends javax.swing.JDialog {

    private String nameBackup;

    public GenerarCopiaSeguridad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLBLRutaDestino = new javax.swing.JLabel();
        JBTNCambiarRutaDestino = new javax.swing.JButton();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Generar Copia de Seguridad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecciona el destino"));

        jLabel1.setText("La copia de seguridad se guardará en:");

        JLBLRutaDestino.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JBTNCambiarRutaDestino.setText("...");
        JBTNCambiarRutaDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCambiarRutaDestinoActionPerformed(evt);
            }
        });

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGenerar.setText("GENERAR");
        JBTNGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLBLRutaDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBTNCambiarRutaDestino))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 284, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGenerar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBTNCambiarRutaDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLRutaDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNGenerar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBTNCambiarRutaDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCambiarRutaDestinoActionPerformed
        try {
            final JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Guardar en:");
            jFileChooser.showOpenDialog(this);
            final String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

            final File file = jFileChooser.getSelectedFile() == null ? null : jFileChooser.getSelectedFile();
            final String path = file == null ? "" : file.getAbsolutePath();
            if (file != null) {
                nameBackup = path + "_" + date + ".sql";
                JLBLRutaDestino.setText(nameBackup);
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNCambiarRutaDestinoActionPerformed

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JBTNGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNGenerarActionPerformed
        try {
            if (nameBackup == null || nameBackup.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la ruta e ingresa el nombre de la copia de seguridad.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                final ProcessBuilder processBuilder = new ProcessBuilder("C:/Program Files/PostgreSQL/10/bin/" + "pg_dump.exe", "-f", nameBackup, "-h", "localhost", "-U", "ceretrop", "ceretrop");
                processBuilder.environment().put("PGPASSWORD", "ceretrop");
                processBuilder.redirectErrorStream(true);

                final Process process = processBuilder.start();
                final InputStream inputStream = process.getInputStream();
                final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String log;
                while ((log = bufferedReader.readLine()) != null) {
                    System.out.println(log);
                }

                if (process.waitFor() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Copia de seguridad generada.", "SIET", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (final IOException iOException) {
            System.err.println("Error: " + iOException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        } catch (final InterruptedException ex) {
            Logger.getLogger(GenerarCopiaSeguridad.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNGenerarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            GenerarCopiaSeguridad dialog = new GenerarCopiaSeguridad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCambiarRutaDestino;
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGenerar;
    private javax.swing.JLabel JLBLRutaDestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
