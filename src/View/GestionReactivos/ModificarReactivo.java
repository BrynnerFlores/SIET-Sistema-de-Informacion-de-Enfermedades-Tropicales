package View.GestionReactivos;

import Model.POJO.Reactivo;
import Presenter.GestionReactivos.PresenterGestionReactivos;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brynner
 */
public class ModificarReactivo extends javax.swing.JDialog implements PresenterGestionReactivos.CallBackVerificarExistenciaReactivo, PresenterGestionReactivos.CallBackModificarReactivo {

    private final PresenterGestionReactivos presenterGestionReactivos;
    private Reactivo reactivo;

    public ModificarReactivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        presenterGestionReactivos = new PresenterGestionReactivos();
        presenterGestionReactivos.setCallBackVerificarExistenciaReactivo(this);
        presenterGestionReactivos.setCallBackModificarReactivo(this);

        JTXTFNombre.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setReactivo(Reactivo reactivo) {
        this.reactivo = reactivo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        JLBLContadorReactivoNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Reactivo");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Reactivo"));

        jLabel1.setText("NOMBRE:");

        JTXTFNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombreFocusGained(evt);
            }
        });
        JTXTFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNombreKeyTyped(evt);
            }
        });
        JTXTFNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        JLBLContadorReactivoNombre.setText("0");

        jLabel2.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorReactivoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(JLBLContadorReactivoNombre))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTXTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9- ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (reactivo == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFNombre.setText(reactivo.getNombre());
                JLBLContadorReactivoNombre.setText(String.valueOf(JTXTFNombre.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreKeyReleased
        JLBLContadorReactivoNombre.setText(String.valueOf(JTXTFNombre.getText().length()));
    }//GEN-LAST:event_JTXTFNombreKeyReleased

    private void JTXTFNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombreFocusGained
        JTXTFNombre.selectAll();
    }//GEN-LAST:event_JTXTFNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarReactivo dialog = new ModificarReactivo(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLContadorReactivoNombre;
    private javax.swing.JTextField JTXTFNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String nombre = JTXTFNombre.getText();

            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del nuevo reactivo.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                reactivo.setNombre(nombre);
                presenterGestionReactivos.modificarReactivo(reactivo);
            }
        }
    };

    @Override
    public void reactivoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarExistenciaReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void reactivoModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarReactivo(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}