package api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    public class ImageServlet extends HttpServlet{
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setStatus(200);
            resp.setContentType("UTF-8");
            resp.getWriter().write("你好啊");
            //这个代码就是把hello这个字符串放到http响应的body中了
            /**
             * 当这里写完这个方法后，还无法直接运行，还需要修改项目路径下的webapp/WEB-INF/web.xml文件,
             * 这个文件是项目创建的时候自动生成的，然后把把新创建的Servlet注册进去
             *
             */
        }
    }
