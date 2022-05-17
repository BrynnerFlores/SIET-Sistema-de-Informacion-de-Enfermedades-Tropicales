package View.Utilitarios.ModelTable.GestionExamenes;

import Model.POJO.GrupoVariables;
import Model.POJOPersonalizado.GrupoVariablesPersonalizado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelVerGrupoVariables extends AbstractTableModel {

    private final String[] columnas = {"Nº", "GRUPO VARIABLE", "# VARIABLES"};
    private List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados;

    public void setGruposVariablesPersonalizados(List<GrupoVariablesPersonalizado> gruposVariablesPersonalizados) {
        this.gruposVariablesPersonalizados = gruposVariablesPersonalizados;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (gruposVariablesPersonalizados != null) {
            gruposVariablesPersonalizados.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return gruposVariablesPersonalizados == null ? 0 : gruposVariablesPersonalizados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(final int colunIndex) {
        return columnas[colunIndex];
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final GrupoVariablesPersonalizado grupoVariablesPersonalizado = gruposVariablesPersonalizados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return grupoVariablesPersonalizado.getGrupoVariables().getGrupoVariableNombre();

            case 2:
                return grupoVariablesPersonalizado.getTotalVariables();

            default:
                return null;
        }
    }
    
    public GrupoVariables getGrupoVariables(final int rowIndex) {
        return gruposVariablesPersonalizados.get(rowIndex).getGrupoVariables();
    }
}