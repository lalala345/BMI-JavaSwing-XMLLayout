package Helper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {
    public static Element getRootElement(File file) {
        Element root = null;
        try {
            Document document = DocumentBuilderFactory.newInstance()
                                    .newDocumentBuilder().parse(file);
            root = document.getDocumentElement();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
