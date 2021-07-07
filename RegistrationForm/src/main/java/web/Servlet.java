package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String technologies[] = request.getParameterValues("technology");
        String gender = request.getParameter("gender");
        String occupation = request.getParameter("occupation");
        String music[] = request.getParameterValues("music");
        String comments = request.getParameter("comments");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Servlet Result</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Servlet Parameters:</h1>");
        out.print("<table border='1'>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("User");
        out.print("</td>");
        out.print("<td>");
        out.print(user);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Technologies");
        out.print("</td>");
        out.print("<td>");
        for (String technology : technologies) {
            out.print(technology);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Gender");
        out.print("</td>");
        out.print("<td>");
        out.print(gender);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Occupation");
        out.print("</td>");
        out.print("<td>");
        out.print(occupation);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Favorite Music");
        out.print("</td>");
        out.print("<td>");
        if (music != null) {
            for (String m : music) {
                out.print(m);
                out.print(" / ");
            }
        }
        else{
            out.print("Value doesn't given");
        }
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Comments");
        out.print("</td>");
        out.print("<td>");
        out.print(comments);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
}
