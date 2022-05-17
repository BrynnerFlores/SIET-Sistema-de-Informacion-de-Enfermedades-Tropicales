package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Reactivo {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoReactivo;
    private String nombre;
    private int estado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Reactivo(int codigoReactivo, String nombre, int estado) {
        this.codigoReactivo = codigoReactivo;
        this.nombre = nombre;
        this.estado = estado;
    }
    
    public Reactivo(String nombre, int estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoReactivo() {
        return codigoReactivo;
    }

    public void setCodigoReactivo(int codigoReactivo) {
        this.codigoReactivo = codigoReactivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    // </editor-fold>
    
}