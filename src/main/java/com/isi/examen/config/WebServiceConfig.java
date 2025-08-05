package com.isi.examen.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "parametrage")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema parametrageSchema) {
        DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
        wsdlDefinition.setPortTypeName("ParametragePort");
        wsdlDefinition.setLocationUri("/ws");
        wsdlDefinition.setTargetNamespace("http://example.com/parametrage");
        wsdlDefinition.setSchema(parametrageSchema);
        return wsdlDefinition;
    }

    @Bean
    public XsdSchema parametrageSchema() {
        return new SimpleXsdSchema(new ClassPathResource("parametrage.xsd"));
    }
}
