package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.TecnicaAplicada;

/**
 *
 * @author Brynner
 */
public class TecnicaDisponible {

    private TecnicaAplicada tecnicaAplicada;
    private boolean selected;

    public TecnicaDisponible(TecnicaAplicada tecnicaAplicada, boolean selected) {
        this.tecnicaAplicada = tecnicaAplicada;
        this.selected = selected;
    }

    public TecnicaAplicada getTecnicaAplicada() {
        return tecnicaAplicada;
    }

    public void setTecnicaAplicada(TecnicaAplicada tecnicaAplicada) {
        this.tecnicaAplicada = tecnicaAplicada;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}