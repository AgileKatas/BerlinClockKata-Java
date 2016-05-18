package uk.co.agilekatas.katas.berlinclock;

public class BerlinClock {

  private static final String RED_LAMP = "R";
  private static final String YELLOW_LAMP = "Y";
  private static final String OFF_LAMP = "O";

  public String convert(String time) {
    StringBuilder base = new StringBuilder("OOOOO");

    String singleHours = calculateSingleHours(time);
    String fiveMinutes = calculateFiveMinutes(time);
    String singleMinutes = calculateSingleMinutes(time);

    return base.append(singleHours).append(fiveMinutes).append(singleMinutes).toString();
  }

  private String calculateSingleHours(String time) {
    StringBuilder row = new StringBuilder();
    int hours = Integer.parseInt(time.split(":")[0]);
    int lampsToTurnOn = hours % 5;
    for (int i = 1; i <=4; i++) {
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

    while (lampsToTurnOn > 0) {
      row.append(YELLOW_LAMP);
      lampsToTurnOn -= 1;
    }

    while (row.length() < 4) {
      row.append(OFF_LAMP);
    }

    return row.toString();
  }

}
