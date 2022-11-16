package com.cydeo.step_definitions;

 /*
    in this class we will be able to pass pre&post conditions to each scenario and each step
     */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    //@Before
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    @After
    public void tearDownScenario(Scenario scenario){

        if (scenario.isFailed()){ //if scenario fails, take me the screenshot
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);//down casting yaptik burada
            scenario.attach(screenshot,"image/png", scenario.getName());

        }


        Driver.closeDriver();

      //  System.out.println("====Setting up browser using cucumber @After");
       // System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("-----> applying setup using @BeforeStep");
    }

   // @AfterStep
    public void afterSetup(){
        System.out.println("-----> applying tearDown using @afterStep");
    }


}
