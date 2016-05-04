package true_test;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import true_test.pages.TaniaHospitalOwnerManagementPage;
import true_test.pages.TaniaLoginPage;


public class TaniaHospitalOwnerManagementTest {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public TaniaHospitalOwnerManagementPage taniaHospOwManagP;
    public TaniaLoginPage loginpage;
    public WebDriver driver;
    //public String email = "admin@erdocfinder.com";
    //public String passwordField = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        loginpage = PageFactory.initElements(driver, TaniaLoginPage.class);
        taniaHospOwManagP = PageFactory.initElements(driver, TaniaHospitalOwnerManagementPage.class);
        loginpage.openLoginPage();
        loginpage.Login();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {

        taniaHospOwManagP.openAdminPage();
        //  driver.get("http://admin.yikids.com/admin/hospital_owner_management");
    }


        @Test
        public void HospitalOwnTest() {

            System.out.println("Text element ="+ taniaHospOwManagP.gettext());
            taniaHospOwManagP.checkCheckbxesStatus(10,"Not Owned Anymore");


        }


  /* @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }*/
}



