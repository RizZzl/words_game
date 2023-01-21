public class Keyboard {
    private final KeyboardType type;
    private final boolean presenceOfIllumination;
    private final double weight;

    public Keyboard(KeyboardType type, boolean presenceOfIllumination, double weight) {
        this.type = type;
        this.presenceOfIllumination = presenceOfIllumination;
        this.weight = weight;
    }

    public KeyboardType getType() {
        return type;
    }

    public Keyboard setType(KeyboardType type) {
        return new Keyboard(type, presenceOfIllumination, weight);
    }

    public boolean isPresenceOfIllumination() {
        return presenceOfIllumination;
    }

    public Keyboard setPresenceOfIllumination(boolean presenceOfIllumination) {
        return new Keyboard(type, presenceOfIllumination, weight);
    }

    public double getWeight() {
        return weight;
    }

    public Keyboard setWeight(double weight) {
        return new Keyboard(type, presenceOfIllumination, weight);
    }

    public String toString() {
        return "Тип клавиатуры: " + type + "\n" +
                "Есть подсветка: " + presenceOfIllumination + "\n" +
                "Вес: " + weight + "\n";
    }
}
