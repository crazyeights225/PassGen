Testing the Application - Navigate to the index page

Narrative: The user navigates to the index page on the platform

Scenario: User wants to access the index page
@Skip
Given the user goes to the index page
Then the user sees their randomly generated useragent and password

Scenario: User attempts to log in with the correct password
Given the user goes to the index page
When the user gets their password and puts it in the form
When the user presses Submit
Then the user sees Success message

Scenario: User attempts to log in with the incorrect password
Given the user goes to the index page
When the user puts an incorrect password into the form
When the user presses Submit
Then the user sees Failure message
