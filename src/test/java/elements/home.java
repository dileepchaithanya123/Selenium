package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class home {

    @FindBy(xpath = "//a[@title='Automation Practice Site']")
    WebElement HomePage;

    @FindBy(xpath = "//a[text()='Shop']")
    WebElement ShopLink;

    @FindBy(xpath = "//a[text()='My Account']")
    WebElement MyAccountLink;


}
