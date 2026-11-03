# Diagnosis: Abena's Juice Bar

Written after running the starter, before changing any code.

## What I observed

The large Mango Smoothie with a loyalty card is charged GHS 30.38. A large smoothie is
GHS 37.50, and the card takes 10% off, so it should be GHS 33.75. Juices with a card are
priced correctly (the large Sobolo is GHS 20.25).

## Problems, most dangerous first

1. **The loyalty discount is applied twice to smoothies** (`Bar.sell`, the SMOOTHIE branch
   has the `if (loyaltyCard)` line twice). Root cause: the pricing rules were copied into
   each branch, and the copy drifted. Risk: Abena loses money on every carded smoothie,
   quietly, and the takings do not match what she expects.
2. **Pricing is duplicated per kind of drink.** The size and card rules are written out
   once for juices and again for smoothies. Risk: every price change must be made twice,
   which is how problem 1 happened.
3. **Selling an item that is not on the menu crashes the till** with a
   NullPointerException, because `sell` never checks that it found the item. Risk: a typo
   at the counter stops the till mid-sale.
4. **Everything is public and stringly typed.** Any code can change a price or the
   takings directly, and a size typed as "Large" is silently charged as small. Risk:
   wrong prices with no error.

## What I will keep the same

The prices, the size rule (large is 1.5 times the base price), the 10% card discount
(applied once), the receipt lines and the takings total.
