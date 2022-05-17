package Model.DAO.GestionEquipo;

import Model.DAO.DataBaseConfiguration;
import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Caracteriztica;
import Model.POJO.Conexion;
import Model.POJO.Equipo;
import Model.POJO.LogConsulta;
import Model.POJO.PersonalTecnico;
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
public class SQLCaracteriztica {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();

    private final String SQL_INSERTAR_EN_LOG = "INSERT INTO alogcon(palccoloco, falccopete, calcconeje) VALUES(nextval('palccoloco_sequence'), ?, ?)";
    private final String SQL_INSERTAR = "INSERT INTO aequcar(paeccoeqca, faeccodequ, caecequcar, caeceqcava, caeceqcaes) VALUES(nextval('paeccoeqca_sequence'), ?, ?, ?, ?)";
    private final String SQL_OBTENER_CARACTERIZTICAS = "SELECT * FROM aequcar WHERE faeccodequ = ? AND caeceqcaes = 1 ORDER BY paeccoeqca";
    private final String SQL_ACTUALIZAR = "UPDATE aequcar SET caecequcar = ?, caeceqcava = ? WHERE paeccoeqca = ? AND caeceqcaes = 1";
    private final String SQL_ELIMINAR = "UPDATE aequcar SET caeceqcaes = 0 WHERE paeccoeqca = ? AND caeceqcaes = 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aequcar WHERE faeccodequ = ? AND caecequcar = ? AND caeceqcava = ? AND caeceqcaes = 1)";
    private final PersonalTecnico PERSONAL_TECNICO;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLCaracteriztica() {
        connection = null;
        resultSet = null;
        PERSONAL_TECNICO = Utilidades.obtenerCuentaLocal().getPersonalTecnico();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Caracteriztica caracteriztica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_INSERTAR));
            
            final Equipo equipo = caracteriztica.getEquipo();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR);
            statement.setInt(1, equipo.getCodigoEquipo());
            statement.setString(2, caracteriztica.getEquipoCaracteriztica());
            statement.setString(3, caracteriztica.getEquipoCaracterizticaValor());
            statement.setInt(4, caracteriztica.getEquipoCaracterizticaEstado());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - Insertar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCaracteriztica - Insertar: " + exception.getMessage());
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

    public List<Caracteriztica> obtenerCaracterizticas(final Equipo equipo) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_OBTENER_CARACTERIZTICAS));
            
            final List<Caracteriztica> caracterizticas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_CARACTERIZTICAS);
            statement.setInt(1, equipo.getCodigoEquipo());
            resultSet = statement.executeQuery();

            caracterizticas = new ArrayList<>();
            while (resultSet.next()) {
                final int codigo_equipo_caracteriztica = resultSet.getInt(1);
                final String equipo_caracteriztica = resultSet.getString(3);
                final String equipo_caractetiztica_valor = resultSet.getString(4);
                final int equipo_caracteriztica_estado = resultSet.getInt(5);
                caracterizticas.add(new Caracteriztica(codigo_equipo_caracteriztica, equipo, equipo_caracteriztica, equipo_caractetiztica_valor, equipo_caracteriztica_estado));
            }
            return caracterizticas;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - Obtener Caracterizticas: " + sqlException.getMessage());
            return null;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCaracteriztica - Obtener Caracterizticas: " + exception.getMessage());
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

    public Boolean actualizar(final Caracteriztica caracteriztica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ACTUALIZAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ACTUALIZAR);
            statement.setString(1, caracteriztica.getEquipoCaracteriztica());
            statement.setString(2, caracteriztica.getEquipoCaracterizticaValor());
            statement.setInt(3, caracteriztica.getCodigoEquipoCaracteriztica());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - Actualizar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCaracteriztica - Actualizar: " + exception.getMessage());
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

    public Boolean eliminar(final Caracteriztica caracteriztica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_ELIMINAR));
            
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_ELIMINAR);
            statement.setInt(1, caracteriztica.getCodigoEquipoCaracteriztica());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - Eliminar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCaracteriztica - Eliminar: " + exception.getMessage());
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

    public int verificarExistencia(final Caracteriztica caracteriztica) {
        try {
            insertarEnLog(new LogConsulta(PERSONAL_TECNICO, SQL_VERIFICAR_EXISTENCIA));
            
            final Equipo equipo = caracteriztica.getEquipo();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, equipo.getCodigoEquipo());
            statement.setString(2, caracteriztica.getEquipoCaracteriztica());
            statement.setString(3, caracteriztica.getEquipoCaracterizticaValor());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - Verificar Existencia: " + sqlException.getMessage());
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
    
    private Boolean insertarEnLog(final LogConsulta logConsulta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_INSERTAR_EN_LOG);
            statement.setInt(1, logConsulta.getPersonalTecnico().getCodigoPersonalTecnico());
            statement.setString(2, logConsulta.getConsultaEjecutada());

            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCaracteriztica - InsertarEnLog: " + sqlException.getMessage());
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