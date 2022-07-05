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
            gender = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckbox = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateSelect = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            citySelect = $("#stateCity-wrapper"),
            resultModalWindow = $("#example-modal-sizes-title-lg"),
            submitButton = $("#submit");



    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value){
        gender.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year){
        birthDayInput.click();
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
        stateInput.click();
        stateSelect.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage chooseCity(String value) {
        cityInput.click();
        citySelect.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage pressSubmit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkOpenedResultForm() {
        resultModalWindow.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
            resultTableComponent.checkResult(key, value);
            return this;
    }

}
