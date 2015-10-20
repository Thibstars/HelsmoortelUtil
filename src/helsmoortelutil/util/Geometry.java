/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.util;

/**
 * @author Thibault Helsmoortel
 */

import java.lang.Math;

/**
 * Class for regularly used geometry math methods.
 */

public final class Geometry {

    /**
     * Unavailable constructor
     */
    private Geometry() {
    }

    /**
     * Returns the perimeter of a square
     * @param side length of one side
     * @return the perimeter
     */
    public static double perimeterSquare(double side) {
        return side + side + side + side;
    }

    /**
     * Returns the perimeter of a rectangle
     * @param length length
     * @param width width
     * @return the perimeter
     */
    public static double perimeterRectangle(double length, double width) {
        return length + width + length + width;
    }

    /**
     * Returns the perimeter of a triangle
     * @param side1 length of side 1
     * @param side2 length of side 2
     * @param side3 length of side 3
     * @return the perimeter
     */
    public static double perimeterTriangle(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    /**
     * Returns the perimeter of a trapezoid
     * @param side1 length of side 1
     * @param side2 length of side 2
     * @param side3 length of side 3
     * @param side4 length of side 4
     * @return the perimeter
     */
    public static double perimeterTrapezoid(double side1, double side2, double side3, double side4) {
        return side1 + side2 + side3 + side4;
    }

    /**
     * Returns the perimeter of a circle
     * @param radius radius of the circle
     * @return the perimeter
     */
    public static double perimeterCircle(double radius) {
        return 2 * Math.PI * radius;
    }

    /**
     * Returns the area of a square
     * @param side length of one side
     * @return the area
     */
    public static double areaSquare(double side) {
        return side * side;
    }

    /**
     * Returns the area of a rectangle
     * @param length length
     * @param width width
     * @return the area
     */
    public static double areaRectangle(double length, double width) {
        return length * width;
    }

    /**
     * Returns the area of a triangle
     * @param base length of the base
     * @param height length of the height
     * @return the area
     */
    public static double areaTriangle(double base, double height) {
        return Math.pow((base * height), 2);
    }

    /**
     * Returns the area of a trapezoid
     * @param base1 length of the first base
     * @param base2 length of the second base
     * @param height length of the height
     * @return the area
     */
    public static double areaTrapezoid(double base1, double base2, double height) {
        return (base1 + base2) * height / 2;
    }

    /**
     * Returns the area of a circle
     * @param radius radius of the circle
     * @return the area
     */
    public static double areaCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Returns the volume of a cube
     * @param side length of one side
     * @return the volume
     */
    public static double volumeCube(double side) {
        return side * side * side;
    }

    /**
     * Returns the volume of a box
     * @param length length
     * @param width  width
     * @param height height
     * @return the volume
     */
    public static double volumeBox(double length, double width, double height) {
        return length * width * height;
    }

    /**
     * Returns the volume of a sphere
     * @param radius radius of the sphere
     * @return the volume
     */
    public static double volumeSphere(double radius) {
        return (4/3) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Returns the volume of a triangular prism
     * @param baseTriangle base of the triangle
     * @param heightTriangle height of the triangle
     * @param heightPrism height of the prism
     * @return the volume
     */
    public static double volumeTriangularPrism(double baseTriangle, double heightTriangle, double heightPrism) {
        return areaTriangle(baseTriangle, heightTriangle) * heightPrism;
    }

    /**
     * Returns the volume of a cylinder
     * @param radius radius of the cylinder
     * @param height height of the cylinder
     * @return the volume
     */
    public static double volumeCylinder(double radius, double height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    /**
     * Returns the length of the hypotenuse (c) of a right triangle
     * @param a the triangle's first right side
     * @param b the triangle's second right side
     * @return the length of the hypotenuse (c) of the right triangle
     */
    public static double pythagoras(double a, double b) {
        double c = 0.0;
        if (Math.abs(a) > Math.abs(b)) {
            c = b / a;
            c = Math.abs(a) * Math.sqrt(1 + c * c);
        }
        else if (b != 0) {
            c = a / b;
            c = Math.abs(b) * Math.sqrt(1 + c * c);
        }
        return c;
    }
}
