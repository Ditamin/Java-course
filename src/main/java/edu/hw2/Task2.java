package edu.hw2;

public class Task2 {
    public static class Rectangle {
        final private int width;
        final private int height;

        Rectangle() {
            this(0, 0);
        }

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        Rectangle setWidth(int width) {
            return new Rectangle(width, this.height);
        }

        Rectangle setHeight(int height) {
            return new Rectangle(this.width, height);
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        Square() {
            this(0);
        }

        Square(int side) {
            super(side, side);
        }
    }
}
