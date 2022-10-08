package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = true //bu true oldugu zaman, yani acik oldugu zaman Java code runlanmiyor,
                     // sadece if any missing step, snippet veriyor

)
public class CukesRunner {
}
