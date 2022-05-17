package View.GestionRecepciones;

import Model.POJO.AspectoCalidad;
import Model.POJO.Enfermedad;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.PersonalTecnico;
import Model.POJO.ExamenSolicitado;
import Model.POJO.Parasito;
import Model.POJO.ParasitoEncontrado;
import Model.POJO.ResultadoGeneral;
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
import Presenter.GestionPersonalTecnico.PresenterGestionPersonalTecnico;
import Presenter.GestionRecepciones.PresenterGestionResultadoGeneral;
import Presenter.GestionSubespecialidades.PresenterGestionSubespecialidades;
import View.Utilitarios.Utilidades;
import View.Utilitarios.ModelTable.GestionRecepciones.ParasitoDisponible;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelParasitosMuestraBiologica;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelResultadosVariables;
import View.Utilitarios.ModelTable.GestionRecepciones.TableModelTecnicasMetodos;
import View.Utilitarios.ModelTable.GestionRecepciones.TecnicaDisponible;
import View.Utilitarios.ModeloItemComboBox.ItemAspectoCalidad;
import View.Utilitarios.ModeloItemComboBox.ItemEnfermedad;
import View.Utilitarios.ModeloItemComboBox.ItemPersonalTecnico;
import View.Utilitarios.ModeloItemComboBox.ItemPosibleResultado;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Brynner
 */
public class IngresarResultados extends javax.swing.JDialog implements PresenterGestionMuestrasBiologicas.CallBackObtenerAspectos, PresenterGestionPersonalTecnico.CallBackObtenerPersonalesTecnicos, PresenterGestionVariablesExamen.CallBackObtenerVariablesExamenes, PresenterGestionMuestrasBiologicas.CallBackObtenerParasitos, PresenterGestionExamenes.CallBackObtenerPosiblesResultados, PresenterGestionPacientes.CallBackObtenerSeguimiento, PresenterGestionResultadoGeneral.CallBackVerificarResultadoExiste, PresenterGestionResultadoGeneral.CallBackRegistrarResultadoGeneral, PresenterGestionExamenes.CallBackObtenerTecnicasAgregadas, PresenterGestionSubespecialidades.CallBackObtenerEnfermedades {

    private final TableModelResultadosVariables tableModelResultadosVariables;
    private final TableModelParasitosMuestraBiologica tableModelParasitosMuestraBiologica;
    private final TableModelTecnicasMetodos tableModelTecnicasMetodos;

    private final PresenterGestionMuestrasBiologicas presenterGestionMuestrasBiologicas;
    private final PresenterGestionPersonalTecnico presenterGestionPersonalTecnico;
    private final PresenterGestionVariablesExamen presenterGestionVariablesExamen;
    private final PresenterGestionExamenes presenterGestionExamenes;
    private final PresenterGestionResultadoGeneral presenterGestionResultadoGeneral;
    private final PresenterGestionPacientes presenterGestionPacientes;
    private final PresenterGestionSubespecialidades presenterGestionSubespecialidades;

    private final JComboBox jComboBoxObservacionesParasitarias;

    private final PersonalTecnico personalTecnicoResultados;
    private ExamenSolicitado examenSolicitado;
    private SeguimientoPaciente seguimientoPaciente;

    public IngresarResultados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        presenterGestionMuestrasBiologicas = new PresenterGestionMuestrasBiologicas();
        presenterGestionPersonalTecnico = new PresenterGestionPersonalTecnico();
        presenterGestionVariablesExamen = new PresenterGestionVariablesExamen();
        presenterGestionExamenes = new PresenterGestionExamenes();
        presenterGestionResultadoGeneral = new PresenterGestionResultadoGeneral();
        presenterGestionPacientes = new PresenterGestionPacientes();
        presenterGestionSubespecialidades = new PresenterGestionSubespecialidades();

        presenterGestionMuestrasBiologicas.setCallBackObtenerAspectos(this);
        presenterGestionPersonalTecnico.setCallBackObtenerPersonalesTecnicos(this);
        presenterGestionVariablesExamen.setCallBackObtenerVariablesExamenes(this);
        presenterGestionMuestrasBiologicas.setCallBackObtenerParasitos(this);
        presenterGestionExamenes.setCallBackObtenerPosiblesResultados(this);
        presenterGestionResultadoGeneral.setCallBackVerificarResultadoExiste(this);
        presenterGestionResultadoGeneral.setCallBackRegistrarResultadoGeneral(this);
        presenterGestionPacientes.setCallBackObtenerSeguimiento(this);
        presenterGestionExamenes.setCallBackObtenerTecnicasAgregadas(this);
        presenterGestionSubespecialidades.setCallBackObtenerEnfermedades(this);

        personalTecnicoResultados = Utilidades.obtenerCuentaLocal().getPersonalTecnico();

        jComboBoxObservacionesParasitarias = new JComboBox();
        jComboBoxObservacionesParasitarias.addItem("MICROSCOPICA");
        jComboBoxObservacionesParasitarias.addItem("MACROSCOPICA");

        tableModelResultadosVariables = new TableModelResultadosVariables(true);
        tableModelParasitosMuestraBiologica = new TableModelParasitosMuestraBiologica();
        tableModelTecnicasMetodos = new TableModelTecnicasMetodos();

        initComponents();

        JBTNGuardar.addActionListener(action);
    }

    public void setExamenSolicitado(ExamenSolicitado examenSolicitado) {
        this.examenSolicitado = examenSolicitado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBTNCancelar = new javax.swing.JButton();
        JBTNActualizar = new javax.swing.JButton();
        JBTNGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTBLResultadosExamen = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTBLParasitosMuestraBiologica = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTBLTecnicas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        JLBLContadorObservaciones = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTXTAREAObservaciones = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        JLBLContadorRecomendaciones = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        JTXTAREARecomendaciones = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        JCMBXEnfermedad = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        JCMBXExamenPosibleResultado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JDTCHOOSERFechaTomaMuestra = new com.toedter.calendar.JDateChooser();
        JTABBEDPANEResultadosSeguimientoPaciente = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
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
        JDTCHOOSERFechaFinalAnalisis = new com.toedter.calendar.JDateChooser();
        jLabel32 = new javax.swing.JLabel();
        java.util.Date date = new java.util.Date();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        JSPNHoraFinalAnalisis = new javax.swing.JSpinner(spinnerDateModel);
        JCMBXResponsableAnalisis = new javax.swing.JComboBox<>();
        JCMBXIncorporarASeguimiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JPANELSeguimientoPaciente = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        JLBLPacienteEnSeguimiento = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLBLFechaInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLBLHoraInicioDeSeguimiento = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JCMBXBaciloscopiaControl = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIET - Ingresar Resultados de Análisis");
        setIconImage(new ImageIcon(getClass().getResource("/View/icons/logo_ceretrop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JBTNCancelar.setText("CANCELAR");
        JBTNCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNCancelarActionPerformed(evt);
            }
        });

        JBTNActualizar.setText("ACTUALIZAR");
        JBTNActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNActualizarActionPerformed(evt);
            }
        });

        JBTNGuardar.setText("GUARDAR");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de Análisis"));

        JTBLResultadosExamen.setModel(tableModelResultadosVariables);
        JTBLResultadosExamen.setRowHeight(20);
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

        jTabbedPane1.addTab("Variables de Exámen", jPanel2);

        JTBLParasitosMuestraBiologica.setModel(tableModelParasitosMuestraBiologica);
        JTBLParasitosMuestraBiologica.setRowHeight(20);
        JTBLParasitosMuestraBiologica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTBLParasitosMuestraBiologica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTBLParasitosMuestraBiologicaMousePressed(evt);
            }
        });
        defaultTableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);

        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(0).setPreferredWidth(40);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(1).setPreferredWidth(700);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(2).setPreferredWidth(150);
        JTBLParasitosMuestraBiologica.getColumnModel().getColumn(3).setPreferredWidth(100);

        final TableColumn tableColumn = JTBLParasitosMuestraBiologica.getColumnModel().getColumn(2);
        tableColumn.setCellEditor(new DefaultCellEditor(jComboBoxObservacionesParasitarias));
        jScrollPane2.setViewportView(JTBLParasitosMuestraBiologica);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Parásitos de Muestra Biológica", jPanel4);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Técnias/Métodos", jPanel5);

        jLabel15.setText("OBSERVACIONES:");

        JLBLContadorObservaciones.setText("0");

        jLabel16.setText("/200");

        JTXTAREAObservaciones.setColumns(20);
        JTXTAREAObservaciones.setLineWrap(true);
        JTXTAREAObservaciones.setRows(5);
        JTXTAREAObservaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREAObservacionesFocusGained(evt);
            }
        });
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
        jScrollPane6.setViewportView(JTXTAREAObservaciones);

        jLabel17.setText("RECOMENDACIONES:");

        JLBLContadorRecomendaciones.setText("0");

        jLabel18.setText("/200");

        JTXTAREARecomendaciones.setColumns(20);
        JTXTAREARecomendaciones.setLineWrap(true);
        JTXTAREARecomendaciones.setRows(5);
        JTXTAREARecomendaciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTXTAREARecomendacionesFocusGained(evt);
            }
        });
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
        jScrollPane7.setViewportView(JTXTAREARecomendaciones);

        jLabel19.setText("ENFERMEDAD:");

        JCMBXEnfermedad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXEnfermedadItemStateChanged(evt);
            }
        });

        jLabel20.setText("RESULTADO O INTERPRETACION:");

        jLabel1.setText("FECHA DE TOMA DE MUESTRA");

        JDTCHOOSERFechaTomaMuestra.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(JDTCHOOSERFechaTomaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 253, Short.MAX_VALUE))
                    .addComponent(JCMBXEnfermedad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(JCMBXExamenPosibleResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
                        .addComponent(jScrollPane7)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBLContadorObservaciones)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel16))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLBLContadorRecomendaciones)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18)))
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCMBXEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCMBXExamenPosibleResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JDTCHOOSERFechaTomaMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jLabel16)
                        .addComponent(JLBLContadorObservaciones))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(JLBLContadorRecomendaciones))
                        .addComponent(jLabel17))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Observaciones/Recomendaciones/Resultado o Interpretación", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        JDTCHOOSERFechaFinalAnalisis.setDate(Calendar.getInstance().getTime());
        JDTCHOOSERFechaFinalAnalisis.setDateFormatString("yyyy-MM-dd");

        jLabel32.setText("HORA FINAL DE ANALISIS:");

        JSPNHoraFinalAnalisis.setEditor(new JSpinner.DateEditor(JSPNHoraFinalAnalisis, "HH:mm:ss"));

        JCMBXIncorporarASeguimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));
        JCMBXIncorporarASeguimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCMBXIncorporarASeguimientoItemStateChanged(evt);
            }
        });

        jLabel5.setText("¿INCORPORAR A SEGUIMIENTO?");

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
                    .addComponent(JSPNHoraFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JCMBXResponsableAnalisis, 0, 300, Short.MAX_VALUE)
                    .addComponent(JDTCHOOSERFechaFinalAnalisis, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(JCMBXIncorporarASeguimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCMBXResponsableAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLBLResponsableIntroduccionResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDTCHOOSERFechaFinalAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JSPNHoraFinalAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBXIncorporarASeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Resultados Generales", jPanel6);

        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setColumns(20);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setLineWrap(true);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setRows(5);
        JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento.setEnabled(false);
        jScrollPane5.setViewportView(JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento);

        jLabel6.setText("PACIENTE EN SEGUIMIENTO:");

        JLBLPacienteEnSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("BACILOSCOPIA DE CONTROL:");

        jLabel10.setText("FECHA INICIO DE SEGUIMIENTO:");

        JLBLFechaInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("HORA INICIO DE SEGUIMIENTO:");

        JLBLHoraInicioDeSeguimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("DETALLES U OBSERVACIONES REGISTRADAS AL INICIO DEL SEGUIMIENTO:");

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
                        .addComponent(JLBLHoraInicioDeSeguimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addContainerGap())
        );

        JTABBEDPANEResultadosSeguimientoPaciente.addTab("Seguimientos del Paciente", JPANELSeguimientoPaciente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBTNCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBTNGuardar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTABBEDPANEResultadosSeguimientoPaciente))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JTABBEDPANEResultadosSeguimientoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNCancelar)
                    .addComponent(JBTNActualizar)
                    .addComponent(JBTNGuardar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            if (examenSolicitado == null || personalTecnicoResultados == null) {
                JOptionPane.showMessageDialog(this, "Parámatro(s) no recibido(s), vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
                dispose();

            } else {
                JTABBEDPANEResultadosSeguimientoPaciente.removeTabAt(1);
                JLBLResponsableIntroduccionResultados.setText(personalTecnicoResultados.getPersona().getPersonaApellido() + " " + personalTecnicoResultados.getPersona().getPersonaNombre());

                JLBLExamenSolicitado.setText(examenSolicitado.getExamen().getExamenNombre());
                JLBLMuestraBiologica.setText(examenSolicitado.getMuestraBiologica().getMuestraBiologicaTipo());

                if (examenSolicitado.getTotalMuestrasBiologicas() == 1) {
                    JCMBXNumeroMuestraBiologica.addItem("1ra. Muestra");
                } else {
                    JCMBXNumeroMuestraBiologica.addItem("1ra. Muestra");
                    JCMBXNumeroMuestraBiologica.addItem("2da. Muestra");
                }

                JLBLEstadoMuestraBiologica.setText(examenSolicitado.getMuestraBiologicaEstado());

                JDTCHOOSERFechaTomaMuestra.setDate(examenSolicitado.getRecepcion().getFechaRecepcion());

                presenterGestionMuestrasBiologicas.obtenerAspectos(examenSolicitado.getMuestraBiologica());
                presenterGestionPersonalTecnico.obtenerPersonalesTecnicos();
                presenterGestionVariablesExamen.obtenerVariablesExamen(examenSolicitado.getExamen());
                presenterGestionMuestrasBiologicas.obtenerParasitos(examenSolicitado.getMuestraBiologica());
                presenterGestionExamenes.obtenerPosiblesResultados(examenSolicitado.getExamen());
                presenterGestionExamenes.obtenerTecnicasAgregadas(examenSolicitado.getExamen());
                presenterGestionSubespecialidades.obtenerEnfermedades(examenSolicitado.getExamen().getSubespecialidad());

            }
        } catch (final HeadlessException headlessException) {
            System.err.println("Se produjo un error: " + headlessException.getMessage());
            JOptionPane.showMessageDialog(rootPane, "Se produjo un error, vuelve a intentarlo.", "SIET", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    private void JBTNCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JBTNCancelarActionPerformed

    private void JBTNActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_JBTNActualizarActionPerformed

    private void JTBLParasitosMuestraBiologicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTBLParasitosMuestraBiologicaMousePressed
        final int currentRow = JTBLParasitosMuestraBiologica.rowAtPoint(evt.getPoint());
        JTBLParasitosMuestraBiologica.setRowSelectionInterval(currentRow, currentRow);
    }//GEN-LAST:event_JTBLParasitosMuestraBiologicaMousePressed

    private void JCMBXIncorporarASeguimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXIncorporarASeguimientoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 0) {
                if (JTABBEDPANEResultadosSeguimientoPaciente.getTabCount() > 1) {
                    JCMBXBaciloscopiaControl.setSelectedIndex(-1);
                    JTABBEDPANEResultadosSeguimientoPaciente.removeTabAt(1);
                }
            } else {
                presenterGestionPacientes.obtenerSeguimiento(examenSolicitado.getRecepcion().getPaciente(), examenSolicitado);
            }
        }
    }//GEN-LAST:event_JCMBXIncorporarASeguimientoItemStateChanged

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

    private void JTXTAREAObservacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREAObservacionesFocusGained
        JTXTAREAObservaciones.selectAll();
    }//GEN-LAST:event_JTXTAREAObservacionesFocusGained

    private void JTXTAREARecomendacionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JTXTAREARecomendacionesFocusGained
        JTXTAREARecomendaciones.selectAll();
    }//GEN-LAST:event_JTXTAREARecomendacionesFocusGained

    private void JCMBXEnfermedadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCMBXEnfermedadItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (examenSolicitado.getExamen().getExamenNombre().equals("HEMOGRAMA")) {
                switch (JCMBXEnfermedad.getSelectedItem().toString()) {
                    case "MALARIA MIXTA":
                    case "MALARIA POR P. FALCIPARUM":
                    case "MALARIA POR P. VIVAX": {
                        final int positionGotaGruesa = tableModelResultadosVariables.getRowPosition("GOTA GRUESA");
                        final Object valueGotaGruesa = tableModelResultadosVariables.getValueAt(positionGotaGruesa, 2);
                        if (valueGotaGruesa == null) {
                            JOptionPane.showMessageDialog(rootPane, "Debes indicar el resultado de GOTA GRUESA antes de seleccionar la enfermedad.\nLos resultados posibles para GOTA GRUESA son: POSITIVO o NEGATIVO", "SIET", JOptionPane.ERROR_MESSAGE);
                            JCMBXEnfermedad.setSelectedIndex(-1);
                        } else {
                        }
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_JCMBXEnfermedadItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            IngresarResultados dialog = new IngresarResultados(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton JBTNActualizar;
    private javax.swing.JButton JBTNCancelar;
    private javax.swing.JButton JBTNGuardar;
    private javax.swing.JComboBox<View.Utilitarios.ModeloItemComboBox.ItemAspectoCalidad> JCMBXAspecto;
    private javax.swing.JComboBox<String> JCMBXBaciloscopiaControl;
    private javax.swing.JComboBox<ItemEnfermedad> JCMBXEnfermedad;
    private javax.swing.JComboBox<ItemPosibleResultado> JCMBXExamenPosibleResultado;
    private javax.swing.JComboBox<String> JCMBXIncorporarASeguimiento;
    private javax.swing.JComboBox<String> JCMBXNumeroMuestraBiologica;
    private javax.swing.JComboBox<View.Utilitarios.ModeloItemComboBox.ItemPersonalTecnico> JCMBXResponsableAnalisis;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaFinalAnalisis;
    private com.toedter.calendar.JDateChooser JDTCHOOSERFechaTomaMuestra;
    private javax.swing.JLabel JLBLContadorObservaciones;
    private javax.swing.JLabel JLBLContadorRecomendaciones;
    private javax.swing.JLabel JLBLEstadoMuestraBiologica;
    private javax.swing.JLabel JLBLExamenSolicitado;
    private javax.swing.JLabel JLBLFechaInicioDeSeguimiento;
    private javax.swing.JLabel JLBLHoraInicioDeSeguimiento;
    private javax.swing.JLabel JLBLMuestraBiologica;
    private javax.swing.JLabel JLBLPacienteEnSeguimiento;
    private javax.swing.JLabel JLBLResponsableIntroduccionResultados;
    private javax.swing.JPanel JPANELSeguimientoPaciente;
    private javax.swing.JSpinner JSPNHoraFinalAnalisis;
    private javax.swing.JTabbedPane JTABBEDPANEResultadosSeguimientoPaciente;
    private javax.swing.JTable JTBLParasitosMuestraBiologica;
    private javax.swing.JTable JTBLResultadosExamen;
    private javax.swing.JTable JTBLTecnicas;
    private javax.swing.JTextArea JTXTAREAObservaciones;
    private javax.swing.JTextArea JTXTAREAObservacionesRegistradasAlInicioDelSeguimiento;
    private javax.swing.JTextArea JTXTAREARecomendaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        tableModelResultadosVariables.limpiarLista();
        presenterGestionVariablesExamen.obtenerVariablesExamen(examenSolicitado.getExamen());
    }

    private void guardar() {
        final String numeroMuestraBiologica = JCMBXNumeroMuestraBiologica.getSelectedItem().toString();
        final ItemPersonalTecnico itemPersonalTecnico = (ItemPersonalTecnico) JCMBXResponsableAnalisis.getSelectedItem();
        final PersonalTecnico personalTecnicoAnalisis = new PersonalTecnico(itemPersonalTecnico.getCodigoPersonalTecnico(), itemPersonalTecnico.getPersona(), itemPersonalTecnico.getPertecProfesion(), itemPersonalTecnico.getPertecFechaInicio(), itemPersonalTecnico.getPertecHoraInicio(), itemPersonalTecnico.getPertecHabilitado());
        final Date fechaFinalAnalisis = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaFinalAnalisis.getDate()));
        final Time horaFinalAnalisis = Time.valueOf(new JSpinner.DateEditor(JSPNHoraFinalAnalisis, "HH:mm:ss").getFormat().format(JSPNHoraFinalAnalisis.getValue()));
        final String baciloscopiaControl = JCMBXIncorporarASeguimiento.getSelectedIndex() == 1 && seguimientoPaciente != null && JCMBXBaciloscopiaControl.getSelectedIndex() != -1 ? JCMBXBaciloscopiaControl.getSelectedItem().toString() : "";
        final List<ResultadoVariable> resultadosVariables = tableModelResultadosVariables.obtenerResultadoVariablesNoVacias();
        final List<ParasitoEncontrado> parasitosEncontrados = tableModelParasitosMuestraBiologica.obtenerParasitosEncontrados();
        final List<TecnicaAplicada> tecnicasAplicadas = tableModelTecnicasMetodos.obtenerTecnicasAplicadas();
        final String observaciones = JTXTAREAObservaciones.getText().trim().isEmpty() ? "" : JTXTAREAObservaciones.getText();
        final String recomendaciones = JTXTAREARecomendaciones.getText().trim().isEmpty() ? "" : JTXTAREARecomendaciones.getText();
        final Date fechaTomaMuestra = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(JDTCHOOSERFechaTomaMuestra.getDate()));

        AspectoCalidad aspecto = null;
        if (JCMBXAspecto.getSelectedIndex() != -1) {
            final ItemAspectoCalidad itemAspecto = (ItemAspectoCalidad) JCMBXAspecto.getSelectedItem();
            aspecto = new AspectoCalidad(itemAspecto.getCodigoAspectoCalidad(), null, itemAspecto.getAspectoCalidad(), itemAspecto.getAspectoCalidadEstado());
        }

        ExamenPosibleResultado examenPosibleResultado = null;
        if (JCMBXExamenPosibleResultado.getSelectedIndex() != -1) {
            final ItemPosibleResultado itemPosibleResultado = (ItemPosibleResultado) JCMBXExamenPosibleResultado.getSelectedItem();
            examenPosibleResultado = new ExamenPosibleResultado(itemPosibleResultado.getCodigoPosibleResultado(), itemPosibleResultado.getExamen(), itemPosibleResultado.getPosibleResultadoNombre(), itemPosibleResultado.getPosibleResultadoEstado());
        }

        Enfermedad enfermedad = null;
        if (JCMBXEnfermedad.getSelectedIndex() != -1) {
            final ItemEnfermedad itemEnfermedad = (ItemEnfermedad) JCMBXEnfermedad.getSelectedItem();
            enfermedad = new Enfermedad(itemEnfermedad.getCodigoEnfermedad(), null, itemEnfermedad.getEnfermedadNombre(), itemEnfermedad.getEnfermedadEstado());
        }

        final ResultadoGeneral resultadoGeneral = new ResultadoGeneral(personalTecnicoAnalisis, personalTecnicoResultados, examenSolicitado, aspecto, seguimientoPaciente, examenPosibleResultado, enfermedad, numeroMuestraBiologica, fechaTomaMuestra, fechaFinalAnalisis, horaFinalAnalisis, baciloscopiaControl, observaciones, recomendaciones);
        presenterGestionResultadoGeneral.registrarResultadoAnalisis(new ResultadoGeneralPersonalizado(resultadoGeneral, resultadosVariables, parasitosEncontrados, tecnicasAplicadas));
    }

    private final Action action = new AbstractAction() {
        @Override
        public void actionPerformed(final ActionEvent e) {
            if (JCMBXNumeroMuestraBiologica.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el número de la muestra biológica.", "SIET", JOptionPane.ERROR_MESSAGE);
                JDTCHOOSERFechaFinalAnalisis.requestFocus();
            } else if (JCMBXResponsableAnalisis.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona el responsable del análisis.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXResponsableAnalisis.requestFocus();
            } else if (JDTCHOOSERFechaFinalAnalisis.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha final del análisis.", "SIET", JOptionPane.ERROR_MESSAGE);
                JDTCHOOSERFechaFinalAnalisis.requestFocus();
            } else if (JSPNHoraFinalAnalisis.getValue() == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la hora final del análisis.", "SIET", JOptionPane.ERROR_MESSAGE);
                JSPNHoraFinalAnalisis.requestFocus();
            } else if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 1 && seguimientoPaciente == null) {
                JOptionPane.showMessageDialog(rootPane, "El paciente no posee seguimientos activos.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXIncorporarASeguimiento.setSelectedIndex(0);
            } else if (JCMBXIncorporarASeguimiento.getSelectedIndex() == 1 && seguimientoPaciente != null && JCMBXBaciloscopiaControl.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la baciloscopia de control.", "SIET", JOptionPane.ERROR_MESSAGE);
                JCMBXIncorporarASeguimiento.setSelectedIndex(0);
            } else if (JDTCHOOSERFechaTomaMuestra.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Selecciona la fecha de toma de muestra.", "SIET", JOptionPane.ERROR_MESSAGE);
                JDTCHOOSERFechaFinalAnalisis.requestFocus();
            } else if (tableModelResultadosVariables.resultadosVacios() && JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Debes ingresar los resultados en la tabla y/o ingresar un resultado o interpretación del análisis.", "SIET", JOptionPane.ERROR_MESSAGE);
            } else {
                switch (examenSolicitado.getExamen().getExamenNombre()) {
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
                        if (JCMBXAspecto.getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el aspecto de la muestra.", "SIET", JOptionPane.ERROR_MESSAGE);
                            JCMBXAspecto.requestFocus();
                        } else if (JCMBXEnfermedad.getSelectedIndex() == -1 || !JCMBXEnfermedad.getSelectedItem().toString().equals("TUBERCULOSIS")) {
                            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar la enfermedad de TUBERCULOSIS paraque pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                            JCMBXEnfermedad.requestFocus();
                        } else if (JCMBXExamenPosibleResultado.getSelectedIndex() == -1) {
                            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar el resultado o la interpretación: POSITIVO o NEGATIVO para que pueda contabilizarse en el SNIS.", "SIET", JOptionPane.ERROR_MESSAGE);
                            JCMBXExamenPosibleResultado.requestFocus();
                        } else if (tableModelResultadosVariables.resultadosVacios()) {
                            JOptionPane.showMessageDialog(rootPane, "Debes ingresar los resultados en la tabla.", "SIET", JOptionPane.ERROR_MESSAGE);
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
                        } else if (tableModelResultadosVariables.resultadosVacios()) {
                            JOptionPane.showMessageDialog(rootPane, "Debes ingresar los resultados en la tabla.", "SIET", JOptionPane.ERROR_MESSAGE);
                        } else  {    
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
        }
    };

    @Override
    public void aspectosObtenidos(final List<AspectoCalidad> aspectos) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        aspectos.forEach((aspecto) -> {
            defaultComboBoxModel.addElement(new ItemAspectoCalidad(aspecto.getCodigoAspectoCalidad(), aspecto.getAspectoCalidad(), aspecto.getAspectoCalidadEstado()));
        });
        JCMBXAspecto.setModel(defaultComboBoxModel);
        JCMBXAspecto.setSelectedIndex(-1);
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
    public void personalesTecnicosObtenidos(final List<PersonalTecnico> personalesTecnicos) {
        final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        personalesTecnicos.forEach((personalTecnico) -> {
            defaultComboBoxModel.addElement(new ItemPersonalTecnico(personalTecnico.getCodigoPersonalTecnico(), personalTecnico.getPersona(), personalTecnico.getPertecProfesion(), personalTecnico.getPertecFechaInicio(), personalTecnico.getPertecHoraInicio(), personalTecnico.getPertecHabilitado()));
        });
        JCMBXResponsableAnalisis.setModel(defaultComboBoxModel);
        JCMBXResponsableAnalisis.setSelectedIndex(-1);
    }

    @Override
    public void listaPersonalesTecnicosVacia(final String msg) {
    }

    @Override
    public void errorObtenerPersonalesTecnicos(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPersonalesTecnicos(String msg) {
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
    }

    @Override
    public void listaVariablesExamenesVacia(final String msg) {
    }

    @Override
    public void errorObtenerVariablesExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void errorDesconocidoObtenerVariablesExamenes(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        dispose();
    }

    @Override
    public void parasitosObtenidos(final List<Parasito> parasitos) {
        final List<ParasitoDisponible> parasitosDisponibles = new ArrayList<>();
        parasitos.forEach((parasito) -> {
            parasitosDisponibles.add(new ParasitoDisponible(new ParasitoEncontrado(null, parasito, null, 1), false));
        });
        tableModelParasitosMuestraBiologica.setParasitosDisponibles(parasitosDisponibles);
        JTBLParasitosMuestraBiologica.getTableHeader().setReorderingAllowed(false);
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
    }

    @Override
    public void listaPosiblesResultadosVacia(final String msg) {

    }

    @Override
    public void errorObtenerPosiblesResultados(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoObtenerPosiblesResultados(String msg) {
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
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
    }

    @Override
    public void errorObtenerSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
    }

    @Override
    public void errorDesconocidoObtenerSeguimiento(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
        JCMBXIncorporarASeguimiento.setSelectedIndex(0);
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
    public void resultadoAnalisisRegistrado(final String msg) {
        dispose();
    }

    @Override
    public void errorRegistrarResultadoAnalisis(final String msg) {
        JOptionPane.showMessageDialog(this, msg, "SIET", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void errorDesconocidoRegistrarResultadoAnalisis(final String msg) {
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
}