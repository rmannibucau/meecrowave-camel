package com.github.rmannibucau.camel;

import javax.enterprise.context.Dependent;

import org.apache.camel.builder.RouteBuilder;

@Dependent
public class ProxyDefinition extends RouteBuilder {
    @Override
    public void configure() {
        from("servlet://demo")
                .id("route_demo")
                .to("log:display")
                .setBody(constant("worked!"));
    }
}
