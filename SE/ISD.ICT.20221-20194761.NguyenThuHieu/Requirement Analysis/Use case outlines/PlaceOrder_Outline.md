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
| 8 | Software | calculates shipping fees |
| 9 | Software | displays the invoice |
| 10 | Customer | confirms the invoice |
| 11 | Software | saves the invoice |
| 12 | Customer | provides a payment method |
| 13 | Customer | makes payment |
| 14 | Software | displays info and record transaction and order info |
| 15 | Software | records the transaction info and the order|
| 16 | Software | sends an email of invoice and transaction info to the customer |
| 17 | Administrator | accepts orders |
| 18 | Software | accepts orders |
## Alternative flow of events
| Location | Condition | Actions | Resume location|
| ---- | ---- | --------|------|
| | Any time | Customer can go to previous step | Previous Step |
| | Any time | Customer can cancel order payment. If canceling after the payment, the amount will be refunded | |
| Step 3 | Order quantity is smaller than that in the inventory | Software asks the customer to update the cart and shows the available quantity for each of those products | Step 2 | 
| Step 6 | if a mandatory field is left blank or there exists invalid input | Software asks the customer to update again | Step 7 |
| Step 7 | if the customer has chosen to place a rush order | Software checks media and shipping address, notifies the customer, asks the customer to update rush order info, displays the screen for rush order, and calculates the shipping fees | Step 8 |
| Step 17 | Administrator rejects the order | Order is canceled | End |
| Step 18 | if there are not enough products in the inventory | Softwares denies the approval of an order | End |
