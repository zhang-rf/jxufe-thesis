package cn.jxufe.center.dubbo.impl;

import cn.jxufe.app.dubbo.App;
import cn.jxufe.app.dubbo.AppResponse;
import cn.jxufe.center.ApplicationContextUtil;
import cn.jxufe.center.dubbo.Center;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class CenterImpl implements Center {

    private Set<String> tagList = new CopyOnWriteArraySet<>();

    @Override
    public void register(String tag) {
        tagList.add(tag);
    }

    @Override
    public void unregister(String tag) {
        tagList.remove(tag);
    }

    @Override
    public List<String> list() {
        return new ArrayList<>(tagList);
    }

    @Override
    public Object invoke(String tag, Object... args) {
        AppResponse response;
        int retry = 0;
        do {
            retry++;
            response = ApplicationContextUtil.getContext().getBean(App.class).invoke(args);
        } while (!response.getTag().equals(tag) && retry < tagList.size());
        if (!response.getTag().equals(tag)) {
            unregister(tag);
            return new Exception(tag + " Unavailable");
        }
        return response.getResult();
    }
}
