package test.xml.jaxb.base; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import xml.jaxb.base.JaxbBase;
import xml.jaxb.base.pojo.Server;

/** 
* JaxbBase Tester. 
* 
* @author <Author name> 
* @version 1.0 
*/ 
public class JaxbBaseTest { 

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
    //TODO: Test goes here... 
    
    } 

/** 
* 
* Method: write(Server server) 
* 
*/ 
    @Test
    public void testWrite(){
        String path = "src/test/xml/jaxb/base/write.xml";
        JaxbBase jaxbBase = new JaxbBase(path);
        Server server = getServer();
        jaxbBase.write(server);
    }

    private Server getServer(){
        Server server = new Server();
        server.setId(1);
        server.setName("I'm a server");
        server.setIp("1.1.1.1");
        server.setPort(8888);
        server.setIpType("v4");
        return server;
    }
} 
