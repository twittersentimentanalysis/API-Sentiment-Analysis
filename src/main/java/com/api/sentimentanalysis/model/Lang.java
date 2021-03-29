package com.api.sentimentanalysis.model;

import io.swagger.annotations.ApiModelProperty;

/** Class that represents a json returned in http methods. <br>
 * Example:                          <br>
 *  &emsp;          lang: {          <br>
 *  &emsp; &emsp;       from: "en"   <br>
 *  &emsp; &emsp;      to: "es"      <br>
 *  &emsp;          }
 *
 * @author Ariadna de Arriba
 */
public class Lang
{
    @ApiModelProperty(notes = "from", example = "en")
    String from;

    @ApiModelProperty (notes = "to", example = "es")
    String to;

    /** Getter for 'from' param.
     *
     * @return String containing source language code.
     */
    public String getFrom()
    {
        return from;
    }

    /** Setter for 'from' param.
     *
     * @param from Source language code.
     */
    public void setFrom(String from)
    {
        this.from = from;
    }

    /** Getter for 'to' param.
     *
     * @return String containing target language code.
     */
    public String getTo()
    {
        return to;
    }

    /** Setter for 'to' param.
     *
     * @param to Target language code.
     */
    public void setTo(String to)
    {
        this.to = to;
    }
}
