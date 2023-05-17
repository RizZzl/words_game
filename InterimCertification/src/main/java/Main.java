import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Main {
    private static final int DEFAULT_SIZE_LIMIT = 1;

    public static void main(String[] args) {
        String path = args[0];
        int sizeLimit = args.length > 1 ? Integer.parseInt(args[1]) : DEFAULT_SIZE_LIMIT;
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path");
            return;
        }
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new FileSearchTask(folder, sizeLimit));
    }

    private static class FileSearchTask extends RecursiveAction {

        private final File folder;
        private final int sizeLimit;

        public FileSearchTask(File folder, int sizeLimit) {
            this.folder = folder;
            this.sizeLimit = sizeLimit;
        }

        @Override
        protected void compute() {
            List<File> fileList = new ArrayList<>();
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        FileSearchTask task = new FileSearchTask(file, sizeLimit);
                        task.fork();
                        task.join();
                    } else {
                        if (file.length() > sizeLimit * 1024 * 1024) {
                            fileList.add(file);
                        }
                    }
                }
            }
            Collections.sort(fileList, (f1, f2) -> Long.compare(f2.length(), f1.length()));
            for (File file : fileList) {
                System.out.println(file.getAbsolutePath() + " (" + formatSize(file.length()) + ")");
            }
        }

        private String formatSize(long size) {
            if (size < 1024) {
                return size + " B";
            }
            if (size < 1024 * 1024) {
                return size / 1024 + " KB";
            }
            if (size < 1024 * 1024 * 1024) {
                return size / (1024 * 1024) + " MB";
            }
            return size / (1024 * 1024 * 1024) + " GB";
        }
    }

}
