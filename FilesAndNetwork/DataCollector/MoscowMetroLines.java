package DataCollector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MoscowMetroLines {
    public StringBuilder builder = new StringBuilder();
    private Elements elements;
    private Elements lineNumber;

    public String getMoscowMetroLines() {
        String htmlFile = parseFile("data/code.html");
        Document doc = Jsoup.parse(htmlFile);
        elements = doc.select("span.js-metro-line");
        lineNumber = doc.select("div.js-metro-stations.data-line");
        for (int i = 0; i < elements.size(); i++) {
            builder = builder.append(elements.get(i).text()).append(lineNumber.size()).append("\n");
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
        return "MoscowMetroLines" + getMoscowMetroLines();
    }
}
