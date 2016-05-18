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

    private static final int ROW_START = 20;
    private static final int ROW_END = 24;

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void showsNoLampsForMinutesEndingInZeroMinutesOrFiveMinutes() {
      List<String> noLampExamples = Arrays.asList("00:00:00", "00:05:00", "00:10:00", "00:15:00");

      for (String example : noLampExamples) {
        String singleMinutes = getRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("OOOO");
      }
    }

    @Test
    public void showsOneLampForMinutesEndingInOneMinuteOrSixMinutes() {
      List<String> oneLampExamples = Arrays.asList("00:01:00", "00:06:00", "00:11:00", "00:16:00");

      for (String example : oneLampExamples) {
        String singleMinutes = getRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YOOO");
      }
    }

    @Test
    public void showsTwoLampsForMinutesEndingInTwoMinutesOrSevenMinutes() {
      List<String> twoLampExamples = Arrays.asList("00:02:00", "00:07:00", "00:12:00", "00:17:00");

      for (String example : twoLampExamples) {
        String singleMinutes = getRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYOO");
      }
    }

    @Test
    public void showsThreeLampsForMinutesEndingInThreeMinutesOrEightMinutes() {
      List<String> threeLampExamples = Arrays.asList("00:03:00", "00:08:00", "00:13:00", "00:18:00");

      for (String example : threeLampExamples) {
        String singleMinutes = getRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYYO");
      }
    }

    @Test
    public void showsFourLampsForMinutesEndingInFourMinutesOrNineMinutes() {
      List<String> fourLampExamples = Arrays.asList("00:04:00", "00:09:00", "00:14:00", "00:19:00");

      for (String example : fourLampExamples) {
        String singleMinutes = getRow(clock.convert(example));
        assertThat(singleMinutes).isEqualTo("YYYY");
      }
    }

    private String getRow(String time) {
      return time.substring(ROW_START, ROW_END);
    }

  }

  public static class FiveMinutesRow {

    private static final int ROW_START = 9;
    private static final int ROW_END = 20;

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void showsNoLampsForMinutesBetweenZeroAndFive() {
      List<String> noLampExamples = Arrays.asList("00:00:00", "00:01:00", "00:02:00", "00:03:00", "00:04:00");

      for (String example : noLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("OOOOOOOOOOO");
      }
    }

    @Test
    public void showsOneLampForMinutesBetweenFiveAndTen() {
      List<String> oneLampExamples = Arrays.asList("00:05:00", "00:06:00", "00:07:00", "00:08:00", "00:09:00");

      for (String example : oneLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YOOOOOOOOOO");
      }
    }

    @Test
    public void showsTwoLampsForMinutesBetweenTenAndFifteen() {
      List<String> twoLampExamples = Arrays.asList("00:10:00", "00:11:00", "00:12:00", "00:13:00", "00:14:00");

      for (String example : twoLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYOOOOOOOOO");
      }
    }

    @Test
    public void showsThreeLampsForMinutesBetweenFifteenAndTwenty() {
      List<String> threeLampExamples = Arrays.asList("00:15:00", "00:16:00", "00:17:00", "00:18:00", "00:19:00");

      for (String example : threeLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYROOOOOOOO");
      }
    }

    @Test
    public void showsFourLampsForMinutesBetweenTwentyAndTwentyFive() {
      List<String> fourLampExamples = Arrays.asList("00:20:00", "00:21:00", "00:22:00", "00:23:00", "00:24:00");

      for (String example : fourLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYOOOOOOO");
      }
    }

    @Test
    public void showsFiveLampsForMinutesBetweenTwentyFiveAndThirty() {
      List<String> fiveLampExamples = Arrays.asList("00:25:00", "00:26:00", "00:27:00", "00:28:00", "00:29:00");

      for (String example : fiveLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYOOOOOO");
      }
    }

    @Test
    public void showsSixLampsForMinutesBetweenThirtyAndThirtyFive() {
      List<String> sixLampExamples = Arrays.asList("00:30:00", "00:31:00", "00:32:00", "00:33:00", "00:34:00");

      for (String example : sixLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYROOOOO");
      }
    }

    @Test
    public void showsSevenLampsForMinutesBetweenThirtyFiveAndForty() {
      List<String> sevenLampExamples = Arrays.asList("00:35:00", "00:36:00", "00:37:00", "00:38:00", "00:39:00");

      for (String example : sevenLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYRYOOOO");
      }
    }

    @Test
    public void showsEightLampsForMinutesBetweenFortyAndFortyFive() {
      List<String> eightLampExamples = Arrays.asList("00:40:00", "00:41:00", "00:42:00", "00:43:00", "00:44:00");

      for (String example : eightLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYRYYOOO");
      }
    }

    @Test
    public void showsNineLampsForMinutesBetweenFortyFiveAndFifty() {
      List<String> nineLampExamples = Arrays.asList("00:45:00", "00:46:00", "00:47:00", "00:48:00", "00:49:00");

      for (String example : nineLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYRYYROO");
      }
    }

    @Test
    public void showsTenLampsForMinutesBetweenFiftyAndFiftyFive() {
      List<String> tenLampExamples = Arrays.asList("00:50:00", "00:51:00", "00:52:00", "00:53:00", "00:54:00");

      for (String example : tenLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYRYYRYO");
      }
    }

    @Test
    public void showsElevenLampsForMinutesBetweenFiftyFiveAndSixty() {
      List<String> elevenLampExamples = Arrays.asList("00:55:00", "00:56:00", "00:57:00", "00:58:00", "00:59:00");

      for (String example : elevenLampExamples) {
        String fiveMinutes = getRow(clock.convert(example));
        assertThat(fiveMinutes).isEqualTo("YYRYYRYYRYY");
      }
    }

    private String getRow(String time) {
      return time.substring(ROW_START, ROW_END);
    }

  }

  public static class SingleHoursRow {

    private static final int ROW_START = 5;
    private static final int ROW_END = 9;

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void showsNoLampsForHoursEndingInZeroHoursOrFiveHours() {
      List<String> noLampExamples = Arrays.asList("00:00:00", "05:00:00", "10:00:00", "15:00:00", "20:00:00");

      for (String example : noLampExamples) {
        String singleHours = getRow(clock.convert(example));
        assertThat(singleHours).isEqualTo("OOOO");
      }
    }

    @Test
    public void showsOneLampForHoursEndingInOneHourOrSixHours() {
      List<String> oneLampExamples = Arrays.asList("01:00:00", "06:00:00", "11:00:00", "16:00:00", "21:00:00");

      for (String example : oneLampExamples) {
        String singleHours = getRow(clock.convert(example));
        assertThat(singleHours).isEqualTo("ROOO");
      }
    }

    @Test
    public void showsTwoLampsForHoursEndingInTwoHoursOrSevenHours() {
      List<String> twoLampExamples = Arrays.asList("02:00:00", "07:00:00", "12:00:00", "17:00:00", "22:00:00");

      for (String example : twoLampExamples) {
        String singleHours = getRow(clock.convert(example));
        assertThat(singleHours).isEqualTo("RROO");
      }
    }

    @Test
    public void showsThreeLampsForHoursEndingInThreeHoursOrEightHours() {
      List<String> threeLampExamples = Arrays.asList("03:00:00", "08:00:00", "13:00:00", "18:00:00", "23:00:00");

      for (String example : threeLampExamples) {
        String singleHours = getRow(clock.convert(example));
        assertThat(singleHours).isEqualTo("RRRO");
      }
    }

    @Test
    public void showsFourLampsForHoursEndingInFourHoursOrNineHours() {
      List<String> fourLampExamples = Arrays.asList("04:00:00", "09:00:00", "14:00:00", "19:00:00");

      for (String example : fourLampExamples) {
        String singleHours = getRow(clock.convert(example));
        assertThat(singleHours).isEqualTo("RRRR");
      }
    }

    private String getRow(String time) {
      return time.substring(ROW_START, ROW_END);
    }

  }

  public static class FiveHoursRow {

    private static final int ROW_START = 1;
    private static final int ROW_END = 5;

    private final BerlinClock clock = new BerlinClock();

    @Test
    public void showsNoLampsForHoursBetweenZeroAndFive() {
      List<String> examples = Arrays.asList("00:00:00", "01:00:00", "02:00:00", "03:00:00", "04:00:00");

      for (String example : examples) {
        String row = getRow(clock.convert(example));
        assertThat(row).isEqualTo("OOOO");
      }
    }

    @Test
    public void showsOneLampForHoursBetweenFiveAndTen() {
      List<String> examples = Arrays.asList("05:00:00", "06:00:00", "07:00:00", "08:00:00", "09:00:00");

      for (String example : examples) {
        String row = getRow(clock.convert(example));
        assertThat(row).isEqualTo("ROOO");
      }
    }

    @Test
    public void showsTwoLampsForHoursBetweenTenAndFifteen() {
      List<String> examples = Arrays.asList("10:00:00", "11:00:00", "12:00:00", "13:00:00", "14:00:00");

      for (String example : examples) {
        String row = getRow(clock.convert(example));
        assertThat(row).isEqualTo("RROO");
      }
    }

    @Test
    public void showsThreeLampsForHoursBetweenFifteenAndTwenty() {
      List<String> examples = Arrays.asList("15:00:00", "16:00:00", "17:00:00", "18:00:00", "19:00:00");

      for (String example : examples) {
        String row = getRow(clock.convert(example));
        assertThat(row).isEqualTo("RRRO");
      }
    }

    @Test
    public void showsFourLampsForHoursBetweenTwentyAndTwentyFour() {
      List<String> examples = Arrays.asList("20:00:00", "21:00:00", "22:00:00", "23:00:00");

      for (String example : examples) {
        String row = getRow(clock.convert(example));
        assertThat(row).isEqualTo("RRRR");
      }
    }

    private String getRow(String time) {
      return time.substring(ROW_START, ROW_END);
    }

  }

}
