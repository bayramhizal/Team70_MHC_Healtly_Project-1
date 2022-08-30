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
        glue= {"stepDefinitions","hooks"},
        tags= "@E2E",
        dryRun = false
)

public class TestRunner {
    /*
    Bir framework'de bir tek TestRunner3 class'i yeterli olabilir
    TestRunner3 class'inda class body'sinde hic bir sey olmaz
    TestRunner3 class'imizi onemli yapan 2 adet annotaion vardir
    @RunWith(Cucumber.class) notasyonu TestRunner3 class'ina calisma ozelligi katar
    Bu notasyon oldugu icin Cucumber framework'umuzde JUnit kullanmayi tercih ediyoruz

    features : TestRunner3 dosyasinin feature dosyalarini nereden bulacagini tarif eder
    glue : step definitions dosyalarini nerede bulacagimizi gosterir
    tags : o an hangi tag'i calistirmak istiyorsak onu belli eder

   dryRun : iki secenek var
   dryRun=true; yazdigimizda Testimizi calistirmadan sadece eksik adimlari bize verir
   deyRun=false yazdigimizda testlerimizi calistirir

     */
}
