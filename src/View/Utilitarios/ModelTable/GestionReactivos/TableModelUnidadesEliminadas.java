package View.Utilitarios.ModelTable.GestionReactivos;

import Model.POJO.UnidadEliminada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelUnidadesEliminadas extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CAUSA DE ELIMINACION", "FECHA ELIMINACION", "HORA ELIMINACION"};
    private List<UnidadEliminada> unidadesEliminadas;

    public void setUnidadesEliminadas(List<UnidadEliminada> unidadesEliminadas) {
        this.unidadesEliminadas = unidadesEliminadas;
    }
    
    public void limpiarLista() {
        if (unidadesEliminadas != null) {
            unidadesEliminadas.clear();
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return unidadesEliminadas == null ? 0 : unidadesEliminadas.size();
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
        final UnidadEliminada unidadEliminada = unidadesEliminadas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return unidadEliminada.getCausaEliminacion();

            case 2:
                return unidadEliminada.getFechaEliminacion();

            case 3:
                return unidadEliminada.getHoraEliminacion();

            default:
                return null;
        }
    }
}