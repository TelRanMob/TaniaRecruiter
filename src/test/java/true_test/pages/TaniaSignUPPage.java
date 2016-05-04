package true_test.pages;

/**
 * Created by Tatiana Pereminski on 01/05/2016.
 */


import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import true_test.LogLog4j;

import java.io.IOException;
import java.util.Random;

public class TaniaSignUPPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private static Random rnd = new Random();


    //fields
    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "zipcode")
    WebElement zipCodeField;

    @FindBy(id = "zip-plus")
    WebElement zipCode2Field;

    @FindBy(id = "company")
    WebElement companyField;

    //buttons
    @FindBy(id = "create-account")
    WebElement continueButton;

    //System messages
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name field is required.']")
    WebElement firstNameEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name may only contain letters and numbers.']")
    WebElement firstNameWrongFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The first name must be at least 3 characters.']")
    WebElement firstNameOneNumbFieldMessage;

    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The last name field is required.']")
    WebElement LastNameEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The last name may only contain letters and numbers.']")
    WebElement LastNameWrongFieldMessage;

    @FindBy(xpath = "//*[@id='email-error']/*[text()='The email field is required.']")
    WebElement EmailEmptyFieldMessage;
    @FindBy(xpath = "//*[@id='email-error']/*[text()='The email format is invalid.']")
    WebElement EmailWrongFieldMessage;

    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The zipcode field is required.']")
    WebElement ZipCodEmptyFieldMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='Zipcode is invalid']")
    WebElement ZipCodWrongFielNumbdMessage;
    @FindBy(xpath = "//div [@class='col-sm-6']/*[text()='The zipcode must be a number.']")
    WebElement ZipCodWrongFieldLattersMessage;

    @FindBy(xpath = "//*[@id='section-account']/span")
    WebElement ErrorCaptcha;


    //Labels
    @FindBy(xpath = "//*[@id='section-account']/div[1]/div/label")
    WebElement FirstNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[2]/div/label")
    WebElement LastNameLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[3]/div/label")
    WebElement EmailLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[4]/div/label")
    WebElement ZipCodLabel;
    @FindBy(xpath = "//*[@id='section-account']/div[5]/div/label")
    WebElement CompanyLabel;


    public TaniaSignUPPage(WebDriver driver) {
        super(driver);
        this.PAGE_URL = "http://physician.yikids.com/recruiter/signup";
        PageFactory.initElements(driver, this);
    }

    private static String getRandomString(final int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public TaniaSignUPPage openTaniaSignUPPage() {
        Log.info("Opening TaniaSignUPPage page");
        driver.get(PAGE_URL);
        return this;
    }
    //Fill the fields

    public TaniaSignUPPage fillFirstnameField(String username) {
        Log.info("Filling username field");
        setElementText(firstNameField, username);
        return this;
    }

    public TaniaSignUPPage fillLastNameField(String lastname) {
        Log.info("Filling lastname field");
        setElementText(lastNameField, lastname);
        return this;
    }

    public TaniaSignUPPage fillemailField(String email) {
        Log.info("Filling email field");
        setElementText(emailField, email);
        return this;
    }

    public TaniaSignUPPage fillzipcodeField(String zipcode) {
        Log.info("Filling zipcode field");
        setElementText(zipCodeField, zipcode);
        return this;
    }

    public TaniaSignUPPage fillzipCode2Field(String zipcode2) {
        Log.info("Filling zipcode2 field");
        setElementText(zipCode2Field, zipcode2);
        return this;
    }

    public TaniaSignUPPage fillcompanyField(String companyName) {
        Log.info("Filling companyName field");
        setElementText(companyField, companyName);
        return this;
    }

    public TaniaSignUPPage buttoncontinueButton() {
        Log.info("Click To Continue");
        clickElement(continueButton);
        return this;
    }


    public String generateEmail() {
        String rand = getRandomString(5);
        String username = rand + "@yopmail.com";
         Log.info("Doctor's Username generated is <" + username + ">");
        return username;
    }


    public TaniaSignUPPage FillsignUPFields() throws InterruptedException {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
       // Thread.sleep(15000);
        buttoncontinueButton();
        return this;
    }

    public TaniaSignUPPage NoFillUsernameFields() {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage OneNumbFillFirstName() {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("1");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage WrongFillUsernameFields() {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("wewr-324");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage NoFillLastnameFields() {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage WrongFillLastnameFields() {
        Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("ertr@hh");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage NoFillEmailFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        fillemailField(" ");
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage WrongFillEmailFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        fillemailField("24354656 ");
        fillzipcodeField("00801");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage WrongFillZipCodeFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("0080");
        fillzipCode2Field("0080");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage NoFillZipCodeFields() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("");
        fillzipCode2Field("");
        fillcompanyField("company");
        return this;
    }

    public TaniaSignUPPage FillZipCodeFieldsofLetters() {
        //Log.info("Filling all fields");
        openTaniaSignUPPage();
        fillFirstnameField("username");
        fillLastNameField("lastname");
        String email = generateEmail();
        fillemailField(email);
        fillzipcodeField("hdfh");
        fillzipCode2Field("");
        fillcompanyField("company");
        return this;
    }


    public boolean CheckFirstNameLabel() {
        return verifyTextBoolean(FirstNameLabel, "First name*");
    }

    public boolean CheckLastNameLabel() {
        return verifyTextBoolean(LastNameLabel, "Last name*");
    }

    public boolean CheckEmailLabel() {
        return verifyTextBoolean(EmailLabel, "Email*");
    }

    public boolean CheckZipCodeLabel() {
        return verifyTextBoolean(ZipCodLabel, "Zip code*");
    }

    public boolean CheckCompanyNameLabel() {
        return verifyTextBoolean(CompanyLabel, "Company");
    }


    public String gettext() {
        return getTextElement(firstNameEmptyFieldMessage);
    }


    public boolean CheckWarningMessageFirstName() {
        return verifyTextBoolean(firstNameEmptyFieldMessage,"The first name field is required.");
    }

    public boolean CheckWarningMessageFirstNameisSimbols() {
        return verifyTextBoolean(firstNameWrongFieldMessage,"The first name may only contain letters and numbers.");
    }

    public boolean CheckWarningMessageFirstNameisOneNumber() {
        return verifyTextBoolean(firstNameOneNumbFieldMessage, "The first name must be at least 3 characters.");
    }


    public boolean CheckWarningMessageLastName() {
        return verifyTextBoolean(LastNameEmptyFieldMessage,"The last name field is required.");
    }

    public boolean CheckWarningMessageLastNameisSimvols() {
        return verifyTextBoolean(LastNameWrongFieldMessage, "The last name may only contain letters and numbers.");
    }

    public boolean CheckWarningMessageEmail() {
        return verifyTextBoolean(EmailEmptyFieldMessage, "The email field is required.");
    }

    public boolean CheckWarningMessageEmailisNumber() {
        return verifyTextBoolean(EmailWrongFieldMessage, "The email format is invalid.");
    }

    public boolean CheckWarningMessageZipCod() {
        return verifyTextBoolean(ZipCodEmptyFieldMessage, "The zipcode field is required.");
    }

    public boolean CheckWarningMessageWrongZipCod() {
        return verifyTextBoolean(ZipCodWrongFielNumbdMessage, "Zipcode is invalid");
    }

    public boolean CheckWarningMessageZipCodLetters() {
        return verifyTextBoolean(ZipCodWrongFieldLattersMessage, "The zipcode must be a number.");
    }

    public boolean CheckPageForCapthcaMessage() {
        return verifyElementIsPresent(ErrorCaptcha);

    }


    public void waitForFirstNameWarning() {
        try {
            waitUntilElementIsLoaded(firstNameEmptyFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForFirstNameWarning1() {
        try {
            waitUntilElementIsLoaded(firstNameWrongFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForFirstNameWarning2() {
        try {
            waitUntilElementIsLoaded(firstNameOneNumbFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForLasttNameWarning1() {
        try {
            waitUntilElementIsLoaded(LastNameEmptyFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForLasttNameWarning2() {
        try {
            waitUntilElementIsLoaded(LastNameWrongFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForEmailWarning1() {
        try {
            waitUntilElementIsLoaded(EmailEmptyFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForEmailWarning2() {
        try {
            waitUntilElementIsLoaded(EmailWrongFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForZipCodeWarning1() {
        try {
            waitUntilElementIsLoaded(ZipCodEmptyFieldMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForZipCodeWarning2() {
        try {
            waitUntilElementIsLoaded(ZipCodWrongFielNumbdMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void waitForZipCodeWarning3() {
        try {
            waitUntilElementIsLoaded(ZipCodWrongFieldLattersMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String waitAndGetTextofSelectedMessage(String number) throws IOException, InterruptedException {
        String locator = "//*[@id='section-account']/div[" + number + "]//div[2]/span[1]";
        WebElement m = driver.findElement(By.xpath(locator));
        waitUntilElementIsLoaded(m);
        return m.getText();
    }
}