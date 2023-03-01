package dev.avi.AQI;
import java.util.List;
import java.util.Map;
    public class HttpResponse {

        private Map<String, List<String>> headers;
        private int responseCode;
        private String body;

        public HttpResponse(String body, Map<String, List<String>> headers, int responseCode) {
            this.body = body;
            this.headers = headers;
            this.responseCode = responseCode;
        }

        public Map<String, List<String>> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, List<String>> headers) {
            this.headers = headers;
        }

        public int getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

