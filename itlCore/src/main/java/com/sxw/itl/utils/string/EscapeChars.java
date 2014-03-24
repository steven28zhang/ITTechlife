/**
 * 
 */
package com.sxw.itl.utils.string;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class EscapeChars {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 
     * @param aText
     * @return
     */
    public static String forOracleSQL(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '\'') {
                result.append('\'').append('\'');
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

}
