package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin      = {"pretty"},
        glue        = {"tests"},
        features    = {"src/test/java/features"},
        tags        = "@api",
        monochrome = true
)

public class ApiRunnerTest {
}
