public class RAM {
    private final String typeRAM;
    private final int volume;
    private final double weight;

    public RAM(String typeRAM, int volume, double weight) {
        this.typeRAM = typeRAM;
        this.volume = volume;
        this.weight = weight;
    }

    public String getTypeRAM() {
        return typeRAM;
    }

    public RAM setTypeRAM(String typeRAM) {
        return new RAM(typeRAM, volume, weight);
    }

    public int getVolume() {
        return volume;
    }

    public RAM setVolume(int volume) {
        return new RAM(typeRAM, volume, weight);
    }

    public double getWeight() {
        return weight;
    }

    public RAM setWeight(double weight) {
        return new RAM(typeRAM, volume, weight);
    }

    public String toString() {
        return "Тип оперативной памяти: " + typeRAM + "\n" +
                "Обем оперативной памяти: " + volume + "\n" +
                "Вес: " + weight + "\n";
    }
}
