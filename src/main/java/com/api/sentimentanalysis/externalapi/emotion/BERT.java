package com.api.sentimentanalysis.externalapi.emotion;

import okhttp3.*;
import org.json.simple.JSONObject;

public class BERT implements EmotionAnalysisAPI
{
    private String apiKey;
    private String host = "http://127.0.0.1:5000/api/v1/";

    public BERT(String apiKey)
    {
        this.apiKey = apiKey;
    }

    @Override
    public String emotion(String text) throws Exception
    {
        if (this.apiKey != null)
        {
            String url = host + "emotion";
            OkHttpClient client = new OkHttpClient();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("text", text);
            String json = jsonObject.toString();

            RequestBody requestBody = RequestBody.create(
                    json,
                    MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-api-key", apiKey)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } else
        {
            throw new NullPointerException("No api-key provided");
        }
    }
}