package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"stepdefinitions","hooks"},
        tags = "@headless",
        plugin = {"pretty"},
        monochrome = true

)

public class RunnerTest {
    //used to run all test
}
