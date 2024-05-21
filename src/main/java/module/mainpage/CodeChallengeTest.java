package module.mainpage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Code challenge")
public class CodeChallengeTest {

    @Test
    @DisplayName("Testing the codility login")
    public void PasswordAndEmailShouldBeInTheMainScreen() {

        //Open Browser
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver123\\chromedriver123.exe");
        WebDriver driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Enter in the website
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        WebElement emailField = driver.findElement(By.id("email-input"));
        if (emailField.isDisplayed()) {
            System.out.println("Email field is present on the main screen.");
        } else {
            System.out.println("Email field is not present on the main screen.");
        }
        WebElement passwordField = driver.findElement(By.id("password-input"));
        if (passwordField.isDisplayed()) {
            System.out.println("Password field is present on the main screen.");
        } else {
            System.out.println("Password field is not present on the main screen.");
        }

        driver.quit();

    }

    @Test
    @DisplayName("Testing the codility login")
    public void TestCodilityLoginWelcomeMessage() {

        //Open Browser
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver123\\chromedriver123.exe");
        WebDriver driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Enter in the website
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

        driver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        driver.findElement(By.id("password-input")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String expectedMessage = driver.findElement(By.cssSelector("div[class='message success']")).getText();
        Assertions.assertEquals("Welcome to Codility", expectedMessage);

        driver.quit();

    }
    @Test
    @DisplayName("Testing the codility login")
    public void TestCodilityLoginWrongCredentials() {

        //Open Browser
        System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver123\\chromedriver123.exe");
        WebDriver driver = new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Enter in the website
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");

        driver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
        driver.findElement(By.id("password-input")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String expectedMessage = driver.findElement(By.cssSelector("div[class='message error']")).getText();
        Assertions.assertEquals("You shall not pass! Arr!", expectedMessage);

        driver.quit();

    }

}
