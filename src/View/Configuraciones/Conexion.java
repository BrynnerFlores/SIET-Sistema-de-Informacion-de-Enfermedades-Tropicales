package View.Configuraciones;

/**
 *
 * @author Brynner
 */
public class Conexion {
    private String host;
    private int port;
    private String user;
    private String password;
    private String nameDataBase;

    public Conexion(String host, int port, String user, String password, String nameDataBase) {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.nameDataBase = nameDataBase;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNameDataBase() {
        return nameDataBase;
    }
}