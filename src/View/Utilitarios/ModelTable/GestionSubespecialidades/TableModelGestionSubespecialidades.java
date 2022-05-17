package View.Utilitarios.ModelTable.GestionSubespecialidades;

import Model.POJO.Subespecialidad;
import Model.POJOPersonalizado.SubespecialidadPersonalizada;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionSubespecialidades extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "SUBESPECIALIDAD", "ESPECIALIDAD", "# MUESTRAS BIOLOGICAS", "# ENFERMEDADES", "# EXAMENES"};
    private List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas;

    public void setSubespecialidadesPersonalizadas(List<SubespecialidadPersonalizada> subespecialidadesPersonalizadas) {
        this.subespecialidadesPersonalizadas = subespecialidadesPersonalizadas;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (subespecialidadesPersonalizadas != null) {
            subespecialidadesPersonalizadas.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return subespecialidadesPersonalizadas == null ? 0 : subespecialidadesPersonalizadas.size();
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
        final SubespecialidadPersonalizada subespecialidadPersonalizada = subespecialidadesPersonalizadas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return subespecialidadPersonalizada.getSubespecialidad().getCodigoSubespecialidad();

            case 2:
                return subespecialidadPersonalizada.getSubespecialidad().getSubespecialidadNombre();
                
            case 3:
                return subespecialidadPersonalizada.getSubespecialidad().getEspecialidad().getEspecialidadNombre();
                
            case 4:
                return subespecialidadPersonalizada.getTotalMuestrasBiologicas();
                
            case 5:
                return subespecialidadPersonalizada.getTotalEnfermedades();
                
            case 6:
                return subespecialidadPersonalizada.getTotalExamenes();

            default:
                return null;
        }
    }

    public Subespecialidad getSubespecialidad(final int rowIndex) {
        return subespecialidadesPersonalizadas.get(rowIndex).getSubespecialidad();
    }
}