package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(
        plugin={"html:target/cucumber-reports-testrunner.html",
                "json:target/json-reports/cucumber-testrunner.json",
                "junit:target/xml-report/cucumber-testrunner.xml"
        },
        features = "src/test/resources/features",
        glue= {"stepDefinitions" , "hooks"},
        tags= "@grid",
        dryRun = false
)




public class GridRunner {


    // Paralel ve Cross Browser testleri çalıştırmak için ayrı bir runner oluşturdum,
    // grid taglı tüm testler parlel koşulacak.


}
