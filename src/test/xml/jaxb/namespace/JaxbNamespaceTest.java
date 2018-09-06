package test.xml.jaxb.namespace; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import xml.jaxb.namespace.JaxbNamespace;
import xml.jaxb.namespace.pojo.Server;

/** 
* JaxbNamespace Tester. 
* 
* @author <Author Jiaqing Fan> 
* @version 1.0 
*/ 
public class JaxbNamespaceTest { 

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
        //TODO: Test goes here... 
        String path = "src/test/xml/jaxb/namespace/write.xml";
        JaxbNamespace jaxbNamespace = new JaxbNamespace(path);
        jaxbNamespace.write(getServer());
    } 

    private Server getServer(){
        Server server = new Server();
        server.setId(1);
        server.setName("Server namespace test");
        server.setIp("3.3.3.3");
        server.setPort(8989);
        return server;
    }

} 
