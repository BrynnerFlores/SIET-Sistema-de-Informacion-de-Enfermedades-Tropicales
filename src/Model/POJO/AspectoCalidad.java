package Model.POJO;

/**
 *
 * @author Brynner
 */
public class AspectoCalidad {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoAspectoCalidad;
    private MuestraBiologica muestraBiologica;
    private String aspectoCalidad;
    private int aspectoCalidadEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public AspectoCalidad(int codigoAspectoCalidad, MuestraBiologica muestraBiologica, String aspectoCalidad, int aspectoCalidadEstado) {
        this.codigoAspectoCalidad = codigoAspectoCalidad;
        this.muestraBiologica = muestraBiologica;
        this.aspectoCalidad = aspectoCalidad;
        this.aspectoCalidadEstado = aspectoCalidadEstado;
    }
    
    public AspectoCalidad(MuestraBiologica muestraBiologica, String aspectoCalidad, int aspectoCalidadEstado) {
        this.muestraBiologica = muestraBiologica;
        this.aspectoCalidad = aspectoCalidad;
        this.aspectoCalidadEstado = aspectoCalidadEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoAspectoCalidad() {
        return codigoAspectoCalidad;
    }

    public void setCodigoAspectoCalidad(int codigoAspectoCalidad) {
        this.codigoAspectoCalidad = codigoAspectoCalidad;
    }

    public MuestraBiologica getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public String getAspectoCalidad() {
        return aspectoCalidad;
    }

    public void setAspectoCalidad(String aspectoCalidad) {
        this.aspectoCalidad = aspectoCalidad;
    }

    public int getAspectoCalidadEstado() {
        return aspectoCalidadEstado;
    }

    public void setAspectoCalidadEstado(int aspectoCalidadEstado) {
        this.aspectoCalidadEstado = aspectoCalidadEstado;
    }
    
    // </editor-fold>
    
}