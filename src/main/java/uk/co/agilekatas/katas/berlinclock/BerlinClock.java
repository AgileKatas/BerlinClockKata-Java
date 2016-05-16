package uk.co.agilekatas.katas.berlinclock;

public class BerlinClock {

  public String convert(String time) {
    StringBuilder base = new StringBuilder("OOOOOOOOOOOOOOOOOOOO");

    String singleMinutes = calculateSingleMinutes(time);

    return base.append(singleMinutes).toString();
  }

  private String calculateSingleMinutes(String time) {
    StringBuilder row = new StringBuilder();
    int minutes = Integer.parseInt(time.split(":")[1]);
    int lampsToTurnOn = minutes % 5;

    while(lampsToTurnOn > 0) {
      row.append("Y");
      lampsToTurnOn -= 1;
    }

    while(row.length() < 4) {
      row.append("O");
    }

    return row.toString();
  }

}
