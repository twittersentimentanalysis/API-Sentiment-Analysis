# API Sentiment Analysis
[![Build status](https://travis-ci.com/ariadnadearriba/API-Sentiment-Analysis.svg?branch=staging)](https://travis-ci.com/ariadnadearriba/API-Sentiment-Analysis)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=alert_status)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=code_smells)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=coverage)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=bugs)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=ariadnadearriba_API-Sentiment-Analysis&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=ariadnadearriba_API-Sentiment-Analysis)

A RESTFul API for Sentiment Analysis in Spanish.

## How to run 
### Local
1. Clone this project to a local folder and go to root folder

   `git clone https://github.com/twittersentimentanalysis/API-Sentiment-Analysis.git`

2. Build the Spring Boot project with Maven

    `mvn clean install`
    
3. Run the project

    `mvn spring-boot:run`
    
4. Go to http://localhost:8080/swagger-ui.html and test the API


### Tomcat
1. Clone this project to a local folder and go to root folder

   `git clone https://github.com/twittersentimentanalysis/API-Sentiment-Analysis.git`

2. Build the Spring Boot project with Maven to generate a WAR file

    `mvn clean package`
    
3. Go to http://localhost:8080/manager/html

4. Load generated WAR file into section "Deploy > WAR file to deploy" and click on "Deploy"

    > *By default generated WAR file is saved on `target` folder in the root project folder*

5. Go to http://localhost:8080/sentiment-analysis-api/swagger-ui.html and test the API