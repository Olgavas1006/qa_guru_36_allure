package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepAnnotationTest {

    @Step ("Открыть главную страницу")
    public void openMainPage () {
        open("https://github.com");
    }

    @Step ("Поиск репозитория {repo}")
    public void searchRepository (String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).pressEnter();

    }

    @Step ("В результатах поиска перейти по ссылке репозитория {repo}")
    public void openRepositoryFromSearch (String repo) {
        $(linkText(repo)).click();

    }

    @Step ("Открыть таб issues")
    public void openIssuesTab () {
        $("#issues-tab").click();

    }

    @Step ("Проверить наличие Issue с номером {issue}")
    public void verifyIssueExists (int issue) {
        $(withText("#" + issue)).should(Condition.exist);

    }
}
