package true_test;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import true_test.pages.TaniaSignUPPage;

import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaSignUpTest {
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

   @Test
    public void CheckingLabelOnLoginPage(){
        //taniaSignUPPage.waitForFirstNameWarning();

        System.out.println("Page title is: " + driver.getTitle());
       // System.out.println("Text element ="+taniaSignUPPage.gettext());

        assertTrue( "First Name text is confirmed", taniaSignUPPage.CheckFirstNameLabel());
        assertTrue( "Last Name text is confirmed", taniaSignUPPage.CheckLastNameLabel());
        assertTrue( "Email text is confirmed", taniaSignUPPage.CheckEmailLabel());
        assertTrue( "Zip Code text is confirmed", taniaSignUPPage.CheckZipCodeLabel());
        assertTrue( "Company  text is confirmed", taniaSignUPPage.CheckCompanyNameLabel());
        assertTrue("Check kapcha", taniaSignUPPage.CheckPageForCapthcaMessage());
        /* try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


   @Test
    public void fillSignUPFiledsPositive() throws InterruptedException {
        //  Log.info("TestLoginWithExtData was started....");
        taniaSignUPPage
                .fillcompanyField("company")
                .fillemailField("sem@yuopmail.com")
                .fillFirstnameField("firstname")
                .fillLastNameField("last")
                .fillzipcodeField("110000")
                .fillzipCode2Field("55");
        //pass the captcha manually
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taniaSignUPPage.buttoncontinueButton();
       assertTrue( "First Name text is confirmed", taniaSignUPPage.CheckFirstNameLabel());
       assertTrue( "Last Name text is confirmed", taniaSignUPPage.CheckLastNameLabel());
       assertTrue( "Email text is confirmed", taniaSignUPPage.CheckEmailLabel());
       assertTrue( "Zip Code text is confirmed", taniaSignUPPage.CheckZipCodeLabel());
       assertTrue( "Company  text is confirmed", taniaSignUPPage.CheckCompanyNameLabel());
       assertTrue("Check kapcha", taniaSignUPPage.CheckPageForCapthcaMessage());


    }

    @Test //negative
    public void WorningNoFillFirstName(){
        taniaSignUPPage
                .NoFillUsernameFields()
                .buttoncontinueButton()
                .waitForFirstNameWarning();
        System.out.println(taniaSignUPPage.gettext());
        assertTrue("Check warning message the first name feld is ampty ", taniaSignUPPage.CheckWarningMessageFirstName());

    }
    @Test //negative
    public void WorningFieldFirstNameWrong(){
        taniaSignUPPage
                .WrongFillUsernameFields()
                .buttoncontinueButton()
                .waitForFirstNameWarning1();

        assertTrue("Check warning message the first name field is wrongly filled ", taniaSignUPPage.CheckWarningMessageFirstNameisSimbols());

    }

    @Test//negative
    public void WorningFieldFirstNameOneNumber(){
        taniaSignUPPage
                .OneNumbFillFirstName()
                .buttoncontinueButton()
                .waitForFirstNameWarning2();
        assertTrue("Check warning message the first name field is one number ", taniaSignUPPage.CheckWarningMessageFirstNameisOneNumber());

    }

    @Test//negative
    public void WorningNoFillLastNane(){
        taniaSignUPPage
                .NoFillLastnameFields()
                .buttoncontinueButton()
                .waitForLasttNameWarning1();
        assertTrue("Check warning massage the Last name feld is ampty ", taniaSignUPPage.CheckWarningMessageLastName());

    }
    @Test//negative
    public void WorningFieldLastNameWrong(){
        taniaSignUPPage
                .WrongFillLastnameFields()
                .buttoncontinueButton()
                .waitForLasttNameWarning2();
        assertTrue("Check warning message the Last name field is wrongly filled ", taniaSignUPPage.CheckWarningMessageLastNameisSimvols());

    }
    @Test//negative
    public void WorningNoFieldEmail(){
        taniaSignUPPage
                .NoFillEmailFields()
                .buttoncontinueButton()
                .waitForEmailWarning1();
        assertTrue("Check warning message the email field is ampty ", taniaSignUPPage.CheckWarningMessageEmail());

    }

    @Test//negative
    public void WoringNoFillZipCode(){
        taniaSignUPPage
                .NoFillZipCodeFields()
                .buttoncontinueButton()
                .waitForZipCodeWarning1();
        assertTrue("Check warning message the Zip Code field is ampty ", taniaSignUPPage.CheckWarningMessageZipCod());

    }
    @Test//negative
    public void WoringFieldZipCodeWrongNumb(){
        taniaSignUPPage
                .WrongFillZipCodeFields()
                .buttoncontinueButton()
                .waitForZipCodeWarning2();
        assertTrue("Check warning message the Zip Code field is wrongly filled of numbers ", taniaSignUPPage.CheckWarningMessageWrongZipCod());

    }
    @Test//negative
    public void  WoringFieldZipCodeWrongLetters(){
        taniaSignUPPage
                .FillZipCodeFieldsofLetters()
                .buttoncontinueButton()
                .waitForZipCodeWarning3();
        assertTrue("Check warning message the Zip Code field is wrongly filled of letters ", taniaSignUPPage.CheckWarningMessageZipCodLetters());

    }

    // test of clicking on Registration link are writtenw in another class

    /* @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/

   @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}