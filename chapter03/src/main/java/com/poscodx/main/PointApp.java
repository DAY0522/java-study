package com.poscodx.main;

import com.poscodx.i.Drawable;
import com.poscodx.point.ColorPoint;
import com.poscodx.point.Point;
import com.poscodx.shape.Circle;
import com.poscodx.shape.Rectangle;
import com.poscodx.shape.Shape;
import com.poscodx.shape.Triangle;
import com.poscodx.text.GraphicText;

import java.io.Serializable;

public class PointApp {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(10);
        point.setY(20);
//        point.show();
//        drawPoint(point);
        draw(point);

        Point point2 = new Point(100, 200);
//        point2.show();
        point2.show(false);
//        drawPoint(point2);
        draw(point2);

        ColorPoint point3 = new ColorPoint(50, 100, "red");
//        drawPoint(point3);
        draw(point3);

//        drawShape(new Triangle());
//        drawShape(new Rectangle());
//        drawShape(new Circle());

        draw(new Triangle());
        draw(new Rectangle());
        draw(new Circle());

        draw(new GraphicText("안녕"));

        // instanceof 연산자
        Circle c = new Circle();
        System.out.println(c instanceof Circle);
        System.out.println(c instanceof Shape);
        System.out.println(c instanceof Object);

        // 오류: 연산자 우측항이 클래스인 경우, 좌측항의 레퍼런스 타입의 hierachy의 상하위만 사용할 수 있다.
        // System.out.println(c instanceof Rectangle);

        Shape s = new Circle();
        System.out.println(s instanceof Circle);
        System.out.println(s instanceof Object);
        System.out.println(s instanceof Rectangle);

        // 연산자 우측항이 인터페이스인 경우
        // hierachy 상관 없이 연산자를 사용할 수 있다.
        System.out.println(c instanceof Drawable);
        System.out.println(c instanceof Runnable); // 계층에 상관 없는 것도 가능하다.
        System.out.println(c instanceof Serializable);
    }

    public static void draw(Drawable drawable) {
        drawable.draw();
    }

//    public static void drawPoint(Point point) {
//        point.show();
//    }

//    public static void drawPoint(ColorPoint colorPoint) {
//        colorPoint.show();
//    }

//    public static void drawShape(Shape shape) {
//        shape.draw();
//    }

//    public static void drawTriangle(Triangle triangle) {
//        triangle.draw();
//    }
//
//    public static void drawRectangle(Rectangle rectangle) {
//        rectangle.draw();
//    }
}
