# Outline usecase "Place Order"
## Basic flow
| # | Doer | Action |
| --- | ---- | --------|
| 1 | Customer | views the cart |
| 2 | Customer | requests to place an order |
| 3 | Software | checks the order quantity |
| 4 | Customer | updates delivery information |
| 5 | Customer | submits the delivery form |
| 6 | Software | validates customer input |
| 7 | Software | checks if customer place rush order or normal order |
| 8 | Software | check shipping address |
| 9 | Software | display info, allow customer update rush order info |
| 10 | Software | calculates shipping fees |
| 11 | Software | displays the invoice |
| 12 | Customer | confirms the invoice |
| 13 | Software | saves the invoice |
| 14 | Customer | provides a payment method |
| 15 | Customer | makes payment |
| 16 | Software | displays info and record transaction and order info |
| 17 | Software | records the transaction info and the order|
| 18 | Software | sends an email of invoice and transaction info to the customer |
| 19 | Administrator | accepts orders |
| 20 | Software | accepts orders |
## Alternative flow of events
| Location | Condition | Actions | Resume location|
| ---- | ---- | --------|------|
| | Any time | Customer can go to previous step | Previous Step |
| | Any time | Customer can cancel order payment. If canceling after the payment, the amount will be refunded | |
| Step 3 | Order quantity is smaller than that in the inventory | Software asks the customer to update the cart and shows the available quantity for each of those products | Step 2 | 
| Step 6 | if a mandatory field is left blank or there exists invalid input | Software asks the customer to update again | Step 7 |
| Step 7 | if the customer has chosen to place normal order | The software skip some step | Step 10 |
| Step 19 | Administrator rejects the order | Order is canceled | End |
| Step 20 | if there are not enough products in the inventory | Softwares denies the approval of an order | End |
