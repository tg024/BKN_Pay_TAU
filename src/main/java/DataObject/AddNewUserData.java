package DataObject;

import com.github.javafaker.Faker;

public interface AddNewUserData {
    Faker faker = new Faker();
    String
            validFullName = faker.name().fullName(),
            invalidFormatName = "123",
            validEmailAddress = faker.internet().emailAddress(),
            invalidEmail = faker.name().firstName(),
            validRole = "Commercialista",
            emptyRole = "",
            emptyFullName = "",
            emptyEmail = "";
}
