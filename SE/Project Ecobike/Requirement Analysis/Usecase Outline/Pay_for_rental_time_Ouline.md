# OUTLINE USECASE "Pay for rental time"

## Basic flow
| # | Doer | Action |
| --- | ---- | --------|
| 1 | Software | Calculate rental fee |
| 2 | Softbank | Ask the bank to pay the fee |
| 3 | Interbank | Process the transaction |
| 4 | Software | Save the transaction |
| 5 | Software | Display the successful transaction notification |
| 6 | Software | Send an emails of transaction info to the customer |

## Alternative flow
| # | Location | Condition | Action | Resume Location |
| --- | ---- | --------|
| 1 | Step 3 | The balance is not enough | The software notifies that the balance is not enough | Step 2 |