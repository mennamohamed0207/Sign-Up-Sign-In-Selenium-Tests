import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignIn {
    public WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver=new ChromeDriver();
        driver.get("https://automationexercise.com/login");
        driver.manage().window().maximize();
        //implicit wait for 0.5 second
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));


    }
    @Test
    public void signInFunction()
    {
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("menna124@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/");

    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
