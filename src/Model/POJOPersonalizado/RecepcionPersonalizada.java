package Model.POJOPersonalizado;

import Model.POJO.Recepcion;

/**
 *
 * @author Brynner
 */
public class RecepcionPersonalizada {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">

    private Recepcion recepcion;
    private int totalExamenesSolicitados;
    private int totalExamenesPendientes;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public RecepcionPersonalizada(Recepcion recepcion, int totalExamenesSolicitados, int totalExamenesPendientes) {
        this.recepcion = recepcion;
        this.totalExamenesSolicitados = totalExamenesSolicitados;
        this.totalExamenesPendientes = totalExamenesPendientes;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public int getTotalExamenesSolicitados() {
        return totalExamenesSolicitados;
    }

    public void setTotalExamenesSolicitados(int totalExamenesSolicitados) {
        this.totalExamenesSolicitados = totalExamenesSolicitados;
    }
    
    public int getTotalExamenesPendientes() {
        return totalExamenesPendientes;
    }
    
    // </editor-fold>

}