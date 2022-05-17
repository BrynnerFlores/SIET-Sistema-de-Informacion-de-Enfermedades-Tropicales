package View.Utilitarios.ModeloItemComboBox;

import Model.POJO.Especialidad;

/**
 *
 * @author Brynner
 */
public class ItemSubespecialidad {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoSubespecialidad;
    private Especialidad especialidad;
    private String subespecialidadNombre;
    private int subespecialidadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ItemSubespecialidad(int codigoSubespecialidad, Especialidad especialidad, String subespecialidadNombre, int subespecialidadEstado) {
        this.codigoSubespecialidad = codigoSubespecialidad;
        this.especialidad = especialidad;
        this.subespecialidadNombre = subespecialidadNombre;
        this.subespecialidadEstado = subespecialidadEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public int getCodigoSubespecialidad() {
        return codigoSubespecialidad;
    }

    public String getSubespecialidadNombre() {
        return subespecialidadNombre;
    }

    public int getSubespecialidadEstado() {
        return subespecialidadEstado;
    }
    
    // </editor-fold>

    @Override
    public String toString() {
        return getSubespecialidadNombre();
    }
}