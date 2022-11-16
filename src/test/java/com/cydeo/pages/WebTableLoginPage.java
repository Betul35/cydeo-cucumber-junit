package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement inputUserName;


    @FindBy(name = "password")
    public WebElement inputPassword;


    @FindBy(xpath = "//button[.='Login']")
    public WebElement LoginButton;


    //no parameters but when we call this method it will directly login using: Username:Test, Password:Tester
    public void login(){
        this.inputUserName.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.LoginButton.click();
    }

    //this method will accept two arguments and login.
    public void login(String username, String password){
        inputPassword.sendKeys(username);
        inputPassword.sendKeys(password);
        LoginButton.click();
    }

    //this method will login using credentials from configuration.properties
    public void loginWithConfig(){
        inputUserName.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
        LoginButton.click();
    }

}
