Feature: Register at Practice form box

  @smokeTestExcel
  Scenario: fill each field of register with Excel data
    Given that a web user wants to register in demoqa
    When he fills all the requested fields in text box register section with excel
    Then he should see it a message succesful using excel.

  @smokeTestFaker
  Scenario: fill each field of register with Faker data
      Given that a web user wants to register in demoqa
      When he fills all the requested fields in text box register section with faker
      Then he should see it a message succesful using faker.

  @smokeTestProperties
    Scenario: fill each field of register with file config.properties data
        Given that a web user wants to register in demoqa
        When he fills all the requested fields in text box register section with properties
        Then he should see it a message succesful using properties.