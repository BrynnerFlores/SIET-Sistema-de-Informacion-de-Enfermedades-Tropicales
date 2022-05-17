package View.Utilitarios.ModeloItemComboBox;

import Model.POJO.Persona;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Brynner
 */
public class ItemPersonalTecnico {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoPersonalTecnico;
    private Persona persona;
    private String pertecProfesion;
    private Date pertecFechaInicio;
    private Time pertecHoraInicio;
    private Boolean pertecHabilitado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ItemPersonalTecnico(int codigoPersonalTecnico, Persona persona, String pertecProfesion, Date pertecFechaInicio, Time pertecHoraInicio, Boolean pertecHabilitado) {
        this.codigoPersonalTecnico = codigoPersonalTecnico;
        this.persona = persona;
        this.pertecProfesion = pertecProfesion;
        this.pertecFechaInicio = pertecFechaInicio;
        this.pertecHoraInicio = pertecHoraInicio;
        this.pertecHabilitado = pertecHabilitado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters">

    public int getCodigoPersonalTecnico() {
        return codigoPersonalTecnico;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getPertecProfesion() {
        return pertecProfesion;
    }

    public Date getPertecFechaInicio() {
        return pertecFechaInicio;
    }

    public Time getPertecHoraInicio() {
        return pertecHoraInicio;
    }

    public Boolean getPertecHabilitado() {
        return pertecHabilitado;
    }
    
    // </editor-fold>
    
    @Override
    public String toString() {
        return getPersona().getPersonaNombre() + " " + getPersona().getPersonaApellido();
    }
}