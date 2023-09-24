package com.Adidas.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "com/Adidas/stepdefs",
        dryRun = false,
        tags ="@purchase"

        // tags = "@driver and @VYT-123 and @wip"
        //tags = "@driver or @store_manager"
        //tags = "@driver and @VYT-123"
        // tags = "@login and @wip"
        //tags = "@login and not @wip"
        //tags = "@login and not @wip and not @sales_manager"
        // tags = {"@login","@wip"}  old version
        // tags = {"@login","~@wip"}  old version
        //tags = "not @wip"
        //tags = "@driver and @VYT-123 and @wip"
)
public class CukesRunner {

}