package DataCollector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MoscowMetroStations {
    public StringBuilder builder = new StringBuilder();
    private Elements elements;
    private Elements lineNumber;

    public String getMoscowMetroStations() {
        String htmlFile = parseFile("data/code.html");
        Document doc = Jsoup.parse(htmlFile);
        elements = doc.select("span.js-metro-line");
        lineNumber = doc.select("div.js-depend");
        for (int i = 0; i < elements.size(); i++) {
            builder = builder.append(elements.get(i).text()).append(":\n\t")
                    .append(lineNumber.get(i).text().replaceAll("[0-9.]", "")).append("\n");
        }
//        System.out.println(builder);
        return builder.toString();
    }

    public String parseFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line +"\n"));
        }
        catch (Exception ex) {
            ex.getMessage();
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "MoscowMetroStations" + getMoscowMetroStations();
    }
}
