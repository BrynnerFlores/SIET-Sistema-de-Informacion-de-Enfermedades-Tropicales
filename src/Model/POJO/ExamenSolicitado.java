package Model.POJO;


/**
 *
 * @author Brynner
 */
public class ExamenSolicitado {
    
    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private int codigoExamenSolicitado;
    private Recepcion recepcion;
    private Examen examen;
    private MuestraBiologica muestraBiologica;
    private int totalMuestrasBiologicas;
    private String muestraBiologicaEstado;
    private int examenSolicitadoEstado;    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public ExamenSolicitado(int codigoExamenSolicitado, Recepcion recepcion, Examen examen, MuestraBiologica muestraBiologica, int totalMuestrasBiologicas, String muestraBiologicaEstado, int examenSolicitadoEstado) {
        this.codigoExamenSolicitado = codigoExamenSolicitado;
        this.recepcion = recepcion;
        this.examen = examen;
        this.muestraBiologica = muestraBiologica;
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
        this.muestraBiologicaEstado = muestraBiologicaEstado;
        this.examenSolicitadoEstado = examenSolicitadoEstado;
    }
    
    public ExamenSolicitado(Recepcion recepcion, Examen examen, MuestraBiologica muestraBiologica, int totalMuestrasBiologicas, String muestraBiologicaEstado, int examenSolicitadoEstado) {
        this.recepcion = recepcion;
        this.examen = examen;
        this.muestraBiologica = muestraBiologica;
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
        this.muestraBiologicaEstado = muestraBiologicaEstado;
        this.examenSolicitadoEstado = examenSolicitadoEstado;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getCodigoExamenSolicitado() {
        return codigoExamenSolicitado;
    }

    public void setCodigoExamenSolicitado(int codigoExamenSolicitado) {
        this.codigoExamenSolicitado = codigoExamenSolicitado;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public MuestraBiologica getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(MuestraBiologica muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public int getTotalMuestrasBiologicas() {
        return totalMuestrasBiologicas;
    }

    public void setTotalMuestrasBiologicas(int totalMuestrasBiologicas) {
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
    }

    public String getMuestraBiologicaEstado() {
        return muestraBiologicaEstado;
    }

    public void setMuestraBiologicaEstado(String muestraBiologicaEstado) {
        this.muestraBiologicaEstado = muestraBiologicaEstado;
    }

    public int getExamenSolicitadoEstado() {
        return examenSolicitadoEstado;
    }

    public void setExamenSolicitadoEstado(int examenSolicitadoEstado) {
        this.examenSolicitadoEstado = examenSolicitadoEstado;
    }
    
    // </editor-fold>
    
}