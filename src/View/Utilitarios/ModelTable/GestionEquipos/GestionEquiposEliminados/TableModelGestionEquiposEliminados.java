package View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposEliminados;

import Model.POJO.EquipoEliminado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionEquiposEliminados extends AbstractTableModel {

    private final String[] columnas = {"Nº", "FECHA ELIMINACION", "HORA ELIMINACION", "EQUIPO", "MARCA", "MODELO", "SERIE", "FECHA ADQUISICION", "UBICACION"};
    private List<EquipoEliminado> equiposEliminados;

    public void setEquiposEliminados(List<EquipoEliminado> equiposEliminados) {
        this.equiposEliminados = equiposEliminados;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return equiposEliminados == null ? 0 : equiposEliminados.size();
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
        final EquipoEliminado equipoEliminado = equiposEliminados.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return equipoEliminado.getFechaEliminacion();

            case 2:
                return equipoEliminado.getHoraEliminacion();

            case 3:
                return equipoEliminado.getEquipo().getEquipoNombre();

            case 4:
                return equipoEliminado.getEquipo().getEquipoMarca();

            case 5:
                return equipoEliminado.getEquipo().getEquipoModelo();

            case 6:
                return equipoEliminado.getEquipo().getEquipoNumeroSerie();

            case 7:
                return equipoEliminado.getEquipo().getEquipoFechaAdquisicion();

            case 8:
                return equipoEliminado.getEquipo().getSubespecialidad().getSubespecialidadNombre();

            default:
                return null;
        }
    }

    public EquipoEliminado getEquipoEliminado(final int rowIndex) {
        return equiposEliminados.get(rowIndex);
    }
}