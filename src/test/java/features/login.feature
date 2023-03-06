Feature: Login feature 

Scenario Outline: Sign in  with valid credentials
Given I navigate to login 
When I enter <username> and <password>
And I click Login button
Then Success message "You are logged in" is displayed

Examples: 
| username			 | password  |
| Numpy@sdet102  | Abcd1234! |

Scenario Outline: Sign in with invalid credentials
Given I navigate to login 
When I enter <username> and <password>
And I click Login button
Then Error message "Invalid Username and Password" is displayed

Examples: 
| username			 | password  |
| Numpy@sdet102  | password1 | 
| Numpy@sdet10   | password1 |
| Numpy@sdet10   | password1 |
