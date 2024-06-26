package org.example.demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class SearchCodeRepository {
    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadTimeout = 60000;  // Таймаут загрузки страницы 60 секунд
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Firefox";

    }
    @Test
    public void searchCodeRepository() {
        open("https://github.com");
        $(".header-search-button").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        $("#wiki-tab").click();
        $(".f6").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        sleep(5000);
    }
}
