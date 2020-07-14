package com.api.sentimentanalysis;

import com.api.sentimentanalysis.controller.MainController;
import com.api.sentimentanalysis.model.Text;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest
{
    @Autowired
    private MockMvc mvc;

    @Test
    public void getEmotionTest() throws Exception
    {
        Text text = new Text();
        text.setTextToAnalyze("text");

        mvc.perform(post("/api/emotion")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(text)))
            .andExpect(status().isOk());
    }
}


