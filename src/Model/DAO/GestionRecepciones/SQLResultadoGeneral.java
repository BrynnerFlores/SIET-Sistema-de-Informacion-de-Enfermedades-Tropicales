package Model.DAO.GestionRecepciones;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.ParasitoEncontrado;
import Model.POJO.PersonalTecnico;
import Model.POJO.ResultadoVariable;
import Model.POJO.TecnicaAplicada;
import Model.POJOPersonalizado.ResultadoGeneralPersonalizado;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLResultadoGeneral {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR_RESULTADO_GENERAL = "INSERT INTO aresgen(pargcorege, fargcopean, fargcopere, fargcoexso, fargcoasca, fargcosepa, fargcopore, fargcodenf, cargnumubi, cargfertmu, cargfecfin, carghorfin, cargexacon, cargobserv, cargrecome) VALUES(nextval('pargcorege_sequence'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_INSERTAR_RESULTADO_VARIABLE = "INSERT INTO aresvar(parvcoreva, farvcorege, farvcovaex, carvresvar, carvrevaes) VALUES(nextval('parvcoreva_sequence'), ?, ?, ?, ?)";
    private final String SQL_INSERTAR_PARASITO_ENCONTRADO = "INSERT INTO aparenc(papecopaen, fapecorege, fapecodpar, capepatiob, capepaenes) VALUES(nextval('papecopaen_sequence'), ?, ?, ?, ?)";
    private final String SQL_INSERTAR_TECNICA_APLICADA = "INSERT INTO atecapl(patacoteap, fatacorege, fatacodtec, catateapes) VALUES(nextval('patacoteap_sequence'), ?, ?, ?)";
    private final String SQL_ACTUALIZAR_RESULTADO_GENERAL = "UPDATE aresgen SET fargcoasca = ?, fargcosepa = ?, fargcopore = ?, fargcodenf = ?, cargnumubi = ?, cargfertmu = ?, cargexacon = ?, cargobserv = ?, cargrecome = ? WHERE pargcorege = ?";
    private final String SQL_ACTUALIZAR_RESULTADO_VARIABLE = "UPDATE aresvar SET carvresvar = ? WHERE parvcoreva = ?";
    private final String SQL_ACTUALIZAR_PARASITO_ENCONTRADO = "UPDATE aparenc SET capepatiob = ? WHERE papecopaen = ?";
    private final String SQL_ELIMINAR_RESULTADO_VARIABLE = "UPDATE aresvar SET carvrevaes = 0 WHERE parvcoreva = ?";
    private final String SQL_ELIMINAR_PARASITO_ENCONTRADO = "UPDATE aparenc SET capepaenes = 0 WHERE papecopaen = ?";
    private final String SQL_ELIMINAR_TECNICA_APLICADA = "UPDATE atecapl SET catateapes = 0 WHERE patacoteap = ?";
    private final String SQL_VERIFICAR_RESULTADO_EXISTE = "SELECT CASE WHEN ((SELECT cargnumubi FROM aresgen WHERE pargcorege != ? AND fargcoexso = ?) = ?) THEN TRUE ELSE FALSE END";
    private final String SQL_VERIFICAR_PERMITIR_MODIFICACION = "SELECT CASE WHEN ((SELECT EXTRACT(EPOCH FROM(CURRENT_TIMESTAMP - (SELECT CONCAT((SELECT cargfecfin FROM aresgen WHERE pargcorege = ?),' ',(SELECT carghorfin FROM aresgen WHERE pargcorege = ?))::timestamp)))/3600) > 48) THEN TRUE ELSE FALSE END";
    private final String SQL_VERIFICAR_SI_RESULTADO_ES_ANTECEDENTE = "SELECT EXISTS (SELECT 1 FROM asegpac WHERE faspcoexso = ?)";
    private final PersonalTecnico PERSONAL_TECNICO;
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLResultadoGeneral() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_RESULTADO_VARIABLE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_PARASITO_ENCONTRADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_TECNICA_APLICADA));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERTAR_RESULTADO_GENERAL, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoAnalista().getCodigoPersonalTecnico());
            statement.setInt(2, resultadoGeneralPersonalizado.getResultadoGeneral().getPersonalTecnicoResultados().getCodigoPersonalTecnico());
            statement.setInt(3, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getCodigoExamenSolicitado());
            statement.setObject(4, resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto().getCodigoAspectoCalidad());
            statement.setObject(5, resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getCodigoSeguimientoPaciente());
            statement.setObject(6, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado().getCodigoPosibleResultado());
            statement.setObject(7, resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad().getCodigoEnfermedad());
            statement.setString(8, resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica());
            statement.setDate(9, resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra());
            statement.setDate(10, resultadoGeneralPersonalizado.getResultadoGeneral().getFechaFinal());
            statement.setTime(11, resultadoGeneralPersonalizado.getResultadoGeneral().getHoraFinal());
            statement.setString(12, resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getExamenControl());
            statement.setString(13, resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
            statement.setString(14, resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones());

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                final int CODIGO_RESULTADO_GENERAL = resultSet.getInt(1);

                statement = connection.prepareStatement(SQL_INSERTAR_RESULTADO_VARIABLE);
                final int sizeVariableExamen = resultadoGeneralPersonalizado.getResultadosVariables().size();
                boolean variablesInsertadas = true;

                for (int i = 0; i < sizeVariableExamen; i++) {
                    statement.setInt(1, CODIGO_RESULTADO_GENERAL);
                    statement.setInt(2, resultadoGeneralPersonalizado.getResultadosVariables().get(i).getVariableExamen().getCodigoVariableExamen());
                    statement.setString(3, resultadoGeneralPersonalizado.getResultadosVariables().get(i).getResultadoVariable());
                    statement.setInt(4, resultadoGeneralPersonalizado.getResultadosVariables().get(i).getResultadoVariableEstado());

                    if (statement.executeUpdate() != 1) {
                        variablesInsertadas = false;
                        break;
                    }
                }

                if (variablesInsertadas) {
                    statement = connection.prepareStatement(SQL_INSERTAR_PARASITO_ENCONTRADO);
                    final int sizeParasitosEncontrados = resultadoGeneralPersonalizado.getParasitosEncontrados().size();
                    boolean parasitosInsertados = true;

                    for (int i = 0; i < sizeParasitosEncontrados; i++) {
                        statement.setInt(1, CODIGO_RESULTADO_GENERAL);
                        statement.setInt(2, resultadoGeneralPersonalizado.getParasitosEncontrados().get(i).getParasito().getCodigoParasito());
                        statement.setString(3, resultadoGeneralPersonalizado.getParasitosEncontrados().get(i).getParasitoTipoObservacion());
                        statement.setInt(4, resultadoGeneralPersonalizado.getParasitosEncontrados().get(i).getParasitoEncontradoEstado());

                        if (statement.executeUpdate() != 1) {
                            parasitosInsertados = false;
                            break;
                        }
                    }

                    if (parasitosInsertados) {
                        statement = connection.prepareStatement(SQL_INSERTAR_TECNICA_APLICADA);
                        final int sizeTecnicasAplicadas = resultadoGeneralPersonalizado.getTecnicasAplicadas().size();
                        boolean tecnicasAplicadasInsertadas = true;

                        for (int i = 0; i < sizeTecnicasAplicadas; i++) {
                            statement.setInt(1, CODIGO_RESULTADO_GENERAL);
                            statement.setInt(2, resultadoGeneralPersonalizado.getTecnicasAplicadas().get(i).getTecnica().getCodigoTecnica());
                            statement.setInt(3, resultadoGeneralPersonalizado.getTecnicasAplicadas().get(i).getTecnicaAplicadaEstado());

                            if (statement.executeUpdate() != 1) {
                                tecnicasAplicadasInsertadas = false;
                                break;
                            }
                        }

                        if (tecnicasAplicadasInsertadas) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                            return false;
                        }
                    } else {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLResultadoGeneral - Insertar: " + sqlException.getMessage());
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

    public boolean actualizar(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_RESULTADO_GENERAL));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_RESULTADO_VARIABLE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_RESULTADO_VARIABLE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_RESULTADO_VARIABLE));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_PARASITO_ENCONTRADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_PARASITO_ENCONTRADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR_PARASITO_ENCONTRADO));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR_TECNICA_APLICADA));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_TECNICA_APLICADA));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_ACTUALIZAR_RESULTADO_GENERAL);
            statement.setObject(1, resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getAspecto().getCodigoAspectoCalidad());
            statement.setObject(2, resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getSeguimientoPaciente().getCodigoSeguimientoPaciente());
            statement.setObject(3, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getExamenPosibleResultado().getCodigoPosibleResultado());
            statement.setObject(4, resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad() == null ? null : resultadoGeneralPersonalizado.getResultadoGeneral().getEnfermedad().getCodigoEnfermedad());
            statement.setString(5, resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica());
            statement.setDate(6, resultadoGeneralPersonalizado.getResultadoGeneral().getFechaTomaMuestra());
            statement.setString(7, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenControl());
            statement.setString(8, resultadoGeneralPersonalizado.getResultadoGeneral().getObservaciones());
            statement.setString(9, resultadoGeneralPersonalizado.getResultadoGeneral().getRecomendaciones());
            statement.setInt(10, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());

            if (statement.executeUpdate() == 1) {
                boolean variablesActualizadas = true;

                for (final ResultadoVariable resultadoVariable : resultadoGeneralPersonalizado.getResultadosVariables()) {
                    if (resultadoVariable.getCodigoResultadoVariable() == 0 && resultadoVariable.getResultadoVariableEstado() == 1) {
                        statement = connection.prepareStatement(SQL_INSERTAR_RESULTADO_VARIABLE);
                        statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
                        statement.setInt(2, resultadoVariable.getVariableExamen().getCodigoVariableExamen());
                        statement.setString(3, resultadoVariable.getResultadoVariable());
                        statement.setInt(4, resultadoVariable.getResultadoVariableEstado());
                    } else if (resultadoVariable.getCodigoResultadoVariable() != 0 && resultadoVariable.getResultadoVariableEstado() == 0) {
                        statement = connection.prepareStatement(SQL_ELIMINAR_RESULTADO_VARIABLE);
                        statement.setInt(1, resultadoVariable.getCodigoResultadoVariable());
                    } else {
                        statement = connection.prepareStatement(SQL_ACTUALIZAR_RESULTADO_VARIABLE);
                        statement.setString(1, resultadoVariable.getResultadoVariable());
                        statement.setInt(2, resultadoVariable.getCodigoResultadoVariable());
                    }

                    final int result = statement.executeUpdate();
                    if (result > 1 || result < 1) {
                        variablesActualizadas = false;
                        break;
                    }
                }

                if (variablesActualizadas) {
                    boolean parasitosActualizados = true;

                    for (final ParasitoEncontrado parasitoEncontrado : resultadoGeneralPersonalizado.getParasitosEncontrados()) {
                        if (parasitoEncontrado.getCodigoParasitoEncontrado() == 0 && parasitoEncontrado.getParasitoEncontradoEstado() == 1) {
                            statement = connection.prepareStatement(SQL_INSERTAR_PARASITO_ENCONTRADO);
                            statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
                            statement.setInt(2, parasitoEncontrado.getParasito().getCodigoParasito());
                            statement.setString(3, parasitoEncontrado.getParasitoTipoObservacion());
                            statement.setInt(4, parasitoEncontrado.getParasitoEncontradoEstado());
                        } else if (parasitoEncontrado.getCodigoParasitoEncontrado() != 0 && parasitoEncontrado.getParasitoEncontradoEstado() == 0) {
                            statement = connection.prepareStatement(SQL_ELIMINAR_PARASITO_ENCONTRADO);
                            statement.setInt(1, parasitoEncontrado.getCodigoParasitoEncontrado());
                        } else {
                            statement = connection.prepareStatement(SQL_ACTUALIZAR_PARASITO_ENCONTRADO);
                            statement.setString(1, parasitoEncontrado.getParasitoTipoObservacion());
                            statement.setInt(2, parasitoEncontrado.getCodigoParasitoEncontrado());
                        }

                        final int result = statement.executeUpdate();
                        if (result > 1 || result < 1) {
                            parasitosActualizados = false;
                            break;
                        }
                    }

                    if (parasitosActualizados) {
                        boolean tecnicasAplicadasActualizadas = true;

                        for (final TecnicaAplicada tecnicaAplicada : resultadoGeneralPersonalizado.getTecnicasAplicadas()) {
                            if (tecnicaAplicada.getCodigoTecnicaAplicada() == 0 && tecnicaAplicada.getTecnicaAplicadaEstado() == 1) {
                                statement = connection.prepareStatement(SQL_INSERTAR_TECNICA_APLICADA);
                                statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
                                statement.setInt(2, tecnicaAplicada.getTecnica().getCodigoTecnica());
                                statement.setInt(3, tecnicaAplicada.getTecnicaAplicadaEstado());
                            } else {
                                statement = connection.prepareStatement(SQL_ELIMINAR_TECNICA_APLICADA);
                                statement.setInt(1, tecnicaAplicada.getCodigoTecnicaAplicada());
                            }

                            final int result = statement.executeUpdate();
                            if (result > 1 || result < 1) {
                                tecnicasAplicadasActualizadas = false;
                                break;
                            }
                        }

                        if (tecnicasAplicadasActualizadas) {
                            connection.commit();
                            return true;
                        } else {
                            connection.rollback();
                            return false;
                        }
                    } else {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLResultadoGeneral - Actualizar: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public int verificarPermitirModificacion(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_PERMITIR_MODIFICACION));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_PERMITIR_MODIFICACION);
            statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
            statement.setInt(2, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLResultadoGeneral - Verificar Permitir Modificacion: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public int verificarResultadoExiste(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_RESULTADO_EXISTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_RESULTADO_EXISTE);
            statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getCodigoResultadoGeneral());
            statement.setInt(2, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getCodigoExamenSolicitado());
            statement.setString(3, resultadoGeneralPersonalizado.getResultadoGeneral().getNumeroMuestraBiologica());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLResultadoGeneral - Verificar Resultado Existe: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarSiResultadoEsAntecedente(final ResultadoGeneralPersonalizado resultadoGeneralPersonalizado) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_SI_RESULTADO_ES_ANTECEDENTE));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_SI_RESULTADO_ES_ANTECEDENTE);
            statement.setInt(1, resultadoGeneralPersonalizado.getResultadoGeneral().getExamenSolicitado().getCodigoExamenSolicitado());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLResultadoGeneral - Verificar si Resultado es un Antecedente: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
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
            System.err.println("Error en SQLResultadoGeneral - InsertarEnLog: " + sqlException.getMessage());
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