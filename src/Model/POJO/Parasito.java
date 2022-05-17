package Model.POJO;

/**
 *
 * @author Brynner
 */
public class Parasito {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoParasito;
    private MuestraBiologica muestraBiologica;
    private String parasitoNombre;
    private int parasitoEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public Parasito(int codigoParasito, MuestraBiologica muestraBiologica, String parasitoNombre, int parasitoEstado) {
        this.codigoParasito = codigoParasito;
        this.muestraBiologica = muestraBiologica;
        this.parasitoNombre = parasitoNombre;
        this.parasitoEstado = parasitoEstado;
    }
    
    public Parasito(MuestraBiologica muestraBiologica, String parasitoNombre, int parasitoEstado) {
        this.muestraBiologica = muestraBiologica;
        this.parasitoNombre = parasitoNombre;
        this.parasitoEstado = parasitoEstado;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public int getCodigoParasito() {
        return codigoParasito;
    }

    public void setCodigoParasito(int codigoParasito) {
        this.codigoParasito = codigoParasito;
    }

    public MuestraBiologica getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public String getParasitoNombre() {
        return parasitoNombre;
    }

    public void setParasitoNombre(String parasitoNombre) {
        this.parasitoNombre = parasitoNombre;
    }

    public int getParasitoEstado() {
        return parasitoEstado;
    }
    
    public void setParasitoEstado(int parasitoEstado) {    
        this.parasitoEstado = parasitoEstado;
    }
    
    // </editor-fold>
    
}