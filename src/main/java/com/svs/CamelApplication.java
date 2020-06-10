package com.svs;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelApplication extends RouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(CamelApplication.class, args);
    }

    @Override
    public void configure() throws Exception {

        // this will copy file from one location to another
        from("file:C:/Users/sagar.vitthal.sawant/OneDrive - Accenture/Desktop/New folder/CVs/a").
                to("file:C:/Users/sagar.vitthal.sawant/OneDrive - Accenture/Desktop/New folder/b");
    }
}
