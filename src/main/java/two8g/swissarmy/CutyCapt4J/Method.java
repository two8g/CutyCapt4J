package two8g.swissarmy.CutyCapt4J;

/**
 * Created by two8g on 16-5-31.
 */
public enum Method {
    GET("get"), POST("post"), PUT("put");
    String method;

    private Method(String method) {
        setMethod(method);
    }

    public String getMethod() {
        return method;
    }

    private void setMethod(String method) {
        this.method = method;
    }
}
