package Model.DAO.GestionReportes;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.AspectoCalidad;
import Model.POJO.Conexion;
import Model.POJO.Enfermedad;
import Model.POJO.Especialidad;
import Model.POJO.Examen;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.ExamenSolicitado;
import Model.POJO.GrupoVariables;
import Model.POJO.LogConsulta;
import Model.POJO.MuestraBiologica;
import Model.POJO.Parasito;
import Model.POJO.ParasitoEncontrado;
import Model.POJO.PersonalTecnico;
import Model.POJO.Recepcion;
import Model.POJO.ResultadoGeneral;
import Model.POJO.SeguimientoPaciente;
import Model.POJO.Subespecialidad;
import Model.POJO.Tecnica;
import Model.POJO.TecnicaAplicada;
import Model.POJO.VariableExamenInformePersonalizado;
import Model.POJOPersonalizado.GrupoVariablesInformePersonalizado;
import Model.POJOPersonalizado.ResultadoGeneralReportePersonalizado;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLInformeMensualLaboratorio {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";

    private final String SQL_OBTENER_RECEPCIONES_MENSUAL = "SELECT * FROM arecepc INNER JOIN aexasol ON aexasol.faescodrec = arecepc.parecodrec INNER JOIN aexamen ON aexamen.paemcodexa = aexasol.faescodexa INNER JOIN amuebio ON amuebio.pambcomubi = aexasol.faescomubi INNER JOIN aresgen ON aresgen.fargcoexso = aexasol.paescoexso INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub INNER JOIN aespeci ON aespeci.paeecodesp = asubesp.fasecodesp WHERE careestado = 1 AND date_part('month', carefecrec) = ? AND date_part('year', carefecrec) = ?";
    private final String SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL = "SELECT * FROM aaspcal WHERE paaccoasca IN (SELECT fargcoasca FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_SEGUIMIENTO_PACIENTE = "SELECT * FROM asegpac WHERE paspcosepa IN (SELECT fargcosepa FROM aresgen WHERE pargcorege = ?) AND faspcodexa = ?";
    private final String SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL = "SELECT * FROM aexpore WHERE paeocopore IN (SELECT fargcopore FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL = "SELECT * FROM aenferm WHERE paeecodenf IN (SELECT fargcodenf FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_PARASITOS_ENCONTRADOS = "SELECT * FROM aparenc INNER JOIN aparasi ON aparasi.papacodpar = aparenc.fapecodpar WHERE fapecorege = ? AND capepaenes = 1";
    private final String SQL_OBTENER_TECNICAS_APLICADAS = "SELECT * FROM atecapl INNER JOIN atecnic ON atecnic.patncodtec = atecapl.fatacodtec WHERE fatacorege = ? AND catateapes = 1 ORDER BY atecapl.patacoteap DESC";
    private final String SQL_OBTENER_GRUPOS_VARIABLES = "SELECT * FROM agruvar WHERE pagvcogrva IN (SELECT favecogrva FROM avarexa WHERE pavecovaex IN (SELECT farvcovaex FROM aresvar WHERE farvcorege = ? AND carvrevaes = 1))";
    private final String SQL_OBTENER_VARIABLES = "SELECT * FROM avarexa WHERE favecogrva = ? AND pavecovaex IN (SELECT farvcovaex FROM aresvar WHERE farvcorege = ? AND carvrevaes = 1)";
    private final String SQL_OBTENER_RESULTADO_VARIABLE = "SELECT carvresvar FROM aresvar WHERE farvcorege = ? AND farvcovaex = ? AND carvrevaes = 1";
    private final String SQL_OBTENER_RECEPCIONES_MENSUAL_CON_MUESTRAS_REFERIDAS_POR_EL_LABORATORIO = "SELECT * FROM arecepc INNER JOIN aexasol ON aexasol.faescodrec = arecepc.parecodrec INNER JOIN aexamen ON aexamen.paemcodexa = aexasol.faescodexa INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub INNER JOIN aespeci ON aespeci.paeecodesp = asubesp.fasecodesp INNER JOIN amuebio ON amuebio.pambcomubi = aexasol.faescomubi WHERE arecepc.careestado = 1 AND aexasol.caesmubies = 'REFERIDO POR EL LABORATORIO' AND date_part('month', carefecrec) = ? AND date_part('year', carefecrec) = ?";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private ResultSet resultSetAux1;
    private ResultSet resultSetAux2;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLInformeMensualLaboratorio() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        resultSetAux1 = null;
        resultSetAux2 = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public List<ResultadoGeneralReportePersonalizado> obtenerResultadosGenerales(final int month, final int year) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RECEPCIONES_MENSUAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SEGUIMIENTO_PACIENTE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_GRUPOS_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_VARIABLE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PARASITOS_ENCONTRADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TECNICAS_APLICADAS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RECEPCIONES_MENSUAL_CON_MUESTRAS_REFERIDAS_POR_EL_LABORATORIO));

            final List<ResultadoGeneralReportePersonalizado> resultadosGeneralesReportePersonalizado;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_RECEPCIONES_MENSUAL);
            statement.setInt(1, month);
            statement.setInt(2, year);
            resultSet = statement.executeQuery();

            resultadosGeneralesReportePersonalizado = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoRecepcion = resultSet.getInt(1);
                final String codigoRegistroLaboratorio = resultSet.getString(5);
                final int edadPacienteYears = resultSet.getInt(6);
                final int edadPacienteMeses = resultSet.getInt(7);
                final int edadPacienteDias = resultSet.getInt(8);
                final boolean mujerEmbarazada = resultSet.getBoolean(9);
                final boolean mujerParto = resultSet.getBoolean(10);
                final boolean mujerPostParto = resultSet.getBoolean(11);
                final int numeroDiasSintoma = resultSet.getInt(12);
                final Date fechaProcesamiento = resultSet.getDate(13);
                final String solicitante = resultSet.getString(14);
                final Date fechaRecepcion = resultSet.getDate(15);
                final Time horaRecepcion = resultSet.getTime(16);
                final int estado = resultSet.getInt(17);

                final int codigoExamenSolicitado = resultSet.getInt(18);
                final int totalMuestrasBiologicas = resultSet.getInt(22);
                final String estadoMuestraBiologica = resultSet.getString(23);
                final int examenSolicitadoEstado = resultSet.getInt(24);

                final int codigoExamen = resultSet.getInt(25);
                final String examenNombre = resultSet.getString(27);
                final int examenEstado = resultSet.getInt(28);

                final int codigoMuestraBiologica = resultSet.getInt(29);
                final String muestraBiologicaTipo = resultSet.getString(30);
                final int muestraBiologicaEstado = resultSet.getInt(31);

                final int codigoResultadoGeneral = resultSet.getInt(32);
                final String numeroMuestraBiologica = resultSet.getString(40);
                final Date fechaRecepcionTomaMuestra = resultSet.getDate(41);
                final Date resGenFechaFinal = resultSet.getDate(42);
                final Time resGenHoraFinal = resultSet.getTime(43);
                final String resGenExamenControl = resultSet.getString(44);
                final String resGenObservaciones = resultSet.getString(45);
                final String resGenRecomendaciones = resultSet.getString(46);

                final int codigoSubespecialidad = resultSet.getInt(47);
                final String subespecialidadNombre = resultSet.getString(49);
                final int subespecialidadEstado = resultSet.getInt(50);

                final int codigoEspecialidad = resultSet.getInt(51);
                final String especialidadNombre = resultSet.getString(52);
                final int especialidadEstado = resultSet.getInt(53);

                final Recepcion recepcion = new Recepcion(codigoRecepcion, null, null, null, codigoRegistroLaboratorio, edadPacienteYears, edadPacienteMeses, edadPacienteDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintoma, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, estado);
                final Especialidad especialidad = new Especialidad(codigoEspecialidad, especialidadNombre, especialidadEstado);
                final Subespecialidad subespecialidad = new Subespecialidad(codigoSubespecialidad, especialidad, subespecialidadNombre, subespecialidadEstado);
                final Examen examen = new Examen(codigoExamen, subespecialidad, examenNombre, examenEstado);
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigoMuestraBiologica, muestraBiologicaTipo, muestraBiologicaEstado);
                final ExamenSolicitado examenSolicitado = new ExamenSolicitado(codigoExamenSolicitado, recepcion, examen, muestraBiologica, totalMuestrasBiologicas, estadoMuestraBiologica, examenSolicitadoEstado);

                // OBTENIENDO EL ASPECTO
                statement = connection.prepareStatement(SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                AspectoCalidad aspecto = null;
                if (resultSetAux.next()) {
                    final int codigoAspecto = resultSetAux.getInt(1);
                    final String aspectoTipo = resultSetAux.getString(3);
                    final int aspectoEstado = resultSetAux.getInt(4);

                    aspecto = new AspectoCalidad(codigoAspecto, null, aspectoTipo, aspectoEstado);
                }

                // OBTENIENDO EL SEGUIMIENTO DEL PACIENTE
                statement = connection.prepareStatement(SQL_OBTENER_SEGUIMIENTO_PACIENTE);
                statement.setInt(1, codigoResultadoGeneral);
                statement.setInt(2, examenSolicitado.getExamen().getCodigoExamen());
                resultSetAux = statement.executeQuery();

                SeguimientoPaciente seguimientoPaciente = null;
                if (resultSetAux.next()) {
                    final int codigoSeguimientoPaciente = resultSetAux.getInt(1);
                    final Date fechaInicio = resultSetAux.getDate(5);
                    final Time horaInicio = resultSetAux.getTime(6);
                    final String progreso = resultSetAux.getString(9);
                    final String detallesObservacionesInicio = resultSetAux.getString(10);

                    seguimientoPaciente = new SeguimientoPaciente(codigoSeguimientoPaciente, examenSolicitado.getRecepcion().getPaciente(), examenSolicitado.getExamen(), examenSolicitado, fechaInicio, horaInicio, progreso, detallesObservacionesInicio);
                }

                // OBTENIENDO EL POSIBLE RESULTADO DEL EXAMEN
                statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                ExamenPosibleResultado examenPosibleResultado = null;
                if (resultSetAux.next()) {
                    final int codigoPosibleResultado = resultSetAux.getInt(1);
                    final String posibleResultadoNombre = resultSetAux.getString(3);
                    final int posibleResultadoEstado = resultSetAux.getInt(4);

                    examenPosibleResultado = new ExamenPosibleResultado(codigoPosibleResultado, null, posibleResultadoNombre, posibleResultadoEstado);
                }

                // OBTENIENDO LA ENFERMEDAD
                statement = connection.prepareStatement(SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                Enfermedad enfermedad = null;
                if (resultSetAux.next()) {
                    final int codigoEnfermedad = resultSetAux.getInt(1);
                    final String enfermedadNombre = resultSetAux.getString(3);
                    final int enfermedadEstado = resultSetAux.getInt(4);

                    enfermedad = new Enfermedad(codigoEnfermedad, null, enfermedadNombre, enfermedadEstado);
                }

                final ResultadoGeneral resultadoGeneral = new ResultadoGeneral(codigoResultadoGeneral, null, null, examenSolicitado, aspecto, seguimientoPaciente, examenPosibleResultado, enfermedad, numeroMuestraBiologica, fechaRecepcionTomaMuestra, resGenFechaFinal, resGenHoraFinal, resGenExamenControl, resGenObservaciones, resGenRecomendaciones);

                //OBTENIENDO LOS GRUPOS Y VARIABLES DE LOS EXAMENES CON RESULTADOS CARGADOS
                statement = connection.prepareStatement(SQL_OBTENER_GRUPOS_VARIABLES);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                List<GrupoVariablesInformePersonalizado> gruposVariablesInformePesonalizado = new ArrayList<>();
                while (resultSetAux.next()) {
                    final int codigoGrupoVariable = resultSetAux.getInt(1);
                    final String grupoVariablesNombre = resultSetAux.getString(3);
                    final int grupoVariableEstado = resultSetAux.getInt(4);

                    final GrupoVariables grupoVariables = new GrupoVariables(codigoGrupoVariable, examen, grupoVariablesNombre, grupoVariableEstado);

                    statement = connection.prepareStatement(SQL_OBTENER_VARIABLES);
                    statement.setInt(1, codigoGrupoVariable);
                    statement.setInt(2, codigoResultadoGeneral);

                    resultSetAux1 = statement.executeQuery();

                    final List<VariableExamenInformePersonalizado> variablesExamenInformePersonalizados = new ArrayList<>();
                    while (resultSetAux1.next()) {
                        final int codigoVariableExamen = resultSetAux1.getInt(1);
                        final String variableExamenNombre = resultSetAux1.getString(3);
                        final int variableExamenEstado = resultSetAux1.getInt(9);

                        statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_VARIABLE);
                        switch (variableExamenNombre) {
                            case "MICROMETODO CHAGAS":
                                statement.setInt(1, codigoResultadoGeneral);
                                statement.setInt(2, codigoVariableExamen);
                                resultSetAux2 = statement.executeQuery();
                                resultSetAux2.next();
                                if (resultSetAux2.getString(1).equals("POSITIVO")) {
                                    variablesExamenInformePersonalizados.add(new VariableExamenInformePersonalizado(codigoVariableExamen, grupoVariables, variableExamenNombre, null, null, variableExamenEstado, true, false));
                                } else {
                                    variablesExamenInformePersonalizados.add(new VariableExamenInformePersonalizado(codigoVariableExamen, grupoVariables, variableExamenNombre, null, null, variableExamenEstado, false, false));
                                }
                                break;
                            case "GOTA GRUESA":
                                statement.setInt(1, codigoResultadoGeneral);
                                statement.setInt(2, codigoVariableExamen);
                                resultSetAux2 = statement.executeQuery();
                                resultSetAux2.next();
                                if (resultSetAux2.getString(1).equals("POSITIVO")) {
                                    variablesExamenInformePersonalizados.add(new VariableExamenInformePersonalizado(codigoVariableExamen, grupoVariables, variableExamenNombre, null, null, variableExamenEstado, false, true));
                                } else {
                                    variablesExamenInformePersonalizados.add(new VariableExamenInformePersonalizado(codigoVariableExamen, grupoVariables, variableExamenNombre, null, null, variableExamenEstado, false, false));
                                }
                                break;
                            default:
                                variablesExamenInformePersonalizados.add(new VariableExamenInformePersonalizado(codigoVariableExamen, grupoVariables, variableExamenNombre, null, null, variableExamenEstado, false, false));
                                break;
                        }
                    }

                    gruposVariablesInformePesonalizado.add(new GrupoVariablesInformePersonalizado(grupoVariables, variablesExamenInformePersonalizados));
                }

                //OBTENIENDO LOS PARASITOS ENCONTRADOS
                statement = connection.prepareStatement(SQL_OBTENER_PARASITOS_ENCONTRADOS);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                final List<ParasitoEncontrado> parasitosEncontrados = new ArrayList<>();
                while (resultSetAux.next()) {
                    final int codigoParasitoEncontrado = resultSetAux.getInt(1);
                    final String parasitoTipoObservacion = resultSetAux.getString(4);
                    final int parasitoEncontradoEstado = resultSetAux.getInt(5);

                    final int codigoParasito = resultSetAux.getInt(6);
                    final String parasitoNombre = resultSetAux.getString(8);
                    final int parasitoEstado = resultSetAux.getInt(9);

                    final Parasito parasito = new Parasito(codigoParasito, null, parasitoNombre, parasitoEstado);
                    parasitosEncontrados.add(new ParasitoEncontrado(codigoParasitoEncontrado, null, parasito, parasitoTipoObservacion, parasitoEncontradoEstado));
                }

                // OBTENIENDO LAS TECNICAS APLICADAS
                statement = connection.prepareStatement(SQL_OBTENER_TECNICAS_APLICADAS);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();

                List<TecnicaAplicada> tecnicasAplicadas = new ArrayList<>();
                while (resultSetAux.next()) {
                    final int codigoTecnicaAplicada = resultSetAux.getInt(1);
                    final int tecnicaAplicadaEstado = resultSetAux.getInt(4);

                    final int codigoTecnica = resultSetAux.getInt(5);
                    final String tecnicaNombre = resultSetAux.getString(7);
                    final String tecnicaMetodo = resultSetAux.getString(8);
                    final int tecnicaEstado = resultSetAux.getInt(9);

                    final Tecnica tecnica = new Tecnica(codigoTecnica, examenSolicitado.getExamen(), tecnicaNombre, tecnicaMetodo, tecnicaEstado);
                    tecnicasAplicadas.add(new TecnicaAplicada(codigoTecnicaAplicada, resultadoGeneral, tecnica, tecnicaAplicadaEstado));
                }

                resultadosGeneralesReportePersonalizado.add(new ResultadoGeneralReportePersonalizado(resultadoGeneral, gruposVariablesInformePesonalizado, parasitosEncontrados, tecnicasAplicadas));
            }

            // OBTENIENDO LOS EXAMENES CON MUESTRAS BIOLOGICAS REFERIDAS POR EL LABORATORIO
            statement = connection.prepareStatement(SQL_OBTENER_RECEPCIONES_MENSUAL_CON_MUESTRAS_REFERIDAS_POR_EL_LABORATORIO);
            statement.setInt(1, month);
            statement.setInt(2, year);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                final int codigoRecepcion = resultSet.getInt(1);
                final String codigoRegistroLaboratorio = resultSet.getString(5);
                final int edadPacienteYears = resultSet.getInt(6);
                final int edadPacienteMeses = resultSet.getInt(7);
                final int edadPacienteDias = resultSet.getInt(8);
                final boolean mujerEmbarazada = resultSet.getBoolean(9);
                final boolean mujerParto = resultSet.getBoolean(10);
                final boolean mujerPostParto = resultSet.getBoolean(11);
                final int numeroDiasSintoma = resultSet.getInt(12);
                final Date fechaProcesamiento = resultSet.getDate(13);
                final String solicitante = resultSet.getString(14);
                final Date fechaRecepcion = resultSet.getDate(15);
                final Time horaRecepcion = resultSet.getTime(16);
                final int estado = resultSet.getInt(17);

                final int codigoExamenSolicitado = resultSet.getInt(18);
                final int totalMuestrasBiologicas = resultSet.getInt(22);
                final String estadoMuestraBiologica = resultSet.getString(23);
                final int examenSolicitadoEstado = resultSet.getInt(24);

                final int codigoExamen = resultSet.getInt(25);
                final String examenNombre = resultSet.getString(27);
                final int examenEstado = resultSet.getInt(28);

                final int codigoSubespecialidad = resultSet.getInt(29);
                final String subespecialidadNombre = resultSet.getString(31);
                final int subespecialidadEstado = resultSet.getInt(32);

                final int codigoEspecialidad = resultSet.getInt(33);
                final String especialidadNombre = resultSet.getString(34);
                final int especialidadEstado = resultSet.getInt(35);

                final int codigoMuestraBiologica = resultSet.getInt(36);
                final String muestraBiologicaTipo = resultSet.getString(37);
                final int muestraBiologicaEstado = resultSet.getInt(38);

                final Recepcion recepcion = new Recepcion(codigoRecepcion, null, null, null, codigoRegistroLaboratorio, edadPacienteYears, edadPacienteMeses, edadPacienteDias, mujerEmbarazada, mujerParto, mujerPostParto, numeroDiasSintoma, fechaProcesamiento, solicitante, fechaRecepcion, horaRecepcion, estado);
                final Especialidad especialidad = new Especialidad(codigoEspecialidad, especialidadNombre, especialidadEstado);
                final Subespecialidad subespecialidad = new Subespecialidad(codigoSubespecialidad, especialidad, subespecialidadNombre, subespecialidadEstado);
                final Examen examen = new Examen(codigoExamen, subespecialidad, examenNombre, examenEstado);
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigoMuestraBiologica, muestraBiologicaTipo, muestraBiologicaEstado);
                final ExamenSolicitado examenSolicitado = new ExamenSolicitado(codigoExamenSolicitado, recepcion, examen, muestraBiologica, totalMuestrasBiologicas, estadoMuestraBiologica, examenSolicitadoEstado);

                final ResultadoGeneral resultadoGeneral = new ResultadoGeneral(-1, null, null, examenSolicitado, null, null, null, null, null, null, null, null, null, null, null);

                resultadosGeneralesReportePersonalizado.add(new ResultadoGeneralReportePersonalizado(resultadoGeneral, null, null, null));
            }

            return resultadosGeneralesReportePersonalizado;
        } catch (final SQLException sqlException) {
            System.out.print("SQLException - Error en SQLInformeMensualLaboratorio - Obtener Resultados Generales: " + sqlException.getMessage());
            return null;
        } catch (final Exception exception) {
            System.out.print("SQLException - Error en SQLInformeMensualLaboratorio - Obtener Resultados Generales: " + exception.getMessage());
            return null;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (resultSetAux != null && !resultSetAux.isClosed()) {
                    resultSetAux.close();
                }

                if (resultSetAux1 != null && !resultSetAux1.isClosed()) {
                    resultSetAux1.close();
                }

                if (resultSetAux2 != null && !resultSetAux2.isClosed()) {
                    resultSetAux2.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLInformeMensualLaboratorio - InsertarEnLog: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    // </editor-fold>
    
}