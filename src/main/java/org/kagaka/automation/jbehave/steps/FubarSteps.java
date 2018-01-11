package org.kagaka.automation.jbehave.steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.kagaka.pages.SandboxPage;

import java.net.MalformedURLException;
import java.net.URL;

public class FubarSteps extends ScenarioSteps {

    private SandboxPage page;

    @Step
    public void openMainPage(){

            try {
                URL defaultBaseUrl = new URL(pages().getDefaultBaseUrl());
                if (defaultBaseUrl.getUserInfo() != null) {
                    //URL does contain user info, open two times - first only via driver, to not get TripMarketMainPage WhenPageOpens check
                    getDriver().get(pages().getDefaultBaseUrl());
                    String resultingUrlWithoutUserInfo = defaultBaseUrl.getProtocol() + "://" + defaultBaseUrl.getHost() +
                            (defaultBaseUrl.getPort() == -1 ? "" : ":" + defaultBaseUrl.getPort());
                    page.openAt(resultingUrlWithoutUserInfo);
                } else {
                    //URL does not contain user info, open just once and using TripMarketMainPage
                    page.openAt(pages().getDefaultBaseUrl());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //something failed, try to open the base url the "normal" way
                page.openAt(pages().getDefaultBaseUrl());
            }
//        getDriver().manage().window().maximize();

    }

    @Step
    public void submitText(){

        page.getSubmitLink().click();

    }

    @Step
    public void enterText(String message){

        page.getEditBox().clear();
        page.getEditBox().type(message);

    }

    @Step
    public void clickGridCell(int x, int y){

        page.getGridTable().findElement(By.cssSelector("td#c" + x + "x" + y)).click();

    }
}
