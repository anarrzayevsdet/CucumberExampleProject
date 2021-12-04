package StepDefinitions;

import Pages.WindowsTabsPage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsTabsSteps {

    WebDriver driver = Driver.getDriver();
    WindowsTabsPage windowsTabsPage = new WindowsTabsPage();

    @Given("user navigates to Window and Tab Page")
    public void user_navigates_to_Window_and_Tab_Page() {
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Original window title is: " + driver.getTitle());
    }

    @When("user clicks on new window button")
    public void user_clicks_on_new_window_button() {
        windowsTabsPage.newWindowButton.click();
    }

    @Then("user should be able to verify new window title")
    public void user_should_be_able_to_verify_new_window_title() throws InterruptedException {
        //store original window handle
        String mainGUID = driver.getWindowHandle();

        //switch to the new window
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String winHandle : allWindowHandles) {
            driver.switchTo().window(winHandle);
        }

        //perform some actions on new window
        Thread.sleep(3000);
        String expectedNewWindowTitle = "This is a sample page";
        String actualNewWindowTitle = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("New Window title verificaiton failed!",
                expectedNewWindowTitle, actualNewWindowTitle);

        //close the new window
        driver.close();

        //switch back to the original window
        Thread.sleep(3000);
        driver.switchTo().window(mainGUID);
        Thread.sleep(2000);
        System.out.println("Original window title is: " + driver.getTitle());

    }















}
