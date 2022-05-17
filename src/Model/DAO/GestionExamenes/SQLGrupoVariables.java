package Model.DAO.GestionExamenes;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Conexion;
import Model.POJO.Examen;
import Model.POJO.GrupoVariables;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
import Model.POJO.VariableExamen;
import View.Utilitarios.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brynner
 */
public class SQLGrupoVariables {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO agruvar(pagvcogrva, fagvcodexa, cagvgrvano, cagvgrvaes) VALUES(nextval('pagvcogrva_sequence'), ?, ?, ?)";
    private final String SQL_OBTENER_VARIABLES = "SELECT * FROM avarexa INNER JOIN agruvar ON agruvar.pagvcogrva = avarexa.favecogrva INNER JOIN aexamen ON aexamen.paemcodexa = agruvar.fagvcodexa INNER JOIN asubesp ON asubesp.pasecodsub = aexamen.faemcodsub WHERE pagvcogrva = ? AND cavevarest = 1 AND cagvgrvaes = 1 AND caemexaest = 1 ORDER BY pavecovaex";
    private final String SQL_ACTUALIZAR = "UPDATE agruvar SET cagvgrvano = ? WHERE pagvcogrva = ? AND cagvgrvaes = 1";
    private final String SQL_ELIMINAR_GRUPO = "UPDATE agruvar SET cagvgrvaes = 0 WHERE pagvcogrva = ? AND cagvgrvaes = 1";
    private final String SQL_ELIMINAR_VARIABLES = "UPDATE avarexa SET cavevarest = 0 WHERE favecogrva = ? AND cavevarest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM agruvar WHERE cagvgrvano = ? AND fagvcodexa = ? AND cagvgrvaes = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLGrupoVariables() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final GrupoVariables grupoVariables) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final Examen examen = grupoVariables.getExamen();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, examen.getCodigoExamen());
            statement.setString(2, grupoVariables.getGrupoVariableNombre());
            statement.setInt(3, grupoVariables.getGrupoVariableEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLGrupoVariable - Insertar: " + sqlException.getMessage());
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

    public List<VariableExamen> obtenerVariables(final GrupoVariables grupoVariables) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_VARIABLES));
            
            final List<VariableExamen> variablesExamen;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_VARIABLES);
            statement.setInt(1, grupoVariables.getCodigoGrupoVariable());
            resultSet = statement.executeQuery();

            variablesExamen = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoVariableExamen = resultSet.getInt(1);
                final String variableExamenNombre = resultSet.getString(3);
                final String variableExamenValorReferencia = resultSet.getString(4);
                final String variableExamenMetodo = resultSet.getString(5);
                final String variableTipoVariable = resultSet.getString(6);
                final Object variableValorMinimo = resultSet.getObject(7);
                final Object variableValorMaximo = resultSet.getObject(8);
                final int variableExamenEstado = resultSet.getInt(9);
                
                variablesExamen.add(new VariableExamen(codigoVariableExamen, grupoVariables, variableExamenNombre, variableExamenValorReferencia, variableExamenMetodo, variableTipoVariable, variableValorMinimo, variableValorMaximo, variableExamenEstado));
            }
            return variablesExamen;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLGrupoVariables - Obtener Variables: " + sqlException.getMessage());
            return null;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
                statement.close();
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public Boolean actualizar(final GrupoVariables grupoVariables) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, grupoVariables.getGrupoVariableNombre());
            statement.setInt(2, grupoVariables.getCodigoGrupoVariable());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLGrupoVariables - Actualizar: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && statement.isClosed()) {
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
    
    public Boolean eliminar(final GrupoVariables grupoVariables) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_VARIABLES));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR_GRUPO));
            
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_ELIMINAR_VARIABLES);
            statement.setInt(1, grupoVariables.getCodigoGrupoVariable());
            
            if (statement.executeUpdate() >= 0) {
                statement = connection.prepareStatement(SQL_ELIMINAR_GRUPO);
                statement.setInt(1, grupoVariables.getCodigoGrupoVariable());
                
                if (statement.executeUpdate() == 1) {
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
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLGrupoVariables - Eliminar: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && statement.isClosed()) {
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

    public int verificarExistencia(final GrupoVariables grupoVariables) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setString(1, grupoVariables.getGrupoVariableNombre());
            statement.setInt(2, grupoVariables.getExamen().getCodigoExamen());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLGrupoVariable - Verificar Existencia: " + sqlException.getMessage());
            return -1;
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
    
    public Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLGrupoVaraiables - InsertarEnLog: " + sqlException.getMessage());
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