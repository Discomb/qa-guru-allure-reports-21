package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class SelenideTest {

    @BeforeAll
    public static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1980x1020";
    }

    @Test
    public void testIssueSearch() {

        open("https://github.com");

        $(".search-input").click();
        $("#query-builder-test").setValue("qa_guru_14_10");
        $("#query-builder-test").submit();
        $(linkText("qa-guru/qa_guru_14_10")).click();
        $("#issues-tab").click();

        $(withText("#2")).should(exist);
    }
}
