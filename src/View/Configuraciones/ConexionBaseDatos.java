package View.Configuraciones;

import Model.DAO.DataBaseConfiguration;
import Model.POJO.Conexion;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.w3c.dom.DOMException;

/**
 *
 * @author Brynner
 */
public class ConexionBaseDatos extends javax.swing.JDialog {
    
    private final Conexion conexion;
    
    public ConexionBaseDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        
        conexion = DataBaseConfiguration.CONEXION;
        
        JTXTFHost.addActionListener(action);
        JTXTFPuerto.addActionListener(action);
        JTXTFUsuario.addActionListener(action);
        JTXTFPassword.addActionListener(action);
        JTXTFNombreBaseDatos.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFHost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTXTFPuerto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTXTFUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        JTXTFPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JTXTFNombreBaseDatos = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Conexión a Base de Datos");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexión a Base de Datos"));

        jLabel1.setText("HOST:");

        JTXTFHost.setTransferHandler(null);
        JTXTFHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFHostFocusGained(evt);
            }
        });

        jLabel2.setText("PUERTO:");

        JTXTFPuerto.setTransferHandler(null);
        JTXTFPuerto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFPuertoFocusGained(evt);
            }
        });

        jLabel3.setText("USUARIO:");

        JTXTFUsuario.setTransferHandler(null);
        JTXTFUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFUsuarioFocusGained(evt);
            }
        });

        jLabel4.setText("CONTRASEÑA:");

        JTXTFPassword.setTransferHandler(null);
        JTXTFPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFPasswordFocusGained(evt);
            }
        });

        jLabel5.setText("NOMBRE DE BASE DE DATOS:");

        JTXTFNombreBaseDatos.setTransferHandler(null);
        JTXTFNombreBaseDatos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombreBaseDatosFocusGained(evt);
            }
        });

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFHost)
                    .addComponent(JTXTFPuerto)
                    .addComponent(JTXTFUsuario)
                    .addComponent(JTXTFPassword)
                    .addComponent(JTXTFNombreBaseDatos)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombreBaseDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        JTXTFHost.setText(conexion.getHost());
        JTXTFPuerto.setText(String.valueOf(conexion.getPuerto()));
        JTXTFUsuario.setText(conexion.getUsuario());
        JTXTFPassword.setText(conexion.getPassword());
        JTXTFNombreBaseDatos.setText(conexion.getNombreBaseDatos());
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFHostFocusGained
        JTXTFHost.selectAll();
    }//GEN-LAST:event_JTXTFHostFocusGained

    private void JTXTFPuertoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFPuertoFocusGained
        JTXTFPuerto.selectAll();
    }//GEN-LAST:event_JTXTFPuertoFocusGained

    private void JTXTFUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFUsuarioFocusGained
        JTXTFUsuario.selectAll();
    }//GEN-LAST:event_JTXTFUsuarioFocusGained

    private void JTXTFPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFPasswordFocusGained
        JTXTFPassword.selectAll();
    }//GEN-LAST:event_JTXTFPasswordFocusGained

    private void JTXTFNombreBaseDatosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombreBaseDatosFocusGained
        JTXTFNombreBaseDatos.selectAll();
    }//GEN-LAST:event_JTXTFNombreBaseDatosFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ConexionBaseDatos dialog = new ConexionBaseDatos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JTextField JTXTFHost;
    private javax.swing.JTextField JTXTFNombreBaseDatos;
    private javax.swing.JTextField JTXTFPassword;
    private javax.swing.JTextField JTXTFPuerto;
    private javax.swing.JTextField JTXTFUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private Boolean guardarConexion(final Conexion conexion) {
        try {
            final File file = new File("conection-data-base.xml");

            if (file.exists()) {
                file.delete();

                if (!DataBaseConfiguration.crearArchivo(conexion)) {
                    JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (!DataBaseConfiguration.crearArchivo(conexion)) {
                    JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                }
            }
            return true;
        } catch (final DOMException e) {
            System.err.println("Error al guardar los datos de la conexión a la base de datos: " + e.getMessage());
            return false;
        }
    }
    
    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            if (JTXTFHost.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa la dirección del servidor.");
            } else if (JTXTFUsuario.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el usuario de la base de datos.");
            } else if (JTXTFPassword.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa la contraseña del usuario de la base de datos.");
            } else if (JTXTFNombreBaseDatos.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre de la base de datos.");
            } else {
                final String host = JTXTFHost.getText();
                final int puerto = JTXTFPuerto.getText().trim().isEmpty() ? 5432 : Integer.parseInt(JTXTFPuerto.getText());
                final String usuario = JTXTFUsuario.getText();
                final String password = JTXTFPassword.getText();
                final String nombreBaseDatos = JTXTFNombreBaseDatos.getText();

                final Conexion conexion = new Conexion(host, puerto, usuario, password, nombreBaseDatos);

                if (guardarConexion(conexion)) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.");
                }
            }
        }
    };
}