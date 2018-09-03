package xml.jaxb.base.pojo;

import javax.xml.bind.annotation.*;

/**
 * 映射的xml的节点的名称，如果不写name属性，则默认节点名称为类名，还有一个属性是namespace，后续再补充
 */
@XmlRootElement(name = "serverExample")

/**
 * 指定映射java对象和xml文件时，对java对象属性的访问方式
 *  XmlAccessType.FIELD java对象中的所有成员变量
 *  XmlAccessType.PROPERTY java对象中所有通过getter/setter方式访问的成员变量
 *  XmlAccessType.PUBLIC_MEMBER java对象中所有的public访问权限的成员变量和通过getter/setter方式访问的成员你变量
 *  XmlAccessType.NONE java对象的所有属性都不映射为xml的元素
 * */
@XmlAccessorType(XmlAccessType.FIELD)
/**
 *  jaxb生成的xml文件中的元素顺序是不确定的。使用这个注解可以指定元素的生成顺序。
 *  当使用propOrder属性时，必须指出JavaBean对象中所有的属性，否则报错。但是被@XmlTransient和@XmlAttribute修饰的属性是不用指出的
 *  同时使用@XmlType(propOrder={})和@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)时，生成的xml只按照propOrder的顺序
 *
 *  目前不知道出了元素节点名字外，属性是否也要列出（看样子应该也需要）。属性是否也会按照指定的顺序生成呢？应该是的。
 *  后续验证了再补充
 *  这个注解还有name和namespace属性，作用后续再补充
 */
@XmlType(propOrder = {"id", "name", "ip", "port"})
public class Server {
    private int id;
    private String name;
    private String ip;
    private int port;
    /**
     * 被这个属性修饰的变量不会被映射到xml文件中。
     */
    @XmlTransient
    private int ignoreTest;
    /**
     * 将ipType映射成节点的属性，在这里就是serverExample节点的属性。属性名称为ipTyp。这个名称可以和变量名不一致。
     * 这里提醒一下，这里映射的所有属性都是serverExample节点的。如果想要给serverExample的子节点添加属性，则另外创建一个
     * pojo类A。在类A中声名相应的节点和属性信息，然后将类A作为Server类的一个属性就行了。就是说当前类，是对serverExample节点
     * 的描述。这也是为什么jaxb适合解析结构相对简单的xml文件。
     */
    @XmlAttribute(name = "ipTyp")
    private String ipType;

//    @XmlJavaTypeAdapter(value = ComplexNodeName.class)
//    private


    public Server(){

    }

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

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public int getIgnoreTest() {
        return ignoreTest;
    }

    public void setIgnoreTest(int ignoreTest) {
        this.ignoreTest = ignoreTest;
    }
}
