package xml.jaxb.base;

import xml.jaxb.base.pojo.Server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * 雨下之月
 * 2018.8.30
 */
public class JaxbBase {
    private String xmlPath;
    public JaxbBase(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public Server parse(){
        Server server;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Server.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            server = (Server)unmarshaller.unmarshal(new File(xmlPath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return server;
    }

    public void write(Server server){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Server.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(server, new File(xmlPath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
