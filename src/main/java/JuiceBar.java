// Abena's Juice Bar - till program.
// Written in a hurry when the bar opened. It works, mostly. Run it and look at the
// receipts for loyalty-card customers.

import java.util.*;

public class JuiceBar {

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.items.add(new Item("Sobolo", "JUICE", 15.00));
        bar.items.add(new Item("Pineapple Ginger", "JUICE", 18.00));
        bar.items.add(new Item("Mango Smoothie", "SMOOTHIE", 25.00));

        bar.sell("Sobolo", "SMALL", false);
        bar.sell("Sobolo", "LARGE", true);
        bar.sell("Mango Smoothie", "SMALL", false);
        bar.sell("Mango Smoothie", "LARGE", true);
        bar.sell("Pineapple Ginger", "LARGE", false);

        bar.printDay();
    }
}

class Item {
    public String name;
    public String kind;      // "JUICE" or "SMOOTHIE"
    public double basePrice;

    public Item(String name, String kind, double basePrice) {
        this.name = name;
        this.kind = kind;
        this.basePrice = basePrice;
    }
}

class Bar {
    public List<Item> items = new ArrayList<>();
    public List<String> receipts = new ArrayList<>();
    public double takings = 0;

    public void sell(String name, String size, boolean loyaltyCard) {
        Item item = null;
        for (Item i : items) {
            if (i.name.equals(name)) item = i;
        }
        double price = 0;
        if (item.kind.equals("JUICE")) {
            price = item.basePrice;
            if (size.equals("LARGE")) price = price * 1.5;
            if (loyaltyCard) price = price * 0.9;
        } else if (item.kind.equals("SMOOTHIE")) {
            price = item.basePrice;
            if (size.equals("LARGE")) price = price * 1.5;
            if (loyaltyCard) price = price * 0.9;
            if (loyaltyCard) price = price * 0.9;
        }
        takings = takings + price;
        receipts.add(name + " (" + size + ")" + (loyaltyCard ? " with card" : "") + ": GHS " + String.format("%.2f", price));
    }

    public void printDay() {
        System.out.println("=== Abena's Juice Bar - today ===");
        for (String r : receipts) System.out.println("  " + r);
        System.out.println("Takings: GHS " + String.format("%.2f", takings));
    }
}
