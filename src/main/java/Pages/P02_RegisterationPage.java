package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P02_RegisterationPage {
    WebDriver driver;

    public P02_RegisterationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    private final By FirstName_TEXT = By.xpath("//input[@id='input-firstname']");
    private final By LastName_TEXT = By.xpath("//input[@id='input-lastname']");
    private final By Email_TEXT = By.xpath("//input[@id='input-email']");
    private final By Telephone_TEXT = By.xpath("//input[@id='input-telephone']");
    private final By Password_TEXT = By.xpath("//input[@id='input-password']");
    private final By ConfirmPassword_TEXT = By.xpath("//input[@id='input-confirm']");
    private final By TermasAgree_RadioButton = By.xpath("//input[@name='agree']");
    private final By Continue_Button = By.xpath("//input[@type='submit']");
    private final By SuccessfullyRegisterNewAccount_TXT = By.xpath("//h1[text()='Your Account Has Been Created!']");
    private final By ContinueAfterCreatedAccount_Button = By.xpath("//a[text()='Continue']");

    public P02_RegisterationPage Insert_FirstName_TEXT(String Firstname) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.FirstName_TEXT);
        driver.findElement(this.FirstName_TEXT).sendKeys(Firstname);
        return this;
    }
    public P02_RegisterationPage Insert_LastName_TEXT(String Lastname) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.LastName_TEXT);
        driver.findElement(this.LastName_TEXT).sendKeys(Lastname);
        return this;
    }
    public P02_RegisterationPage Insert_Email_TEXT(String email) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Email_TEXT);
        driver.findElement(this.Email_TEXT).sendKeys(email);
        return this;
    }
    public P02_RegisterationPage Insert_Telephone_TEXT(String phone) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Telephone_TEXT);
        driver.findElement(this.Telephone_TEXT).sendKeys(phone);
        return this;
    }
    public P02_RegisterationPage Insert_Password_TEXT(String Password) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Password_TEXT);
        driver.findElement(this.Password_TEXT).sendKeys(Password);
        return this;
    }
    public P02_RegisterationPage Insert_ConfirmPassword_TEXT(String ConfirmPassword) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.ConfirmPassword_TEXT);
        driver.findElement(this.ConfirmPassword_TEXT).sendKeys(ConfirmPassword);
        return this;
    }
    public P02_RegisterationPage CLick_TermasAgree_RadioButton() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.TermasAgree_RadioButton);
        driver.findElement(this.TermasAgree_RadioButton).click();
        return this;
    }
    public P02_RegisterationPage CLick_Continue_Button() {
        PageBase.SCrollDown(getDriver());
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Continue_Button);
        driver.findElement(this.Continue_Button).click();
        return this;
    }
    public P02_RegisterationPage CLick_ContinueAfterCreatedAccount_Button() {
        PageBase.SCrollDown(getDriver());
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.ContinueAfterCreatedAccount_Button);
        driver.findElement(this.ContinueAfterCreatedAccount_Button).click();
        return this;
    }

    public boolean Verify_SuccessfullyRegisterNewAccount_TXT() {
        PageBase.explicitWait_ToBevisibility(getDriver(), this.SuccessfullyRegisterNewAccount_TXT);
        System.out.println("driver.findElement(this.SuccessfullyRegisterNewAccount_TXT).getText() "+driver.findElement(this.SuccessfullyRegisterNewAccount_TXT).getText());
        return driver.findElement(this.SuccessfullyRegisterNewAccount_TXT).getText().contains("Your Account Has Been Created!");
    }
}
