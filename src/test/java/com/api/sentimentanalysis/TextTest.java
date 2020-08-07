package com.api.sentimentanalysis;

import com.api.sentimentanalysis.model.TextToAnalyze;
import org.junit.Assert;
import org.junit.Test;


public class TextTest
{
    @Test
    public void setTextTest()
    {
        TextToAnalyze text = new TextToAnalyze();
        text.setText("hola");
        Assert.assertNotNull(text);
    }

    @Test
    public void getTextTest()
    {
        TextToAnalyze text = new TextToAnalyze();
        text.setText("hola");
        Assert.assertEquals("hola", text.getText());
    }
}
