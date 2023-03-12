package DataCollector;

public class Main {
    public static void main(String[] args) throws Exception {
        MoscowMetroStations metroStations = new MoscowMetroStations();
        MoscowMetroLines metroLines = new MoscowMetroLines();

        System.out.println(metroLines);
        System.out.println(metroStations);

        FileSearch fileSearch = new FileSearch();
        fileSearch.fileReader("data");
        fileSearch.getJsonFile();

        JsonParse testJson = new JsonParse();
        testJson.jsonParse(fileSearch.listJsonFile);

        CSVParser testCSV = new CSVParser();
        testCSV.CSVParse(fileSearch.listCSVFile);
    }

}
