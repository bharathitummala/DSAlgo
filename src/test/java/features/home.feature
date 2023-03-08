Feature: Home page Feature
@LoginTesting
Scenario Outline: User launches home page of an dsalgo project without Sign in
Given The user navigates to Home page 
When The user click on Get started button 
Then User sees Error message "You are not logged in" is displayed
Then User clicks on the Sign in 
When User enters <username> and <password>
Then User clicks Login button

Examples: 
| username			 | password  |
| Numpy@sdet102  | Abcd1234! |

