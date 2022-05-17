package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Especialidad {    
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEspecialidad;
    private String especialidadNombre;
    private int especialidadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public Especialidad(int codigoEspecialidad, String especialidadNombre, int especialidadEstado) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.especialidadNombre = especialidadNombre;
        this.especialidadEstado = especialidadEstado;
    }
    
    public Especialidad(String especialidadNombre, int especialidadEstado) {
        this.especialidadNombre = especialidadNombre;
        this.especialidadEstado = especialidadEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(int codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public String getEspecialidadNombre() {
        return especialidadNombre;
    }

    public void setEspecialidadNombre(String especialidadNombre) {
        this.especialidadNombre = especialidadNombre;
    }

    public int getEspecialidadEstado() {
        return especialidadEstado;
    }

    public void setEspecialidadEstado(int especialidadEstado) {
        this.especialidadEstado = especialidadEstado;
    }
    
    // </editor-fold>
    
}