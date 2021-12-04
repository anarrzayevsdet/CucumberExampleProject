package StepDefinitions;

import Pages.iFramePage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class iFrameSteps {

    WebDriver driver = Driver.getDriver();
    iFramePage iFramePage = new iFramePage();

    @Given("user navigates to iFrame Page")
    public void user_navigates_to_iFrame_Page() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("user enters a keyword into the textbox on iFrame Page")
    public void user_enters_a_keyword_into_the_textbox_on_iFrame_Page() throws InterruptedException {
        Thread.sleep(5000);
        driver.switchTo().frame(iFramePage.mceiFrame);
        iFramePage.tinyMCETextbox.clear();
        iFramePage.tinyMCETextbox.sendKeys("My name is Gulnara!");
    }

    @Then("user should be able to verify entered text")
    public void user_should_be_able_to_verify_entered_text() {

    }
}
