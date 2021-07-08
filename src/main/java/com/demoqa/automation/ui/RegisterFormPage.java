package com.demoqa.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterFormPage {

    public static String URL = "https://www.demoqa.com/automation-practice-form";
    public static final Target FIRST_NAME_INPUT = Target.the("").located(By.id("firstName"));
    public static final Target LAST_NAME_INPUT = Target.the("").located(By.id("lastName"));
    public static final Target EMAIL_INPUT = Target.the("").located(By.id("userEmail"));
    public static final Target GENDER_RADIO_BUTTON = Target.the("").locatedBy("//label[@for='gender-radio-1']");
    public static final Target PHONE_NUMBER_INPUT = Target.the("").located(By.id("userNumber"));
    public static final Target DATE_BIRTH_SELECT = Target.the("").located(By.id("dateOfBirthInput"));
    public static final Target MONTH_SELECT = Target.the("").locatedBy("//select[@class='react-datepicker__month-select']");
    public static final Target MONTH_OPTION = Target.the("").locatedBy("//*[@value='8' and text()='September']");
    public static final Target YEAR_SELECT = Target.the("").locatedBy("//*[@class='react-datepicker__year-select']");
    public static final Target YEAR_OPTION = Target.the("").locatedBy("//*[@value='1996' and text()='1996']");
    public static final Target DAY_OPTION = Target.the("").locatedBy("//*[@class='react-datepicker__day react-datepicker__day--013' and text()='13']");
    public static final Target SUBJECT_INPUT = Target.the("").locatedBy("//input[@id='subjectsInput']");
    public static final Target HOBBIES_CHECKBOX = Target.the("").locatedBy("//label[@for='hobbies-checkbox-1']");
    public static final Target UPLOAD_SELECT = Target.the("").located(By.id("uploadPicture"));
    public static final Target CURRENT_ADDRESS_INPUT = Target.the("").located(By.id("currentAddress"));
    public static final Target STATE_INPUT = Target.the("").locatedBy("//*[@id='react-select-3-input' and @type='text']");
    public static final Target CITY_INPUT = Target.the("").locatedBy("//*[@id='react-select-4-input' and @type='text']");
    public static final Target SUBMIT_BUTTON = Target.the("").located(By.id("submit"));
    public static final Target VALIDATION_MESSAGE_SUBMITTING_FORM = Target.the("").locatedBy("//*[@id='example-modal-sizes-title-lg' and text()='Thanks for submitting the form']");
    public static final Target CLOSE_BUTTON = Target.the("").locatedBy("//*[@id='closeLargeModal' and @type='button']");

}
