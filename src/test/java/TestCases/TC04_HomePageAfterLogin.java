package TestCases;

import Pages.P02_RegisterationPage;
import Pages.P03_LoginPage;
import Pages.P04_HomePage_Afterlogin;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static TestCases.TC02_Registeration.EmailGeneration_Utility;
import static TestCases.TC02_Registeration.PasswordGeneration_Utility;
import static drivers.DriverHolder.getDriver;

public class TC04_HomePageAfterLogin extends Testbase{
    @Test(priority = 1, description = "Verify Logout")
    public void Check_LogOut() throws InterruptedException {

        new P04_HomePage_Afterlogin(getDriver()).Click_Logout_Button();
        PageBase.captureScreenshot(driver,"LogOut_P");
        Assert.assertTrue(new P04_HomePage_Afterlogin(getDriver()).Verify_Transfer_LogoutSuccessfully_TEXT());
        new P04_HomePage_Afterlogin(getDriver()).Click_ContinueLogout_Button();
    }
}
