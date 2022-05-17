package Presenter.GestionRecepciones;

import Model.DAO.GestionRecepciones.SQLEstablecimiento;
import Model.DAO.GestionExamenes.SQLExamen;
import Model.DAO.GestionMuestraBiologica.SQLMuestraBiologica;
import Model.DAO.GestionRecepciones.SQLRecepcion;
import Model.DAO.GestionSubespecialidad.SQLSubespecialidadMuestra;
import Model.POJO.Establecimiento;
import Model.POJO.ExamenSolicitado;
import Model.POJO.MuestraBiologica;
import Model.POJO.Recepcion;
import Model.POJO.Subespecialidad;
import Model.POJO.SubespecialidadMuestra;
import Model.POJOPersonalizado.ExamenPersonalizado;
import Model.POJOPersonalizado.ExamenSolicitadoPersonalizado;
import Model.POJOPersonalizado.MuestraBiologicaPersonalizada;
import Model.POJOPersonalizado.RecepcionPersonalizada;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brynner
 */
public class PresenterGestionRecepciones {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLRecepcion sqlRecepcion;
    private final SQLExamen sqlExamen;
    private final SQLSubespecialidadMuestra sqlSubespecialidadMuestra;
    private final SQLEstablecimiento sqlEstablecimiento;
    private final SQLMuestraBiologica sqlMuestraBiologica;
    
    private CallBackObtenerExamenes callBackObtenerExamenes;
    private CallBackObtenerMuestrasBiologicas callBackObtenerMuestrasBiologicas;
    private CallBackRegistrarRecepcion callBackRegistrarRecepcion;
    private CallBackObtenerRecepciones callBackObtenerRecepciones;
    private CallBackObtenerExamenesSolicitados callBackObtenerExamenesSolicitados;
    private CallBackActualizarRecepcion callBackActualizarRecepcion;
    private CallBackEliminarRecepcion callBackEliminarRecepcion;
    private CallBackObtenerEstablecimientos callBackObtenerEstablecimientos;
    private CallBackGenerarCodigoRegistroLaboratorio callBackGenerarCodigoRegistroLaboratorio;
    private CallBackVerificarPermitirModificacion callBackVerificarPermitirModificacion;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterGestionRecepciones() {
        sqlRecepcion = new SQLRecepcion();
        sqlExamen = new SQLExamen();
        sqlSubespecialidadMuestra = new SQLSubespecialidadMuestra();
        sqlEstablecimiento = new SQLEstablecimiento();
        sqlMuestraBiologica = new SQLMuestraBiologica();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackObtenerExamenes(CallBackObtenerExamenes callBackObtenerExamenes) {
        this.callBackObtenerExamenes = callBackObtenerExamenes;
    }

    public void setCallBackObtenerMuestrasBiologicas(CallBackObtenerMuestrasBiologicas callBackObtenerMuestrasBiologicas) {
        this.callBackObtenerMuestrasBiologicas = callBackObtenerMuestrasBiologicas;
    }

    public void setCallBackRegistrarRecepcion(CallBackRegistrarRecepcion callBackRegistrarRecepcion) {
        this.callBackRegistrarRecepcion = callBackRegistrarRecepcion;
    }

    public void setCallBackObtenerRecepciones(CallBackObtenerRecepciones callBackObtenerRecepciones) {
        this.callBackObtenerRecepciones = callBackObtenerRecepciones;
    }

    public void setCallBackObtenerExamenesSolicitados(CallBackObtenerExamenesSolicitados callBackObtenerExamenesSolicitados) {
        this.callBackObtenerExamenesSolicitados = callBackObtenerExamenesSolicitados;
    }

    public void setCallBackActualizarRecepcion(CallBackActualizarRecepcion callBackActualizarRecepcion) {
        this.callBackActualizarRecepcion = callBackActualizarRecepcion;
    }

    public void setCallBackEliminarRecepcion(CallBackEliminarRecepcion callBackEliminarRecepcion) {
        this.callBackEliminarRecepcion = callBackEliminarRecepcion;
    }

    public void setCallBackObtenerEstablecimientos(CallBackObtenerEstablecimientos callBackObtenerEstablecimientos) {
        this.callBackObtenerEstablecimientos = callBackObtenerEstablecimientos;
    }

    public void setCallBackGenerarCodigoRegistroLaboratorio(CallBackGenerarCodigoRegistroLaboratorio callBackGenerarCodigoRegistroLaboratorio) {
        this.callBackGenerarCodigoRegistroLaboratorio = callBackGenerarCodigoRegistroLaboratorio;
    }

    public void setCallBackVerificarPermitirModificacion(CallBackVerificarPermitirModificacion callBackVerificarPermitirModificacion) {
        this.callBackVerificarPermitirModificacion = callBackVerificarPermitirModificacion;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void obtenerRecepciones(final int month, final int year) {
        try {
            final List<RecepcionPersonalizada> recepcionesPersonalizadas = sqlRecepcion.obtenerRecepciones(month, year);

            if (recepcionesPersonalizadas == null) {
                callBackObtenerRecepciones.errorObtenerRecepciones("Se produjo un error al obtener las recepciones.");
            } else if (recepcionesPersonalizadas.isEmpty()) {
                callBackObtenerRecepciones.listaRecepcionesVacia("No se encontraron registros de recepciones en la base de datos.");
            } else {
                callBackObtenerRecepciones.recepcionesObtenidas(recepcionesPersonalizadas);
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionRecepciones - Obtener Recepciones: " + exception.getMessage());
            callBackObtenerRecepciones.errorDesconocidoObtenerRecepciones("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void registrarRecepcion(final List<ExamenSolicitado> examenesSolicitados) {
        try {
            boolean isValid = false;
            OUTER:
            for (final ExamenSolicitado examenSolicitado : examenesSolicitados) {
                final Subespecialidad subespecialidad = examenSolicitado.getExamen().getSubespecialidad();
                final MuestraBiologica muestraBiologica = examenSolicitado.getMuestraBiologica();
                final SubespecialidadMuestra subespecialidadMuestra = new SubespecialidadMuestra(subespecialidad, muestraBiologica, 1);
                final int muestraValidation = sqlSubespecialidadMuestra.validarMuestra(subespecialidadMuestra);
                switch (muestraValidation) {
                    case 1:
                        isValid = true;
                        break;
                    case 0:
                        callBackRegistrarRecepcion.muestraNoValida("MUESTRA BIOLOGICA NO VALIDA.\n\nLa muestra biologica " + muestraBiologica.getMuestraBiologicaTipo() + ",\nno corresponde a la subespecialidad " + subespecialidad.getSubespecialidadNombre());
                        isValid = false;
                        break OUTER;
                    default:
                        callBackRegistrarRecepcion.errorValidarMuestra("Se produjo un error al validar la muestra.");
                        isValid = false;
                        break OUTER;
                }
            }

            if (isValid) {
                final boolean result = sqlRecepcion.insertar(examenesSolicitados);

                if (result) {
                    callBackRegistrarRecepcion.recepcionRegistrada("Recepcion registrada correctamente.");
                } else {
                    callBackRegistrarRecepcion.errorRegistrarRecepcion("No se pudo registrar la recepción.");
                }
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionRecepciones - Registrar Recepción: " + e.getMessage());
            callBackRegistrarRecepcion.errorDesconocidoRegistrarRecepcion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerExamenes() {
        try {
            final List<ExamenPersonalizado> examenesPersonalizados = sqlExamen.obtenerExamenes();

            if (examenesPersonalizados == null) {
                callBackObtenerExamenes.errorObtenerExamenes("Se produjo un error al intentar obtener a los examenes, vuelve a intentarlo.");
            } else if (examenesPersonalizados.isEmpty()) {
                callBackObtenerExamenes.listaExamenesVacia("No se encontraron registros de exámenes en la base de datos.");
            } else {
                callBackObtenerExamenes.examenesObtenidos(examenesPersonalizados);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionRecepciones - Obtener Examenes: " + e.getMessage());
            callBackObtenerExamenes.errorDesconocidoObtenerExamenes("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerMuestrasBiologicas() {
        try {
            final List<MuestraBiologicaPersonalizada> muestrasBiologicasBiologicaPersonalizadas = sqlMuestraBiologica.obtenerMuestrasBiologicas();

            if (muestrasBiologicasBiologicaPersonalizadas == null) {
                callBackObtenerMuestrasBiologicas.errorObtenerMuestrasBiologicas("Se produjo un error al intentar obtener a las muestras biológicas, vuelve a intentarlo.");
            } else if (muestrasBiologicasBiologicaPersonalizadas.isEmpty()) {
                callBackObtenerMuestrasBiologicas.listaMuestrasBiologicasVacia("No se encontraron registros de muestas biológicas en la base de datos.");
            } else {
                final List<MuestraBiologica> muestrasBiologicas = new ArrayList<>();
                muestrasBiologicasBiologicaPersonalizadas.forEach((muestraBiologicaPersonalizada) -> {
                    muestrasBiologicas.add(muestraBiologicaPersonalizada.getMuestraBiologica());
                });
                callBackObtenerMuestrasBiologicas.muestrasBiologicasObtenidas(muestrasBiologicas);
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionRecepciones - Obtener Muestras Biologicas: " + e.getMessage());
            callBackObtenerMuestrasBiologicas.errorDesconocidoObtenerMuestrasBiologicas("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerExamenesSolicitados(final Recepcion recepcion) {
        try {
            final List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados = sqlRecepcion.obtenerExamenesSolicitados(recepcion);

            if (examenesSolicitadosPersonalizados == null) {
                callBackObtenerExamenesSolicitados.errorObtenerExamenesSolicitados("Se produjo un error al obtener las examenes solicitados por la recepcion.");
            } else if (examenesSolicitadosPersonalizados.isEmpty()) {
                callBackObtenerExamenesSolicitados.listaExamenesSolicitadosVacia("No se encontraron registros de exámenes solicitados por la recepcion en la base de datos.");
            } else {
                callBackObtenerExamenesSolicitados.examenesSolicitadosObtenidos(examenesSolicitadosPersonalizados);
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionRecepciones - Obtener Examenes Solicitados: " + exception.getMessage());
            callBackObtenerExamenesSolicitados.errorDesconocidoObtenerExamenesSolicitados("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void obtenerEstablecimientos() {
        try {
            final List<Establecimiento> establecimientos = sqlEstablecimiento.obtenerEstablecimientos();

            if (establecimientos == null) {
                callBackObtenerEstablecimientos.errorObtenerEstablecimientos("Se produjo un error al obtener los establecimientos.");
            } else if (establecimientos.isEmpty()) {
                callBackObtenerEstablecimientos.listaEstablecimientosVacia("No se encontraron registros de establecimientos en la base de datos.");
            } else {
                callBackObtenerEstablecimientos.establecimientosObtenidos(establecimientos);
            }
        } catch (final Exception exception) {
            System.err.println("Error en PresenterGestionRecepciones - Obtener Establecimientos: " + exception.getMessage());
            callBackObtenerEstablecimientos.errorDesconocidoObtenerEstablecimientos("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    public void actualizarRecepcion(final List<ExamenSolicitado> examenesSolicitados) {
        try {
            final int resultadoPermitirModificacion = sqlRecepcion.verificarPermitirModificacion(examenesSolicitados.get(0).getRecepcion());

            switch (resultadoPermitirModificacion) {
                case -1:
                    callBackVerificarPermitirModificacion.errorVerificarPermisoModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;

                case 0:
                    boolean isValid = false;
                    OUTER:
                    for (final ExamenSolicitado examenSolicitado : examenesSolicitados) {
                        final Subespecialidad subespecialidad = examenSolicitado.getExamen().getSubespecialidad();
                        final MuestraBiologica muestraBiologica = examenSolicitado.getMuestraBiologica();
                        final SubespecialidadMuestra subespecialidadMuestra = new SubespecialidadMuestra(subespecialidad, muestraBiologica, 1);
                        final int muestraValidation = sqlSubespecialidadMuestra.validarMuestra(subespecialidadMuestra);
                        switch (muestraValidation) {
                            case 1:
                                isValid = true;
                                break;
                            case 0:
                                callBackActualizarRecepcion.muestraNoValida("La muestra " + muestraBiologica.getMuestraBiologicaTipo() + ",\nno corresponde a la subespecialidad " + subespecialidad.getSubespecialidadNombre());
                                isValid = false;
                                break OUTER;
                            default:
                                callBackActualizarRecepcion.errorValidarMuestra("Se produjo un error al validar la muestra.");
                                isValid = false;
                                break OUTER;
                        }
                    }

                    if (isValid) {
                        final boolean result = sqlRecepcion.actualizar(examenesSolicitados);

                        if (result) {
                            callBackActualizarRecepcion.recepcionActualizada("Recepcion actualizada correctamente.");
                        } else {
                            callBackActualizarRecepcion.errorActualizarRecepcion("No se pudo actualizar la recepcion.");
                        }
                    }
                    break;

                case 1:
                    callBackVerificarPermitirModificacion.permisoNegado("No es posible modificar la recepción. El plazo de 48 horas expiró.");
                    break;

                default:
                    callBackVerificarPermitirModificacion.errorVerificarPermisoModificacion("Se produjo un error, vuelve a intentarlo.");
                    break;
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionRecepciones - Actualizar Examenes: " + e.getMessage());
            callBackActualizarRecepcion.errorDesconocidoActualizarRecepcion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void eliminarRecepcion(final Recepcion recepcion) {
        try {
            if (sqlRecepcion.eliminarRecepcion(recepcion)) {
                callBackEliminarRecepcion.recepcionEliminada("");
            } else {
                callBackEliminarRecepcion.errorEliminarRecepcion("Se produjo un error al eliminar la recepción.");
            }
        } catch (final Exception e) {
            System.err.println("Error en PresenterGestionRecepciones - Eliminar Recepcion: " + e.getMessage());
            callBackEliminarRecepcion.errorDesconocidoEliminarRecepcion("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }
    
    public void generarCodigoRegistroLaboratorio() {
        try {
            final int yearServer = sqlRecepcion.obtenerYearServer();
            if (yearServer == -1) {
                callBackGenerarCodigoRegistroLaboratorio.errorGenerarCodigo("Se produjo un error, vuelve a intentarlo.");
            } else {
                final int resultTablaRecepcionesVacia = sqlRecepcion.verificarTablaVaciaRecepciones();

                switch (resultTablaRecepcionesVacia) {
                    case 0:
                        final String ultimoCodigoRegistroLaboratorio = sqlRecepcion.obtenerUltimoCodigoRegsitroLaboratorio();
                        if (ultimoCodigoRegistroLaboratorio == null) {
                            callBackGenerarCodigoRegistroLaboratorio.errorGenerarCodigo("Se produjo un error, vuelve a intentarlo.");
                        } else {
                            final int year = Integer.valueOf(ultimoCodigoRegistroLaboratorio.substring(ultimoCodigoRegistroLaboratorio.lastIndexOf("-") + 1));
                            final int count = Integer.valueOf(ultimoCodigoRegistroLaboratorio.substring(0, ultimoCodigoRegistroLaboratorio.lastIndexOf("-")));

                            if (year == yearServer) {
                                callBackGenerarCodigoRegistroLaboratorio.codigoGenerado((count + 1) + "-" + year);
                            } else if (year < yearServer) {
                                callBackGenerarCodigoRegistroLaboratorio.codigoGenerado("1-" + yearServer);
                            } else {
                                callBackGenerarCodigoRegistroLaboratorio.errorGenerarCodigo("Se produjo un error, vuelve a intentarlo.");
                            }
                        }
                        break;

                    case 1:
                        callBackGenerarCodigoRegistroLaboratorio.codigoGenerado("1-" + yearServer);
                        break;
                    default:
                        callBackGenerarCodigoRegistroLaboratorio.errorGenerarCodigo("Se produjo un error, vuelve a intentarlo.");
                        break;
                }
            }
        } catch (final NumberFormatException numberFormatException) {
            System.out.println("Error en PresenterGestionRecepciones - Generar Codigo Registro Laboratorio: " + numberFormatException.getMessage());
            callBackGenerarCodigoRegistroLaboratorio.errorDesconocidoGenerarCodigo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        } catch (final Exception exception) {
            System.out.println("Error en PresenterGestionRecepciones - Generar Codigo Registro Laboratorio: " + exception.getMessage());
            callBackGenerarCodigoRegistroLaboratorio.errorDesconocidoGenerarCodigo("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackObtenerRecepciones {

        void recepcionesObtenidas(final List<RecepcionPersonalizada> recepcionesPersonalizadas);

        void listaRecepcionesVacia(final String msg);

        void errorObtenerRecepciones(final String msg);

        void errorDesconocidoObtenerRecepciones(final String msg);
    }

    public interface CallBackObtenerExamenes {

        void examenesObtenidos(final List<ExamenPersonalizado> examenesPersonalizados);

        void listaExamenesVacia(final String msg);

        void errorObtenerExamenes(final String msg);

        void errorDesconocidoObtenerExamenes(final String msg);
    }

    public interface CallBackObtenerMuestrasBiologicas {

        void muestrasBiologicasObtenidas(final List<MuestraBiologica> muestrasBiologicas);

        void listaMuestrasBiologicasVacia(final String msg);

        void errorObtenerMuestrasBiologicas(final String msg);

        void errorDesconocidoObtenerMuestrasBiologicas(final String msg);
    }

    public interface CallBackRegistrarRecepcion {

        void recepcionRegistrada(final String msg);

        void errorRegistrarRecepcion(final String msg);

        void muestraValida(final String msg);

        void muestraNoValida(final String msg);

        void errorValidarMuestra(final String msg);

        void errorDesconocidoRegistrarRecepcion(final String msg);
    }

    public interface CallBackObtenerExamenesSolicitados {

        void examenesSolicitadosObtenidos(final List<ExamenSolicitadoPersonalizado> examenesSolicitadosPersonalizados);

        void listaExamenesSolicitadosVacia(final String msg);

        void errorObtenerExamenesSolicitados(final String msg);

        void errorDesconocidoObtenerExamenesSolicitados(final String msg);
    }

    public interface CallBackObtenerEstablecimientos {

        void establecimientosObtenidos(final List<Establecimiento> establecimientos);

        void listaEstablecimientosVacia(final String msg);

        void errorObtenerEstablecimientos(final String msg);

        void errorDesconocidoObtenerEstablecimientos(final String msg);
    }

    public interface CallBackActualizarRecepcion {

        void recepcionActualizada(final String msg);

        void errorActualizarRecepcion(final String msg);

        void muestraValida(final String msg);

        void muestraNoValida(final String msg);

        void errorValidarMuestra(final String msg);

        void aspectoValido(final String msg);

        void aspectoNoValido(final String msg);

        void errorValidarAspecto(final String msg);

        void errorDesconocidoActualizarRecepcion(final String msg);
    }
    
    public interface CallBackEliminarRecepcion {
        
        void recepcionEliminada(final String msg);
        
        void errorEliminarRecepcion(final String msg);
        
        void errorDesconocidoEliminarRecepcion(final String msg);
    }
    
    public interface CallBackGenerarCodigoRegistroLaboratorio {

        void codigoGenerado(final String codigo);

        void errorGenerarCodigo(final String msg);

        void errorDesconocidoGenerarCodigo(final String msg);

    }

    public interface CallBackVerificarPermitirModificacion {
        
        void permisoNegado(final String msg);

        void errorVerificarPermisoModificacion(final String msg);

    }

    // </editor-fold>
    
}