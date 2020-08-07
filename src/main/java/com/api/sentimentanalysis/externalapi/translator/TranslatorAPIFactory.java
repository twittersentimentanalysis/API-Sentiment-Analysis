package com.api.sentimentanalysis.externalapi.translator;

public class TranslatorAPIFactory
{
    public static TranslatorAPI getTranslatorAPI(String api, String apiKey)
    {
        if ("Microsoft".equalsIgnoreCase(api)) return new Microsoft(apiKey);
        throw new NullPointerException("No api with this name");
    }
}
