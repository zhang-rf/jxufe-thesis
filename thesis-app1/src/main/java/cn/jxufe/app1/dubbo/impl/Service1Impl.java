package cn.jxufe.app1.dubbo.impl;

import cn.jxufe.app1.dubbo.Service1;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class Service1Impl implements Service1 {

    @Override
    public String invoke() {
        return "Hello from app1!";
    }
}
