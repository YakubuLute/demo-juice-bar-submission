public enum Size {
    SMALL(1.0), LARGE(1.5);

    private final double multiplier;

    Size(double multiplier) { this.multiplier = multiplier; }

    double multiplier() { return multiplier; }
}
