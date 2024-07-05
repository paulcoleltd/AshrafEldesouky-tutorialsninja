package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P01_DashboardPage {

    WebDriver driver;

    public P01_DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    private final By MyAccount_Button = By.xpath("//a[@title='My Account']");
    private final By Regsiter_Button = By.xpath("//a[text()='Register']");
    private final By Login_Button = By.xpath("(//a[text()='Login'])[1]");
    private final By Tablet_CategoryButton = By.xpath("(//a[text()='Tablets'])[1]");
    private final By AddToCart_Tablet = By.xpath("//span[text()='Add to Cart']");
    private final By ShoppingCart_Button = By.xpath("//span[text()='Shopping Cart']");
    private final By Checkout_Button = By.xpath("//a[text()='Checkout']");

    public P01_DashboardPage CLick_MyAccount_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.MyAccount_Button);
        driver.findElement(this.MyAccount_Button).click();
        return this;
    }
    public P01_DashboardPage CLick_Regsiter_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Regsiter_Button);
        driver.findElement(this.Regsiter_Button).click();
        return this;
    }
    public P01_DashboardPage CLick_Login_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Login_Button);
        driver.findElement(this.Login_Button).click();
        return this;
    }
    public P01_DashboardPage CLick_Tablet_CategoryButton() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Tablet_CategoryButton);
        driver.findElement(this.Tablet_CategoryButton).click();
        return this;
    }
    public P01_DashboardPage CLick_AddToCart_Tablet() {
        PageBase.SCrollDown(getDriver());
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.AddToCart_Tablet);
        driver.findElement(this.AddToCart_Tablet).click();
        return this;
    }
    public P01_DashboardPage CLick_ShoppingCart_Button() {
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.ShoppingCart_Button);
        driver.findElement(this.ShoppingCart_Button).click();
        return this;
    }
    public P01_DashboardPage CLick_Checkout_Button() {
        PageBase.SCroll_deepTill_Down(getDriver());
        PageBase.explicitWait_Button_ToBeClickable(getDriver(),this.Checkout_Button);
        driver.findElement(this.Checkout_Button).click();
        return this;
    }

}
