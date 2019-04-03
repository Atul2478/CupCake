package Backend;

import DataMapper.UserMapper;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Logud", urlPatterns = {"/logud"})
public class Logud extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

       Enumeration attributeNames = session.getAttributeNames();

        while (attributeNames.hasMoreElements()) {

            String param = attributeNames.nextElement().toString();

            session.removeAttribute(param);
        }
        request.getRequestDispatcher("/").forward(request, response);
    }
}
