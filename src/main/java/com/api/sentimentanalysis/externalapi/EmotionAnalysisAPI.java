package com.api.sentimentanalysis.externalapi;

public interface EmotionAnalysisAPI
{
    String emotion(String text) throws Exception;
}
