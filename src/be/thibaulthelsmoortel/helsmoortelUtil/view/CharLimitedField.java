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
 * @author Thibault Helsmoortel
 */

/**
 * Class for JTextFields with a maximum amount of characters.
 */
public class CharLimitedField extends JTextField {
    private int maxChars;

    public CharLimitedField(int maxChars) {
        this.maxChars = maxChars;
    }

    public CharLimitedField(String text, int maxChars) {
        super(text);
        this.maxChars = maxChars;
    }

    public CharLimitedField(int columns, int maxChars) {
        super(columns);
        this.maxChars = maxChars;
    }

    public CharLimitedField(String text, int columns, int maxChars) {
        super(text, columns);
        this.maxChars = maxChars;
    }

    public CharLimitedField(Document doc, String text, int columns, int maxChars) {
        super(doc, text, columns);
        this.maxChars = maxChars;
    }

    /**
     * Returns the maximum amount of characters.
     * @return the maximum amount of characters
     */
    public int getMaxChars() {
        return maxChars;
    }

    /**
     * Sets the maximum amount of characters.
     * @param maxChars the new maximum amount of characters
     */
    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    /**
     * Returns the current character count of the field.
     * @return the current character count
     */
    public int getCurrentCharCount() {
        return getText().length();
    }

    /**
     * Returns the amount of available characters left.
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
     * Inner class forcing the limit on the field.
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
