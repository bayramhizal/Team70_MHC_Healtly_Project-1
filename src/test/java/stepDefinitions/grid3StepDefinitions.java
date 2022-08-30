package stepDefinitions;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;

public class grid3StepDefinitions {


    public static void main(String[] args) throws MalformedURLException {


        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.XP);
        cap.setVersion("104.0.5112.102");
        cap.setJavascriptEnabled(false);


        ChromeOptions options= new ChromeOptions();
        options.merge(cap);
        // hangi Driveri istiyorsak ondan obje oluşturup Merge edecegiz


        String hubURL= "http://192.168.0.51:4444/";
        // herkese özel olan şahsi URL.
        // URL degişik ise Stringi degiştirmek yeterli....

        WebDriver driver=new RemoteWebDriver(new URL(hubURL) , options);

        driver.get(ConfigReader.getProperty("medunnaUrl"));

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());



        /*
        İsteyen Grid3 ile deneyebilir.
         */


    }



}
