package com.api.sentimentanalysis;

import com.api.sentimentanalysis.externalapi.emotion.EmotionAnalysisAPI;
import com.api.sentimentanalysis.externalapi.emotion.EmotionAnalysisAPIFactory;
import org.junit.Assert;
import org.junit.Test;


public class EmotionAnalysisAPIFactoryTest
{
    @Test
    public void constructorTest()
    {
        EmotionAnalysisAPI emotionAnalysisAPI = EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("ParallelDots", "hMHL3owGxJxbn6h6RQtCEyscYchzejmhVnPkdKoNax8");
        Assert.assertTrue(emotionAnalysisAPI instanceof EmotionAnalysisAPI);
    }

    @Test
    public void constructorExceptionTest()
    {
        Assert.assertThrows(NullPointerException.class, () -> EmotionAnalysisAPIFactory.getEmotionAnalysisAPI("EmotionAPI", ""));
    }
}