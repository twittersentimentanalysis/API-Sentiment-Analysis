package com.api.sentimentanalysis.externalapi.translator;

import org.json.simple.parser.ParseException;
import java.io.IOException;

/** Interface for translator in factory pattern.
 *
 * @author Ariadna de Arriba
 */
public interface TranslatorAPI
{
    /** Make a request to translator API to translate a text.
     *
     * @param text Text to translate.
     * @param lang_src Language of the original text. For example: 'en'.
     * @param lang_dest Language to translate the text. For example: 'es'.
     * @return Returns a string which represents a json with the translated text.
     * @throws ParseException {@link ParseException caused parsing the json.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    String translate(String text, String lang_src, String lang_dest) throws IOException, ParseException;
}
