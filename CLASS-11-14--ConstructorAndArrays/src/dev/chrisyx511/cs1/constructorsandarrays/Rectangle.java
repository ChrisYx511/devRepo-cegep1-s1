package dev.chrisyx511.cs1.constructorsandarrays;

public class Rectangle {
    double length;
    double width;

    Rectangle() {
        length = 0;
        width = 0;
    }

    public Rectangle(double width) {
        this.width = width;
        this.length = width;
    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public double returnArea() {
        return length * width;
    }
}
