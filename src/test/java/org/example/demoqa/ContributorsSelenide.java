package org.example.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class ContributorsSelenide {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 60000;  // Таймаут загрузки страницы 60 секунд
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Firefox";

    }
    @Test
    public void contributors() {
        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors")).closest("h2").sibling(0).$$("li").first().hover();
        $(".Popover").shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
