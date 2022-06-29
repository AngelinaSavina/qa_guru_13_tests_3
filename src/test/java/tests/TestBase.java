package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";

    }
}
