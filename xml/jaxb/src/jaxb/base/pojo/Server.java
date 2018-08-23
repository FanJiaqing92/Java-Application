package jaxb.base.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 映射的xml的根节点的名称，如果不写name属性，则默认根节点tag为类名，还有一个属性是namespace，后续再补充
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
 *  当使用propOrder属性时，必须指出JavaBean对象中所有的属性，否则报错
 *  同时使用@XmlType(propOrder={})和@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)时，生成的xml只按照propOrder的顺序
 *
 *  目前不知道出了元素节点名字外，属性是否也要列出（看样子应该也需要）。属性是否也会按照指定的顺序生成呢？应该是的。
 *  后续验证了再补充
 *  这个注解还有name和namespace属性，作用后续再补充
 */
@XmlType(propOrder = {"id", "name", "ip", "port" })
public class Server {
    private int id;
    private String name;
    private String ip;
    private int port;
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
}
