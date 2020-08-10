package com.api.sentimentanalysis.externalapi.translator;


import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Microsoft implements TranslatorAPI
{
    private String apiKey;
    private String host = "https://api.cognitive.microsofttranslator.com";

    public Microsoft(String apiKey)
    {
        this.apiKey = apiKey;
    }


    @Override
    public String translate(String text, String lang_src, String lang_dest) throws Exception
    {

        String url = host + "/translate?api-version=3.0&to=" + lang_dest;

        // Instantiates the OkHttpClient.
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Text", text);
        jsonArray.add(jsonObject);

        RequestBody body = RequestBody.create(jsonArray.toString(), mediaType);

        Request request = new Request.Builder()
                .url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", apiKey)
                .addHeader("Content-type", "application/json").build();

        Response response = client.newCall(request).execute();

        return prettifyJSON(response, response.code());
    }

    private String prettifyJSON (Response response, Integer statusCode) throws IOException, ParseException
    {
        JSONParser parser = new JSONParser();
        JSONObject prettyJSON = new JSONObject();

        if (statusCode == 200)
        {
            JSONArray jsonBodyArray = (JSONArray) parser.parse(response.body().string());
            JSONObject jsonBodyObject = (JSONObject) jsonBodyArray.get(0);
            JSONObject jsonLanguage = (JSONObject) jsonBodyObject.get("detectedLanguage");
            JSONArray jsonTransArray = (JSONArray) jsonBodyObject.get("translations");
            JSONObject jsonTransObject = (JSONObject) jsonTransArray.get(0);

            String translatedText = jsonTransObject.get("text").toString();
            String lang_src = jsonLanguage.get("language").toString();
            String lang_dest = jsonTransObject.get("to").toString();

            prettyJSON.put("from", lang_src);
            prettyJSON.put("to", lang_dest);
            prettyJSON.put("translation", translatedText);
        }
        else
        {
            JSONObject jsonBodyObject = (JSONObject) parser.parse(response.body().string());
            JSONObject jsonError = (JSONObject) jsonBodyObject.get("error");

            String message = jsonError.get("message").toString();

            prettyJSON.put("code", statusCode);
            prettyJSON.put("message", message);
        }

        return prettyJSON.toString();
    }
}