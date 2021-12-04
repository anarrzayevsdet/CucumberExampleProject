package StepDefinitions;

import Pages.HomePage;
import Utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HomePageSteps {

    WebDriver driver = Driver.getDriver();
    HomePage homePage = new HomePage();
    JavascriptExecutor js = (JavascriptExecutor)driver;

    @Then("user should be able to land on HRM homepage")
    public void user_should_be_able_to_land_on_HRM_homepage() {
        String expectedHomePageMessage = "Welcome SDET";
        String actualHomePageMessage = homePage.homePageWelcomeMessage.getText();
        Assert.assertEquals("Home Page message verification failed!",
                expectedHomePageMessage, actualHomePageMessage);
    }

    @Then("user should be able to validate all main tabs on Homepage")
    public void user_should_be_able_to_validate_all_main_tabs_on_Homepage(DataTable tabName) {
        List<Map<String, String>> maps = tabName.asMaps(String.class, String.class);
        int i=0;
        for (Map<String, String> map : maps) {
            String expectedTabname = map.get("tabName");
            String actualTabname = homePage.allTabs.get(i).getText();
            Assert.assertEquals("Tab verification failed!", expectedTabname, actualTabname);
            i++;
        }
    }

    @Then("user clicks on {string} main tab on HRM homepage")
    public void user_clicks_on_main_tab_on_HRM_homepage(String mainTab) throws Exception {
        switch (mainTab) {
            case "PIM":
                //regular selenium click
//                homePage.pimMainTab.click();
                //js executor click with executeScript method
                js.executeScript("arguments[0].click();", homePage.pimMainTab);
                break;
            default:
                throw new Exception(mainTab + " Main Tab is undefined!");
        }
    }

    @Then("user clicks on {string} sub tab on HRM homepage")
    public void user_clicks_on_sub_tab_on_HRM_homepage(String subTab) throws Exception {
        switch (subTab) {
            case "Employee List":
                //regular sleep with selenium
//                Thread.sleep(2000);
                //js executor sleep with executeAsyncScript method
                js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
                homePage.viewEmployeeListSubTab.click();
                break;
            default:
                throw new Exception(subTab + " Sub Tab is undefined!");
        }
    }

    @Then("user verifies employee list table")
    public void user_verifies_employee_list_table() throws InterruptedException {
        Thread.sleep(3000);
        /* this is for scrolling to any specific element on the page */
//        WebElement element = driver.findElement(By.xpath("//*[text()='Yolka Yol']"));
//        js.executeScript("arguments[0].scrollIntoView(true);", element);

        /* this is for scrolling to the bottom of the screen */
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

}
