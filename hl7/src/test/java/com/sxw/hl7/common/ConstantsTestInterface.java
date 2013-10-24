/**
 * 
 */
package com.sxw.hl7.common;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public interface ConstantsTestInterface {
    String STRING_LENGTH_6 = "123456";
    String STRING_LENGTH_21 = "abcdefghijklmnopqrs21";
    String STRING_LENGTH_51 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstu51";
    String STRING_LENGTH_61 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstu51abcdefgh61";
    String STRING_LENGTH_81 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxy";
    String STRING_LENGTH_129 = "abcdefghijklmnopqrstuvwxyz28abcdefghijklmnopqrstuvwxyz56abcdefghijklmnopqrstuvwxyz84abcdefghijklmno|abcdefghijklmnopqrstuvwxyz129";
    String STRING_LENGTH_258 = STRING_LENGTH_129 + STRING_LENGTH_129;
    String STRING_LENGTH_706 = STRING_LENGTH_258 + STRING_LENGTH_258 + STRING_LENGTH_129 + STRING_LENGTH_61;
    String STRING_LENGTH_751 = STRING_LENGTH_706 + STRING_LENGTH_21 + STRING_LENGTH_21 + "123";
    String STRING_LENGTH_1001 = STRING_LENGTH_258 + STRING_LENGTH_258 + STRING_LENGTH_258 + STRING_LENGTH_129
            + STRING_LENGTH_81 + "abcdefghijklmno17";
    String PRINCIPALVAL = "";
    String CREDENTIALVAL = "";
    String HEADERKEY = "";
    String CONTENT_TYPE_JSON = "application/json";
    String REQUEST_METHOD_POST="POST";
}
