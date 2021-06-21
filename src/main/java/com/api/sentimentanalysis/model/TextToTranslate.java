package com.api.sentimentanalysis.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Class that represents a json for calls in http methods to translate a block of text.
 *
 * @author Ariadna de Arriba
 */
@ApiModel (description = "Texto a traducir")
public class TextToTranslate
{
    @ApiModelProperty ( notes = "text",
            example = "Covid19 sucks but during this year I've lived moments I'll never forget, it's helped me a lot in my personal growth")
    String text;

    @ApiModelProperty ( notes = "language")
    Lang language;

    /** Getter for text to translate.
     *
     * @return Returns a string with text to translate.
     */
    public String getText()
    {
        return text;
    }

    /** Setter for text to translate.
     *
     * @param text Text to translate.
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /** Getter for Lang class.
     *
     * @return Returns an instance of Lang class.
     */
    public Lang getLanguage()
    {
        return language;
    }

    /** Setter for Lang class.
     *
     * @param language Lang instance.
     */
    public void setLanguage(Lang language)
    {
        this.language = language;
    }
}

