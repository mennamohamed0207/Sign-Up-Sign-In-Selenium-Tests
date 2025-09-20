import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignUp {
    public WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();
    }

    @Test
    public void signUpFunction() {

        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("Menna");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("Menn12@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
        //Explict wait for 2 seconds for moving to next page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_gender2")));

        driver.findElement(By.id("uniform-id_gender2")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"password\"]")).sendKeys("123456789");
        Select days = new Select(driver.findElement(By.xpath("//select[@data-qa=\"days\"]")));
        days.selectByIndex(2);
        Select months = new Select(driver.findElement(By.xpath("//select[@data-qa=\"months\"]")));
        months.selectByValue("2");
        Select years = new Select(driver.findElement(By.xpath("//select[@data-qa=\"years\"]")));
        years.selectByValue("2020");

        driver.findElement(By.xpath("//input[@data-qa=\"first_name\"]")).sendKeys("Menna");
        driver.findElement(By.xpath("//input[@data-qa=\"last_name\"]")).sendKeys("Abdelbaset");
        driver.findElement(By.xpath("//input[@data-qa=\"company\"]")).sendKeys("Unknown llasf");
        driver.findElement(By.xpath("//input[@data-qa=\"address\"]")).sendKeys("Giza");

        Select country = new Select(driver.findElement(By.xpath("//select[@data-qa=\"country\"]")));
        country.selectByIndex(1);

        driver.findElement(By.xpath("//input[@data-qa=\"state\"]")).sendKeys("Giza");
        driver.findElement(By.xpath("//input[@data-qa=\"city\"]")).sendKeys("Giza");
        driver.findElement(By.xpath("//input[@data-qa=\"zipcode\"]")).sendKeys("Giza");
        driver.findElement(By.xpath("//input[@data-qa=\"mobile_number\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
        Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        WebElement sucessMessage=fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b")));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(sucessMessage);
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
