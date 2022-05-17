package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.Examen;
import Model.POJO.MuestraBiologica;

/**
 *
 * @author Brynner
 */
public class ExamenSeleccionado {
    
    private Examen examen;
    private MuestraBiologica muestraBiologica;
    private int totalMuestrasBiologicas;
    private String estadoMuestraBiologica;

    public ExamenSeleccionado(Examen examen, MuestraBiologica muestraBiologica, int totalMuestrasBiologicas, String estadoMuestraBiologica) {
        this.examen = examen;
        this.muestraBiologica = muestraBiologica;
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
        this.estadoMuestraBiologica = estadoMuestraBiologica;
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

    public String getEstadoMuestraBiologica() {
        return estadoMuestraBiologica;
    }

    public void setEstadoMuestraBiologica(String estadoMuestraBiologica) {
        this.estadoMuestraBiologica = estadoMuestraBiologica;
    }
}