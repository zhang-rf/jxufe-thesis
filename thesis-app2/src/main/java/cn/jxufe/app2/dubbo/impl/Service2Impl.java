package cn.jxufe.app2.dubbo.impl;

import cn.jxufe.app2.dubbo.Service2;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class Service2Impl implements Service2 {

    @Override
    public String invoke() {
        return "Hello from app2!";
    }
}
