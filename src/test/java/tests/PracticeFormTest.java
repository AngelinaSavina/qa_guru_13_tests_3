package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    @Test
    void successfulTest() {

        String name = "Angelina";

        String firstName = "Angelina";
        String lastName = "Sokolova";
        String userEmail = "lina@sokol.ru";
        String phoneNumber = "7999777443";
        String gender = "Female";
        String month = "June";
        String year = "1996";
        String day = "08";
        String fromSubject = "Economics";
        String hobby = "Reading";
        String currentAddress = "current address 12";
        String state = "Haryana";
        String city = "Karnal";
        String url = "_DSC1044.JPG";

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setDateOfBirth(day, month, year)
                .chooseSubject(fromSubject)
                .chooseHobbies(hobby)
                .uploadPicture(url)
                .setAddress(currentAddress)
                .chooseState(state)
                .chooseCity(city)
                .pressSubmit()
                .checkOpenedResultForm()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", fromSubject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "_DSC1044.JPG")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

}
