package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsTabsPage {

    WebDriver driver;

    public WindowsTabsPage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "windowButton")
    public WebElement newWindowButton;
}
