package com.api.sentimentanalysis.externalapi;

public class EmotionAnalysisAPIFactory
{
    public static EmotionAnalysisAPI getEmotionAnalysisAPI(String API, String apiKey)
    {
        if ("ParallelDots".equalsIgnoreCase(API)) return new ParallelDots(apiKey);
        return null;
    }
}
