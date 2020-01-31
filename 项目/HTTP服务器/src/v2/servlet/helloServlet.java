//验证session,以及查看个人信息:Http://127.0.0.1:1003/hello
package v2.servlet;

import v2.Request;
import v2.Response;
import v2.SessionServer;
import v2.business.User;

import java.io.IOException;

public class helloServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String sessionId=null;
        //String currentUser="未登录";  //引入Session前的代码
        String cookie=req.headers.get("Cookie");
        if(cookie!=null){
            //currentUser=cookie.split("=")[1]; //引入Session前的代码
            sessionId=cookie.split("=")[1];
        }
        User user=SessionServer.get(sessionId);
        resp.setHeader("Content-Type","text/plain;charset=UTF-8");
        //引入Session前的代码
        /* resp.setHeader("X-Teacher","gaofeng");
        resp.setHeader("X-Room","201");
        resp.println("你好"+req.parameters.get("target"));//target是后边的路径部分
        resp.print("当前用户"+currentUser);*/
        resp.println("当前用户是 " + user.username);
        resp.println("账户余额是 " + user.balance);
    }
}
