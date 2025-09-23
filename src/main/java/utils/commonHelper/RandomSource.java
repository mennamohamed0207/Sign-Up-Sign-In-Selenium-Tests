package utils.commonHelper;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomSource {
    private static final Faker faker = new Faker(new Locale("en"));

    public static String randomMobileNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String randomUsername() {
        return faker.name().username();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomName() {
        return faker.name().fullName();
    }
    public static String randomPassword()
    {
        return faker.internet().password();
    }


}
