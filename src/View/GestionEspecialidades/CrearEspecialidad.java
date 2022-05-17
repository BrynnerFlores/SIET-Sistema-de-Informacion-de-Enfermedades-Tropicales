package View.GestionEspecialidades;

import Model.POJO.Especialidad;
import Presenter.GestionEspecialidades.PresenterGestionEspecialidades;
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
public class CrearEspecialidad extends javax.swing.JDialog implements PresenterGestionEspecialidades.CallBackVerificarExistenciaEspecialidad, PresenterGestionEspecialidades.CallBackCrearEspecialidad {

    private final PresenterGestionEspecialidades presenterGestionEspecialidades;
    
    public CrearEspecialidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        presenterGestionEspecialidades = new PresenterGestionEspecialidades();
        presenterGestionEspecialidades.setCallBackCrearEspecialidad(this);
        presenterGestionEspecialidades.setCallBackVerificarExistenciaEspecialidad(this);
        JTXTFNombreEspecialidad.addActionListener(action);
        JBTNCrear.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTXTFNombreEspecialidad = new javax.swing.JTextField();
        JBTNCrear = new javax.swing.JButton();
        JBTNCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JLBLContadorNombreEspecialidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Crear Especialidad");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Especialidad"));

        jLabel1.setText("Nombre de la Especialidad:");

        JTXTFNombreEspecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFNombreEspecialidadFocusGained(evt);
            }
        });
        JTXTFNombreEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFNombreEspecialidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFNombreEspecialidadKeyTyped(evt);
            }
        });
        JTXTFNombreEspecialidad.setTransferHandler(null);

        JBTNCrear.setText("CREAR");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("/50");

        JLBLContadorNombreEspecialidad.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFNombreEspecialidad)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorNombreEspecialidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(JBTNCrear)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(JLBLContadorNombreEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFNombreEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNCrear))
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

    private void JTXTFNombreEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreEspecialidadKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFNombreEspecialidad.getText().length() >= 50) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTFNombreEspecialidadKeyTyped

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JTXTFNombreEspecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFNombreEspecialidadKeyReleased
        JLBLContadorNombreEspecialidad.setText(String.valueOf(JTXTFNombreEspecialidad.getText().length()));
    }//GEN-LAST:event_JTXTFNombreEspecialidadKeyReleased

    private void JTXTFNombreEspecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFNombreEspecialidadFocusGained
        JTXTFNombreEspecialidad.selectAll();
    }//GEN-LAST:event_JTXTFNombreEspecialidadFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CrearEspecialidad dialog = new CrearEspecialidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCrear;
    private javax.swing.JLabel JLBLContadorNombreEspecialidad;
    private javax.swing.JTextField JTXTFNombreEspecialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            final String especialidad_nombre = JTXTFNombreEspecialidad.getText();
        
            if (especialidad_nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresa un nombre para la nueva especialidad.", "SIET", JOptionPane.INFORMATION_MESSAGE);
            } else {
                final Especialidad especialidad = new Especialidad(especialidad_nombre.toUpperCase(), 1);
                presenterGestionEspecialidades.crearEspecialidad(especialidad);
            }
        }
    };
    
    @Override
    public void especialidadCreada(final String msg) {
        dispose();
    }

    @Override
    public void errorCrearEspecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoCrearEspecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void especialidadExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaEspecialidad(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}