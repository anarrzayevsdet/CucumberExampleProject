package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage {
    WebDriver driver;

    public ActionsPage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    public WebElement womenTab;

    @FindBy(xpath = "(//a[@title='Casual Dresses'])[1]")
    public WebElement casualDressesLink;

    @FindBy(xpath = "//span[@class='cat-name']")
    public WebElement casualDressesTitle;

    @FindBy(xpath = "//span[text()='right click me']")
    public WebElement rightCLickButton;

    @FindBy(xpath = "//*[contains(@class,'context-menu-icon-copy')]")
    public WebElement contextCopyButton;
}
