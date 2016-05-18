Feature: Implement the Single Hours Row

  Scenario Outline: Single hours row displays correctly
  As a clock user
  I want to be able to see single hours
  So that I can tell what hour it is

    Given I have started the converter
    When I enter <time>
    Then <row> is returned for the single hours row

    Examples:
      | time     | row  |
      | 00:00:00 | OOOO |
      | 23:59:59 | RRRO |
      | 02:04:00 | RROO |
      | 08:23:00 | RRRO |
      | 14:35:00 | RRRR |