package cn.jxufe.app3;

import cn.jxufe.center.dubbo.Center;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("dubbo.xml")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        Center center = applicationContext.getBean(Center.class);
        LOGGER.info(String.valueOf(center.list().size()));
        LOGGER.info(String.valueOf(center.invoke("app1")));
        LOGGER.info(String.valueOf(center.invoke("app2")));
    }
}
