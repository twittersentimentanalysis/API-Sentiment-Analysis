package com.api.sentimentanalysis.externalapi.translator;

import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/** This class contains a method to translate a text with Microsoft API.
 *
 * @author Ariadna de Arriba
 */
public class Microsoft implements TranslatorAPI
{
    private String apiKey;
    private String host = "https://api.cognitive.microsofttranslator.com";

    /** Constructor.
     *
     * @param apiKey Api-key to authorize the method.
     */
    public Microsoft(String apiKey)
    {
        this.apiKey = apiKey;
    }

    /** Make a request to Microsoft translator API to translate a text.
     *
     * @param text Text to translate.
     * @param lang_src Language of the original text. For example: 'en'
     * @param lang_dest Language to translate the text. For example: 'es'
     * @return Returns a string which represents a json with the translated text.
     * @throws ParseException {@link ParseException caused parsing the json.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    @Override
    public String translate(String text, String lang_src, String lang_dest) throws IOException, ParseException
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
                .addHeader("Ocp-Apim-Subscription-Region", "westeurope")
                .addHeader("Content-type", "application/json").build();

        Response response = client.newCall(request).execute();

        return prettifyJSON(response, response.code());
    }

    /** Method that transforms a string to a pretty json.
     *
     * @param response Response of the call to post method to translate a text.
     * @param statusCode Status code of the response.
     * @return A json with translation and source and target language codes OR the status code and error message.
     * @throws IOException
     * @throws ParseException
     */
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