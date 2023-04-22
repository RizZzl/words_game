import java.io.FileOutputStream;

public class Loader {
    // 10687 ms
    // 323 ms
    // 1 ms
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        int startIndex = 0;
        int endIndex = 0;
        int perThread = 20000 / NUM_THREADS;
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int i = 0; i < NUM_THREADS; i++) {
            startIndex = i * perThread;
            endIndex = startIndex + perThread;
            Thread thread = new NumberGeneratorThread(startIndex, endIndex, letters);
            thread.start();
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }


    static class NumberGeneratorThread extends Thread {
        private int startIndex;
        private int endIndex;
        private char[] letters;

        public NumberGeneratorThread(int startIndex, int endIndex, char[] letters) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.letters = letters;
        }

        @Override
        public void run() {
            try {
                FileOutputStream writer = new FileOutputStream("CarNumberGenerator/res/numbers_" + startIndex + "-" + endIndex + ".txt");

                for (int number = startIndex; number < endIndex; number++) {
                    int regionCode = 199;
                    for (char firstLetter : letters) {
                        StringBuilder carNumber = new StringBuilder();
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                carNumber.append(firstLetter);
                                carNumber.append(padNumber(number, 3));
                                carNumber.append(secondLetter);
                                carNumber.append(thirdLetter);
                                carNumber.append(padNumber(regionCode, 2));
                                carNumber.append("\n");
                            }
                        }
                        writer.write(carNumber.toString().getBytes());
                    }
                }
                writer.flush();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static String padNumber(int number, int numberLength) {
            StringBuilder numberStr = new StringBuilder(Integer.toString(number));
            int padSize = numberLength - numberStr.length();

            for (int i = 0; i < padSize; i++) {
                numberStr.insert(0, '0');
            }
            return numberStr.toString();
        }
    }
}