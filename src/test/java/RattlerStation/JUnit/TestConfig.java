package RattlerStation.JUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
        "file:src/main/webapp/WEB-INF/web.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc-servlet.xml"
})
public class TestConfig {
    /* web.xml and spring-mvc-servlet.xml config */
}
