package DataCollector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;


public class JsonParse {
    public String filePath;

    public void jsonParse(StringBuilder file) {
        this.filePath = String.valueOf(file);
        try {
            String[] split = filePath.split("\n");
            for (int i = 1; i < split.length; i++) {
                FileReader reader = new FileReader(split[i]);

                JSONParser jsonParser = new JSONParser();
                JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

                Iterator iterator = jsonArray.iterator();

                System.out.println("\n" + i);
                while (iterator.hasNext()) {
                    JSONObject innerObj = (JSONObject) iterator.next();
                    System.out.println("Station name: "+ innerObj.get("station_name") + "\n\t" +
                            "depth: " + innerObj.get("depth"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}