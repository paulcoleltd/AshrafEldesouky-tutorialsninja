package TestCases;

import Pages.P01_DashboardPage;
import Pages.PageBase;
import TestCases.TC02_Registeration;
import Pages.P03_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestCases.TC02_Registeration.EmailGeneration_Utility;
import static TestCases.TC02_Registeration.PasswordGeneration_Utility;
import static drivers.DriverHolder.getDriver;

public class TC03_Login extends Testbase{

    @Test(priority = 1, description = " Verify Login User")
    public void Check_LoginUser() throws InterruptedException {

        new P01_DashboardPage(getDriver()).CLick_MyAccount_Button().CLick_Login_Button();
        new P03_LoginPage(getDriver()).Insert_Email_TXT(EmailGeneration_Utility)
                .Insert_Password_TXT(PasswordGeneration_Utility).Click_Login_Button();

        PageBase.captureScreenshot(driver,"LoginPositive");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://tutorialsninja.com/demo/index.php?route=account/account"));
    }
}
