package org.example.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 60000;  // Таймаут загрузки страницы 60 секунд
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest(){
        open("/text-box");

        $("[id=userName]").setValue("Arkadiy");
        $("[id=userEmail]").setValue("arrajgi@yandex.ru");
        $("[id=currentAddress]").setValue("englishblyat");
        $("[id=permanentAddress]").setValue("yeha");

        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Arkadiy"), text("arrajgi@yandex.ru"),
                text("englishblyat"), text("yeha"));
    }
}
