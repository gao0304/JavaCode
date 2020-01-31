//引入一个接口，实现访问不同页面时的不同功能
package v2.servlet;

import v2.Request;
import v2.Response;

import java.io.IOException;

public abstract class HTTPServlet {
    public abstract void doGet(Request req, Response resp) throws IOException;
}
