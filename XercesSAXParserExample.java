import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;

import java.io.File;

public class XercesSAXParserExample {

  public static void main(String[] args) {
    try {
      // Crear un objeto File que representa el archivo XML de entrada
      File archivoEntrada = new File("Ej02.xml");
      // Crear una fábrica de analizadores SAX
      SAXParserFactory fabricaSAXParser = SAXParserFactory.newInstance();

      // Crear un analizador SAX a partir de la fábrica
      SAXParser saxParser = fabricaSAXParser.newSAXParser();

      // Definir un manejador para los eventos SAX
      DefaultHandler manejador = new DefaultHandler() {
        // Banderas para identificar en qué elemento nos encontramos
        boolean bTitulo = false;
        boolean bAAAA = false;
        boolean bMM = false;
        boolean bDD = false;
        boolean bTitSeccion = false;
        boolean bOrganismo = false;
        boolean bTexto = false;
        boolean bPagina = false;

        // Método que se llama cuando se encuentra el inicio de un elemento
        public void startElement(String uri, String localName, String qName, Attributes atributos) throws SAXException {
          System.out.println("Inicio del elemento: " + qName);

          // Configurar las banderas según el nombre del elemento
          if (qName.equalsIgnoreCase("TITULO")) {
            bTitulo = true;
          } else if (qName.equalsIgnoreCase("AAAA")) {
            bAAAA = true;
          } else if (qName.equalsIgnoreCase("MM")) {
            bMM = true;
          } else if (qName.equalsIgnoreCase("DD")) {
            bDD = true;
          } else if (qName.equalsIgnoreCase("TIT-SECCION")) {
            bTitSeccion = true;
          } else if (qName.equalsIgnoreCase("ORGANISMO")) {
            bOrganismo = true;
          } else if (qName.equalsIgnoreCase("TEXTO")) {
            bTexto = true;
          } else if (qName.equalsIgnoreCase("PAGINA")) {
            bPagina = true;
          }
        }

        // Método que se llama cuando se encuentra el final de un elemento
        public void endElement(String uri, String localName, String qName) throws SAXException {
          System.out.println("Fin del elemento: " + qName);
        }

        // Método que se llama cuando se encuentra texto dentro de un elemento
        public void characters(char ch[], int start, int length) throws SAXException {
          // Imprimir el contenido del elemento según la bandera activada
          if (bTitulo) {
            System.out.println("Contenido del TITULO: " + new String(ch, start, length));
            bTitulo = false;
          } else if (bAAAA) {
            System.out.println("Contenido del AAAA: " + new String(ch, start, length));
            bAAAA = false;
          } else if (bMM) {
            System.out.println("Contenido del MM: " + new String(ch, start, length));
            bMM = false;
          } else if (bDD) {
            System.out.println("Contenido del DD: " + new String(ch, start, length));
            bDD = false;
          } else if (bTitSeccion) {
            System.out.println("Contenido del TIT-SECCION: " + new String(ch, start, length));
            bTitSeccion = false;
          } else if (bOrganismo) {
            System.out.println("Contenido del ORGANISMO: " + new String(ch, start, length));
            bOrganismo = false;
          } else if (bTexto) {
            System.out.println("Contenido del TEXTO: " + new String(ch, start, length));
            bTexto = false;
          } else if (bPagina) {
            System.out.println("Contenido del PAGINA: " + new String(ch, start, length));
            bPagina = false;
          }
        }
      };

      // Analizar el archivo XML usando el manejador definido
      saxParser.parse(archivoEntrada, manejador);
    } catch (Exception e) {
      // Manejar las excepciones
      e.printStackTrace();
    }
  }
}
