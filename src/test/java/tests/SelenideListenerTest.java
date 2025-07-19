package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideListenerTest {
    @Test
    public void IssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-button").click();
        $("#query-builder-test").setValue("Olgavas1006/qa_guru_36_allure").pressEnter();

        $(linkText("Olgavas1006/qa_guru_36_allure")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
