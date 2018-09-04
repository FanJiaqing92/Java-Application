package test.xml.jaxb.base; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import xml.jaxb.base.JaxbBase;
import xml.jaxb.base.pojo.ComplexNode;
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
        String path = "src/test/xml/jaxb/base/parse.xml";
        JaxbBase jaxbBase = new JaxbBase(path);
        Server server = jaxbBase.parse();
        System.out.println("IP Type: " + server.getIpType());
        System.out.println("Id: " + server.getId());
        System.out.println("Name: " + server.getName());
        System.out.println("IP: " + server.getIp());
        System.out.println("Port: " + server.getPort());
        System.out.println("First: " + server.getComplexNode().getFirst());
        System.out.println("Second: " + server.getComplexNode().getSecond());
        System.out.println("Third: " + server.getComplexNode().getThird());
        System.out.println("Total Name: " + server.getComplexNode().getTotalName());
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
        ComplexNode complexNode = new ComplexNode();
        complexNode.setFirst("first");
        complexNode.setSecond("second");
        complexNode.setThird("third");
        server.setComplexNode(complexNode);
        return server;
    }
} 
