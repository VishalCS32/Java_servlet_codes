import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("<h1>Hello, World from Servlet!</h1>");
    }
}
