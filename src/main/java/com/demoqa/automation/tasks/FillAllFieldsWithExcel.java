package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.ui.RegisterFormPage;
import com.demoqa.automation.utils.Excel;
import com.demoqa.automation.utils.Javascript;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillAllFieldsWithExcel implements Task {
    private DataInjection dataInjection = new DataInjection();
    @Override
    public <T extends Actor> void performAs(T actor) {
           try{
               actor.attemptsTo(
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,0)).into(RegisterFormPage.FIRST_NAME_INPUT),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,1)).into(RegisterFormPage.LAST_NAME_INPUT),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,2)).into(RegisterFormPage.EMAIL_INPUT),
                       JavaScriptClick.on(RegisterFormPage.GENDER_RADIO_BUTTON),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,3)).into(RegisterFormPage.PHONE_NUMBER_INPUT),
                       JavaScriptClick.on(RegisterFormPage.DATE_BIRTH_SELECT),
                       WaitUntil.the(RegisterFormPage.MONTH_SELECT, isVisible()),
                       JavaScriptClick.on(RegisterFormPage.MONTH_SELECT),
                       JavaScriptClick.on(RegisterFormPage.MONTH_OPTION),
                       WaitUntil.the(RegisterFormPage.YEAR_SELECT, isVisible()),
                       JavaScriptClick.on(RegisterFormPage.YEAR_SELECT),
                       JavaScriptClick.on(RegisterFormPage.YEAR_OPTION),
                       JavaScriptClick.on(RegisterFormPage.DAY_OPTION),
                       WaitUntil.the(RegisterFormPage.SUBJECT_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                       Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,4)).into(RegisterFormPage.SUBJECT_INPUT),
                       Enter.keyValues(Keys.ENTER).into(RegisterFormPage.SUBJECT_INPUT),
                       Scroll.to(RegisterFormPage.UPLOAD_SELECT),
                       JavaScriptClick.on(RegisterFormPage.HOBBIES_CHECKBOX),
                       Enter.keyValues(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,5)).into(RegisterFormPage.UPLOAD_SELECT),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,6)).into(RegisterFormPage.CURRENT_ADDRESS_INPUT),
                       JavaScriptClick.on(RegisterFormPage.STATE_INPUT),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,7)).into(RegisterFormPage.STATE_INPUT),
                       Enter.keyValues(Keys.ENTER).into(RegisterFormPage.STATE_INPUT),
                       JavaScriptClick.on(RegisterFormPage.CITY_INPUT),
                       Enter.theValue(Excel.getCellValue(dataInjection.getFilepath(),dataInjection.getSheetName(),0,8)).into(RegisterFormPage.CITY_INPUT),
                       Enter.keyValues(Keys.ENTER).into(RegisterFormPage.CITY_INPUT),
                       JavaScriptClick.on(RegisterFormPage.SUBMIT_BUTTON)

               );
           }catch(IOException  e){
               e.printStackTrace();
           }
    }

    public static FillAllFieldsWithExcel dataInjectionSheet(){
        return instrumented(FillAllFieldsWithExcel.class);
    }
}
