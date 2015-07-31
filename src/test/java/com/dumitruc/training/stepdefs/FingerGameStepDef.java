package com.dumitruc.training.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by dima on 30/07/2015.
 */
public class FingerGameStepDef extends StepDefBase {

    private int FINGERS_ON_ONE_HAND = 5;

    @Given("^I hold my hand in a fist$")
    public void i_hold_my_hand_in_a_fist() throws Throwable {
        cache.setFingersInFist(FINGERS_ON_ONE_HAND);
    }

    @When("^I show (\\d+) finger on my (\\S+) hand$")
    public void i_show_finger_on_my_left_hand(int arg1, String whichHand) throws Throwable {
        int fingersInFist = cache.getFingersInFist();
        try{
            int sleepTime = (int)(Math.random()*100);
            System.out.printf("Sleep time: %s for %s hand on thread: %s\n",sleepTime,whichHand,Thread.currentThread().getId());
            Thread.sleep(sleepTime);
            cache.setFingersInFist(fingersInFist - arg1);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.printf("Showing %s fingers on my %s hand, %s in my fist\n",arg1,whichHand,cache.getFingersInFist());
    }

    @Then("^I have (\\d+) bent in my fist in my (\\S+) hand$")
    public void i_have_bent_in_my_fist_in_my_left_hand(int arg1, String whichHand) throws Throwable {
        System.out.printf("I have %s fingers left in my %s hand fist\n",arg1,whichHand);
        assertEquals("Incorrect number of fingers left bent", arg1, cache.getFingersInFist());
    }

}
