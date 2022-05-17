package View.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Caracteriztica;
import Presenter.GestionEquipos.PresenterGestionEquipos;
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
public class ModificarCaracteriztica extends javax.swing.JDialog implements PresenterGestionEquipos.CallBackVerificarExistenciaCaracteriztica, PresenterGestionEquipos.CallBackModificarCaracteriztica {

    private final PresenterGestionEquipos presenterGestionEquipos;
    private Caracteriztica caracteriztica;

    public ModificarCaracteriztica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionEquipos = new PresenterGestionEquipos();
        presenterGestionEquipos.setCallBackVerificarExistenciaCaracteriztica(this);
        presenterGestionEquipos.setCallBackModificarCaracteriztica(this);
        JTXTFCaracteriztica.addActionListener(action);
        JTXTFValor.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setCaracteriztica(Caracteriztica caracteriztica) {
        this.caracteriztica = caracteriztica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        JTXTFCaracteriztica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JTXTFValor = new javax.swing.JTextField();
        BTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JLBLContadorCaracteriztica = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLContadorValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Caracteríztica");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Caracteríztica del Equipo"));

        jLabel5.setText("CARACTERIZTICA:");

        JTXTFCaracteriztica.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFCaracterizticaFocusGained(evt);
            }
        });
        JTXTFCaracteriztica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFCaracterizticaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFCaracterizticaKeyTyped(evt);
            }
        });
        JTXTFCaracteriztica.setTransferHandler(null);

        jLabel6.setText("VALOR:");

        JTXTFValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFValorFocusGained(evt);
            }
        });
        JTXTFValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFValorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFValorKeyTyped(evt);
            }
        });
        JTXTFValor.setTransferHandler(null);

        BTNCancelar.setText("CANCELAR");
        BTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel1.setText("/20");

        JLBLContadorCaracteriztica.setText("0");

        jLabel2.setText("/50");

        JLBLContadorValor.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFCaracteriztica, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(JTXTFValor, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorCaracteriztica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(JLBLContadorCaracteriztica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFCaracteriztica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNCancelar)
                    .addComponent(JBTNGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (caracteriztica == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFCaracteriztica.setText(caracteriztica.getEquipoCaracteriztica());
                JTXTFValor.setText(caracteriztica.getEquipoCaracterizticaValor());
                
                JLBLContadorCaracteriztica.setText(String.valueOf(JTXTFCaracteriztica.getText().length()));
                JLBLContadorValor.setText(String.valueOf(JTXTFValor.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFCaracterizticaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCaracterizticaKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFCaracteriztica.getText().length() >= 20) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFCaracterizticaKeyTyped

    private void JTXTFValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFValorKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFValor.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFValorKeyTyped

    private void BTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BTNCancelarActionPerformed

    private void JTXTFCaracterizticaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFCaracterizticaKeyReleased
        JLBLContadorCaracteriztica.setText(String.valueOf(JTXTFCaracteriztica.getText().length()));
    }//GEN-LAST:event_JTXTFCaracterizticaKeyReleased

    private void JTXTFValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFValorKeyReleased
        JLBLContadorValor.setText(String.valueOf(JTXTFValor.getText().length()));
    }//GEN-LAST:event_JTXTFValorKeyReleased

    private void JTXTFCaracterizticaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFCaracterizticaFocusGained
        JTXTFCaracteriztica.selectAll();
    }//GEN-LAST:event_JTXTFCaracterizticaFocusGained

    private void JTXTFValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFValorFocusGained
        JTXTFValor.selectAll();
    }//GEN-LAST:event_JTXTFValorFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarCaracteriztica dialog = new ModificarCaracteriztica(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JLabel JLBLContadorCaracteriztica;
    private javax.swing.JLabel JLBLContadorValor;
    private javax.swing.JTextField JTXTFCaracteriztica;
    private javax.swing.JTextField JTXTFValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String equipo_caracteriztica = JTXTFCaracteriztica.getText();
            final String equipo_caracteriztica_valor = JTXTFValor.getText();

            if (equipo_caracteriztica.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un atributo del equipo.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else if (equipo_caracteriztica_valor.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor para el atributo del equipo.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else {
                caracteriztica.setEquipoCaracteriztica(equipo_caracteriztica);
                caracteriztica.setEquipoCaracterizticaValor(equipo_caracteriztica_valor);
                presenterGestionEquipos.modificarCaracteriztica(caracteriztica);
            }
        }
    };

    @Override
    public void caracterizticaExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaCaracteriztica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void caracterizticaModificada(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarCaracteriztica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarCaracteriztica(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}