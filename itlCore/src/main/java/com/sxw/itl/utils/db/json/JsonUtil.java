/**
 * 
 */
package com.sxw.itl.utils.db.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * @author u123199
 * 
 */
public class JsonUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        parseTestLocJson();
    }

    private static String createTestLocJson() {
        JSONObject jsonLoc = new JSONObject();
        jsonLoc.put("repType", "ajax");
        jsonLoc.put("repSource", "fromLoc");
        jsonLoc.put("status", "success");
        JSONObject loc = new JSONObject();
        JSONArray ja = new JSONArray();
        loc.put("PVG", "PVG-Shanghai Pu Dong");
        ja.add(loc);
        loc = new JSONObject();
        loc.put("SHA", "SHA-Shanghai All airports");
        ja.add(loc);
        loc = new JSONObject();
        loc.put("BJS", "BJS-All Airports");
        ja.add(loc);
        jsonLoc.put("locationList", ja);

        jsonLoc.put("message", "success");
        System.out.println("jsonLoc:" + jsonLoc.toString());
        return jsonLoc.toString();
    }

    private static void parseTestLocJson() {
        String reqJSON = "{\"reqType\":\"ajax\",\"reqSource\":\"fromLoc\",\"reqTripType\":\"flight\",\"locName\":\"pvg\"}";
        reqJSON = "{'reqType':'ajax','reqSource':'fromLoc','reqTripType':'flight','locName':'de\\''}";
        JSONObject json = (JSONObject) JSONSerializer.toJSON(reqJSON);
        String reqType = getStringFromJSON(json, "reqType");
        String locName= getStringFromJSON(json, "locName");
        System.out.println("reqType:" + reqType);
        System.out.println("locName:" + locName);
        String reqSource = getStringFromJSON(json, "reqSource");
        String reqTripType = getStringFromJSON(json, "reqTripType");

        reqJSON = "{\"reqType\":\"ajax\",\"reqSource\":\"fromLoc\",\"reqTripType\":\"flight\",\"locName\":\"pvg\"}";
        json = (JSONObject) JSONSerializer.toJSON(reqJSON);
        reqType = getStringFromJSON(json, "reqType");
        System.out.println("reqType:" + reqType);
        reqSource = getStringFromJSON(json, "reqSource");
        reqTripType = getStringFromJSON(json, "reqTripType");

        System.out.println("");
    }

    private static String getStringFromJSON(final JSONObject json, final String key) {
        try {
            return json.getString(key);
        } catch (Exception e) {
        }
        return "";
    }

}
