package me.dawars.szakkor2;

import processing.core.PApplet;
import processing.core.PShape;

public class DrawShapes extends PApplet {
    public static void main(String[] args) {
        PApplet.main(DrawShapes.class);
    }

    @Override
    public void settings() {
        size(1000, 1000, P3D);
    }

    PShape sphere;
    float angle = 0;
    float d = 0;

    @Override
    public void setup() {
        sphere = createSphere(155, 200, 100, 32);
    }

    float Cangle = 0;
    float distance = 0;

    @Override
    public void draw() {
        background(0);


        shape(sphere);

        angle += 0.01;

        Cangle += 0.01;
        distance += 1;


        camera(distance * cos(Cangle), 0, distance * sin(Cangle), 0, 0, 0, 0, 1, 0);
//        camera(distance * cos(Cangle), 0, distance * sin(Cangle), 0, 0, 0, 0, 1, 0);

    }


    float sqrt(int y) {
        double r;
        r = 24025 - y * y;
        r = Math.sqrt(r);


        return (float) r;
    }

    private PShape createSphere(int R, float h, float w, int detail) {
        PShape shape = createShape();


        shape.beginShape(POINTS);
        shape.stroke(0, 0, 255);
        shape.strokeWeight(4);
        int y;


        for (int i = 0; i <= detail; i++) {
            float angle = TWO_PI / detail;
            float x = sin(i * angle);
            float z = cos(i * angle);

            // shape.vertex(x * r, 0, z * r);


            for (y = R; y >= -R; y -= 15) {
                float r = 24025 - y * y;
                r = (float) Math.sqrt(r);


                shape.vertex(x * r, -y, z * r);

            }


            //shape.vertex(x * sqrt(145), 0, z * sqrt(145));
            shape.vertex(x * sqrt(155), 155, z * sqrt(155));



           /* shape.vertex(x * sqrt(10), -10, z * sqrt(10));
            shape.vertex(x * sqrt(30),-30, z * sqrt(30));
            shape.vertex(x * sqrt(50), -50, z * sqrt(50));
            shape.vertex(x * sqrt(70), -70, z * sqrt(70));
            shape.vertex(x * sqrt(90), -90, z * sqrt(90));
            shape.vertex(x * sqrt(110), -110, z * sqrt(110));
            shape.vertex(x * sqrt(10), 10, z * sqrt(10));
            shape.vertex(x * sqrt(30),30, z * sqrt(30));
            shape.vertex(x * sqrt(50), 50, z * sqrt(50));
            shape.vertex(x * sqrt(70), 70, z * sqrt(70));
            shape.vertex(x * sqrt(90), 90, z * sqrt(90));
            shape.vertex(x * sqrt(110), 110, z * sqrt(110)); */


        }
        shape.endShape();
        return shape;
    }
}
