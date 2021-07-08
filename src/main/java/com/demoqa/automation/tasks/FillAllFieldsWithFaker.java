package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.RegisterFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAllFieldsWithFaker implements Task {
    private DataInjection dataInjection = new DataInjection();
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(dataInjection.getName()).into(RegisterFormPage.FIRST_NAME_INPUT),
                Enter.keyValues(dataInjection.getLastName()).into(RegisterFormPage.LAST_NAME_INPUT),
                Enter.keyValues(dataInjection.getEmail()).into(RegisterFormPage.EMAIL_INPUT),
                JavaScriptClick.on(RegisterFormPage.GENDER_RADIO_BUTTON),
                Enter.keyValues(dataInjection.getMobileNumber()).into(RegisterFormPage.PHONE_NUMBER_INPUT),
                JavaScriptClick.on(RegisterFormPage.DATE_BIRTH_SELECT),
                WaitUntil.the(RegisterFormPage.MONTH_SELECT, isVisible()),
                JavaScriptClick.on(RegisterFormPage.MONTH_SELECT),
                JavaScriptClick.on(RegisterFormPage.MONTH_OPTION),
                JavaScriptClick.on(RegisterFormPage.YEAR_SELECT),
                JavaScriptClick.on(RegisterFormPage.YEAR_OPTION),
                JavaScriptClick.on(RegisterFormPage.DAY_OPTION),
                Enter.keyValues(dataInjection.getSubject()).into(RegisterFormPage.SUBJECT_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.SUBJECT_INPUT),
                Scroll.to(RegisterFormPage.UPLOAD_SELECT),
                JavaScriptClick.on(RegisterFormPage.HOBBIES_CHECKBOX),
                Enter.keyValues(dataInjection.getPicture()).into(RegisterFormPage.UPLOAD_SELECT),
                Enter.keyValues(dataInjection.getCurrentAddress()).into(RegisterFormPage.CURRENT_ADDRESS_INPUT),
                JavaScriptClick.on(RegisterFormPage.STATE_INPUT),
                Enter.keyValues(dataInjection.getState()).into(RegisterFormPage.STATE_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.STATE_INPUT),
                JavaScriptClick.on(RegisterFormPage.CITY_INPUT),
                Enter.keyValues(dataInjection.getCity()).into(RegisterFormPage.CITY_INPUT),
                Enter.keyValues(Keys.ENTER).into(RegisterFormPage.CITY_INPUT),
                JavaScriptClick.on(RegisterFormPage.SUBMIT_BUTTON)
        );
    }

    public static FillAllFieldsWithFaker dataInjectionFaker(){
        return instrumented(FillAllFieldsWithFaker.class);
    }
}
