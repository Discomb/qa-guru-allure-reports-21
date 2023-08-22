package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1980x1020";
        Configuration.baseUrl = "https://github.com";
    }
}
