package Model.DAO.GestionMuestraBiologica;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.AspectoCalidad;
import Model.POJO.Conexion;
import Model.POJO.LogConsulta;
import Model.POJO.MuestraBiologica;
import Model.POJO.Parasito;
import Model.POJO.PersonalTecnico;
import Model.POJOPersonalizado.MuestraBiologicaPersonalizada;
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
public class SQLMuestraBiologica {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO amuebio(pambcomubi, cambmubiti, cambmubies) VALUES(nextval('pambcomubi_sequence'), ?, ?)";
    private final String SQL_OBTENER_TODOS = "SELECT * FROM amuebio WHERE amuebio.cambmubies = 1 ORDER BY amuebio.pambcomubi";
    private final String SQL_OBTENER_TOTAL_ASPECTOS = "SELECT COUNT(*) FROM aaspcal WHERE faaccomubi = ? AND faaccomubi IN (SELECT pambcomubi FROM amuebio WHERE cambmubies = 1) AND caacascaes = 1";
    private final String SQL_OBTENER_TOTAL_PARASITOS = "SELECT COUNT(*) FROM aparasi WHERE fapacomubi = ? AND fapacomubi IN (SELECT pambcomubi FROM amuebio WHERE cambmubies = 1) AND capaparest = 1";
    private final String SQL_ACTUALIZAR = "UPDATE amuebio SET cambmubiti = ? WHERE pambcomubi = ? AND cambmubies = 1";
    private final String SQL_ELIMINAR = "UPDATE amuebio SET cambmubies = 0 WHERE pambcomubi = ? AND cambmubies = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM amuebio WHERE cambmubiti = ? AND cambmubies = 1)";
    private final String SQL_OBTENER_ASPECTOS = "SELECT * FROM aaspcal INNER JOIN amuebio ON amuebio.pambcomubi = aaspcal.faaccomubi WHERE amuebio.pambcomubi = ? AND amuebio.cambmubies = 1 AND aaspcal.caacascaes = 1 ORDER BY aaspcal.paaccoasca";
    private final String SQL_OBTENER_PARASITOS = "SELECT * FROM aparasi INNER JOIN amuebio ON amuebio.pambcomubi = aparasi.fapacomubi WHERE amuebio.pambcomubi = ? AND amuebio.cambmubies = 1 AND aparasi.capaparest = 1 ORDER BY aparasi.papacodpar";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private ResultSet resultSetAux;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLMuestraBiologica() {
        connection = null;
        resultSet = null;
        resultSetAux = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setString(1, muestraBiologica.getMuestraBiologicaTipo());
            statement.setInt(2, muestraBiologica.getMuestraBiologicaEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLMuestraBiologica - Insertar: " + sqlException.getMessage());
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

    public List<MuestraBiologicaPersonalizada> obtenerMuestrasBiologicas() {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TODOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_ASPECTOS));
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_TOTAL_PARASITOS));
            
            final List<MuestraBiologicaPersonalizada> muestrasBiologicasPesonalizadas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_TODOS);
            resultSet = statement.executeQuery();

            muestrasBiologicasPesonalizadas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_muestra_biologica = resultSet.getInt(1);
                final String muestra_biologica_tipo = resultSet.getString(2);
                final int muestra_biologica_estado = resultSet.getInt(3);
                final MuestraBiologica muestraBiologica = new MuestraBiologica(codigo_muestra_biologica, muestra_biologica_tipo, muestra_biologica_estado);

                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_ASPECTOS);
                statement.setInt(1, muestraBiologica.getCodigoMuestraBiologica());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalAspecto = resultSetAux.getInt(1);
                
                statement = connection.prepareStatement(SQL_OBTENER_TOTAL_PARASITOS);
                statement.setInt(1, muestraBiologica.getCodigoMuestraBiologica());
                resultSetAux = statement.executeQuery();

                resultSetAux.next();

                final int totalParasitos = resultSetAux.getInt(1);

                muestrasBiologicasPesonalizadas.add(new MuestraBiologicaPersonalizada(muestraBiologica, totalAspecto, totalParasitos));
            }
            return muestrasBiologicasPesonalizadas;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLMuestraBiologica - Obtener Todos: " + sqlException.getMessage());
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
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public List<AspectoCalidad> obtenerAspectos(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_ASPECTOS));
            
            final List<AspectoCalidad> aspectos;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_ASPECTOS);
            statement.setInt(1, muestraBiologica.getCodigoMuestraBiologica());
            resultSet = statement.executeQuery();
            aspectos = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_aspecto = resultSet.getInt(1);
                final String aspecto_tipo = resultSet.getString(3);
                final int aspecto_estado = resultSet.getInt(4);

                aspectos.add(new AspectoCalidad(codigo_aspecto, muestraBiologica, aspecto_tipo, aspecto_estado));
            }
            return aspectos;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLMuestraBiologica - Obtener Aspectos: " + sqlException.getMessage());
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
    
    public List<Parasito> obtenerParasitos(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_PARASITOS));
            
            final List<Parasito> parasitos;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PARASITOS);
            statement.setInt(1, muestraBiologica.getCodigoMuestraBiologica());
            resultSet = statement.executeQuery();
            parasitos = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_parasito = resultSet.getInt(1);
                final String parasito_nombre = resultSet.getString(3);
                final int parasito_estado = resultSet.getInt(4);

                parasitos.add(new Parasito(codigo_parasito, muestraBiologica, parasito_nombre, parasito_estado));
            }
            return parasitos;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLMuestraBiologica - Obtener Parasitos: " + sqlException.getMessage());
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

    public Boolean actualizar(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, muestraBiologica.getMuestraBiologicaTipo());
            statement.setInt(2, muestraBiologica.getCodigoMuestraBiologica());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLMuestraBiologica - Actualizar: " + sqlException.getMessage());
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

    public Boolean eliminar(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, muestraBiologica.getCodigoMuestraBiologica());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.out.print("Error en SQLMuestrasBiologicas - Eliminar: " + sqlException.getMessage());
            return false;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException ex) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int verificarExistencia(final MuestraBiologica muestraBiologica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setString(1, muestraBiologica.getMuestraBiologicaTipo());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLMuestaBiologica - Verificar Existencia: " + sqlException.getMessage());
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
            System.err.println("Error en SQLMuestraBiologica - InsertarEnLog: " + sqlException.getMessage());
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