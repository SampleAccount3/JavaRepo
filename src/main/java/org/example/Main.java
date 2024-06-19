package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main{
    public static void main(String[] args) {
//        JsonObjects();
        GsonObjects();

//        System.out.println(map.get("details"));
    }

    private static void GsonObjects() {
        String jsonString = "{\n" +
                "    \"header\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"order_id\": \"D03 TB MASTERS BERNA BEACH\",\n" +
                "            \"branch\": \"WHO\",\n" +
                "            \"submitted_by\": \"JOBERTZON STA. CATALINA\",\n" +
                "            \"salesman\": null,\n" +
                "            \"status\": \"pending\",\n" +
                "            \"date_submitted\": \"2024-06-10 15:28:57\",\n" +
                "            \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "            \"updated_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "            \"details\": [\n" +
                "                {\n" +
                "                    \"id\": 1,\n" +
                "                    \"order_id\": 1,\n" +
                "                    \"line_number\": \"1\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"SET\",\n" +
                "                    \"barcode\": \"147200005134\",\n" +
                "                    \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                    \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        // Parse JSON string to Map<String, Object>
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> data = gson.fromJson(jsonString, type);

        // Access header array
        List<Map<String, Object>> headerList = (List<Map<String, Object>>) data.get("header");
        if (headerList != null && !headerList.isEmpty()) {
            // Get the first header item
            Map<String, Object> firstHeaderItem = headerList.get(0);

            // Access details array within the first header item
            List<Map<String, Object>> detailsList = (List<Map<String, Object>>) firstHeaderItem.get("details");
            if (detailsList != null && !detailsList.isEmpty()) {
                // Get the first details item
                Map<String, Object> detailsItem = detailsList.get(0);
                System.out.println("First details item:");
                System.out.println("line_number: " + detailsItem.get("line_number"));
                System.out.println("store_loc: " + detailsItem.get("store_loc"));
                // Access other fields as needed
            }
        }
    }

    public static void JsonJackson(){
        String jsonString = "{ \"header\": [ { \"id\": 1, \"order_id\": \"D03 TB MASTERS BERNA BEACH\", \"branch\": \"WHO\", \"submitted_by\": \"JOBERTZON STA. CATALINA\", \"salesman\": null, \"status\": \"pending\", \"date_submitted\": \"2024-06-10 15:28:57\", \"created_at\": \"2024-06-10T07:28:57.000000Z\", \"updated_at\": \"2024-06-10T07:28:57.000000Z\", \"details\": [ { \"id\": 1, \"order_id\": 1, \"line_number\": \"1\", \"store_loc\": \"D03\", \"qty\": \"1\", \"uom\": \"SET\", \"barcode\": \"147200005134\", \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\", \"created_at\": \"2024-06-10T07:28:57.000000Z\", \"updated_at\": \"2024-06-10T07:28:57.000000Z\" } ] } ] }";

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = null;
        try {
            map = mapper.readValue(jsonString, HashMap.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        // Get the "header" list from the map
        List<Map<String, Object>> headerList = (List<Map<String, Object>>) map.get("header");

        // Get the first header item (since it's an array)
        if (headerList != null && !headerList.isEmpty()) {
            Map<String, Object> firstHeaderItem = headerList.get(0);
            List<Map<String, Object>> detailsList = (List<Map<String, Object>>) firstHeaderItem.get("details");
            Map<String, Object> detailsItem = detailsList.get(0);

            // Get the "details" list from the first header item

            System.out.println("----------------header----------------");
            System.out.println(firstHeaderItem.get("date_submitted"));
            System.out.println("----------------details----------------");
            System.out.println(detailsItem.get("store_loc"));
        } else {
            System.out.println("Header list is empty or null.");
        }
    }

    public static void JsonObjects(){
        String jsonString = "{ \"header\": [ { \"id\": 1, \"order_id\": \"D03 TB MASTERS BERNA BEACH\", \"branch\": \"WHO\", \"submitted_by\": \"JOBERTZON STA. CATALINA\", \"salesman\": null, \"status\": \"pending\", \"date_submitted\": \"2024-06-10 15:28:57\", \"created_at\": \"2024-06-10T07:28:57.000000Z\", \"updated_at\": \"2024-06-10T07:28:57.000000Z\", \"details\": [ { \"id\": 1, \"order_id\": 1, \"line_number\": \"1\", \"store_loc\": \"D03\", \"qty\": \"1\", \"uom\": \"SET\", \"barcode\": \"147200005134\", \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\", \"created_at\": \"2024-06-10T07:28:57.000000Z\", \"updated_at\": \"2024-06-10T07:28:57.000000Z\" } ] } ] }";

        JSONObject jsonObject = new JSONObject(jsonString);

        // Get the "header" array from the JSON object
        JSONArray headerArray = jsonObject.getJSONArray("header");

        // Get the first header item (since it's an array)
        if (headerArray.length() > 0) {
            JSONObject firstHeaderItem = headerArray.getJSONObject(0);

            // Get the "details" array from the first header item
            JSONArray detailsArray = firstHeaderItem.getJSONArray("details");

            // Get the first details item (since it's an array)
            if (detailsArray.length() > 0) {
                JSONObject detailsItem = detailsArray.getJSONObject(0);

                // Print values
                System.out.println("----------------header----------------");
                System.out.println(firstHeaderItem.getString("date_submitted"));
                System.out.println("----------------details----------------");
                System.out.println(detailsItem.getString("store_loc"));
            } else {
                System.out.println("Details array is empty.");
            }
        } else {
            System.out.println("Header array is empty.");
        }
    }

}