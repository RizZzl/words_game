package src;

public class Dimensions {
    private int width;
    private int height;
    private int length;

    public Dimensions(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void toPrintVolume() {
        System.out.println(width * height * length);
    }

//    public int getWidth() {
//        return width;
//    }
//
//    public Dimensions setWidth(int width) {
//        return new Dimensions(width, height, length);
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public Dimensions setHeight(int height) {
//        return new Dimensions(width, height, length);
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public Dimensions setLength(int length) {
//        return new Dimensions(width, height, length);
//    }


}
