Feature: Validating Listen API

  Scenario Outline:Add the podcast
    Given Add  podcast with "<id>" "<image>" <listen_score>
    When Use "post" method to "ADDpodcast"
    Then assert the data with status code 100
    Then assert "status" in response body is "in review"
    Then use Get method to display the podacst "3141672a2"

    Examples:
    |id|image|listen_score|
    |3141672a2|new| 73    |

    Scenario: run Ui test
      Given open Url
      When enter test in search bar
      Then press click button to get results
      Then close browser


