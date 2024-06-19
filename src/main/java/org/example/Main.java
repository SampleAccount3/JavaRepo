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

        String api =  apiKuno();
//        System.out.println(api);
//        sampleNestedMapping();
        JSONObject jO = new JSONObject(api);
        JSONArray headersArray = jO.getJSONArray("header");
        JSONArray detailsArray = jO.getJSONArray("details");
        System.out.println("Headers Array: "+headersArray);
        System.out.println("Details Array: "+detailsArray);

    }

    private static void sampleNestedMapping() {
        // Create the outer HashMap
        HashMap<String, HashMap<String, String>> outerMap = new HashMap<>();

        // Create the first inner HashMap
        HashMap<String, String> innerMap1 = new HashMap<>();
        innerMap1.put("innerKey1", "value1");
        innerMap1.put("innerKey2", "value2");

        // Create the second inner HashMap
        HashMap<String, String> innerMap2 = new HashMap<>();
        innerMap2.put("innerKeyA", "valueA");
        innerMap2.put("innerKeyB", "valueB");

        // Put the inner HashMaps into the outer HashMap
        outerMap.put("outerKey1", innerMap1);
        outerMap.put("outerKey2", innerMap2);

        // Accessing the values
        System.out.println("Outer Map: " + outerMap);
        System.out.println("Outer Map -> outerKey1: " + outerMap.get("outerKey1"));
        System.out.println("Outer Map -> outerKey1 -> innerKey1: " + outerMap.get("outerKey1").get("innerKey1"));
        System.out.println("Outer Map -> outerKey2 -> innerKeyA: " + outerMap.get("outerKey2").get("innerKeyA"));

        // Iterating through the nested HashMap
        for (Map.Entry<String, HashMap<String, String>> outerEntry : outerMap.entrySet()) {
            String outerKey = outerEntry.getKey();
            HashMap<String, String> innerMap = outerEntry.getValue();
            System.out.println("Outer Key: " + outerKey);

            for (Map.Entry<String, String> innerEntry : innerMap.entrySet()) {
                String innerKey = innerEntry.getKey();
                String value = innerEntry.getValue();
                System.out.println("\tInner Key: " + innerKey + ", Value: " + value);
            }
        }
    }

    private static String apiKuno() {
        return  "{\n" +
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
                "                },\n" +
                "                {\n" +
                "                    \"id\": 2,\n" +
                "                    \"order_id\": 1,\n" +
                "                    \"line_number\": \"2\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": null,\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": null,\n" +
                "                    \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 3,\n" +
                "                    \"order_id\": 1,\n" +
                "                    \"line_number\": \"3\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": null,\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": null,\n" +
                "                    \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 4,\n" +
                "                    \"order_id\": 1,\n" +
                "                    \"line_number\": \"4\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"157500002040\",\n" +
                "                    \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                    \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"order_id\": \"D03 TB MASTERS BERNA BEACH\",\n" +
                "            \"branch\": \"WHO\",\n" +
                "            \"submitted_by\": \"JOBERTZON STA. CATALINA\",\n" +
                "            \"salesman\": null,\n" +
                "            \"status\": \"pending\",\n" +
                "            \"date_submitted\": \"2024-06-11 09:46:32\",\n" +
                "            \"created_at\": \"2024-06-11T01:46:32.000000Z\",\n" +
                "            \"updated_at\": \"2024-06-11T01:46:32.000000Z\",\n" +
                "            \"details\": [\n" +
                "                {\n" +
                "                    \"id\": 5,\n" +
                "                    \"order_id\": 2,\n" +
                "                    \"line_number\": \"1\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"SET\",\n" +
                "                    \"barcode\": \"147200005134\",\n" +
                "                    \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                    \"created_at\": \"2024-06-11T01:46:34.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T01:46:34.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 6,\n" +
                "                    \"order_id\": 2,\n" +
                "                    \"line_number\": \"2\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                    \"created_at\": \"2024-06-11T01:46:35.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T01:46:35.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 7,\n" +
                "                    \"order_id\": 2,\n" +
                "                    \"line_number\": \"3\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                    \"created_at\": \"2024-06-11T01:46:35.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T01:46:35.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 8,\n" +
                "                    \"order_id\": 2,\n" +
                "                    \"line_number\": \"4\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"157500002040\",\n" +
                "                    \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                    \"created_at\": \"2024-06-11T01:46:36.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T01:46:36.000000Z\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"order_id\": \"D03 TB MASTERS BERNA BEACH\",\n" +
                "            \"branch\": \"WHO\",\n" +
                "            \"submitted_by\": \"JOBERTZON STA. CATALINA\",\n" +
                "            \"salesman\": null,\n" +
                "            \"status\": \"pending\",\n" +
                "            \"date_submitted\": \"2024-06-11 10:07:13\",\n" +
                "            \"created_at\": \"2024-06-11T02:07:13.000000Z\",\n" +
                "            \"updated_at\": \"2024-06-11T02:07:13.000000Z\",\n" +
                "            \"details\": [\n" +
                "                {\n" +
                "                    \"id\": 9,\n" +
                "                    \"order_id\": 3,\n" +
                "                    \"line_number\": \"1\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"SET\",\n" +
                "                    \"barcode\": \"147200005134\",\n" +
                "                    \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                    \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 10,\n" +
                "                    \"order_id\": 3,\n" +
                "                    \"line_number\": \"2\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                    \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 11,\n" +
                "                    \"order_id\": 3,\n" +
                "                    \"line_number\": \"3\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"111040000081\",\n" +
                "                    \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                    \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 12,\n" +
                "                    \"order_id\": 3,\n" +
                "                    \"line_number\": \"4\",\n" +
                "                    \"store_loc\": \"D03\",\n" +
                "                    \"qty\": \"1\",\n" +
                "                    \"uom\": \"PC\",\n" +
                "                    \"barcode\": \"157500002040\",\n" +
                "                    \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                    \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                    \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"details\": [\n" +
                "        [\n" +
                "            {\n" +
                "                \"id\": 1,\n" +
                "                \"order_id\": 1,\n" +
                "                \"line_number\": \"1\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"SET\",\n" +
                "                \"barcode\": \"147200005134\",\n" +
                "                \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 2,\n" +
                "                \"order_id\": 1,\n" +
                "                \"line_number\": \"2\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": null,\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": null,\n" +
                "                \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 3,\n" +
                "                \"order_id\": 1,\n" +
                "                \"line_number\": \"3\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": null,\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": null,\n" +
                "                \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 4,\n" +
                "                \"order_id\": 1,\n" +
                "                \"line_number\": \"4\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"157500002040\",\n" +
                "                \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                \"created_at\": \"2024-06-10T07:28:57.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-10T07:28:57.000000Z\"\n" +
                "            }\n" +
                "        ],\n" +
                "        [\n" +
                "            {\n" +
                "                \"id\": 5,\n" +
                "                \"order_id\": 2,\n" +
                "                \"line_number\": \"1\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"SET\",\n" +
                "                \"barcode\": \"147200005134\",\n" +
                "                \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                \"created_at\": \"2024-06-11T01:46:34.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T01:46:34.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 6,\n" +
                "                \"order_id\": 2,\n" +
                "                \"line_number\": \"2\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                \"created_at\": \"2024-06-11T01:46:35.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T01:46:35.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 7,\n" +
                "                \"order_id\": 2,\n" +
                "                \"line_number\": \"3\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                \"created_at\": \"2024-06-11T01:46:35.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T01:46:35.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 8,\n" +
                "                \"order_id\": 2,\n" +
                "                \"line_number\": \"4\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"157500002040\",\n" +
                "                \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                \"created_at\": \"2024-06-11T01:46:36.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T01:46:36.000000Z\"\n" +
                "            }\n" +
                "        ],\n" +
                "        [\n" +
                "            {\n" +
                "                \"id\": 9,\n" +
                "                \"order_id\": 3,\n" +
                "                \"line_number\": \"1\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"SET\",\n" +
                "                \"barcode\": \"147200005134\",\n" +
                "                \"desc\": \"POZZI/BTUB PALM SPRING (BN-406\",\n" +
                "                \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 10,\n" +
                "                \"order_id\": 3,\n" +
                "                \"line_number\": \"2\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 11,\n" +
                "                \"order_id\": 3,\n" +
                "                \"line_number\": \"3\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"111040000081\",\n" +
                "                \"desc\": \"POZZI YS-60012 DOUBLE TOWEL BA\",\n" +
                "                \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 12,\n" +
                "                \"order_id\": 3,\n" +
                "                \"line_number\": \"4\",\n" +
                "                \"store_loc\": \"D03\",\n" +
                "                \"qty\": \"1\",\n" +
                "                \"uom\": \"PC\",\n" +
                "                \"barcode\": \"157500002040\",\n" +
                "                \"desc\": \"GROHE 39310000 EUROSTYLE 1PC S\",\n" +
                "                \"created_at\": \"2024-06-11T02:07:14.000000Z\",\n" +
                "                \"updated_at\": \"2024-06-11T02:07:14.000000Z\"\n" +
                "            }\n" +
                "        ]\n" +
                "    ]\n" +
                "}";
    }

    static class Header{
        private String id;
        private String order_id;
        private String branch;
        private String submitted_by;
        private String salesman;
        private String status;
        private  String date_submitted;
        private  String created_at;
        private  String updated_at;
        Details details;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getBranch() {
            return branch;
        }

        public void setBranch(String branch) {
            this.branch = branch;
        }

        public String getSubmitted_by() {
            return submitted_by;
        }

        public void setSubmitted_by(String submitted_by) {
            this.submitted_by = submitted_by;
        }

        public String getSalesman() {
            return salesman;
        }

        public void setSalesman(String salesman) {
            this.salesman = salesman;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate_submitted() {
            return date_submitted;
        }

        public void setDate_submitted(String date_submitted) {
            this.date_submitted = date_submitted;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Details getDetails() {
            return details;
        }

        public void setDetails(Details details) {
            this.details = details;
        }
    }
    static class Details{
        private String id;
        private String order_id;
        private String line_number;
        private String store_loc;
        private String qty;
        private String uom;
        private String barcode;
        private String desc;
        private String created_at;
        private String updated_at;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getLine_number() {
            return line_number;
        }

        public void setLine_number(String line_number) {
            this.line_number = line_number;
        }

        public String getStore_loc() {
            return store_loc;
        }

        public void setStore_loc(String store_loc) {
            this.store_loc = store_loc;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}