Feature: Register feature with ExcelSheet Handling
 @Excel
Scenario Outline: User enters user data in Register page
Given User navigate to Register page 
When  User enters user data "<Sheetname>" and <RowNumber> 
And   User clicks Register button
Then  User sees a an approriate message

Examples:
|Sheetname|RowNumber|
| Sheet1  |   0     |
| Sheet1  |   1     |
| Sheet1  |   2     |
| Sheet1  |   3     |
| Sheet1  |   4     |
| Sheet1  |   5     |
| Sheet1  |   6     |
