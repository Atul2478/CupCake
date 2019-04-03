# CupCake
Java/Maven based student project!


## Functionality ##

# Guest (No Login)
- Browse Pages (Forside, Login, Opret, Shop, Kurv)
- Add items to cart from page 'Shop'
/ - / When trying to fulfil an order, get's redirected to login page.

# Customer
- Browse Pages (Forside, Profil, Logud, Shop, Kurv)
- Change username and email from page 'Profil'.
- Logout and reset session by going to page 'Logud'.
- Put items into their cart from page 'Shop'.
- See a full list of their cart and it's prices from 'Kurv'.
- Fulfil an order from the cart page 'Kurv'. /// This resets cart aswell.

# Admin
* SAME AS CUSTOMER *
- Access to Browse Page 'Admin'.
- From Admin can see a list of all Customers and all Orders.
- From Admin can either 1. Search Customer by ID or Email or 2. Click on a customer in the list. - This makes them see the customer's orders and their customer information.
- From Admin can they delete any order.
- From Admin Search / Customer page they can add money to the selected Customer's account.
- Should also be able to delete a user, but I did not end up fixing this function, so instead it just looks good on the Customer Page...
