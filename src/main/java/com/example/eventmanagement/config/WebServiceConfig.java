package com.example.eventmanagement.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "events")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema eventsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EventsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/events");
        wsdl11Definition.setSchema(eventsSchema);
        return wsdl11Definition;
    }

    @Bean(name = "attendees")
    public DefaultWsdl11Definition attendeesWsdl11Definition(XsdSchema attendeesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AttendeesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/attendees");
        wsdl11Definition.setSchema(attendeesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema attendeesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/AttendeeService.xsd"));
    }

    @Bean(name = "venues")
    public DefaultWsdl11Definition venuesWsdl11Definition(XsdSchema venuesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("VenuesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/venues");
        wsdl11Definition.setSchema(venuesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema venuesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/VenueService.xsd"));
    }

    @Bean(name = "payments")
    public DefaultWsdl11Definition paymentsWsdl11Definition(XsdSchema paymentsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PaymentsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/payments");
        wsdl11Definition.setSchema(paymentsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema paymentsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/PaymentService.xsd"));
    }

    @Bean(name = "utilities")
    public DefaultWsdl11Definition utilitiesWsdl11Definition(XsdSchema utilitiesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("UtilitiesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/utilities");
        wsdl11Definition.setSchema(utilitiesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema utilitiesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("wsdl/UtilityService.xsd"));
    }


}
