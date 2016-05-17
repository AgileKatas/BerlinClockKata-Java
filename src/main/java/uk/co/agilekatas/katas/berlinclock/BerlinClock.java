package uk.co.agilekatas.katas.berlinclock;

public class BerlinClock {

  public String convert(String time) {
    StringBuilder base = new StringBuilder("OOOOOOOOO");

    String fiveMinutes = calculateFiveMinutes(time);
    String singleMinutes = calculateSingleMinutes(time);

    return base.append(fiveMinutes).append(singleMinutes).toString();
  }

  private String calculateFiveMinutes(String time) {
    StringBuilder row = new StringBuilder();
    int minutes = Integer.parseInt(time.split(":")[1]);
    int lampsToTurnOn = minutes / 5;
    for (int i = 1; i <= 11; i++) {
      if (lampsToTurnOn > 0) {
        if (i % 3 == 0) {
          row.append("R");
        } else {
          row.append("Y");
        }
        lampsToTurnOn--;
      } else {
        row.append("O");
      }
    }

    return row.toString();
  }

  private String calculateSingleMinutes(String time) {
    StringBuilder row = new StringBuilder();
    int minutes = Integer.parseInt(time.split(":")[1]);
    int lampsToTurnOn = minutes % 5;

    while (lampsToTurnOn > 0) {
      row.append("Y");
      lampsToTurnOn -= 1;
    }

    while (row.length() < 4) {
      row.append("O");
    }

    return row.toString();
  }

}
