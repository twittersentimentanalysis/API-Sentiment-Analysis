package com.api.sentimentanalysis.controller;

import com.api.sentimentanalysis.externalapi.translator.TranslatorAPI;
import com.api.sentimentanalysis.externalapi.translator.TranslatorAPIFactory;
import com.api.sentimentanalysis.model.TextToTranslate;
import io.swagger.annotations.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/** Controller for /translator endpoint in sentiment analysis API.
 *
 * @author Ariadna de Arriba
 */
@RestController
@Api(tags = "Traductor")
@RequestMapping("/api")
public class TranslatorController
{
    JSONParser parser = new JSONParser();

    /** POST - Translate a block of text.
     *
     * @param text Text to translate
     * @param token Bearer token for authorization.
     * @param translator Translator for sentiment analysis.
     * @return Returns a ResponseEntity that contains the result of calling this POST method.
     * @throws ParseException {@link ParseException caused parsing the json.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    @PostMapping(value = "/translator", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtener la traducción de un texto",
            notes = "Devuelve un json que contiene el texto traducido")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "OK"),                       @ApiResponse(code = 304, message = "Not Modified"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),             @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 429, message = "Too Many Requests"),        @ApiResponse(code = 406, message = "Not Acceptable")
            })
    public ResponseEntity<String> translate(@ApiParam(name = "Texto", required = true, value = "Texto a traducir")
                                             @RequestBody TextToTranslate text,
                                             @RequestHeader(name="Authorization",required = true) String token,
                                             @RequestParam Translators translator) throws IOException, ParseException
    {
        TranslatorAPI translatorAPI = TranslatorAPIFactory.getTranslatorAPI(translator.name(), token);
        String translation = translatorAPI.translate(text.getText(), text.getLanguage().getFrom(), text.getLanguage().getTo());

        JSONObject jsonText = (JSONObject)parser.parse(translation);
        int code = jsonText.get("code") == null ? 200 : Integer.parseInt(jsonText.get("code").toString());

        return new ResponseEntity<>(translation, HttpStatus.valueOf(code));
    }

    /** Available Translators.
     *  {@link #Microsoft}
     */
    public enum Translators {
        Microsoft;
    }
}
