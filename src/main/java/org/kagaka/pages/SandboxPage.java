package org.kagaka.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SandboxPage extends PageObject {

    @FindBy(css = "form#testForm input[name = 'message']")
    private WebElementFacade editBox;

    @FindBy(css = "form#testForm a")
    private WebElementFacade submitLink;

    @FindBy(css = "table#targetTable")
    public WebElementFacade gridTable;

    public WebElementFacade getEditBox() {
        return editBox;
    }

    public WebElementFacade getSubmitLink() {
        return submitLink;
    }

    public WebElementFacade getGridTable() {
        return gridTable;
    }
}
