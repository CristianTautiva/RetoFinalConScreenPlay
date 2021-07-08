package com.demoqa.automation.tasks;

import com.demoqa.automation.ui.RegisterFormPage;
import com.demoqa.automation.utils.Excel;
import com.demoqa.automation.utils.SpecialMethods;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAllFieldsWithProperties implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        SpecialMethods.configProperties();
        actor.attemptsTo(
                Enter.keyValues(SpecialMethods.properties.getProperty("firstName")).into(RegisterFormPage.FIRST_NAME_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("lastName")).into(RegisterFormPage.LAST_NAME_INPUT),
                Enter.keyValues(SpecialMethods.properties.getProperty("email")).into(RegisterFormPage.EMAIL_INPUT),
                JavaScriptClick.on(RegisterFormPage.GENDER_RADIO_BUTTON),
                Enter.theValue(SpecialMethods.properties.getProperty("mobileNumber")).into(RegisterFormPage.PHONE_NUMBER_INPUT),
                JavaScriptClick.on(RegisterFormPage.DATE_BIRTH_SELECT),
                WaitUntil.the(RegisterFormPage.MONTH_SELECT, isVisible()),
                JavaScriptClick.on(RegisterFormPage.MONTH_SELECT),
                JavaScriptClick.on(RegisterFormPage.MONTH_OPTION),
                WaitUntil.the(RegisterFormPage.YEAR_SELECT, isVisible()),
                JavaScriptClick.on(RegisterFormPage.YEAR_SELECT),
                JavaScriptClick.on(RegisterFormPage.YEAR_OPTION),
                JavaScriptClick.on(RegisterFormPage.DAY_OPTION),
                WaitUntil.the(RegisterFormPage.SUBJECT_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.keyValues(SpecialMethods.properties.getProperty("subject")).into(RegisterFormPage.SUBJECT_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.SUBJECT_INPUT),
                Scroll.to(RegisterFormPage.UPLOAD_SELECT),
                JavaScriptClick.on(RegisterFormPage.HOBBIES_CHECKBOX),
                Enter.keyValues(SpecialMethods.properties.getProperty("picture")).into(RegisterFormPage.UPLOAD_SELECT),
                Enter.theValue(SpecialMethods.properties.getProperty("currentAddress")).into(RegisterFormPage.CURRENT_ADDRESS_INPUT),
                JavaScriptClick.on(RegisterFormPage.STATE_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("state")).into(RegisterFormPage.STATE_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.STATE_INPUT),
                JavaScriptClick.on(RegisterFormPage.CITY_INPUT),
                Enter.theValue(SpecialMethods.properties.getProperty("city")).into(RegisterFormPage.CITY_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.CITY_INPUT),
                JavaScriptClick.on(RegisterFormPage.SUBMIT_BUTTON)

        );
    }

    public static FillAllFieldsWithProperties dataInjectionProperties(){
        return instrumented(FillAllFieldsWithProperties.class);
    }
}
