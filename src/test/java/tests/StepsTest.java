package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "Olgavas1006/qa_guru_36_allure";
    private static final int ISSUE = 1;

    @Test
    public void lambdaStepTest () {

       SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
    });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("В результатах поиска перейти по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открыть таб issues", () -> {
            $("#issues-tab").click();

        });

        step("Проверить наличие Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void annotatedStepTest () {

        SelenideLogger.addListener("allure", new AllureSelenide());
        StepAnnotationTest steps = new StepAnnotationTest();

        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.openRepositoryFromSearch(REPOSITORY);
        steps.openIssuesTab();
        steps.verifyIssueExists(ISSUE);

    }
}
