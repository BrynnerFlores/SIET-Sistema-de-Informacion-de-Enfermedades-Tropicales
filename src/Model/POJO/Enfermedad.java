package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Enfermedad {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEnfermedad;
    private Subespecialidad subespecialidad;
    private String enfermedadNombre;
    private int enfermedadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Enfermedad(int codigoEnfermedad, Subespecialidad subespecialidad, String enfermedadNombre, int enfermedadEstado) {
        this.codigoEnfermedad = codigoEnfermedad;
        this.subespecialidad = subespecialidad;
        this.enfermedadNombre = enfermedadNombre;
        this.enfermedadEstado = enfermedadEstado;
    }
    
    public Enfermedad(Subespecialidad subespecialidad, String enfermedadNombre, int enfermedadEstado) {
        this.subespecialidad = subespecialidad;
        this.enfermedadNombre = enfermedadNombre;
        this.enfermedadEstado = enfermedadEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public void setCodigoEnfermedad(int codigoEnfermedad) {
        this.codigoEnfermedad = codigoEnfermedad;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public String getEnfermedadNombre() {
        return enfermedadNombre;
    }

    public void setEnfermedadNombre(String enfermedadNombre) {
        this.enfermedadNombre = enfermedadNombre;
    }

    public int getEnfermedadEstado() {
        return enfermedadEstado;
    }

    public void setEnfermedadEstado(int enfermedadEstado) {
        this.enfermedadEstado = enfermedadEstado;
    }

    // </editor-fold>
    
}