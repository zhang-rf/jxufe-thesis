package cn.jxufe.interfaces;

public interface Consumer {

    Object invoke(String provider, String service, Object... params);
}
