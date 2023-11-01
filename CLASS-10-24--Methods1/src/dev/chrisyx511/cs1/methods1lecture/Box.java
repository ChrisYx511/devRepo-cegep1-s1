package dev.chrisyx511.cs1.methods1lecture;

public class Box {
    public int width;
    public int height;
    public int length;
    Box(int w,int h,int l){
        this.width = w;
        this.height = h;
        this.length = l;
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }
}
