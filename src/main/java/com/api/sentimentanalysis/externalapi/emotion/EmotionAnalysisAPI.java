package com.api.sentimentanalysis.externalapi.emotion;

public interface EmotionAnalysisAPI
{
    String emotion(String text) throws Exception;
}
