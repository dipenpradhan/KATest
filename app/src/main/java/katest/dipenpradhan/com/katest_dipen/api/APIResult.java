package katest.dipenpradhan.com.katest_dipen.api;

/**
 * Created by dipenpradhan on 2/8/16.
 */
public class APIResult<T> {

    private int requestId;
    private int httpStatusCode;
    private T data;

    public enum FailureType{CONNECTION, PARSE, DATABASE}

    public APIResult(int requestId, int httpStatusCode, T data) {
        this.requestId = requestId;
        this.httpStatusCode = httpStatusCode;
        this.data = data;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
