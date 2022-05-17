package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Subespecialidad {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoSubespecialidad;
    private Especialidad especialidad;
    private String subespecialidadNombre;
    private int subespecialidadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Subespecialidad(int codigoSubespecialidad, Especialidad especialidad, String subespecialidadNombre, int subespecialidadEstado) {
        this.codigoSubespecialidad = codigoSubespecialidad;
        this.especialidad = especialidad;
        this.subespecialidadNombre = subespecialidadNombre;
        this.subespecialidadEstado = subespecialidadEstado;
    }
    
    public Subespecialidad(Especialidad especialidad, String subespecialidadNombre, int subespecialidadEstado) {
        this.especialidad = especialidad;
        this.subespecialidadNombre = subespecialidadNombre;
        this.subespecialidadEstado = subespecialidadEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getCodigoSubespecialidad() {
        return codigoSubespecialidad;
    }

    public void setCodigoSubespecialidad(int codigoSubespecialidad) {
        this.codigoSubespecialidad = codigoSubespecialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getSubespecialidadNombre() {
        return subespecialidadNombre;
    }

    public void setSubespecialidadNombre(String subespecialidadNombre) {
        this.subespecialidadNombre = subespecialidadNombre;
    }

    public int getSubespecialidadEstado() {
        return subespecialidadEstado;
    }

    public void setSubespecialidadEstado(int subespecialidadEstado) {
        this.subespecialidadEstado = subespecialidadEstado;
    }
    
    // </editor-fold>
}