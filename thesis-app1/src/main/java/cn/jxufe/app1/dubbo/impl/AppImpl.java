package cn.jxufe.app1.dubbo.impl;

import cn.jxufe.app.dubbo.App;
import cn.jxufe.app.dubbo.AppResponse;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Arrays;

@Service
public class AppImpl implements App {

    @Override
    public AppResponse invoke(Object... args) {
        return new AppResponse("app1", "Hello from app1(" + Arrays.toString(args) + ")!");
    }
}
