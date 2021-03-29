package com.api.sentimentanalysis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Class that represents a json for calls in http methods to apply getEmotion analysis.
 *
 * @author Ariadna de Arriba
 */
@ApiModel (description = "Texto a analizar")
public class TextToAnalyze
{
    @ApiModelProperty ( notes = "text",
                        example = "In a statement issued with France and UN chief António Guterres on Saturday, China committed to \"update\" " +
                                    "its climate target \"in a manner representing a progression beyond the current one\".  It also vowed to publish " +
                                    "a long term decarbonisation strategy by next year.")
    String text;

    /** Getter for text to analyze.
     *
     * @return Returns a string with text to analyze.
     */
    public String getText()
    {
        return text;
    }

    /** Setter for text to analyze.
     *
     * @param text Text to analyze.
     */
    public void setText(String text)
    {
        this.text = text;
    }
}
