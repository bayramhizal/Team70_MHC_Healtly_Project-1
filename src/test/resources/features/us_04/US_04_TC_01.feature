Feature: Get Cucumber Projesi

  Scenario: Arif Senerio
    Given herokuapp base url e "booking" ve 19 ekle
    When User sends a GET Request to the url
    Then HTTP Status Code should be 200
    And  Content Type should be JSON
    And  Status Line should be "HTTP/1.1 200 OK"


