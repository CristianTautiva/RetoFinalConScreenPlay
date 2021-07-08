package com.demoqa.automation.models;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.Locale;

public class DataInjection {

    Faker faker = new Faker(new Locale("es-ES"));

    private String name, email, lastName, birthday, mobileNumber,currentAddress, subject, state,city,
             extensionName, extensionEmail, extensionCurrentAddress, extensionPermanentAddress, filepath, sheetName, picture;

    public String getName() {
        return name;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getExtensionEmail() {
        return extensionEmail;
    }

    public String getFilepath() {
        return filepath;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getExtensionCurrentAddress() {
        return extensionCurrentAddress;
    }

    public String getExtensionPermanentAddress() {
        return extensionPermanentAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public String getPicture(){
        //File file = new File(this.picture);
        //String path = file.getAbsolutePath();
        return this.picture;
    }
    public DataInjection(){
        this.name = faker.name().name();
        this.email = faker.internet().emailAddress();
        this.lastName = faker.name().lastName();
        this.birthday = faker.date().birthday().toString();
        this.state = "Rajasthan";
        this.city = "Jaipur";
        this.subject = "Maths";
        this.mobileNumber = Integer.toString(faker.number().numberBetween(1000000000,1999999999));
        this.currentAddress = faker.address().secondaryAddress();
        this.extensionName = "Name:";
        this.extensionEmail = "Email:";
        this.extensionCurrentAddress = "Current Address :";
        this.extensionPermanentAddress = "Permananet Address: ";
        this.filepath = "resources/DataInjection.xlsx";
        this.sheetName = "DataFromExcel";
        this.picture = "C:\\Users\\Dcris\\Pictures\\Camera Roll\\dcris.jpg";

    }


}
