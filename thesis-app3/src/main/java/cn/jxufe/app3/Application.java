package cn.jxufe.app3;

import cn.jxufe.app1.dubbo.Service1;
import cn.jxufe.app2.dubbo.Service2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        Service1 service1 = applicationContext.getBean(Service1.class);
        logger.info(service1.invoke());
        Service2 service2 = applicationContext.getBean(Service2.class);
        logger.info(service2.invoke());
    }
}