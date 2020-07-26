package org.example;

import com.squareup.okhttp.*;

import java.io.IOException;

public class MyOkHttpClient {

    // one instance, reuse
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static String BASE_URL = "https://scoreboard-backend-dev.herokuapp.com/scoreBoard";

    public static void sendGet() throws Exception {

        Request request = new Request.Builder()
                .url(BASE_URL+ "/all/score")
                .build();

        Response response = httpClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        // Get response body
        System.out.println(response.body().string());
    }

    static public void sendPost() throws Exception {
        String json = "{\"team\":\"team\",\"point\":500}";

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder()
                .url(BASE_URL+"/add/score")
                .post(body)
                .build();

        Call call = httpClient.newCall(request);
        Response response = call.execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        // Get response body
        System.out.println(response.body().string());
    }
}
