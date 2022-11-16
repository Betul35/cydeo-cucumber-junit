Feature: Web table order feature


  Scenario: User should be able to place order and order seen in web table
    Given User is already logged in and order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters customer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user selects credit card type "american express"
    And user enters credit card number "1111222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in first row of the web table



  Scenario Outline: User should be able to place order and order seen in web table
    Given User is already logged in and order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    @femaleScientists
    Examples: Famous female scientist
      | productType | quantity | customerName      | street        | city   | state   | zipCode | cardType | cardNumber    | expDate | expectedName      |
      | MoneyCog    | 2        | Marie Curie       | London Street | London | Endland | 50505   | Visa     | 1222223333444 | 12/24   | Marie Curie       |
      | Familybea   | 3        | Rosalind Franklin | London Street | London | Endland | 50505   | Visa     | 1222223333444 | 12/24   | Rosalind Franklin |
      | Screenable  | 4        | Betul Piyade      | London Street | London | Endland | 50505   | Visa     | 1222223333444 | 12/24   | Betul Piyade      |
      | MoneyCog    | 5        | Lise Meitner      | London Street | London | Endland | 50505   | Visa     | 1222223333444 | 12/24   | Lise Meitner      |
      | MoneyCog    | 6        | Barbara Clintock  | London Street | London | Endland | 50505   | Visa     | 1222223333444 | 12/24   | Barbara Clintock  |