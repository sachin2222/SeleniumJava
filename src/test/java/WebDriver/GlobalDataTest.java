package WebDriver;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalDataTest {

    @Test
    public void globaldataTest() throws IOException {
        Properties prop = new Properties();
        FileInputStream fin = new FileInputStream("C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\src\\main\\java\\Utilities\\GlobalData.properties");
        prop.load(fin);
        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("url"));
        prop.setProperty("browser","firefox");
        System.out.println(prop.getProperty("browser"));

        FileOutputStream fos=new FileOutputStream("C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\src\\main\\java\\Utilities\\GlobalData.properties");
        prop.store(fos,"hello");



    }
}
