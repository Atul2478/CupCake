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

@WebServlet(name = "Opret", urlPatterns = {"/opret"})
public class Opret extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        boolean loggedin = false;

        loggedin = (boolean) session.getAttribute("loggedin");

        if (loggedin == false) {

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User tempUser = null;

            tempUser = UserMapper.receiveUser(email);

            if (tempUser != null) {
                String message = "En bruger med den samme email eksisterer allerede, prøv igen.";
                request.setAttribute("failMessage", message);

                request.getRequestDispatcher("/opret.jsp").forward(request, response);

            } else {
                UserMapper.createUser(username, password, email);

                User currUser = null;

                currUser = UserMapper.receiveUser(email);

                SessionHandling.clearSession(request, response); // Clears session through iterating an enumeration.

                loggedin = true;

                session.setAttribute("user", currUser);
                session.setAttribute("user_id", currUser.getId());
                session.setAttribute("username", currUser.getUsername());
                session.setAttribute("email", currUser.getEmail());
                session.setAttribute("balance", currUser.getBalance());
                session.setAttribute("loggedin", loggedin);

                request.getRequestDispatcher("/user.jsp").forward(request, response);

            }

        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
