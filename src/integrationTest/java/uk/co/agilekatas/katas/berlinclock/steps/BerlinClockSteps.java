package uk.co.agilekatas.katas.berlinclock.steps;

import uk.co.agilekatas.katas.berlinclock.BerlinClock;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

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

  @Then("^([^\"]*) is returned for the five minutes row$")
  public void row_is_returned_for_the_five_minutes_row(String row) {
    assertThat(berlinTime.substring(9, 20)).isEqualTo(row);
  }

  @Then("^^([^\"]*) is returned for the single hours row$")
  public void _row_is_returned_for_the_single_hours_row(String row) {
    assertThat(berlinTime.substring(5, 9)).isEqualTo(row);
  }

  @Then("^^([^\"]*) is returned for the five hours row$")
  public void _row_is_returned_for_the_five_hours_row(String row) {
    assertThat(berlinTime.substring(1, 5)).isEqualTo(row);
  }

  @Then("^^([^\"]*) is returned for the seconds lamp$")
  public void lamp_is_returned_for_the_seconds_lamp(String lamp) {
    assertThat(berlinTime.substring(0, 1)).isEqualTo(lamp);
  }

  @Then("^^([^\"]*) is returned$")
  public void clock_is_returned(String clock) {
    assertThat(berlinTime).isEqualTo(clock);
  }
}
