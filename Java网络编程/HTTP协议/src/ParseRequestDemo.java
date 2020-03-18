public class ParseRequestDemo {
    public static void main(String[] args) {
        StringBuilder request=new StringBuilder();
        request.append("Get / HTTP/1.1\r\n");
        request.append("Host:127.0.0.1\r\n");
        request.append("Accept: text/html\r\n");
        request.append("X-Teacher:peixinchen\r\n");
    }
}
