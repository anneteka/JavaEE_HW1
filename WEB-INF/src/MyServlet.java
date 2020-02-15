import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n=request.getParameter("username");
        String p=request.getParameter("userpass");

        if(validate(n, p)){
            out.print("Welcome, "+n);
            out.println(getIndexHTML());
        }
        else{
            out.print("Incorrect username or password");
            out.println(getIndexHTML());
        }

        out.close();
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print(getIndexHTML());
        out.close();
    }

    private boolean validate(String n, String p) {
        return n.equals("admin") && p.equals("password");
    }

    private String getIndexHTML(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"MyServlet\" method=\"post\">\n" +
                "    Name:<input type=\"text\" name=\"username\"/><br/><br/>\n" +
                "    Password:<input type=\"password\" name=\"userpass\"/><br/><br/>\n" +
                "    <input type=\"submit\" value=\"login\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";
    }
}