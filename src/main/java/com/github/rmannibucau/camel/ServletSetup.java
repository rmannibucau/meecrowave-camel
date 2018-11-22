package com.github.rmannibucau.camel;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;

public class ServletSetup implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        final ServletRegistration.Dynamic servlet = ctx.addServlet("CamelServlet",
                CamelHttpTransportServlet.class);
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);
        // servlet.setInitParameter("async", "true");
        servlet.addMapping("/*");
    }
}
