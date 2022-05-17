package Presenter.Acceso;

import Model.DAO.GestionCuenta.SQLCuenta;
import Model.POJO.Cuenta;
import View.Utilitarios.CryptoException;
import View.Utilitarios.CryptoUtils;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Brynner
 */
public class PresenterIniciarSesion {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    
    private final SQLCuenta sqlCuenta;

    private CallBackIniciarSesion callBackIniciarSesion;
    private CallBackGuardarCuenta callBackGuardarCuenta;

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    
    public PresenterIniciarSesion() {
        sqlCuenta = new SQLCuenta();
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    
    public void setCallBackIniciarSesion(CallBackIniciarSesion callBackIniciarSesion) {
        this.callBackIniciarSesion = callBackIniciarSesion;
    }

    public void setCallBackGuardarCuenta(CallBackGuardarCuenta callBackGuardarCuenta) {
        this.callBackGuardarCuenta = callBackGuardarCuenta;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Metodos">
    
    public void iniciarSesion(final String ci, final String clave, final boolean mantenerSesionIniciada) {
        try {
            final Cuenta cuenta = sqlCuenta.autenticar(ci, clave);

            if (cuenta == null) {
                callBackIniciarSesion.errorIniciarSesion("Cédula de identidad y/o contraseña incorrecto(s).");
            } else {
                if (guardarCuenta(cuenta, mantenerSesionIniciada)) {
                    if (cifrarArchivo()) {
                        callBackIniciarSesion.credencialesCorrectos();
                    } else {
                        callBackGuardarCuenta.errorGuardarCuenta("Tu número de cédula de identidad y contraseña son correctos, sin embargo, ocurrió un error al intentar guardar la cuenta en el equipo. vuelve a iniciar sesión para acceder al sistema.");
                    }
                } else {
                    callBackGuardarCuenta.errorGuardarCuenta("Tu número de cédula de identidad y contraseña son correctos, sin embargo, ocurrió un error al intentar guardar la cuenta en el equipo. vuelve a iniciar sesión para acceder al sistema.");
                }
            }
        } catch (final Exception e) {
            System.err.println("Error: " + e.getMessage());
            callBackIniciarSesion.errorDesconocido("Se produjo un error desconocido, vuelve a intentarlo, si el problema persiste contactate con el desarrollador.");
        }
    }

    private Boolean guardarCuenta(final Cuenta cuenta, final boolean mantenerSesionIniciada) {
        try {
            final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            final Document document = documentBuilder.newDocument();

            // Elemento raiz
            final Element user = document.createElement("DATA");
            document.appendChild(user);

            // CUENTA
            Element element = document.createElement("CODIGO_CUENTA");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getCodigoCuenta())));
            user.appendChild(element);

            element = document.createElement("CUENTA_ROL");
            element.appendChild(document.createTextNode(cuenta.getCuentaRol()));
            user.appendChild(element);

            element = document.createElement("CUENTA_FECHA_REGISTRO");
            element.appendChild(document.createTextNode(cuenta.getCuentaFechaRegistro().toString()));
            user.appendChild(element);

            element = document.createElement("CUENTA_HORA_REGISTRO");
            element.appendChild(document.createTextNode(cuenta.getCuentaHoraRegistro().toString()));
            user.appendChild(element);

            // PERSONAL TECNICO
            element = document.createElement("CODIGO_PERSONAL_TECNICO");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getPersonalTecnico().getCodigoPersonalTecnico())));
            user.appendChild(element);

            element = document.createElement("PERTEC_PROFESION");
            element.appendChild(document.createTextNode(cuenta.getPersonalTecnico().getPertecProfesion()));
            user.appendChild(element);

            element = document.createElement("PERTEC_FECHA_INICIO");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getPersonalTecnico().getPertecFechaInicio())));
            user.appendChild(element);

            element = document.createElement("PERTEC_HORA_INICIO");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getPersonalTecnico().getPertecHoraInicio())));
            user.appendChild(element);

            element = document.createElement("PERTEC_HABILITADO");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getPersonalTecnico().getPertecHabilitado())));
            user.appendChild(element);

            // PERSONA
            element = document.createElement("CODIGO_PERSONA");
            element.appendChild(document.createTextNode(String.valueOf(cuenta.getPersonalTecnico().getPersona().getCodigoPersona())));
            user.appendChild(element);

            element = document.createElement("PERSONA_CI");
            element.appendChild(document.createTextNode(cuenta.getPersonalTecnico().getPersona().getPersonaCedulaIdentidad()));
            user.appendChild(element);

            element = document.createElement("PERSONA_APELLIDO");
            element.appendChild(document.createTextNode(cuenta.getPersonalTecnico().getPersona().getPersonaApellido()));
            user.appendChild(element);

            element = document.createElement("PERSONA_NOMBRE");
            element.appendChild(document.createTextNode(cuenta.getPersonalTecnico().getPersona().getPersonaNombre()));
            user.appendChild(element);

            element = document.createElement("PERSONA_SEXO");
            element.appendChild(document.createTextNode(cuenta.getPersonalTecnico().getPersona().getPersonaSexo()));
            user.appendChild(element);

            // Estado de la Sesion
            element = document.createElement("MANTENER_SESION_INICIADA");
            element.appendChild(document.createTextNode(String.valueOf(mantenerSesionIniciada)));
            user.appendChild(element);

            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource domSource = new DOMSource(document);
            final StreamResult streamResult = new StreamResult(new File("siet-user-information.xml"));

            transformer.transform(domSource, streamResult);
            return true;
        } catch (final ParserConfigurationException | TransformerException | DOMException e) {
            System.err.println("Error al guardar los datos de la cuenta: " + e.getMessage());
            return false;
        }
    }

    public boolean cifrarArchivo() {
        try {
            final String key = "gPyaP,;)9EbW}Gl@";
            File inputFile = new File("siet-user-information.xml");
            File encryptedFile = new File("siet-user-information.encrypted");

            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            inputFile.delete();
            return true;
        } catch (final CryptoException ex) {
            System.out.println("Error al cifrar: " + ex.getMessage());
            return false;
        }
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Interfaces">
    
    public interface CallBackIniciarSesion {

        void credencialesCorrectos();

        void errorIniciarSesion(final String msg);

        void errorDesconocido(final String msg);
    }

    public interface CallBackGuardarCuenta {

        void errorGuardarCuenta(final String msg);
    }

    // </editor-fold>
    
}