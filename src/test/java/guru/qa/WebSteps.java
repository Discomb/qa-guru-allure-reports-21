package guru.qa;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open(baseUrl);
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepo(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepoLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с названием {issueText}")
    public void shouldSeeIssueWithText(String issueText) {
        $(withText(issueText)).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() throws InterruptedException {
        Thread.sleep(2500);
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
