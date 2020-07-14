package com.api.sentimentanalysis;

import com.api.sentimentanalysis.model.Text;
import org.junit.Assert;
import org.junit.Test;


public class TextTest
{
    @Test
    void setTextTest()
    {
        Text text = new Text();
        text.setTextToAnalyze("hola");
        Assert.assertNotNull(text);
    }

    @Test
    void getTextTest()
    {
        Text text = new Text();
        text.setTextToAnalyze("hola");
        Assert.assertEquals("hola", text.getTextToAnalyze());
    }
}
