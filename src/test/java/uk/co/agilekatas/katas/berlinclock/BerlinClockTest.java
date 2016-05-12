package uk.co.agilekatas.katas.berlinclock;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class BerlinClockTest {

  public static class SingleMinutes {

    private static final int SINGLE_ROW_START = 20;
    private static final int SINGLE_ROW_END = 24;

    @Test
    public void minutesEndingInZeroHaveNoLights() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:00:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("OOOO");
    }

    @Test
    public void minutesEndingInOneHaveOneLight() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:01:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("YOOO");
    }

    @Test
    public void minutesEndingInTwoHaveTwoLights() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:02:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("YYOO");
    }

    @Test
    public void minutesEndingInThreeHaveThreeLights() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:03:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("YYYO");
    }

    @Test
    public void minutesEndingInFourHaveFourLights() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:04:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("YYYY");
    }

    @Test
    public void minutesEndingInFiveHaveZeroLights() {
      BerlinClock clock = new BerlinClock();

      String singleMinutes = clock.convert("12:05:00").substring(SINGLE_ROW_START, SINGLE_ROW_END);

      assertThat(singleMinutes).isEqualTo("OOOO");
    }

  }

}