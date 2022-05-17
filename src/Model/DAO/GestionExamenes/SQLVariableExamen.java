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
public class SQLVariableExamen {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO avarexa(pavecovaex, favecogrva, cavevarnom, cavevavare, cavevarmet, cavetipvar, cavevalmin, cavevalmax, cavevarest) VALUES(nextval('pavecovaex_sequence'), ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQL_ACTUALIZAR = "UPDATE avarexa SET cavevarnom = ?, cavevavare = ?, cavevarmet = ?, cavetipvar = ?, cavevalmin = ?, cavevalmax = ? WHERE pavecovaex = ? AND cavevarest = 1";
    private final String SQL_OBTENER_VARIABLES_EXAMEN = "SELECT * FROM avarexa INNER JOIN agruvar ON agruvar.pagvcogrva = avarexa.favecogrva INNER JOIN aexamen ON aexamen.paemcodexa = agruvar.fagvcodexa WHERE aexamen.paemcodexa = ? AND agruvar.cagvgrvaes = 1 AND avarexa.cavevarest = 1 ORDER BY agruvar.pagvcogrva ASC, avarexa.pavecovaex ASC";
    private final String SQL_ELIMINAR = "UPDATE avarexa SET cavevarest = 0 WHERE pavecovaex = ? AND cavevarest = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM avarexa WHERE pavecovaex != ? AND favecogrva = ? AND cavevarnom = ? AND cavevarest = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLVariableExamen() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final VariableExamen variableExamen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final GrupoVariables grupoVariables = variableExamen.getGrupoVariables();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, grupoVariables.getCodigoGrupoVariable());
            statement.setString(2, variableExamen.getVariableExamenNombre());
            statement.setString(3, variableExamen.getVariableExamenValorReferencia());
            statement.setString(4, variableExamen.getVariableExamenMetodo());
            statement.setString(5, variableExamen.getVariableTipoVariable());
            statement.setObject(6, variableExamen.getVariableValorMinimo());
            statement.setObject(7, variableExamen.getVariableValorMaximo());
            statement.setInt(8, variableExamen.getVariableExamenEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLVariableExamen - Insertar: " + sqlException.getMessage());
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
    
    public List<VariableExamen> obtenerVariables(final Examen examen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_VARIABLES_EXAMEN));
            
            final List<VariableExamen> variablesExamen;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_VARIABLES_EXAMEN);
            statement.setInt(1, examen.getCodigoExamen());
            resultSet = statement.executeQuery();

            variablesExamen = new ArrayList<>();
            while (resultSet.next()) {
                final int codigoVariableExamen = resultSet.getInt(1);
                final String variableNombre = resultSet.getString(3);
                final String variableValorReferencia = resultSet.getString(4);
                final String variableMetodo = resultSet.getString(5);
                final String variableTipoVariable = resultSet.getString(6);
                final Object variableValorMinimo = resultSet.getObject(7);
                final Object variableValorMaximo = resultSet.getObject(8);
                final int variableEstado = resultSet.getInt(9);

                final int codigoGrupoVariable = resultSet.getInt(10);
                final String grupoVariableNombre = resultSet.getString(12);
                final int grupoVariableEstado = resultSet.getInt(13);

                final GrupoVariables grupoVariables = new GrupoVariables(codigoGrupoVariable, examen, grupoVariableNombre, grupoVariableEstado);
                final VariableExamen variableExamen = new VariableExamen(codigoVariableExamen, grupoVariables, variableNombre, variableValorReferencia, variableMetodo, variableTipoVariable, variableValorMinimo, variableValorMaximo, variableEstado);
                variablesExamen.add(variableExamen);
            }
            return variablesExamen;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLVariableExamen - Obtener Variables " + sqlException.getMessage());
            return null;
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

    public Boolean actualizar(final VariableExamen variableExamen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, variableExamen.getVariableExamenNombre());
            statement.setString(2, variableExamen.getVariableExamenValorReferencia());
            statement.setString(3, variableExamen.getVariableExamenMetodo());
            statement.setString(4, variableExamen.getVariableTipoVariable());
            statement.setObject(5, variableExamen.getVariableValorMinimo());
            statement.setObject(6, variableExamen.getVariableValorMaximo());
            statement.setInt(7, variableExamen.getCodigoVariableExamen());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLVariableExamen - Actualizar: " + sqlException.getMessage());
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
    
    public Boolean eliminar(final VariableExamen variableExamen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, variableExamen.getCodigoVariableExamen());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLVariableExamen - Eliminar: " + sqlException.getMessage());
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

    public int verificarExistencia(final VariableExamen variableExamen) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, variableExamen.getCodigoVariableExamen());
            statement.setInt(2, variableExamen.getGrupoVariables().getCodigoGrupoVariable());
            statement.setString(3, variableExamen.getVariableExamenNombre());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLVariableExamen - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLVariableExamen - InsertarEnLog: " + sqlException.getMessage());
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