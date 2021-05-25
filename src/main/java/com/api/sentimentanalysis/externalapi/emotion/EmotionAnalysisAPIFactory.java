package com.api.sentimentanalysis.externalapi.emotion;

/** Class to instantiate a machine learning tool class in factory pattern.
 *
 * @author Ariadna de Arriba
 */
public class EmotionAnalysisAPIFactory
{
    /** Factory pattern to instantiate a machine learning tool class.
     *
     * @param tool Machine learning tool.
     * @param apiKey Api-key to authorize the method.
     * @return Returns an instance of the ML tool class.
     */
    public static EmotionAnalysisAPI getEmotionAnalysisAPI(String tool, String apiKey)
    {
        if ("ParallelDots".equalsIgnoreCase(tool)) return new ParallelDots(apiKey);
        if ("BERT".equalsIgnoreCase(tool)) return new BERT(apiKey, true);
        if ("BETO".equalsIgnoreCase(tool)) return new BERT(apiKey, false);
        if ("SVC".equalsIgnoreCase(tool)) return new SVC(apiKey);
        throw new NullPointerException("No api with this name");
    }
}
