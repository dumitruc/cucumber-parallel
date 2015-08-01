package com.dumitruc.training.stepdefs;

import com.sun.org.apache.xpath.internal.operations.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.String;
import java.lang.management.ManagementFactory;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by dima on 30/07/2015.
 */
public class FingerGameStepDef extends StepDefBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(FingerGameStepDef.class);
    private int FINGERS_ON_ONE_HAND = 5;

    @Given("^I hold my hand in a fist$")
    public void i_hold_my_hand_in_a_fist() throws Throwable {
        cache.setFingersInFist(FINGERS_ON_ONE_HAND);
    }

    @When("^I show (\\d+) finger on my (\\S+) hand$")
    public void i_show_finger_on_my_left_hand(int arg1, String whichHand) throws Throwable {
        int fingersInFist = cache.getFingersInFist();
        try{
            int sleepTime = (int)(Math.random()*1000);
            String jvmId = ManagementFactory.getRuntimeMXBean().getName();
            LOGGER.info(String.format("Sleep time: %s for %s hand on thread: %s on JVM: %s",sleepTime,whichHand,Thread.currentThread().getId(),jvmId));
            Thread.sleep(sleepTime);
            cache.setFingersInFist(fingersInFist - arg1);
        }catch (Exception e){
            System.out.println(e);
        }
        LOGGER.info(String.format("Showing %s fingers on my %s hand, %s in my fist",arg1,whichHand,cache.getFingersInFist()));
    }

    @Then("^I have (\\d+) bent in my fist in my (\\S+) hand$")
    public void i_have_bent_in_my_fist_in_my_left_hand(int arg1, String whichHand) throws Throwable {
        LOGGER.info(String.format("I have hand:%s\texp:%s\tact:%s", whichHand, arg1, cache.getFingersInFist()));
        assertEquals("Incorrect number of fingers left bent", arg1, cache.getFingersInFist());
    }

}
