//演示用户登录：Http://127.0.0.1:1003/login?username=你的用户名

package v2.servlet;

import v2.Request;
import v2.Response;
import v2.SessionServer;
import v2.business.User;

import java.io.IOException;

public class LoginServlet extends HTTPServlet {
    @Override
    public void doGet(Request req, Response resp) throws IOException {
        String username=req.parameters.get("username");
        if(username==null){
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>请登录</h1>");
            return;
        }
        /*//种Cookie以及设置了过期时间:引入Session前的代码
        resp.setHeader("Set-Cookie","username="+username+";expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.println("<h1>欢迎"+username+"</h1>");*/
        User currentUser=User.findUser(username);
        if(currentUser==null){
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>该用户不存在</h1>");
            return;
        }
        String sessionId=SessionServer.put(currentUser);
        resp.setHeader("Set-Cookie","sessionId="+sessionId+";expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.println("<h1>欢迎"+username+"</h1>");
    }
}
