package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Examen {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoExamen;
    private Subespecialidad subespecialidad;
    private String examenNombre;
    private int examenEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Examen(int codigoExamen, Subespecialidad subespecialidad, String examenNombre, int examenEstado) {
        this.codigoExamen = codigoExamen;
        this.subespecialidad = subespecialidad;
        this.examenNombre = examenNombre;
        this.examenEstado = examenEstado;
    }
        
    public Examen(Subespecialidad subespecialidad, String examenNombre, int examenEstado) {
        this.subespecialidad = subespecialidad;
        this.examenNombre = examenNombre;
        this.examenEstado = examenEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(int codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public String getExamenNombre() {
        return examenNombre;
    }

    public void setExamenNombre(String examenNombre) {
        this.examenNombre = examenNombre;
    }

    public int getExamenEstado() {
        return examenEstado;
    }

    public void setExamenEstado(int examenEstado) {
        this.examenEstado = examenEstado;
    }
    
    // </editor-fold>
    
}