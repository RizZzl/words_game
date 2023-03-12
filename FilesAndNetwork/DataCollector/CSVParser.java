package DataCollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVParser {
    public String filePath;

    public void CSVParse(StringBuilder file) {
        this.filePath = String.valueOf(file);
        String[] split = filePath.split("\n");

        for (int i = 1; i < split.length; i++) {
            try (BufferedReader br = Files.newBufferedReader(Paths.get(split[i]))) {
                String DELIMITER = ",";

                String line;
                while ((line = br.readLine()) != null) {
                    String[] columns = line.split(DELIMITER);

                    System.out.println("Metro opening date: " + String.join(", ", columns));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
