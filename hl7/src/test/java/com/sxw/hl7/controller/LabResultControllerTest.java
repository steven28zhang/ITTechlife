/**
 * 
 */
package com.sxw.hl7.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.sxw.hl7.common.AbstractCommonTest;

/**
 * @author Stephen.Zhang@covisint.com
 * 
 */
public class LabResultControllerTest extends AbstractCommonTest {

    @Before
    public void setup() {
        super.initialize();
    }

    @Test
    public void insertLabResutTestNormalCases() throws ServletException, IOException {
        jsonObj = "{\"valueType\":\"CWE\",\"labEntryCode\":\"625-4\",\"labEntryLabel\":\"Bacteria identified:Prid:Pt:Stool:Nom:Culture^LN^^^^2.26\",\"subCode\":\"1382602857402001\",\"value\":\"66543000^Campylobacter jejuni^SCT^^^^January2007\",\"units\":\"\",\"referenceRange\":\"\",\"abnormalFlags\":\"\",\"resultStatus\":\"\",\"observationTime\":\"\",\"producerId\":\"\",\"observationMethod\":\"\",\"observer\":[{\"id\":\"1382602857402001\",\"lastName\":\"Zhang\",\"firstName\":\"Stephen\"}]}";
        MockHttpServletRequest curRequest = mockRequest(REQUEST_METHOD_POST, "/hlseven/handler/888888/storeLabResut", jsonObj);
        MockHttpServletResponse returnedResponse = callRequest(curRequest);
        System.out.println("insertLabResutTestNormalCases -->" + returnedResponse.getContentAsString() + "\nStatus: "
                + returnedResponse.getStatus());
    }
}
