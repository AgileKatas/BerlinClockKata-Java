package uk.co.agilekatas.katas.berlinclock;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Enclosed.class)
public class BerlinClockTest {

  public static class SingleMinutesRow {

    private static final int SINGLE_ROW_START = 20;
    private static final int SINGLE_ROW_END = 24;

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void showsNoLampsForMinutesEndingInZeroMinutesOrFiveMinutes() {
      List<String> noLampExamples = Arrays.asList("00:00:00", "00:05:00", "00:10:00", "00:15:00");

      for (String example : noLampExamples) {
        String singleMinutes = getSingleMinutesRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("OOOO");
      }
    }

    @Test
    public void showsOneLampForMinutesEndingInOneMinuteOrSixMinutes() {
      List<String> oneLampExamples = Arrays.asList("00:01:00", "00:06:00", "00:11:00", "00:16:00");

      for (String example : oneLampExamples) {
        String singleMinutes = getSingleMinutesRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YOOO");
      }
    }

    @Test
    public void showsTwoLampsForMinutesEndingInTwoMinutesOrSevenMinutes() {
      List<String> twoLampExamples = Arrays.asList("00:02:00", "00:07:00", "00:12:00", "00:17:00");

      for (String example : twoLampExamples) {
        String singleMinutes = getSingleMinutesRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYOO");
      }
    }

    @Test
    public void showsThreeLampsForMinutesEndingInThreeMinutesOrEightMinutes() {
      List<String> threeLampExamples = Arrays.asList("00:03:00", "00:08:00", "00:13:00", "00:18:00");

      for (String example : threeLampExamples) {
        String singleMinutes = getSingleMinutesRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYYO");
      }
    }

    @Test
    public void showsFourLampsForMinutesEndingInFourMinutesOrNineMinutes() {
      List<String> fourLampExamples = Arrays.asList("00:04:00", "00:09:00", "00:14:00", "00:19:00");

      for (String example : fourLampExamples) {
        String singleMinutes = getSingleMinutesRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYYY");
      }
    }

    private String getSingleMinutesRow(String time) {
      return time.substring(SINGLE_ROW_START, SINGLE_ROW_END);
    }

  }

}