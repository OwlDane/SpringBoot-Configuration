package belajar_spring_configuration.spring_configuration.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import lombok.Getter;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {
    
    @Autowired
    private TestApplication.ApplicationProperties properties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }

    @Test
    void testSystemProperties() {
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-23", systemProperties.getJavaHome());
    }

    @SpringBootApplication
    public static class TestApplication {

    @Component
    @Getter
    public static class SystemProperties {
        @Value("${JAVA_HOME}")
        private String javaHome;
    }

    @Component
    @Getter
    public static class ApplicationProperties {
        @Value("${spring.application.name}")
        private String name;

        @Value("${spring.application.version}")
        private Integer version;

        @Value("${spring.application.production-mode}")
        private boolean productionMode;
        }
    }
}
