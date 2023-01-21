public class Screen {
    private final String diagonal;
    private final ScreenType type;
    private final double weight;

    public Screen(String diagonal, ScreenType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public Screen setDiagonal(String diagonal) {
        return new Screen(diagonal, type, weight);
    }

    public ScreenType getType() {
        return type;
    }

    public Screen setType(ScreenType type) {
        return new Screen(diagonal, type, weight);
    }

    public double getWeight() {
        return weight;
    }

    public Screen setWeight(double weight) {
        return new Screen(diagonal, type, weight);
    }

    public String toString() {
        return "Диагональ: " + diagonal + "\n" +
                "Тип экрана: " + type + "\n" +
                "Вес: " + weight + "\n";
    }
}
