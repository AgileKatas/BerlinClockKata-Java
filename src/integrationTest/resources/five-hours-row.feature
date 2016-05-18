Feature: Implement the Five Hours Row

  Scenario Outline: Five hours row displays correctly
  As a clock user
  I want to be able to see five hours
  So that I can tell higher hour amounts more easily at a glance

    Given I have started the converter
    When I enter <time>
    Then <row> is returned for the five hours row

    Examples:
      | time     | row  |
      | 00:00:00 | OOOO |
      | 23:59:59 | RRRR |
      | 02:04:00 | OOOO |
      | 08:23:00 | ROOO |
      | 16:35:00 | RRRO |