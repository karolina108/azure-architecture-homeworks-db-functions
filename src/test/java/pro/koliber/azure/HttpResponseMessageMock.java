package pro.koliber.azure;

import com.microsoft.azure.functions.*;

import java.util.Map;

/**
 * The mock for HttpResponseMessage, can be used in unit tests to verify if the
 * returned response by HTTP trigger function is correct or not.
 */
public class HttpResponseMessageMock implements HttpResponseMessage {
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private Object body;
    private Map<String, String> headers;

    public HttpResponseMessageMock(HttpStatus status, Map<String, String> headers, Object body) {
        this.httpStatus = status;
        this.httpStatusCode = status.value();
        this.headers = headers;
        this.body = body;
    }

    @Override
    public HttpStatus getStatus() {
        return this.httpStatus;
    }

    public int getStatusCode() {
        return httpStatusCode;
    }

    @Override
    public String getHeader(String key) {
        return this.headers.get(key);
    }

    @Override
    public Object getBody() {
        return this.body;
    }

    public static class HttpResponseMessageBuilderMock implements HttpResponseMessage.Builder {
        private Object body;
        private int httpStatusCode;
        private Map<String, String> headers;
        private HttpStatus httpStatus;


        @Override
        public Builder status(HttpStatus httpStatus) {
            this.httpStatusCode = httpStatus.value();
            this.httpStatus = httpStatus;
            return this;
        }

        @Override
        public HttpResponseMessage.Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        @Override
        public HttpResponseMessage.Builder body(Object body) {
            this.body = body;
            return this;
        }

        @Override
        public HttpResponseMessage build() {
            return new HttpResponseMessageMock(this.httpStatus, this.headers, this.body);
        }
    }
}
