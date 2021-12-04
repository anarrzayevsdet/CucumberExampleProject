package StepDefinitions;

import Pages.ActionsPage;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionsSteps {

    WebDriver driver = Driver.getDriver();
    ActionsPage actionsPage = new ActionsPage();

    @Given("user navigates to Automation Practice Page")
    public void user_navigates_to_Automation_Practice_Page() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user hover over womens tab")
    public void user_hover_over_womens_tab() {
        Actions action = new Actions(driver);
        action.moveToElement(actionsPage.womenTab).perform();
    }

    @Then("user clicks on casual dresses link")
    public void user_clicks_on_casual_dresses_link() throws Exception {
        Thread.sleep(1000);
        actionsPage.casualDressesLink.click();
    }

    @Then("user validates casual dresses page")
    public void user_validates_casual_dresses_page() throws Exception {
        Thread.sleep(2000);
        String expectedTitle = "CASUAL DRESSES";
        String actualTitle = actionsPage.casualDressesTitle.getText().trim();
        Assert.assertEquals("Casual Dresses title verification failed!", expectedTitle, actualTitle);
    }

    @Given("user navigates to Practice Page")
    public void user_navigates_to_Practice_Page() {
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("user performs right click action on the button")
    public void user_performs_right_click_action_on_the_button() throws InterruptedException {
        Actions action = new Actions(driver);
        action.contextClick(actionsPage.rightCLickButton).perform();
        Thread.sleep(1000);
        actionsPage.contextCopyButton.click();
    }

    @Given("user navigates to Drag Drop Page")
    public void user_navigates_to_Drag_Drop_Page() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user should be able to drag and drop capital to its country")
    public void user_should_be_able_to_drag_and_drop_capital_to_its_country() {
        Actions action = new Actions(driver);
        WebElement sourceElement = driver.findElement(By.id("box3"));
        WebElement targetElement = driver.findElement(By.id("box103"));
        action.dragAndDrop(sourceElement, targetElement).perform();

        String attributeValue = sourceElement.getAttribute("style");

        if (!attributeValue.contains("background-color")) {
            Assert.fail("Drag and Drop was not performed successfully!");
        }
    }

    @Then("user performs multiple keyboard actions")
    public void user_performs_multiple_keyboard_actions() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement searchTextBox = driver.findElement(By.id("search_query_top"));
        WebElement searchButton = driver.findElement(By.name("submit_search"));

        action.
            moveToElement(searchTextBox). //hover over
            contextClick(searchTextBox). //right click
            click().
            click().
            keyDown(searchTextBox, Keys.SHIFT). //hold the SHIFT key
            sendKeys("jeans").
            keyUp(searchTextBox, Keys.SHIFT). //release the SHIFT key
            doubleClick(searchTextBox).
            build().
            perform();

        Thread.sleep(2000);
        searchButton.click();
    }
}
