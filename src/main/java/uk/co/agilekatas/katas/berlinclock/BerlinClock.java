package uk.co.agilekatas.katas.berlinclock;

public class BerlinClock {

  private static final String RED_LAMP = "R";
  private static final String YELLOW_LAMP = "Y";
  private static final String OFF_LAMP = "O";

  public String convert(String time) {
    return new StringBuilder()
        .append(calculateSecondsLamp(time))
        .append(calculateFiveHours(time))
        .append(calculateSingleHours(time))
        .append(calculateFiveMinutes(time))
        .append(calculateSingleMinutes(time))
        .toString();
  }

  private String calculateSecondsLamp(String time) {
    int seconds = Integer.parseInt(time.split(":")[2]);
    return seconds % 2 == 0 ? YELLOW_LAMP : OFF_LAMP;
  }

  private String calculateFiveHours(String time) {
    StringBuilder row = new StringBuilder();
    int hours = Integer.parseInt(time.split(":")[0]);
    int lampsToTurnOn = hours / 5;
    for (int i = 1; i <= 4; i++) {
      if (lampsToTurnOn > 0) {
        row.append(RED_LAMP);
        lampsToTurnOn--;
      } else {
        row.append(OFF_LAMP);
      }
    }

    return row.toString();
  }

  private String calculateSingleHours(String time) {
    StringBuilder row = new StringBuilder();
    int hours = Integer.parseInt(time.split(":")[0]);
    int lampsToTurnOn = hours % 5;
    for (int i = 1; i <= 4; i++) {
      if (lampsToTurnOn > 0) {
        row.append(RED_LAMP);
        lampsToTurnOn--;
      } else {
        row.append(OFF_LAMP);
      }
    }

    return row.toString();
  }

  private String calculateFiveMinutes(String time) {
    StringBuilder row = new StringBuilder();
    int minutes = Integer.parseInt(time.split(":")[1]);
    int lampsToTurnOn = minutes / 5;
    for (int i = 1; i <= 11; i++) {
      if (lampsToTurnOn > 0) {
        if (isRedLamp(i)) {
          row.append(RED_LAMP);
        } else {
          row.append(YELLOW_LAMP);
        }
        lampsToTurnOn--;
      } else {
        row.append(OFF_LAMP);
      }
    }

    return row.toString();
  }

  private boolean isRedLamp(int i) {
    return i % 3 == 0;
  }

  private String calculateSingleMinutes(String time) {
    StringBuilder row = new StringBuilder();
    int minutes = Integer.parseInt(time.split(":")[1]);
    int lampsToTurnOn = minutes % 5;
    for (int i = 1; i <= 4; i++) {
      if (lampsToTurnOn > 0) {
        row.append(YELLOW_LAMP);
        lampsToTurnOn--;
      } else {
        row.append(OFF_LAMP);
      }
    }
    return row.toString();
  }

}
