package true_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import true_test.pages.TaniaHospitalOwnerManagementPage;
import true_test.pages.TaniaLoginPage;


public class TaniaHospitalOwnerManagementTest {

    public TaniaHospitalOwnerManagementPage elenaHOMtPage;
    public TaniaLoginPage loginpage;
    public WebDriver driver;
    //public String email = "admin@erdocfinder.com";
    //public String passwordField = "Test123";

    @BeforeClass(alwaysRun = true)
    public void setup() {
       // driver = new ChromeDriver();
        driver = new FirefoxDriver();
        loginpage = PageFactory.initElements(driver, TaniaLoginPage.class);
        elenaHOMtPage = PageFactory.initElements(driver, TaniaHospitalOwnerManagementPage.class);
        loginpage.openLoginPage();
        loginpage.Login();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetUp() {

        elenaHOMtPage.openAdminPage();
        //  driver.get("http://admin.yikids.com/admin/hospital_owner_management");
    }


        @Test
        public void HospitalOwnTest() {

            System.out.println("Text element ="+ elenaHOMtPage.gettext());
            elenaHOMtPage.checkCheckbxesStatus(10,"Not Owned Anymore");


        }


  /* @AfterClass(alwaysRun = true)
   public void tearDown() {
        this.driver.quit();
    }*/
}



