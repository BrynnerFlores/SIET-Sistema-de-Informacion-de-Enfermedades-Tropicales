package View.GestionSubespecialidades;

import Model.POJO.Enfermedad;
import Presenter.GestionSubespecialidades.PresenterGestionEnfermedades;
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
public class ModificarEnfermedad extends javax.swing.JDialog implements PresenterGestionEnfermedades.CallBackVerificarExistenciaEnfermedad, PresenterGestionEnfermedades.CallBackModificarEnfermedad {
    
    private final PresenterGestionEnfermedades presenterGestionEnfermedades;
    private Enfermedad enfermedad;
    
    public ModificarEnfermedad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        presenterGestionEnfermedades = new PresenterGestionEnfermedades();
        presenterGestionEnfermedades.setCallBackVerificarExistenciaEnfermedad(this);
        presenterGestionEnfermedades.setCallBackModificarEnfermedad(this);
        
        JTXTFEnfermedadNombre.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFEnfermedadNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JLBLContadorEnfermedadNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Enfermedad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Enfermedad"));

        jLabel1.setText("ENFERMEDAD:");

        JTXTFEnfermedadNombre.setTransferHandler(null);
        JTXTFEnfermedadNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFEnfermedadNombreFocusGained(evt);
            }
        });
        JTXTFEnfermedadNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFEnfermedadNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFEnfermedadNombreKeyTyped(evt);
            }
        });
        JTXTFEnfermedadNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel2.setText("/50");

        JLBLContadorEnfermedadNombre.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFEnfermedadNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorEnfermedadNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorEnfermedadNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFEnfermedadNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        try {
            if (enfermedad == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFEnfermedadNombre.setText(enfermedad.getEnfermedadNombre());
                
                JLBLContadorEnfermedadNombre.setText(String.valueOf(JTXTFEnfermedadNombre.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFEnfermedadNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEnfermedadNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFEnfermedadNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFEnfermedadNombreKeyTyped

    private void JTXTFEnfermedadNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFEnfermedadNombreKeyReleased
        JLBLContadorEnfermedadNombre.setText(String.valueOf(JTXTFEnfermedadNombre.getText().length()));
    }//GEN-LAST:event_JTXTFEnfermedadNombreKeyReleased

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFEnfermedadNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFEnfermedadNombreFocusGained
        JTXTFEnfermedadNombre.selectAll();
    }//GEN-LAST:event_JTXTFEnfermedadNombreFocusGained
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarEnfermedad dialog = new ModificarEnfermedad(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLContadorEnfermedadNombre;
    private javax.swing.JTextField JTXTFEnfermedadNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (JTXTFEnfermedadNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre de la enfermedad.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFEnfermedadNombre.requestFocus();
            } else {
                final String enfermedadNombre = JTXTFEnfermedadNombre.getText();
                enfermedad.setEnfermedadNombre(enfermedadNombre);
                presenterGestionEnfermedades.modificarEnfermedad(enfermedad);
            }
        }
    };
    
    @Override
    public void existeEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void enfermedadModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarEnfermedad(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}