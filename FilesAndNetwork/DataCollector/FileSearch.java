package DataCollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;


public class FileSearch {

    public StringBuilder listJsonFile = new StringBuilder();
    public StringBuilder listCSVFile = new StringBuilder();
    public String DATA_FILE = "";

    public void fileReader(String path) throws ParseException, FileNotFoundException {
        File doc = new File(path);
        if (doc.isFile()) {
            DATA_FILE = doc.getAbsolutePath();
            if (doc.getName().endsWith(".json")) {
                listJsonFile.append(" \n").append(doc);
            }
            if (doc.getName().endsWith(".csv")) {
                listCSVFile.append("\n").append(doc);
            }
        } else {
            File[] files = doc.listFiles();
            assert files != null;
            for (File file : files) {
                fileReader(file.getAbsolutePath());
            }
        }

//        System.out.println(listJsonFile.toString() + listCSVFile);
    }
}
