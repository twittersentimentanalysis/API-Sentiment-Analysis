package com.api.sentimentanalysis.model;

import io.swagger.annotations.ApiModelProperty;

public class Lang
{
    @ApiModelProperty(notes = "from", example = "en")
    String from;

    @ApiModelProperty (notes = "to", example = "es")
    String to;

    public String getFrom()
    {
        return from;
    }
    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }
    public void setTo(String to)
    {
        this.to = to;
    }
}
