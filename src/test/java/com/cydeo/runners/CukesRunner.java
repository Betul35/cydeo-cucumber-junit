package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty", bu parallel testing icin
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = false, //bu true oldugu zaman, yani acik oldugu zaman Java code runlanmiyor,
                     // sadece if any missing step, snippet veriyor
        tags = "@regression" //burada tag a yazdigini scenerionun ustune yazarsan sadece onu runlar
                            // istedigimiz kadar tag yazabiliriz

)
public class CukesRunner {
}
