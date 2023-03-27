import java.io.File;
import java.util.Objects;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) throws Exception {
        String srcFolder = "/users/sortedmap/Desktop/src";
        String dstFolder = "/users/sortedmap/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int step = Objects.requireNonNull(files).length / Runtime.getRuntime().availableProcessors();

        int var = 0;
        File[] temp = new File[step];

        for (File file : files) {
            temp[var++] = file;
            if (var == step) {
                new Thread(new ImageResizer(temp, newWidth, dstFolder, start)).start();
                temp = new File[step];
                var = 0;
            }
        }
    }
}
