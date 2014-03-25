/**
 * 
 */
package com.sxw.itl.utils.string;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import org.apache.commons.validator.GenericValidator;

/**
 * @author stephenxianweizhang@gmail.com
 * 
 */
public final class EscapeChars {

    private static final String prjSupportedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * The locName only support includes a-Z,0-9<br>
     * 
     * @param locName
     * @return
     */
    public static String escapeCharsForPrj(final String locName) {
        if (GenericValidator.isBlankOrNull(locName)) {
            return "";
        }
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(locName);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (prjSupportedChars.indexOf(character) >= 0) {
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "N'Zeto, Angola (ARZ)";
        System.out.println("CharacterIterator.DONE:" + CharacterIterator.DONE);
        str = forOracleSQL(str);

        System.out.println("str:" + str);
    }

    /**
     * 
     * @param aText
     * @return
     */
    public static String forOracleSQL(String aText) {
        if (GenericValidator.isBlankOrNull(aText)) {
            return "";
        }
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '\'') {
                result.append('\'').append('\'');
            } else {
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

}
