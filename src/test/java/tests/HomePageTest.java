package tests;

import drivers.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BasePage {

    @BeforeTest
    public void setUp(){
        initiatePropertiesFiles();
        browserhandler();
    }

    @Test
    public void TestCase1(){

    }

    @AfterTest
    public void close(){
        //closeBrowser();
    }

}
