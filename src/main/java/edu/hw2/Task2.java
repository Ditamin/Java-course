package edu.hw2;

public class Task2 {
    public static class Rectangle {
        private int width;
        private int height;

        void setWidth(int width) {
            this.width = width;
        }

        void setHeight(int height) {
            this.height = height;
        }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        @Override
        void setWidth(int width) {
            super.setHeight(width);
            super.setWidth(width);
        }

        @Override
        void setHeight(int height) {
            super.setHeight(height);
            super.setWidth(height);
        }
    }

}
