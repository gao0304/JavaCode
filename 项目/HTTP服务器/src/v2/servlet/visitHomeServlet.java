//验证cookie，session,以及访问首页:Http://127.0.0.1:1003/visit?target=xxx
package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public class visitHomeServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String currentUser="未登录";
        String cookie=req.headers.get("Cookie");
        if(cookie!=null){
            currentUser=cookie.split("=")[1];
        }
        resp.setHeader("Content-Type","text/plain;charset=UTF-8");
        resp.setHeader("X-Teacher","gaofeng");
        resp.setHeader("X-Room","201");
        resp.println("你好"+req.parameters.get("target"));//target是后边的路径部分
        resp.print("它的用户编号是"+currentUser);
    }
}
