package true_test.pages;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import true_test.LogLog4j;

import java.util.Random;
import java.util.logging.Logger;


public class TaniaLoginPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();


    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement psswordField;

    @FindBy(xpath="//*[@class='err']")
    WebElement ErrorEmail;

    @FindBy(xpath = "//div[@class='err'][contains(text(),'Your passwordField is not correct. Please try again.')]")
    WebElement errorPasswordMessage;

    //buttons
    @FindBy(xpath = "//*[@id='login-form']/div/button")
    WebElement LoginButton;
    @FindBy(xpath = "//*[@id='logout-container']/a")
    WebElement LogOutButton;

    public TaniaLoginPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://admin.yikids.com/";
        PageFactory.initElements(driver, this);
    }



    //Fill the fields

    public TaniaLoginPage openLoginPage() {
        Log.info("Opening Login page");
        driver.get(PAGE_URL);
        return this;
    }


    public TaniaLoginPage fillEmailField(String email) {
        //Log.info("Filling username field");
        setElementText(emailField, email);
        return this;
    }

     public TaniaLoginPage Login() {
         fillEmailField("admin@erdocfinder.com");
         fillPasswordField("Test123");
         ClickLoginButton();
         return this;
     }


    public TaniaLoginPage fillPasswordField(String password) {
        //Log.info("Filling username field");
        setElementText(psswordField, password);
        return this;
    }

    public String gettext() {
        return getTextElement(ErrorEmail);
    }

    //click button
    public TaniaLoginPage ClickLoginButton( ) {
        //Log.info("Filling username field");
        clickElement(LoginButton);
        return this;
    }

    public boolean CheckTextOfElementLogOut() {
        return verifyTextBoolean(LogOutButton, "Log Out");
    }
    public boolean CheckElementLogOu() {
        return verifyElementIsPresent(LogOutButton);
    }

    public boolean CheckTextErrorEmail() {
        return verifyTextBoolean(ErrorEmail, "Please sign up because your email does not exist in our system.");
    }

    public boolean CheckElementLogIn() {
        return exists(LoginButton);
        }

    public boolean passwordNotCorrect() {
        return exists(errorPasswordMessage);
    }


    }


