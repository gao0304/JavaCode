package v1;

public class JokeJSServlet extends HTTPServlet{

    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "application/javascript; charset=utf-8");
        resp.println("alert('很好很好');");
    }
}

