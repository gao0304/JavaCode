//演示裸文本页面:Http://127.0.0.1:1003/plain
package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class PlainTextServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setHeader("Content-Type","text/plain;charset=utf-8");
        resp.println("<h1>我，就在这里等着你！</h1>");
    }
}
