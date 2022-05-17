package Model.POJOPersonalizado;

import Model.POJO.MuestraBiologica;

/**
 *
 * @author Brynner
 */
public class MuestraBiologicaPersonalizada {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private MuestraBiologica muestraBiologica;
    private int totalAspectos;
    private int totalParasitos;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

    public MuestraBiologicaPersonalizada(MuestraBiologica muestraBiologica, int totalAspectos, int totalParasitos) {
        this.muestraBiologica = muestraBiologica;
        this.totalAspectos = totalAspectos;
        this.totalParasitos = totalParasitos;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public MuestraBiologica getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public int getTotalAspectos() {
        return totalAspectos;
    }

    public void setTotalAspectos(int totalAspectos) {
        this.totalAspectos = totalAspectos;
    }
    
    public int getTotalParasitos() {
        return totalParasitos;
    }

    public void setTotalParasitos(int totalParasitos) {
        this.totalParasitos = totalParasitos;
    }
    // </editor-fold>

}