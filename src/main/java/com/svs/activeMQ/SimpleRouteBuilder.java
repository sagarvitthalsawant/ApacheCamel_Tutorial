package com.svs.activeMQ;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //Splitter EIP
        /*from("file:C:/Users/sagar.vitthal.sawant/OneDrive - Accenture/Desktop/New folder/inputFolder").
                split().tokenize("\n").to("jms:queue:firstQueue");*/

        //Content Based Router
        /*from("file:C:/Users/sagar.vitthal.sawant/OneDrive - Accenture/Desktop/New folder/inputFolder").
                split().tokenize("\n").to("direct:cbr");

        from("direct:cbr").
                choice().
                when(body().contains("oneQueue"))
                .to("jms:queue.oneQueue").
                when(body().contains("twoQueue"))
                .to("jms:queue.oneQueue").
                when(body().contains("threeQueue"))
                .to("jms:queue.oneQueue").
                otherwise().to("jms:queue.otherwise");*/

        // Recipient List Queue
        /*from("direct:recipient").process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
               String recipient = exchange.getIn().getBody().toString();
               String recipientQueue = "jms:queue"+recipient;
               exchange.getIn().setHeader("queue", recipientQueue);
            }
        }).recipientList(header("queue"));*/

        // Wiretap

    }
}
