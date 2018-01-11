package org.kagaka.automation.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

import org.jbehave.core.annotations.When;

import java.util.Random;

public class FubarStepDefinitions {

    @Steps
    private FubarSteps fubarSteps;

    @Given("the sandbox is loaded")
    public void sanbdoxLoaded(){

         System.out.println("DEBUG - called step definition");
         fubarSteps.openMainPage();
         //fubarSteps.enterText("Vitejte vas zpet do sveta sereniteho a selenia");

    }

    @When("I add a string to the edit box")
    public void addStringToEditField(){

        fubarSteps.enterText("Vitam vas zpet do sveta sereniteho a selenia");

    }

    @When("submit the text")
    public void submitTheText(){

        fubarSteps.submitText();
    }

    @When("click the top right tile")
    public void clickTopRightTile(){

        Random rand = new Random();

        fubarSteps.clickGridCell(rand.nextInt(3), rand.nextInt(3));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
