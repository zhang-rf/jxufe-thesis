package cn.jxufe.app2;

import cn.jxufe.center.dubbo.Center;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
@ImportResource("dubbo.xml")
public class Application {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        applicationContext.getBean(Center.class).register("app2");

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.newCondition().await();
    }
}
