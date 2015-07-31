Feature: Fun game to count on fingers
  A game to learn to count on fingers

  @LEFT
  Scenario Outline: Showing fingers
    Given I hold my hand in a fist
    When I show <show> finger on my left hand
    Then I have <left> bent in my fist in my left hand
  Examples: left hand
    | show | left |
    | 1    | 4    |
    | 2    | 3    |
    | 3    | 2    |
    | 4    | 1    |
    | 5    | 0    |

  @RIGHT
  Scenario Outline: Showing fingers
    Given I hold my hand in a fist
    When I show <show> finger on my right hand
    Then I have <left> bent in my fist in my right hand
  Examples: left hand
    | show | left |
    | 5    | 0    |
    | 4    | 1    |
    | 3    | 2    |
    | 2    | 3    |
    | 1    | 4    |
