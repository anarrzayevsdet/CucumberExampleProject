package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFramePage {

    WebDriver driver;

    public iFramePage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "mce_0_ifr")
    public WebElement mceiFrame;

    @FindBy (id = "tinymce")
    public WebElement tinyMCETextbox;
}
