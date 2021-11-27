package ui.utils;

import com.github.javafaker.Faker;
import com.kw.auto.utils.PropertyUtils;
import ui.entity.User;

import java.util.Locale;

public final class DataGenerator {
    private static final Faker FAKER = new Faker(new Locale("en"));
    private DataGenerator() { }

    private static String getRandomEmail() {
        return FAKER.bothify("chalyi.danylo##??##??@gmail.com");
    }

    public static User getUser() {
        return User.builder()
                .firstName(FAKER.name().firstName().replace("'", ""))
                .lastName(FAKER.name().lastName().replace("'", ""))
                .email(getRandomEmail())
                .password(PropertyUtils.getProperties().getProperty("password"))
                .phoneNumber(FAKER.phoneNumber().cellPhone()
                        .replaceAll("\\D", ""))
                .address(FAKER.address().streetAddress())
                .city(FAKER.address().city())
                .postCode(FAKER.address().zipCode())
                .build();
    }
}
