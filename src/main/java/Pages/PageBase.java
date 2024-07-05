package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PageBase {

    // constructor
    // Locators
    // Action Methods
    WebDriver driver;
    static int LongExplicitWait_Value = 25;
    static int ShortExplicitWait_Value = 10;
    static int explicitWait_Value = 80;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public static void hoverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void SCrollDown50(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");
    }

    public static void SCrollDown(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public static void SCroll_deepTill_Down(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void ScrollToTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollUntilTextDisplayed(WebDriver driver, WebElement element) {
        while (!element.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)");
        }
    }


    public static void ThreadSleep2000() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void ThreadSleep1000() throws InterruptedException {
        Thread.sleep(1000);
    }

    // TODO: Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "\\src\\test\\RefrencesScreenShot\\Screenshots\\" +screenshotName + System.currentTimeMillis() + ".png"));

            System.out.println(System.getProperty("user.dir")
                    + "\\src\\test\\RefrencesScreenShot\\Screenshots\\" + screenshotName + System.currentTimeMillis() + ".png");
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void explicitWait_ToBevisibility(WebDriver driver, By element) {
        // explicit wait - to wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait_Value));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void explicitWait_Button_ToBeClickable(WebDriver driver, By element) {
        // explicit wait - to wait for the button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait_Value));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //fluentWaitHandling not recommended to use
    public static void fluentWaitHandling(WebDriver driver, By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    // long explicit wait
    public static WebDriverWait LongExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(LongExplicitWait_Value));
    }

    // short explicit wait
    public static WebDriverWait ShortExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(ShortExplicitWait_Value));
    }

    //wait for java script running
    public static void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, Duration.ofSeconds(50))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                System.out.println("Ready State: " + readyState);
                return (Boolean) readyState.equals("complete");
            }
        });
    }

    public static void removeAds(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");

    }

    public static void afterDoingDownload_ClickOnSaveAs() {
        try {
            // Wait for the dialog to appear (may need to adjust the sleep time)
            Thread.sleep(2000);

            // Create an instance of Robot class
            Robot robot = new Robot();

            // Generate the file path
            String nameGenerationUtility = Utility.generateCompanyName();
            String directoryPath = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data\\";
            String filePath = directoryPath + nameGenerationUtility + ".txt";
            System.out.println("File path: " + filePath);

            // Ensure the directory exists
            ensureDirectoryExists(directoryPath);

            // Type the file path
            typeFilePath(robot, filePath);

            // Simulate pressing the "Enter" key to confirm the save
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Wait a moment for the save operation to complete
            Thread.sleep(2000);

            // Verify if the file was created
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File saved successfully: " + filePath);
            } else {
                System.out.println("File not saved: " + filePath);
            }

        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }

    private static void ensureDirectoryExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create directory: " + directoryPath);
            }
        }
    }

    private static void typeFilePath(Robot robot, String filePath) {
        for (char c : filePath.toCharArray()) {
            typeCharacter(robot, c);
        }
    }

    private static void typeCharacter(Robot robot, char character) {
        System.out.println("Typing character: " + character);
        switch (character) {
            case ':':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '\\':
                robot.keyPress(KeyEvent.VK_BACK_SLASH);
                robot.keyRelease(KeyEvent.VK_BACK_SLASH);
                break;
            case '/':
                robot.keyPress(KeyEvent.VK_SLASH);
                robot.keyRelease(KeyEvent.VK_SLASH);
                break;
            case '.':
                robot.keyPress(KeyEvent.VK_PERIOD);
                robot.keyRelease(KeyEvent.VK_PERIOD);
                break;
            case '_':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case ' ':
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
                break;
            default:
                if (Character.isUpperCase(character)) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(character)));
                robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(Character.toUpperCase(character)));
                if (Character.isUpperCase(character)) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
        }
    }


}
