// Abena's Juice Bar - till program.
public class JuiceBar {

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.addToMenu(new MenuItem("Sobolo", 15.00));
        bar.addToMenu(new MenuItem("Pineapple Ginger", 18.00));
        bar.addToMenu(new MenuItem("Mango Smoothie", 25.00));

        bar.sell("Sobolo", Size.SMALL, false);
        bar.sell("Sobolo", Size.LARGE, true);
        bar.sell("Mango Smoothie", Size.SMALL, false);
        bar.sell("Mango Smoothie", Size.LARGE, true);
        bar.sell("Pineapple Ginger", Size.LARGE, false);

        System.out.println("=== Abena's Juice Bar - today ===");
        for (String r : bar.receipts()) System.out.println("  " + r);
        System.out.println("Takings: GHS " + String.format("%.2f", bar.takings()));
    }
}
