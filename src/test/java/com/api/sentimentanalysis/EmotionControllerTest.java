package com.api.sentimentanalysis;

import com.api.sentimentanalysis.controller.EmotionController;
import com.api.sentimentanalysis.model.TextToAnalyze;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EmotionController.class)
public class EmotionControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Test
    public void getEmotionTest() throws Exception
    {
        TextToAnalyze text = new TextToAnalyze();
        text.setText("text");

        mvc.perform(post("/api/emotion")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(text)))
            .andExpect(status().isOk());
    }
}


