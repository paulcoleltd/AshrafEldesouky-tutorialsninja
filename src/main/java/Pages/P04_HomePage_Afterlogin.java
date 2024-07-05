package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P04_HomePage_Afterlogin {


    WebDriver driver;

    public P04_HomePage_Afterlogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private final By Logout_Button = By.xpath("(//a[text()='Logout'])[2]");
    private final By LogoutSuccessfully_TEXT = By.xpath("//h1[text()='Account Logout']");
    private final By ContinueLogout_Button = By.xpath("//a[text()='Continue']");

    public P04_HomePage_Afterlogin Click_Logout_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Logout_Button);
        driver.findElement(this.Logout_Button).click();
        return this;
    }
    public boolean Verify_Transfer_LogoutSuccessfully_TEXT() {
        PageBase.explicitWait_ToBevisibility(getDriver(), this.LogoutSuccessfully_TEXT);
        System.out.println("driver.findElement(this.LogoutSuccessfully_TEXT).getText() "+driver.findElement(this.LogoutSuccessfully_TEXT).getText());
        return driver.findElement(this.LogoutSuccessfully_TEXT).getText().contains("Account Logout");
    }
    public P04_HomePage_Afterlogin Click_ContinueLogout_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),ContinueLogout_Button);
        driver.findElement(this.ContinueLogout_Button).click();
        return this;
    }

}
