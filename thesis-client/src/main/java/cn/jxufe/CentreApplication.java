package cn.jxufe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class CentreApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CentreApplication.class, args);
        applicationContext.getBean(cn.jxufe.interfaces.Consumer.class).invoke(null, null);
    }
}
