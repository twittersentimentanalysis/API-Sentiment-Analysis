package com.api.sentimentanalysis.controller;

import com.api.sentimentanalysis.externalapi.EmotionAnalysisAPI;
import com.api.sentimentanalysis.externalapi.EmotionAnalysisAPIFactory;
import com.api.sentimentanalysis.externalapi.ParallelDots;
import io.swagger.annotations.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
@Api(tags = "Análisis de emociones")
@RequestMapping("/api")
public class MainController
{
    JSONParser parser = new JSONParser();
    // APIKey = "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8";
    EmotionAnalysisAPI emotionAnalysisAPI = EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("ParallelDots", "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");

    public MainController() throws ParseException
    {
    }


    /*  ====================
            Method: POST
        ====================
    */
    /*  Find the emotion in a block of text */
    @PostMapping(value = "/emotion", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtener la emoción a partir de un texto", notes = "Devuelve un json que contiene el conjunto de emociones para el texto introducido y la puntuación para cada emoción")
    @ApiResponses(value =
        {
            @ApiResponse(code = 200, message = "OK"),                       @ApiResponse(code = 304, message = "Not Modified"),
            @ApiResponse(code = 500, message = "Internal Server Error"),    @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),             @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 429, message = "Too Many Requests"),        @ApiResponse(code = 406, message = "Not Acceptable")
        })
    public ResponseEntity getEmotion(@ApiParam( name = "Texto", value = "Texto a analizar (versión de prueba - sólo para texto en inglés)", required = true,
                                                example = "This song is incredible",
                                                examples = @Example(value = {
                                                    @ExampleProperty
                                                        ("In a statement issued with France and UN chief António Guterres on Saturday, China committed to “update” " +
                                                        "its climate target “in a manner representing a progression beyond the current one”.  It also vowed to publish " +
                                                        "a long term decarbonisation strategy by next year.")
                                                }))
                                     @RequestBody String text) throws Exception
    {
        String emotion_multilang = emotionAnalysisAPI.emotion(text);

        JSONObject jsonText = (JSONObject)parser.parse(emotion_multilang);
        Integer code = jsonText.get("code") == null ? 200 : Integer.parseInt(jsonText.get("code").toString());

        return new ResponseEntity<String>(emotion_multilang, HttpStatus.valueOf(code));
    }
}
