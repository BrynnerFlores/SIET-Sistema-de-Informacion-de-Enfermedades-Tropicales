package View.Utilitarios.ModeloItemComboBox;

import Model.POJO.Subespecialidad;

/**
 *
 * @author Brynner
 */
public class ItemEnfermedad {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoEnfermedad;
    private Subespecialidad subespecialidad;
    private String enfermedadNombre;
    private int enfermedadEstado;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ItemEnfermedad(int codigoEnfermedad, Subespecialidad subespecialidad, String enfermedadNombre, int enfermedadEstado) {
        this.codigoEnfermedad = codigoEnfermedad;
        this.subespecialidad = subespecialidad;
        this.enfermedadNombre = enfermedadNombre;
        this.enfermedadEstado = enfermedadEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">
    
    public int getCodigoEnfermedad() {
        return codigoEnfermedad;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public String getEnfermedadNombre() {
        return enfermedadNombre;
    }
    
    public int getEnfermedadEstado() {    
        return enfermedadEstado;
    }

    // </editor-fold>
    
    @Override
    public String toString() {
        return getEnfermedadNombre();
    }
}