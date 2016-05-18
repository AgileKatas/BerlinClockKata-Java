Feature: Implement the Seconds Lamp

  Scenario Outline: Seconds lamp displays correctly
  As a clock user
  I want to be able to see seconds passing
  So that I can see if my clock is working at a glance

    Given I have started the converter
    When I enter <time>
    Then <lamp> is returned for the seconds lamp

    Examples:
      | time     | lamp |
      | 00:00:00 | R    |
      | 23:59:59 | O    |