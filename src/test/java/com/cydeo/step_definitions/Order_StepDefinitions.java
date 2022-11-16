package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();


    @Given("User is already logged in and order page")
    public void user_is_already_logged_in_and_order_page() {
        //getting the page using url from configuration.properties
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));

        //calling our login method to log in to web table app
        webTableLoginPage.login();

        //clicking to "order" link to go order page
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) throws InterruptedException {

         //Thread.sleep(5000);
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);

    }

//    @When("user enters customer name {string}")
//    public void user_enters_customer_name(String string) {
//
//    }

    @And("user enters quantity {int}")
    public void user_enters_quantity(int int1) {

      //orderPage.inputQuantity.clear();//bu box un icindeki varolan quantity i silecek, ama bazen bu teknik calismiyor
      orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

      //orderPage.inputQuantity.sendKeys(int1 + ""); //sendkeys accepts only string, ondan boyle yazdik
      orderPage.inputQuantity.sendKeys(String.valueOf(int1)); //boyle de yazabilirsin.

    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String string) {
        orderPage.inputName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {

       /* bu eski yontemimiz, ama biz utils kullanacagiz
       List<WebElement> cardTypes = orderPage.cardType; //burada card tye lari cagirip web element olarak listeledik

        for (WebElement each : cardTypes) {
            if (each.getAttribute("value").equalsIgnoreCase(expectedCardType)){
                each.click();
            }
        }
        */
        //this line will loop through the list and decide which radio button to click
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);


    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {

        orderPage.cardNoInput.sendKeys(string);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
       String actualName = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(expectedName, actualName);
    }


}
