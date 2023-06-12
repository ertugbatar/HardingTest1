package com.hardingTest.stepDefs;

import com.github.javafaker.Faker;
import com.hardingTest.PageObject.HardingPage;
import com.hardingTest.Utilities.BrowserUtils;
import com.hardingTest.Utilities.ConfigurationReader;
import com.hardingTest.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HardingStepDefs {

    HardingPage hardingPage = new HardingPage();

    @Given("that I am looking at the company’s homepage")
    public void that_i_am_looking_at_the_company_s_homepage() throws InterruptedException {

        WebElement cookie = hardingPage.cookieAcceptHarding;
        Driver.getDriver().get(ConfigurationReader.getProperty("hardingUrl"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();

    }

    @And("searching for an {string} job")
    public void searchingForAnJob(String jobTitle) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hardingPage.careerButton).perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
        wait.until(ExpectedConditions.visibilityOf(hardingPage.landSideButton));
        hardingPage.landSideButton.click();

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 7);
        wait1.until(ExpectedConditions.visibilityOf(hardingPage.seeVacanciesBtn));
        hardingPage.seeVacanciesBtn.click();

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 7);
        wait2.until(ExpectedConditions.visibilityOf(hardingPage.searchInputBox));
        hardingPage.searchInputBox.sendKeys(jobTitle);

        hardingPage.searchBtn.click();


    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonWord) {

        hardingPage.button(buttonWord).click();
        BrowserUtils.sleep(3);

    }

    Faker faker = new Faker();

    @Then("I should be able to fill in the mandatory fields with the Basic data on the first page.")
    public void i_should_be_able_to_fill_in_the_mandatory_fields_with_the_basic_data_on_the_first_page() {
        hardingPage.firstNameInputBox.sendKeys("Agnes");
        hardingPage.surNameInputBox.sendKeys("Nemeth");
        hardingPage.emailAddressBox.sendKeys(faker.internet().emailAddress());
        hardingPage.mobileInputBox.sendKeys("07777 111111");

        BrowserUtils.sleep(7);

        String path = "/User/ertugbatar/Desktop/denemecv.pdf";
       // String path = "/Users/ertugbatar/Desktop/denemecv.pdf";
        hardingPage.uploadBtn.sendKeys(path);
        BrowserUtils.sleep(7);
        hardingPage.townInputBox.sendKeys("Bristol");

        hardingPage.nextBtn.click();
        BrowserUtils.sleep(7);

        hardingPage.nextBtn.click();


    }


    @Then("I should be able to fill in the mandatory fields with the {string} on the first page.")
    public void iShouldBeAbleToFillInTheMandatoryFieldsWithTheOnTheFirstPage(String testDate) throws InterruptedException {
        Driver.getDriver().get("https://careers.hardingretail.com/Forms/Application?formParameters=KizGpaAy2eWSChSK2ySS31%2FQ5LX98ERQAjFp7wKPPTDI3XdGKDIXaw%3D%3D&jobPostId=414311");
        WebElement testDateField = Driver.getDriver().findElement(By.id("testDateFieldId"));
        testDateField.clear();
        testDateField.sendKeys(testDate);
        Thread.sleep(3000);
        Driver.getDriver().quit();


    }

    @Then("I should get the {string} when submitting the application.")
    public void i_should_get_the_when_submitting_the_application(String string) {
        Driver.getDriver().get("https://careers.hardingretail.com/Forms/Application?formParameters=KizGpaAy2eWSChSK2ySS31%2FQ5LX98ERQAjFp7wKPPTDI3XdGKDIXaw%3D%3D&jobPostId=414311");
        WebElement resultElement = Driver.getDriver().findElement(By.xpath("//div[@class='success-message']"));

        String actualResult = resultElement.getText();
        if (actualResult.equals(string)) {
            System.out.println("Test passed. Expected result '" + string + "' received.");
        } else {
            System.out.println("Test failed. Expected result: '" + string + "'. Actual result: '" + actualResult + "'.");
        }

        Driver.getDriver().quit();



    }
}