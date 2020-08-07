package com.api.sentimentanalysis.externalapi.translator;

public interface TranslatorAPI
{
    String translate(String text, String lang_src, String lang_dest) throws Exception;
}
