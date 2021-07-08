package com.demoqa.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class GetRegisterQuestion implements Question {

    private Target target;

    public GetRegisterQuestion(Target target){
        this.target = target;
    }


    @Override
    public Object answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().trim();
    }

    @Override
    public String getSubject() {
        return Question.super.getSubject();
    }

    public static GetRegisterQuestion in (Target target){
        return new GetRegisterQuestion(target);
    }
}
