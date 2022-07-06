
package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTestWithFakers extends TestBase {

    TestData testData = new TestData();

    @Test
    void successfulTest() {


        practiceFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setNumber(testData.phoneNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .chooseSubject(testData.fromSubject)
                .chooseHobbies(testData.hobby)
                .uploadPicture(testData.url)
                .setAddress(testData.currentAddress)
                .chooseState(testData.state)
                .chooseCity(testData.city)
                .pressSubmit()
                .checkOpenedResultForm()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.fromSubject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.url)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

}
