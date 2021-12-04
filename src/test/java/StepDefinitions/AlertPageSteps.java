package StepDefinitions;

import Pages.AlertPage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertPageSteps {

    WebDriver driver = Driver.getDriver();
    AlertPage alertPage = new AlertPage();

    @Given("user navigates to Alerts Page")
    public void user_navigates_to_Alerts_Page() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("user clicks on {string} alert button on Alerts Page")
    public void user_clicks_on_alert_button_on_Alerts_Page(String alertType) {
        alertPage.regularAlertButton.click();
    }

    @Then("user should be able to handle {string} alert on Alerts Page")
    public void user_should_be_able_to_handle_alert_on_Alerts_Page(String alertType) {
        //TODO move this logic to Page Object and only call the method to this step
        Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert myAlert = driver.switchTo().alert();

        switch (alertType) {
            case "regular":
                System.out.println(myAlert.getText());
                myAlert.accept();
                break;
        }
    }
}
