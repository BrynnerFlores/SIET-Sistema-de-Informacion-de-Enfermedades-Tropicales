package Model.POJOPersonalizado;

import Model.POJO.Especialidad;

/**
 *
 * @author Brynner
 */
public class EspecialidadPersonalizada {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Especialidad especialidad;
    private int totalSubespecialidades;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public EspecialidadPersonalizada(Especialidad especialidad, int totalSubespecialidades) {
        this.especialidad = especialidad;
        this.totalSubespecialidades = totalSubespecialidades;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getTotalSubespecialidades() {
        return totalSubespecialidades;
    }

    public void setTotalSubespecialidades(int totalSubespecialidades) {
        this.totalSubespecialidades = totalSubespecialidades;
    }

    // </editor-fold>
}