package Model.POJO;

/**
 *
 * @author Brynner
 */
public class MuestraBiologica {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoMuestraBiologica;
    private String muestraBiologicaTipo;
    private int muestraBiologicaEstado;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">

     public MuestraBiologica(int codigoMuestraBiologica, String muestraBiologicaTipo, int muestraBiologicaEstado) {
        this.codigoMuestraBiologica = codigoMuestraBiologica;
        this.muestraBiologicaTipo = muestraBiologicaTipo;
        this.muestraBiologicaEstado = muestraBiologicaEstado;
    }
    
    public MuestraBiologica(String muestraBiologicaTipo, int muestraBiologicaEstado) {
        this.muestraBiologicaTipo = muestraBiologicaTipo;
        this.muestraBiologicaEstado = muestraBiologicaEstado;
    }
  
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
   
    public int getCodigoMuestraBiologica() {
        return codigoMuestraBiologica;
    }

    public void setCodigoMuestraBiologica(int codigoMuestraBiologica) {
        this.codigoMuestraBiologica = codigoMuestraBiologica;
    }

    public String getMuestraBiologicaTipo() {
        return muestraBiologicaTipo;
    }

    public void setMuestraBiologicaTipo(String muestraBiologicaTipo) {
        this.muestraBiologicaTipo = muestraBiologicaTipo;
    }

    public int getMuestraBiologicaEstado() {
        return muestraBiologicaEstado;
    }

    public void setMuestraBiologicaEstado(int muestraBiologicaEstado) {
        this.muestraBiologicaEstado = muestraBiologicaEstado;
    }
    
    // </editor-fold>
    
}