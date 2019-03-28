package xml.jaxb.namespace;

import xml.jaxb.namespace.pojo.Server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Jiaqing Fan
 * @date 2018/09/06
 */
public class JaxbNamespace {
    private String xmlPath;
    public JaxbNamespace(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public Server parse(){
        //TODO
        File xml = new File(xmlPath);
        if (!xml.exists()){
            return null;
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Server.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Server)unmarshaller.unmarshal(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(Server server){
        //TODO
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
