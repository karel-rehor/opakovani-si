package org.kagaka.automation.jbehave;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.embedder.StoryControls;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.URISyntaxException;

public class RunTestSuite extends SerenityStories {

    private static final String STORY_NAME_PATTERN = "**/@jbehave.story.name@.story";

    @Managed
    WebDriver driver;

    public RunTestSuite() {
        configuredEmbedder().embedderControls().doIgnoreFailureInStories(false);

        if (System.getProperty("doNotSkipScenariosAfterFailure") == null) {
            configuration().useStoryControls(
                    new StoryControls().doSkipScenariosAfterFailure(true).doResetStateBeforeScenario(false));
        }
        findStoriesCalled(storyNamesFromEnvironmentVariable());
    }

    private String storyNamesFromEnvironmentVariable() {
        String storyProperty = System.getProperty("story");
        if (storyProperty == null) {
            storyProperty = "*";
        } else {
            if (storyProperty.isEmpty()) {
                throw new RuntimeException("Please specify the story name or name pattern: e.g.: -Dstory=\"*_full\"");
            } else {
                storyProperty.trim();
            }
        }
        return STORY_NAME_PATTERN.replaceAll("@jbehave.story.name@", storyProperty);
    }

    @BeforeScenario
    public void setupProfile() throws IOException, URISyntaxException, InterruptedException {
        /*
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
        proxy.setHttpProxy("localhost:3128");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", "localhost");
        profile.setPreference("network.proxy.http_port", 3128);
        profile.setPreference("dom.max_script_run_time", 30000);
        profile.setAlwaysLoadNoFocusLib(true);
        profile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(profile);
    */
    }


}
