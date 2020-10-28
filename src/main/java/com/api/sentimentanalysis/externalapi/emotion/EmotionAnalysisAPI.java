package com.api.sentimentanalysis.externalapi.emotion;

import java.io.IOException;

/** Interface for getEmotion analysis in factory pattern.
 *
 * @author Ariadna de Arriba
 */
public interface EmotionAnalysisAPI
{
    /** Make a request to ML tool for sentiment analysis.
     *
     * @param text Text to analyze.
     * @return Returns a string that contains a json with each of six emotions weighted.
     * @throws NullPointerException {@link NullPointerException caused by an error during a call to the API and returns nothing.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    String getEmotion(String text) throws NullPointerException, IOException;
}
