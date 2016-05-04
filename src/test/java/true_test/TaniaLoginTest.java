package true_test;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import true_test.pages.TaniaLoginPage;

import static org.testng.AssertJUnit.assertTrue;

//@org.testng.annotations.Listeners(FailTestScreenshotListener.class)
public class TaniaLoginTest extends TestNgTestBase {

  //static String driverPath = "D:\\Tel_Ran\\Java\\webDrivers\\";
    public TaniaLoginPage taniaLoginPage;
    // public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
      //System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
        //driver = new ChromeDriver();

        // driver = new FirefoxDriver();
        taniaLoginPage = PageFactory.initElements(driver, TaniaLoginPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp(){
        // taniaLoginPage.openLoginPage();
        driver.get("http://admin.yikids.com/");
    }

    @Test//positive test
    public void PositiveLoginTest() {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage.Login();


        System.out.println("Page title is: " + driver.getTitle());
      // System.out.println("Text element ="+taniaLoginPage.gettext());

      assertTrue( "The text element LogOut is present on the page", taniaLoginPage.CheckTextOfElementLogOut());

      assertTrue("Check : the element LogOut is present on the page", taniaLoginPage.CheckElementLogOu());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadInvalidLoginFromFile")
    public void NegstiveLoginTest(String login, String pass) {
        //  Log.info("TestLoginWithExtData was started....");
        taniaLoginPage
                .fillEmailField(login)
                .fillPasswordField(pass)
                .ClickLoginButton();

        // String assertText = "taniaLoginPage."+method+";";


        //assertTrue( "The text error email is present on the page", taniaLoginPage.CheckTextErrorEmail());

        assertTrue("We are not in login page anymore", taniaLoginPage.CheckElementLogIn());

    }





 /* @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }*/
}