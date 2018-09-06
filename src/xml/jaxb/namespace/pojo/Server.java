package xml.jaxb.namespace.pojo;

import javax.xml.bind.annotation.*;

/**
 * @author Jiaqing Fan
 * @date 2018/09/06
 */

@XmlRootElement(name = "ServerNamespace", namespace = "nsTest")

@XmlAccessorType(XmlAccessType.FIELD)

public class Server {
    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "ip", namespace = "nsTest2")
    private String ip;

    @XmlElement(name = "port")
    private int port;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
