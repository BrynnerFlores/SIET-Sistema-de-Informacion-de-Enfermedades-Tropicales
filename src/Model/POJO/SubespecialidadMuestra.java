package Model.POJO;

/**
 *
 * @author Brynner
 */
public class SubespecialidadMuestra {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoSubespecialidadMuestra;
    private Subespecialidad subespecialidad;
    private MuestraBiologica muestraBiologica;
    private int subespecialidadMuestraEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
     public SubespecialidadMuestra(int codigoSubespecialidadMuestra, Subespecialidad subespecialidad, MuestraBiologica muestraBiologica, int subespecialidadMuestraEstado) {
        this.codigoSubespecialidadMuestra = codigoSubespecialidadMuestra;
        this.subespecialidad = subespecialidad;
        this.muestraBiologica = muestraBiologica;
        this.subespecialidadMuestraEstado = subespecialidadMuestraEstado;
    }
    
    public SubespecialidadMuestra(Subespecialidad subespecialidad, MuestraBiologica muestraBiologica, int subespecialidadMuestraEstado) {
        this.subespecialidad = subespecialidad;
        this.muestraBiologica = muestraBiologica;
        this.subespecialidadMuestraEstado = subespecialidadMuestraEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters"> 
    
    public int getCodigoSubespecialidadMuestra() {
        return codigoSubespecialidadMuestra;
    }

    public void setCodigoSubespecialidadMuestra(int codigoSubespecialidadMuestra) {
        this.codigoSubespecialidadMuestra = codigoSubespecialidadMuestra;
    }

    public Subespecialidad getSubespecialidad() {
        return subespecialidad;
    }

    public void setSubespecialidad(Subespecialidad subespecialidad) {
        this.subespecialidad = subespecialidad;
    }

    public MuestraBiologica getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public int getSubespecialidadMuestraEstado() {
        return subespecialidadMuestraEstado;
    }

    public void setSubespecialidadMuestraEstado(int subespecialidadMuestraEstado) {
        this.subespecialidadMuestraEstado = subespecialidadMuestraEstado;
    }
    
    // </editor-fold>
    
}