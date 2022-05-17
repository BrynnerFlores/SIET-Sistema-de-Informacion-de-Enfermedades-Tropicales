package View.Utilitarios.ModelTable.GestionRecepciones;

import Model.POJO.ParasitoEncontrado;

/**
 *
 * @author Brynner
 */
public class ParasitoDisponible {

    private ParasitoEncontrado parasitoEncontrado;
    private boolean selected;

    public ParasitoDisponible(ParasitoEncontrado parasitoEncontrado, boolean selected) {
        this.parasitoEncontrado = parasitoEncontrado;
        this.selected = selected;
    }

    public ParasitoEncontrado getParasitoEncontrado() {
        return parasitoEncontrado;
    }

    public void setParasitoEncontrado(ParasitoEncontrado parasitoEncontrado) {
        this.parasitoEncontrado = parasitoEncontrado;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}