package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends BaseTest {

    private final String REPOSITORY = "qa-guru/qa_guru_14_10";
    private final String ISSUE = "Issue for Autotest";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {

            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY);
            $("#query-builder-test").submit();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issue с названием " + ISSUE, () -> {
            $(withText(ISSUE)).should(exist);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Работа с Issue")
    @Owner("nmalygin")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск Issue по названию")
    public void testAnnotatedStep() throws InterruptedException {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepo(REPOSITORY);
        steps.takeScreenshot();
        steps.clickOnRepoLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithText(ISSUE);
    }
}
