//演示404页面
package v2.servlet;

import v2.Request;
import v2.Response;
import v2.servlet.HTTPServlet;

import java.io.IOException;

public class NotFoundServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setStatus("404 Not Found");
        resp.println("<h1>亲，你的页面找不到啦</h1>");
    }
}
