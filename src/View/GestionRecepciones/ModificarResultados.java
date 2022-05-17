package View.GestionRecepciones;

import Model.POJO.AspectoCalidad;
import Model.POJO.Enfermedad;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.Parasito;
import Model.POJO.ParasitoEncontrado;
import Model.POJO.ResultadoVariable;
import Model.POJO.SeguimientoPaciente;
import Model.POJO.Tecnica;
import Model.POJO.TecnicaAplicada;
import Model.POJO.VariableExamen;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import Presenter.GestionExamenes.PresenterGestionExamenes;
import Presenter.GestionExamenes.PresenterGestionVariablesExamen;
import Presenter.GestionMuestrasBiologicas.PresenterGestionMuestrasBiologicas;
import Presenter.GestionPacientes.PresenterGestionPacientes;
import Presenter.GestionRecepciones.PresenterGestionResultadoGeneral;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.ModelTable.GestionRecepciones.ParasitoDisponible;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelParasitosMuestraBiologica;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelResultadosVariables;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelTecnicasMetodos;
import View.Utilitarios.ModelTable.GestionRecepciones.TecnicaDisponible;
import View.Utilitarios.ModeloItemComboBox.ItemAspectoCalidad;
import View.Utilitarios.ModeloItemComboBox.ItemEnfermedad;
import View.Utilitarios.ModeloItemComboBox.ItemPosibleResultado;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Brynner
 */
public class ModificarResultados extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackObtenerAspectos, PresenterGestionVariablesExamen.CallBackObtenerVariablesExamenes, PresenterGestionMuestrasBiologicas.CallBackObtenerParasitos, PresenterGestionExamenes.CallBackObtenerPosiblesResultados, PresenterGestionPacientes.CallBackObtenerSeguimiento, PresenterGestionResultadoGeneral.CallBackVerificarResultadoExiste, PresenterGestionResultadoGeneral.CallBackModificarResultadoGeneral, PresenterGestionExamenes.CallBackObtenerTecnicasAgregadas, PresenterGestionSubespecialidades.CallBackObtenerEnfermedades, PresenterGestionResultadoGeneral.CallBackVerificarPermitirModificacion, PresenterGestionResultadoGeneral.CallBackVerificarSiResultadoEsAntecedente {

    private final TableModelResultadosVariables tableModelResultadosVariables;
    private final TableModelParasitosMuestraBiologica tableModelParasitosMuestraBiologica;
    private final TableModelTecnicasMetodos tableModelTecnicasMetodos;

    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    private final PresenterGestionVariablesExamen presenterGestionVariablesExamen;
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionResultadoGeneral presenterGestionResultadoGeneral;
    private final PresenterGestionPacientes presenterGestionPacientes;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;

    private final JComboBox jComboBoxObservacionesParasitarias;

    private SeguimientoPaciente seguimientoPaciente;
    private ResultadoGeneralPersonalizado resultadoGeneralPersonalizado;

    public ModificarResultados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionVariablesExamen = new PresenterGestionVariablesExamen();
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionResultadoGeneral = new PresenterGestionResultadoGeneral();
        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();

        presenterGestionMuestrasBiologicas.setCallBackObtenerAspectos(this);
        presenterGestionVariablesExamen.setCallBackObtenerVariablesExamenes(this);
        presenterGestionMuestrasBiologicas.setCallBackObtenerParasitos(this);
        presenterGestionExamenes.setCallBackObtenerPosiblesResultados(this);
        presenterGestionResultadoGeneral.setCallBackVerificarResultadoExiste(this);
        presenterGestionResultadoGeneral.setCallBackModificarResultadoGeneral(this);
        presenterGestionPacientes.setCallBackObtenerSeguimiento(this);
        presenterGestionExamenes.setCallBackObtenerTecnicasAgregadas(this);
        presenterGestionSubespecialidades.setCallBackObtenerEnfermedades(this);
        presenterGestionResultadoGeneral.setCallBackVerificarPermitirModificacion(this);
        presenterGestionResultadoGeneral.setCallBackVerificarSiResultadoEsAntecedente(this);

        jComboBoxObservacionesParasitarias = new JComboBox();
        jComboBoxObservacionesParasitarias.addItem("MICROSCOPICA");
        jComboBoxObservacionesParasitarias.addItem("MACROSCOPICA");

        tableModelResultadosVariables = new TableModelResultadosVariables(true);
        tableModelParasitosMuestraBiologica = new TableModelParasitosMuestraBiologica();
        tableModelTecnicasMetodos = new TableModelTecnicasMetodos();

        initComponents();

    }

    public void setResultadoGeneralPersonalizado(ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        this.resultadoGeneralPersonalizado = resultadoGeneralPersonalizado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTABBEDPANEResultadosSeguimientoPaciente = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        JLBLExamenSolicitado = new javax.swing.JLabel();
        JLBLMuestraBiologica = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        JLBLEstadoMuestraBiologica = new javax.swing.JLabel();
        JCMBXAspecto = new javax.swing.JComboBox<>();
        JCMBXNumeroMuestraBiologica = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        JLBLResponsableIntroduccionResultados = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        JCMBXIncorporarASeguimiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JLBLResponsableAnalisis = new javax.swing.JLabel();
        JLBLFechaFinalAnalisis = new javax.swing.JLabel();
        JLBLHoraFinalAnalisis = new javax.swing.JLabel();
        JPANELSeguimientoPaciente = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        JLBLPacienteEnSeguimiento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLBLFechaInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLBLHoraInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento = new javax.swing.JTextArea();
        JCMBXBaciloscopiaControl = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLResultadosExamen = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBLParasitosMuestraBiologica = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTBLTecnicas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        JLBLContadorRecomendaciones = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTXTAREARecomendaciones = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTXTAREAObservaciones = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        JCMBXExamenPosibleResultado = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        JCMBXEnfermedad = new javax.swing.JComboBox<>();
        JDTCHOOSERFechaTomaMuestra = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        JBTNCancelar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Modificar Resultados");
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
                    .addComponent(JCMBXAspecto, 0, 300, Short.MAX_VALUE)
                    .addComponent(JCMBXNumeroMuestraBiologica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBXNumeroMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCMBXAspecto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLEstadoMuestraBiologica, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Análisis"));

        jLabel26.setText("RESPONSABLE DE ANALISIS:");

        jLabel28.setText("RESULTADOS INGRESADOS POR:");

        JLBLResponsableIntroduccionResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setText("FECHA FINAL DE ANALISIS:");

        jLabel32.setText("HORA FINAL DE ANALISIS:");

        JCMBXIncorporarASeguimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        JCMBXIncorporarASeguimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXIncorporarASeguimientoItemStateChanged(evt);
            }
        });

        jLabel5.setText("¿INCORPORAR A SEGUIMIENTO?");

        JLBLResponsableAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLFechaFinalAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLBLHoraFinalAnalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JCMBXIncorporarASeguimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLResponsableAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLFechaFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLBLHoraFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLResponsableAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLFechaFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(JLBLHoraFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBXIncorporarASeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Resultados Generales", jPanel3);

        jLabel6.setText("PACIENTE EN SEGUIMIENTO:");

        JLBLPacienteEnSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("BACILOSCOPIA DE CONTROL:");

        jLabel10.setText("FECHA INICIO DE SEGUIMIENTO:");

        JLBLFechaInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("HORA INICIO DE SEGUIMIENTO:");

        JLBLHoraInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("DETALLES U OBSERVACIONES REGISTRADAS AL INICIO DEL SEGUIMIENTO:");

        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setColumns(20);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setLineWrap(true);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setRows(5);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setEnabled(false);
        jScrollPane5.setViewportView(JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento);

        JCMBXBaciloscopiaControl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fin de 1ra. Fase", "Al final del 3er. Mes", "Al final del 4to. Mes", "Al final del 5to. Mes", "Al final del 6to. Mes", "Al final del 7mo. Mes", "Al final del 8vo. Mes", "Otras" }));
        JCMBXBaciloscopiaControl.setSelectedIndex(-1);

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
                        .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(JLBLHoraInicioDeSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(JCMBXBaciloscopiaControl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        JPANELSeguimientoPacienteLayout.setVerticalGroup(
            JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPANELSeguimientoPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPANELSeguimientoPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addComponent(JLBLPacienteEnSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLFechaInicioDeSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPANELSeguimientoPacienteLayout.createSequentialGroup()
                        .addComponent(JCMBXBaciloscopiaControl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLBLHoraInicioDeSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimientos del Paciente", JPANELSeguimientoPaciente);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de Análisis"));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Variables de Exámen", jPanel2);

        JTBLParasitosMuestraBiologica.setModel(tableModelParasitosMuestraBiologica);
        JTBLParasitosMuestraBiologica.setRowHeight(20);
        JTBLParasitosMuestraBiologica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(1).setPreferredWidth(800);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(3).setPreferredWidth(100);

        final TableColumn tableColumn = JTBLParasitosMuestraBiologica.getColumnModel().getColumn(2);
        tableColumn.setCellEditor(new DefaultCellEditor(jComboBoxObservacionesParasitarias));
        JTBLParasitosMuestraBiologica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLParasitosMuestraBiologicaMousePressed(evt);
            }
        });
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Parásitos de Muestra Biológica", jPanel6);

        JTBLTecnicas.setModel(tableModelTecnicasMetodos);
        JTBLTecnicas.setRowHeight(20);
        JTBLTecnicas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLTecnicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLTecnicasMousePressed(evt);
            }
        });
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLTecnicas.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLTecnicas.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLTecnicas.getColumnModel().getColumn(1).setPreferredWidth(600);
        JTBLTecnicas.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLTecnicas.getColumnModel().getColumn(3).setPreferredWidth(100);
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Técnicas/Métodos", jPanel7);

        JLBLContadorRecomendaciones.setText("0");

        JTXTAREARecomendaciones.setColumns(20);
        JTXTAREARecomendaciones.setLineWrap(true);
        JTXTAREARecomendaciones.setRows(5);
        JTXTAREARecomendaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREARecomendacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREARecomendacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREARecomendacionesKeyTyped(evt);
            }
        });
        JTXTAREARecomendaciones.setTransferHandler(null);
        jScrollPane6.setViewportView(JTXTAREARecomendaciones);

        jLabel11.setText("/200");

        jLabel13.setText("OBSERVACIONES:");

        jLabel15.setText("RESULTADO O INTERPRETACION:");

        jLabel16.setText("RECOMENDACIONES:");

        JLBLContadorObservaciones.setText("0");

        JTXTAREAObservaciones.setColumns(20);
        JTXTAREAObservaciones.setLineWrap(true);
        JTXTAREAObservaciones.setRows(5);
        JTXTAREAObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTXTAREAObservacionesKeyTyped(evt);
            }
        });
        JTXTAREAObservaciones.setTransferHandler(null);
        jScrollPane7.setViewportView(JTXTAREAObservaciones);

        jLabel17.setText("/200");

        jLabel18.setText("ENFERMEDAD:");

        JDTCHOOSERFechaTomaMuestra.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaTomaMuestra.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("FECHA DE TOMA DE MUESTRA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorObservaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLBLContadorRecomendaciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(JDTCHOOSERFechaTomaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCMBXEnfermedad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(JCMBXExamenPosibleResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(JLBLContadorObservaciones))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(JLBLContadorRecomendaciones))
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCMBXExamenPosibleResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCMBXEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDTCHOOSERFechaTomaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Observaciones/Recomendaciones/Resultado o Interpretación", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");
        JBTNGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNGuardarActionPerformed(evt);
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTABBEDPANEResultadosSeguimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNGuardar))
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
                JTABBEDPANEResultadosSeguimientoPaciente.removeTabAt(1);
                JLBLExamenSolicitado.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre());
                JLBLMuestraBiologica.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica().getMuestraBiologicaTipo());

                if (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getTotalMuestrasBiologicas() == 1) {
                    JCMBXNumeroMuestraBiologica.addItem("1ra. Muestra");
                } else {
                    JCMBXNumeroMuestraBiologica.addItem("1ra. Muestra");
                    JCMBXNumeroMuestraBiologica.addItem("2da. Muestra");
                    JCMBXNumeroMuestraBiologica.setSelectedIndex(resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica().equals("1ra. Muestra") ? 0 : 1);
                }

                JLBLEstadoMuestraBiologica.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologicaEstado());
                JLBLResponsableAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getPersona().getPersonaNombre());
                JLBLResponsableIntroduccionResultados.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getPersona().getPersonaNombre());
                JLBLFechaFinalAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getFechaFinal().toString());
                JLBLHoraFinalAnalisis.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getHoraFinal().toString());

                if (resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null) {
                    JCMBXIncorporarASeguimiento.setSelectedIndex(0);
                } else {
                    JCMBXIncorporarASeguimiento.setSelectedIndex(1);
                    JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimiento del Paciente", JPANELSeguimientoPaciente);
                    JLBLPacienteEnSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaApellido() + " " + resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente().getPersona().getPersonaNombre());
                    JCMBXBaciloscopiaControl.setSelectedIndex(getIndexBaciloscopiaControlSeleccionado(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenControl()));
                    JLBLFechaInicioDeSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getFechaInicio().toString());
                    JLBLHoraInicioDeSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getHoraInicio().toString());
                    JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getDetallesObservacionesInicio());
                }

                JTXTAREAObservaciones.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
                JTXTAREARecomendaciones.setText(resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones());

                JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAObservaciones.getText().length()));
                JLBLContadorRecomendaciones.setText(String.valueOf(JTXTAREARecomendaciones.getText().length()));

                JDTCHOOSERFechaTomaMuestra.setDate(resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra());

                presenterGestionMuestrasBiologicas.obtenerAspectos(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica());
                presenterGestionVariablesExamen.obtenerVariablesExamen(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen());
                presenterGestionMuestrasBiologicas.obtenerParasitos(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getMuestraBiologica());
                presenterGestionExamenes.obtenerPosiblesResultados(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen());
                presenterGestionExamenes.obtenerTecnicasAgregadas(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen());
                presenterGestionSubespecialidades.obtenerEnfermedades(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getSubespecialidad());
            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JCMBXIncorporarASeguimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXIncorporarASeguimientoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 0) {
                seguimientoPaciente = null;
                if (JTABBEDPANEResultadosSeguimientoPaciente.getTabCount() > 1) {
                    JCMBXBaciloscopiaControl.setSelectedIndex(-1);
                    JTABBEDPANEResultadosSeguimientoPaciente.removeTabAt(1);
                }
            } else {
                presenterGestionPacientes.obtenerSeguimiento(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getRecepcion().getPaciente(), resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado());
            }
        }
    }//GEN-LAST:event_JCMBXIncorporarASeguimientoItemStateChanged

    private void JTBLParasitosMuestraBiologicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLParasitosMuestraBiologicaMousePressed
        final int currentRow = JTBLParasitosMuestraBiologica.rowAtPoint(evt.getPoint());
        JTBLParasitosMuestraBiologica.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLParasitosMuestraBiologicaMousePressed

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JBTNGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNGuardarActionPerformed
        if (tableModelResultadosVariables.resultadosVacios() && JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar los resultados a la tabla y/o ingresar un resultado o interpretación del análisis.", "SIET", JOptionPane.ERROR_MESSAGE);
            JCMBXEnfermedad.setSelectedIndex(-1);
            JCMBXExamenPosibleResultado.setSelectedIndex(-1);
        } else if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 1 && seguimientoPaciente == null) {
            JOptionPane.showMessageDialog(rootPane, "El paciente no posee seguimientos activos.", "SIET", JOptionPane.ERROR_MESSAGE);
        } else if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 1 && seguimientoPaciente != null && JCMBXBaciloscopiaControl.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la baciloscopia de control.", "SIET", JOptionPane.ERROR_MESSAGE);
            JCMBXBaciloscopiaControl.requestFocus();
        } else if (JDTCHOOSERFechaTomaMuestra.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de toma de muestra.", "SIET", JOptionPane.ERROR_MESSAGE);
            JDTCHOOSERFechaTomaMuestra.requestFocus();
        } else {
            switch (resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getExamen().getExamenNombre()) {
                case "HEMOGRAMA":
                    final int positionGotaGruesa = tableModelResultadosVariables.getRowPosition("GOTA GRUESA");
                    final Object valueGotaGruesa = tableModelResultadosVariables.getValueAt(positionGotaGruesa, 2);

                    if (valueGotaGruesa == null) {
                        guardar();
                    } else {
                        if (JCMBXEnfermedad.getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(rootPane, "El parámetro GOTA GRUESA fué indicada como " + valueGotaGruesa + ", debes seleccionar la enfermedad: Malaria Mixta, Malaria por P. falciparum o Malaria por P. vivax para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                        } else {
                            guardar();
                        }
                    }
                    break;

                case "BACILOSCOPIA":
                    if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("TUBERCULOSIS")) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de TUBERCULOSIS paraque pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO o NEGATIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (JCMBXExamenPosibleResultado.getSelectedItem().toString()) {
                            case "POSITIVO":
                            case "NEGATIVO": {
                                guardar();
                            }
                            break;

                            default:
                                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO o NEGATIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    break;

                case "HAI ELISA CHAGAS":
                case "HAI CHAGAS":
                case "ELISA CHAGAS": {
                    if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("CHAGAS")) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de CHAGAS paraque pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO, NEGATIVO o INDETERMINADO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (JCMBXExamenPosibleResultado.getSelectedItem().toString()) {
                            case "POSITIVO":
                            case "NEGATIVO":
                            case "INDETERMINADO": {
                                guardar();
                            }
                            break;

                            default:
                                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO, NEGATIVO o INDETERMINADO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }
                break;

                case "MAC ELISA DENGUE":
                case "MAC ELISA - DENGUE":
                case "ELISA NS1 DENGUE":
                case "ELISA NS1 - DENGUE": {
                    if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("DENGUE")) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de DENGUE paraque pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO, NEGATIVO o INDETERMINADO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (JCMBXExamenPosibleResultado.getSelectedItem().toString()) {
                            case "POSITIVO":
                            case "NEGATIVO":
                            case "INDETERMINADO": {
                                guardar();
                            }
                            break;

                            default:
                                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO, NEGATIVO o INDETERMINADO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }
                break;

                case "CUTANEO":
                case "MUCOSO":
                case "VISCERAL": {
                    if (tableModelTecnicasMetodos.obtenerTecnicasAplicadas().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar que técnica fue aplicada para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("LEISHMANIASIS")) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de LEISHMANIASIS para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO o NEGATIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (JCMBXExamenPosibleResultado.getSelectedItem().toString()) {
                            case "POSITIVO":
                            case "NEGATIVO": {
                                guardar();
                            }
                            break;

                            default:
                                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO o NEGATIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                }
                break;

                case "PRUEBA RAPIDA PARA VIH":
                    if (tableModelTecnicasMetodos.obtenerTecnicasAplicadas().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar que técnica fue aplicada para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("VIH")) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de VIH para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                        JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: REACTIVO o NO REACTIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                    } else {
                        switch (JCMBXExamenPosibleResultado.getSelectedItem().toString()) {
                            case "REACTIVO":
                            case "NO REACTIVO": {
                                guardar();
                            }
                            break;

                            default:
                                JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: REACTIVO o NO REACTIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                                break;
                        }
                    }
                    break;

                default:
                    guardar();
                    break;
            }
        }
    }//GEN-LAST:event_JBTNGuardarActionPerformed

    private void JTXTAREARecomendacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREARecomendacionesKeyReleased
        JLBLContadorRecomendaciones.setText(String.valueOf(JTXTAREARecomendaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREARecomendacionesKeyReleased

    private void JTXTAREARecomendacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREARecomendacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9ñÑ. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREARecomendaciones.getText().length() >= 200) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREARecomendacionesKeyTyped

    private void JTXTAREAObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyReleased
        JLBLContadorObservaciones.setText(String.valueOf(JTXTAREAObservaciones.getText().length()));
    }//GEN-LAST:event_JTXTAREAObservacionesKeyReleased

    private void JTXTAREAObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyTyped
        final char keyChar = evt.getKeyChar();
        final Pattern pt = Pattern.compile("^([a-zA-Z0-9ñÑ. ]*)$");
        final Matcher mt = pt.matcher(Character.toString(keyChar));

        boolean matchFound = mt.find();
        if (!matchFound || JTXTAREAObservaciones.getText().length() >= 200) {
            evt.consume();
        } else if (Character.isLowerCase(evt.getKeyChar())) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyTyped

    private void JTBLTecnicasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLTecnicasMousePressed
        final int currentRow = JTBLTecnicas.rowAtPoint(evt.getPoint());
        JTBLTecnicas.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLTecnicasMousePressed

    private void JTXTAREAObservacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREAObservacionesKeyPressed

    private void JTXTAREARecomendacionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTXTAREARecomendacionesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            evt.consume();
        }
    }//GEN-LAST:event_JTXTAREARecomendacionesKeyPressed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ModificarResultados dialog = new ModificarResultados(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<View.Utilitarios.ModeloItemComboBox.ItemAspectoCalidad> JCMBXAspecto;
    private javax.swing.JComboBox<String> JCMBXBaciloscopiaControl;
    private javax.swing.JComboBox<ItemEnfermedad> JCMBXEnfermedad;
    private javax.swing.JComboBox<ItemPosibleResultado> JCMBXExamenPosibleResultado;
    private javax.swing.JComboBox<String> JCMBXIncorporarASeguimiento;
    private javax.swing.JComboBox<String> JCMBXNumeroMuestraBiologica;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaTomaMuestra;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorRecomendaciones;
    private javax.swing.JLabel JLBLEstadoMuestraBiologica;
    private javax.swing.JLabel JLBLExamenSolicitado;
    private javax.swing.JLabel JLBLFechaFinalAnalisis;
    private javax.swing.JLabel JLBLFechaInicioDeSeguimiento;
    private javax.swing.JLabel JLBLHoraFinalAnalisis;
    private javax.swing.JLabel JLBLHoraInicioDeSeguimiento;
    private javax.swing.JLabel JLBLMuestraBiologica;
    private javax.swing.JLabel JLBLPacienteEnSeguimiento;
    private javax.swing.JLabel JLBLResponsableAnalisis;
    private javax.swing.JLabel JLBLResponsableIntroduccionResultados;
    private javax.swing.JPanel JPANELSeguimientoPaciente;
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel jLabel8;
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

    private int getIndexAspectoMuestraSeleccionada(final AspectoCalidad aspecto) {
        final int size = JCMBXAspecto.getItemCount();
        for (int i = 0; i < size; i++) {
            if (JCMBXAspecto.getItemAt(i).getCodigoAspectoCalidad() == aspecto.getCodigoAspectoCalidad()) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexObservacionSeleccionada(final ParasitoEncontrado parasitoEncontrado) {
        final int size = jComboBoxObservacionesParasitarias.getItemCount();
        for (int i = 0; i < size; i++) {
            if (jComboBoxObservacionesParasitarias.getItemAt(i).toString().equals(parasitoEncontrado.getParasitoTipoObservacion())) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexExamenPosibleResultadoSeleccionado(final ExamenPosibleResultado examenPosibleResultado) {
        final int size = JCMBXExamenPosibleResultado.getItemCount();
        for (int i = 0; i < size; i++) {
            if (JCMBXExamenPosibleResultado.getItemAt(i).getCodigoPosibleResultado() == examenPosibleResultado.getCodigoPosibleResultado()) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexBaciloscopiaControlSeleccionado(final String baciloscopiaControl) {
        final int size = JCMBXBaciloscopiaControl.getItemCount();
        for (int i = 0; i < size; i++) {
            if (JCMBXBaciloscopiaControl.getItemAt(i).equals(baciloscopiaControl)) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexEnfermedadSeleccionada(final Enfermedad enfermedad) {
        final int size = JCMBXEnfermedad.getItemCount();
        for (int i = 0; i < size; i++) {
            if (JCMBXEnfermedad.getItemAt(i).getCodigoEnfermedad() == enfermedad.getCodigoEnfermedad()) {
                return i;
            }
        }
        return -1;
    }

    private void guardar() {
        final String numeroMuestraBiologica = JCMBXNumeroMuestraBiologica.getSelectedItem().toString();

        AspectoCalidad aspecto = null;
        if (JCMBXAspecto.getSelectedIndex() != -1) {
            final ItemAspectoCalidad itemAspecto = (ItemAspectoCalidad) JCMBXAspecto.getSelectedItem();
            aspecto = new AspectoCalidad(itemAspecto.getCodigoAspectoCalidad(), null, itemAspecto.getAspectoCalidad(), itemAspecto.getAspectoCalidadEstado());
        }

        final String baciloscopiaControl = JCMBXBaciloscopiaControl.getSelectedIndex() == -1 ? null : JCMBXBaciloscopiaControl.getSelectedItem().toString();

        final List<ResultadoVariable> resultadosVariables = tableModelResultadosVariables.obtenerResultadoVariablesNoVacias();
        final List<ParasitoEncontrado> parasitosEncontrados = tableModelParasitosMuestraBiologica.obtenerParasitosEncontrados();
        final List<TecnicaAplicada> tecnicasAplicadas = tableModelTecnicasMetodos.obtenerTecnicasAplicadas();

        final List<ResultadoVariable> nuevosResultadosVariables = new ArrayList<>();
        final List<ParasitoEncontrado> nuevosParasitosEncontrados = new ArrayList<>();
        final List<TecnicaAplicada> nuevasTecnicasAplicadas = new ArrayList<>();

        boolean variableFound = false;
        for (final ResultadoVariable currentResultadoVariable : resultadosVariables) {
            for (final ResultadoVariable oldResultadoVariable : resultadoGeneralPersonalizado.getResultadosVariables()) {
                if (currentResultadoVariable.getVariableExamen().getCodigoVariableExamen() == oldResultadoVariable.getVariableExamen().getCodigoVariableExamen()) {
                    variableFound = true;
                    nuevosResultadosVariables.add(new ResultadoVariable(oldResultadoVariable.getCodigoResultadoVariable(), null, oldResultadoVariable.getVariableExamen(), currentResultadoVariable.getResultadoVariable(), oldResultadoVariable.getResultadoVariableEstado()));
                    break;
                }
            }

            if (variableFound == false) {
                nuevosResultadosVariables.add(new ResultadoVariable(0, null, currentResultadoVariable.getVariableExamen(), currentResultadoVariable.getResultadoVariable(), 1));
            }
            variableFound = false;
        }

        variableFound = false;
        for (final ResultadoVariable oldResultadoVariable : resultadoGeneralPersonalizado.getResultadosVariables()) {
            for (final ResultadoVariable currentResultadoVariable : resultadosVariables) {
                if (oldResultadoVariable.getVariableExamen().getCodigoVariableExamen() == currentResultadoVariable.getVariableExamen().getCodigoVariableExamen()) {
                    variableFound = true;
                    break;
                }
            }

            if (variableFound == false) {
                nuevosResultadosVariables.add(new ResultadoVariable(oldResultadoVariable.getCodigoResultadoVariable(), null, oldResultadoVariable.getVariableExamen(), oldResultadoVariable.getResultadoVariable(), 0));
            }
            variableFound = false;
        }

        boolean parasitosFound = false;
        for (final ParasitoEncontrado currentParasitoEncontrado : parasitosEncontrados) {
            for (final ParasitoEncontrado oldParasitoEncontrado : resultadoGeneralPersonalizado.getParasitosEncontrados()) {
                if (currentParasitoEncontrado.getParasito().getCodigoParasito() == oldParasitoEncontrado.getParasito().getCodigoParasito()) {
                    parasitosFound = true;
                    nuevosParasitosEncontrados.add(new ParasitoEncontrado(oldParasitoEncontrado.getCodigoParasitoEncontrado(), null, oldParasitoEncontrado.getParasito(), currentParasitoEncontrado.getParasitoTipoObservacion(), oldParasitoEncontrado.getParasitoEncontradoEstado()));
                    break;
                }
            }

            if (parasitosFound == false) {
                nuevosParasitosEncontrados.add(new ParasitoEncontrado(0, null, currentParasitoEncontrado.getParasito(), currentParasitoEncontrado.getParasitoTipoObservacion(), 1));
            }
            parasitosFound = false;
        }

        for (final ParasitoEncontrado oldParasitoEncontrado : resultadoGeneralPersonalizado.getParasitosEncontrados()) {
            for (final ParasitoEncontrado currentParasitoEncontrado : parasitosEncontrados) {
                if (oldParasitoEncontrado.getParasito().getCodigoParasito() == currentParasitoEncontrado.getParasito().getCodigoParasito()) {
                    parasitosFound = true;
                    break;
                }
            }

            if (parasitosFound == false) {
                nuevosParasitosEncontrados.add(new ParasitoEncontrado(oldParasitoEncontrado.getCodigoParasitoEncontrado(), null, oldParasitoEncontrado.getParasito(), null, 0));
            }
            parasitosFound = false;
        }

        boolean tecnicaFound = false;
        for (final TecnicaAplicada currentTecnicaAplicada : tecnicasAplicadas) {
            for (final TecnicaAplicada oldTecnicaAplicada : resultadoGeneralPersonalizado.getTecnicasAplicadas()) {
                if (currentTecnicaAplicada.getTecnica().getCodigoTecnica() == oldTecnicaAplicada.getTecnica().getCodigoTecnica()) {
                    tecnicaFound = true;
                    break;
                }
            }

            if (tecnicaFound == false) {
                // INSERTAR NUEVA TECNICA
                nuevasTecnicasAplicadas.add(new TecnicaAplicada(0, null, currentTecnicaAplicada.getTecnica(), 1));
            }
            tecnicaFound = false;
        }

        for (final TecnicaAplicada oldTecnicaAplicada : resultadoGeneralPersonalizado.getTecnicasAplicadas()) {
            for (final TecnicaAplicada currentTecnicaAplicada : tecnicasAplicadas) {
                if (oldTecnicaAplicada.getTecnica().getCodigoTecnica() == currentTecnicaAplicada.getTecnica().getCodigoTecnica()) {
                    tecnicaFound = true;
                    break;
                }
            }

            if (tecnicaFound == false) {
                nuevasTecnicasAplicadas.add(new TecnicaAplicada(oldTecnicaAplicada.getCodigoTecnicaAplicada(), null, oldTecnicaAplicada.getTecnica(), 0));
            }
            tecnicaFound = false;
        }

        ExamenPosibleResultado examenPosibleResultado = null;
        if (JCMBXExamenPosibleResultado.getSelectedIndex() != -1) {
            final ItemPosibleResultado itemPosibleResultado = (ItemPosibleResultado) JCMBXExamenPosibleResultado.getSelectedItem();
            examenPosibleResultado = new ExamenPosibleResultado(itemPosibleResultado.getCodigoPosibleResultado(), null, itemPosibleResultado.getPosibleResultadoNombre(), itemPosibleResultado.getPosibleResultadoEstado());
        }

        Enfermedad enfermedad = null;
        if (JCMBXEnfermedad.getSelectedIndex() != -1) {
            final ItemEnfermedad itemEnfermedad = (ItemEnfermedad) JCMBXEnfermedad.getSelectedItem();
            enfermedad = new Enfermedad(itemEnfermedad.getCodigoEnfermedad(), null, itemEnfermedad.getEnfermedadNombre(), itemEnfermedad.getEnfermedadEstado());
        }

        final String observaciones = JTXTAREAObservaciones.getText().trim().isEmpty() ? "" : JTXTAREAObservaciones.getText();
        final String recomencaciones = JTXTAREARecomendaciones.getText().trim().isEmpty() ? "" : JTXTAREARecomendaciones.getText();

        resultadoGeneralPersonalizado.getResultadoGeneral().setNumeroMuestraBiologica(numeroMuestraBiologica);
        resultadoGeneralPersonalizado.getResultadoGeneral().setAspecto(aspecto);
        resultadoGeneralPersonalizado.getResultadoGeneral().setSeguimientoPaciente(seguimientoPaciente);
        resultadoGeneralPersonalizado.getResultadoGeneral().setExamenControl(baciloscopiaControl);
        resultadoGeneralPersonalizado.setResultadosVariables(nuevosResultadosVariables);
        resultadoGeneralPersonalizado.setParasitosEncontrados(nuevosParasitosEncontrados);
        resultadoGeneralPersonalizado.setTecnicasAplicadas(nuevasTecnicasAplicadas);
        resultadoGeneralPersonalizado.getResultadoGeneral().setExamenPosibleResultado(examenPosibleResultado);
        resultadoGeneralPersonalizado.getResultadoGeneral().setEnfermedad(enfermedad);
        resultadoGeneralPersonalizado.getResultadoGeneral().setObservaciones(observaciones);
        resultadoGeneralPersonalizado.getResultadoGeneral().setRecomendaciones(recomencaciones);
        resultadoGeneralPersonalizado.getResultadoGeneral().setFechaTomaMuestra(Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaTomaMuestra.getDate())));

        presenterGestionResultadoGeneral.modificarResultadoGeneral(resultadoGeneralPersonalizado);
    }

    @Override
    public void aspectosObtenidos(final List<AspectoCalidad> aspectos) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        aspectos.forEach((aspecto) -> {
            defaultComboBoxModel.addElement(new ItemAspectoCalidad(aspecto.getCodigoAspectoCalidad(), aspecto.getAspectoCalidad(), aspecto.getAspectoCalidadEstado()));
        });
        JCMBXAspecto.setModel(defaultComboBoxModel);
        JCMBXAspecto.setSelectedIndex(-1);

        JCMBXAspecto.setSelectedIndex(resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto() == null ? -1 : getIndexAspectoMuestraSeleccionada(resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto()));
    }

    @Override
    public void listaAspectosVacia(final String msg) {
    }

    @Override
    public void errorObtenerAspectos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerAspectos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void variablesExamenesObtenidos(final List<VariableExamen> variablesExamenes) {
        final List<ResultadoVariable> resultadosVariables = new ArrayList<>();

        variablesExamenes.forEach((variableExamen) -> {
            resultadosVariables.add(new ResultadoVariable(null, variableExamen, null, 1));
        });

        tableModelResultadosVariables.setResultadosVariables(resultadosVariables);
        JTBLResultadosExamen.getTableHeader().setReorderingAllowed(false);

        final int lengthRow = JTBLResultadosExamen.getModel().getRowCount();
        resultadoGeneralPersonalizado.getResultadosVariables().forEach((resultadoVariable) -> {
            for (int i = 0; i < lengthRow; i++) {
                if (tableModelResultadosVariables.getResultadoVariable(i).getVariableExamen().getCodigoVariableExamen() == resultadoVariable.getVariableExamen().getCodigoVariableExamen()) {
                    tableModelResultadosVariables.setValueAt(resultadoVariable.getResultadoVariable(), i, 2);
                }
            }
        });

    }

    @Override
    public void listaVariablesExamenesVacia(final String msg) {
    }

    @Override
    public void errorObtenerVariablesExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerVariablesExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void parasitosObtenidos(final List<Parasito> parasitos) {
        final List<ParasitoDisponible> parasitosDisponibles = new ArrayList<>();
        parasitos.forEach((parasito) -> {
            parasitosDisponibles.add(new ParasitoDisponible(new ParasitoEncontrado(null, parasito, null, 1), false));
        });
        tableModelParasitosMuestraBiologica.setParasitosDisponibles(parasitosDisponibles);
        JTBLParasitosMuestraBiologica.getTableHeader().setReorderingAllowed(false);

        final int lengthRow = JTBLParasitosMuestraBiologica.getModel().getRowCount();
        resultadoGeneralPersonalizado.getParasitosEncontrados().forEach((parasitoEncontrado) -> {
            for (int i = 0; i < lengthRow; i++) {
                if (tableModelParasitosMuestraBiologica.getParasitosDisponibles().get(i).getParasitoEncontrado().getParasito().getCodigoParasito() == parasitoEncontrado.getParasito().getCodigoParasito()) {
                    tableModelParasitosMuestraBiologica.setValueAt(true, i, 3);
                    jComboBoxObservacionesParasitarias.setSelectedIndex(getIndexObservacionSeleccionada(parasitoEncontrado));
                    tableModelParasitosMuestraBiologica.setValueAt(jComboBoxObservacionesParasitarias.getSelectedItem().toString(), i, 2);
                }
            }
        });
    }

    @Override
    public void listaParasitosVacia(final String msg) {
    }

    @Override
    public void errorObtenerParasitos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerParasitos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void posiblesResultadosObtenidos(final List<ExamenPosibleResultado> examenesPosiblesResultados) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        examenesPosiblesResultados.forEach((examenPosibleResultado) -> {
            defaultComboBoxModel.addElement(new ItemPosibleResultado(examenPosibleResultado.getCodigoPosibleResultado(), examenPosibleResultado.getExamen(), examenPosibleResultado.getPosibleResultadoNombre(), examenPosibleResultado.getPosibleResultadoEstado()));
        });
        JCMBXExamenPosibleResultado.setModel(defaultComboBoxModel);
        JCMBXExamenPosibleResultado.setSelectedIndex(-1);

        JCMBXExamenPosibleResultado.setSelectedIndex(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado() == null ? -1 : getIndexExamenPosibleResultadoSeleccionado(resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado()));
    }

    @Override
    public void listaPosiblesResultadosVacia(final String msg) {

    }

    @Override
    public void errorObtenerPosiblesResultados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPosiblesResultados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void seguimientoObtenido(final List<SeguimientoPaciente> seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente.get(0);
        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimiento del Paciente", JPANELSeguimientoPaciente);
        JLBLPacienteEnSeguimiento.setText(seguimientoPaciente.get(0).getPaciente().getPersona().getPersonaApellido() + " " + seguimientoPaciente.get(0).getPaciente().getPersona().getPersonaNombre());
        JLBLFechaInicioDeSeguimiento.setText(seguimientoPaciente.get(0).getFechaInicio().toString());
        JLBLHoraInicioDeSeguimiento.setText(seguimientoPaciente.get(0).getHoraInicio().toString());
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setText(seguimientoPaciente.get(0).getDetallesObservacionesInicio());
    }

    @Override
    public void seguimientoNoEncontrado(final String msg) {
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorObtenerSeguimiento(final String msg) {
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerSeguimiento(final String msg) {
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void resultadoExiste(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarExistenciaResultado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void resultadoGeneralModificado(final String msg) {
        dispose();
    }

    @Override
    public void errorModificarResultadoGeneral(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoModificarResultadoGeneral(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void tecnicasAgregadasObtenidas(final List<Tecnica> tecnicasAgregadas) {
        final List<TecnicaDisponible> tecnicasDisponibles = new ArrayList<>();
        tecnicasAgregadas.forEach((tecnicaAgregada) -> {
            tecnicasDisponibles.add(new TecnicaDisponible(new TecnicaAplicada(null, tecnicaAgregada, 1), false));
        });

        tableModelTecnicasMetodos.setTecnicasDisponibles(tecnicasDisponibles);
        JTBLTecnicas.getTableHeader().setReorderingAllowed(false);

        final int lengthRow = JTBLTecnicas.getModel().getRowCount();
        resultadoGeneralPersonalizado.getTecnicasAplicadas().forEach((tecnicaAplicada) -> {
            for (int i = 0; i < lengthRow; i++) {
                if (tableModelTecnicasMetodos.getTecnicasDisponibles().get(i).getTecnicaAplicada().getTecnica().getCodigoTecnica() == tecnicaAplicada.getTecnica().getCodigoTecnica()) {
                    tableModelTecnicasMetodos.setValueAt(true, i, 3);
                }
            }
        });
    }

    @Override
    public void listaTecnicasAgregadasVacia(final String msg) {
    }

    @Override
    public void errorObtenerTecnicasAgregadas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerTecnicasAgregadas(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void enfermedadesObtenidas(final List<Enfermedad> enfermedades) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        enfermedades.forEach((enfermedad) -> {
            defaultComboBoxModel.addElement(new ItemEnfermedad(enfermedad.getCodigoEnfermedad(), null, enfermedad.getEnfermedadNombre(), enfermedad.getEnfermedadEstado()));
        });
        JCMBXEnfermedad.setModel(defaultComboBoxModel);
        JCMBXEnfermedad.setSelectedIndex(-1);

        JCMBXEnfermedad.setSelectedIndex(resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad() == null ? -1 : getIndexEnfermedadSeleccionada(resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad()));
    }

    @Override
    public void listaEnfermedadesVacia(final String msg) {
    }

    @Override
    public void errorObtenerEnfermedades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerEnfermedades(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void permisoConcedido() {

    }

    @Override
    public void permisoNegado(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarPermitirModificacion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoVerificarPermitirModificacion(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void esAntecedente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorVerificarSiResultadoEsAntecedente(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }
}
