@US25
  Feature: New Appointment by patient
    Scenario: Patient make an appointment yourself
      Given User goes to medunna website for patient appointment
      And user click Sign In button for validation criteria
      And user enter valid username for patient account
      And user enter valid password for patient account
      And user click the Sign In button for reach their account
      And user click the MY PAGES button for a new appointment
      And user click make an appoinment button
      And user enter valid Phone number "123-456-8769"
      And user click the send an Appointment Request
      Then user verify sees registration saved! toast container


