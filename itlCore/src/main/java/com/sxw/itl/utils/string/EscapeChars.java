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
