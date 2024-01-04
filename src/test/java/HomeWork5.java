import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork5 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
      //  Configuration.holdBrowserOpen = true;
      //  Configuration.timeout = 5000; // default 4000
    }

    @Test
    void firstTest() {
        open("selenide/selenide");  //Откройте страницу Selenide в Github
        $(By.id("wiki-tab")).click();  //Перейдите в раздел Wiki проекта
        $(byText("Soft assertions")).shouldBe(visible).click();//Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(By.id("repo-content-turbo-frame")).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}")).shouldBe(visible);//Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    }
}

