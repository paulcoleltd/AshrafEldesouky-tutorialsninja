package TestCases;

import com.github.javafaker.Faker;
import common.MyScreenRecorder;
import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import util.Utility;

import java.util.concurrent.TimeUnit;

public class Testbase {

    protected static WebDriver driver;
    protected Faker faker = new Faker();


    @Parameters("browser")
    @BeforeTest
    public void setup(String browser) throws Exception {
        // Start Recording
//        MyScreenRecorder.startRecording("Sprint1");
        driver = DriverFactory.getNewInstance(browser);
        DriverHolder.setDriver(driver);

        // Set the implicit wait time to 10 seconds
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @AfterTest
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        //Stop Recording
//        MyScreenRecorder.stopRecording();
    }
    @AfterSuite
    public void deleteScreen() throws Exception {
        // Code Shady Group Whatsapp
        // use it per 3 months
        String folderPath = System.getProperty("user.dir")+ "\\src\\test\\RefrencesScreenShot\\Screenshots\\" ;
        System.out.println("folderPath : "+folderPath);
        Utility.deleteFilesInFolder(folderPath);
    }
}
