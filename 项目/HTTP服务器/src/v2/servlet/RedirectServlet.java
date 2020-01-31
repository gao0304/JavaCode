//演示307跳转:Http://127.0.0.1:1003/skip
package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class RedirectServlet extends HTTPServlet{
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.setStatus("307 Temporary Redirect");
        resp.setHeader("Location", "https://www.baidu.com/");
    }
}
