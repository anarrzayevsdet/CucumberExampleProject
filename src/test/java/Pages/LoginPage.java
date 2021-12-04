package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage () {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    public WebElement usernameTextBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordTextBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    public void login () {
        usernameTextBox.sendKeys("yoll-student");
        passwordTextBox.sendKeys("Bootcamp5#");
        loginButton.click();
    }
}
