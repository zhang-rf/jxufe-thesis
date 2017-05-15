package cn.jxufe.center.dubbo;

import java.util.List;

public interface Center {

    void register(String tag);

    void unregister(String tag);

    List<String> list();

    Object invoke(String tag, Object... args);
}
