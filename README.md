# Abena's Juice Bar: Till Program (demo submission)

A sample submission for the **demo lab**, used to show how to submit on Evalu8.

## Running it

```bash
javac -d target/classes src/main/java/*.java
java -cp target/classes JuiceBar
```

## What I changed

See `DIAGNOSIS.md` (committed before any code change) for what was wrong and why.

- **One pricing rule.** `MenuItem.price` applies the size and then the loyalty card,
  once, for every drink. The double discount on smoothies is gone, and a price change
  is now made in one place.
- **No more juice and smoothie branches.** The two kinds priced identically, so the
  kind no longer needs to exist in code.
- **Sizes are an enum**, so a mistyped size no longer compiles.
- **The till refuses an unknown item** with a clear message instead of crashing.
- **Fields are private.** Only `Bar` changes the takings, and the receipts it hands out
  cannot be edited.

## Before and after

| Sale | Before | After |
| --- | --- | --- |
| Mango Smoothie (LARGE) with card | GHS 30.38 | GHS 33.75 |
| Every other sale | unchanged | unchanged |

## One improvement

Unknown items now fail with "Not on the menu: <name>", so a typo at the counter is
caught and named instead of stopping the till with a NullPointerException.
