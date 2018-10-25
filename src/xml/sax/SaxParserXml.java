package xml.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SaxParserXml
 * @Descripiton //TODO
 * @Author Jiaqing Fan
 * @Date 2018/10/16
 */
public class SaxParserXml {
    private String xmlPath;

    public SaxParserXml(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public void parser(){
        File xml = new File(xmlPath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SaxParseHandler handler = new SaxParseHandler();
        SAXParser saxParser = null;
        try {
            saxParser = factory.newSAXParser();
            saxParser.parse(xml, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        List<User> userList = handler.getUsers();
        userList.forEach(user -> System.out.println("User id: " + user.getId() + " User name: " + user.getName()
                + " User password: " + user.getPassword()));

    }
}
