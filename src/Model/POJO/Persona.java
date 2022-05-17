package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Persona {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPersona;
    private String personaCedulaIdentidad;
    private String personaApellido;
    private String personaNombre;
    private String personaSexo;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public Persona(int codigoPersona, String personaCedulaIdentidad, String personaApellido, String personaNombre, String personaSexo) {
        this.codigoPersona = codigoPersona;
        this.personaCedulaIdentidad = personaCedulaIdentidad;
        this.personaApellido = personaApellido;
        this.personaNombre = personaNombre;
        this.personaSexo = personaSexo;
    }
    
    public Persona(String personaCedulaIdentidad, String personaApellido, String personaNombre, String personaSexo) {
        this.personaCedulaIdentidad = personaCedulaIdentidad;
        this.personaApellido = personaApellido;
        this.personaNombre = personaNombre;
        this.personaSexo = personaSexo;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getPersonaCedulaIdentidad() {
        return personaCedulaIdentidad;
    }

    public void setPersonaCedulaIdentidad(String personaCedulaIdentidad) {
        this.personaCedulaIdentidad = personaCedulaIdentidad;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaSexo() {
        return personaSexo;
    }

    public void setPersonaSexo(String personaSexo) {
        this.personaSexo = personaSexo;
    }
    
    // </editor-fold>
    
}