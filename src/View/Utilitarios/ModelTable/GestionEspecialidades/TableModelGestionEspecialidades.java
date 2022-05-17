package View.Utilitarios.ModelTable.GestionEspecialidades;

import Model.POJO.Especialidad;
import Model.POJOPersonalizado.EspecialidadPersonalizada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionEspecialidades extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "ESPECIALIDAD", "# SUBESPECIALIDADES"};
    private List<EspecialidadPersonalizada> especialidadesPersonalizadas;

    public void setEspecialidadesPersonalizadas(List<EspecialidadPersonalizada> especialidadesPersonalizadas) {
        this.especialidadesPersonalizadas = especialidadesPersonalizadas;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (especialidadesPersonalizadas != null) {
            especialidadesPersonalizadas.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return especialidadesPersonalizadas == null ? 0 : especialidadesPersonalizadas.size();
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
        final EspecialidadPersonalizada especialidadPersonalizada = especialidadesPersonalizadas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return especialidadPersonalizada.getEspecialidad().getCodigoEspecialidad();

            case 2:
                return especialidadPersonalizada.getEspecialidad().getEspecialidadNombre();

            case 3:
                return especialidadPersonalizada.getTotalSubespecialidades();

            default:
                return null;
        }
    }

    public Especialidad getEspecialidad(final int rowIndex) {
        return especialidadesPersonalizadas.get(rowIndex).getEspecialidad();
    }
}