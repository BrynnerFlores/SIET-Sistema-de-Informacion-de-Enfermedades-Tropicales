package Model.DAO.GestionRecepciones;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.AspectoCalidad;
import Model.POJO.Conexion;
import Model.POJO.Enfermedad;
import Model.POJO.ExamenPosibleResultado;
import Model.POJO.ExamenSolicitado;
import Model.POJO.GrupoVariables;
import Model.POJO.LogConsulta;
import Model.POJO.Parasito;
import Model.POJO.ParasitoEncontrado;
import Model.POJO.Persona;
import Model.POJO.PersonalTecnico;
import Model.POJO.ResultadoGeneral;
import Model.POJO.ResultadoVariable;
import Model.POJO.SeguimientoPaciente;
import Model.POJO.Tecnica;
import Model.POJO.TecnicaAplicada;
import Model.POJO.VariableExamen;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
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
public class SQLExamenSolicitado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_OBTENER_RESULTADO_GENERAL = "SELECT * FROM aresgen INNER JOIN apertec personalTecnicoAnalista ON personalTecnicoAnalista.paptcopete = aresgen.fargcopean INNER JOIN aperson personaAnalista ON personalTecnicoAnalista.faptcodper = personaAnalista.papscodper INNER JOIN apertec personalTecnicoResultados ON personalTecnicoResultados.paptcopete = aresgen.fargcopere INNER JOIN aperson personaResultado ON personalTecnicoResultados.faptcodper = personaResultado.papscodper WHERE aresgen.fargcoexso = ? ORDER BY pargcorege";
    private final String SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL = "SELECT * FROM aaspcal WHERE paaccoasca IN (SELECT fargcoasca FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_SEGUIMIENTO_PACIENTE = "SELECT * FROM asegpac WHERE paspcosepa IN (SELECT fargcosepa FROM aresgen WHERE pargcorege = ?) AND faspcodexa = ?";
    private final String SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL = "SELECT * FROM aexpore WHERE paeocopore IN (SELECT fargcopore FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL = "SELECT * FROM aenferm WHERE paeecodenf IN (SELECT fargcodenf FROM aresgen WHERE pargcorege = ?) LIMIT 1";
    private final String SQL_OBTENER_RESULTADO_VARIABLES = "SELECT * FROM aresvar INNER JOIN avarexa ON avarexa.pavecovaex = aresvar.farvcovaex INNER JOIN agruvar ON agruvar.pagvcogrva = avarexa.favecogrva WHERE farvcorege = ? AND carvrevaes = 1 ORDER BY pavecovaex ASC";
    private final String SQL_OBTENER_PARASITOS_ENCONTRADOS = "SELECT * FROM aparenc INNER JOIN aparasi ON aparasi.papacodpar = aparenc.fapecodpar WHERE fapecorege = ? AND capepaenes = 1";
    private final String SQL_OBTENER_TECNICAS_APLICADAS = "SELECT * FROM atecapl INNER JOIN atecnic ON atecnic.patncodtec = atecapl.fatacodtec WHERE fatacorege = ? AND catateapes = 1 ORDER BY atecapl.patacoteap ASC";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLExamenSolicitado() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public ResultadoGeneralPersonalizado obtenerResultadoGeneral(final ExamenSolicitado examenSolicitado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SEGUIMIENTO_PACIENTE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PARASITOS_ENCONTRADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TECNICAS_APLICADAS));
            
            ResultadoGeneralPersonalizado resultadoGeneralPersonalizado = null;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_GENERAL);
            statement.setInt(1, examenSolicitado.getCodigoExamenSolicitado());
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                final int codigoResultadoGeneral = resultSet.getInt(1);
                final String numeroMuestraBiologica = resultSet.getString(9);
                final Date fechaRecepcionTomaMuestra = resultSet.getDate(10);
                final Date fechaFinal = resultSet.getDate(11);
                final Time horaFinal = resultSet.getTime(12);
                final String examenControl = resultSet.getString(13);
                final String observaciones = resultSet.getString(14);
                final String recomendaciones = resultSet.getString(15);
                
                final int codigoPersonalTecnicoAnalista = resultSet.getInt(16);
                final String personalTecnicoAnalistaProfesion = resultSet.getString(18);
                final Date personalTecnicoAnalistaFechaInicio = resultSet.getDate(19);
                final Time personalTecnicoAnalistaHoraInicio = resultSet.getTime(20);
                final boolean personalTecnicoAnalistaHabilitado = resultSet.getBoolean(23);
                
                final int codigoPersonaAnalista = resultSet.getInt(24);
                final String personaAnalistaCedulaIdentidad = resultSet.getString(25);
                final String personaAnalistaApellido = resultSet.getString(26);
                final String personaAnalistaNombre = resultSet.getString(27);
                final String personaAnalistaSexo = resultSet.getString(28);
                
                final int codigoPersonalTecnicoResultados = resultSet.getInt(29);
                final String personalTecnicoResultadosProfesion = resultSet.getString(31);
                final Date personalTecnicoResultadosFechaInicio = resultSet.getDate(32);
                final Time personalTecnicoResultadosHoraInicio = resultSet.getTime(33);
                final boolean personalTecnicoResultadosHabilitado = resultSet.getBoolean(36);
                
                final int codigoPersonaResultados = resultSet.getInt(37);
                final String personaResultadosCedulaIdentidad = resultSet.getString(38);
                final String personaResultadosApellido = resultSet.getString(39);
                final String personaResultadosNombre = resultSet.getString(40);
                final String personaResultadosSexo = resultSet.getString(41);
                
                final Persona personaAnalista = new Persona(codigoPersonaAnalista, personaAnalistaCedulaIdentidad, personaAnalistaApellido, personaAnalistaNombre, personaAnalistaSexo);
                final Persona personaResultados = new Persona(codigoPersonaResultados, personaResultadosCedulaIdentidad, personaResultadosApellido, personaResultadosNombre, personaResultadosSexo);
                final PersonalTecnico personalTecnicoAnalista = new PersonalTecnico(codigoPersonalTecnicoAnalista, personaAnalista, personalTecnicoAnalistaProfesion, personalTecnicoAnalistaFechaInicio, personalTecnicoAnalistaHoraInicio, personalTecnicoAnalistaHabilitado);
                final PersonalTecnico personalTecnicoResultados = new PersonalTecnico(codigoPersonalTecnicoResultados, personaResultados, personalTecnicoResultadosProfesion, personalTecnicoResultadosFechaInicio, personalTecnicoResultadosHoraInicio, personalTecnicoResultadosHabilitado);
                
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
                
                final ResultadoGeneral resultadoGeneral = new ResultadoGeneral(codigoResultadoGeneral, personalTecnicoAnalista, personalTecnicoResultados, examenSolicitado, aspecto, seguimientoPaciente, examenPosibleResultado, enfermedad, numeroMuestraBiologica, fechaRecepcionTomaMuestra, fechaFinal, horaFinal, examenControl, observaciones, recomendaciones);
                
                //OBTENIENDO LAS VARIABLES DE LOS EXAMENES CON RESULTADOS CARGADOS
                statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_VARIABLES);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();
                
                List<ResultadoVariable> resultadosVariables = new ArrayList<>();
                while (resultSetAux.next()) {
                    final int codigoResultadoVariable = resultSetAux.getInt(1);
                    final String resultadoVariable = resultSetAux.getString(4);
                    final int resultadoVariableEstado = resultSetAux.getInt(5);
                    
                    final int codigoVariableExamen = resultSetAux.getInt(6);
                    final String variableNombre = resultSetAux.getString(8);
                    final String variableValorReferencia = resultSetAux.getString(9);
                    final String variableMetodo = resultSetAux.getString(10);
                    final String variableTipoVariable = resultSetAux.getString(11);
                    final Object variableValorMinimo = resultSetAux.getObject(12);
                    final Object variableValorMaximo = resultSetAux.getObject(13);
                    final int variableEstado = resultSetAux.getInt(14);
                    
                    final VariableExamen variableExamen = new VariableExamen(codigoVariableExamen, null, variableNombre, variableValorReferencia, variableMetodo, variableTipoVariable, variableValorMinimo, variableValorMaximo, variableEstado);
                    resultadosVariables.add(new ResultadoVariable(codigoResultadoVariable, null, variableExamen, resultadoVariable, resultadoVariableEstado));
                }
                
                //OBTENIENDO LOS PARASITOS ENCONTRADOS
                statement = connection.prepareStatement(SQL_OBTENER_PARASITOS_ENCONTRADOS);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();
                
                List<ParasitoEncontrado> parasitosEncontrados = new ArrayList<>();
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
                
                resultadoGeneralPersonalizado = new ResultadoGeneralPersonalizado(resultadoGeneral, resultadosVariables, parasitosEncontrados, tecnicasAplicadas);
            }
            return resultadoGeneralPersonalizado;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamenSolicitado - Obtener Resultado General: " + sqlException.getMessage());
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
                
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }

        }
    }
    
    public List<ResultadoGeneralPersonalizado> obtenerResultadosGenerales(final ExamenSolicitado examenSolicitado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ASPECTO_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_SEGUIMIENTO_PACIENTE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_FINAL_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ENFERMEDAD_DEL_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_RESULTADO_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PARASITOS_ENCONTRADOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TECNICAS_APLICADAS));
            
            List<ResultadoGeneralPersonalizado> resultadosGeneralesPersonalizados;
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_GENERAL);
            statement.setInt(1, examenSolicitado.getCodigoExamenSolicitado());
            resultSet = statement.executeQuery();
            
            resultadosGeneralesPersonalizados = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoResultadoGeneral = resultSet.getInt(1);
                final String numeroMuestraBiologica = resultSet.getString(9);
                final Date fechaRecepcionTomaMuestra = resultSet.getDate(10);
                final Date fechaFinal = resultSet.getDate(11);
                final Time horaFinal = resultSet.getTime(12);
                final String examenControl = resultSet.getString(13);
                final String observaciones = resultSet.getString(14);
                final String recomendaciones = resultSet.getString(15);
                
                final int codigoPersonalTecnicoAnalista = resultSet.getInt(16);
                final String personalTecnicoAnalistaProfesion = resultSet.getString(18);
                final Date personalTecnicoAnalistaFechaInicio = resultSet.getDate(19);
                final Time personalTecnicoAnalistaHoraInicio = resultSet.getTime(20);
                final boolean personalTecnicoAnalistaHabilitado = resultSet.getBoolean(23);
                
                final int codigoPersonaAnalista = resultSet.getInt(24);
                final String personaAnalistaCedulaIdentidad = resultSet.getString(25);
                final String personaAnalistaApellido = resultSet.getString(26);
                final String personaAnalistaNombre = resultSet.getString(27);
                final String personaAnalistaSexo = resultSet.getString(28);
                
                final int codigoPersonalTecnicoResultados = resultSet.getInt(29);
                final String personalTecnicoResultadosProfesion = resultSet.getString(31);
                final Date personalTecnicoResultadosFechaInicio = resultSet.getDate(32);
                final Time personalTecnicoResultadosHoraInicio = resultSet.getTime(33);
                final boolean personalTecnicoResultadosHabilitado = resultSet.getBoolean(36);
                
                final int codigoPersonaResultados = resultSet.getInt(37);
                final String personaResultadosCedulaIdentidad = resultSet.getString(38);
                final String personaResultadosApellido = resultSet.getString(39);
                final String personaResultadosNombre = resultSet.getString(40);
                final String personaResultadosSexo = resultSet.getString(41);
                
                final Persona personaAnalista = new Persona(codigoPersonaAnalista, personaAnalistaCedulaIdentidad, personaAnalistaApellido, personaAnalistaNombre, personaAnalistaSexo);
                final Persona personaResultados = new Persona(codigoPersonaResultados, personaResultadosCedulaIdentidad, personaResultadosApellido, personaResultadosNombre, personaResultadosSexo);
                final PersonalTecnico personalTecnicoAnalista = new PersonalTecnico(codigoPersonalTecnicoAnalista, personaAnalista, personalTecnicoAnalistaProfesion, personalTecnicoAnalistaFechaInicio, personalTecnicoAnalistaHoraInicio, personalTecnicoAnalistaHabilitado);
                final PersonalTecnico personalTecnicoResultados = new PersonalTecnico(codigoPersonalTecnicoResultados, personaResultados, personalTecnicoResultadosProfesion, personalTecnicoResultadosFechaInicio, personalTecnicoResultadosHoraInicio, personalTecnicoResultadosHabilitado);
                
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
                
                final ResultadoGeneral resultadoGeneral = new ResultadoGeneral(codigoResultadoGeneral, personalTecnicoAnalista, personalTecnicoResultados, examenSolicitado, aspecto, seguimientoPaciente, examenPosibleResultado, enfermedad, numeroMuestraBiologica, fechaRecepcionTomaMuestra, fechaFinal, horaFinal, examenControl, observaciones, recomendaciones);
                
                //OBTENIENDO LAS VARIABLES DE LOS EXAMENES CON RESULTADOS CARGADOS
                statement = connection.prepareStatement(SQL_OBTENER_RESULTADO_VARIABLES);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();
                
                List<ResultadoVariable> resultadosVariables = new ArrayList<>();
                while (resultSetAux.next()) {
                    final int codigoResultadoVariable = resultSetAux.getInt(1);
                    final String resultadoVariable = resultSetAux.getString(4);
                    final int resultadoVariableEstado = resultSetAux.getInt(5);
                    
                    final int codigoVariableExamen = resultSetAux.getInt(6);
                    final String variableNombre = resultSetAux.getString(8);
                    final String variableValorReferencia = resultSetAux.getString(9);
                    final String variableMetodo = resultSetAux.getString(10);
                    final String variableTipoVariable = resultSet.getString(11);
                    final Object variableValorMinimo = resultSet.getObject(12);
                    final Object variableValorMaximo = resultSet.getObject(13);
                    final int variableEstado = resultSetAux.getInt(14);
                    
                    final int codigoGrupoVariable = resultSetAux.getInt(15);
                    final String grupoVariablaNombre = resultSetAux.getString(17);
                    final int grupoVariableEstado = resultSetAux.getInt(18);
                    
                    final GrupoVariables grupoVariables = new GrupoVariables(codigoGrupoVariable, null, grupoVariablaNombre, grupoVariableEstado);
                    final VariableExamen variableExamen = new VariableExamen(codigoVariableExamen, grupoVariables, variableNombre, variableValorReferencia, variableMetodo, variableTipoVariable, variableValorMinimo, variableValorMaximo, variableEstado);
                    resultadosVariables.add(new ResultadoVariable(codigoResultadoVariable, null, variableExamen, resultadoVariable, resultadoVariableEstado));
                }
                
                //OBTENIENDO LOS PARASITOS ENCONTRADOS
                statement = connection.prepareStatement(SQL_OBTENER_PARASITOS_ENCONTRADOS);
                statement.setInt(1, codigoResultadoGeneral);
                resultSetAux = statement.executeQuery();
                
                List<ParasitoEncontrado> parasitosEncontrados = new ArrayList<>();
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
                
                resultadosGeneralesPersonalizados.add(new ResultadoGeneralPersonalizado(resultadoGeneral, resultadosVariables, parasitosEncontrados, tecnicasAplicadas));
            }
            return resultadosGeneralesPersonalizados;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLExamenSolicitado - Obtener Resultados Generales: " + sqlException.getMessage());
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
            System.err.println("Error en SQLExamenSolicitado - InsertarEnLog: " + sqlException.getMessage());
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