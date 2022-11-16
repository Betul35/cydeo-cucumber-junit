package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public  GoogleSearchPage(){
        //create constructor
        //initialise the driver instance and this class instance using Page.factory.initElement
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //We can start location web element using @FindBy annotation

    @FindBy(name = "q")
    public WebElement searchBox;

}
