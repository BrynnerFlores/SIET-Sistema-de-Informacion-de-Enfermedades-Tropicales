package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.Examen;

/**
 *
 * @author Brynner
 */
public class ExamenDisponible {

    private Examen examen;
    private String muestraBiologica;
    private String estadoMuestraBiologica;
    private int totalMuestrasBiologicas;
    private boolean selected;

    public ExamenDisponible(Examen examen, String muestraBiologica, String estadoMuestraBiologica, int totalMuestrasBiologicas, boolean selected) {
        this.examen = examen;
        this.muestraBiologica = muestraBiologica;
        this.estadoMuestraBiologica = estadoMuestraBiologica;
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
        this.selected = selected;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public String getMuestraBiologica() {
        return muestraBiologica;
    }

    public void setMuestraBiologica(String muestraBiologica) {
        this.muestraBiologica = muestraBiologica;
    }

    public String getEstadoMuestraBiologica() {
        return estadoMuestraBiologica;
    }

    public void setEstadoMuestraBiologica(String estadoMuestraBiologica) {
        this.estadoMuestraBiologica = estadoMuestraBiologica;
    }

    public int getTotalMuestrasBiologicas() {
        return totalMuestrasBiologicas;
    }

    public void setTotalMuestrasBiologicas(int totalMuestrasBiologicas) {
        this.totalMuestrasBiologicas = totalMuestrasBiologicas;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}