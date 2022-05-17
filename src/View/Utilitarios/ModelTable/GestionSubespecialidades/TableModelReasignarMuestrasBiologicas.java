package View.Utilitarios.ModelTable.GestionSubespecialidades;

import Model.POJO.SubespecialidadMuestra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelReasignarMuestrasBiologicas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "MUESTRA BIOLOGICA"};
    private List<SubespecialidadMuestra> subespecialidadesMuestras;

    public void setSubespecialidadesMuestras(List<SubespecialidadMuestra> subespecialidadesMuestras) {
        this.subespecialidadesMuestras = subespecialidadesMuestras;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (subespecialidadesMuestras != null) {
            subespecialidadesMuestras.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return subespecialidadesMuestras == null ? 0 : subespecialidadesMuestras.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return columnas[columnIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final SubespecialidadMuestra subespecialidadMuestra = subespecialidadesMuestras.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return subespecialidadMuestra.getMuestraBiologica().getMuestraBiologicaTipo();

            default:
                return null;
        }
    }
    
    public SubespecialidadMuestra getSubespecialidadMuestra(final int rowIndex) {
        return subespecialidadesMuestras.get(rowIndex);
    }
}