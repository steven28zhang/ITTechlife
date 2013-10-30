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
        jsonObj  = "{\"valueType\":\"\",\"labEntryCode\":\"14134-1\",\"labEntryLabel\":\"Hemoglobin^LN\",\"subCode\":\"LRSC1383032269169\",\"value\":\"12.6\",\"units\":\"g/dl^^UM\",\"referenceRange\":\"12.0-16.0\",\"abnormalFlags\":\"N\",\"resultStatus\":\"F\",\"observationTime\":\"20131029030910\",\"observationMethod\":\"LRM1382926928671\",\"observer\":[{\"id\":\"LRIDSXZ0011383009096647\",\"lastName\":\"LRLNZhang0011383009096647\",\"firstName\":\"LRFNStephen0011383009096647\"},{\"id\":\"LR1381912800100OIDSXZ002\",\"lastName\":\"LR1381912800100OLNZhang002\",\"firstName\":\"LR1381912800100OFNStephen002\"},{\"id\":\"LR1381912800100OIDSXZ003\",\"lastName\":\"LR1381912800100OLNZhang003\",\"firstName\":\"LR1381912800100OFNStephen003\"},{\"id\":\"LR1381912800100OIDSXZ004\",\"lastName\":\"LR1381912800100OLNZhang004\",\"firstName\":\"LR1381912800100OFNStephen004\"}]}";
        MockHttpServletRequest curRequest = mockRequest(REQUEST_METHOD_POST, "/hlseven/handler/888888/storeLabResut", jsonObj);
        MockHttpServletResponse returnedResponse = callRequest(curRequest);
        System.out.println("insertLabResutTestNormalCases -->" + returnedResponse.getContentAsString() + "\nStatus: "
                + returnedResponse.getStatus());
    }
}
