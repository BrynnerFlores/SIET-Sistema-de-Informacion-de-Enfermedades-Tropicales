package Model.POJOPersonalizado;

import Model.POJO.Paciente;

/**
 *
 * @author Brynner
 */
public class PacientePersonalizado {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private Paciente paciente;
    private boolean pacienteEnSeguimiento;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PacientePersonalizado(Paciente paciente, boolean pacienteEnSeguimiento) {
        this.paciente = paciente;
        this.pacienteEnSeguimiento = pacienteEnSeguimiento;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public boolean isPacienteEnSeguimiento() {
        return pacienteEnSeguimiento;
    }
    
    public void setPacienteEnSeguimiento(boolean pacienteEnSeguimiento) {    
        this.pacienteEnSeguimiento = pacienteEnSeguimiento;
    }
    
    // </editor-fold>
    
}