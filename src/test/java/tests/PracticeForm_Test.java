package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm_Test {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulTest() {

        String name = "Angelina";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("[id=firstName]").setValue("Lina");
        $("[id=lastName]").setValue("Sokolova");
        $("[id=userEmail]").setValue("lina@sokol.ru");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("+79997774433");
        $("[id=dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--008:nth-child(3)").click();
        $("[id=subjectsInput]").setValue("Ecology");
        $(byText("Reading")).click();
        $("[id=uploadPicture]").uploadFile(new File("src/tests/resources/_DSC1044.JPG"));
        ;
        $("[id=currentAress]").setValue("current Address 12");
        $("[id=react-select-3-input]").click();

        $("[id=city]").click();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("lina@sokol.ru"),
                text("lina@sokol.ru"), text("Female"), text("+79997774433"), text("current Address 12"),
                text("08 June,1996"), text("Ecology"), text("Reading"),
                text("DSC1044.JPG"), text("current Address 12"), text("Haryana Karnal"));
    }

}
