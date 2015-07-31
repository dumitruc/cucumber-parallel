package com.dumitruc.training.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dumitruc on 13/12/2014.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@RIGHT"},
        features = ".",
        glue = "com.dumitruc.training.stepdefs")
public class RightHandRunnerTest {
}
