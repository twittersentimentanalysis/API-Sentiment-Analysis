package com.api.sentimentanalysis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel (description = "Texto a analizar")
public class TextToAnalyze
{
    @ApiModelProperty ( notes = "text",
                        example = "In a statement issued with France and UN chief António Guterres on Saturday, China committed to “update” " +
                                    "its climate target “in a manner representing a progression beyond the current one”.  It also vowed to publish " +
                                    "a long term decarbonisation strategy by next year.")
    String text;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
