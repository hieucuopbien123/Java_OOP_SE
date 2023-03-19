# OUTLINE USECASE "Rent a bike"

## Basic flow
| # | Doer | Action |
| --- | ---- | --------|
| 1 | Customer| Scan the barcode on the lock via app |
| 2 | Software | Convert barcode to bike code of the system |
| 3 | Software | Check validity of the bike code |
| 4 | Software | Show the information of that bike |
| 5 | Customer| Choose payment method, default is pay by credit card |
| 6 | Customer| Input card information and transaction content |
| 7 | Software | Calculate the deposit fee |
| 8 | Customer| Confirm transaction |
| 9 | Software | Deduct money from customer account |
| 10 | Software | Show the information of transaction to screen and save that transaction to the system |
| 11 | Software | Send email informing customer about the status of transaction |

## Alternative flow
| Location | Condition | Actions | Resume location|
| ---- | ---- | --------|------|
| 3 | Invalid bikecode | Show error | Previous Step |
| 6 | Invalid card information | Show error | Previous Step |
| 6 | Not enough balance | Notify customer | Previous Step |