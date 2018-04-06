package me.dawars.szakkor1;

import processing.core.PApplet;
import processing.core.PMatrix2D;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class RotateTransform extends PApplet {

    private float angle = 0;


    public static void main(String[] args) {
        PApplet.main(RotateTransform.class);
    }

    @Override
    public void settings() {
        size(1280, 720);
    }

    @Override
    public void setup() {
    }

    @Override
    public void draw() {
        background(200f);
        // move (0, 0) to the center of the window
        translate(width / 2, height / 2);
        // calculate the length of a unit in pixels
        float unit = width / 2 / 10;
        scale(unit, -unit);

        pushMatrix(); // saves the current transformation

//        rotate(angle); // TODO 1: comment out

        PMatrix2D mat = new PMatrix2D(
                cos(-angle), -sin(-angle), 0,
                sin(-angle),  cos(-angle), 0

        );

        camera(100,200,200,0,0,0,0,0,0);

        angle += 0.01f;

        drawOrdinaryShape();

        // P point
        PVector P = new PVector(1, 0);

        PVector newP = mat.mult(P, null);


        // TODO 2: rotate P point with @angle here

        float x0 = newP.x; // change these
        float y0 = newP.y; // change these



        stroke(0xffff0000);
        strokeWeight(0.05f);
        line(0, 0, x0, y0);

        popMatrix(); // resets the previous transformation (removes rotation)

        drawCoord(unit);
    }

    /**
     * Draws a random shape
     */
    private void drawOrdinaryShape() {
        List<PVector> points = new ArrayList<>();
        points.add(new PVector(-1, 2));
        points.add(new PVector(5, 4));
        points.add(new PVector(3, 0));
        points.add(new PVector(4, -3));
        points.add(new PVector(0, -2));
        points.add(new PVector(-4, -3));
        points.add(new PVector(-2, 0));
        points.add(new PVector(-3, 3));
        points.add(new PVector(-2, 4));
        points.add(new PVector(0, 3));

        noStroke();
        fill(0, 210, 255);

        beginShape();
        for (PVector point : points) {
            // TODO 3: rotate every point with @angle here, hint coming next week

            PMatrix2D mat = new PMatrix2D(
                    cos(-angle), -sin(-angle), 0,
                    sin(-angle),  cos(-angle), 0

            );

            PVector newP = mat.mult(point, null);



            float x0 = newP.x; // change these
            float y0 = newP.y; // change these

            curveVertex(x0, y0);
        }
        endShape();
    }

    /**
     * Draws the coordinate axes
     * Up and Right are the positive directions
     *
     * @param unit
     */
    private void drawCoord(float unit) {
        stroke(0);

        // coordinate axis
        strokeWeight(0.01f);
        color(0);
        line(-width / 2, 0, width / 2, 0);
        line(0, -height / 2, 0, height / 2);

        // arrows
        float side = 0.2f;
        fill(0f);
        noStroke();
        triangle(0, height / unit / 2, side, height / unit / 2 - side, -side, height / unit / 2 - side);
        triangle(width / unit / 2, 0, width / unit / 2 - side, -side, width / unit / 2 - side, side);

        // mark numbers
        fill(255f);
        stroke(0);
        strokeWeight(0.05f);
        for (int x = 0; x <= width / unit / 2; x++) {
            point(x, 0);
            point(-x, 0);
        }
        for (int y = 1; y <= height / unit / 2; y++) {
            point(0, y);

            point(0, -y);

        }
    }
}
