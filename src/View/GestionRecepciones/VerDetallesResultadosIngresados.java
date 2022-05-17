package View.GestionRecepciones;

import Model.POJO.ParasitoEncontrado;
import Model.POJO.Reportes.ResultadoExamen.TablaParametros;
import Model.POJO.Reportes.ResultadoExamen.TablaParasitaria;
import Model.POJO.Reportes.ResultadoExamen.TablaResultadoBaciloscopia;
import Model.POJO.ResultadoVariable;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelParasitosEncontrados;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelResultadosVariables;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelTecnicasAplicadas;
import java.awt.HeadlessException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
public class VerDetallesResultadosIngresados extends javax.swing.JDialog {

    private final TableModelResultadosVariables tableModelResultadosVariables;
    private final TableModelParasitosEncontrados tableModelParasitosEncontrados;
    private final TableModelTecnicasAplicadas tableModelTecnicasAplicadas;

    private ResultadoGeneralPersonalizado resultadoGeneralPersonalizado;

    public VerDetallesResultadosIngresados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        tableModelResultadosVariables = new TableModelResultadosVariables(false);
        tableModelParasitosEncontrados = new TableModelParasitosEncontrados();
        tableModelTecnicasAplicadas = new TableModelTecnicasAplicadas();

        initComponents();
    }

    public void setResultadoGeneralPersonalizado(ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        this.resultadoGeneralPersonalizado = resultadoGeneralPersonalizado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPOPUPMENUItemResultadosIngresados = new javax.swing.JPopupMenu();
        JMENUITEMVerResultados = new javax.swing.JMenuItem();
        JMENUITEMModificarResultados = new javax.swing.JMenuItem();
        JTABBEDPANEResultadosSeguimientoPaciente = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        JLBLExamenSolicitado = new javax.swing.JLabel();
        JLBLMuestraBiologica = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        JLBLEstadoMuestraBiologica = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JLBLAspectoMuestra = new javax.swing.JLabel();
        JLBLNumeroMuestraBiologica = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        JLBLResponsableIntroduccionResultados = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JLBLResponsableAnalisis = new javax.swing.JLabel();
        JLBLFechaFinalAnalisis = new javax.swing.JLabel();
        JLBLHoraFinalAnalisis = new javax.swing.JLabel();
        JLBLIncorporarASeguimiento = new javax.swing.JLabel();
        JPANELSeguimientoPaciente = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        JLBLPacienteEnSeguimiento = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLBLFechaInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JLBLBaciloscopiaControl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLBLHoraInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLResultadosExamen = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBLParasitosMuestraBiologica = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTBLTecnicas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTXTAREAObservaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTXTAREARecomendaciones = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        JLBLResultadoFinal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JLBLEnfermedad = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JLBLFechaTomaMuestra = new javax.swing.JLabel();
        JBTNCerrar = new javax.swing.JButton();
        JBTNImprimir = new javax.swing.JButton();

        JMENUITEMVerResultados.setText("VerResultados");
        JPOPUPMENUItemResultadosIngresados.add(JMENUITEMVerResultados);

        JMENUITEMModificarResultados.setText("Modificar Resultados");
        JPOPUPMENUItemResultadosIngresados.add(JMENUITEMModificarResultados);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ver Resultados Ingresados");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Exámen Solicitado"));

        JLBLExamenSolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLMuestraBiologica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel39.setText("EXAMEN SOLICITADO:");
        jLabel39.setToolTipText("HISTORIAL CLINICO");

        jLabel40.setText("MUESTRA BIOLOGICA:");

        jLabel41.setText("ASPECTO DE LA MUESTRA:");

        jLabel42.setText("ESTADO DE LA MUESTRA:");

        JLBLEstadoMuestraBiologica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Nº MUESTRA BIOLOGICA:");

        JLBLAspectoMuestra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLNumeroMuestraBiologica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLBLEstadoMuestraBiologica, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLMuestraBiologica, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLExamenSolicitado, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLAspectoMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLNumeroMuestraBiologica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(JLBLExamenSolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JLBLMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLNumeroMuestraBiologica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLAspectoMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEstadoMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Análisis"));

        jLabel26.setText("RESPONSABLE DE ANALISIS:");

        jLabel28.setText("RESULTADOS INGRESADOS POR:");

        JLBLResponsableIntroduccionResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setText("FECHA FINAL DE ANALISIS:");

        jLabel32.setText("HORA FINAL DE ANALISIS:");

        jLabel5.setText("¿INCORPORAR A SEGUIMIENTO?");

        JLBLResponsableAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLFechaFinalAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLHoraFinalAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLIncorporarASeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLResponsableAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLFechaFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLHoraFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLIncorporarASeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLResponsableAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLFechaFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLHoraFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLIncorporarASeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Resultados Generales", jPanel1);

        jLabel6.setText("PACIENTE EN SEGUIMIENTO:");

        JLBLPacienteEnSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("FECHA INICIO DE SEGUIMIENTO:");

        JLBLFechaInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("BACILOSCOPIA DE CONTROL:");

        JLBLBaciloscopiaControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("HORA INICIO DE SEGUIMIENTO:");

        JLBLHoraInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("DETALLES U OBSERVACIONES REGISTRADAS AL INICIO DEL SEGUIMIENTO:");

        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setColumns(20);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setLineWrap(true);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setRows(5);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setEnabled(false);
        jScrollPane5.setViewportView(JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento);

        javax.swing.GroupLayout JPANELSeguimientoPacienteLayout = new javax.swing.GroupLayout(JPANELSeguimientoPaciente);
        JPANELSeguimientoPaciente.setLayout(JPANELSeguimientoPacienteLayout);
        JPANELSeguimientoPacienteLayout.setHorizontalGroup(
            JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLPacienteEnSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBLFechaInicioDeSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                                .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(0, 322, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(JLBLHoraInicioDeSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(JLBLBaciloscopiaControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        JPANELSeguimientoPacienteLayout.setVerticalGroup(
            JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPANELSeguimientoPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLPacienteEnSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLFechaInicioDeSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLBaciloscopiaControl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLHoraInicioDeSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimientos del Paciente", JPANELSeguimientoPaciente);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de Análisis"));

        JTBLResultadosExamen.setModel(tableModelResultadosVariables);
        JTBLResultadosExamen.setRowHeight(20);
        JTBLResultadosExamen.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLResultadosExamen.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
        JTBLResultadosExamen.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);

        JTBLResultadosExamen.getColumnModel().getColumn(0).setPreferredWidth(20);
        JTBLResultadosExamen.getColumnModel().getColumn(1).setPreferredWidth(250);
        JTBLResultadosExamen.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLResultadosExamen.getColumnModel().getColumn(3).setPreferredWidth(150);
        JTBLResultadosExamen.getColumnModel().getColumn(4).setPreferredWidth(150);
        jScrollPane1.setViewportView(JTBLResultadosExamen);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Variables de Exámen", jPanel5);

        JTBLParasitosMuestraBiologica.setModel(tableModelParasitosEncontrados);
        JTBLParasitosMuestraBiologica.setRowHeight(20);
        JTBLParasitosMuestraBiologica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(1).setPreferredWidth(800);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(2).setPreferredWidth(150);
        jScrollPane2.setViewportView(JTBLParasitosMuestraBiologica);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Parásitos de Muestra Biológica", jPanel6);

        JTBLTecnicas.setModel(tableModelTecnicasAplicadas);
        JTBLTecnicas.setRowHeight(20);
        JTBLTecnicas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLTecnicas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLTecnicas.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLTecnicas.getColumnModel().getColumn(1).setPreferredWidth(600);
        JTBLTecnicas.getColumnModel().getColumn(2).setPreferredWidth(150);
        jScrollPane3.setViewportView(JTBLTecnicas);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Técnicas/Métodos", jPanel7);

        jLabel7.setText("OBSERVACIONES:");

        JTXTAREAObservaciones.setColumns(20);
        JTXTAREAObservaciones.setLineWrap(true);
        JTXTAREAObservaciones.setRows(5);
        JTXTAREAObservaciones.setEditable(false);
        JTXTAREARecomendaciones.setEditable(false);
        jScrollPane6.setViewportView(JTXTAREAObservaciones);

        jLabel9.setText("RECOMENDACIONES:");

        JTXTAREARecomendaciones.setColumns(20);
        JTXTAREARecomendaciones.setLineWrap(true);
        JTXTAREARecomendaciones.setRows(5);
        jScrollPane7.setViewportView(JTXTAREARecomendaciones);

        jLabel11.setText("RESULTADO O INTERPRETACION:");

        JLBLResultadoFinal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ENFERMEDAD:");

        JLBLEnfermedad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("FECHA DE TOMA DE MUESTRA");

        JLBLFechaTomaMuestra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JLBLFechaTomaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(JLBLEnfermedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLBLResultadoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBLResultadoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLEnfermedad, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLFechaTomaMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Observaciones/Recomendaciones/Resultado o Interpretación", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCerrar.setText("CERRAR");
        JBTNCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCerrarActionPerformed(evt);
            }
        });

        JBTNImprimir.setText("IMPRIMIR");
        JBTNImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTABBEDPANEResultadosSeguimientoPaciente)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCerrar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNImprimir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTABBEDPANEResultadosSeguimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCerrar)
                    .addComponent(JBTNImprimir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (resultadoGeneralPersonalizado == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();
            } else {
                JLBLExamenSolicitado.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre());
                JLBLMuestraBiologica.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo());
                JLBLNumeroMuestraBiologica.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica());
                JLBLAspectoMuestra.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto() == null ? "" : resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto().getAspectoCalidad());
                JLBLEstadoMuestraBiologica.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado());
                JLBLResponsableAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaNombre());
                JLBLResponsableIntroduccionResultados.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaNombre());
                JLBLFechaFinalAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getFechaFinal().toString());
                JLBLHoraFinalAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getHoraFinal().toString());

                if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null) {
                    JTABBEDPANEResultadosSeguimientoPaciente.removeTabAt(1);
                    JLBLIncorporarASeguimiento.setText("NO");
                } else {
                    JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimiento del Paciente", JPANELSeguimientoPaciente);
                    JLBLPacienteEnSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaNombre());
                    JLBLBaciloscopiaControl.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenControl());
                    JLBLFechaInicioDeSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getFechaInicio().toString());
                    JLBLHoraInicioDeSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getHoraInicio().toString());
                    JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getDetallesObservacionesInicio());
                    JLBLIncorporarASeguimiento.setText("SI");
                }

                tableModelResultadosVariables.setResultadosVariables(resultadoGeneralPersonalizado.getResultadosVariables());
                JTBLResultadosExamen.getTableHeader().setReorderingAllowed(false);

                tableModelParasitosEncontrados.setParasitosEncontrados(resultadoGeneralPersonalizado.getParasitosEncontrados());
                JTBLParasitosMuestraBiologica.getTableHeader().setReorderingAllowed(false);

                tableModelTecnicasAplicadas.setTecnicasAplicadas(resultadoGeneralPersonalizado.getTecnicasAplicadas());
                JTBLTecnicas.getTableHeader().setReorderingAllowed(false);

                JTXTAREAObservaciones.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                JTXTAREARecomendaciones.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones());
                JLBLFechaTomaMuestra.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra().toString());
                JLBLEnfermedad.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad() == null ? "" : resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad().getEnfermedadNombre());
                JLBLResultadoFinal.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado() == null ? "" : resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre());
            }
        } catch (final HeadlessException ex) {
            System.err.println("Se produjo un error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Se produjo un error desconocido. Vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCerrarActionPerformed

    private void JBTNImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNImprimirActionPerformed
        try {
            final Map<String, Object> parameters = new HashMap<>();
            JasperReport jasperReport;
            parameters.put("ESTABLECIMIENTO_SOLICITANTE", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEstablecimiento().getEstablecimientoNombre());
            parameters.put("PACIENTE", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaNombre() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaApellido());

            final String edad;

            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() == 0) {
                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias() == 0) {
                        edad = "R.N";
                    } else {
                        edad = resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias() + " Días";
                    }
                } else {
                    edad = resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() + " Meses";
                }
            } else {
                edad = resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() + " Años";
            }
            parameters.put("EDAD", edad);

            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                case "BACILOSCOPIA":
                    parameters.put("LOGO_MINISTERIO_SALUD", getClass().getResourceAsStream("/View/icons/logo_ministerio_salud.png"));
                    parameters.put("MEDICO_SOLICITANTE", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getSolicitante());
                    parameters.put("FECHA_RECOLECCION_PRIMERA_MUESTRA", resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica().equals("1ra. Muestra") ? resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra() : resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra());

                    final List<TablaResultadoBaciloscopia> tablaResultadoBaciloscopia = new ArrayList<>();

                    final Date fechaProceso = resultadoGeneralPersonalizado.getResultadoGeneral().getFechaFinal();
                    final Date fechaRecepcionMuestra = resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra();
                    final String calidadMuestra = resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto().getAspectoCalidad();

                    for (int i = 0; i < 3; i++) {
                        if (resultadoGeneralPersonalizado.getResultadosVariables().get(0).getVariableExamen().getVariableExamenNombre().equals("RESULTADO")) {
                            switch (i) {
                                case 0:
                                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null && resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica().equals("1ra. Muestra")) {
                                        switch (resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable()) {
                                            case "NEGATIVO":
                                            case "negativo": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Primera", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "NEGATIVO", "", "", "", ""));
                                            }

                                            break;

                                            case "POSITIVO +":
                                            case "positivo +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Primera", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "POSITIVO +", "", ""));
                                            }

                                            break;

                                            case "POSITIVO ++":
                                            case "POSITIVO + +":
                                            case "positivo ++":
                                            case "positivo + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Primera", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "", "POSITIVO ++", ""));
                                            }
                                            break;

                                            case "POSITIVO +++":
                                            case "POSITIVO + + +":
                                            case "positivo +++":
                                            case "positivo + + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Primera", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "", "", "POSITIVO +++"));
                                            }
                                            break;

                                            default:
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Primera", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable(), "", "", ""));
                                                break;
                                        }
                                    } else {
                                        tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "Primera", null, null, null, null, null, null, null, null));
                                    }
                                    break;

                                case 1:
                                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null && resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica().equals("2da. Muestra")) {
                                        switch (resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable()) {
                                            case "NEGATIVO":
                                            case "negativo": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Segunda", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "NEGATIVO", "", "", "", ""));
                                            }
                                            break;

                                            case "POSITIVO +":
                                            case "positivo +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Segunda", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "POSITIVO +", "", ""));
                                            }
                                            break;

                                            case "POSITIVO ++":
                                            case "POSITIVO + +":
                                            case "positivo ++":
                                            case "positivo + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Segunda", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "POSITIVO ++", "", ""));
                                            }
                                            break;

                                            case "POSITIVO +++":
                                            case "POSITIVO + + +":
                                            case "positivo +++":
                                            case "positivo + + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Segunda", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "POSITIVO +++", "", ""));
                                            }
                                            break;

                                            default:
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Segunda", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable(), "", "", ""));
                                                break;
                                        }
                                    } else {
                                        tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "Segunda", null, null, null, null, null, null, null, null));
                                    }
                                    break;

                                default:
                                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() != null) {
                                        switch (resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable()) {
                                            case "NEGATIVO":
                                            case "negativo": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Control", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "NEGATIVO", "", "", "", ""));
                                            }
                                            break;

                                            case "POSITIVO +":
                                            case "positivo +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Control", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "POSITIVO +", "", ""));
                                            }
                                            break;

                                            case "POSITIVO ++":
                                            case "POSITIVO + +":
                                            case "positivo ++":
                                            case "positivo + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Control", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "", "POSITIVO ++", ""));
                                            }
                                            break;

                                            case "POSITIVO +++":
                                            case "POSITIVO + + +":
                                            case "positivo +++":
                                            case "positivo + + +": {
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Control", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", "", "", "", "POSITIVO +++"));
                                            }
                                            break;

                                            default:
                                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(fechaProceso, "Control", fechaRecepcionMuestra, fechaProceso, calidadMuestra, "", resultadoGeneralPersonalizado.getResultadosVariables().get(0).getResultadoVariable(), "", "", ""));
                                                break;
                                        }
                                        break;
                                    } else {
                                        tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "Control", null, null, null, null, null, null, null, null));
                                    }
                                    break;
                            }
                        }
                    }

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null) {
                        tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "Mes de control de tratamiento", null, null, null, null, null, null, null, null));
                    } else {
                        switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenControl()) {
                            case "Fin de 1ra. Fase":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "1er Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 3er. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "3er Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 4to. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "4to Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 5to. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "5to Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 6to. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "6to Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 7mo. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "7mo Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            case "Al final del 8vo. Mes":
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "8vo Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;

                            default:
                                tablaResultadoBaciloscopia.add(new TablaResultadoBaciloscopia(null, "Otro Mes de control de tratamiento", fechaRecepcionMuestra, fechaProceso, calidadMuestra, null, null, null, null, null));
                                break;
                        }
                    }

                    final JRBeanCollectionDataSource dataSourceTablaResultadoBaciloscopia = new JRBeanCollectionDataSource(tablaResultadoBaciloscopia);
                    parameters.put("TABLA_RESULTADO_BACILOSCOPIA", dataSourceTablaResultadoBaciloscopia);
                    parameters.put("OBSERVACIONES", resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                    parameters.put("RESPONSABLE_DE_ANALISIS", resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaNombre() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaApellido());

                    jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("ResultadoBaciloscopia.jrxml"));

                    break;
                    
                case "CULTIVO":
                    parameters.put("LOGO_MINISTERIO_SALUD", getClass().getResourceAsStream("/View/icons/logo_ministerio_salud.png"));
                    parameters.put("MEDICO_SOLICITANTE", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getSolicitante());
                    parameters.put("OBSERVACIONES", resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                    parameters.put("RESPONSABLE_DE_ANALISIS", resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaNombre() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaApellido());
                    
                    jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("ResultadoCultivo.jrxml"));
                    
                    break;

                case "CUTANEO":
                case "MUCOSO":
                case "VISCERAL": {
                    parameters.put("LOGO_MINISTERIO_SALUD", getClass().getResourceAsStream("/View/icons/logo_ministerio_salud.png"));
                    parameters.put("LOGO_BERMEJO", getClass().getResourceAsStream("/View/icons/logo_bermejo.png"));
                    parameters.put("SEXO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaSexo());

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                        if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() == 0) {
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias() == 0) {
                                parameters.put("EDAD", "R.N");
                            } else {
                                parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias()) + " DIAS");
                            }
                        } else {
                            parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses()) + " MESES");
                        }
                    } else {
                        parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears()) + " AÑOS");
                    }

                    parameters.put("MEDICO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getSolicitante());

                    resultadoGeneralPersonalizado.getResultadosVariables().forEach((resultadoVariable) -> {
                        switch (resultadoVariable.getVariableExamen().getVariableExamenNombre()) {
                            case "CUALITATIVO":
                                parameters.put("CUALITATIVO", resultadoVariable.getResultadoVariable());
                                break;

                            case "SEMICUANTITATIVO":
                                parameters.put("SEMICUANTITATIVO", resultadoVariable.getResultadoVariable());
                                break;

                            default:
                                break;
                        }
                    });

                    parameters.put("OBSERVACIONES", resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                }
                jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("ResultadoLeishmaniasis.jrxml"));
                break;

                default:
                    parameters.put("LOGO_CERETROP", getClass().getResourceAsStream("/View/icons/logo_ceretrop.png"));
                    parameters.put("LOGO_CERETROP_DETALLES", getClass().getResourceAsStream("/View/icons/logo_ceretrop_opacity.png"));
                    parameters.put("LOGO_BERMEJO", getClass().getResourceAsStream("/View/icons/logo_bermejo.png"));
                    parameters.put("CEDULA_IDENTIDAD", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaCedulaIdentidad());
                    parameters.put("CODIGO_REGISTRO_LABORATORIO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getCodigoRegistroLaboratorio());

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears() == 0) {
                        if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses() == 0) {
                            if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias() == 0) {
                                parameters.put("EDAD", "R.N");
                            } else {
                                parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteDias()) + " DIAS");
                            }
                        } else {
                            parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteMeses()) + " MESES");
                        }
                    } else {
                        parameters.put("EDAD", String.valueOf(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getEdadPacienteYears()) + " AÑOS");
                    }

                    parameters.put("SEXO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaSexo());
                    parameters.put("MEDICO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getSolicitante());
                    parameters.put("FECHA_RECEPCION", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getFechaRecepcion().toString());
                    parameters.put("FECHA_TOMA_MUESTRA", resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra().toString());
                    parameters.put("MUESTRA_BIOLOGICA", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo());

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getNumeroDiasSintomas() == 0) {
                        parameters.put("IMPRIMIR_NUMERO_DIAS_SINTOMAS", false);
                    } else {
                        parameters.put("IMPRIMIR_NUMERO_DIAS_SINTOMAS", true);
                        parameters.put("NUMERO_DIAS_SINTOMAS", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getNumeroDiasSintomas());
                    }

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getFechaProcesamiento() == null) {
                        parameters.put("IMPRIMIR_FECHA_PROCESAMIENTO", false);
                    } else {
                        parameters.put("IMPRIMIR_FECHA_PROCESAMIENTO", true);
                        parameters.put("FECHA_PROCESAMIENTO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getFechaProcesamiento().toString());
                    }

                    parameters.put("SUBESPECIALIDAD", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad().getSubespecialidadNombre());
                    parameters.put("EXAMEN", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre());

                    if (resultadoGeneralPersonalizado.getResultadosVariables().isEmpty()) {
                        parameters.put("IMPRIMIR_TABLA_PARAMETROS", false);
                    } else {
                        parameters.put("IMPRIMIR_TABLA_PARAMETROS", true);
                        final List<TablaParametros> tablaParametros = construirTablaParametros(resultadoGeneralPersonalizado.getResultadosVariables());
                        JRBeanCollectionDataSource dataSourceTablaParametros = new JRBeanCollectionDataSource(tablaParametros);
                        parameters.put("TABLA_PARAMETROS", dataSourceTablaParametros);
                    }

                    switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                        case "COPROPARASITOLOGICO SIMPLE":
                        case "COPROPARASITOLOGICO SERIADO": {

                            parameters.put("IMPRIMIR_CUADRO_OBSERVACION_MACROSCOPICA", true);
                            parameters.put("IMPRIMIR_CUADRO_OBSERVACION_MICROSCOPICA", true);

                            if (resultadoGeneralPersonalizado.getParasitosEncontrados().isEmpty()) {
                                parameters.put("IMPRIMIR_TABLA_PARASITARIA_MACROSCOPICA", false);
                                parameters.put("IMPRIMIR_TABLA_PARASITARIA_MICROSCOPICA", false);
                                parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MACROSCOPICA", true);
                                parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MICROSCOPICA", true);
                            } else {
                                final List<TablaParasitaria> tablaParasitariaMacroscopica = construirTablaParasitariaMacroscopica(resultadoGeneralPersonalizado.getParasitosEncontrados());
                                final List<TablaParasitaria> tablaParasitariaMicroscopica = construirTablaParasitariaMicroscopica(resultadoGeneralPersonalizado.getParasitosEncontrados());

                                if (tablaParasitariaMacroscopica.isEmpty()) {
                                    parameters.put("IMPRIMIR_TABLA_PARASITARIA_MACROSCOPICA", false);
                                    parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MACROSCOPICA", true);
                                } else {
                                    parameters.put("IMPRIMIR_TABLA_PARASITARIA_MACROSCOPICA", true);
                                    parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MACROSCOPICA", false);

                                    JRBeanCollectionDataSource dataSourceTablaParasitariaMacroscopica = new JRBeanCollectionDataSource(tablaParasitariaMacroscopica);
                                    parameters.put("TABLA_PARASITARIA_MACROSCOPICA", dataSourceTablaParasitariaMacroscopica);
                                }

                                if (tablaParasitariaMicroscopica.isEmpty()) {
                                    parameters.put("IMPRIMIR_TABLA_PARASITARIA_MICROSCOPICA", false);
                                    parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MICROSCOPICA", true);
                                } else {
                                    parameters.put("IMPRIMIR_TABLA_PARASITARIA_MICROSCOPICA", true);
                                    parameters.put("IMPRIMIR_CUADRO_NO_SE_OBSERVAN_FORMAS_PARASITARIAS_MICROSCOPICA", false);

                                    JRBeanCollectionDataSource dataSourceTablaParasitariaMicroscopica = new JRBeanCollectionDataSource(tablaParasitariaMicroscopica);
                                    parameters.put("TABLA_PARASITARIA_MICROSCOPICA", dataSourceTablaParasitariaMicroscopica);
                                }
                            }
                        }
                        break;

                        case "PRUEBA RAPIDA PARA COVID AC":
                            parameters.put("IMPRIMIR_SENSIBILIDAD_ESPECIFICIDAD", true);
                            parameters.put("SENSIBILIDAD_ESPECIFICIDAD", "Sensibilidad: IgM 89% - IgG 100% Especificidad: IgM 96% - IgG 98%");
                            break;

                        case "PRUEBA RAPIDA PARA COVID AG":
                            parameters.put("IMPRIMIR_SENSIBILIDAD_ESPECIFICIDAD", true);
                            parameters.put("SENSIBILIDAD_ESPECIFICIDAD", "Sensibilidad: 96,52% Especificidad: 99,68%");
                            break;

                        default:
                            parameters.put("IMPRIMIR_CUADRO_OBSERVACION_MACROSCOPICA", false);
                            parameters.put("IMPRIMIR_CUADRO_OBSERVACION_MICROSCOPICA", false);
                            break;
                    }

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado() == null) {
                        parameters.put("IMPRIMIR_RESULTADO", false);
                    } else {
                        parameters.put("IMPRIMIR_RESULTADO", true);
                        parameters.put("RESULTADO", resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado().getPosibleResultadoNombre());
                    }

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones().isEmpty()) {
                        parameters.put("IMPRIMIR_OBSERVACIONES", false);
                    } else {
                        parameters.put("IMPRIMIR_OBSERVACIONES", true);
                        parameters.put("OBSERVACIONES", resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                    }

                    if (resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones().isEmpty()) {
                        parameters.put("IMPRIMIR_RECOMENDACIONES", false);
                    } else {
                        parameters.put("IMPRIMIR_RECOMENDACIONES", true);
                        parameters.put("RECOMENDACIONES", resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones());
                    }

                    jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("ResultadoExamen.jrxml"));

                    break;
            }

            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
            final JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
            jasperViewer.setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
            jasperViewer.setTitle("SIET - Sistema de Información de Enfermedades Tropicales");
            jasperViewer.setVisible(true);
        } catch (final JRException jRException) {
            Logger.getLogger(VerDetallesResultadosIngresados.class.getName()).log(Level.SEVERE, null, jRException);
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBTNImprimirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            VerDetallesResultadosIngresados dialog = new VerDetallesResultadosIngresados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNCerrar;
    private javax.swing.JButton JBTNImprimir;
    private javax.swing.JLabel JLBLAspectoMuestra;
    private javax.swing.JLabel JLBLBaciloscopiaControl;
    private javax.swing.JLabel JLBLEnfermedad;
    private javax.swing.JLabel JLBLEstadoMuestraBiologica;
    private javax.swing.JLabel JLBLExamenSolicitado;
    private javax.swing.JLabel JLBLFechaFinalAnalisis;
    private javax.swing.JLabel JLBLFechaInicioDeSeguimiento;
    private javax.swing.JLabel JLBLFechaTomaMuestra;
    private javax.swing.JLabel JLBLHoraFinalAnalisis;
    private javax.swing.JLabel JLBLHoraInicioDeSeguimiento;
    private javax.swing.JLabel JLBLIncorporarASeguimiento;
    private javax.swing.JLabel JLBLMuestraBiologica;
    private javax.swing.JLabel JLBLNumeroMuestraBiologica;
    private javax.swing.JLabel JLBLPacienteEnSeguimiento;
    private javax.swing.JLabel JLBLResponsableAnalisis;
    private javax.swing.JLabel JLBLResponsableIntroduccionResultados;
    private javax.swing.JLabel JLBLResultadoFinal;
    private javax.swing.JMenuItem JMENUITEMModificarResultados;
    private javax.swing.JMenuItem JMENUITEMVerResultados;
    private javax.swing.JPanel JPANELSeguimientoPaciente;
    private javax.swing.JPopupMenu JPOPUPMENUItemResultadosIngresados;
    private javax.swing.JTabbedPane JTABBEDPANEResultadosSeguimientoPaciente;
    private javax.swing.JTable JTBLParasitosMuestraBiologica;
    private javax.swing.JTable JTBLResultadosExamen;
    private javax.swing.JTable JTBLTecnicas;
    private javax.swing.JTextArea JTXTAREAObservaciones;
    private javax.swing.JTextArea JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento;
    private javax.swing.JTextArea JTXTAREARecomendaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables

    private List<TablaParametros> construirTablaParametros(final List<ResultadoVariable> resultadosVariables) {
        final List<TablaParametros> tablaParametros = new ArrayList<>();

        resultadosVariables.forEach((resultadoVariable) -> {
            if (!verificarGrupoAgregado(tablaParametros, resultadoVariable.getVariableExamen().getGrupoVariables().getGrupoVariableNombre())) {
                tablaParametros.add(new TablaParametros(resultadoVariable.getVariableExamen().getGrupoVariables().getGrupoVariableNombre(), "", "", "", ""));
            }

            switch (resultadoVariable.getVariableExamen().getVariableExamenNombre()) {
                case "MIELOCITOS FLR":
                case "MIELOCITOS FLA": {
                    tablaParametros.add(new TablaParametros("", "MIELOCITOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }
                break;

                case "METAMIELOCITOS FLR":
                case "METAMIELOCITOS FLA": {
                    tablaParametros.add(new TablaParametros("", "METAMIELOCIOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "CAYADOS FLR":
                case "CAYADOS FLA": {
                    tablaParametros.add(new TablaParametros("", "CAYADOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "SEGMENTADOS FLR":
                case "SEGMENTADOS FLA": {
                    tablaParametros.add(new TablaParametros("", "SEGMENTADOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "LINFOCITOS FLR":
                case "LINFOCITOS FLA": {
                    tablaParametros.add(new TablaParametros("", "LINFOCITOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "MONOCITOS FLR":
                case "MONOCITOS FLA": {
                    tablaParametros.add(new TablaParametros("", "MONOCITOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "BASOFILOS FLR":
                case "BASOFILOS FLA": {
                    tablaParametros.add(new TablaParametros("", "BASOFILOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }

                break;

                case "EOSINOFILOS FLR":
                case "EOSINOFILOS FLA": {
                    tablaParametros.add(new TablaParametros("", "EOSINOFILOS", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }
                
                break;
                
                case "VALOR DEL PACIENTE IGM":
                case "VALOR DEL PACIENTE IGG": {
                    tablaParametros.add(new TablaParametros("", "VALOR DEL PACIENTE", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }
                break;

                case "INTERPRETACION IGM":
                case "INTERPRETACION IGG": {
                    tablaParametros.add(new TablaParametros("", "INTERPRETACION", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }
                break;

                case "OBSERVACIONES IGM":
                case "OBSERVACIONES IGG": {
                    tablaParametros.add(new TablaParametros("", "OBSERVACIONES", resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                }
                break;

                default:
                    tablaParametros.add(new TablaParametros("", resultadoVariable.getVariableExamen().getVariableExamenNombre(), resultadoVariable.getResultadoVariable(), resultadoVariable.getVariableExamen().getVariableExamenValorReferencia(), resultadoVariable.getVariableExamen().getVariableExamenMetodo()));
                    break;
            }
        });
        return tablaParametros;
    }

    private List<TablaParasitaria> construirTablaParasitariaMacroscopica(final List<ParasitoEncontrado> parasitosEncontrados) {
        final List<TablaParasitaria> tablaParasitarias = new ArrayList<>();
        parasitosEncontrados.forEach((parasitoEncontrado) -> {
            if (parasitoEncontrado.getParasitoTipoObservacion().equals("MACROSCOPICA")) {
                tablaParasitarias.add(new TablaParasitaria(parasitoEncontrado.getParasito().getParasitoNombre()));
            }
        });
        return tablaParasitarias;
    }

    private List<TablaParasitaria> construirTablaParasitariaMicroscopica(final List<ParasitoEncontrado> parasitosEncontrados) {
        final List<TablaParasitaria> tablaParasitarias = new ArrayList<>();
        parasitosEncontrados.forEach((parasitoEncontrado) -> {
            if (parasitoEncontrado.getParasitoTipoObservacion().equals("MICROSCOPICA")) {
                tablaParasitarias.add(new TablaParasitaria(parasitoEncontrado.getParasito().getParasitoNombre()));
            }
        });
        return tablaParasitarias;
    }

    private boolean verificarGrupoAgregado(final List<TablaParametros> tablaParametros, final String nombreGrupo) {
        boolean found = false;
        for (final TablaParametros tp : tablaParametros) {
            if (tp.getGrupoParametro().equals(nombreGrupo)) {
                found = true;
                break;
            }
        }

        return found;
    }
}
