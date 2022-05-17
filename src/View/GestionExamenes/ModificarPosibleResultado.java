package View.GestionExamenes;

import Model.POJO.ExamenPosibleResultado;
import Presenter.GestionExamenes.PresenterGestionPosiblesResultados;
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
public class ModificarPosibleResultado extends javax.swing.JDialog implements PresenterGestionPosiblesResultados.CallBackVerificarExistencia, PresenterGestionPosiblesResultados.CallBackModificarPosibleResultado {

    private final PresenterGestionPosiblesResultados presenterGestionPosiblesResultados;
    private ExamenPosibleResultado examenPosibleResultado;

    public ModificarPosibleResultado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        presenterGestionPosiblesResultados = new PresenterGestionPosiblesResultados();
        presenterGestionPosiblesResultados.setCallBackVerificarExistencia(this);
        presenterGestionPosiblesResultados.setCallBackModificarPosibleResultado(this);

        JTXTFPosibleResultadoNombre.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setExamenPosibleResultado(ExamenPosibleResultado examenPosibleResultado) {
        this.examenPosibleResultado = examenPosibleResultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFPosibleResultadoNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        JLBLContadorPosibleResultado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Posible Resultado");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Posible Resultado"));

        jLabel1.setText("RESULTADO:");

        JTXTFPosibleResultadoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFPosibleResultadoNombreFocusGained(evt);
            }
        });
        JTXTFPosibleResultadoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFPosibleResultadoNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFPosibleResultadoNombreKeyTyped(evt);
            }
        });
        JTXTFPosibleResultadoNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        JLBLContadorPosibleResultado.setText("0");

        jLabel2.setText("/20");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFPosibleResultadoNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorPosibleResultado)
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
                        .addComponent(JLBLContadorPosibleResultado))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFPosibleResultadoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            if (examenPosibleResultado == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFPosibleResultadoNombre.setText(examenPosibleResultado.getPosibleResultadoNombre());
                JLBLContadorPosibleResultado.setText(String.valueOf(JTXTFPosibleResultadoNombre.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFPosibleResultadoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPosibleResultadoNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9+,/ ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFPosibleResultadoNombre.getText().length() >= 20) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JTXTFPosibleResultadoNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFPosibleResultadoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFPosibleResultadoNombreKeyReleased
        JLBLContadorPosibleResultado.setText(String.valueOf(JTXTFPosibleResultadoNombre.getText().length()));
    }//GEN-LAST:event_JTXTFPosibleResultadoNombreKeyReleased

    private void JTXTFPosibleResultadoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFPosibleResultadoNombreFocusGained
        JTXTFPosibleResultadoNombre.selectAll();
    }//GEN-LAST:event_JTXTFPosibleResultadoNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarPosibleResultado dialog = new ModificarPosibleResultado(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLContadorPosibleResultado;
    private javax.swing.JTextField JTXTFPosibleResultadoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            if (JTXTFPosibleResultadoNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el resultado.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFPosibleResultadoNombre.requestFocus();
            } else {
                examenPosibleResultado.setPosibleResultadoNombre(JTXTFPosibleResultadoNombre.getText());
                presenterGestionPosiblesResultados.modificarPosibleResultado(examenPosibleResultado);
            }
        }
    };

    @Override
    public void posibleResultadoExiste(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistencia(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void posibleResultadoModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarPosibleResultado(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarPosibleResultado(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}