package View.GestionExamenes;

import Model.POJO.Tecnica;
import Presenter.GestionExamenes.PresenterGestionTecnicas;
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
public class ModificarTecnica extends javax.swing.JDialog implements PresenterGestionTecnicas.CallBackVerificarExistenciaTecnica, PresenterGestionTecnicas.CallBackModificarTecnica {
    
    private final PresenterGestionTecnicas presenterGestionTecnicas;
    private Tecnica tecnica;
    
    public ModificarTecnica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        
        presenterGestionTecnicas = new PresenterGestionTecnicas();
        presenterGestionTecnicas.setCallBackVerificarExistenciaTecnica(this);
        presenterGestionTecnicas.setCallBackModificarTecnica(this);
        
        JTXTFTecnicaNombre.addActionListener(action);
        JTXTFTecnicaMetodo.addActionListener(action);
        JBTNGuardar.addActionListener(action);
    }

    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFTecnicaNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTXTFTecnicaMetodo = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        JLBLContadorNombreTecnica = new javax.swing.JLabel();
        JLBLContadorNombreMetodo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Técnica");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Técnica"));

        jLabel1.setText("NOMBRE DE LA TECNICA:");

        JTXTFTecnicaNombre.setTransferHandler(null);
        JTXTFTecnicaNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFTecnicaNombreFocusGained(evt);
            }
        });
        JTXTFTecnicaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFTecnicaNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFTecnicaNombreKeyTyped(evt);
            }
        });
        JTXTFTecnicaNombre.setTransferHandler(null);

        jLabel2.setText("NOMBRE DEL METODO:");

        JTXTFTecnicaMetodo.setTransferHandler(null);
        JTXTFTecnicaMetodo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFTecnicaMetodoFocusGained(evt);
            }
        });
        JTXTFTecnicaMetodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFTecnicaMetodoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFTecnicaMetodoKeyTyped(evt);
            }
        });
        JTXTFTecnicaMetodo.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jLabel3.setText("/50");

        JLBLContadorNombreTecnica.setText("0");

        JLBLContadorNombreMetodo.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFTecnicaNombre)
                    .addComponent(JTXTFTecnicaMetodo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreMetodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreTecnica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(JLBLContadorNombreTecnica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFTecnicaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorNombreMetodo))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFTecnicaMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (tecnica == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JTXTFTecnicaNombre.setText(tecnica.getTecnicaNombre());
                JTXTFTecnicaMetodo.setText(tecnica.getTecnicaMetodo());
                
                JLBLContadorNombreTecnica.setText(String.valueOf(JTXTFTecnicaNombre.getText().length()));
                JLBLContadorNombreMetodo.setText(String.valueOf(JTXTFTecnicaMetodo.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFTecnicaNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTecnicaNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFTecnicaNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFTecnicaNombreKeyTyped

    private void JTXTFTecnicaNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTecnicaNombreKeyReleased
        JLBLContadorNombreTecnica.setText(String.valueOf(JTXTFTecnicaNombre.getText().length()));
    }//GEN-LAST:event_JTXTFTecnicaNombreKeyReleased

    private void JTXTFTecnicaMetodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTecnicaMetodoKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFTecnicaMetodo.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFTecnicaMetodoKeyTyped

    private void JTXTFTecnicaMetodoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFTecnicaMetodoKeyReleased
        JLBLContadorNombreMetodo.setText(String.valueOf(JTXTFTecnicaMetodo.getText().length()));
    }//GEN-LAST:event_JTXTFTecnicaMetodoKeyReleased

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFTecnicaNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFTecnicaNombreFocusGained
        JTXTFTecnicaNombre.selectAll();
    }//GEN-LAST:event_JTXTFTecnicaNombreFocusGained

    private void JTXTFTecnicaMetodoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFTecnicaMetodoFocusGained
        JTXTFTecnicaMetodo.selectAll();
    }//GEN-LAST:event_JTXTFTecnicaMetodoFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarTecnica dialog = new ModificarTecnica(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLBLContadorNombreMetodo;
    private javax.swing.JLabel JLBLContadorNombreTecnica;
    private javax.swing.JTextField JTXTFTecnicaMetodo;
    private javax.swing.JTextField JTXTFTecnicaNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent actionEvent) {
            if (JTXTFTecnicaNombre.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre de la técnica.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFTecnicaNombre.requestFocus();
            } else if (JTXTFTecnicaMetodo.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ingresa el nombre del método.", "SIET", JOptionPane.ERROR_MESSAGE);
                JTXTFTecnicaMetodo.requestFocus();
            } else {
                final String tecnicaNombre = JTXTFTecnicaNombre.getText();
                final String tecnicaMetodo = JTXTFTecnicaMetodo.getText();
                tecnica.setTecnicaNombre(tecnicaNombre);
                tecnica.setTecnicaMetodo(tecnicaMetodo);
                presenterGestionTecnicas.modificarTecnica(tecnica);
            }
        }
    };
    @Override
    public void examenExiste(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaTecnica(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void examenModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarTecnica(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarTecnica(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}