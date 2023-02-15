package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@CucumberOptions(tags ="@smoke", features = {"src/test/resources/Features/login.feature"}, glue = {"WebStepDefination"},   monochrome = true,
        dryRun = false,
        plugin = {
                "pretty","html:build/reports/feature.html"
        })
@Test

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
//        @BeforeClass
//        public static void beforeClass(){
//
//        }
//        @AfterClass
//        public static void AfterClass(){
//
//        }
}
