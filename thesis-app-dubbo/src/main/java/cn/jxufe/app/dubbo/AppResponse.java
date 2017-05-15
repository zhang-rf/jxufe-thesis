package cn.jxufe.app.dubbo;

public class AppResponse {

    private String tag;
    private Object result;

    public AppResponse() {
    }

    public AppResponse(String tag, Object result) {
        this.tag = tag;
        this.result = result;
    }

    public String getTag() {
        return tag;
    }

    public AppResponse setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public AppResponse setResult(Object result) {
        this.result = result;
        return this;
    }
}
