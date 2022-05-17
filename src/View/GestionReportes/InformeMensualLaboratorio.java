package View.GestionReportes;

import Model.POJO.PersonalTecnico;
import Model.POJO.Reportes.InformeMensualLaboratorio.CuartaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.DecimaPrimeraTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.DecimaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.NovenaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.OctavaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.PrimeraTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.QuintaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.SegundaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.SeptimaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.SextaTabla;
import Model.POJO.Reportes.InformeMensualLaboratorio.TerceraTabla;
import Model.POJOPersonalizado.ResultadoGeneralReportePersonalizado;
import Presenter.GestionReportes.PresenterGestionReportes;
import View.Utilitarios.Utilidades;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Brynner
 */
public class InformeMensualLaboratorio extends javax.swing.JDialog implements PresenterGestionReportes.CallBackInformeMensualLaboratorio {

    private final PresenterGestionReportes presenterGestionReportes;
    private final PersonalTecnico personalTecnico;

    public InformeMensualLaboratorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        presenterGestionReportes = new PresenterGestionReportes();
        presenterGestionReportes.setCallBackInformeMensualLaboratorio(this);

        personalTecnico = Utilidades.obtenerCuentaLocal().getPersonalTecnico();

        JTXTFYear.addActionListener(action);
        JBTNGenerar.addActionListener(action);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGenerar = new javax.swing.JButton();
        JCMBXMes = new javax.swing.JComboBox<>();
        JTXTFYear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JLBLContadorYear = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Informe Mensual de Laboratorio");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informe Mensual de Laboratorio"));

        jLabel1.setText("MES:");

        jLabel2.setText("AÑO:");

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGenerar.setText("GENERAR");

        JCMBXMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
        JCMBXMes.setSelectedIndex(-1);

        JTXTFYear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTFYearFocusGained(evt);
            }
        });
        JTXTFYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTFYearKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTFYearKeyTyped(evt);
            }
        });
        JTXTFYear.setTransferHandler(null);

        jLabel3.setText("/4");

        JLBLContadorYear.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTXTFYear)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                        .addComponent(JBTNGenerar))
                    .addComponent(JCMBXMes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JCMBXMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(JLBLContadorYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTXTFYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

    private void JTXTFYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFYearKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([0-9]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTFYear.getText().length() >= 4) {
            evt.consume();
        } else {
            evt.setKeyChar(evt.getKeyChar());
        }
    }//GEN-LAST:event_JTXTFYearKeyTyped

    private void JTXTFYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTFYearKeyReleased
        JLBLContadorYear.setText(String.valueOf(JTXTFYear.getText().length()));
    }//GEN-LAST:event_JTXTFYearKeyReleased

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (personalTecnico == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                final LocalDate localDate = LocalDate.now();
                final int month = localDate.getMonthValue();
                final int year = localDate.getYear();
                JCMBXMes.setSelectedIndex(month - 1);
                JTXTFYear.setText(String.valueOf(year));
                JLBLContadorYear.setText(String.valueOf(JTXTFYear.getText().length()));
                JTXTFYear.requestFocus();
            }
        } catch (HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JTXTFYearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTFYearFocusGained
        JTXTFYear.selectAll();
    }//GEN-LAST:event_JTXTFYearFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            InformeMensualLaboratorio dialog = new InformeMensualLaboratorio(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNGenerar;
    private javax.swing.JComboBox<String> JCMBXMes;
    private javax.swing.JLabel JLBLContadorYear;
    private javax.swing.JTextField JTXTFYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            try {
                if (JCMBXMes.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(rootPane, "Selecciona el mes.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JCMBXMes.requestFocus();
                } else if (JTXTFYear.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Ingresa el año.", "SIET", JOptionPane.ERROR_MESSAGE);
                    JTXTFYear.requestFocus();
                } else {
                    final int month = JCMBXMes.getSelectedIndex() + 1;
                    final int year = Integer.valueOf(JTXTFYear.getText());
                    presenterGestionReportes.obtenerInformeMensualLaboratorio(month, year);
                }
            } catch (final HeadlessException | NumberFormatException exception) {
                System.out.println("Error: " + exception.getMessage());
                JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            }
        }
    };

    private List<PrimeraTabla> construirPrimeraTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<PrimeraTabla> resultadosPrimeraTabla = new ArrayList<>();

        final PrimeraTabla primeraTablaAnalisisClinico = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaBacteriologia = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaParasitologia = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaMicologia = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaInmunologia = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaVirologia = new PrimeraTabla(0, 0, 0, 0);
        final PrimeraTabla primeraTablaCitologia = new PrimeraTabla(0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralPersonalizado) -> {
            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getEspecialidad().getEspecialidadNombre()) {
                case "ANALISIS CLINICO":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                                final int size = resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().size();
                                int countGrupoVariablesHemogramaCompleto = 0;
                                int countOthersGrupoVariablesHemograma = 0;
                                for (int i = 0; i < size; i++) {
                                    switch (resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getGrupoVariables().getGrupoVariableNombre()) {
                                        case "SERIE ROJA":
                                        case "SERIE BLANCA":
                                        case "SERIE PLAQUETARIA": {
                                            countGrupoVariablesHemogramaCompleto++;
                                        }
                                        break;

                                        case "GRUPO SANGUINEO Y FACTOR RH":
                                            countOthersGrupoVariablesHemograma++;
                                            break;

                                        case "HEMOPARASITOS":
                                            primeraTablaParasitologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaParasitologia.getTotalMuestrasTomadasEnElLaboratorio() + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size());
                                            break;

                                        case "COAGULOGRAMA":
                                            countOthersGrupoVariablesHemograma = countOthersGrupoVariablesHemograma + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size();
                                            break;
                                    }
                                }

                                if (countGrupoVariablesHemogramaCompleto == 3 && countOthersGrupoVariablesHemograma == 0) {
                                    primeraTablaAnalisisClinico.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                                } else if (countGrupoVariablesHemogramaCompleto == 3 && countOthersGrupoVariablesHemograma > 0) {
                                    primeraTablaAnalisisClinico.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasTomadasEnElLaboratorio() + 1 + countOthersGrupoVariablesHemograma);
                                } else if (countGrupoVariablesHemogramaCompleto < 3 && countOthersGrupoVariablesHemograma > 0) {
                                    primeraTablaAnalisisClinico.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasTomadasEnElLaboratorio() + countOthersGrupoVariablesHemograma);
                                }
                            } else {
                                primeraTablaAnalisisClinico.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            }
                            break;

                        case "REFERIDO AL LABORATORIO":
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                                final int size = resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().size();
                                int countGrupoVariablesHemogramaCompleto = 0;
                                int countOthersGrupoVariablesHemograma = 0;
                                for (int i = 0; i < size; i++) {
                                    switch (resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getGrupoVariables().getGrupoVariableNombre()) {
                                        case "SERIE ROJA":
                                        case "SERIE BLANCA":
                                        case "SERIE PLAQUETARIA": {
                                            countGrupoVariablesHemogramaCompleto++;
                                        }
                                        break;

                                        case "GRUPO SANGUINEO Y FACTOR RH":
                                            countOthersGrupoVariablesHemograma++;
                                            break;

                                        case "HEMOPARASITOS":
                                            primeraTablaParasitologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaParasitologia.getTotalMuestrasReferidasAlLaboratorio() + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size());
                                            break;

                                        case "COAGULOGRAMA":
                                            countOthersGrupoVariablesHemograma = countOthersGrupoVariablesHemograma + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size();
                                            break;
                                    }
                                }

                                if (countGrupoVariablesHemogramaCompleto == 3) {
                                    primeraTablaAnalisisClinico.setTotalMuestrasReferidasAlLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasReferidasAlLaboratorio() + 1);
                                } else if (countGrupoVariablesHemogramaCompleto == 3 && countOthersGrupoVariablesHemograma > 0) {
                                    primeraTablaAnalisisClinico.setTotalMuestrasReferidasAlLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasReferidasAlLaboratorio() + 1 + countOthersGrupoVariablesHemograma);
                                } else {
                                    primeraTablaAnalisisClinico.setTotalMuestrasReferidasAlLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasReferidasAlLaboratorio() + countOthersGrupoVariablesHemograma);
                                }
                            } else {
                                primeraTablaAnalisisClinico.setTotalMuestrasReferidasAlLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            }
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaAnalisisClinico.setTotalMuestrasReferidasPorLaboratorio(primeraTablaAnalisisClinico.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "BACTERIOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            primeraTablaBacteriologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaBacteriologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            break;

                        case "REFERIDO AL LABORATORIO":
                            primeraTablaBacteriologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaBacteriologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaBacteriologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaBacteriologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "PARASITOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                                primeraTablaParasitologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaParasitologia.getTotalMuestrasTomadasEnElLaboratorio() + 2);
                            } else {
                                primeraTablaParasitologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaParasitologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            }
                            break;

                        case "REFERIDO AL LABORATORIO":
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                                primeraTablaParasitologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaParasitologia.getTotalMuestrasReferidasAlLaboratorio() + 2);
                            } else {
                                primeraTablaParasitologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaParasitologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            }
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaParasitologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaParasitologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "MICOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            primeraTablaMicologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaMicologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            break;

                        case "REFERIDO AL LABORATORIO":
                            primeraTablaMicologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaMicologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaMicologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaMicologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "INMUNOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            primeraTablaInmunologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaInmunologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            break;

                        case "REFERIDO AL LABORATORIO":
                            primeraTablaInmunologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaInmunologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaInmunologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaInmunologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "VIROLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            primeraTablaVirologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaVirologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            break;

                        case "REFERIDO AL LABORATORIO":
                            primeraTablaVirologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaVirologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaVirologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaVirologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;

                case "CITOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                            primeraTablaCitologia.setTotalMuestrasTomadasEnElLaboratorio(primeraTablaCitologia.getTotalMuestrasTomadasEnElLaboratorio() + 1);
                            break;

                        case "REFERIDO AL LABORATORIO":
                            primeraTablaCitologia.setTotalMuestrasReferidasAlLaboratorio(primeraTablaCitologia.getTotalMuestrasReferidasAlLaboratorio() + 1);
                            break;

                        case "REFERIDO POR EL LABORATORIO":
                            primeraTablaCitologia.setTotalMuestrasReferidasPorLaboratorio(primeraTablaCitologia.getTotalMuestrasReferidasPorLaboratorio() + 1);
                            break;
                    }
                    break;
            }
        });

        primeraTablaAnalisisClinico.setTotalMuestrasProcesadas(primeraTablaAnalisisClinico.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaAnalisisClinico.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaBacteriologia.setTotalMuestrasProcesadas(primeraTablaBacteriologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaBacteriologia.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaParasitologia.setTotalMuestrasProcesadas(primeraTablaParasitologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaParasitologia.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaMicologia.setTotalMuestrasProcesadas(primeraTablaMicologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaMicologia.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaInmunologia.setTotalMuestrasProcesadas(primeraTablaInmunologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaInmunologia.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaVirologia.setTotalMuestrasProcesadas(primeraTablaVirologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaVirologia.getTotalMuestrasReferidasAlLaboratorio());
        primeraTablaCitologia.setTotalMuestrasProcesadas(primeraTablaCitologia.getTotalMuestrasTomadasEnElLaboratorio() + primeraTablaCitologia.getTotalMuestrasReferidasAlLaboratorio());

        resultadosPrimeraTabla.add(primeraTablaAnalisisClinico);
        resultadosPrimeraTabla.add(primeraTablaBacteriologia);
        resultadosPrimeraTabla.add(primeraTablaParasitologia);
        resultadosPrimeraTabla.add(primeraTablaMicologia);
        resultadosPrimeraTabla.add(primeraTablaInmunologia);
        resultadosPrimeraTabla.add(primeraTablaVirologia);
        resultadosPrimeraTabla.add(primeraTablaCitologia);
        return resultadosPrimeraTabla;
    }

    private List<SegundaTabla> construirSegundaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<SegundaTabla> resultadosSegundaTabla = new ArrayList<>();

        final SegundaTabla segundaTablaAnalisisClinicoHematologia = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaAnalisisClinicoBioquimica = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaAnalisisClinicoUroAnalisisEGO = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaAnalisisClinicoSerologia = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaAnalisisClinicoCitoquimica = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaBacteriologiaBacterioscopia = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaBacteriologiaCultivo = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaBacteriologiaAntibiograma = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaBacteriologiaSerologiaYBM = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaParasitologiaExamenDirecto = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaParasitologiaSerologiaYBM = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaParasitologiaCultivo = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaMicologiaExamenDirecto = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaMicologiaCultivo = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaMicologiaAntifungigramaYOtros = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaInmunologiaInmunoserologia = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaInmunologiaBiologiaMolecular = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaVirologiaInmunoserologia = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaVirologiaAislamientoViral = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaVirologiaBiologiaMolecular = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);
        final SegundaTabla segundaTablaVirologiaCargaViral = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaCitologiaCitologico = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        final SegundaTabla segundaTablaTotal = new SegundaTabla(0, 0, 0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralPersonalizado) -> {
            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getEspecialidad().getEspecialidadNombre()) {
                case "ANALISIS CLINICO":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "HEMATOLOGIA":
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA") && (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SANGRE") || resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SUERO"))) {
                                final int size = resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().size();
                                int countGrupoVariablesHemogramaCompleto = 0;
                                int countOthersGrupoVariablesHemograma = 0;
                                for (int i = 0; i < size; i++) {
                                    switch (resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getGrupoVariables().getGrupoVariableNombre()) {
                                        case "SERIE ROJA":
                                        case "SERIE BLANCA":
                                        case "SERIE PLAQUETARIA": {
                                            countGrupoVariablesHemogramaCompleto = countGrupoVariablesHemogramaCompleto + 1;
                                        }
                                        break;

                                        case "GRUPO SANGUINEO Y FACTOR RH":
                                            countOthersGrupoVariablesHemograma++;
                                            break;

                                        case "HEMOPARASITOS":
                                            segundaTablaParasitologiaExamenDirecto.setSangreSuero(segundaTablaParasitologiaExamenDirecto.getSangreSuero() + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size());
                                            break;

                                        case "COAGULOGRAMA":
                                            countOthersGrupoVariablesHemograma = countOthersGrupoVariablesHemograma + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().get(i).getVariablesExamenInformePersonalizado().size();
                                            break;
                                    }
                                }

                                if (countGrupoVariablesHemogramaCompleto == 3 && countOthersGrupoVariablesHemograma == 0) {
                                    segundaTablaAnalisisClinicoHematologia.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + 1);
                                } else if (countGrupoVariablesHemogramaCompleto == 3 && countOthersGrupoVariablesHemograma > 0) {
                                    segundaTablaAnalisisClinicoHematologia.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + 1 + countOthersGrupoVariablesHemograma);
                                } else if (countGrupoVariablesHemogramaCompleto < 3 && countOthersGrupoVariablesHemograma > 0) {
                                    segundaTablaAnalisisClinicoHematologia.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + countOthersGrupoVariablesHemograma);

                                }
                            } else if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("COAGULOGRAMA") && (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SANGRE") || resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SUERO"))) {
                                segundaTablaAnalisisClinicoHematologia.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + resultadoGeneralPersonalizado.getGrupoVariablesInformePersonalizado().size());
                            } else if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SANGRE") || resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo().equals("SUERO")) {
                                segundaTablaAnalisisClinicoHematologia.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + 1);
                            }
                            break;

                        case "BIOQUIMICA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaAnalisisClinicoBioquimica.setSangreSuero(segundaTablaAnalisisClinicoBioquimica.getSangreSuero() + 1);
                                    break;
                                }

                                case "ORINA":
                                    segundaTablaAnalisisClinicoBioquimica.setOrina(segundaTablaAnalisisClinicoBioquimica.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaAnalisisClinicoBioquimica.setSecrecion(segundaTablaAnalisisClinicoBioquimica.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaAnalisisClinicoBioquimica.setLiquidoBiologico(segundaTablaAnalisisClinicoBioquimica.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaAnalisisClinicoBioquimica.setOtras(segundaTablaAnalisisClinicoBioquimica.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "URO ANALISIS (E.G.O.)":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "ORINA":
                                    segundaTablaAnalisisClinicoUroAnalisisEGO.setOrina(segundaTablaAnalisisClinicoUroAnalisisEGO.getOrina() + 1);
                                    break;
                            }
                            break;

                        case "SEROLOGIA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaAnalisisClinicoSerologia.setSangreSuero(segundaTablaAnalisisClinicoSerologia.getSangreSuero() + 1);
                                    break;
                                }

                                case "ORINA":
                                    segundaTablaAnalisisClinicoSerologia.setOrina(segundaTablaAnalisisClinicoSerologia.getOrina() + 1);
                                    break;
                            }
                            break;

                        case "CITOQUIMICA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "HECES FECALES":
                                    segundaTablaAnalisisClinicoCitoquimica.setHecesFecales(segundaTablaAnalisisClinicoCitoquimica.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaAnalisisClinicoCitoquimica.setEsputo(segundaTablaAnalisisClinicoCitoquimica.getEsputo() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaAnalisisClinicoCitoquimica.setSecrecion(segundaTablaAnalisisClinicoCitoquimica.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaAnalisisClinicoCitoquimica.setLiquidoBiologico(segundaTablaAnalisisClinicoCitoquimica.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaAnalisisClinicoCitoquimica.setOtras(segundaTablaAnalisisClinicoCitoquimica.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "BACTERIOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "BACTERIOSCOPIA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaBacteriologiaBacterioscopia.setSangreSuero(segundaTablaBacteriologiaBacterioscopia.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaBacteriologiaBacterioscopia.setHecesFecales(segundaTablaBacteriologiaBacterioscopia.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaBacteriologiaBacterioscopia.setEsputo(segundaTablaBacteriologiaBacterioscopia.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaBacteriologiaBacterioscopia.setOrina(segundaTablaBacteriologiaBacterioscopia.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaBacteriologiaBacterioscopia.setSecrecion(segundaTablaBacteriologiaBacterioscopia.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaBacteriologiaBacterioscopia.setLiquidoBiologico(segundaTablaBacteriologiaBacterioscopia.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaBacteriologiaBacterioscopia.setOtras(segundaTablaBacteriologiaBacterioscopia.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "CULTIVO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaBacteriologiaCultivo.setSangreSuero(segundaTablaBacteriologiaCultivo.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaBacteriologiaCultivo.setHecesFecales(segundaTablaBacteriologiaCultivo.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaBacteriologiaCultivo.setEsputo(segundaTablaBacteriologiaCultivo.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaBacteriologiaCultivo.setOrina(segundaTablaBacteriologiaCultivo.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaBacteriologiaCultivo.setSecrecion(segundaTablaBacteriologiaCultivo.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaBacteriologiaCultivo.setLiquidoBiologico(segundaTablaBacteriologiaCultivo.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaBacteriologiaCultivo.setOtras(segundaTablaBacteriologiaCultivo.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "ANTIBIOGRAMA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaBacteriologiaAntibiograma.setSangreSuero(segundaTablaBacteriologiaAntibiograma.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaBacteriologiaAntibiograma.setHecesFecales(segundaTablaBacteriologiaAntibiograma.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaBacteriologiaAntibiograma.setEsputo(segundaTablaBacteriologiaAntibiograma.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaBacteriologiaAntibiograma.setOrina(segundaTablaBacteriologiaAntibiograma.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaBacteriologiaAntibiograma.setSecrecion(segundaTablaBacteriologiaAntibiograma.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaBacteriologiaAntibiograma.setLiquidoBiologico(segundaTablaBacteriologiaAntibiograma.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaBacteriologiaAntibiograma.setOtras(segundaTablaBacteriologiaAntibiograma.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "SEROLOGIA Y B.M. **":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaBacteriologiaSerologiaYBM.setSangreSuero(segundaTablaBacteriologiaSerologiaYBM.getSangreSuero() + 1);
                                    break;
                                }

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaBacteriologiaSerologiaYBM.setLiquidoBiologico(segundaTablaBacteriologiaSerologiaYBM.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaBacteriologiaSerologiaYBM.setOtras(segundaTablaBacteriologiaSerologiaYBM.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "PARASITOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "EXAMEN DIRECTO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaParasitologiaExamenDirecto.setSangreSuero(segundaTablaParasitologiaExamenDirecto.getSangreSuero() + 1);
                                }
                                break;

                                case "HECES FECALES":
                                    segundaTablaParasitologiaExamenDirecto.setHecesFecales(segundaTablaParasitologiaExamenDirecto.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaParasitologiaExamenDirecto.setEsputo(segundaTablaParasitologiaExamenDirecto.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaParasitologiaExamenDirecto.setOrina(segundaTablaParasitologiaExamenDirecto.getOrina() + 1);
                                    break;

                                default:
                                    segundaTablaParasitologiaExamenDirecto.setOtras(segundaTablaParasitologiaExamenDirecto.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "SEROLOGIA Y B.M. **":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                                        segundaTablaParasitologiaSerologiaYBM.setSangreSuero(segundaTablaParasitologiaSerologiaYBM.getSangreSuero() + 2);
                                    } else {
                                        segundaTablaParasitologiaSerologiaYBM.setSangreSuero(segundaTablaParasitologiaSerologiaYBM.getSangreSuero() + 1);
                                    }
                                }
                                break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaParasitologiaSerologiaYBM.setLiquidoBiologico(segundaTablaParasitologiaSerologiaYBM.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaParasitologiaSerologiaYBM.setOtras(segundaTablaParasitologiaSerologiaYBM.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "CULTIVO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaParasitologiaCultivo.setSangreSuero(segundaTablaParasitologiaCultivo.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaParasitologiaCultivo.setHecesFecales(segundaTablaParasitologiaCultivo.getHecesFecales() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaParasitologiaCultivo.setOrina(segundaTablaParasitologiaCultivo.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaParasitologiaCultivo.setSecrecion(segundaTablaParasitologiaCultivo.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaParasitologiaCultivo.setLiquidoBiologico(segundaTablaParasitologiaCultivo.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaParasitologiaCultivo.setOtras(segundaTablaParasitologiaCultivo.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "MICOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "EXAMEN DIRECTO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaMicologiaExamenDirecto.setSangreSuero(segundaTablaMicologiaExamenDirecto.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaMicologiaExamenDirecto.setHecesFecales(segundaTablaMicologiaExamenDirecto.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaMicologiaExamenDirecto.setEsputo(segundaTablaMicologiaExamenDirecto.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaMicologiaExamenDirecto.setOrina(segundaTablaMicologiaExamenDirecto.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaMicologiaExamenDirecto.setSecrecion(segundaTablaMicologiaExamenDirecto.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaMicologiaExamenDirecto.setLiquidoBiologico(segundaTablaMicologiaExamenDirecto.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaMicologiaExamenDirecto.setOtras(segundaTablaMicologiaExamenDirecto.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "CULTIVO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaMicologiaCultivo.setSangreSuero(segundaTablaMicologiaCultivo.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaMicologiaCultivo.setHecesFecales(segundaTablaMicologiaCultivo.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaMicologiaCultivo.setEsputo(segundaTablaMicologiaCultivo.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaMicologiaCultivo.setOrina(segundaTablaMicologiaCultivo.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaMicologiaCultivo.setSecrecion(segundaTablaMicologiaCultivo.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaMicologiaCultivo.setLiquidoBiologico(segundaTablaMicologiaCultivo.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaMicologiaCultivo.setOtras(segundaTablaMicologiaCultivo.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "ANTIFUNGIGRAMA Y OTROS":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaMicologiaAntifungigramaYOtros.setSangreSuero(segundaTablaMicologiaAntifungigramaYOtros.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaMicologiaAntifungigramaYOtros.setHecesFecales(segundaTablaMicologiaAntifungigramaYOtros.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaMicologiaAntifungigramaYOtros.setEsputo(segundaTablaMicologiaAntifungigramaYOtros.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaMicologiaAntifungigramaYOtros.setOrina(segundaTablaMicologiaAntifungigramaYOtros.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaMicologiaAntifungigramaYOtros.setSecrecion(segundaTablaMicologiaAntifungigramaYOtros.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaMicologiaAntifungigramaYOtros.setLiquidoBiologico(segundaTablaMicologiaAntifungigramaYOtros.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaMicologiaAntifungigramaYOtros.setOtras(segundaTablaMicologiaAntifungigramaYOtros.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "INMUNOLGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "INMUNOSEROLOGIA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaInmunologiaInmunoserologia.setSangreSuero(segundaTablaInmunologiaInmunoserologia.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaInmunologiaInmunoserologia.setHecesFecales(segundaTablaInmunologiaInmunoserologia.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaInmunologiaInmunoserologia.setEsputo(segundaTablaInmunologiaInmunoserologia.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaInmunologiaInmunoserologia.setOrina(segundaTablaInmunologiaInmunoserologia.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaInmunologiaInmunoserologia.setSecrecion(segundaTablaInmunologiaInmunoserologia.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaInmunologiaInmunoserologia.setLiquidoBiologico(segundaTablaInmunologiaInmunoserologia.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaInmunologiaInmunoserologia.setOtras(segundaTablaInmunologiaInmunoserologia.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "BIOLOGICA MOLECULAR":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaInmunologiaBiologiaMolecular.setSangreSuero(segundaTablaInmunologiaBiologiaMolecular.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaInmunologiaBiologiaMolecular.setHecesFecales(segundaTablaInmunologiaBiologiaMolecular.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaInmunologiaBiologiaMolecular.setEsputo(segundaTablaInmunologiaBiologiaMolecular.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaInmunologiaBiologiaMolecular.setOrina(segundaTablaInmunologiaBiologiaMolecular.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaInmunologiaBiologiaMolecular.setSecrecion(segundaTablaInmunologiaBiologiaMolecular.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaInmunologiaBiologiaMolecular.setLiquidoBiologico(segundaTablaInmunologiaBiologiaMolecular.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaInmunologiaBiologiaMolecular.setOtras(segundaTablaInmunologiaBiologiaMolecular.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "VIROLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "INMUNOSEROLOGIA":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaVirologiaInmunoserologia.setSangreSuero(segundaTablaVirologiaInmunoserologia.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaVirologiaInmunoserologia.setHecesFecales(segundaTablaVirologiaInmunoserologia.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaVirologiaInmunoserologia.setEsputo(segundaTablaVirologiaInmunoserologia.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaVirologiaInmunoserologia.setOrina(segundaTablaVirologiaInmunoserologia.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaVirologiaInmunoserologia.setSecrecion(segundaTablaVirologiaInmunoserologia.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaVirologiaInmunoserologia.setLiquidoBiologico(segundaTablaVirologiaInmunoserologia.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaVirologiaInmunoserologia.setOtras(segundaTablaVirologiaInmunoserologia.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "AISLAMIENTO VIRAL":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaVirologiaAislamientoViral.setSangreSuero(segundaTablaVirologiaAislamientoViral.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaVirologiaAislamientoViral.setHecesFecales(segundaTablaVirologiaAislamientoViral.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaVirologiaAislamientoViral.setEsputo(segundaTablaVirologiaAislamientoViral.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaVirologiaAislamientoViral.setOrina(segundaTablaVirologiaAislamientoViral.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaVirologiaAislamientoViral.setSecrecion(segundaTablaVirologiaAislamientoViral.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaVirologiaAislamientoViral.setLiquidoBiologico(segundaTablaVirologiaAislamientoViral.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaVirologiaAislamientoViral.setOtras(segundaTablaVirologiaAislamientoViral.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "BIOLOGIA MOLECULAR":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaVirologiaBiologiaMolecular.setSangreSuero(segundaTablaVirologiaBiologiaMolecular.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaVirologiaBiologiaMolecular.setHecesFecales(segundaTablaVirologiaBiologiaMolecular.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaVirologiaBiologiaMolecular.setEsputo(segundaTablaVirologiaBiologiaMolecular.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaVirologiaBiologiaMolecular.setOrina(segundaTablaVirologiaBiologiaMolecular.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaVirologiaBiologiaMolecular.setSecrecion(segundaTablaVirologiaBiologiaMolecular.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaVirologiaBiologiaMolecular.setLiquidoBiologico(segundaTablaVirologiaBiologiaMolecular.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaVirologiaBiologiaMolecular.setOtras(segundaTablaVirologiaBiologiaMolecular.getOtras() + 1);
                                    break;
                            }
                            break;

                        case "CARGA VIRAL":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaVirologiaCargaViral.setSangreSuero(segundaTablaVirologiaCargaViral.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaVirologiaCargaViral.setHecesFecales(segundaTablaVirologiaCargaViral.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaVirologiaCargaViral.setEsputo(segundaTablaVirologiaCargaViral.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaVirologiaCargaViral.setOrina(segundaTablaVirologiaCargaViral.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaVirologiaCargaViral.setSecrecion(segundaTablaVirologiaCargaViral.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaVirologiaCargaViral.setLiquidoBiologico(segundaTablaVirologiaCargaViral.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaVirologiaCargaViral.setOtras(segundaTablaVirologiaCargaViral.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;

                case "CITOLOGIA":
                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre()) {
                        case "CITOLOGICO":
                            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo()) {
                                case "SANGRE":
                                case "SUERO": {
                                    segundaTablaCitologiaCitologico.setSangreSuero(segundaTablaCitologiaCitologico.getSangreSuero() + 1);
                                    break;
                                }

                                case "HECES FECALES":
                                    segundaTablaCitologiaCitologico.setHecesFecales(segundaTablaCitologiaCitologico.getHecesFecales() + 1);
                                    break;

                                case "ESPUTO":
                                    segundaTablaCitologiaCitologico.setEsputo(segundaTablaCitologiaCitologico.getEsputo() + 1);
                                    break;

                                case "ORINA":
                                    segundaTablaCitologiaCitologico.setOrina(segundaTablaCitologiaCitologico.getOrina() + 1);
                                    break;

                                case "SECRECION":
                                    segundaTablaCitologiaCitologico.setSecrecion(segundaTablaCitologiaCitologico.getSecrecion() + 1);
                                    break;

                                case "LIQUIDO BIOLOGICO":
                                    segundaTablaCitologiaCitologico.setLiquidoBiologico(segundaTablaCitologiaCitologico.getLiquidoBiologico() + 1);
                                    break;

                                default:
                                    segundaTablaCitologiaCitologico.setOtras(segundaTablaCitologiaCitologico.getOtras() + 1);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        });

        segundaTablaAnalisisClinicoHematologia.setTotal(segundaTablaAnalisisClinicoHematologia.getSangreSuero());
        segundaTablaAnalisisClinicoBioquimica.setTotal(segundaTablaAnalisisClinicoBioquimica.getSangreSuero() + segundaTablaAnalisisClinicoBioquimica.getOrina() + segundaTablaAnalisisClinicoBioquimica.getSecrecion() + segundaTablaAnalisisClinicoBioquimica.getLiquidoBiologico() + segundaTablaAnalisisClinicoBioquimica.getOtras());
        segundaTablaAnalisisClinicoUroAnalisisEGO.setTotal(segundaTablaAnalisisClinicoUroAnalisisEGO.getOrina());
        segundaTablaAnalisisClinicoSerologia.setTotal(segundaTablaAnalisisClinicoSerologia.getSangreSuero() + segundaTablaAnalisisClinicoSerologia.getOrina());
        segundaTablaAnalisisClinicoCitoquimica.setTotal(segundaTablaAnalisisClinicoCitoquimica.getHecesFecales() + segundaTablaAnalisisClinicoCitoquimica.getEsputo() + segundaTablaAnalisisClinicoCitoquimica.getSecrecion() + segundaTablaAnalisisClinicoCitoquimica.getLiquidoBiologico() + segundaTablaAnalisisClinicoCitoquimica.getOtras());
        segundaTablaBacteriologiaBacterioscopia.setTotal(segundaTablaBacteriologiaBacterioscopia.getSangreSuero() + segundaTablaBacteriologiaBacterioscopia.getHecesFecales() + segundaTablaBacteriologiaBacterioscopia.getEsputo() + segundaTablaBacteriologiaBacterioscopia.getOrina() + segundaTablaBacteriologiaBacterioscopia.getSecrecion() + segundaTablaBacteriologiaBacterioscopia.getLiquidoBiologico() + segundaTablaBacteriologiaBacterioscopia.getOtras());
        segundaTablaBacteriologiaCultivo.setTotal(segundaTablaBacteriologiaCultivo.getSangreSuero() + segundaTablaBacteriologiaCultivo.getHecesFecales() + segundaTablaBacteriologiaCultivo.getEsputo() + segundaTablaBacteriologiaCultivo.getOrina() + segundaTablaBacteriologiaCultivo.getSecrecion() + segundaTablaBacteriologiaCultivo.getLiquidoBiologico() + segundaTablaBacteriologiaCultivo.getOtras());
        segundaTablaBacteriologiaAntibiograma.setTotal(segundaTablaBacteriologiaAntibiograma.getSangreSuero() + segundaTablaBacteriologiaAntibiograma.getHecesFecales() + segundaTablaBacteriologiaAntibiograma.getEsputo() + segundaTablaBacteriologiaAntibiograma.getOrina() + segundaTablaBacteriologiaAntibiograma.getSecrecion() + segundaTablaBacteriologiaAntibiograma.getLiquidoBiologico() + segundaTablaBacteriologiaAntibiograma.getOtras());
        segundaTablaBacteriologiaSerologiaYBM.setTotal(segundaTablaBacteriologiaSerologiaYBM.getSangreSuero() + segundaTablaBacteriologiaSerologiaYBM.getLiquidoBiologico() + segundaTablaBacteriologiaSerologiaYBM.getOtras());
        segundaTablaParasitologiaExamenDirecto.setTotal(segundaTablaParasitologiaExamenDirecto.getSangreSuero() + segundaTablaParasitologiaExamenDirecto.getHecesFecales() + segundaTablaParasitologiaExamenDirecto.getEsputo() + segundaTablaParasitologiaExamenDirecto.getOrina() + segundaTablaParasitologiaExamenDirecto.getOtras());
        segundaTablaParasitologiaSerologiaYBM.setTotal(segundaTablaParasitologiaSerologiaYBM.getSangreSuero() + segundaTablaParasitologiaSerologiaYBM.getLiquidoBiologico() + segundaTablaParasitologiaSerologiaYBM.getOtras());
        segundaTablaParasitologiaCultivo.setTotal(segundaTablaParasitologiaCultivo.getSangreSuero() + segundaTablaParasitologiaCultivo.getHecesFecales() + segundaTablaParasitologiaCultivo.getOrina() + segundaTablaParasitologiaCultivo.getSecrecion() + segundaTablaParasitologiaCultivo.getLiquidoBiologico() + segundaTablaParasitologiaCultivo.getOtras());
        segundaTablaMicologiaExamenDirecto.setTotal(segundaTablaMicologiaExamenDirecto.getSangreSuero() + segundaTablaMicologiaExamenDirecto.getHecesFecales() + segundaTablaMicologiaExamenDirecto.getEsputo() + segundaTablaMicologiaExamenDirecto.getOrina() + segundaTablaMicologiaExamenDirecto.getSecrecion() + segundaTablaMicologiaExamenDirecto.getLiquidoBiologico() + segundaTablaMicologiaExamenDirecto.getOtras());
        segundaTablaMicologiaCultivo.setTotal(segundaTablaMicologiaCultivo.getSangreSuero() + segundaTablaMicologiaCultivo.getHecesFecales() + segundaTablaMicologiaCultivo.getEsputo() + segundaTablaMicologiaCultivo.getOrina() + segundaTablaMicologiaCultivo.getSecrecion() + segundaTablaMicologiaCultivo.getLiquidoBiologico() + segundaTablaMicologiaCultivo.getOtras());
        segundaTablaMicologiaAntifungigramaYOtros.setTotal(segundaTablaMicologiaAntifungigramaYOtros.getSangreSuero() + segundaTablaMicologiaAntifungigramaYOtros.getHecesFecales() + segundaTablaMicologiaAntifungigramaYOtros.getEsputo() + segundaTablaMicologiaAntifungigramaYOtros.getOrina() + segundaTablaMicologiaAntifungigramaYOtros.getSecrecion() + segundaTablaMicologiaAntifungigramaYOtros.getLiquidoBiologico() + segundaTablaMicologiaAntifungigramaYOtros.getOtras());
        segundaTablaInmunologiaInmunoserologia.setTotal(segundaTablaInmunologiaInmunoserologia.getSangreSuero() + segundaTablaInmunologiaInmunoserologia.getHecesFecales() + segundaTablaInmunologiaInmunoserologia.getEsputo() + segundaTablaInmunologiaInmunoserologia.getOrina() + segundaTablaInmunologiaInmunoserologia.getSecrecion() + segundaTablaInmunologiaInmunoserologia.getLiquidoBiologico() + segundaTablaInmunologiaInmunoserologia.getOtras());
        segundaTablaInmunologiaBiologiaMolecular.setTotal(segundaTablaInmunologiaBiologiaMolecular.getSangreSuero() + segundaTablaInmunologiaBiologiaMolecular.getHecesFecales() + segundaTablaInmunologiaBiologiaMolecular.getEsputo() + segundaTablaInmunologiaBiologiaMolecular.getOrina() + segundaTablaInmunologiaBiologiaMolecular.getSecrecion() + segundaTablaInmunologiaBiologiaMolecular.getLiquidoBiologico() + segundaTablaInmunologiaBiologiaMolecular.getOtras());
        segundaTablaVirologiaInmunoserologia.setTotal(segundaTablaVirologiaInmunoserologia.getSangreSuero() + segundaTablaVirologiaInmunoserologia.getHecesFecales() + segundaTablaVirologiaInmunoserologia.getEsputo() + segundaTablaVirologiaInmunoserologia.getOrina() + segundaTablaVirologiaInmunoserologia.getSecrecion() + segundaTablaVirologiaInmunoserologia.getLiquidoBiologico() + segundaTablaVirologiaInmunoserologia.getOtras());
        segundaTablaVirologiaAislamientoViral.setTotal(segundaTablaVirologiaAislamientoViral.getSangreSuero() + segundaTablaVirologiaAislamientoViral.getHecesFecales() + segundaTablaVirologiaAislamientoViral.getEsputo() + segundaTablaVirologiaAislamientoViral.getOrina() + segundaTablaVirologiaAislamientoViral.getSecrecion() + segundaTablaVirologiaAislamientoViral.getLiquidoBiologico() + segundaTablaVirologiaAislamientoViral.getOtras());
        segundaTablaVirologiaBiologiaMolecular.setTotal(segundaTablaVirologiaBiologiaMolecular.getSangreSuero() + segundaTablaVirologiaBiologiaMolecular.getHecesFecales() + segundaTablaVirologiaBiologiaMolecular.getEsputo() + segundaTablaVirologiaBiologiaMolecular.getOrina() + segundaTablaVirologiaBiologiaMolecular.getSecrecion() + segundaTablaVirologiaBiologiaMolecular.getLiquidoBiologico());
        segundaTablaVirologiaCargaViral.setTotal(segundaTablaVirologiaCargaViral.getSangreSuero() + segundaTablaVirologiaCargaViral.getHecesFecales() + segundaTablaVirologiaCargaViral.getEsputo() + segundaTablaVirologiaCargaViral.getOrina() + segundaTablaVirologiaCargaViral.getSecrecion() + segundaTablaVirologiaCargaViral.getLiquidoBiologico() + segundaTablaVirologiaCargaViral.getOtras());
        segundaTablaCitologiaCitologico.setTotal(segundaTablaCitologiaCitologico.getSangreSuero() + segundaTablaCitologiaCitologico.getHecesFecales() + segundaTablaCitologiaCitologico.getEsputo() + segundaTablaCitologiaCitologico.getOrina() + segundaTablaCitologiaCitologico.getSecrecion() + segundaTablaCitologiaCitologico.getLiquidoBiologico() + segundaTablaCitologiaCitologico.getOtras());

        segundaTablaTotal.setSangreSuero(segundaTablaAnalisisClinicoHematologia.getSangreSuero() + segundaTablaAnalisisClinicoBioquimica.getSangreSuero() + segundaTablaAnalisisClinicoSerologia.getSangreSuero() + segundaTablaBacteriologiaBacterioscopia.getSangreSuero() + segundaTablaBacteriologiaCultivo.getSangreSuero() + segundaTablaBacteriologiaAntibiograma.getSangreSuero() + segundaTablaBacteriologiaSerologiaYBM.getSangreSuero() + segundaTablaParasitologiaExamenDirecto.getSangreSuero() + segundaTablaParasitologiaSerologiaYBM.getSangreSuero() + segundaTablaParasitologiaCultivo.getSangreSuero() + segundaTablaMicologiaExamenDirecto.getSangreSuero() + segundaTablaMicologiaCultivo.getSangreSuero() + segundaTablaMicologiaAntifungigramaYOtros.getSangreSuero() + segundaTablaInmunologiaInmunoserologia.getSangreSuero() + segundaTablaInmunologiaBiologiaMolecular.getSangreSuero() + segundaTablaVirologiaInmunoserologia.getSangreSuero() + segundaTablaVirologiaAislamientoViral.getSangreSuero() + segundaTablaVirologiaBiologiaMolecular.getSangreSuero() + segundaTablaVirologiaCargaViral.getSangreSuero() + segundaTablaCitologiaCitologico.getSangreSuero());
        segundaTablaTotal.setHecesFecales(segundaTablaAnalisisClinicoCitoquimica.getHecesFecales() + segundaTablaBacteriologiaBacterioscopia.getHecesFecales() + segundaTablaBacteriologiaCultivo.getHecesFecales() + segundaTablaBacteriologiaAntibiograma.getHecesFecales() + segundaTablaParasitologiaExamenDirecto.getHecesFecales() + segundaTablaParasitologiaCultivo.getHecesFecales() + segundaTablaMicologiaExamenDirecto.getHecesFecales() + segundaTablaMicologiaCultivo.getHecesFecales() + segundaTablaMicologiaAntifungigramaYOtros.getHecesFecales() + segundaTablaInmunologiaInmunoserologia.getHecesFecales() + segundaTablaInmunologiaBiologiaMolecular.getHecesFecales() + segundaTablaVirologiaInmunoserologia.getHecesFecales() + segundaTablaVirologiaAislamientoViral.getHecesFecales() + segundaTablaVirologiaBiologiaMolecular.getHecesFecales() + segundaTablaVirologiaCargaViral.getHecesFecales() + segundaTablaCitologiaCitologico.getHecesFecales());
        segundaTablaTotal.setEsputo(segundaTablaAnalisisClinicoCitoquimica.getEsputo() + segundaTablaBacteriologiaBacterioscopia.getEsputo() + segundaTablaBacteriologiaCultivo.getEsputo() + segundaTablaBacteriologiaAntibiograma.getEsputo() + segundaTablaParasitologiaExamenDirecto.getEsputo() + segundaTablaMicologiaExamenDirecto.getEsputo() + segundaTablaMicologiaCultivo.getEsputo() + segundaTablaMicologiaAntifungigramaYOtros.getEsputo() + segundaTablaInmunologiaInmunoserologia.getEsputo() + segundaTablaInmunologiaBiologiaMolecular.getEsputo() + segundaTablaVirologiaInmunoserologia.getEsputo() + segundaTablaVirologiaAislamientoViral.getEsputo() + segundaTablaVirologiaBiologiaMolecular.getEsputo() + segundaTablaVirologiaCargaViral.getEsputo() + segundaTablaCitologiaCitologico.getEsputo());
        segundaTablaTotal.setOrina(segundaTablaAnalisisClinicoBioquimica.getOrina() + segundaTablaAnalisisClinicoBioquimica.getOrina() + segundaTablaAnalisisClinicoUroAnalisisEGO.getOrina() + segundaTablaAnalisisClinicoSerologia.getOrina() + segundaTablaBacteriologiaBacterioscopia.getOrina() + segundaTablaBacteriologiaCultivo.getOrina() + segundaTablaBacteriologiaAntibiograma.getOrina() + segundaTablaParasitologiaExamenDirecto.getOrina() + segundaTablaParasitologiaCultivo.getOrina() + segundaTablaMicologiaExamenDirecto.getOrina() + segundaTablaMicologiaCultivo.getOrina() + segundaTablaMicologiaAntifungigramaYOtros.getOrina() + segundaTablaInmunologiaInmunoserologia.getOrina() + segundaTablaInmunologiaBiologiaMolecular.getOrina() + segundaTablaVirologiaInmunoserologia.getOrina() + segundaTablaVirologiaAislamientoViral.getOrina() + segundaTablaVirologiaBiologiaMolecular.getOrina() + segundaTablaVirologiaCargaViral.getOrina() + segundaTablaCitologiaCitologico.getOrina());
        segundaTablaTotal.setSecrecion(segundaTablaAnalisisClinicoBioquimica.getSecrecion() + segundaTablaAnalisisClinicoBioquimica.getSecrecion() + segundaTablaAnalisisClinicoCitoquimica.getSecrecion() + segundaTablaBacteriologiaBacterioscopia.getSecrecion() + segundaTablaBacteriologiaCultivo.getSecrecion() + segundaTablaBacteriologiaAntibiograma.getSecrecion() + segundaTablaParasitologiaCultivo.getSecrecion() + segundaTablaMicologiaExamenDirecto.getSecrecion() + segundaTablaMicologiaCultivo.getSecrecion() + segundaTablaMicologiaAntifungigramaYOtros.getSecrecion() + segundaTablaInmunologiaInmunoserologia.getSecrecion() + segundaTablaInmunologiaBiologiaMolecular.getSecrecion() + segundaTablaVirologiaInmunoserologia.getSecrecion() + segundaTablaVirologiaAislamientoViral.getSecrecion() + segundaTablaVirologiaBiologiaMolecular.getSecrecion() + segundaTablaVirologiaCargaViral.getSecrecion() + segundaTablaCitologiaCitologico.getSecrecion());
        segundaTablaTotal.setLiquidoBiologico(segundaTablaAnalisisClinicoBioquimica.getLiquidoBiologico() + segundaTablaAnalisisClinicoCitoquimica.getLiquidoBiologico() + segundaTablaBacteriologiaBacterioscopia.getLiquidoBiologico() + segundaTablaBacteriologiaCultivo.getLiquidoBiologico() + segundaTablaBacteriologiaAntibiograma.getLiquidoBiologico() + segundaTablaBacteriologiaSerologiaYBM.getLiquidoBiologico() + segundaTablaParasitologiaSerologiaYBM.getLiquidoBiologico() + segundaTablaMicologiaExamenDirecto.getLiquidoBiologico() + segundaTablaMicologiaCultivo.getLiquidoBiologico() + segundaTablaMicologiaAntifungigramaYOtros.getLiquidoBiologico() + segundaTablaInmunologiaInmunoserologia.getLiquidoBiologico() + segundaTablaInmunologiaBiologiaMolecular.getLiquidoBiologico() + segundaTablaVirologiaInmunoserologia.getLiquidoBiologico() + segundaTablaVirologiaAislamientoViral.getLiquidoBiologico() + segundaTablaVirologiaBiologiaMolecular.getLiquidoBiologico() + segundaTablaVirologiaCargaViral.getLiquidoBiologico() + segundaTablaCitologiaCitologico.getLiquidoBiologico());
        segundaTablaTotal.setOtras(segundaTablaAnalisisClinicoBioquimica.getOtras() + segundaTablaAnalisisClinicoCitoquimica.getOtras() + segundaTablaBacteriologiaBacterioscopia.getOtras() + segundaTablaBacteriologiaCultivo.getOtras() + segundaTablaBacteriologiaAntibiograma.getOtras() + segundaTablaBacteriologiaSerologiaYBM.getOtras() + segundaTablaParasitologiaExamenDirecto.getOtras() + segundaTablaParasitologiaSerologiaYBM.getOtras() + segundaTablaParasitologiaCultivo.getOtras() + segundaTablaMicologiaExamenDirecto.getOtras() + segundaTablaMicologiaCultivo.getOtras() + segundaTablaMicologiaAntifungigramaYOtros.getOtras() + segundaTablaInmunologiaInmunoserologia.getOtras() + segundaTablaInmunologiaBiologiaMolecular.getOtras() + segundaTablaVirologiaInmunoserologia.getOtras() + segundaTablaVirologiaAislamientoViral.getOtras() + segundaTablaVirologiaBiologiaMolecular.getOtras() + segundaTablaVirologiaCargaViral.getOtras() + segundaTablaCitologiaCitologico.getOtras());
        segundaTablaTotal.setTotal(segundaTablaAnalisisClinicoHematologia.getTotal() + segundaTablaAnalisisClinicoBioquimica.getTotal() + segundaTablaAnalisisClinicoUroAnalisisEGO.getTotal() + segundaTablaAnalisisClinicoSerologia.getTotal() + segundaTablaAnalisisClinicoCitoquimica.getTotal() + segundaTablaBacteriologiaBacterioscopia.getTotal() + segundaTablaBacteriologiaCultivo.getTotal() + segundaTablaBacteriologiaAntibiograma.getTotal() + segundaTablaBacteriologiaSerologiaYBM.getTotal() + segundaTablaParasitologiaExamenDirecto.getTotal() + segundaTablaParasitologiaSerologiaYBM.getTotal() + segundaTablaParasitologiaCultivo.getTotal() + segundaTablaMicologiaExamenDirecto.getTotal() + segundaTablaMicologiaCultivo.getTotal() + segundaTablaMicologiaAntifungigramaYOtros.getTotal() + segundaTablaInmunologiaInmunoserologia.getTotal() + segundaTablaInmunologiaBiologiaMolecular.getTotal() + segundaTablaVirologiaInmunoserologia.getTotal() + segundaTablaVirologiaAislamientoViral.getTotal() + segundaTablaVirologiaBiologiaMolecular.getTotal() + segundaTablaVirologiaCargaViral.getTotal() + segundaTablaCitologiaCitologico.getTotal());

        resultadosSegundaTabla.add(segundaTablaAnalisisClinicoHematologia);
        resultadosSegundaTabla.add(segundaTablaAnalisisClinicoBioquimica);
        resultadosSegundaTabla.add(segundaTablaAnalisisClinicoUroAnalisisEGO);
        resultadosSegundaTabla.add(segundaTablaAnalisisClinicoSerologia);
        resultadosSegundaTabla.add(segundaTablaAnalisisClinicoCitoquimica);

        resultadosSegundaTabla.add(segundaTablaBacteriologiaBacterioscopia);
        resultadosSegundaTabla.add(segundaTablaBacteriologiaCultivo);
        resultadosSegundaTabla.add(segundaTablaBacteriologiaAntibiograma);
        resultadosSegundaTabla.add(segundaTablaBacteriologiaSerologiaYBM);

        resultadosSegundaTabla.add(segundaTablaParasitologiaExamenDirecto);
        resultadosSegundaTabla.add(segundaTablaParasitologiaSerologiaYBM);
        resultadosSegundaTabla.add(segundaTablaParasitologiaCultivo);

        resultadosSegundaTabla.add(segundaTablaMicologiaExamenDirecto);
        resultadosSegundaTabla.add(segundaTablaMicologiaCultivo);
        resultadosSegundaTabla.add(segundaTablaMicologiaAntifungigramaYOtros);

        resultadosSegundaTabla.add(segundaTablaInmunologiaInmunoserologia);
        resultadosSegundaTabla.add(segundaTablaInmunologiaBiologiaMolecular);

        resultadosSegundaTabla.add(segundaTablaVirologiaInmunoserologia);
        resultadosSegundaTabla.add(segundaTablaVirologiaAislamientoViral);
        resultadosSegundaTabla.add(segundaTablaVirologiaBiologiaMolecular);
        resultadosSegundaTabla.add(segundaTablaVirologiaCargaViral);

        resultadosSegundaTabla.add(segundaTablaCitologiaCitologico);

        resultadosSegundaTabla.add(segundaTablaTotal);

        return resultadosSegundaTabla;
    }

    private List<TerceraTabla> construirTerceraTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<TerceraTabla> resultadosTerceraTabla = new ArrayList<>();

        final TerceraTabla terceraTablaFila1 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila2 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila3 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila4 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila5 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila6 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);
        final TerceraTabla terceraTablaFila7 = new TerceraTabla(0, 0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre().equals("CHAGAS")) {
                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerEmbarazada()) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila6.setHaiSerologico(terceraTablaFila6.getHaiSerologico() + 1);
                        terceraTablaFila6.setElisaSerologico(terceraTablaFila6.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila6.setHaiSerologico(terceraTablaFila6.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila6.setElisaSerologico(terceraTablaFila6.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila6.setMicrometodoParasitologico(terceraTablaFila6.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila6.setOtrosParasitologico(terceraTablaFila6.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila6.setIcSerologico(terceraTablaFila6.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila6.setHaiSerologico(terceraTablaFila6.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila6.setElisaSerologico(terceraTablaFila6.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila6.setIfiSerologico(terceraTablaFila6.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila6.setOtrosSerologico(terceraTablaFila6.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if ((resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto()) || (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() || resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto())) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila7.setHaiSerologico(terceraTablaFila7.getHaiSerologico() + 1);
                        terceraTablaFila7.setElisaSerologico(terceraTablaFila7.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila7.setHaiSerologico(terceraTablaFila7.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila7.setElisaSerologico(terceraTablaFila7.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila7.setMicrometodoParasitologico(terceraTablaFila7.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila7.setOtrosParasitologico(terceraTablaFila7.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila7.setIcSerologico(terceraTablaFila7.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila7.setHaiSerologico(terceraTablaFila7.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila7.setElisaSerologico(terceraTablaFila7.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila7.setIfiSerologico(terceraTablaFila7.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila7.setOtrosSerologico(terceraTablaFila7.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila1.setHaiSerologico(terceraTablaFila1.getHaiSerologico() + 1);
                        terceraTablaFila1.setElisaSerologico(terceraTablaFila1.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila1.setHaiSerologico(terceraTablaFila1.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila1.setElisaSerologico(terceraTablaFila1.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila1.setMicrometodoParasitologico(terceraTablaFila1.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila1.setOtrosParasitologico(terceraTablaFila1.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila1.setIcSerologico(terceraTablaFila1.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila1.setHaiSerologico(terceraTablaFila1.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila1.setElisaSerologico(terceraTablaFila1.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila1.setIfiSerologico(terceraTablaFila1.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila1.setOtrosSerologico(terceraTablaFila1.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() > 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 12 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila2.setHaiSerologico(terceraTablaFila2.getHaiSerologico() + 1);
                        terceraTablaFila2.setElisaSerologico(terceraTablaFila2.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila2.setHaiSerologico(terceraTablaFila2.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila2.setElisaSerologico(terceraTablaFila2.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila2.setMicrometodoParasitologico(terceraTablaFila2.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila2.setOtrosParasitologico(terceraTablaFila2.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila2.setIcSerologico(terceraTablaFila2.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila2.setHaiSerologico(terceraTablaFila2.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila2.setElisaSerologico(terceraTablaFila2.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila2.setIfiSerologico(terceraTablaFila2.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila2.setOtrosSerologico(terceraTablaFila2.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 1 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila3.setHaiSerologico(terceraTablaFila3.getHaiSerologico() + 1);
                        terceraTablaFila3.setElisaSerologico(terceraTablaFila3.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila3.setHaiSerologico(terceraTablaFila3.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila3.setElisaSerologico(terceraTablaFila3.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila3.setMicrometodoParasitologico(terceraTablaFila3.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila3.setOtrosParasitologico(terceraTablaFila3.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila3.setIcSerologico(terceraTablaFila3.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila3.setHaiSerologico(terceraTablaFila3.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila3.setElisaSerologico(terceraTablaFila3.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila3.setIfiSerologico(terceraTablaFila3.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila3.setOtrosSerologico(terceraTablaFila3.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila4.setHaiSerologico(terceraTablaFila4.getHaiSerologico() + 1);
                        terceraTablaFila4.setElisaSerologico(terceraTablaFila4.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila4.setHaiSerologico(terceraTablaFila4.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila4.setElisaSerologico(terceraTablaFila4.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila4.setMicrometodoParasitologico(terceraTablaFila4.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila4.setOtrosParasitologico(terceraTablaFila4.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila4.setIcSerologico(terceraTablaFila4.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila4.setHaiSerologico(terceraTablaFila4.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila4.setElisaSerologico(terceraTablaFila4.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila4.setIfiSerologico(terceraTablaFila4.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila4.setOtrosSerologico(terceraTablaFila4.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() > 15) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        terceraTablaFila5.setHaiSerologico(terceraTablaFila5.getHaiSerologico() + 1);
                        terceraTablaFila5.setElisaSerologico(terceraTablaFila5.getElisaSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI CHAGAS")) {
                        terceraTablaFila5.setHaiSerologico(terceraTablaFila5.getHaiSerologico() + 1);
                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("ELISA CHAGAS")) {
                        terceraTablaFila5.setElisaSerologico(terceraTablaFila5.getElisaSerologico() + 1);
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO")) {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "MICROMETODO":
                                        terceraTablaFila5.setMicrometodoParasitologico(terceraTablaFila5.getMicrometodoParasitologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila5.setOtrosParasitologico(terceraTablaFila5.getOtrosParasitologico() + 1);
                                        break;
                                }
                            } else {
                                switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                    case "IC":
                                        terceraTablaFila5.setIcSerologico(terceraTablaFila5.getIcSerologico() + 1);
                                        break;

                                    case "HAI":
                                        terceraTablaFila5.setHaiSerologico(terceraTablaFila5.getHaiSerologico() + 1);
                                        break;

                                    case "ELISA":
                                        terceraTablaFila5.setElisaSerologico(terceraTablaFila5.getElisaSerologico() + 1);
                                        break;

                                    case "IFI":
                                        terceraTablaFila5.setIfiSerologico(terceraTablaFila5.getIfiSerologico() + 1);
                                        break;

                                    default:
                                        terceraTablaFila5.setOtrosSerologico(terceraTablaFila5.getOtrosSerologico() + 1);
                                        break;
                                }
                            }
                        });
                    }
                }
            }

            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                if (resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado() != null) {
                    resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado().forEach((grupoVariable) -> {
                        if (grupoVariable.getGrupoVariables().getGrupoVariableNombre().equals("HEMOPARASITOS")) {
                            grupoVariable.getVariablesExamenInformePersonalizado().forEach((variableExamen) -> {
                                if (variableExamen.getVariableExamenNombre().equals("MICROMETODO CHAGAS")) {
                                    if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                                            terceraTablaFila1.setMicrometodoParasitologico(terceraTablaFila1.getMicrometodoParasitologico() + 1);
                                        } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() > 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 12 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                                            terceraTablaFila2.setMicrometodoParasitologico(terceraTablaFila2.getMicrometodoParasitologico() + 1);
                                        } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 1 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                                            terceraTablaFila3.setMicrometodoParasitologico(terceraTablaFila3.getMicrometodoParasitologico() + 1);
                                        } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                                            terceraTablaFila4.setMicrometodoParasitologico(terceraTablaFila4.getMicrometodoParasitologico() + 1);
                                        } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() > 15) {
                                            terceraTablaFila5.setMicrometodoParasitologico(terceraTablaFila5.getMicrometodoParasitologico() + 1);
                                        } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerEmbarazada()) {
                                            terceraTablaFila6.setMicrometodoParasitologico(terceraTablaFila6.getMicrometodoParasitologico() + 1);
                                        } else if ((resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto()) || (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() || resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto())) {
                                            terceraTablaFila7.setMicrometodoParasitologico(terceraTablaFila7.getMicrometodoParasitologico() + 1);
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });

        resultadosTerceraTabla.add(terceraTablaFila1);
        resultadosTerceraTabla.add(terceraTablaFila2);
        resultadosTerceraTabla.add(terceraTablaFila3);
        resultadosTerceraTabla.add(terceraTablaFila4);
        resultadosTerceraTabla.add(terceraTablaFila5);
        resultadosTerceraTabla.add(terceraTablaFila6);
        resultadosTerceraTabla.add(terceraTablaFila7);
        return resultadosTerceraTabla;
    }

    private List<CuartaTabla> construirCuartaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<CuartaTabla> resultadosCuartaTabla = new ArrayList<>();

        final CuartaTabla cuartaTablaCutaneo = new CuartaTabla(0, 0, 0, 0, 0, 0, 0);
        final CuartaTabla cuartaTablaMuscoso = new CuartaTabla(0, 0, 0, 0, 0, 0, 0);
        final CuartaTabla cuartaTablaVisceral = new CuartaTabla(0, 0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralPersonalizado) -> {
            if (resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad() != null && resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre().equals("LEISHMANIASIS")) {
                switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                    case "CUTANEO":
                        resultadoGeneralPersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                case "FROTIS":
                                    cuartaTablaCutaneo.setFrotis(cuartaTablaCutaneo.getFrotis() + 1);
                                    break;

                                case "CULTIVO":
                                    cuartaTablaCutaneo.setCultivo(cuartaTablaCutaneo.getCultivo() + 1);
                                    break;

                                case "IDMR":
                                    cuartaTablaCutaneo.setIdmr(cuartaTablaCutaneo.getIdmr() + 1);
                                    break;

                                case "IFI":
                                    cuartaTablaCutaneo.setIfi(cuartaTablaCutaneo.getIfi() + 1);
                                    break;

                                case "ELISA":
                                    cuartaTablaCutaneo.setElisa(cuartaTablaCutaneo.getElisa() + 1);
                                    break;

                                default:
                                    cuartaTablaCutaneo.setOtras(cuartaTablaCutaneo.getOtras() + 1);
                                    break;
                            }
                        });
                        break;

                    case "MUCOSO":
                        resultadoGeneralPersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                case "FROTIS":
                                    cuartaTablaMuscoso.setFrotis(cuartaTablaMuscoso.getFrotis() + 1);
                                    break;

                                case "CULTIVO":
                                    cuartaTablaMuscoso.setCultivo(cuartaTablaMuscoso.getCultivo() + 1);
                                    break;

                                case "IDMR":
                                    cuartaTablaMuscoso.setIdmr(cuartaTablaMuscoso.getIdmr() + 1);
                                    break;

                                case "IFI":
                                    cuartaTablaMuscoso.setIfi(cuartaTablaMuscoso.getIfi() + 1);
                                    break;

                                case "ELISA":
                                    cuartaTablaMuscoso.setElisa(cuartaTablaMuscoso.getElisa() + 1);
                                    break;

                                default:
                                    cuartaTablaMuscoso.setOtras(cuartaTablaMuscoso.getOtras() + 1);
                                    break;
                            }
                        });
                        break;

                    case "VISCERAL":
                        resultadoGeneralPersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                                case "FROTIS":
                                    cuartaTablaVisceral.setFrotis(cuartaTablaVisceral.getFrotis() + 1);
                                    break;

                                case "CULTIVO":
                                    cuartaTablaVisceral.setCultivo(cuartaTablaVisceral.getCultivo() + 1);
                                    break;

                                case "PCR":
                                    cuartaTablaVisceral.setPcr(cuartaTablaVisceral.getPcr() + 1);
                                    break;

                                default:
                                    cuartaTablaVisceral.setOtras(cuartaTablaVisceral.getOtras() + 1);
                                    break;
                            }
                        });
                        break;

                    default:
                        break;
                }
            }
        });

        resultadosCuartaTabla.add(cuartaTablaCutaneo);
        resultadosCuartaTabla.add(cuartaTablaMuscoso);
        resultadosCuartaTabla.add(cuartaTablaVisceral);

        return resultadosCuartaTabla;
    }

    private List<QuintaTabla> construirQuintaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<QuintaTabla> resultadosQuintaTabla = new ArrayList<>();

        final QuintaTabla quintaTablaProblacionGeneral = new QuintaTabla(0, 0, 0, 0, 0);
        final QuintaTabla quintaTablaMujeresEmbarazadas = new QuintaTabla(0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre().equals("VIH")) {
                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerEmbarazada()) {
                    resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                        switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                            case "PRUEBA RAPIDA":
                                quintaTablaMujeresEmbarazadas.setPruebaRapida(quintaTablaMujeresEmbarazadas.getPruebaRapida() + 1);
                                break;

                            case "ELISA":
                                quintaTablaMujeresEmbarazadas.setElisa(quintaTablaMujeresEmbarazadas.getElisa() + 1);
                                break;

                            case "WESTERN BLOTT":
                                quintaTablaMujeresEmbarazadas.setWesternBlott(quintaTablaMujeresEmbarazadas.getWesternBlott() + 1);
                                break;

                            case "CARGA VIRAL":
                                quintaTablaMujeresEmbarazadas.setCargaViral(quintaTablaMujeresEmbarazadas.getCargaViral() + 1);
                                break;

                            case "SUBPOBLACIONES LINFOCITARIAS":
                                quintaTablaMujeresEmbarazadas.setSubpoblacionesLinfocitarias(quintaTablaMujeresEmbarazadas.getSubpoblacionesLinfocitarias() + 1);
                                break;

                            default:
                                break;
                        }
                    });
                } else {
                    resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                        switch (tecnicaAplicada.getTecnica().getTecnicaNombre()) {
                            case "PRUEBA RAPIDA":
                                quintaTablaProblacionGeneral.setPruebaRapida(quintaTablaProblacionGeneral.getPruebaRapida() + 1);
                                break;

                            case "ELISA":
                                quintaTablaProblacionGeneral.setElisa(quintaTablaProblacionGeneral.getElisa() + 1);
                                break;

                            case "WESTERN BLOTT":
                                quintaTablaProblacionGeneral.setWesternBlott(quintaTablaProblacionGeneral.getWesternBlott() + 1);
                                break;

                            case "CARGA VIRAL":
                                quintaTablaProblacionGeneral.setCargaViral(quintaTablaProblacionGeneral.getCargaViral() + 1);
                                break;

                            case "SUBPOBLACIONES LINFOCITARIAS":
                                quintaTablaProblacionGeneral.setSubpoblacionesLinfocitarias(quintaTablaProblacionGeneral.getSubpoblacionesLinfocitarias() + 1);
                                break;

                            default:
                                break;
                        }
                    });
                }
            }
        });

        resultadosQuintaTabla.add(quintaTablaProblacionGeneral);
        resultadosQuintaTabla.add(quintaTablaMujeresEmbarazadas);

        return resultadosQuintaTabla;
    }

    private List<SextaTabla> construirSextaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<SextaTabla> resultadosSextaTabla = new ArrayList<>();

        final SextaTabla sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaDiagnosticaSegundaMuestra = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaDiagnosticaTerceraMuestra = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinPrimeraFase = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalTercerMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalCuartoMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalQuintoMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalSextoMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalSeptimoMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlFinalOctavoMes = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaBaciloscopiaControlOtras = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaCultivoPilmonar = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaCultivoExtrapulmonar = new SextaTabla(0, 0, 0);
        final SextaTabla sextaTablaOtrosExamenes = new SextaTabla(0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre().equals("TUBERCULOSIS")) {
                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                    case "BACILOSCOPIA":
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null) {
                            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getNumeroMuestraBiologica().equals("1ra. Muestra")) {
                                sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.setMuestrasProcesadas(sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.getMuestrasProcesadas() + 1);
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.setPositivos(sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.getPositivos() + 1);
                                } else {
                                    sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.setNegativos(sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra.getNegativos() + 1);
                                }
                            } else {
                                sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.setMuestrasProcesadas(sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.getMuestrasProcesadas() + 1);
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.setPositivos(sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.getPositivos() + 1);
                                } else {
                                    sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.setNegativos(sextaTablaBaciloscopiaDiagnosticaSegundaMuestra.getNegativos() + 1);
                                }
                            }
                        } else {
                            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenControl()) {
                                case "Fin de 1ra. Fase":
                                    sextaTablaBaciloscopiaControlFinPrimeraFase.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinPrimeraFase.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinPrimeraFase.setPositivos(sextaTablaBaciloscopiaControlFinPrimeraFase.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinPrimeraFase.setNegativos(sextaTablaBaciloscopiaControlFinPrimeraFase.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 3er. Mes":
                                    sextaTablaBaciloscopiaControlFinalTercerMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalTercerMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalTercerMes.setPositivos(sextaTablaBaciloscopiaControlFinalTercerMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalTercerMes.setNegativos(sextaTablaBaciloscopiaControlFinalTercerMes.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 4to. Mes":
                                    sextaTablaBaciloscopiaControlFinalCuartoMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalCuartoMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalCuartoMes.setPositivos(sextaTablaBaciloscopiaControlFinalCuartoMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalCuartoMes.setNegativos(sextaTablaBaciloscopiaControlFinalCuartoMes.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 5to. Mes":
                                    sextaTablaBaciloscopiaControlFinalQuintoMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalQuintoMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalQuintoMes.setPositivos(sextaTablaBaciloscopiaControlFinalQuintoMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalQuintoMes.setNegativos(sextaTablaBaciloscopiaControlFinalQuintoMes.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 6to. Mes":
                                    sextaTablaBaciloscopiaControlFinalSextoMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalSextoMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalSextoMes.setPositivos(sextaTablaBaciloscopiaControlFinalSextoMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalSextoMes.setNegativos(sextaTablaBaciloscopiaControlFinalSextoMes.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 7mo. Mes":
                                    sextaTablaBaciloscopiaControlFinalSeptimoMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalSeptimoMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalSeptimoMes.setPositivos(sextaTablaBaciloscopiaControlFinalSeptimoMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalSeptimoMes.setNegativos(sextaTablaBaciloscopiaControlFinalSeptimoMes.getNegativos() + 1);
                                    }
                                    break;

                                case "Al final del 8vo. Mes":
                                    sextaTablaBaciloscopiaControlFinalOctavoMes.setMuestrasProcesadas(sextaTablaBaciloscopiaControlFinalOctavoMes.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlFinalOctavoMes.setPositivos(sextaTablaBaciloscopiaControlFinalOctavoMes.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlFinalOctavoMes.setNegativos(sextaTablaBaciloscopiaControlFinalOctavoMes.getNegativos() + 1);
                                    }
                                    break;

                                default:
                                    sextaTablaBaciloscopiaControlOtras.setMuestrasProcesadas(sextaTablaBaciloscopiaControlOtras.getMuestrasProcesadas() + 1);
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                        sextaTablaBaciloscopiaControlOtras.setPositivos(sextaTablaBaciloscopiaControlOtras.getPositivos() + 1);
                                    } else {
                                        sextaTablaBaciloscopiaControlOtras.setNegativos(sextaTablaBaciloscopiaControlOtras.getNegativos() + 1);
                                    }
                                    break;
                            }
                        }
                        break;

                    default:
                        break;
                }
            }
        });

        resultadosSextaTabla.add(sextaTablaBaciloscopiaDiagnosticaPrimeraMuestra);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaDiagnosticaSegundaMuestra);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaDiagnosticaTerceraMuestra);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinPrimeraFase);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalTercerMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalCuartoMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalQuintoMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalSextoMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalSeptimoMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlFinalOctavoMes);
        resultadosSextaTabla.add(sextaTablaBaciloscopiaControlOtras);
        resultadosSextaTabla.add(sextaTablaCultivoPilmonar);
        resultadosSextaTabla.add(sextaTablaCultivoExtrapulmonar);
        resultadosSextaTabla.add(sextaTablaOtrosExamenes);

        return resultadosSextaTabla;

    }

    private List<SeptimaTabla> construirSeptimaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<SeptimaTabla> resultadosSeptimaTabla = new ArrayList<>();

        final SeptimaTabla septimaTablaNumeroDePAPProcesados = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaNumeroDeLIEBajoGrado = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaNumeroDeLIEAltoGrado = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaOrina = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaLiquidoCefaloRaquideo = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaLiquidoPreural = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaLiquidoAscitico = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaPuncionDeOrganosProfundos = new SeptimaTabla(0, 0, 0, 0);
        final SeptimaTabla septimaTablaEsputo = new SeptimaTabla(0, 0, 0, 0);

        resultadosSeptimaTabla.add(septimaTablaNumeroDePAPProcesados);
        resultadosSeptimaTabla.add(septimaTablaNumeroDeLIEBajoGrado);
        resultadosSeptimaTabla.add(septimaTablaNumeroDeLIEAltoGrado);
        resultadosSeptimaTabla.add(septimaTablaOrina);
        resultadosSeptimaTabla.add(septimaTablaLiquidoCefaloRaquideo);
        resultadosSeptimaTabla.add(septimaTablaLiquidoPreural);
        resultadosSeptimaTabla.add(septimaTablaLiquidoAscitico);
        resultadosSeptimaTabla.add(septimaTablaPuncionDeOrganosProfundos);
        resultadosSeptimaTabla.add(septimaTablaEsputo);

        return resultadosSeptimaTabla;
    }

    private List<OctavaTabla> construirOctavaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<OctavaTabla> resultadosOctavaTabla = new ArrayList<>();

        final OctavaTabla octavaTablaDengue = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaFiebreAmarilla = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaFiebreHemorragicaBoliviana = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaHantaVirus = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaHepatitisA = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaHepatitisC = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaLeishmaniasis = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaLepra = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaMalariaMixta = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaMalariaPorPFalciparum = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaMalariaPorPVivax = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaMeningitisMeningococica = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaMeningitisTuberculosa = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaPeste = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaRabiaEnCanes = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaRabiaEnHumanos = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaRabiaEnAnimalesSilvestres = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaRubeola = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaSarampion = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaLeptospirosis = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaEnfermedadTipoInfluenzaETIABC = new OctavaTabla(0, 0, 0, 0, 0);
        final OctavaTabla octavaTablaVirusAH1N1 = new OctavaTabla(0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad() != null) {
                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre()) {
                    case "DENGUE":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaDengue.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaDengue.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaDengue.setMuestrasProcesadas(octavaTablaDengue.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaDengue.setResultadoPositivo(octavaTablaDengue.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaDengue.setResultadoNegativo(octavaTablaDengue.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            default:
                                break;
                        }
                        break;

                    case "FIEBRE AMARILLA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaFiebreAmarilla.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaFiebreAmarilla.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaFiebreAmarilla.setMuestrasProcesadas(octavaTablaFiebreAmarilla.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaFiebreAmarilla.setResultadoPositivo(octavaTablaFiebreAmarilla.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaFiebreAmarilla.setResultadoNegativo(octavaTablaFiebreAmarilla.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaFiebreAmarilla.setMuestrasReferidasPorElLaboratorio(octavaTablaFiebreAmarilla.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "FIEBRE HEMORRAGICA BOLIVIANA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaFiebreHemorragicaBoliviana.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaFiebreHemorragicaBoliviana.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaFiebreHemorragicaBoliviana.setMuestrasProcesadas(octavaTablaFiebreHemorragicaBoliviana.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaFiebreHemorragicaBoliviana.setResultadoPositivo(octavaTablaFiebreHemorragicaBoliviana.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaFiebreHemorragicaBoliviana.setResultadoNegativo(octavaTablaFiebreHemorragicaBoliviana.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaFiebreHemorragicaBoliviana.setMuestrasReferidasPorElLaboratorio(octavaTablaFiebreHemorragicaBoliviana.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "HANTA VIRUS":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaHantaVirus.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaHantaVirus.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaHantaVirus.setMuestrasProcesadas(octavaTablaHantaVirus.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaHantaVirus.setResultadoPositivo(octavaTablaHantaVirus.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaHantaVirus.setResultadoNegativo(octavaTablaHantaVirus.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaHantaVirus.setMuestrasReferidasPorElLaboratorio(octavaTablaHantaVirus.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "HEPATITIS A":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaHepatitisA.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaHepatitisA.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaHepatitisA.setMuestrasProcesadas(octavaTablaHepatitisA.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaHepatitisA.setResultadoPositivo(octavaTablaHepatitisA.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaHepatitisA.setResultadoNegativo(octavaTablaHepatitisA.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaHepatitisA.setMuestrasReferidasPorElLaboratorio(octavaTablaHepatitisA.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "HEPATITIS C":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaHepatitisC.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaHepatitisC.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaHepatitisC.setMuestrasProcesadas(octavaTablaHepatitisC.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaHepatitisC.setResultadoPositivo(octavaTablaHepatitisC.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaHepatitisC.setResultadoNegativo(octavaTablaHepatitisC.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaHepatitisC.setMuestrasReferidasPorElLaboratorio(octavaTablaHepatitisC.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "LEISHMANIASIS":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaLeishmaniasis.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaLeishmaniasis.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaLeishmaniasis.setMuestrasProcesadas(octavaTablaLeishmaniasis.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaLeishmaniasis.setResultadoPositivo(octavaTablaLeishmaniasis.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaLeishmaniasis.setResultadoNegativo(octavaTablaLeishmaniasis.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            default:
                                break;
                        }
                        break;

                    case "LEPRA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaLepra.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaLepra.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaLepra.setMuestrasProcesadas(octavaTablaLepra.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaLepra.setResultadoPositivo(octavaTablaLepra.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaLepra.setResultadoNegativo(octavaTablaLepra.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaLepra.setMuestrasReferidasPorElLaboratorio(octavaTablaLepra.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "MALARIA MIXTA":
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                            if (resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado() != null) {
                                resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado().forEach((grupoVariable) -> {
                                    if (grupoVariable.getGrupoVariables().getGrupoVariableNombre().equals("HEMOPARASITOS")) {
                                        grupoVariable.getVariablesExamenInformePersonalizado().forEach((variableExamen) -> {
                                            if (variableExamen.getVariableExamenNombre().equals("GOTA GRUESA")) {
                                                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                                    case "TOMADO EN EL LABORATORIO":
                                                    case "REFERIDO AL LABORATORIO": {
                                                        octavaTablaMalariaMixta.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaMixta.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                                        octavaTablaMalariaMixta.setMuestrasProcesadas(octavaTablaMalariaMixta.getMuestrasProcesadas() + 1);

                                                        if (variableExamen.isIsGotaGruesaPositivo()) {
                                                            octavaTablaMalariaMixta.setResultadoPositivo(octavaTablaMalariaMixta.getResultadoPositivo() + 1);
                                                        } else {
                                                            octavaTablaMalariaMixta.setResultadoNegativo(octavaTablaMalariaMixta.getResultadoNegativo() + 1);
                                                        }
                                                    }
                                                    break;

                                                    case "REFERIDO POR EL LABORATORIO":
                                                        octavaTablaMalariaMixta.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaMixta.getMuestrasReferidasPorElLaboratorio() + 1);
                                                        break;

                                                    default:
                                                        break;
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                case "TOMADO EN EL LABORATORIO":
                                case "REFERIDO AL LABORATORIO": {
                                    octavaTablaMalariaMixta.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaMixta.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                    octavaTablaMalariaMixta.setMuestrasProcesadas(octavaTablaMalariaMixta.getMuestrasProcesadas() + 1);

                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                        octavaTablaMalariaMixta.setResultadoPositivo(octavaTablaMalariaMixta.getResultadoPositivo() + 1);
                                    } else {
                                        octavaTablaMalariaMixta.setResultadoNegativo(octavaTablaMalariaMixta.getResultadoNegativo() + 1);
                                    }
                                }
                                break;

                                case "REFERIDO POR EL LABORATORIO":
                                    octavaTablaMalariaMixta.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaMixta.getMuestrasReferidasPorElLaboratorio() + 1);
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;

                    case "MALARIA POR P. FALCIPARUM":
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                            if (resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado() != null) {
                                resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado().forEach((grupoVariable) -> {
                                    if (grupoVariable.getGrupoVariables().getGrupoVariableNombre().equals("HEMOPARASITOS")) {
                                        grupoVariable.getVariablesExamenInformePersonalizado().forEach((variableExamen) -> {
                                            if (variableExamen.getVariableExamenNombre().equals("GOTA GRUESA")) {
                                                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                                    case "TOMADO EN EL LABORATORIO":
                                                    case "REFERIDO AL LABORATORIO": {
                                                        octavaTablaMalariaPorPFalciparum.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaPorPFalciparum.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                                        octavaTablaMalariaPorPFalciparum.setMuestrasProcesadas(octavaTablaMalariaPorPFalciparum.getMuestrasProcesadas() + 1);

                                                        if (variableExamen.isIsGotaGruesaPositivo()) {
                                                            octavaTablaMalariaPorPFalciparum.setResultadoPositivo(octavaTablaMalariaPorPFalciparum.getResultadoPositivo() + 1);
                                                        } else {
                                                            octavaTablaMalariaPorPFalciparum.setResultadoNegativo(octavaTablaMalariaPorPFalciparum.getResultadoNegativo() + 1);
                                                        }
                                                    }
                                                    break;

                                                    case "REFERIDO POR EL LABORATORIO":
                                                        octavaTablaMalariaPorPFalciparum.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaPorPFalciparum.getMuestrasReferidasPorElLaboratorio() + 1);
                                                        break;

                                                    default:
                                                        break;
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                case "TOMADO EN EL LABORATORIO":
                                case "REFERIDO AL LABORATORIO": {
                                    octavaTablaMalariaPorPFalciparum.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaPorPFalciparum.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                    octavaTablaMalariaPorPFalciparum.setMuestrasProcesadas(octavaTablaMalariaPorPFalciparum.getMuestrasProcesadas() + 1);

                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                        octavaTablaMalariaPorPFalciparum.setResultadoPositivo(octavaTablaMalariaPorPFalciparum.getResultadoPositivo() + 1);
                                    } else {
                                        octavaTablaMalariaPorPFalciparum.setResultadoNegativo(octavaTablaMalariaPorPFalciparum.getResultadoNegativo() + 1);
                                    }
                                }
                                break;

                                case "REFERIDO POR EL LABORATORIO":
                                    octavaTablaMalariaPorPFalciparum.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaPorPFalciparum.getMuestrasReferidasPorElLaboratorio() + 1);
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;

                    case "MALARIA POR P. VIVAX":
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                            if (resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado() != null) {
                                resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado().forEach((grupoVariable) -> {
                                    if (grupoVariable.getGrupoVariables().getGrupoVariableNombre().equals("HEMOPARASITOS")) {
                                        grupoVariable.getVariablesExamenInformePersonalizado().forEach((variableExamen) -> {
                                            if (variableExamen.getVariableExamenNombre().equals("GOTA GRUESA")) {
                                                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                                    case "TOMADO EN EL LABORATORIO":
                                                    case "REFERIDO AL LABORATORIO": {
                                                        octavaTablaMalariaPorPVivax.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaPorPVivax.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                                        octavaTablaMalariaPorPVivax.setMuestrasProcesadas(octavaTablaMalariaPorPVivax.getMuestrasProcesadas() + 1);

                                                        if (variableExamen.isIsGotaGruesaPositivo()) {
                                                            octavaTablaMalariaPorPVivax.setResultadoPositivo(octavaTablaMalariaPorPVivax.getResultadoPositivo() + 1);
                                                        } else {
                                                            octavaTablaMalariaPorPVivax.setResultadoNegativo(octavaTablaMalariaPorPVivax.getResultadoNegativo() + 1);
                                                        }
                                                    }
                                                    break;

                                                    case "REFERIDO POR EL LABORATORIO":
                                                        octavaTablaMalariaPorPVivax.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaPorPVivax.getMuestrasReferidasPorElLaboratorio() + 1);
                                                        break;

                                                    default:
                                                        break;
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        } else {
                            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                case "TOMADO EN EL LABORATORIO":
                                case "REFERIDO AL LABORATORIO": {
                                    octavaTablaMalariaPorPVivax.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMalariaPorPVivax.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                    octavaTablaMalariaPorPVivax.setMuestrasProcesadas(octavaTablaMalariaPorPVivax.getMuestrasProcesadas() + 1);

                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                        octavaTablaMalariaPorPVivax.setResultadoPositivo(octavaTablaMalariaPorPVivax.getResultadoPositivo() + 1);
                                    } else {
                                        octavaTablaMalariaPorPVivax.setResultadoNegativo(octavaTablaMalariaPorPVivax.getResultadoNegativo() + 1);
                                    }
                                }
                                break;

                                case "REFERIDO POR EL LABORATORIO":
                                    octavaTablaMalariaPorPVivax.setMuestrasReferidasPorElLaboratorio(octavaTablaMalariaPorPVivax.getMuestrasReferidasPorElLaboratorio() + 1);
                                    break;

                                default:
                                    break;
                            }
                        }
                        break;

                    case "MENINGITIS MENINGOCOCICA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaMeningitisMeningococica.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMeningitisMeningococica.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaMeningitisMeningococica.setMuestrasProcesadas(octavaTablaMeningitisMeningococica.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaMeningitisMeningococica.setResultadoPositivo(octavaTablaMeningitisMeningococica.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaMeningitisMeningococica.setResultadoNegativo(octavaTablaMeningitisMeningococica.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaMeningitisMeningococica.setMuestrasReferidasPorElLaboratorio(octavaTablaMeningitisMeningococica.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "MENINGITIS TUBERCULOSA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaMeningitisTuberculosa.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaMeningitisTuberculosa.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaMeningitisTuberculosa.setMuestrasProcesadas(octavaTablaMeningitisTuberculosa.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaMeningitisTuberculosa.setResultadoPositivo(octavaTablaMeningitisTuberculosa.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaMeningitisTuberculosa.setResultadoNegativo(octavaTablaMeningitisTuberculosa.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaMeningitisTuberculosa.setMuestrasReferidasPorElLaboratorio(octavaTablaMeningitisTuberculosa.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "PESTE":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaPeste.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaPeste.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaPeste.setMuestrasProcesadas(octavaTablaPeste.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaPeste.setResultadoPositivo(octavaTablaPeste.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaPeste.setResultadoNegativo(octavaTablaPeste.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaPeste.setMuestrasReferidasPorElLaboratorio(octavaTablaPeste.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "RABIA EN CANES":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaRabiaEnCanes.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaRabiaEnCanes.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaRabiaEnCanes.setMuestrasProcesadas(octavaTablaRabiaEnCanes.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaRabiaEnCanes.setResultadoPositivo(octavaTablaRabiaEnCanes.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaRabiaEnCanes.setResultadoNegativo(octavaTablaRabiaEnCanes.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaRabiaEnCanes.setMuestrasReferidasPorElLaboratorio(octavaTablaRabiaEnCanes.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "RABIA EN HUMANOS":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaRabiaEnHumanos.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaRabiaEnHumanos.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaRabiaEnHumanos.setMuestrasProcesadas(octavaTablaRabiaEnHumanos.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaRabiaEnHumanos.setResultadoPositivo(octavaTablaRabiaEnHumanos.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaRabiaEnHumanos.setResultadoNegativo(octavaTablaRabiaEnHumanos.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaRabiaEnHumanos.setMuestrasReferidasPorElLaboratorio(octavaTablaRabiaEnHumanos.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "RABIA EN ANIMALES SILVESTRES":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaRabiaEnAnimalesSilvestres.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaRabiaEnAnimalesSilvestres.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaRabiaEnAnimalesSilvestres.setMuestrasProcesadas(octavaTablaRabiaEnAnimalesSilvestres.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaRabiaEnAnimalesSilvestres.setResultadoPositivo(octavaTablaRabiaEnAnimalesSilvestres.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaRabiaEnAnimalesSilvestres.setResultadoNegativo(octavaTablaRabiaEnAnimalesSilvestres.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaRabiaEnAnimalesSilvestres.setMuestrasReferidasPorElLaboratorio(octavaTablaRabiaEnAnimalesSilvestres.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "RUBEOLA":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaRubeola.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaRubeola.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaRubeola.setMuestrasProcesadas(octavaTablaRubeola.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaRubeola.setResultadoPositivo(octavaTablaRubeola.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaRubeola.setResultadoNegativo(octavaTablaRubeola.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaRubeola.setMuestrasReferidasPorElLaboratorio(octavaTablaRubeola.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "SARAMPION":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaSarampion.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaSarampion.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaSarampion.setMuestrasProcesadas(octavaTablaSarampion.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaSarampion.setResultadoPositivo(octavaTablaSarampion.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaSarampion.setResultadoNegativo(octavaTablaSarampion.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaSarampion.setMuestrasReferidasPorElLaboratorio(octavaTablaSarampion.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "LEPTOSPIROSIS":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaLeptospirosis.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaLeptospirosis.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaLeptospirosis.setMuestrasProcesadas(octavaTablaLeptospirosis.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaLeptospirosis.setResultadoPositivo(octavaTablaLeptospirosis.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaLeptospirosis.setResultadoNegativo(octavaTablaLeptospirosis.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaLeptospirosis.setMuestrasReferidasPorElLaboratorio(octavaTablaLeptospirosis.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "ENFERMEDAD TIPO INFLUENZA (ETI) A,B,C":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaEnfermedadTipoInfluenzaETIABC.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaEnfermedadTipoInfluenzaETIABC.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaEnfermedadTipoInfluenzaETIABC.setMuestrasProcesadas(octavaTablaEnfermedadTipoInfluenzaETIABC.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaEnfermedadTipoInfluenzaETIABC.setResultadoPositivo(octavaTablaEnfermedadTipoInfluenzaETIABC.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaEnfermedadTipoInfluenzaETIABC.setResultadoNegativo(octavaTablaEnfermedadTipoInfluenzaETIABC.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaEnfermedadTipoInfluenzaETIABC.setMuestrasReferidasPorElLaboratorio(octavaTablaEnfermedadTipoInfluenzaETIABC.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    case "VIRUS A H1N1":
                        switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                            case "TOMADO EN EL LABORATORIO":
                            case "REFERIDO AL LABORATORIO": {
                                octavaTablaVirusAH1N1.setMuestrasTomadasRecibidasPorElLaboratorio(octavaTablaVirusAH1N1.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                                octavaTablaVirusAH1N1.setMuestrasProcesadas(octavaTablaVirusAH1N1.getMuestrasProcesadas() + 1);

                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().endsWith("POSITIVO")) {
                                    octavaTablaVirusAH1N1.setResultadoPositivo(octavaTablaVirusAH1N1.getResultadoPositivo() + 1);
                                } else {
                                    octavaTablaVirusAH1N1.setResultadoNegativo(octavaTablaVirusAH1N1.getResultadoNegativo() + 1);
                                }
                            }
                            break;

                            case "REFERIDO POR EL LABORATORIO":
                                octavaTablaVirusAH1N1.setMuestrasReferidasPorElLaboratorio(octavaTablaVirusAH1N1.getMuestrasReferidasPorElLaboratorio() + 1);
                                break;

                            default:
                                break;
                        }
                        break;

                    default:
                        break;
                }
            } else {
                switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                    case "MAC ELISA DENGUE":
                    case "MAC ELISA - DENGUE":
                    case "ELISA NS1 DENGUE":
                    case "ELISA NS1 - DENGUE": {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado().equals("REFERIDO POR EL LABORATORIO")) {
                            octavaTablaDengue.setMuestrasReferidasPorElLaboratorio(octavaTablaDengue.getMuestrasReferidasPorElLaboratorio() + 1);
                        }
                    }
                    break;

                    case "CUTANEO":
                    case "MUCOSO":
                    case "VISCERAL": {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado().equals("REFERIDO POR EL LABORATORIO")) {
                            octavaTablaLeishmaniasis.setMuestrasReferidasPorElLaboratorio(octavaTablaLeishmaniasis.getMuestrasReferidasPorElLaboratorio() + 1);
                        }
                    }
                    break;
                }
            }
        });

        resultadosOctavaTabla.add(octavaTablaDengue);
        resultadosOctavaTabla.add(octavaTablaFiebreAmarilla);
        resultadosOctavaTabla.add(octavaTablaFiebreHemorragicaBoliviana);
        resultadosOctavaTabla.add(octavaTablaHantaVirus);
        resultadosOctavaTabla.add(octavaTablaHepatitisA);
        resultadosOctavaTabla.add(octavaTablaHepatitisC);
        resultadosOctavaTabla.add(octavaTablaLeishmaniasis);
        resultadosOctavaTabla.add(octavaTablaLepra);
        resultadosOctavaTabla.add(octavaTablaMalariaMixta);
        resultadosOctavaTabla.add(octavaTablaMalariaPorPFalciparum);
        resultadosOctavaTabla.add(octavaTablaMalariaPorPVivax);
        resultadosOctavaTabla.add(octavaTablaMeningitisMeningococica);
        resultadosOctavaTabla.add(octavaTablaMeningitisTuberculosa);
        resultadosOctavaTabla.add(octavaTablaPeste);
        resultadosOctavaTabla.add(octavaTablaRabiaEnCanes);
        resultadosOctavaTabla.add(octavaTablaRabiaEnHumanos);
        resultadosOctavaTabla.add(octavaTablaRabiaEnAnimalesSilvestres);
        resultadosOctavaTabla.add(octavaTablaRubeola);
        resultadosOctavaTabla.add(octavaTablaSarampion);
        resultadosOctavaTabla.add(octavaTablaLeptospirosis);
        resultadosOctavaTabla.add(octavaTablaEnfermedadTipoInfluenzaETIABC);
        resultadosOctavaTabla.add(octavaTablaVirusAH1N1);

        return resultadosOctavaTabla;
    }

    private List<NovenaTabla> construirNovenaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<NovenaTabla> resultadosNovenaTabla = new ArrayList<>();

        final NovenaTabla novenaTablaFila1 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila2 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila3 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila4 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila5 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila6 = new NovenaTabla(0, 0, 0, 0, 0, 0);
        final NovenaTabla novenaTablaFila7 = new NovenaTabla(0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre().equals("CHAGAS")) {
                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila1.setSerologiaConfirmada(novenaTablaFila1.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila1.setParasitologiaPositivo(novenaTablaFila1.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila1.setParasitologiaNegativo(novenaTablaFila1.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila1.setSerologiaPositivo(novenaTablaFila1.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila1.setSerologiaNegativo(novenaTablaFila1.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() > 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 12 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila2.setSerologiaConfirmada(novenaTablaFila2.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila2.setParasitologiaPositivo(novenaTablaFila2.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila2.setParasitologiaNegativo(novenaTablaFila2.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila2.setSerologiaPositivo(novenaTablaFila2.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila2.setSerologiaNegativo(novenaTablaFila2.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 1 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila3.setSerologiaConfirmada(novenaTablaFila3.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila3.setParasitologiaPositivo(novenaTablaFila3.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila3.setParasitologiaNegativo(novenaTablaFila3.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila3.setSerologiaPositivo(novenaTablaFila3.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila3.setSerologiaNegativo(novenaTablaFila3.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila4.setSerologiaConfirmada(novenaTablaFila4.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila4.setParasitologiaPositivo(novenaTablaFila4.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila4.setParasitologiaNegativo(novenaTablaFila4.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila4.setSerologiaPositivo(novenaTablaFila4.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila4.setSerologiaNegativo(novenaTablaFila4.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() > 15) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila5.setSerologiaConfirmada(novenaTablaFila5.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila5.setParasitologiaPositivo(novenaTablaFila5.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila5.setParasitologiaNegativo(novenaTablaFila5.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila5.setSerologiaPositivo(novenaTablaFila5.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila5.setSerologiaNegativo(novenaTablaFila5.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerEmbarazada()) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila6.setSerologiaConfirmada(novenaTablaFila6.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila6.setParasitologiaPositivo(novenaTablaFila6.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila6.setParasitologiaNegativo(novenaTablaFila6.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila6.setSerologiaPositivo(novenaTablaFila6.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila6.setSerologiaNegativo(novenaTablaFila6.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                } else if ((resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto()) || (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() || resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto())) {
                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HAI ELISA CHAGAS")) {
                        if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                            novenaTablaFila7.setSerologiaConfirmada(novenaTablaFila7.getSerologiaConfirmada() + 1);
                        }
                    } else {
                        resultadoGeneralReportePersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
                            if (tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("METODO PARASITOLOGICO") || tecnicaAplicada.getTecnica().getTecnicaMetodo().equals("PARASITOLOGICO")) {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila7.setParasitologiaPositivo(novenaTablaFila7.getParasitologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila7.setParasitologiaNegativo(novenaTablaFila7.getParasitologiaNegativo() + 1);
                                }
                            } else {
                                if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado() != null && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre().equals("POSITIVO")) {
                                    novenaTablaFila7.setSerologiaPositivo(novenaTablaFila7.getSerologiaPositivo() + 1);
                                } else {
                                    novenaTablaFila7.setSerologiaNegativo(novenaTablaFila7.getSerologiaNegativo() + 1);
                                }
                            }
                        });
                    }
                }
            }

            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                if (resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado() != null) {
                    resultadoGeneralReportePersonalizado.getGrupoVariablesInformePersonalizado().forEach((grupoVariable) -> {
                        if (grupoVariable.getGrupoVariables().getGrupoVariableNombre().equals("HEMOPARASITOS")) {
                            grupoVariable.getVariablesExamenInformePersonalizado().forEach((variableExamen) -> {
                                if (variableExamen.getVariableExamenNombre().equals("MICROMETODO CHAGAS")) {
                                    if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila1.setParasitologiaPositivo(novenaTablaFila1.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila1.setParasitologiaNegativo(novenaTablaFila1.getParasitologiaNegativo() + 1);
                                        }
                                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() > 6 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() < 12 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila2.setParasitologiaPositivo(novenaTablaFila2.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila2.setParasitologiaNegativo(novenaTablaFila2.getParasitologiaNegativo() + 1);
                                        }
                                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 1 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila3.setParasitologiaPositivo(novenaTablaFila3.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila3.setParasitologiaNegativo(novenaTablaFila3.getParasitologiaNegativo() + 1);
                                        }
                                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila4.setParasitologiaPositivo(novenaTablaFila4.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila4.setParasitologiaNegativo(novenaTablaFila4.getParasitologiaNegativo() + 1);
                                        }
                                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() > 15) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila5.setParasitologiaPositivo(novenaTablaFila5.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila5.setParasitologiaNegativo(novenaTablaFila5.getParasitologiaNegativo() + 1);
                                        }
                                    } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerEmbarazada()) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila6.setParasitologiaPositivo(novenaTablaFila6.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila6.setParasitologiaNegativo(novenaTablaFila6.getParasitologiaNegativo() + 1);
                                        }
                                    } else if ((resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto()) || (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerParto() || resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().isMujerPostParto())) {
                                        if (variableExamen.isIsMicroMetodoChagasPositivo()) {
                                            novenaTablaFila7.setParasitologiaPositivo(novenaTablaFila7.getParasitologiaPositivo() + 1);
                                        } else {
                                            novenaTablaFila7.setParasitologiaNegativo(novenaTablaFila7.getParasitologiaNegativo() + 1);
                                        }
                                    }
                                }
                            });
                        }
                    });
                }
            }

        });

        resultadosNovenaTabla.add(novenaTablaFila1);
        resultadosNovenaTabla.add(novenaTablaFila2);
        resultadosNovenaTabla.add(novenaTablaFila3);
        resultadosNovenaTabla.add(novenaTablaFila4);
        resultadosNovenaTabla.add(novenaTablaFila5);
        resultadosNovenaTabla.add(novenaTablaFila6);
        resultadosNovenaTabla.add(novenaTablaFila7);

        return resultadosNovenaTabla;
    }

    private List<DecimaTabla> construirDecimaTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<DecimaTabla> resultadosDecimaTabla = new ArrayList<>();

        final DecimaTabla decimaTablaFila1 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila2 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila3 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila4 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila5 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila6 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila7 = new DecimaTabla(0, 0, 0, 0, 0, 0);
        final DecimaTabla decimaTablaFila8 = new DecimaTabla(0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((ResultadoGeneralReportePersonalizado resultadoGeneralReportePersonalizado) -> {
            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                case "COPROPARASITOLOGICO SIMPLE":
                    switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                        case "TOMADO EN EL LABORATORIO":
                        case "REFERIDO AL LABORATORIO": {
                            decimaTablaFila1.setMuestrasTomadasRecibidasPorElLaboratorio(decimaTablaFila1.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);
                            decimaTablaFila2.setMuestrasTomadasRecibidasPorElLaboratorio(decimaTablaFila2.getMuestrasTomadasRecibidasPorElLaboratorio() + 1);

                            if (resultadoGeneralReportePersonalizado.getParasitosEncontrados() != null && !resultadoGeneralReportePersonalizado.getParasitosEncontrados().isEmpty()) {
                                resultadoGeneralReportePersonalizado.getParasitosEncontrados().forEach((parasitoEncontrado) -> {
                                    switch (parasitoEncontrado.getParasito().getParasitoNombre()) {
                                        case "ENTAMOEBA HISTOLITICA":
                                            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                                                decimaTablaFila1.setCasosPositivosMenor5(decimaTablaFila1.getCasosPositivosMenor5() + 1);
                                            } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                                                decimaTablaFila1.setCasosPositivos5A15(decimaTablaFila1.getCasosPositivos5A15() + 1);
                                            } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 15) {
                                                decimaTablaFila1.setCasosPositivosMayorA15(decimaTablaFila1.getCasosPositivosMayorA15() + 1);
                                            }
                                            break;

                                        case "GIARDIA LAMBLIA":
                                            if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 5) {
                                                decimaTablaFila2.setCasosPositivosMenor5(decimaTablaFila2.getCasosPositivosMenor5() + 1);
                                            } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 5 && resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() < 15) {
                                                decimaTablaFila2.setCasosPositivos5A15(decimaTablaFila2.getCasosPositivos5A15() + 1);
                                            } else if (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() >= 15) {
                                                decimaTablaFila2.setCasosPositivosMayorA15(decimaTablaFila2.getCasosPositivosMayorA15() + 1);
                                            }
                                            break;
                                    }
                                });
                            }
                        }
                        break;

                        case "REFERIDO POR EL LABORATORIO":
                            decimaTablaFila1.setMuestrasReferidasPorElLaboratorio(decimaTablaFila1.getMuestrasReferidasPorElLaboratorio() + 1);
                            break;
                    }
                    decimaTablaFila1.setMuestrasProcesadas(decimaTablaFila1.getMuestrasTomadasRecibidasPorElLaboratorio());
                    decimaTablaFila2.setMuestrasProcesadas(decimaTablaFila2.getMuestrasTomadasRecibidasPorElLaboratorio());
                    break;
            }
        });

        resultadosDecimaTabla.add(decimaTablaFila1);
        resultadosDecimaTabla.add(decimaTablaFila2);
        resultadosDecimaTabla.add(decimaTablaFila3);
        resultadosDecimaTabla.add(decimaTablaFila4);
        resultadosDecimaTabla.add(decimaTablaFila5);
        resultadosDecimaTabla.add(decimaTablaFila6);
        resultadosDecimaTabla.add(decimaTablaFila7);
        resultadosDecimaTabla.add(decimaTablaFila8);
        return resultadosDecimaTabla;
    }

    private List<DecimaPrimeraTabla> construirDecimaPrimeraTabla(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        final List<DecimaPrimeraTabla> resultadosDecimaPrimeraTabla = new ArrayList<>();

        final DecimaPrimeraTabla decimaPrimeraTablaFila1 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila2 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila3 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila4 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila5 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila6 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila7 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila8 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);
        final DecimaPrimeraTabla decimaPrimeraTablaFila9 = new DecimaPrimeraTabla(0, 0, 0, 0, 0, 0, 0);

        resultadosGeneralesReportePersonalizado.forEach((resultadoGeneralReportePersonalizado) -> {
            if (resultadoGeneralReportePersonalizado.getParasitosEncontrados() != null && !resultadoGeneralReportePersonalizado.getParasitosEncontrados().isEmpty()) {
                resultadoGeneralReportePersonalizado.getParasitosEncontrados().forEach((parasitoEncontrado) -> {
                    switch (parasitoEncontrado.getParasito().getParasitoNombre()) {
                        case "VIRUS HEPATITIS B":
                            switch (resultadoGeneralReportePersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado()) {
                                case "TOMADO EN EL LABORATORIO":
                                case "REFERIDO AL LABORATORIO": {

                                }
                                break;

                                case "REFERIDO POR EL LABORATORIO":

                                    break;
                            }
                            break;

                        case "TRICHOMONAS VAGINALIS":
                            break;

                        case "NEISSERIA GONORRHOEAE":
                            break;

                        case "CHLAMYDIA TRACHOMATIS":
                            break;

                        case "TREPONEMA PALLIDUM":
                            break;

                        case "TREPONEMA PALLIDUM (CONGENITO)":
                            break;

                        case "HAEMOPHILUS DUCREY (CHANCROIDE)":
                            break;

                        case "VIRUS HERPES SIMPLEX (VSH)":
                            break;

                        case "VIH":
                            break;
                    }
                });
            }
        });

        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila1);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila2);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila3);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila4);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila5);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila6);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila7);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila8);
        resultadosDecimaPrimeraTabla.add(decimaPrimeraTablaFila9);

        return resultadosDecimaPrimeraTabla;
    }

    @Override
    public void informeMensualGenerado(final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado) {
        try {
            final List<PrimeraTabla> resultadosPrimeraTabla = construirPrimeraTabla(resultadosGeneralesReportePersonalizado);
            final List<SegundaTabla> resultadosSegundaTabla = construirSegundaTabla(resultadosGeneralesReportePersonalizado);
            final List<TerceraTabla> resultadosTerceraTabla = construirTerceraTabla(resultadosGeneralesReportePersonalizado);
            final List<CuartaTabla> resultadosCuartaTabla = construirCuartaTabla(resultadosGeneralesReportePersonalizado);
            final List<QuintaTabla> resultadosQuintaTabla = construirQuintaTabla(resultadosGeneralesReportePersonalizado);
            final List<SextaTabla> resultadosSextaTabla = construirSextaTabla(resultadosGeneralesReportePersonalizado);
            final List<SeptimaTabla> resultadosSeptimaTabla = construirSeptimaTabla(resultadosGeneralesReportePersonalizado);
            final List<OctavaTabla> resultadosOctavaTabla = construirOctavaTabla(resultadosGeneralesReportePersonalizado);
            final List<NovenaTabla> resultadosNovenaTabla = construirNovenaTabla(resultadosGeneralesReportePersonalizado);
            final List<DecimaTabla> resultadosDecimaTabla = construirDecimaTabla(resultadosGeneralesReportePersonalizado);
            final List<DecimaPrimeraTabla> resultadosDecimaPrimeraTabla = construirDecimaPrimeraTabla(resultadosGeneralesReportePersonalizado);
            final JRBeanCollectionDataSource dataSourcePrimeraTabla = new JRBeanCollectionDataSource(resultadosPrimeraTabla);
            final JRBeanCollectionDataSource dataSourceSegundaTabla = new JRBeanCollectionDataSource(resultadosSegundaTabla);
            final JRBeanCollectionDataSource dataSourceTerceraTabla = new JRBeanCollectionDataSource(resultadosTerceraTabla);
            final JRBeanCollectionDataSource dataSourceCuartaTabla = new JRBeanCollectionDataSource(resultadosCuartaTabla);
            final JRBeanCollectionDataSource dataSourceQuintaTabla = new JRBeanCollectionDataSource(resultadosQuintaTabla);
            final JRBeanCollectionDataSource dataSourceSextaTabla = new JRBeanCollectionDataSource(resultadosSextaTabla);
            final JRBeanCollectionDataSource dataSourceSeptimaTabla = new JRBeanCollectionDataSource(resultadosSeptimaTabla);
            final JRBeanCollectionDataSource dataSourceOctavaTabla = new JRBeanCollectionDataSource(resultadosOctavaTabla);
            final JRBeanCollectionDataSource dataSourceNovenaTabla = new JRBeanCollectionDataSource(resultadosNovenaTabla);
            final JRBeanCollectionDataSource dataSourceDecimaTabla = new JRBeanCollectionDataSource(resultadosDecimaTabla);
            final JRBeanCollectionDataSource dataSourceDecimaPrimeraTabla = new JRBeanCollectionDataSource(resultadosDecimaPrimeraTabla);
            final Map<String, Object> parameters = new HashMap<>();
            final int month = JCMBXMes.getSelectedIndex();
            final int year = Integer.valueOf(JTXTFYear.getText());
            parameters.put("ESCUDO_BOLIVIA", getClass().getResourceAsStream("/View/icons/logo_escudo_bolivia.jpg"));
            switch (month) {
                case 0:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "ENERO");
                    break;

                case 1:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "FEBRERO");
                    break;

                case 2:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "MARZO");
                    break;

                case 3:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "ABRIL");
                    break;

                case 4:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "MAYO");
                    break;

                case 5:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "JUNIO");
                    break;

                case 6:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "JULIO");
                    break;

                case 7:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "AGOSTO");
                    break;

                case 8:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "SEPTIEMBRE");
                    break;

                case 9:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "OCTUBRE");
                    break;

                case 10:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "NOVIEMBRE");
                    break;

                default:
                    parameters.put("MES_INFORME_MENSUAL_LABORATORIO", "DICIEMBRE");
                    break;
            }
            parameters.put("YEAR_INFORME_MENSUAL_LABORATORIO", String.valueOf(year));
            parameters.put("PRIMERA_TABLA", dataSourcePrimeraTabla);
            parameters.put("SEGUNDA_TABLA", dataSourceSegundaTabla);
            parameters.put("TERCERA_TABLA", dataSourceTerceraTabla);
            parameters.put("CUARTA_TABLA", dataSourceCuartaTabla);
            parameters.put("QUINTA_TABLA", dataSourceQuintaTabla);
            parameters.put("SEXTA_TABLA", dataSourceSextaTabla);
            parameters.put("SEPTIMA_TABLA", dataSourceSeptimaTabla);
            parameters.put("OCTAVA_TABLA", dataSourceOctavaTabla);
            parameters.put("NOVENA_TABLA", dataSourceNovenaTabla);
            parameters.put("DECIMA_TABLA", dataSourceDecimaTabla);
            parameters.put("DECIMA_PRIMERA_TABLA", dataSourceDecimaPrimeraTabla);
            parameters.put("ADMINISTRADOR", personalTecnico.getPersona().getPersonaNombre() + " " + personalTecnico.getPersona().getPersonaApellido());

            final JasperReport jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("InformeMensualLaboratorio.jrxml"));
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jasperViewer.setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
            jasperViewer.setTitle("SIET - Sistema de Información de Enfermedades Tropicales.");
            jasperViewer.setVisible(true);
        } catch (final JRException jRException) {
            Logger.getLogger(InformeMensualLaboratorio.class.getName()).log(Level.SEVERE, null, jRException);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void informeMensualVacio(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void errorGenerarInformeMensualLaboratorio(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoGenerarInformeMensualLaboratorio(final String msg) {
        JOptionPane.showMessageDialog(rootPane, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
