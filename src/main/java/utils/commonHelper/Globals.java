package utils.commonHelper;

public class Globals {
    static public String username;
    static public String name;
    static public String mobileNumber;
    static public String email;
    static public String password;

    static public void intializeRandomFields()
    {
        username=RandomSource.randomUsername();
        name=RandomSource.randomName();
        mobileNumber=RandomSource.randomMobileNumber();
        email=RandomSource.randomEmail();
        password=RandomSource.randomPassword();

    }

}
