package org.example.demoqa;

import org.junit.jupiter.api.Test;


    public class RegistrationWithPageObjectsTests extends TestBase {

        @Test
        void successfulRegistrationTest() {
            String userName = "Arkadiy";

            registrationPage.openPage()
                    .setFirstName(userName)
                    .setLastName("Egorov")
                    .setEmail("alex@egorov.com")
                    .setGender("Other")
                    .setPhone("1234567890")
                    .setBirthDate("30", "July", "2008")
                    .setSubjects("Math")
                    .setHobbies("Sports")
                    .setUploadPicture("example.png")
                    .setCurrentAddress("Some address 1")
                    .setStateCity("NCR")
                    .setStateCitySecond("Delhi")
                    .submit();


            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", userName + " Egorov")
                    .verifyResult("Student Email", "alex@egorov.com")
                    .verifyResult("Gender", "Other")
                    .verifyResult("Mobile", "1234567890")
                    .verifyResult("Date of Birth", "30 July,2008")
                    .verifyResult("Subjects", "Math")
                    .verifyResult("Hobbies", "Sports")
                    .verifyResult("Picture", "example.png")
                    .verifyResult("Address", "Some address 1")
                    .verifyResult("State and City", "NCR Delhi");
        }

    }

