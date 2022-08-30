package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class gridStepDefinitions {

    WebDriver driver;


    @Given ("grid kullanici {string} chrome ile medunna sayfasina gider")
    public void gridKullaniciChromeIleMedunnaSayfasinaGider (String sahsiURL) throws MalformedURLException {
        driver=new RemoteWebDriver(new URL(sahsiURL) , new ChromeOptions());
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("medunnaUrl"));

        // Herkes kendi şahsi URL'ini "String" olarak girecek
    }



    @Given ("grid kullanici {string} firefox ile medunna sayfasina gider")
    public void gridKullaniciFirefoxIleMedunnaSayfasinaGider (String sahsiURL) throws MalformedURLException {
        driver=new RemoteWebDriver(new URL(sahsiURL) , new FirefoxOptions());
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("medunnaUrl"));
    }


    @Given ("grid kullanici {string} edge ile medunna sayfasina gider")
    public void gridKullaniciEdgeIleMedunnaSayfasinaGider (String sahsiURL) throws MalformedURLException {
        driver=new RemoteWebDriver(new URL(sahsiURL) , new EdgeOptions());
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("medunnaUrl"));
    }



    @Given ("grid kullanici {string} safari ile medunna sayfasina gider")
    public void gridKullaniciSafariIleMedunnaSayfasinaGider (String sahsiURL) throws MalformedURLException {
        driver=new RemoteWebDriver(new URL(sahsiURL) , new SafariOptions());
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("medunnaUrl"));
    }


























}
