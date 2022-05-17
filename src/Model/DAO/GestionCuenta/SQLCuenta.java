package Model.DAO.GestionCuenta;

import Model.DAO.DataBaseConfiguration;
import Model.POJO.Conexion;
import Model.POJO.Cuenta;
import Model.POJO.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.POJO.PersonalTecnico;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Brynner
 */
public class SQLCuenta {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final Conexion conexion = DataBaseConfiguration.CONEXION;

    private final String url = "jdbc:postgresql://" + conexion.getHost() + ":" + conexion.getPuerto() + "/" + conexion.getNombreBaseDatos();
    private final String user = conexion.getUsuario();
    private final String password = conexion.getPassword();
    
    private final String SQL_INSERTAR_PERSONA = "INSERT INTO aperson(papscodper, capspeceid, capsperape, capspernom, capspersex) VALUES(nextval('papscodper_sequence'), ?, ?, ?, ?)";
    private final String SQL_INSERTAR_PERSONAL_TECNICO = "INSERT INTO apertec(paptcopete, faptcodper, captperpro, captperhab) VALUES(nextval('paptcopete_sequence'), ?, ?, ?)";
    private final String SQL_INSERTAR_CUENTA = "INSERT INTO acuenta(pacncodcue, facncopete, cacncuecla, cacncuerol, cacncueest) VALUES(nextval('pacncodcue_sequence'), ?, crypt(?, gen_salt('md5')), ?, ?)";
    
    private final String SQL_OBTENER_PERSONAL_TECNICO_HABILITADOS = "SELECT papscodper, capspeceid, capsperape, capspernom, capspersex, paptcopete, captperpro, captpefein, to_char(captpehoin, 'HH24:MI:SS'), captperhab, pacncodcue, cacncuerol, cacncufere, to_char(cacncuhore, 'HH24:MI:SS'), cacncueest FROM aperson INNER JOIN apertec ON aperson.papscodper = apertec.faptcodper INNER JOIN acuenta ON apertec.paptcopete = acuenta.facncopete WHERE apertec.captperhab = TRUE AND acuenta.pacncodcue != ? AND acuenta.cacncueest = 1 ORDER BY acuenta.pacncodcue DESC";
    private final String SQL_OBTENER_PERSONAL_TECNICO_INHABILITADOS = "SELECT papscodper, capspeceid, capsperape, capspernom, capspersex, paptcopete, captperpro, captperhab, pacncodcue, cacncuerol, cacncufere, to_char(cacncuhore, 'HH24:MI:SS'), cacncueest FROM aperson INNER JOIN apertec ON aperson.papscodper = apertec.faptcodper INNER JOIN acuenta ON apertec.paptcopete = acuenta.facncopete WHERE apertec.captperhab = FALSE AND acuenta.cacncueest = 1 ORDER BY aperson.papscodper DESC";
    
    private final String SQL_ACTUALIZAR_PERSONA = "UPDATE aperson SET capspeceid = ?, capsperape = ?, capspernom = ?, capspersex = ? WHERE papscodper = ?";
    private final String SQL_ACTUALIZAR_PERSONAL_TECNICO = "UPDATE apertec SET captperpro = ? WHERE paptcopete = ?";
    
    private final String SQL_ELIMINAR_CUENTA = "UPDATE acuenta SET cacncueest = 0 WHERE pacncodcue = ? AND cacncueest = 1";
    
    private final String SQL_INHABILITAR_PERSONAL_TECNICO = "UPDATE apertec SET captpefefi = (SELECT CURRENT_DATE), captpehofi = (SELECT CURRENT_TIME), captperhab = FALSE WHERE paptcopete = ?";
    private final String SQL_AUTENTICAR = "SELECT papscodper, capspeceid, capsperape, capspernom, capspersex, paptcopete, captperpro, captpefein, to_char(captpehoin, 'HH24:MI:SS'), captperhab, pacncodcue, cacncuerol, cacncufere, to_char(cacncuhore, 'HH24:MI:SS'), cacncueest  FROM aperson INNER JOIN apertec ON aperson.papscodper = apertec.faptcodper INNER JOIN acuenta ON apertec.paptcopete = acuenta.facncopete WHERE aperson.capspeceid = ? AND acuenta.cacncuecla = crypt(?, acuenta.cacncuecla) AND acuenta.cacncueest = 1 LIMIT 1";
    private final String SQL_VERIFICAR_EXISTENCIA = "SELECT EXISTS (SELECT 1 FROM aperson INNER JOIN apertec ON aperson.papscodper = apertec.faptcodper INNER JOIN acuenta ON apertec.paptcopete = acuenta.facncopete WHERE aperson.papscodper != ? AND aperson.capspeceid = ? AND acuenta.cacncueest = 1)";
    private final String SQL_VERIFICAR_PASSWORD_VALIDO = "SELECT CASE WHEN (SELECT cacncuecla FROM acuenta WHERE pacncodcue = ? AND cacncueest = 1) = crypt(?, (SELECT cacncuecla FROM acuenta WHERE pacncodcue = ? AND cacncueest = 1)) THEN TRUE ELSE FALSE END";
    private final String SQL_CAMBIAR_PASSWORD = "UPDATE acuenta SET cacncuecla = crypt(?, gen_salt('md5')) WHERE pacncodcue = ? AND cacncueest = 1";
    
    
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection connection;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SQLCuenta() {
        connection = null;
        resultSet = null;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Queries">
    
    public Boolean insertar(final Cuenta cuenta) {
        try {
            final Persona persona = cuenta.getPersonalTecnico().getPersona();
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INSERTAR_PERSONA, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, persona.getPersonaCedulaIdentidad());
            statement.setString(2, persona.getPersonaApellido());
            statement.setString(3, persona.getPersonaNombre());
            statement.setString(4, persona.getPersonaSexo());

            if (statement.executeUpdate() == 1) {
                resultSet = statement.getGeneratedKeys();
                resultSet.next();
                final int CODIGO_PERSONA = resultSet.getInt(1);
                final PersonalTecnico personalTecnico = cuenta.getPersonalTecnico();

                statement = connection.prepareStatement(SQL_INSERTAR_PERSONAL_TECNICO, Statement.RETURN_GENERATED_KEYS);
                statement.setInt(1, CODIGO_PERSONA);
                statement.setString(2, personalTecnico.getPertecProfesion());
                statement.setBoolean(3, personalTecnico.getPertecHabilitado());

                if (statement.executeUpdate() == 1) {
                    resultSet = statement.getGeneratedKeys();
                    resultSet.next();
                    final int CODIGO_BIOQUIMICO = resultSet.getInt(1);

                    statement = connection.prepareStatement(SQL_INSERTAR_CUENTA);
                    statement.setInt(1, CODIGO_BIOQUIMICO);
                    statement.setString(2, cuenta.getCuentaClave());
                    statement.setString(3, cuenta.getCuentaRol());
                    statement.setInt(4, cuenta.getCuentaEstado());

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
            } else {
                connection.rollback();
                return false;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Insertar: " + sqlException.getMessage());
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
    
    public Boolean actualizar(final Cuenta cuenta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_ACTUALIZAR_PERSONA);
            statement.setString(1, cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad());
            statement.setString(2, cuenta.getPersonalTecnico().getPersona().getPersonaApellido());
            statement.setString(3, cuenta.getPersonalTecnico().getPersona().getPersonaNombre());
            statement.setString(4, cuenta.getPersonalTecnico().getPersona().getPersonaSexo());
            statement.setInt(5, cuenta.getPersonalTecnico().getPersona().getCodigoPersona());
            if (statement.executeUpdate() == 1) {
                statement = connection.prepareStatement(SQL_ACTUALIZAR_PERSONAL_TECNICO);
                statement.setString(1, cuenta.getPersonalTecnico().getPertecProfesion());
                statement.setInt(2, cuenta.getPersonalTecnico().getCodigoPersonalTecnico());
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
            System.err.println("Error en SQLCuenta - Actualizar: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCuenta - Actualizar: " + exception.getMessage());
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

    public List<Cuenta> obtenerCuentasPersonalesTecnicosHabilitados(final Cuenta cuentaLocal) {
        try {
            final List<Cuenta> cuentas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PERSONAL_TECNICO_HABILITADOS);
            statement.setInt(1, cuentaLocal.getCodigoCuenta());
            resultSet = statement.executeQuery();

            cuentas = new ArrayList<>();
            while (resultSet.next()) {
                final int pcodigo_persona = resultSet.getInt(1);
                final String cedula_identidad = resultSet.getString(2);
                final String persona_apellido = resultSet.getString(3);
                final String persona_nombre = resultSet.getString(4);
                final String personas_sexo = resultSet.getString(5);
                final int pcodigo_personal_tecnico = resultSet.getInt(6);
                final String pertec_profesion = resultSet.getString(7);
                final Date pertec_fecha_inicio = resultSet.getDate(8);
                final Time pertec_hora_inicio = resultSet.getTime(9);
                final Boolean pertec_habilitado = resultSet.getBoolean(10);
                final int pcodigo_cuenta = resultSet.getInt(11);
                final String cuenta_rol = resultSet.getString(12);
                final Date cuenta_fecha_registro = resultSet.getDate(13);
                final Time cuenta_hora_registro = resultSet.getTime(14);
                final int cuenta_estado = resultSet.getInt(15);
                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final PersonalTecnico personalTecnico = new PersonalTecnico(pcodigo_personal_tecnico, persona, pertec_profesion, pertec_fecha_inicio, pertec_hora_inicio, pertec_habilitado);
                final Cuenta cuenta = new Cuenta(pcodigo_cuenta, personalTecnico, null, cuenta_rol, cuenta_fecha_registro, cuenta_hora_registro, cuenta_estado);
                cuentas.add(cuenta);
            }
            return cuentas;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Obtener Personal Tecnico Habilitados: " + sqlException.getMessage());
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

    public List<Cuenta> obtenerCuentasPersonalesTecnicosInhabilitados() {
        try {
            final List<Cuenta> cuentas;
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_OBTENER_PERSONAL_TECNICO_INHABILITADOS);
            resultSet = statement.executeQuery();
            cuentas = new ArrayList<>();
            while (resultSet.next()) {
                final int pcodigo_persona = resultSet.getInt(1);
                final String cedula_identidad = resultSet.getString(2);
                final String persona_apellido = resultSet.getString(3);
                final String persona_nombre = resultSet.getString(4);
                final String personas_sexo = resultSet.getString(5);
                
                final int pcodigo_personal_tecnico = resultSet.getInt(6);
                final String pertec_profesion = resultSet.getString(7);
                final Boolean pertec_habilitado = resultSet.getBoolean(8);
                
                final int pcodigo_cuenta = resultSet.getInt(9);
                final String cuenta_rol = resultSet.getString(10);
                final Date cuenta_fecha_registro = resultSet.getDate(11);
                final Time cuenta_hora_registro = resultSet.getTime(12);
                final int cuenta_estado = resultSet.getInt(13);
                
                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, persona_apellido, persona_nombre, personas_sexo);
                final PersonalTecnico personalTecnico = new PersonalTecnico(pcodigo_personal_tecnico, persona, pertec_profesion, null, null, pertec_habilitado);
                final Cuenta cuenta = new Cuenta(pcodigo_cuenta, personalTecnico, null, cuenta_rol, cuenta_fecha_registro, cuenta_hora_registro, cuenta_estado);
                cuentas.add(cuenta);
            }
            return cuentas;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Obtener Personal Tecnico Inhabilitados: " + sqlException.getMessage());
            return null;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCuenta - Obtener Personal Tecnico Inhabilitados: " + exception.getMessage());
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
    
    public Boolean eliminar(final Cuenta cuenta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(SQL_INHABILITAR_PERSONAL_TECNICO);
            statement.setInt(1, cuenta.getPersonalTecnico().getCodigoPersonalTecnico());

            if (statement.executeUpdate() == 1) {
                statement = connection.prepareStatement(SQL_ELIMINAR_CUENTA);
                statement.setInt(1, cuenta.getCodigoCuenta());

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
            System.err.println("Error en SQLCuenta - Eliminar: " + sqlException.getMessage());
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

    public Cuenta autenticar(final String ci, final String clave) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_AUTENTICAR);
            statement.setString(1, ci);
            statement.setString(2, clave);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                final int pcodigo_persona = resultSet.getInt(1);
                final String cedula_identidad = resultSet.getString(2);
                final String apellido = resultSet.getString(3);
                final String nombre = resultSet.getString(4);
                final String sexo = resultSet.getString(5);
                
                final int pcodigo_personal_tecnico = resultSet.getInt(6);
                final String personal_tecnico_profesion = resultSet.getString(7);
                final Date personal_tecnico_fecha_inicio = resultSet.getDate(8);
                final Time personal_tecnico_hora_inicio = resultSet.getTime(9);
                final Boolean personal_tecnico_habilitado = resultSet.getBoolean(10);
                
                final int pcodigo_cuenta = resultSet.getInt(11);
                final String cuenta_rol = resultSet.getString(12);
                final Date cuenta_fecha_registro = resultSet.getDate(13);
                final Time cuenta_hora_registro = resultSet.getTime(14);
                final int cuenta_estado = resultSet.getInt(15);

                final Persona persona = new Persona(pcodigo_persona, cedula_identidad, apellido, nombre, sexo);
                final PersonalTecnico personalTecnico = new PersonalTecnico(pcodigo_personal_tecnico, persona, personal_tecnico_profesion, personal_tecnico_fecha_inicio, personal_tecnico_hora_inicio, personal_tecnico_habilitado);
                return new Cuenta(pcodigo_cuenta, personalTecnico, null, cuenta_rol, cuenta_fecha_registro, cuenta_hora_registro, cuenta_estado);
            } else {
                return null;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Autenticar: " + sqlException.getMessage());
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

    public int verificarExistencia(final Cuenta cuenta) {
        try {
            final Persona persona = cuenta.getPersonalTecnico().getPersona();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_EXISTENCIA);
            statement.setInt(1, persona.getCodigoPersona());
            statement.setString(2, persona.getPersonaCedulaIdentidad());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isExists = resultSet.getBoolean(1);

            if (isExists) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Verificar Existencia: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }

                if (!connection.isClosed() && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }
    
    public int verificarPasswordValido(final Cuenta cuenta) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_VERIFICAR_PASSWORD_VALIDO);
            statement.setInt(1, cuenta.getCodigoCuenta());
            statement.setString(2, cuenta.getCuentaClave());
            statement.setInt(3, cuenta.getCodigoCuenta());

            resultSet = statement.executeQuery();
            resultSet.next();
            final Boolean isValido = resultSet.getBoolean(1);

            if (isValido) {
                return 1;
            } else {
                return 0;
            }
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Verificar Password Valido: " + sqlException.getMessage());
            return -1;
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                
                if (!connection.isClosed() && !connection.isClosed()) {
                    connection.close();
                }
            } catch (final SQLException sqlException) {
                Logger.getLogger(SQLCuenta.class.getName()).log(Level.SEVERE, null, sqlException);
            }
        }
    }

    public boolean cambiarPassword(final Cuenta cuenta, final String nuevoPassword) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(SQL_CAMBIAR_PASSWORD);
            statement.setString(1, nuevoPassword);
            statement.setInt(2, cuenta.getCodigoCuenta());
            return statement.executeUpdate() == 1;
        } catch (final SQLException sqlException) {
            System.err.println("Error en SQLCuenta - Cambiar Password: " + sqlException.getMessage());
            return false;
        } catch (final Exception exception) {
            System.err.println("Error en SQLCuenta - Cambiar Password: " + exception.getMessage());
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