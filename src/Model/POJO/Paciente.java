package Model.POJO;

import java.sql.Date;

/**
 *
 * @author Brynner
 */
public class Paciente {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPaciente;
    private Persona persona; 
    private Date pacienteFechaNacimiento;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Paciente(int codigoPaciente, Persona persona, Date pacienteFechaNacimiento) {
        this.codigoPaciente = codigoPaciente;
        this.persona = persona;
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }
    
    public Paciente(Persona persona, Date pacienteFechaNacimiento) {
        this.persona = persona;
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(int codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public Persona getPersona() {
        return persona;
    }
    
    public void setPersona(Persona persona) {    
        this.persona = persona;
    }
    
    public Date getPacienteFechaNacimiento() {
        return pacienteFechaNacimiento;
    }

    public void setPacienteFechaNacimiento(Date pacienteFechaNacimiento) {
        this.pacienteFechaNacimiento = pacienteFechaNacimiento;
    }
    
    // </editor-fold>
    
}