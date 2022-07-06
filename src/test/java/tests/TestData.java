package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    private Locale ruLocale = new Locale("ru");
    private Locale enLocale = new Locale("en");
    private Faker fakerRussian = new Faker(ruLocale);
    private Faker fakerEnglish = new Faker(enLocale);

    String firstName = fakerRussian.address().firstName();
    String lastName = fakerRussian.address().lastName();
    String userEmail = fakerEnglish.internet().emailAddress();
    String phoneNumber = String.valueOf(fakerRussian.number().randomNumber(10, true));
    String gender = GetTestJava.getGenderFromSite();
    String year = String.valueOf(fakerEnglish.number().numberBetween(1900, 2022));
    String hobby = GetTestJava.getHobbyFromSite();
    String currentAddress = fakerRussian.address().fullAddress();
    String month = "June";
    //String day = String.valueOf(fakerEnglish.number().numberBetween(01, 28));
    String day = "05";
    String fromSubject = "Economics";
    String state = "Haryana";
    String city = "Karnal";
    String url = "_DSC1044.JPG";
}
