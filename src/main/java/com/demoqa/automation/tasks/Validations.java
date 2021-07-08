package com.demoqa.automation.tasks;

import com.demoqa.automation.models.DataInjection;
import com.demoqa.automation.questions.GetRegisterQuestion;
import com.demoqa.automation.ui.RegisterFormPage;
import com.demoqa.automation.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.io.IOException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class Validations implements Task {
    DataInjection dataInjection = new DataInjection();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.should(
                    seeThat(GetRegisterQuestion.in(RegisterFormPage.VALIDATION_MESSAGE_SUBMITTING_FORM), equalToIgnoringCase(Excel.getCellValue(dataInjection.getFilepath(), dataInjection.getSheetName(), 0, 9)))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Validations compareText(){
        return instrumented(Validations.class);
    }
}
