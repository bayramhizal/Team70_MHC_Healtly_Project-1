@US24
  Feature: My Appointment by patient
    Background:User goings to their account
      Given user goes to medunna home page
      And  user click the Sign In button
      And user enter valid username
      And user enter valid password
      And user enter Sign In button
      And user clicks the MY PAGES button
      Then user clicks the My Appointments button

    Scenario: user sees their examination results
        Given user clicks the Shows Test button
        And user clicks the View Results button
        Then user verify test results
    @US024_TC002
    Scenario: user sees their invoice
       When user clicks the Show Invoice Button
       Then user verifies their Invoice

