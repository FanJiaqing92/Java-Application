package test.xml.dom4j.base; 

import org.dom4j.Document;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import xml.dom4j.base.Dom4jBase;

/** 
* Dom4jBase Tester. 
* 
* @author <Author Jiaqing Fan> 
* @version 1.0 
*/ 
public class Dom4jBaseTest { 

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
        String xmlPath = "src/test/xml/dom4j/base/parse.xml";
        Dom4jBase dom4jBase = new Dom4jBase(xmlPath);
        dom4jBase.parse();
    } 

/** 
* 
* Method: write(Element root) 
* 
*/ 
    @Test
    public void testWrite(){ 
        String xmlPath = "src/test/xml/dom4j/base/write.xml";
        Dom4jBase dom4jBase = new Dom4jBase(xmlPath);
        Document document = dom4jBase.getDocument();
        dom4jBase.write(document);
    }

} 
