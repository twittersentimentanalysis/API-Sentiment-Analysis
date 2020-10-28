package com.api.sentimentanalysis.externalapi.translator;

public class TranslatorAPIFactory
{
    /** Factory pattern to instantiate a translator class.
     *
     * @param translator Translator API.
     * @param apiKey Api-key to authorize the method.
     * @return Returns an instance of the translator class.
     */
    public static TranslatorAPI getTranslatorAPI(String translator, String apiKey)
    {
        if ("Microsoft".equalsIgnoreCase(translator)) return new Microsoft(apiKey);
        throw new NullPointerException("No api with this name");
    }
}
