package TestCases;

import Pages.P01_DashboardPage;
import Pages.P03_LoginPage;
import org.testng.annotations.Test;

import static TestCases.TC02_Registeration.EmailGeneration_Utility;
import static TestCases.TC02_Registeration.PasswordGeneration_Utility;
import static drivers.DriverHolder.getDriver;

public class TC01_Dashboard extends Testbase {

    @Test(priority = 1, description = "Verify choose category")
    public void Check_choosecategory() throws InterruptedException {

        new P01_DashboardPage(getDriver()).CLick_Tablet_CategoryButton()
                .CLick_AddToCart_Tablet().CLick_ShoppingCart_Button().CLick_Checkout_Button();

    }
}
