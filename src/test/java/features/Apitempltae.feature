Feature: Validating Listen API

  Scenario Outline:API test
    Given Add  podcast with "<id>" "<image>" <listen_score>
    When Use "post" method to "ADDpodcast"
    Then assert the data with status code 200
    Then assert "status" in response body is "found"
    Then use Get method to display the podacst "<id>"

    Examples:
    |id|image|listen_score|
    |123fasrs5|new| 73    |


  @Ui_test
  Scenario Outline:UI test
    Given open "<Url>"
    When  enter "<text>" in search bar
    Then  press click button to get results
    Then  close browser

    Examples:
    |Url|text|
    |https://www.onesearch.com/|Ampion|



