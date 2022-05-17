package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Conexion {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private String host;
    private int puerto;
    private String usuario;
    private String password;
    private String nombreBaseDatos;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Conexion(String host, int puerto, String usuario, String password, String nombreBaseDatos) {
        this.host = host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.password = password;
        this.nombreBaseDatos = nombreBaseDatos;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public String getHost() {
        return host;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    // </editor-fold>
    
}