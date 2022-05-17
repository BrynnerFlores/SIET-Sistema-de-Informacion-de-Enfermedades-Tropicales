package Model.POJOPersonalizado;

import Model.POJO.SeguimientoPaciente;

/**
 *
 * @author Brynner
 */
public class SeguimientoPacientePersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private SeguimientoPaciente seguimientoPaciente;
    private int totalControles;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public SeguimientoPacientePersonalizado(SeguimientoPaciente seguimientoPaciente, int totalControles) {
        this.seguimientoPaciente = seguimientoPaciente;
        this.totalControles = totalControles;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public SeguimientoPaciente getSeguimientoPaciente() {
        return seguimientoPaciente;
    }

    public void setSeguimientoPaciente(SeguimientoPaciente seguimientoPaciente) {
        this.seguimientoPaciente = seguimientoPaciente;
    }

    public int getTotalControles() {
        return totalControles;
    }

    public void setTotalControles(int totalControles) {
        this.totalControles = totalControles;
    }
    
    // </editor-fold>
    
}