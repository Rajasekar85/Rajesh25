Feature: open google.com feature


  Scenario: open Google website and search
    Given user is entering google.com
    And user clicks the search box
   When some other action
    And Types the search term as "Rajasekar"
    Then the user should see the search results for Rajasekar

  