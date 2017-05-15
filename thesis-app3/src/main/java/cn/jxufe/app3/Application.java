package cn.jxufe.app3;

import cn.jxufe.center.dubbo.Center;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource("dubbo.xml")
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        Center center = applicationContext.getBean(Center.class);
        LOGGER.info(String.valueOf("Apps: " + Arrays.toString(center.list().toArray())));
        LOGGER.info(String.valueOf(center.invoke("app1", "arg1")));
        LOGGER.info(String.valueOf(center.invoke("app2", "arg2")));
        LOGGER.info(String.valueOf(center.invoke("app3", "arg3")));
    }
}
