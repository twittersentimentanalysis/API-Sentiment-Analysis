package com.api.sentimentanalysis;

import com.api.sentimentanalysis.externalapi.EmotionAnalysisAPI;
import com.api.sentimentanalysis.externalapi.EmotionAnalysisAPIFactory;
import org.junit.Assert;
import org.junit.Test;


public class EmotionAnalysisAPIFactoryTest
{
    @Test
    void constructorTest()
    {
        EmotionAnalysisAPI emotionAnalysisAPI = EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("ParallelDots", "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        Assert.assertTrue(emotionAnalysisAPI instanceof EmotionAnalysisAPI);
    }

    @Test
    void constructorExceptionTest()
    {
        Assert.assertThrows(NullPointerException.class, () -> EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("EmotionAPI", ""));
    }
}