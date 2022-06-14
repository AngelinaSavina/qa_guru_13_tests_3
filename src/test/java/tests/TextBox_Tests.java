package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBox_Tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl="https://demoqa.com";
        //Configuration.browserSize = "1366x768";
        //Configuration.browserPosition = "00x00";
        //Configuration.=;
    }


    @Test
    void successfulTest() {

        String name = "Angelina";

        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");


        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("angelinaa@mail.com");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Some address 2");

        $ ("[id=submit]").doubleClick();

        $("[id=output]").shouldHave(text(name), text("angelinaa@mail.com"), text("Some address 1"), text("Some address 2"));

    }


}
