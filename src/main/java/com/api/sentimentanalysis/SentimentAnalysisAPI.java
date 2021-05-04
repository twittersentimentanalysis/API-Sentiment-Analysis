package com.api.sentimentanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/** Runner class
 *
 * @author Ariadna de Arriba
 */
@SpringBootApplication
public class SentimentAnalysisAPI extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(SentimentAnalysisAPI.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(SentimentAnalysisAPI.class, args);
    }
}
