package StepDefinitions;

import Pages.LoginPage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("user navigates to HRM loginpage")
    public void user_navigates_to_HRM_loginpage() throws Exception {
        driver.get("http://dev-hrm.yoll.io/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Thread.sleep(5000);
    }

    @When("user enter valid credentials and clicks on login button")
    public void user_enter_valid_credentials_and_clicks_on_login_button() {
        loginPage.login();
    }

    @When("user enter {string} username and {string} password")
    public void user_enter_username_and_password(String username, String password) throws Exception {
        switch (username) {
            case "invalid":
                loginPage.usernameTextBox.sendKeys("invalidUsername");
                break;
            case "valid":
                loginPage.usernameTextBox.sendKeys("yoll-student");
                break;
            case "empty":
                loginPage.usernameTextBox.sendKeys("");
                break;
            default:
                throw new Exception(username + " Username type is undefined!");
        }

        switch (password) {
            case "invalid":
                loginPage.passwordTextBox.sendKeys("invalidPassword");
                break;
            case "valid":
                loginPage.passwordTextBox.sendKeys("Bootcamp5#");
                break;
            case "empty":
                loginPage.passwordTextBox.sendKeys("");
                break;
            default:
                throw new Exception(password + " Password type is undefined!");
        }
    }

    @Then("user validates {string} error message")
    public void user_validates_error_message(String errorMessage) {
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage + " Error Message verification failed!",
                errorMessage, actualErrorMessage);
    }

    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
}
