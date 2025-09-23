import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.commonHelper.Globals;

public class SignUpTest extends BaseTest{
    HomePage Home ;
    SignUpPage signupPage ;

    @BeforeTest
    public void setup(){
        Home= new HomePage(DriverManager.getDriver());
        signupPage=new SignUpPage(DriverManager.getDriver());
    }
    @Test(testName = "Signup", groups = "regression",priority =1)
    public  void signupHappyPathFlow (){
        Home.clickOnSignInUpLink();
        signupPage.enterName(Globals.name).EnterEmail(Globals.email).clickOnSignupBtn()
                .chooseGender("Mrs")
                .enterPassword(Globals.password)
                .chooseDay("6").chooseMonth("March").chooseYear("2003")
                .checkOnNewsletter()
                .enterFirstName("Mo").enterLastName("Mo")
                .enterAddress("Address").chooseCountry("India").enterState("state").enterCity("city")
                .enterZipCode("+20").enterMobileNumber(Globals.mobileNumber)
                .clickOnCreateAccountBtn();
    }

}
