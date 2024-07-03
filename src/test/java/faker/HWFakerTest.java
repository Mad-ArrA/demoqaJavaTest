package faker;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getSelectedText;
import static faker.TestData.*;
import static utils.RandomUtils.*;


public class HWFakerTest extends TestBase {

    @Test
    void successfulRegistrationTest() {
        //Faker fakername = new Faker(new Locale("ru"));
        Faker faker = new Faker();
        String userName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userGender = faker.options().nextElement(new String[]{"Male", "Female", "Other"});
        String userPhone = faker.phoneNumber().subscriberNumber(10);
        String userBirthDay = String.valueOf(faker.number().numberBetween(1, 28));
        String userBirthMonth = faker.options().option("January", "February",
                "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String userBirthYears = String.valueOf(faker.number().numberBetween(1950, 2024));
        String userSubject = faker.options().nextElement(new String[]{"English", "Physics", "Chemistry", "Computer Science", "Commerce", "Accounting", "Economics"});
        String userHobbies = faker.options().nextElement(new String[]{"Sports", "Reading", "Music"});
        String userPicture = "example.png";
        String userCurrentAddress = faker.address().fullAddress();
        String userState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");


        String city = new String();
        if (userState == "NCR") {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (userState == "Uttar Pradesh") {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (userState == "Haryana") {
            city = faker.options().option("Karnal", "Panipat");
        } else {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }

        String userCity = city;


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYears)
                .setSubjects(userSubject)
                .setHobbies(userHobbies)
                .setUploadPicture(userPicture)
                .setCurrentAddress(userCurrentAddress)
                .setStateCity(userState)
                .setStateCitySecond(city)
                .submit();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYears)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPicture)
                .verifyResult("Address", userCurrentAddress)
                .verifyResult("State and City", "NCR Delhi");
    }

}