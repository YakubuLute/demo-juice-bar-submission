public final class MenuItem {
    private static final double CARD_DISCOUNT = 0.10;

    private final String name;
    private final double basePrice;

    public MenuItem(String name, double basePrice) {
        if (basePrice <= 0) throw new IllegalArgumentException("Price must be positive: " + name);
        this.name = name;
        this.basePrice = basePrice;
    }

    public String name() { return name; }

    // One pricing rule for every drink: size first, then the loyalty card, once.
    public double price(Size size, boolean loyaltyCard) {
        double price = basePrice * size.multiplier();
        if (loyaltyCard) price = price * (1 - CARD_DISCOUNT);
        return price;
    }
}
