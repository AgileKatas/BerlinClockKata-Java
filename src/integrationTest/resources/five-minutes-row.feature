Feature: Implement the Five Minutes Row

  Scenario Outline: Five minutes row displays correctly
  As a clock user
  I want to be able to see five minutes
  So that I can tell higher minute amounts more easily at a glance

    Given I have started the converter
    When I enter <time>
    Then <row> is returned for the five minutes row

    Examples:
      | time     | row         |
      | 00:00:00 | OOOOOOOOOOO |
      | 23:59:59 | YYRYYRYYRYY |
      | 12:04:00 | OOOOOOOOOOO |
      | 12:23:00 | YYRYOOOOOOO |
      | 12:35:00 | YYRYYRYOOOO |