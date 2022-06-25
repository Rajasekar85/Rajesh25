Feature: Verify the Adactin page Details

  Scenario Outline: Booking By Selecting All fields
    #   Given User is on the Adactin Hotel Page
    #  When User should perform Login "<username>" , "<Password>"
    And User should verify "Hello ARUNSK007!"
    And User should select a Hotel "<location>","<hotel>","<roomtype>","<roomNo>","<Datein>","<Dateout>","<adultroom>"and"<childroom>"
    And User should verify the page "Select Hotel"
    And User should Search Hotel
    And User should verify the text "Book A Hotel"
    And User should Book Hotel "<firstname>","<lastname>","<address>" and Payment
      | creditnum        | credittype       | expmonth  | expyear | cvv |
      | 1234132452567894 | American Express | August    |    2019 | 234 |
      | 1736173613123782 | VISA             | September |    2020 | 121 |
      | 2374264782189392 | Master Card      | October   |    2021 | 323 |
      | 2374264534589392 | Others           | November  |    2022 | 342 |
    Then User should verify the "Booking Confirmation"

    Examples: 
      | location  | hotel          | roomtype | roomNo  | Datein     | Dateout    | adultroom | childroom | firstname | lastname | address    |
      | Melbourne | Hotel Sunshine | Deluxe   | 2 - Two | 18/05/2022 | 19/05/2022 | 2 - Two   | 2 - Two   | Arun      | S K      | Kovilpatti |

  Scenario Outline: Booking By Selecting All fields
    # Given User is on the Adactin Hotel Page
    #   When User should perform Login "<username>", "<Password>"
    And User should verify "Hello ARUNSK007!"
    And User should select a Hotel "<location>","<hotel>","<roomtype>","<roomNo>","<Datein>","<Dateout>","<adultroom>"and"<childroom>"
    And User should verify the page "Select Hotel"
    And User Should Search Hotel
    And User should verify the text "Book A Hotel"
    And User should Click on Book
    Then User should verify error"Please Enter your First Name" ,"Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | location  | hotel          | roomtype | roomNo  | Datein     | Dateout    | adultroom | childroom |
      | Melbourne | Hotel Sunshine | Deluxe   | 2 - Two | 18/05/2022 | 19/05/2022 | 2 - Two   | 2 - Two   |
