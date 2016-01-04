/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.view;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

//TODO add JavaDoc

public class CharLimitedArea extends JTextArea {
    private int maxChars;

    public CharLimitedArea(int maxChars) {
        this.maxChars = maxChars;
    }

    public CharLimitedArea(String text, int maxChars) {
        super(text);
        this.maxChars = maxChars;
    }

    public CharLimitedArea(int rows, int columns, int maxChars) {
        super(rows, columns);
        this.maxChars = maxChars;
    }

    public CharLimitedArea(String text, int rows, int columns, int maxChars) {
        super(text, rows, columns);
        this.maxChars = maxChars;
    }

    public CharLimitedArea(Document doc, int maxChars) {
        super(doc);
        this.maxChars = maxChars;
    }

    public CharLimitedArea(Document doc, String text, int rows, int columns, int maxChars) {
        super(doc, text, rows, columns);
        this.maxChars = maxChars;
    }

    public int getMaxChars() {
        return maxChars;
    }

    public void setMaxChars(int maxChars) {
        this.maxChars = maxChars;
    }

    public int getCurrentCharCount() {
        return getText().length();
    }

    public int getCharsLeft() {
        return maxChars - getText().length();
    }

    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

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
