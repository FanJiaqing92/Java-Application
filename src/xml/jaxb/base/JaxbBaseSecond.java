package xml.jaxb.base;

import xml.jaxb.base.pojo.ServerSecond;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbBaseSecond {
    private String xmlPath;

    public JaxbBaseSecond(String xmlPath){
        this.xmlPath = xmlPath;
    }

    public ServerSecond parse(){
        //TODO
        File xmlFile = new File(xmlPath);
        if (!xmlFile.exists()){
            return null;
        }
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(ServerSecond.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (ServerSecond) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(ServerSecond serverSecond){
        //TODO
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ServerSecond.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.marshal(serverSecond, new File(xmlPath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
