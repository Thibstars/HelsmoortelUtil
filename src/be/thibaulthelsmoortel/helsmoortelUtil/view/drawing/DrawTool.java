/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.view.drawing;

import java.awt.*;

/**
 * Class representing the draw tool concept.
 *
 * @author Thibault Helsmoortel
 */
public abstract class DrawTool {

    public static final Point DEFAULT_POINT = new Point(0,0);
    public static final int DEFAULT_SIZE = 1;
    public static final Stroke DEFAULT_STROKE = new BasicStroke(DEFAULT_SIZE);
    public static final Color DEFAULT_COLOR = Color.BLACK;

    private Point point;
    private Stroke stroke;
    private int size;
    private Color color;

    //region constructors

    /**
     * Default constructor.
     */
    public DrawTool() {
        this.point = DEFAULT_POINT;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    /**
     * Constructor specifying point, stroke and color.
     *
     * @param point  the tool's point
     * @param stroke the tool's stroke
     * @param color  the tool's color
     */
    public DrawTool(Point point, Stroke stroke, Color color) {
        this.point = point;
        this.stroke = stroke;
        this.size = DEFAULT_SIZE;
        this.color = color;
    }

    /**
     * Constructor specifying point.
     *
     * @param point the tool's point
     */
    public DrawTool(Point point) {
        this.point = point;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    /**
     * Constructor specifying stroke.
     *
     * @param stroke the tool's stroke
     */
    public DrawTool(Stroke stroke) {
        this.stroke = stroke;
        this.point = DEFAULT_POINT;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    /**
     * Constructor specifying color.
     *
     * @param color the tool's color
     */
    public DrawTool(Color color) {
        this.color = color;
        this.point = DEFAULT_POINT;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
    }

    /**
     * Constructor specifying point and stroke.
     *
     * @param point the tool's point
     * @param stroke the tool's stroke
     */
    public DrawTool(Point point, Stroke stroke) {
        this.point = point;
        this.stroke = stroke;
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
    }

    /**
     * Constructor specifying point and color.
     *
     * @param point the tool's point
     * @param color the tool's color
     */
    public DrawTool(Point point, Color color) {
        this.point = point;
        this.stroke = DEFAULT_STROKE;
        this.size = DEFAULT_SIZE;
        this.color = color;
    }

    /**
     * Constructor specifying stroke and color.
     *
     * @param stroke the tool's stroke
     * @param color the tool's color
     */
    public DrawTool(Stroke stroke, Color color) {
        this.point = DEFAULT_POINT;
        this.size = DEFAULT_SIZE;
        this.stroke = stroke;
        this.color = color;
    }
    //endregion

    /**
     * Returns the tool's point.
     *
     * @return the tool's point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Sets the tool's point.
     *
     * @param point the new point
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * Returns the tool's stroke.
     *
     * @return the tool's stroke
     */
    public Stroke getStroke() {
        return stroke;
    }

    /**
     * Sets the tool's stroke.
     *
     * @param stroke the new stroke
     */
    public void setStroke(Stroke stroke) {
        this.stroke = stroke;
    }

    /**
     * Returns the tool's size;
     *
     * @return the tool's size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the tool's size.
     *
     * @param size the new size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns the tool's color.
     *
     * @return the tool's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the tool's color.
     *
     * @param color the new color
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
