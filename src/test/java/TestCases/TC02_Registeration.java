package TestCases;

import Pages.P01_DashboardPage;
import Pages.P02_RegisterationPage;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Utility;

import static drivers.DriverHolder.getDriver;
import static util.Utility.generateRandomPhoneNumber;

public class TC02_Registeration extends Testbase{

    String Firstname_fakerDate = faker.name().firstName(); // Middle name generated using firstName()
    String lastName_fakerDate = faker.name().lastName();
    String randomPhoneNumber_Utility = generateRandomPhoneNumber();
    public static String EmailGeneration_Utility = Utility.generateRandomEmail();
    public static String PasswordGeneration_Utility = Utility.generatePassword(9);
    @Test(priority = 1, description = "Test Case 1 : Verify Regsiteration")
    public void Check_Regsiteration() throws InterruptedException {

        System.out.println(EmailGeneration_Utility);
        System.out.println(PasswordGeneration_Utility);

        new P01_DashboardPage(getDriver()).CLick_MyAccount_Button().CLick_Regsiter_Button();

        new P02_RegisterationPage(getDriver()).Insert_FirstName_TEXT(Firstname_fakerDate).Insert_LastName_TEXT(lastName_fakerDate)
                .Insert_Email_TEXT(EmailGeneration_Utility).Insert_Telephone_TEXT(randomPhoneNumber_Utility)
                .Insert_Password_TEXT(PasswordGeneration_Utility).Insert_ConfirmPassword_TEXT(PasswordGeneration_Utility)
                . CLick_TermasAgree_RadioButton().CLick_Continue_Button();

        PageBase.captureScreenshot(driver,"RegisterPositive_A");
        Assert.assertTrue(new P02_RegisterationPage(getDriver()).Verify_SuccessfullyRegisterNewAccount_TXT());
        new P02_RegisterationPage(getDriver()).CLick_ContinueAfterCreatedAccount_Button();

        PageBase.captureScreenshot(driver,"RegisterPositive_B");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("https://tutorialsninja.com/demo/index.php?route=account/account"));

    }


}

