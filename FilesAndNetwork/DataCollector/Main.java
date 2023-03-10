package DataCollector;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        MoscowMetroStations metroStations = new MoscowMetroStations();
        MoscowMetroLines metroLines = new MoscowMetroLines();
//        metroLines.getMoscowMetroLines();
        metroStations.getMoscowMetroStations();

//        FileSearch fileSearch = new FileSearch();
//        fileSearch.fileReader("data");
//        fileSearch.getJsonFile();
    }

}
