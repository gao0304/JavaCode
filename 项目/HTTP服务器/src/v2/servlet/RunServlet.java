//演示网页弹窗:Http://127.0.0.1:1003/run 步骤二
package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class RunServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        resp.println("<script src='runjoke'></script>");
    }
}

