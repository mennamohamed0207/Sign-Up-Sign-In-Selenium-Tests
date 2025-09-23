import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.commonHelper.Globals;

public class BaseTest {
    @BeforeTest
    public void Init() {
        DriverManager.driverSetup();
        Globals.intializeRandomFields();
    }

    @AfterTest
    public void closeDriver(){
        //DriverManager.closeDriver();
    }
}
