/**
 * Content Negotiation on All Request, depends on URI mediaType Param
 */

package com.techie.springbootdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //URI : localhost:8080/employees?mediaType=xml

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer.favorParameter(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml",MediaType.APPLICATION_XML)
                .mediaType("json",MediaType.APPLICATION_JSON);
    }


}
