import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class SignInTest extends BaseTest{
    HomePage Home;
    SignInPage SignInPage;

    @BeforeTest
    public  void setUp(){
        Home =new HomePage(DriverManager.getDriver());
        SignInPage=new SignInPage(DriverManager.getDriver());
    }
    @Test
    public  void SignIn(){
        Home.clickOnSignInUpLink();
       SignInPage.EnterLoginEmail("menna123@gmail.com").enterLoginPassword("123456789").clickOnLoginBtn();
    }
}
