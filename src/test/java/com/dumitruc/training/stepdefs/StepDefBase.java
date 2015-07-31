package com.dumitruc.training.stepdefs;

import com.dumitruc.training.CucumberCache;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class StepDefBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefBase.class);

    @Autowired
    CucumberCache cache;


}
