package com.demoqa.test.stepdefinitions;

import com.demoqa.automation.interactions.OpenTheBrowser;
import com.demoqa.automation.tasks.FillAllFieldsWithExcel;
import com.demoqa.automation.tasks.FillAllFieldsWithFaker;
import com.demoqa.automation.tasks.FillAllFieldsWithProperties;
import com.demoqa.automation.tasks.Validations;
import com.demoqa.automation.ui.RegisterFormPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegisterFormStepDefinitions {

    @Managed
    public static WebDriver driver;

    @Before
    public void actorSetUp(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cristian").can(BrowseTheWeb.with(driver));
    }

    @Given("^that a web user wants to register in demoqa$")
    public void thatAWebUserWantsToRegisterInDemoqa() {
        theActorInTheSpotlight().attemptsTo(OpenTheBrowser.on(RegisterFormPage.URL));
    }


    @When("^he fills all the requested fields in text box register section with excel$")
    public void heFillsAllTheRequestedFieldsInTextBoxRegisterSectionWithExcel() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithExcel.dataInjectionSheet());
    }

    @Then("^he should see it a message succesful using excel\\.$")
    public void heShouldSeeItAMessageSuccesfulUsingExcel() {
       theActorInTheSpotlight().attemptsTo(Validations.compareText());
       Serenity.takeScreenshot();
    }

    //Scenarios de inyeccion de datos con faker

    @When("^he fills all the requested fields in text box register section with faker$")
    public void heFillsAllTheRequestedFieldsInTextBoxRegisterSectionWithFaker() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithFaker.dataInjectionFaker());
    }

    @Then("^he should see it a message succesful using faker\\.$")
    public void heShouldSeeItAMessageSuccesfulUsingFaker() {
        theActorInTheSpotlight().attemptsTo(Validations.compareText());
        Serenity.takeScreenshot();
    }

    //Scenarios de inyeccion de datos con conf.properties

    @When("^he fills all the requested fields in text box register section with properties$")
    public void heFillsAllTheRequestedFieldsInTextBoxRegisterSectionWithProperties() {
        theActorInTheSpotlight().attemptsTo(FillAllFieldsWithProperties.dataInjectionProperties());
    }

    @Then("^he should see it a message succesful using properties\\.$")
    public void heShouldSeeItAMessageSuccesfulUsingProperties() {
        theActorInTheSpotlight().attemptsTo(Validations.compareText());
        Serenity.takeScreenshot();
    }

}
