package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.commonHelper.ElementHelper;

public class SignInPage {
    WebDriver driver;
    By LoginEmail =By.xpath("//input[@data-qa='login-email']");
    By  LoginPassword=By.xpath("//input[@data-qa='login-password']");
    By LoginButton =By.xpath("//button[@data-qa='login-button']");
    public  SignInPage( WebDriver driver){
        this.driver=driver;
    }
    public SignInPage EnterLoginEmail(String Email){
        ElementHelper.sendText(driver,LoginEmail,Email);
        return this ;
    }
    public SignInPage enterLoginPassword(String pass){
        ElementHelper.sendText(driver,LoginPassword,pass);
        return this ;
    }
    public SignInPage  clickOnLoginBtn() {
        ElementHelper.click(driver,LoginButton);
        return this ;
    }
}
