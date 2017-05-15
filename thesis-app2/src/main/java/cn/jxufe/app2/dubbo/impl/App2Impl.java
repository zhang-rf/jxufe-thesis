package cn.jxufe.app2.dubbo.impl;

import cn.jxufe.app.dubbo.App;
import cn.jxufe.app.dubbo.AppResponse;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Arrays;

@Service
public class App2Impl implements App {

    @Override
    public AppResponse invoke(Object... args) {
        return new AppResponse("app2", "Hello from app2(" + Arrays.toString(args) + ")!");
    }
}
