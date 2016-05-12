package uk.co.agilekatas.katas.berlinclock.steps;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.agilekatas.katas.berlinclock.BerlinClock;

public class BerlinClockSteps {

  private BerlinClock clock;

  private String berlinTime;

  @Given("^I have started the converter$")
  public void I_have_started_the_converter() {
    clock = new BerlinClock();
  }

  @When("^I enter ([^\"]*)$")
  public void I_enter_time(String time) {
    this.berlinTime = clock.convert(time);
  }

  @Then("^([^\"]*) is returned for the single minutes row$")
  public void row_is_returned_for_the_single_minutes_row(String row) {
    assertThat(berlinTime.substring(20, 24)).isEqualTo(row);
  }

}
