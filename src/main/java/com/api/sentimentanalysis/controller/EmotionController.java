package com.api.sentimentanalysis.controller;

import com.api.sentimentanalysis.externalapi.emotion.EmotionAnalysisAPI;
import com.api.sentimentanalysis.externalapi.emotion.EmotionAnalysisAPIFactory;
import com.api.sentimentanalysis.model.TextToAnalyze;
import io.swagger.annotations.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Análisis de emociones")
@RequestMapping("/api")
public class EmotionController
{
    JSONParser parser = new JSONParser();
    // EmotionAnalysisAPI emotionAnalysisAPI = EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("ParallelDots", "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");

    /*  ====================
            Method: POST
        ====================
    */
    /*  Find the emotion in a block of text */
    @PostMapping(value = "/emotion", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Obtener la emoción a partir de un texto",
                    notes = "Devuelve un json que contiene el conjunto de emociones para el texto introducido y la puntuación para cada emoción")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "OK"),                       @ApiResponse(code = 304, message = "Not Modified"),
                    @ApiResponse(code = 500, message = "Internal Server Error"),    @ApiResponse(code = 400, message = "Bad Request"),
                    @ApiResponse(code = 401, message = "Unauthorized"),             @ApiResponse(code = 403, message = "Forbidden"),
                    @ApiResponse(code = 429, message = "Too Many Requests"),        @ApiResponse(code = 406, message = "Not Acceptable")
            })
    public ResponseEntity<String> getEmotion(@ApiParam( name = "Texto", required = true,
                                                        value = "Texto a analizar (versión de prueba - sólo para texto en inglés)")
                                             @RequestBody TextToAnalyze text,
                                             @RequestHeader(name="Authorization",required = true) String token,
                                             @RequestParam Tools tool) throws Exception
    {
        EmotionAnalysisAPI emotionAnalysisAPI = EmotionAnalysisAPIFactory.getEmotionAnalysisAPI(tool.name(), token);
        String emotion = emotionAnalysisAPI.emotion(text.getText());

        JSONObject jsonText = (JSONObject)parser.parse(emotion);
        int code = jsonText.get("code") == null ? 200 : Integer.parseInt(jsonText.get("code").toString());

        return new ResponseEntity<>(emotion, HttpStatus.valueOf(code));
    }

    /* Machine Learning Tools */
    public enum Tools {
        ParallelDots,
        BERT;
    }
}
