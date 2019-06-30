Feature: To see if a vehicle exists.

    @Functional
    Scenario: Verify vehicle existence in dealer portal
      Given I am on "https://covercheck.vwfsinsuranceportal.co.uk/" page
      When I type "OV12UYY" as registration number
      Then I see vehicle details
