/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view.drawing;

import java.awt.*;

/**
 * @author Thibault Helsmoortel
 */

public abstract class DrawTool {
    //TODO complete JavaDoc
    public static final Point DEFAULT_POINT = new Point(0,0);
    public static final int DEFAULT_SIZE = 1;
    public static final Stroke DEFAULT_STROKE = new BasicStroke(DEFAULT_SIZE);
    public static final Color DEFAULT_COLOR = Color.BLACK;

    private Point point;
    private Stroke stroke;
    private int size;
    private Color color;
    private boolean isDrawing;
    //TODO add a Cursor variable and getters/setters

    //region constructors
    public DrawTool() {
        this.point = DEFAULT_POINT;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
        this.isDrawing = false;
    }

    public DrawTool(Point point, Stroke stroke, Color color) {
        this.point = point;
        this.stroke = stroke;
        this.size = DEFAULT_SIZE;
        this.color = color;
        this.isDrawing = false;
    }

    public DrawTool(Point point) {
        this.point = point;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
        this.isDrawing = false;
    }

    public DrawTool(Stroke stroke) {
        this.stroke = stroke;
        this.point = DEFAULT_POINT;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
        this.isDrawing = false;
    }

    public DrawTool(Color color) {
        this.color = color;
        this.point = DEFAULT_POINT;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.isDrawing = false;
    }

    public DrawTool(Point point, Stroke stroke) {
        this.point = point;
        this.stroke = stroke;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
        this.isDrawing = false;
    }

    public DrawTool(Point point, Color color) {
        this.point = point;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = color;
        this.isDrawing = false;
    }

    public DrawTool(Stroke stroke, Color color) {
        this.point = DEFAULT_POINT;
        this.size = DEFAULT_SIZE;
        this.stroke = stroke;
        this.color = color;
        this.isDrawing = false;
    }
    //endregion


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setXPos(int x) {
        setPoint(new Point(x, (int) point.getY()));
    }

    public void setYPos(int y) {
        setPoint(new Point((int) point.getX(), y));
    }

    public Stroke getStroke() {
        return stroke;
    }

    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDrawing() {
        return isDrawing;
    }

    public void setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }
}
