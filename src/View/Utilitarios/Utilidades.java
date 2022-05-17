package View.Utilitarios;

import Model.POJO.PersonalTecnico;
import Model.POJO.Cuenta;
import Model.POJO.Persona;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Brynner
 */
public class Utilidades {
    
    // <editor-fold defaultstate="collapsed" desc="Obtener Cuenta Local">
    
    public static Cuenta obtenerCuentaLocal() {
        try {
            final String key = "gPyaP,;)9EbW}Gl@";
            final File encryptedFile = new File("siet-user-information.encrypted");
            final File decryptedFile = new File("siet-user-information.xml");
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
            
            
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document document = documentBuilder.parse(decryptedFile);
            
            final int codigoCuenta = Integer.valueOf(document.getElementsByTagName("CODIGO_CUENTA").item(0).getTextContent());
            final String cuentaRol = document.getElementsByTagName("CUENTA_ROL").item(0).getTextContent();
            final Date cuentaFechaRegistro = Date.valueOf(document.getElementsByTagName("CUENTA_FECHA_REGISTRO").item(0).getTextContent());
            final Time cuentaHoraRegistro = Time.valueOf(document.getElementsByTagName("CUENTA_HORA_REGISTRO").item(0).getTextContent());
            
            final int codigoBioquimico = Integer.valueOf(document.getElementsByTagName("CODIGO_PERSONAL_TECNICO").item(0).getTextContent());
            final String bioquimicoProfesion = document.getElementsByTagName("PERTEC_PROFESION").item(0).getTextContent();
            final Date bioquimicoFechaInicio = document.getElementsByTagName("PERTEC_FECHA_INICIO").item(0).getTextContent().equals("null") ? null : Date.valueOf(document.getElementsByTagName("PERTEC_FECHA_INICIO").item(0).getTextContent());
            final Time bioquimicoHoraInicio = document.getElementsByTagName("PERTEC_HORA_INICIO").item(0).getTextContent().equals("null") ? null : Time.valueOf(document.getElementsByTagName("PERTEC_HORA_INICIO").item(0).getTextContent());
            final boolean bioquimicoHabilitado = Boolean.parseBoolean(document.getElementsByTagName("PERTEC_HABILITADO").item(0).getTextContent());

            final int codigoPersona = Integer.valueOf(document.getElementsByTagName("CODIGO_PERSONA").item(0).getTextContent());
            final String personaCedulaIdentidad = document.getElementsByTagName("PERSONA_CI").item(0).getTextContent();
            final String personaApellido = document.getElementsByTagName("PERSONA_APELLIDO").item(0).getTextContent();
            final String personaNombre = document.getElementsByTagName("PERSONA_NOMBRE").item(0).getTextContent();
            final String personaSexo = document.getElementsByTagName("PERSONA_SEXO").item(0).getTextContent();
            
            decryptedFile.delete();
            
            final Persona persona = new Persona(codigoPersona, personaCedulaIdentidad, personaApellido, personaNombre, personaSexo);
            final PersonalTecnico bioquimico = new PersonalTecnico(codigoBioquimico, persona, bioquimicoProfesion, bioquimicoFechaInicio, bioquimicoHoraInicio, bioquimicoHabilitado);
            return new Cuenta(codigoCuenta, bioquimico, null, cuentaRol, cuentaFechaRegistro, cuentaHoraRegistro, 1);
        } catch (final ParserConfigurationException | DOMException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        } catch (CryptoException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SAXException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    // </editor-fold>
    
}