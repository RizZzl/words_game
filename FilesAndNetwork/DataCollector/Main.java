package DataCollector;

public class Main {
    public static void main(String[] args) {
        MoscowMetroStations metroStations = new MoscowMetroStations();
        MoscowMetroLines metroLines = new MoscowMetroLines();
        metroLines.getMoscowMetroLines();
        metroStations.getMoscowMetroStations();



    }

}
