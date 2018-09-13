package test.time.java8; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import time.java8.DateTime;

/** 
* DateTime Tester. 
* 
* @author <Author Jiaqing Fan> 
* @version 1.0 
*/ 
public class DateTimeTest { 

    @Before
    public void before(){ 
    
    } 

    @After
    public void after(){ 
    
    } 

/** 
* 
* Method: localDate() 
* 
*/ 
    @Test
    public void testLocalDate(){ 
        //TODO: Test goes here... 
        DateTime.localDate();
    } 

/** 
* 
* Method: localTime() 
* 
*/ 
    @Test
    public void testLocalTime(){ 
        //TODO: Test goes here... 
        DateTime.localTime();
    }

/**
*
* Method: localDateTime()
*
*/
    @Test
    public void testLocalDateTime(){
        //TODO: Test goes here...
        DateTime.localDateTime();
    }


} 
