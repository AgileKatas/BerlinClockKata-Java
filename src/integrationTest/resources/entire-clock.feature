Feature: Integrate the Entire Berlin Clock

  Scenario Outline: Entire clock displays correctly
  As a clock user
  I want to be able to see an entire clock
  So that I can tell what time it is at a glance

    Given I have started the converter
    When I enter <time>
    Then <clock> is returned

    Examples:
      | time     | clock                    |
      | 00:00:00 | ROOOOOOOOOOOOOOOOOOOOOOO |
      | 23:59:59 | ORRRRRRROYYRYYRYYRYYYYYY |
      | 16:50:06 | RRRROROOOYYRYYRYYRYOOOOO |
      | 11:37:01 | ORROOROOOYYRYYRYOOOOYYOO |