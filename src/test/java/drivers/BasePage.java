package drivers;

import com.sun.org.apache.bcel.internal.Const;
import gherkin.lexer.Fi;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class BasePage {
    private static WebDriver driver;
    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    public static Properties Constants;
    public static void initiatePropertiesFiles(){
        if(Constants==null){
            Constants = new Properties();
            try{

                String fileName = FilenameUtils.normalize(System.getProperty("user.dir") + "/src/test/resources/Properties/constants.properties");
                FileInputStream fis = new FileInputStream(fileName);
                Constants.load(fis);
                System.out.println(Constants.getProperty("browser"));

            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);

            }
        }
    }

    public static void browserhandler() {
        if (Constants.getProperty("browser").toUpperCase().contains("CHROME")) {
            System.setProperty("webdriver.chrome.driver", Constants.getProperty("Driver") + "\\chromedriver.exe");
            //System.setProperty("webdriver.chrome.driver","D:\\Coding\\Selenium\\src\\test\\resources\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(Constants.getProperty("url"));
            driver.manage().window().maximize();
        } else if (Constants.getProperty("browser").toUpperCase().contains("FIREFOX")) {
            System.setProperty("webdriver.gecko.driver", Constants.getProperty("Driver") + "\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(Constants.getProperty("url"));
            driver.manage().window().maximize();
        } else if (Constants.getProperty("browser").toUpperCase().contains("IE")) {
            System.setProperty("webdriver.ie.driver", Constants.getProperty("Driver") + "\\iedriver.exe");
            driver = new InternetExplorerDriver();
            driver.get(Constants.getProperty("url"));
            driver.manage().window().maximize();
        } else if (Constants.getProperty("browser").toUpperCase().contains("edge")) {
            System.setProperty("webdriver.edge.driver", Constants.getProperty("Driver") + "\\MicrosoftWebDriver.exe");
            WebDriver driver = new EdgeDriver();
            driver.get(Constants.getProperty("url"));
            driver.manage().window().maximize();
        } else {
            System.out.println("Your browser is not supported");
        }
    }

    public static void closeBrowser(){
        driver.quit();
    }

}
