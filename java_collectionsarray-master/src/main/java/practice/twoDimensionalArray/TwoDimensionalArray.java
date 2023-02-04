package practice.twoDimensionalArray;

public class TwoDimensionalArray {

    public static final char SYMBOL = 'X';
    public static final char SPASE = ' ';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] cross = new char[size][size];
        for(int i = 0; i < cross.length; i++){
            for (int j = 0; j < cross[i].length; j++) {
                if (j == i || j == cross.length - 1 - i) {
                    cross[i][j] = SYMBOL;
                } else {
                    cross[i][j] = SPASE;
                }
                System.out.print(cross[i][j]);
            }
            System.out.println();
        }
        return cross;
    }
}
