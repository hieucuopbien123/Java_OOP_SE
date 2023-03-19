# OUTLINE USECASE "Return a bike"

## Basic flow
| # | Doer | Action |
| --- | ---- | --------|
| 1 | Customer | Request to return bike |
| 2 | Software | Display list of docks |
| 3 | Customer | Choose a dock |
| 4 | Software | Calls use case “Return exchange” |
| 5 | Software | Calls use case “Pay for rental time” |

## Alternative flow
| # | Location | Condition | Action |
| --- | ---- | --------|
| 1 | Step 4 | If the customer rent for less than 10 minutes | The software notifies and ends the use case |