package test.xml.jaxb.base; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import xml.jaxb.base.JaxbBaseSecond;
import xml.jaxb.base.pojo.ServerSecond;

import java.util.Objects;

/** 
* JaxbBaseSecond Tester. 
* 
* @author <Author Jiaqing Fan>
* @version 1.0 
*/ 
public class JaxbBaseSecondTest { 

    @Before
    public void before(){ 
    
    } 

    @After
    public void after(){ 
    
    } 

/** 
* 
* Method: parse() 
* 
*/ 
    @Test
    public void testParse(){ 
        String path = "src/test/xml/jaxb/base/parseSecond.xml";
        JaxbBaseSecond jaxbBaseSecond = new JaxbBaseSecond(path);
        ServerSecond serverSecond = jaxbBaseSecond.parse();
        if (Objects.nonNull(serverSecond)){
            System.out.println("Id: " + serverSecond.getId());
            System.out.println("Name: " + serverSecond.getName());
            System.out.println("Ip: " + serverSecond.getIp());
            System.out.println("Port: " + serverSecond.getPort());
            System.out.println("bFirst: " + serverSecond.getbFirst());
            System.out.println("aSecond: " + serverSecond.getaSecond());
        }
    } 

/** 
* 
* Method: write(ServerSecond serverSecond) 
* 
*/ 
    @Test
    public void testWrite(){
        String path = "src/test/xml/jaxb/base/writeSecond.xml";
        JaxbBaseSecond jaxbBaseSecond = new JaxbBaseSecond(path);
        jaxbBaseSecond.write(getServerSecond());
    } 

    private ServerSecond getServerSecond(){
        //TODO
        ServerSecond serverSecond = new ServerSecond();
        serverSecond.setId(1);
        serverSecond.setName("This is second server");
        serverSecond.setIp("2.2.2.2");
        serverSecond.setPort(8088);
        serverSecond.setaSecond("second attribute");
        serverSecond.setbFirst("first attribute");
        return serverSecond;
    }

} 
