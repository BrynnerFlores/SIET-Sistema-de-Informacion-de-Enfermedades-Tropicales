package View.GestionExamenes;

import Model.POJO.Examen;
import Model.POJO.GrupoVariables;
import Presenter.GestionExamenes.PresenterGestionGrupoVariables;
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
public class CrearGrupoVariables extends javax.swing.JDialog implements PresenterGestionGrupoVariables.CallBackVerificarExistenciaGrupoVariables, PresenterGestionGrupoVariables.CallBackCrearGrupoVariables {
    
    private final PresenterGestionGrupoVariables presenterGestionGrupoVariables;
    private Examen examen;
    
    public CrearGrupoVariables(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionGrupoVariables = new PresenterGestionGrupoVariables();
        presenterGestionGrupoVariables.setCallBackVerificarExistenciaGrupoVariables(this);
        presenterGestionGrupoVariables.setCallBackCrearGrupoVariables(this);
        JTXTFGrupoVariablesNombre.addActionListener(action);
        JBTNCrearGrupo.addActionListener(action);
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTXTFGrupoVariablesNombre = new javax.swing.JTextField();
        JBTNCancelar = new javax.swing.JButton();
        JBTNCrearGrupo = new javax.swing.JButton();
        JLBLExamenNombre = new javax.swing.JLabel();
        JLBLContadorNombreGrupoVariable = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Crear Grupo de Variables");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Grupo de Variables"));

        jLabel1.setText("NOMBRE DEL EXAMEN:");

        jLabel2.setText("NOMBRE DEL GRUPO:");

        JTXTFGrupoVariablesNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFGrupoVariablesNombreFocusGained(evt);
            }
        });
        JTXTFGrupoVariablesNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFGrupoVariablesNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFGrupoVariablesNombreKeyTyped(evt);
            }
        });
        JTXTFGrupoVariablesNombre.setTransferHandler(null);

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNCrearGrupo.setText("CREAR GRUPO");

        JLBLExamenNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLContadorNombreGrupoVariable.setText("0");

        jLabel4.setText("/50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFGrupoVariablesNombre)
                    .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(JBTNCrearGrupo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreGrupoVariable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLBLExamenNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(JLBLContadorNombreGrupoVariable))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFGrupoVariablesNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNCrearGrupo))
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
            if (examen == null) {
                JOptionPane.showMessageDialog(this, "Par??matro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLExamenNombre.setText(examen.getExamenNombre());
                JTXTFGrupoVariablesNombre.setText(examen.getExamenNombre());
                JLBLContadorNombreGrupoVariable.setText(String.valueOf(JTXTFGrupoVariablesNombre.getText().length()));
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFGrupoVariablesNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFGrupoVariablesNombreKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9-.() ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFGrupoVariablesNombre.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFGrupoVariablesNombreKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFGrupoVariablesNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFGrupoVariablesNombreKeyReleased
        JLBLContadorNombreGrupoVariable.setText(String.valueOf(JTXTFGrupoVariablesNombre.getText().length()));
    }//GEN-LAST:event_JTXTFGrupoVariablesNombreKeyReleased

    private void JTXTFGrupoVariablesNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFGrupoVariablesNombreFocusGained
        JTXTFGrupoVariablesNombre.selectAll();
    }//GEN-LAST:event_JTXTFGrupoVariablesNombreFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CrearGrupoVariables dialog = new CrearGrupoVariables(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCrearGrupo;
    private javax.swing.JLabel JLBLContadorNombreGrupoVariable;
    private javax.swing.JLabel JLBLExamenNombre;
    private javax.swing.JTextField JTXTFGrupoVariablesNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent ae) {
            final String grupo_variables_nombre = JTXTFGrupoVariablesNombre.getText();
            if (grupo_variables_nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un nombre para el nuevo grupo de variables.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else {
                final GrupoVariables grupoVariables = new GrupoVariables(examen, grupo_variables_nombre, 1);
                presenterGestionGrupoVariables.crearGrupoVariables(grupoVariables);
            }
        }
    };
    
    @Override
    public void grupoVariablesExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void grupoVariablesCreado(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearGrupoVariables(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}