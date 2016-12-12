package cn.jxufe;

import cn.jxufe.interfaces.Consumer;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class ConsumerProvider implements Consumer {

    @Override
    public Object invoke(String provider, String service, Object... params) {
        System.out.println("Helloooooooooooooooooo");
        return "Hello";
    }
}
