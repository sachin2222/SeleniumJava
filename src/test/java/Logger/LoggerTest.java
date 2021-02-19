package Logger;


import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;


public class LoggerTest {


    @Test
    public void logsTest(){
       Logger log= LogManager.getLogger(LoggerTest.class.getName());
       DOMConfigurator.configure("Log4J.xml");
       log.error("Error Message");
       log.info("Info Message");
       log.error("Error Message 2");
       log.info("One more Message");


    }


}
