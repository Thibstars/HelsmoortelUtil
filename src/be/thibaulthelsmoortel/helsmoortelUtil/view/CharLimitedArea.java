/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package be.thibaulthelsmoortel.helsmoortelUtil.view;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Class for JTextAreas with a maximum amount of characters.
 *
 * @author Thibault Helsmoortel
 */
public class CharLimitedArea extends JTextArea {
    private int maxChars;

    /**
     * Class constructor specifying max chars.
     *
     * @param maxChars maximum amount of characters
     */
    public CharLimitedArea(int maxChars) {
        this.maxChars = maxChars;
    }

    public CharLimitedArea(String text, int maxChars) {
        super(text);
        this.maxChars = maxChars;
    }

    /**
     * Class constructor specifying rows, columns, max chars.
     *
     * @param rows     amount of rows
     * @param columns  amount of columns
     * @param maxChars maximum amount of characters
     */
    public CharLimitedArea(int rows, int columns, int maxChars) {
        super(rows, columns);
        this.maxChars = maxChars;
    }

    /**
     * Class constructor specifying text, rows, columns, max chars.
     *
     * @param text     the area's text
     * @param rows     amount of rows
     * @param columns  amount of columns
     * @param maxChars maximum amount of characters
     */
    public CharLimitedArea(String text, int rows, int columns, int maxChars) {
        super(text, rows, columns);
        this.maxChars = maxChars;
    }

    /**
     * Class constructor specifying document and max chars.
     *
     * @param doc      the area's document
     * @param maxChars maximum amount of characters
     */
    public CharLimitedArea(Document doc, int maxChars) {
        super(doc);
        this.maxChars = maxChars;
    }

    /**
     * Class constructor specifying document, text, rows, columns, max chars.
     *
     * @param doc      the area's document
     * @param text     the area's text
     * @param rows     amount of rows
     * @param columns  amount of columns
     * @param maxChars maximum amount of characters
     */
    public CharLimitedArea(Document doc, String text, int rows, int columns, int maxChars) {
        super(doc, text, rows, columns);
        this.maxChars = maxChars;
    }

    /**
     * Returns the maximum amount of characters.
     *
     * @return the maximum amount of characters
     */
    public int getMaxChars() {
        return maxChars;
    }

    /**
     * Sets the maximum amount of characters.
     *
     * @param maxChars the new maximum amount of characters
     */
    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    /**
     * Returns the current character count of the area.
     *
     * @return the current character count
     */
    public int getCurrentCharCount() {
        return getText().length();
    }

    /**
     * Returns the amount of available characters left.
     *
     * @return the amount of available characters left
     */
    public int getCharsLeft() {
        return maxChars - getText().length();
    }

    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    /**
     * Inner class forcing the limit on the area.
     */
    private class LimitDocument extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str == null) return;

            if ((getLength() + str.length()) <= maxChars) {
                super.insertString(offs, str, a);
            }
        }
    }
}
