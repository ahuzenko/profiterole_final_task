package com.ahuzenko.jbehave;

import net.serenitybdd.jbehave.SerenityStories;

public class AcceptanceTestSuite extends SerenityStories {

    public  AcceptanceTestSuite() {
        runSerenity().inASingleSession();
    }
}
