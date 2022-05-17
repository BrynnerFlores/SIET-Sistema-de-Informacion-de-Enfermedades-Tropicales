package Model.DAO;

import Model.POJO.Conexion;
import View.Configuraciones.ConexionBaseDatos;

import View.Utilitarios.CryptoException;
import View.Utilitarios.CryptoUtils;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Brynner
 */
public class DataBaseConfiguration {

    public static final Conexion CONEXION = obtenerConexion();

    private static Conexion obtenerConexion() {
        Conexion conexion = null;

        final String key = "gPyaP,;)9EbW}Gl@";
        final File encryptedFile = new File("conection-data-base.encrypted");
        final File decryptedFile = new File("conection-data-base.xml");

        if (encryptedFile.exists()) {
            try {
                CryptoUtils.decrypt(key, encryptedFile, decryptedFile);

                final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                final Document document = documentBuilder.parse(decryptedFile);

                final String host = document.getElementsByTagName("HOST").item(0).getTextContent();
                final int puerto = Integer.valueOf(document.getElementsByTagName("PUERTO").item(0).getTextContent());
                final String usuario = document.getElementsByTagName("USUARIO").item(0).getTextContent();
                final String password = document.getElementsByTagName("PASSWORD").item(0).getTextContent();
                final String nombreBaseDatos = document.getElementsByTagName("NOMBRE_BASE_DATOS").item(0).getTextContent();

                decryptedFile.delete();

                conexion = new Conexion(host, puerto, usuario, password, nombreBaseDatos);
            } catch (final ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(DataBaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
                conexion = new Conexion("", 5432, "", "", "");
            } catch (CryptoException ex) {
                Logger.getLogger(DataBaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            conexion = new Conexion("", 5432, "", "", "");
            if (!crearArchivo(conexion)) {
                System.err.println("Error al crear archivo de conexion a base de datos.");
            }
        }
        return conexion;
    }

    public static boolean crearArchivo(final Conexion conexion) {
        try {
            final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            final Document document = documentBuilder.newDocument();
            
            // Elemento raiz
            final Element user = document.createElement("DATA");
            document.appendChild(user);

            // CUENTA
            Element element = document.createElement("HOST");
            element.appendChild(document.createTextNode(conexion.getHost()));
            user.appendChild(element);

            element = document.createElement("PUERTO");
            element.appendChild(document.createTextNode(String.valueOf(conexion.getPuerto())));
            user.appendChild(element);

            element = document.createElement("USUARIO");
            element.appendChild(document.createTextNode(conexion.getUsuario()));
            user.appendChild(element);

            element = document.createElement("PASSWORD");
            element.appendChild(document.createTextNode(conexion.getPassword()));
            user.appendChild(element);

            element = document.createElement("NOMBRE_BASE_DATOS");
            element.appendChild(document.createTextNode(conexion.getNombreBaseDatos()));
            user.appendChild(element);

            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource domSource = new DOMSource(document);
            final StreamResult streamResult = new StreamResult(new File("conection-data-base.xml"));
            transformer.transform(domSource, streamResult);
            
            final String key = "gPyaP,;)9EbW}Gl@";
            final File encryptedFile = new File("conection-data-base.encrypted");
            File inputFile = new File("conection-data-base.xml");
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            inputFile.delete();
            return true;
        } catch (final ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(ConexionBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (CryptoException ex) {
            Logger.getLogger(DataBaseConfiguration.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}