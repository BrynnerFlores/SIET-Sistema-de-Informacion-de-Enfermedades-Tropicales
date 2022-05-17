package View.Utilitarios.ModelTable.GestionEspecialidades;

import Model.POJO.Subespecialidad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelAsignarSubespecialidades extends AbstractTableModel {

    private final String[] columnas = {"Nº", "SUBESPECIALIDAD"};
    private List<Subespecialidad> subespecialidades;

    public void setSubespecialidades(List<Subespecialidad> subespecialidades) {
        this.subespecialidades = subespecialidades;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (subespecialidades != null) {
            subespecialidades.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return subespecialidades == null ? 0 : subespecialidades.size();
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
        final Subespecialidad subespecialidad = subespecialidades.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return subespecialidad.getSubespecialidadNombre();

            default:
                return null;
        }
    }

    public Subespecialidad getSubespecialidad(final int rowIndex) {
        return subespecialidades.get(rowIndex);
    }
}