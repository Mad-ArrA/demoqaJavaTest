package org.example.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 60000;  // Таймаут загрузки страницы 60 секунд
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form");

        $("[id=firstName]").setValue("Arkadiy");
        $("[id=lastName]").setValue("Khachmanukyan");
        $("[id=userEmail]").setValue("arrajgi@yandex.ru");
        // Клик по метке для выбора радиокнопки
        $("label[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("9271773301");

        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
        // Клик по метке для выбора чекбокса
        $("label[for='hobbies-checkbox-3']").click();
        $("[id=currentAddress]").setValue("Saransk");
        // Выбор предмета через автозаполнение
        $("#subjectsInput").setValue("Maths").pressEnter();
        // Загрузка файла
        File file = new File("src/test/resources/example.png");
        $("#uploadPicture").uploadFile(file);
        // Выбор из выпадающих списков
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("[id=submit]").click();

        // Проверка успешного заполнения формы
        $(".table").shouldHave(
                text("Arkadiy"),
                text("Khachmanukyan"),
                text("arrajgi@yandex.ru"),
                text("Male"),
                text("9271773301"),
                text("09 September,1998"),
                text("Maths"),
                text("Music"),
                text("example.png"),
                text("Saransk"),
                text("NCR Delhi")
        );
    }

}
