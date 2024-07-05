package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P03_LoginPage {
    WebDriver driver;

    public P03_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private final By Email_TXT = By.xpath("//input[@id='input-email']");
    private final By Password_TXT = By.xpath("//input[@id='input-password']");
    private final By Login_Button = By.xpath("//input[@type='submit']");

    public P03_LoginPage Insert_Email_TXT(String email) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Email_TXT);
        driver.findElement(this.Email_TXT).sendKeys(email);
        return this;
    }
    public P03_LoginPage Insert_Password_TXT(String password) {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Password_TXT);
        driver.findElement(this.Password_TXT).sendKeys(password);
        return this;
    }
    public P03_LoginPage Click_Login_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Login_Button);
        driver.findElement(this.Login_Button).click();
        return this;
    }
}
