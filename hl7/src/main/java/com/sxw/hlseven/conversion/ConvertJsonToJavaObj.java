/**
 * 
 */
package com.sxw.hlseven.conversion;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.eel.kitchen.jsonschema.main.JsonValidationFailureException;
import org.eel.kitchen.jsonschema.main.JsonValidator;
import org.eel.kitchen.jsonschema.main.ValidationReport;
import org.eel.kitchen.util.JsonLoader;
import org.springframework.stereotype.Component;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
@Component
public class ConvertJsonToJavaObj {

    /**
     * 
     * @param json
     * @param clazz
     * @return
     * @throws JsonValidationFailureException
     * @throws IOException
     * @throws JsonProcessingException
     */
    public <T> T convertJsonToJava(final String json, final Class<T> clazz) throws JsonProcessingException,
            IOException, JsonValidationFailureException {
        T obj = null;

        validateInputJsonAgaintSchema(json, clazz);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        obj = objectMapper.readValue(json.getBytes(), clazz);
        return obj;
    }

    private <T> void validateInputJsonAgaintSchema(final String json, final Class<T> clazz)
            throws JsonProcessingException, IOException, JsonValidationFailureException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String schemaName = "";

        JsonNode jsonNode = objectMapper.readTree(json.getBytes());

        schemaName = clazz.getSimpleName() + ".json";

        URL url = this.getClass().getResource("/schema/json/" + schemaName);

        if (url == null) {
            return;
        }
        JsonValidator jsonValidator = new JsonValidator(JsonLoader.fromURL(url));
        ValidationReport validationReport = jsonValidator.validate(jsonNode);
        if (!validationReport.isSuccess()) {
            List<String> messageList = validationReport.getMessages();
            if (messageList != null && messageList.size() > 0) {
                throw new JsonValidationFailureException("" + messageList.get(0));
            }
        }

    }
}
