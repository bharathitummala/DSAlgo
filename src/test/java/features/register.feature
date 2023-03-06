Feature: Register feature 

Scenario Outline: User creates an account in Register page
Given I navigate to Register page 
When  I enter <username> and <password> and <confirmpassword>
And   I click Register button
Then  I see success message "New Account Created. You are logged in as" is displayed

Examples: 
| username			| password  |  confirmpassword  |
| USERNAME      | Abcd1234! |  Abcd1234!        |

Scenario Outline: User enters invalid data in Register page
Given I navigate to Register page 
When  I enter invalid <username> and <password> and <confirmpassword>
And   I click Register button
Then  I see failure message "password_mismatch:The two password fields didn’t match." is displayed

Examples: 
|     username	 |   password    | confirmpassword   |
| &**&**         | testpassword  | testpassword      |
| Numpy@sdet102  | Abcd1234!     | Abcd1234!         |
| Numpy@sdet102  | Abcd1234!     | Abcd123           |


