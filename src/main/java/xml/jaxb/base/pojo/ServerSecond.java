package xml.jaxb.base.pojo;

import javax.xml.bind.annotation.*;

/**
 * 这里没有使用name属性，节点名称就是类名
 */
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)

/*
  用于对java对象映射的xml元素进行排序，一共有两个值
  XmlAccessOrder.ALPHABETICAL 根据字母顺序排序
  XmlAccessOrder.UNDEFINED 不排序
  不管是子节点还是属性都会按照字母顺序排序
 */
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)

public class ServerSecond {

    /**
     * 这个注解是表明id是一个子节点名称，可以使用name属性来改变在xml中子节点的名称
     */
    @XmlElement(name = "id")
    private int id;

    @XmlElement(name = "names")
    private String name;
    /**
     * 如果不使用name属性，则属性名称即是xml子节点的名称
     */
    @XmlElement
    private String ip;
    /**
     * 即是不使用@xmlElement注解，port也被默认为子节点了
     */
    private int port;

    @XmlAttribute
    private String bFirst;

    @XmlAttribute
    private String aSecond;

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

    public String getbFirst() {
        return bFirst;
    }

    public void setbFirst(String bFirst) {
        this.bFirst = bFirst;
    }

    public String getaSecond() {
        return aSecond;
    }

    public void setaSecond(String aSecond) {
        this.aSecond = aSecond;
    }
}
