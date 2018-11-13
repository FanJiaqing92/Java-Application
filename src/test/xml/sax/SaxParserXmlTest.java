package test.xml.sax; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import xml.sax.SaxParserXml;

/** 
* SaxParserXml Tester. 
* 
* @author <Author Jiaqing Fan> 
* @version 1.0 
*/ 
public class SaxParserXmlTest { 

    @Before
    public void before(){ 
    
    } 

    @After
    public void after(){ 
    
    } 

/** 
* 
* Method: parser() 
* 
*/ 
    @Test
    public void testParser() {
        String xmlPath = "src/test/xml/sax/sax.xml";
        SaxParserXml saxParserXml = new SaxParserXml(xmlPath);
        saxParserXml.parser();
    }
} 
