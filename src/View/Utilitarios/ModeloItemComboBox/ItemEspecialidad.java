package View.Utilitarios.ModeloItemComboBox;

import Model.POJO.Especialidad;

/**
 *
 * @author Brynner
 */
public class ItemEspecialidad {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEspecialidad;
    private String especialidadNombre;
    private int especialidadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public ItemEspecialidad(int codigoEspecialidad, String especialidadNombre, int especialidadEstado) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.especialidadNombre = especialidadNombre;
        this.especialidadEstado = especialidadEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public String getEspecialidadNombre() {
        return especialidadNombre;
    }

    public int getEspecialidadEstado() {
        return especialidadEstado;
    }
    
    // </editor-fold>
    
    @Override
    public String toString() {
        return getEspecialidadNombre();
    }
}