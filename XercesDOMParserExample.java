import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XercesDOMParserExample {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento DOM
            Document document = builder.parse("Ej02.xml");

            // Normalizar el documento
            document.getDocumentElement().normalize();

            // Obtener el elemento raíz
            Element root = document.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

            String tagName = "PARRAFO";

            // Obtener todos los nodos de un tipo específico
            NodeList nodeList = document.getElementsByTagName(tagName);

            // Iterar sobre los nodos y procesarlos
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Elemento encontrado: " + element.getNodeName());

                // Imprimir información del contenido del elemento
                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);
                        System.out.println("  Sub-elemento: " + childElement.getNodeName() 
                        + " = " + childElement.getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
