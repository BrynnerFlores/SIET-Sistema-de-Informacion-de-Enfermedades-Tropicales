package View.Utilitarios.ModelTable.GestionEquipos.GestionEquiposActivos;

import Model.POJO.Equipo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Brynner
 */
public class TableModelGestionEquiposActivos extends AbstractTableModel {

    private final String[] columnas = {"Nº", "CODIGO", "NOMBRE", "MARCA", "MODELO", "SERIE", "FECHA ADQUISICION", "PROVEEDOR", "RESP. ENTREGA", "INTEGRIDAD", "AREA DE SERVICIO", "UBICACION"};
    private List<Equipo> equipos;

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
        fireTableDataChanged();
    }
    
    public void limpiarLista() {
        if (equipos != null) {
            equipos.clear();
            fireTableDataChanged();
        }
    }
    
    @Override
    public int getRowCount() {
        return equipos == null ? 0 : equipos.size();
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
        final Equipo equipo = equipos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;

            case 1:
                return equipo.getCodigoEquipo();

            case 2:
                return equipo.getEquipoNombre();

            case 3:
                return equipo.getEquipoMarca();

            case 4:
                return equipo.getEquipoModelo();
                
            case 5:
                return equipo.getEquipoNumeroSerie();

            case 6:
                return equipo.getEquipoFechaAdquisicion();

            case 7:
                return equipo.getEquipoProveedor();
                
            case 8:
                return equipo.getEquipoResponsableEntrega();
                
            case 9:
                return equipo.getEquipoIntegridad();

            case 10:
                return equipo.getSubespecialidad().getSubespecialidadNombre();
                
            case 11:
                return equipo.getEquipoUbicacion();

            default:
                return null;
        }
    }
    
    public Equipo getEquipo(final int rowIndex) {
        return equipos.get(rowIndex);
    }
}