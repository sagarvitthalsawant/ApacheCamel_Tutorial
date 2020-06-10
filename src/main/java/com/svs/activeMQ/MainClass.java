package com.svs.activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class MainClass {

    public static void main(String[] args) {
        SimpleRouteBuilder simpleRouteBuilder = new SimpleRouteBuilder();
        CamelContext camelContext = new DefaultCamelContext();

//        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

        connectionFactory.setBrokerURL("tcp://0.0.0.0:61616");
        connectionFactory.setUserName("admin");
        connectionFactory.setPassword("admin");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        try {
            camelContext.addRoutes(simpleRouteBuilder);
            camelContext.start();
            Thread.sleep(5*60*1000);
            camelContext.stop();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
