/**
 * 
 */
package com.sxw.itl.utils.transformation.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class JsonToJava {

    /**
     * 
     * @param jsonString
     * @param clazz
     * @return
     */
    public <T> T convertJsonToJava(String jsonString, Class<T> clazz) {
        T javaObject = null;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            javaObject = objectMapper.readValue(jsonString.getBytes(), clazz);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }

        return javaObject;
    }

}
