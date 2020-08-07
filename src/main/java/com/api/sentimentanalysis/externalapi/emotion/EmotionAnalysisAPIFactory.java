package com.api.sentimentanalysis.externalapi.emotion;

public class EmotionAnalysisAPIFactory
{
    public static EmotionAnalysisAPI getEmotionAnalysisAPI(String api, String apiKey)
    {
        if ("ParallelDots".equalsIgnoreCase(api)) return new ParallelDots(apiKey);
        if ("BERT".equalsIgnoreCase(api)) return new BERT(apiKey);
        throw new NullPointerException("No api with this name");
    }
}
