package com.poscodx.point;

import com.poscodx.i.Drawable;

public class Point implements Drawable {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;
    private int y;

    public void show() {
        System.out.println("Point[x=" + x + ", y=" + y + "]를 그렸습니다.");
    }

    public void show(boolean visible) {
        if (visible) {
            show(); // 중복을 최소화
        } else {
            System.out.println("Point[x=" + x + ", y=" + y + "]를 지웠습니다.");
        }
    }

    @Override
    public void draw() {
        show();
    }
}
