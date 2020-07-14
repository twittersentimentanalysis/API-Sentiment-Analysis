package com.api.sentimentanalysis;

import com.api.sentimentanalysis.externalapi.ParallelDots;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParallelDotsTest
{
    @Test
    void constructorTest()
    {
        ParallelDots parallelDots = new ParallelDots("hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        Assert.assertTrue(parallelDots instanceof ParallelDots);
    }

    @Test
    void setUpCertTest()
    {
        String apiKey = "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8";
        assertDoesNotThrow(() -> new ParallelDots(apiKey));
    }

    @Test
    void emotionTest() throws Exception
    {
        ParallelDots parallelDots = new ParallelDots("hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        String text = "I am trying to imagine you with a personality";

        String emotion = parallelDots.emotion(text);
        String expected = "{\"emotion\":{\"happy\":0.999943,\"sad\":0.000003,\"angry\":0.000001,\"fear\":0.000012,\"excited\":0.000022,\"indifferent\":0.000018}}";

        assertEquals(emotion, expected);
    }

    @Test
    void emotionExceptionTest()
    {
        ParallelDots parallelDots = new ParallelDots(null);
        assertThrows(NullPointerException.class, () -> parallelDots.emotion("Text to analyze"));
    }
}