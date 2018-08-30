package jaxb.base;

import jaxb.base.pojo.Server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

class JaxbBase {
    private String xmlPath;
    JaxbBase(String xmlPath){
        this.xmlPath = xmlPath;
    }

    Server parse(){
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

    void write(Server server){
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
