/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Thibault Helsmoortel
 */

/**
 * Class extending JTextField to create fields reserved for Integers.
 */
public class NumberField extends JTextField {
    private int integer;
    private Color validColor = Color.GREEN, invalidColor = Color.RED;
    private boolean isValid = false;
    private boolean hasMaxLength = false, hasMinLength = false;
    private int minLength, maxLength;

    /**
     * Default constructor.
     */
    public NumberField() {
        addNumberListener();
    }

    /**
     * Constructor setting minimum and maximum lengths of the field.
     * @param minLength minimum length of the field
     * @param maxLength maximum length of the field
     */
    public NumberField(int minLength, int maxLength) {
        setMinLength(minLength);
        setMaxLength(maxLength);
        addNumberListener();
    }

    /**
     * Method adding a KeyListener on the field.
     */
    private void addNumberListener() {
        NumberField.this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                checkValidity();
            }
        });
    }

    /**
     * Method returning the field's value (in stead of getText()).
     * @return the value of the field.
     */
    public int getInteger() {
        return integer;
    }

    /**
     * Method to set the field's value (in stead of setText()).
     * @param integer value to place on the field.
     */
    public void setInteger(int integer) {
        this.integer = integer;
    }

    /**
     * Method returning the validity of the field.
     * @return the validity of the field.
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Method to reset the field.
     */
    public void reset() {
        NumberField.this.setText("");
        checkValidity();
    }

    /**
     * Method to check the validity of the field.
     * According to the validity, a background color is set.
     */
    public void checkValidity() {
        String tmp = NumberField.this.getText();
        if ((hasMaxLength && tmp.length() > maxLength) || (hasMinLength && tmp.length() < minLength)) {
            NumberField.this.setBackground(invalidColor);
            isValid = false;
        }
        else if (!tmp.isEmpty() && tmp.matches("[0-9]+$")) {
            NumberField.this.setBackground(validColor);
            isValid = true;
            integer = Integer.parseInt(tmp);
        }
        else {
            NumberField.this.setBackground(invalidColor);
            isValid = false;
        }
    }

    /**
     * Method to set the maximum length of the field.
     * @param maxLength value for the new maximum length.
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
        hasMaxLength = true;
    }

    /**
     * Method to set the minimum length of the field.
     * @param minLength value for the new minimum length.
     */
    public void setMinLength(int minLength) {
        this.minLength = minLength;
        hasMinLength = true;
    }

    /**
     * Method to get the color for a valid field.
     * @return color a valid field will be set to.
     */
    public Color getValidColor() {
        return validColor;
    }

    /**
     * Method to set the color for a valid field.
     * @param validColor color to set valid fields to.
     */
    public void setValidColor(Color validColor) {
        this.validColor = validColor;
    }

    /**
     * Method to get the color for an invalid field.
     * @return color an invalid field will be set to.
     */
    public Color getInvalidColor() {
        return invalidColor;
    }

    /**
     * Method to set the color for an invalid field.
     * @param invalidColor color to set invalid fields to.
     */
    public void setInvalidColor(Color invalidColor) {
        this.invalidColor = invalidColor;
    }
}