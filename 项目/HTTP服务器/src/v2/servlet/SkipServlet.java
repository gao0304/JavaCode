package v2.servlet;
//演示网页弹窗:Http://127.0.0.1:1003/run 步骤一
import v2.Response;
import v2.Request;

public class SkipServlet extends HTTPServlet{

    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "application/javascript; charset=utf-8");
        resp.println("var s = '你好啊！这里的人都叫我赛丽亚';");
        resp.println("alert(s);");
    }
}
