package Model.POJO;

import java.sql.Timestamp;

/**
 *
 * @author Brynner
 */
public class LogConsulta {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private PersonalTecnico personalTecnico;
    private Timestamp fechaHoraConsulta;
    private String consultaEjecutada;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public LogConsulta(PersonalTecnico personalTecnico, String consultaEjecutada) {
        this.personalTecnico = personalTecnico;
        this.consultaEjecutada = consultaEjecutada;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public PersonalTecnico getPersonalTecnico() {
        return personalTecnico;
    }

    public Timestamp getFechaHoraConsulta() {
        return fechaHoraConsulta;
    }

    public String getConsultaEjecutada() {
        return consultaEjecutada;
    }
    
    // </editor-fold>
    
}