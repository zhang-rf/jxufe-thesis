package cn.jxufe.center.dubbo.impl;

import cn.jxufe.app.dubbo.App;
import cn.jxufe.app.dubbo.AppResponse;
import cn.jxufe.center.ApplicationContextUtil;
import cn.jxufe.center.dubbo.Center;
import com.alibaba.dubbo.config.annotation.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CenterImpl implements Center {

    private List<String> tagList = new CopyOnWriteArrayList<>();

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
        return Collections.unmodifiableList(tagList);
    }

    @Override
    public Object invoke(String tag, Object... args) {
        AppResponse response;
        do {
            response = ApplicationContextUtil.getContext().getBean(App.class).invoke(args);
        } while (!response.getTag().equals(tag));
        return response.getResult();
    }
}
