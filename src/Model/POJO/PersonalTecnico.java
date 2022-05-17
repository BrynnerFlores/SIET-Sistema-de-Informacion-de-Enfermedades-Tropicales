package Model.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class PersonalTecnico {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPersonalTecnico;
    private Persona persona;
    private String pertecProfesion;
    private Date pertecFechaInicio;
    private Time pertecHoraInicio;
    private Date pertecFechaFinal;
    private Time pertecHoraFinal;
    private Boolean pertecHabilitado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public PersonalTecnico(int codigoPersonalTecnico, Persona persona, String pertecProfesion, Date pertecFechaInicio, Time pertecHoraInicio, Date pertecFechaFinal, Time pertecHoraFinal, Boolean pertecHabilitado) {
        this.codigoPersonalTecnico = codigoPersonalTecnico;
        this.persona = persona;
        this.pertecProfesion = pertecProfesion;
        this.pertecFechaInicio = pertecFechaInicio;
        this.pertecHoraInicio = pertecHoraInicio;
        this.pertecFechaFinal = pertecFechaFinal;
        this.pertecHoraFinal = pertecHoraFinal;
        this.pertecHabilitado = pertecHabilitado;
    }
    
    public PersonalTecnico(int codigoPersonalTecnico, Persona persona, String pertecProfesion, Date pertecFechaInicio, Time pertecHoraInicio, Boolean pertecHabilitado) {
        this.codigoPersonalTecnico = codigoPersonalTecnico;
        this.persona = persona;
        this.pertecProfesion = pertecProfesion;
        this.pertecFechaInicio = pertecFechaInicio;
        this.pertecHoraInicio = pertecHoraInicio;
        this.pertecHabilitado = pertecHabilitado;
    }
    
    public PersonalTecnico(Persona persona, String pertecProfesion, Boolean pertecHabilitado) {
        this.persona = persona;
        this.pertecProfesion = pertecProfesion;
        this.pertecHabilitado = pertecHabilitado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getCodigoPersonalTecnico() {
        return codigoPersonalTecnico;
    }

    public void setCodigoPersonalTecnico(int codigoPersonalTecnico) {
        this.codigoPersonalTecnico = codigoPersonalTecnico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getPertecProfesion() {
        return pertecProfesion;
    }

    public void setPertecProfesion(String pertecProfesion) {
        this.pertecProfesion = pertecProfesion;
    }

    public Date getPertecFechaInicio() {
        return pertecFechaInicio;
    }

    public void setPertecFechaInicio(Date pertecFechaInicio) {
        this.pertecFechaInicio = pertecFechaInicio;
    }

    public Time getPertecHoraInicio() {
        return pertecHoraInicio;
    }

    public void setPertecHoraInicio(Time pertecHoraInicio) {
        this.pertecHoraInicio = pertecHoraInicio;
    }

    public Date getPertecFechaFinal() {
        return pertecFechaFinal;
    }

    public void setPertecFechaFinal(Date pertecFechaFinal) {
        this.pertecFechaFinal = pertecFechaFinal;
    }

    public Time getPertecHoraFinal() {
        return pertecHoraFinal;
    }

    public void setPertecHoraFinal(Time pertecHoraFinal) {
        this.pertecHoraFinal = pertecHoraFinal;
    }

    public Boolean getPertecHabilitado() {
        return pertecHabilitado;
    }

    public void setPertecHabilitado(Boolean pertecHabilitado) {
        this.pertecHabilitado = pertecHabilitado;
    }
    
    // </editor-fold>
}