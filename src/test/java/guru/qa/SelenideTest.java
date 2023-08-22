package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends BaseTest {

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(baseUrl);

        $(".search-input").click();
        $("#query-builder-test").setValue("qa_guru_14_10");
        $("#query-builder-test").submit();
        $(linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();

        $(withText("Issue for Autotest")).should(exist);
    }
}
