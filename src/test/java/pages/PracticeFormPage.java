package pages;

import pages.components.CalenderComponent;
import pages.components.ResultTableComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;


public class PracticeFormPage {

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#stateCity-wrapper"),
            citySelect = $("#stateCity-wrapper");

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value){
        $("#firstName").setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value){
        $("#lastName").setValue(value);

        return this;
    }

    public PracticeFormPage setUserEmail(String value){
        $("#userEmail").setValue(value);

        return this;
    }

    public PracticeFormPage setGenderRadio2(String value){
        $("#gender-radio-2").click();
        return this;
    }

    public PracticeFormPage setNumber(String value){
        $("[id=userNumber]").setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year){
        $("[id=dateOfBirthInput").click();
        calenderComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage chooseSubject(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    public PracticeFormPage chooseHobbies(String value) {
        hobbyCheckbox.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }


    public PracticeFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public PracticeFormPage chooseState(String value) {
        $("#state").click();
        stateSelect.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage chooseCity(String value) {
        $("#city").click();
        citySelect.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage pressSubmit() {
        $("#submit").click();
        return this;
    }

    public PracticeFormPage checkOpenedResultForm() {
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
            resultTableComponent.checkResult(key, value);
            return this;
    }

}
