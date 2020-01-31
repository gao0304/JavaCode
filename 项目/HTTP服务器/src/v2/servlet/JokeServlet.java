//演示首页浏览：http://127.0.0:1003/joke
package v2.servlet;
import v2.Response;
import v2.Request;

public class JokeServlet extends HTTPServlet{

    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.println("<h1>一点要记得我哦！</h1>");
    }
}
