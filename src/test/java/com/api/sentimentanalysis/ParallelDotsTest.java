package com.api.sentimentanalysis;

import com.api.sentimentanalysis.externalapi.emotion.ParallelDots;
import com.api.sentimentanalysis.model.TextToAnalyze;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParallelDotsTest
{
    @Test
    public void constructorTest()
    {
        ParallelDots parallelDots = new ParallelDots("hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        Assert.assertTrue(parallelDots instanceof ParallelDots);
    }

    @Test
    public void setUpCertTest()
    {
        String apiKey = "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8";
        assertDoesNotThrow(() -> new ParallelDots(apiKey));
    }

    @Test
    public void emotionTest() throws Exception
    {
        ParallelDots parallelDots = new ParallelDots("hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        String text = "I am trying to imagine you with a personality";

        String emotion = parallelDots.getEmotion(text);
        String expected = "{\"getEmotion\":{\"happy\":0.999943,\"sad\":0.000003,\"angry\":0.000001,\"fear\":0.000012,\"excited\":0.000022,\"indifferent\":0.000018}}";

        assertEquals(emotion, expected);
    }

    @Test
    public void getEmotionTest() throws Exception
    {
        TextToAnalyze text = new TextToAnalyze();
        text.setText("text");
    }

    @Test
    public void emotionExceptionTest()
    {
        ParallelDots parallelDots = new ParallelDots(null);
        assertThrows(NullPointerException.class, () -> parallelDots.getEmotion("Text to analyze"));
    }
}