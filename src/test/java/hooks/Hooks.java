package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class Hooks {
    /*
      Cucumber'da  step definitions package'i icerisinde
      @before, @after gibi bir notasyon varsa
      extends testBase dememize gerek kalmadan
      her scenario'dan once ve/veya sonra bu method'lar calisacaktir

      Bu da bizim isteyecegimiz bir durum degildir

      Cucumber'da @before, @after kullanma ihtiyacimiz olursa
      bunu stepdefinitions package'i altinda olusturacagimiz
      hooks class'ina koyariz

      biz her scenario'dan sonra test sonucunu kontrol edip
      failed olan scenario'lar icin
      screenshoot almasi amaciyla
      @After method'u kullanacagiz

     */
    @Before
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        String url= ConfigReader.getProperty("medunnaUrl");
        Driver.getDriver().get(url);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

     @After
    public void tearDown(Scenario scenario){

        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png","screenshots");
        }
        Driver.closeDriver();
    }
}
