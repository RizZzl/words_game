package DataCollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;


public class FileSearch {

    String listStations;
    String DATA_FILE = "";

    public void fileReader(String path) throws ParseException, FileNotFoundException {
        File doc = new File(path);
        if (doc.isFile()) {
            DATA_FILE = doc.getAbsolutePath();
            if (doc.getName().endsWith(".json")) {
                listStations = listStations + doc + "\n";
            }
            if (doc.getName().endsWith(".csv")) {
                listStations = listStations + doc + "\n";
            }
        } else {
            File[] files = doc.listFiles();
            assert files != null;
            for (File file : files) {
                fileReader(file.getAbsolutePath());
            }
        }
        System.out.println(listStations);
    }

    public String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }

}
