import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.System.currentTimeMillis;

public class Main {
    private static String url = "https://skillbox.ru/";
    private static String fileName = "SiteMap";
    private static final String DST_FOLDER = "SiteMap/src/main/resources/map/";
    private static final String FILE_TYPE = "txt";
    private static final int numberOfCores = Runtime.getRuntime().availableProcessors();
    private static final AtomicLong startOfTime = new AtomicLong();


    public static void main(String[] args)  {
        try {
            fileName = new URL(url).getHost().replace(".", "_");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        startOfTime.set(currentTimeMillis());

        LinkExecutor linkExecutor = new LinkExecutor(url);

        String siteMap = new ForkJoinPool(numberOfCores).invoke(linkExecutor);

        writeToFile(siteMap);
    }

    protected static void writeToFile(String string)  {
        if (!Files.exists(Paths.get(DST_FOLDER))) new File(DST_FOLDER).mkdir();
        String filePath = DST_FOLDER.concat(fileName).concat(".").concat(FILE_TYPE);
        File file = new File(filePath);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write(string);
        writer.flush();

        long allTimeStop = (currentTimeMillis() - startOfTime.get()) / 1_000;

        System.out.printf("Выполнена запись карты сайта %s за %d секунд: %s%n", url, allTimeStop, file.getName());
    }
}
