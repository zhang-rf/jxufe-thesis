package cn.jxufe.interfaces;

public interface Provider {

    Object invoke(String service, Object... params);
}
