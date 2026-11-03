import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Bar {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final List<String> receipts = new ArrayList<>();
    private double takings = 0;

    public void addToMenu(MenuItem item) { menu.put(item.name(), item); }

    public void sell(String name, Size size, boolean loyaltyCard) {
        MenuItem item = menu.get(name);
        if (item == null) throw new IllegalArgumentException("Not on the menu: " + name);
        double price = item.price(size, loyaltyCard);
        takings += price;
        receipts.add(name + " (" + size + ")" + (loyaltyCard ? " with card" : "") + ": GHS " + String.format("%.2f", price));
    }

    public List<String> receipts() { return Collections.unmodifiableList(receipts); }

    public double takings() { return takings; }
}
