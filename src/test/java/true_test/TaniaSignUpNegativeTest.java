package true_test;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import true_test.pages.TaniaSignUPPage;

import java.io.IOException;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaSignUpNegativeTest {
    //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public TaniaSignUPPage taniaSignUPPage;
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
       // driver = new ChromeDriver();
       driver = new FirefoxDriver();
        taniaSignUPPage = PageFactory.initElements(driver, TaniaSignUPPage.class);


    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        taniaSignUPPage.openTaniaSignUPPage();
    }


    @Test(dataProviderClass = TaniaDataProviders.class, dataProvider = "loadInvalidSingUpFromFile")
    public void SingUppNegativeTest(String Firstname, String lastname, String email, String Zip1, String Zip2, String nubmer, String message) throws IOException, InterruptedException {
        taniaSignUPPage
        .fillFirstnameField(Firstname)
        .fillLastNameField(lastname)
                .fillemailField(email)
        .fillzipcodeField(Zip1)
        .fillzipCode2Field(Zip2)
                .buttoncontinueButton();

       // System.out.println(taniaSignUPPage.gettext());
        //assertTrue("Check warning message the first name feld is ampty ",taniaSignUPPage.CheckWarningMessageFirstName());
        Assert.assertEquals(taniaSignUPPage.waitAndGetTextofSelectedMessage(nubmer), message, "Message is nor correct");

    }


    /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/

   @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}