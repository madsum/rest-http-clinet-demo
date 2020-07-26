package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ApacheHttpClient {
    // one instance, reuse
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static String BASE_URL = "https://scoreboard-backend-dev.herokuapp.com/scoreBoard";

    public static void sendGet(URI url) throws Exception {
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            // return it as a String
            String result = EntityUtils.toString(entity);
            // System.out.println(result);
            List<Plant> pp = convertJsonStringToObject(result, 2, 6);

            ObjectMapper objectMapper = new ObjectMapper();
            String all = objectMapper.writeValueAsString(pp);
            System.out.println(all);
        }
    }

    static List<Plant> convertJsonStringToObject(String jsonString, int start, int end) {
        List<Plant> allPlants = new ArrayList<>();
        JSONObject root = new JSONObject(jsonString);

        JSONArray plants = root.getJSONArray("plants");

        for (int i = 0; i < plants.length(); i++) {
            JSONObject jsonPlant = plants.getJSONObject(i);
            Plant plant = new Plant();
            plant.setId(jsonPlant.getInt(Plant.KEY_ID));
            plant.setGenus(jsonPlant.getString(Plant.KEY_GENUS));
            plant.setCommon(jsonPlant.getString(Plant.KEY_COMMON));
            plant.setCultivar(jsonPlant.getString(Plant.KEY_CULTIVAR));
            plant.setSpecies(jsonPlant.getString(Plant.KEY_SPECIES));
            allPlants.add(plant);
        }
        return allPlants.subList(start, end);
    }

    static public void sendPost() throws IOException {

        HttpPost httpPost = new HttpPost(BASE_URL + "/add/score");

        String json = "{\"team\":\"my team\",\"point\":600}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = httpClient.execute(httpPost);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IOException("Unexpected code " + response);
        }
        // Get response body
        System.out.println(response.getEntity());
    }


}
