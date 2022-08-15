package utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MedunnaPage;

public class Methods {

    public static void adminGiris() {
        MedunnaPage enter=new MedunnaPage();
        Actions action=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        enter.accountMenu.click();
        enter.signIn.click();
        enter.userName.click();
        action.sendKeys(ConfigReader.getProperty("adminUN"),
                Keys.TAB,ConfigReader.getProperty("adminPW"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }
    public static void staffGiris() {
        MedunnaPage enter=new MedunnaPage();
        Actions action=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        enter.accountMenu.click();
        enter.signIn.click();
        enter.userName.click();
        action.sendKeys(ConfigReader.getProperty("staffUN"),
                Keys.TAB,ConfigReader.getProperty("staffPW"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }
    public static void patientGiris() {
        MedunnaPage enter=new MedunnaPage();
        Actions action=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        enter.accountMenu.click();
        enter.signIn.click();
        enter.userName.click();
        action.sendKeys(ConfigReader.getProperty("patientUN"),
                Keys.TAB,ConfigReader.getProperty("patientPW"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }
    public static void physicianGiris() {
        MedunnaPage enter=new MedunnaPage();
        Actions action=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        enter.accountMenu.click();
        enter.signIn.click();
        enter.userName.click();
        action.sendKeys(ConfigReader.getProperty("physicianUN"),
                Keys.TAB,ConfigReader.getProperty("physicianPW"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }
    public static void userGiris() {
        MedunnaPage enter=new MedunnaPage();
        Actions action=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        enter.accountMenu.click();
        enter.signIn.click();
        enter.userName.click();
        action.sendKeys(ConfigReader.getProperty("userUN"),
                Keys.TAB,ConfigReader.getProperty("userPW"),Keys.TAB,Keys.TAB,Keys.
                        TAB,Keys.TAB,Keys.ENTER).perform();
    }
    public static void signOut(){
        MedunnaPage enter=new MedunnaPage();
        enter.accountMenu.click();
        enter.signOut.click();
    }
}
