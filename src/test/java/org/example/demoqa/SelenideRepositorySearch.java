package org.example.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 60000;  // Таймаут загрузки страницы 60 секунд
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Firefox";

    }
    @Test
    void shoulFindSelenideRepositoryAtTheTop() {
        open("https://github.com");
        $(".header-search-button").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(5000);
    }
}
